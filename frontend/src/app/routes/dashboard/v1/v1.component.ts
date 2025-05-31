import { Platform } from '@angular/cdk/platform';
import { DOCUMENT } from '@angular/common';
import { ChangeDetectionStrategy, Component, Inject, OnInit } from '@angular/core';
import { NzSafeAny } from 'ng-zorro-antd/core/types';
import {HealthCheckRestService} from "../../../shared/services/rest/health-check.rest.service";

@Component({
  selector: 'app-dashboard-v1',
  templateUrl: './v1.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DashboardV1Component implements OnInit {


  constructor(
    private platform: Platform,
    @Inject(DOCUMENT) private doc: NzSafeAny,
    private healthCheckRestService: HealthCheckRestService,
  ) {
  }

  ngOnInit(): void {
    this.healthCheckRestService.healthCheck().subscribe(res => console.log(res));
  }
}
