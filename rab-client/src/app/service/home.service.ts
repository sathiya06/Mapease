import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Farm } from 'src/app/model/Farm';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class HomeService {

  http = inject(HttpClient);

  getFarmData(): Observable<any> {
    return this.http.get<Farm[]>('http://localhost:8080/farm');
  }

  deleteFarmById(farmId: any) {
    console.log(farmId);
    return this.http.delete('http://localhost:8080/farm', farmId).subscribe({
      next: (response) => {
          console.log(response);
      },
      error: (error) => {
          console.error(error);
      }
  });;
  }

  addFarmData(data: any) {
    return this.http.post('http://localhost:8080/farm', data);
  }

  addMovementData(data: any) {
    return this.http.post('http://localhost:8080/movement', data);
  }

  getMovementData(): Observable<any> {
    return this.http.get<Farm[]>('http://localhost:8080/movement');
  }

  constructor() { }
}
