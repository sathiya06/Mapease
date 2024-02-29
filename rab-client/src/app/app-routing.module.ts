import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { gaurdGuard } from './Guard/gaurd.guard';

const routes: Routes = [
  { path: '', title: 'home', component: LoginComponent, canActivate: [gaurdGuard] },
  { path: 'login', title: 'login', component: LoginComponent, canActivate: [gaurdGuard] },
  { path: 'signup', title: 'signup', component: SignupComponent, canActivate: [gaurdGuard] },
  { path: 'home', title: 'home', component: HomeComponent, canActivate: [gaurdGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
