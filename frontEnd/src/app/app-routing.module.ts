import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthorizatedGuard } from './guard/authorizated.guard';
import { TcProviderComponent } from './catalog/tc-provider/tc-provider.component';
import { TcProviderAddComponent } from './catalog/tc-provider-add/tc-provider-add.component';
import { TcOrderComponent } from './catalog/tc-order/tc-order.component';
import { TcOrderAddComponent } from './catalog/tc-order-add/tc-order-add.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent, canActivate: [ AuthorizatedGuard ]},
  { path: 'provider', component: TcProviderComponent, canActivate: [ AuthorizatedGuard ]},
  { path: 'provider/add', component: TcProviderAddComponent, canActivate: [ AuthorizatedGuard ]},
  { path: 'provider/:providerId/edit', component: TcProviderAddComponent, canActivate: [ AuthorizatedGuard ]},
  { path: 'order', component: TcOrderComponent, canActivate: [ AuthorizatedGuard ]},
  { path: 'crear-orden', component: TcOrderAddComponent, canActivate: [ AuthorizatedGuard ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
