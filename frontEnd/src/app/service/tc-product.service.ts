import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Config } from './config';


@Injectable({
  providedIn: 'root'
})
export class TcProductService {

  private url: string;
  private http: HttpClient;

  constructor(
    http: HttpClient
  ) {
    this.http = http;
    this.url = Config.apiUrl;
  }

  getProductList() {
    return this.http.get(this.url + '/Customer').toPromise();
   }
}
