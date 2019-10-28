import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { NgSelectModule } from '@ng-select/ng-select';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthorizatedGuard } from './guard/authorizated.guard';
import { StorageService } from './service/storage.service';
import { DatePipe } from '@angular/common';
import { AuthInterceptorService } from './service/auth-interceptor.service';
import { TcProviderComponent } from './catalog/tc-provider/tc-provider.component';
import { TcProviderAddComponent } from './catalog/tc-provider-add/tc-provider-add.component';
import { TcClientComponent } from './catalog/tc-client/tc-client.component';
import { TcProductComponent } from './catalog/tc-product/tc-product.component';
import { TcOrderComponent } from './catalog/tc-order/tc-order.component';
import { TcDetailComponent } from './catalog/tc-detail/tc-detail.component';
import { TcOrderAddComponent } from './catalog/tc-order-add/tc-order-add.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    TcProviderComponent,
    TcProviderAddComponent,
    TcClientComponent,
    TcProductComponent,
    TcOrderComponent,
    TcDetailComponent,
    TcOrderAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    ToastrModule.forRoot({
      timeOut: 3000,
      positionClass: 'toast-top-right'
    }),
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgSelectModule
  ],
  providers: [
    AuthorizatedGuard,
    StorageService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi : true
    },
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
