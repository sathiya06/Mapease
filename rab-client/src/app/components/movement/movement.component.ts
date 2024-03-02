import { Component, ViewChild, inject } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Movement } from 'src/app/model/Movement';
import { HomeService } from 'src/app/service/home.service';

@Component({
  selector: 'rab-movement',
  templateUrl: './movement.component.html',
  styleUrls: ['./movement.component.css']
})
export class MovementComponent {

  homeService = inject(HomeService);

  displayedColumns: string[] = ['id', 'company', 'reason', 'from', 'to', 'species', 'itemsMoved', 'date'];
  dataSource :any;

  @ViewChild (MatPaginator) paginator !: MatPaginator;
  @ViewChild (MatSort) sort !: MatSort;

  filterChange(event : Event){
    const val = (event.target as HTMLInputElement).value;
    this.dataSource.filter = val;
  }

  ngOnInit(): void {
    this.homeService.getMovementData().subscribe(data => {
      this.dataSource = new MatTableDataSource<Movement>(data);;
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

}
