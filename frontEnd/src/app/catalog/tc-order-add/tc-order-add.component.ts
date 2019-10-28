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
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-tc-order-add',
  templateUrl: './tc-order-add.component.html',
  styleUrls: ['./tc-order-add.component.css'],
  providers: [
    TcOrderService
  ]
})
export class TcOrderAddComponent implements OnInit {

  private tcClients: TcClient[];
  private tcProducts: TcProduct[];
  private route: ActivatedRoute;
  private router: Router;
  private tcOrderService: TcOrderService;
  private storageService: StorageService;
  private toastr: ToastrService;
  private formBuilder: FormBuilder;
  public mostrarDetalle: boolean;
  private response: any;
  data: any;
  tcDetails: TcDetail[] = [];
  tcDetail: TcDetail;
  tcOrder: TcOrder;
  totalOrder: number;
  formClient: FormGroup;


  constructor(
    route: ActivatedRoute,
    router: Router,
    storageService: StorageService,
    toastr: ToastrService,
    tcOrderService: TcOrderService,
    formBuilder: FormBuilder
  ) {
    this.route = route;
    this.router = router;
    this.storageService = storageService;
    this.toastr = toastr;
    this.tcOrderService = tcOrderService;
    this.formBuilder = formBuilder;
    this.totalOrder = 0;
  }

  ngOnInit() {
    this.mostrarDetalle = false;
    this.getClients();
    this.getProducts();
    this.formClient = this.formBuilder.group({
      orderId: null,
      tcClient: [null, [Validators.required]],
      tcProduct: [null, [Validators.required]],
      cantidad: [null, [Validators.required]]
    });
  }

  getClients() {
    this.tcOrderService.getClients().subscribe(
      Response => {
        this.response = Response;
        if (this.response.status === 'OK') {
          this.data = this.response.data;
          this.tcClients = this.data;
          this.toastr.success(this.response.message);
        } else {
          this.toastr.error(this.response.message);
        }
    },
    error => {
      this.toastr.error('Status: ' + error.error.status + ' Error: ' + error.error.error + ' Message: ' + error.error.message);
    });
  }

  getProducts() {
    this.tcOrderService.getProducts().subscribe(
      Response => {
        this.response = Response;
        if (this.response.status === 'OK') {
          this.data = this.response.data;
          this.tcProducts = this.data;
          this.toastr.success(this.response.message);
        } else {
          this.toastr.error(this.response.message);
        }
    },
    error => {
      this.toastr.error('Status: ' + error.error.status + ' Error: ' + error.error.error + ' Message: ' + error.error.message);
    });
  }

  onSubmit() {
    this.addDetail();
    if (!this.mostrarDetalle) {
      // tslint:disable-next-line:prefer-const
      let rows: number = this.tcDetails.length;
      // tslint:disable-next-line:curly
      if (rows > 0)
         this.mostrarDetalle = true;
    }
  }

  addDetail() {
    this.tcDetail = new TcDetail();
    this.tcDetail.cantidad = this.formClient.value.cantidad;
    this.tcDetail.costUnit = this.formClient.value.tcProduct.costUnit;
    this.tcDetail.priceUnit = this.formClient.value.tcProduct.priceUnit;
    this.tcDetail.tcProduct = this.formClient.value.tcProduct;
    this.tcDetail.total = (this.formClient.value.cantidad * this.formClient.value.tcProduct.priceUnit);
    this.totalOrder =  this.totalOrder + this.tcDetail.total;
    this.tcDetails.push(this.tcDetail);
  }


  changeSelectedClient(event: any) {
    console.log(event);
    console.log(this.formClient.value.tcClient);
  }

  changeSelectedProduct(event: any) {
    console.log(event);
    console.log(this.formClient.value.tcProduct);
  }

  saveOrder() {
    console.log('Evento de guardar');
    this.tcOrder = new TcOrder();

    this.tcOrder.tcClient = this.formClient.value.tcClient;
    this.tcOrder.tcDetail = this.tcDetails;
    this.tcOrderService.add(this.tcOrder).subscribe(
      result => {
        this.response = result;
        if (this.response.status === 'OK') {
          // tslint:disable-next-line:prefer-const
          let tcOrder = this.response.data[0];
          this.formClient.get('orderId').setValue(tcOrder.orderId);
          this.router.navigate(['/home']);
          } else {
            this.toastr.error(this.response.message);
          }
      }, error => {
        this.toastr.error('Status: ' + error.error.status + ' Error: ' + error.error.error + ' Message: ' + error.error.message);
      }
    );
  }

}
