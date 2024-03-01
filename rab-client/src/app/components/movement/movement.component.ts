import { Component } from '@angular/core';
import { HomeService } from 'src/app/service/home.service';

export interface Farm {
  id: string;
  company: string;
  reason: string;
  From: string;
  to: string;
  Species: string;
  itemsMoved: string;
  date: string;
}

@Component({
  selector: 'rab-movement',
  templateUrl: './movement.component.html',
  styleUrls: ['./movement.component.css']
})
export class MovementComponent {

  constructor(private homeService: HomeService) {
  }

  displayedColumns: string[] = ['id', 'company', 'reason', 'from', 'to', 'species', 'itemsMoved', 'date'];
  dataSource :Farm[] = [];

  ngOnInit(): void {
    this.homeService.getMovementData().subscribe(data => {
      this.dataSource = data;
    });
  }

}
