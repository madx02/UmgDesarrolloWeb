import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TcOrder } from '../model/tc-order';
import { TcDetail } from '../model/tc-detail';
import { Config } from './config';

@Injectable({
  providedIn: 'root'
})
export class TcOrderService {

  formData: TcOrder;
  orderItems: TcDetail[];
  private url: string;
  private http: HttpClient;

  constructor(
    http: HttpClient
  ) {
    this.http = http;
    this.url = Config.apiUrl;
  }

  saveOrUpdateOrder() {
    // tslint:disable-next-line:prefer-const
    let body = {
      ...this.formData,
      OrderItems: this.orderItems
    };
    return this.http.post(this.url + '/Order', body);
  }

  // Http Headers
  // tslint:disable-next-line:member-ordering
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  add(data: TcOrder) {
    console.log(JSON.stringify(data));
    return this.http.post(this.url + 'order/add', JSON.stringify(data), this.httpOptions);
  }

  getOrderList() {
    return this.http.get(this.url + 'order/all');
  }

  getClients() {
    return this.http.get(this.url + 'client/all');
  }

  getProducts() {
    return this.http.get(this.url + 'product/all');
  }

  getOrderByID(id: number)  {
    return this.http.get(this.url + + '/Order/' + id).toPromise();
  }

  deleteOrder(id: number) {
    return this.http.delete(this.url + + '/Order/' + id).toPromise();
  }
}
