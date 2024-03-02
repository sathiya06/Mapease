import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'rab-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  router = inject(Router);
  isSidenavOpen = true;
  isAdmin = localStorage.getItem("rab-role") == "0";
  page = 1;
  setPage(n:any){
    this.page = n;
  }
  logout(){
    localStorage.removeItem("rab-token");
    localStorage.removeItem("rab-role");
    this.router.navigateByUrl("/login");
  }
}
