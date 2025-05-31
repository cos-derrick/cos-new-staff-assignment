import { NgModule } from '@angular/core';
import { SharedModule } from '@shared';
import {AuthRoutingModule} from "./auth-routing.module";
import {LoginComponent} from "./login/login.component";

const COMPONENTS = [LoginComponent];

@NgModule({
    imports: [
        SharedModule,
        AuthRoutingModule
    ],
    declarations: [...COMPONENTS]
})
export class AuthModule {}
