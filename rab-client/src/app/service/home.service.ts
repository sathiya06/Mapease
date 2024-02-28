import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Farm } from '../components/farm/farm.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class HomeService {

  http = inject(HttpClient);

  getFarmData(): Observable<any> {
    return this.http.get<Farm[]>('http://localhost:8080/farm');
  }

  getMovementData(): Observable<any> {
    return this.http.get<Farm[]>('http://localhost:8080/movement');
  }

  constructor() { }
}
