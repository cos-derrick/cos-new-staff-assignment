import {
    HttpErrorResponse,
    HttpEvent,
    HttpHandler,
    HttpHeaders,
    HttpInterceptor,
    HttpRequest,
    HttpResponseBase
} from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { ALAIN_I18N_TOKEN } from '@delon/theme';
import { environment } from '@env/environment';
import { Observable, of, throwError } from 'rxjs';
import { catchError, mergeMap } from 'rxjs/operators';

@Injectable()
export class DefaultInterceptor implements HttpInterceptor {
    constructor(private injector: Injector) {}

    // #endregion

    private handleData(ev: HttpResponseBase, req: HttpRequest<any>, next: HttpHandler): Observable<any> {
        switch (ev.status) {
            case 200:
                break;
            case 401:
            case 403:
            case 404:
            case 500:
                // this.goTo(`/exception/${ev.status}?url=${req.urlWithParams}`);
                break;
            default:
                if (ev instanceof HttpErrorResponse) {
                    console.warn(
                        'Unknown errors are mostly caused by the backend not supporting cross-domain CORS or invalid configuration. Please refer to https://ng-alain.com/docs/server to solve cross-domain problems',
                        ev
                    );
                }
                break;
        }
        if (ev instanceof HttpErrorResponse) {
            return throwError(ev);
        } else {
            return of(ev);
        }
    }

    private getAdditionalHeaders(headers?: HttpHeaders): { [name: string]: string } {
        const res: { [name: string]: string } = {};
        const lang = this.injector.get(ALAIN_I18N_TOKEN).currentLang;
        if (!headers?.has('Accept-Language') && lang) {
            res['Accept-Language'] = lang;
        }

        return res;
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let url = req.url;
        if (!url.startsWith('https://') && !url.startsWith('http://') && !url.startsWith('assets/tmp/') ) {
            const { baseUrl } = environment.api;
            url = baseUrl + (baseUrl.endsWith('/') && url.startsWith('/') ? url.substring(1) : url);
        }

        const newReq = req.clone({ url, setHeaders: this.getAdditionalHeaders(req.headers) });
        return next.handle(newReq).pipe(
            mergeMap(ev => {
                if (ev instanceof HttpResponseBase) {
                    return this.handleData(ev, newReq, next);
                }
                return of(ev);
            }),
            catchError((err: HttpErrorResponse) => this.handleData(err, newReq, next))
        );
    }
}
