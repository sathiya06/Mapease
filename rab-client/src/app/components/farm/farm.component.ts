import { Component, ViewChild, inject } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Farm } from 'src/app/model/Farm';
import { HomeService } from 'src/app/service/home.service';


@Component({
  selector: 'rab-farm',
  templateUrl: './farm.component.html',
  styleUrls: ['./farm.component.css']
})

export class FarmComponent {

  fb = inject(FormBuilder);
  homeService = inject(HomeService);

  displayedColumns: string[] = ['id', 'name', 'address', 'city', 'state', 'postalCode', 'total_animals'];
  dataSource :any;

  @ViewChild (MatPaginator) paginator !: MatPaginator;
  @ViewChild (MatSort) sort !: MatSort;

  deleteFarm(farmId: any){
    console.log("component");
    this.homeService.deleteFarmById(this.fb.nonNullable.group({
      id: [farmId]}).getRawValue());
    this.ngOnInit();
  }

  filterChange(event : Event){
    const val = (event.target as HTMLInputElement).value;
    this.dataSource.filter = val;
  }

  ngOnInit(): void {
    this.homeService.getFarmData().subscribe(data => {
      this.dataSource = new MatTableDataSource<Farm>(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }
}
