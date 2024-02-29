import { Component, inject } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'rab-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  hide = true;
  fb = inject(FormBuilder);
  authService = inject(AuthService);

  form = this.fb.nonNullable.group({
    name: ['', Validators.required],
    email: ['', Validators.required],
    password: ['', Validators.required],
  });

  onSubmit(): void {
    
    this.authService.signup(this.form.getRawValue());

  }
}
