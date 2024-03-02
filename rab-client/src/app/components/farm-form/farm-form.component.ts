import { Component, inject } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/service/home.service';

@Component({
  selector: 'rab-farm-form',
  templateUrl: './farm-form.component.html',
  styleUrls: ['./farm-form.component.css']
})
export class FarmFormComponent {

  fb = inject(FormBuilder);
  homeService = inject(HomeService);
  router = inject(Router)

  form = this.fb.nonNullable.group({
    id: ['', Validators.required],
    name: ['', Validators.required],
    address: ['', Validators.required],
    city: ['', Validators.required],
    state: ['', Validators.required],
    postalCode: ['', Validators.required],
    latitude: ['', Validators.required],
    longitude: ['', Validators.required],
    totalAnimals: ['', Validators.required],
  });

  onSubmit() {
    this.homeService.addFarmData(this.form.getRawValue()).subscribe((response : any) => {
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
        this.router.navigate(['/home']));
    });
  }

  constructor() {
  }
}
