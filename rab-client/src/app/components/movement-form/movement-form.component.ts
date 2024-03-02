import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HomeService } from 'src/app/service/home.service';
import { Router } from '@angular/router';
import { Farm } from 'src/app/model/Farm';

@Component({
  selector: 'rab-movement-form',
  templateUrl: './movement-form.component.html',
  styleUrls: ['./movement-form.component.css']
})
export class MovementFormComponent {

  fb = inject(FormBuilder);
  homeService = inject(HomeService);
  router = inject(Router)
  farmList :Farm[] = [];
  destinationFarmList :Farm[] = [];
  originFarmList :Farm[] = [];

  form = this.fb.nonNullable.group({
    originFarmId: ['', Validators.required],
    destinationFarmId: ['', Validators.required],
    company: ['', Validators.required],
    reason: ['', Validators.required],
    species: ['', Validators.required],
    itemsMoved: ['', Validators.required],
    movementDate: ['', Validators.required],
  });

  onOriginChange(selectedOriginId: string) {
    this.destinationFarmList = this.farmList.filter(farm => farm.id !== selectedOriginId);
  }

  onDestinationChange(selectedDestinationId: string) {
    this.originFarmList = this.farmList.filter(farm => farm.id !== selectedDestinationId);
  }

  onSubmit(){
    this.homeService.addMovementData(this.form.getRawValue()).subscribe((response : any) => {
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
        this.router.navigate(['/home']));
    });
  }
  ngOnInit(): void {
    this.homeService.getFarmData().subscribe(data => {
      this.farmList = data;
      this.destinationFarmList = data;
      this.originFarmList = data;
      this.router.navigateByUrl('/home');
    });
  }
}
