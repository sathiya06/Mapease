import { Component } from '@angular/core';
import * as L from 'leaflet';


@Component({
  selector: 'rab-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent  {

  private map:any;
  private centroid: L.LatLngExpression = [39.8282, -98.5795]; 

  private initMap(): void {
    this.map = L.map('map', {
      center: this.centroid,
      zoom: 3
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    

    tiles.addTo(this.map);
  
  }

  constructor() { }

  ngOnInit(): void {
    this.initMap();
  }
}
