import { Component } from '@angular/core';
import { HomeService } from 'src/app/service/home.service';

export interface Farm {
  id: string;
  name: string;
  address: string;
  city: string;
  state: string;
  postalCode: string;
}


@Component({
  selector: 'rab-farm',
  templateUrl: './farm.component.html',
  styleUrls: ['./farm.component.css']
})
export class FarmComponent {

  constructor(private homeService: HomeService) {

  }

  displayedColumns: string[] = ['id', 'name', 'address', 'city', 'state', 'postalCode'];
  dataSource :Farm[] = [];

  ngOnInit(): void {
    this.homeService.getFarmData().subscribe(data => {
      this.dataSource = data;
    });
  }
}
