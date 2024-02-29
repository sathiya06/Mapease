import { Component, inject } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';

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

  form = this.fb.nonNullable.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
  });

  onSubmit(): void {
    this.authService.login(this.form.getRawValue());
  }

}
