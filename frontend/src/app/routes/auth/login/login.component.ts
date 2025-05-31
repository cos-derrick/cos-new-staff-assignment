import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Inject, OnDestroy, Optional } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StartupService } from '@core';
import { ReuseTabService } from '@delon/abc/reuse-tab';
import { DA_SERVICE_TOKEN, ITokenService, SocialService } from '@delon/auth';
import { SettingsService, _HttpClient } from '@delon/theme';

@Component({
    selector: 'passport-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.less'],
    providers: [SocialService],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class LoginComponent implements OnDestroy {
    constructor(
        fb: FormBuilder,
        private router: Router,
        private settingsService: SettingsService,
        private socialService: SocialService,
        @Optional()
        @Inject(ReuseTabService)
        private reuseTabService: ReuseTabService,
        @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
        private startupSrv: StartupService,
        private http: _HttpClient,
        private cdr: ChangeDetectorRef
    ) {
        this.form = fb.group({
            userName: [null, [Validators.required]],
            password: [null, [Validators.required]],
            remember: [true]
        });
    }

    // #region fields

    get userName(): AbstractControl {
        return this.form.get('userName')!;
    }
    get password(): AbstractControl {
        return this.form.get('password')!;
    }
    form: FormGroup;
    error = '';
    type = 0;
    loading = false;

    // #region get captcha

    count = 0;
    interval$: any;

    // #endregion

    // #endregion

    submit(): void {
        this.error = '';
        if (this.type === 0) {
            this.userName.markAsDirty();
            this.userName.updateValueAndValidity();
            this.password.markAsDirty();
            this.password.updateValueAndValidity();
            if (this.userName.invalid || this.password.invalid) {
                return;
            }
        }

        this.loading = true;
        this.cdr.detectChanges();
        this.tokenService.set({
            token: '123456789',
            id: 10000,
            time: +new Date(),
        });
        this.startupSrv.load().subscribe(() => {
            let url = this.tokenService.referrer!.url || '/';
            if (url.includes('/auth')) {
                url = '/';
            }
            this.router.navigateByUrl(url);
        });
    }

    // #region social

    // #endregion

    ngOnDestroy(): void {
        if (this.interval$) {
            clearInterval(this.interval$);
        }
    }
}
