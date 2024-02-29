import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  router = inject(Router);
  http = inject(HttpClient);

  login(data: object){
    this.http.post('http://localhost:8080/auth/login', data).subscribe((response : any) => {
      localStorage.setItem('token', response.token);
      this.router.navigateByUrl('/home');
    });
  }

  signup(data: object){
    this.http.post('http://localhost:8080/auth/signup', data).subscribe((response : any) => {
      localStorage.setItem('token', response.token);
      this.router.navigateByUrl('/home');
    });
  }

  authenticate(){
    return localStorage.getItem("token");
  }

  constructor() { }
}
