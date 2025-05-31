import {AbstractRestService} from "./abstract.rest.service";
import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class HealthCheckRestService extends AbstractRestService {
    getBasePath(): string {
        return 'health';
    }

    healthCheck() {
        return this.get('/check');
    }
}
