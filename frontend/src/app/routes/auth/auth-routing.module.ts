import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LayoutBlankComponent} from "../../layout/blank/blank.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
    {
        path: '',
        component: LayoutBlankComponent,
        children: [
            {
                path: '',
                component: LoginComponent
            }
        ]
    }
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AuthRoutingModule {}
