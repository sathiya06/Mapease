import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'rab-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  hide = true;
  fb = inject(FormBuilder);
  http = inject(HttpClient);
  router = inject(Router);

  form = this.fb.nonNullable.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
  });

  onSubmit(): void {
    this.http.post('http://localhost:8080/auth/login',  this.form.getRawValue()).subscribe((response : any) => {
      localStorage.setItem('token', response.token);
      this.router.navigateByUrl('/home');
    });
  }

}
