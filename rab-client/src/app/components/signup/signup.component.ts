import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'rab-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  hide = true;
  fb = inject(FormBuilder);
  http = inject(HttpClient);
  router = inject(Router);

  form = this.fb.nonNullable.group({
    name: ['', Validators.required],
    email: ['', Validators.required],
    password: ['', Validators.required],
  });

  onSubmit(): void {
    console.log(this.form.getRawValue());
    this.http.post('http://localhost:8080/auth/signup', this.form.getRawValue()).subscribe((response : any) => {
      localStorage.setItem('token', response.token);
      this.router.navigateByUrl('/home');
    });
  }
}
