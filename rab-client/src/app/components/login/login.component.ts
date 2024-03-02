import { Component, inject } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';

import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'rab-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  hide = true;
  fb = inject(FormBuilder);
  authService = inject(AuthService);
  router = inject(Router);


  form = this.fb.nonNullable.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
  });

  onSubmit(): void {
    this.authService.login(this.form.getRawValue()).pipe(
      catchError(async (error) => {console.log(error.error, 'X')})
    ).subscribe((response : any) => {
      console.log(response);
      localStorage.setItem('rab-token', response.token);
      localStorage.setItem('rab-role', response.role);
      this.router.navigateByUrl('/home');
    })
  }

}
