import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  router = inject(Router);
  http = inject(HttpClient);

  login(data: object){
    return this.http.post('http://localhost:8080/auth/login', data);
  }

  signup(data: object){
    this.http.post('http://localhost:8080/auth/signup', data).pipe(
      catchError(async (error) => {return error.error})
    ).subscribe((response : any) => {
      localStorage.setItem('rab-token', response.token);
      localStorage.setItem('rab-role', response.role);
      this.router.navigateByUrl('/home');
    });
  }

  authenticate(){
    return localStorage.getItem("rab-token");
  }

  constructor() { }
}
