import { Component, OnInit } from '@angular/core';
import { TcOrderService } from 'src/app/service/tc-order.service';
import { StorageService } from 'src/app/service/storage.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TcOrder } from 'src/app/model/tc-order';
import { TcClient } from 'src/app/model/tc-client';
import { TcProduct } from 'src/app/model/tc-product';
import { TcDetail } from 'src/app/model/tc-detail';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-tc-order',
  templateUrl: './tc-order.component.html',
  styleUrls: ['./tc-order.component.css']
})
export class TcOrderComponent implements OnInit {
  private tcOrder: TcOrder[];
  private tcClient: TcClient;
  private route: ActivatedRoute;
  private router: Router;
  private tcOrderService: TcOrderService;
  private storageService: StorageService;
  private toastr: ToastrService;
  private response: any;
  data: any;

  constructor(
    route: ActivatedRoute,
    router: Router,
    storageService: StorageService,
    toastr: ToastrService,
    tcOrderService: TcOrderService
  ) {
    this.route = route;
    this.router = router;
    this.storageService = storageService;
    this.toastr = toastr;
    this.tcOrderService = tcOrderService;
   }

  ngOnInit() {
    this.getOrdenes();
  }

  getOrdenes() {
    this.tcOrderService.getOrderList().subscribe(
      Response => {
        this.response = Response;
        if (this.response.status === 'OK') {
          this.data = this.response.data;
          this.toastr.success(this.response.message);
        } else {
          this.toastr.error(this.response.message);
        }
    },
    error => {
      this.toastr.error('Status: ' + error.error.status + ' Error: ' + error.error.error + ' Message: ' + error.error.message);
    });
  }
}
