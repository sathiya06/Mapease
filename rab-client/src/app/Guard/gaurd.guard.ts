import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

export const gaurdGuard: CanActivateFn = (route, state) => {

  const currentTab = (route.url[0]) ? route.url[0].path : '';
  const router = inject(Router);
  const isLoggedIn = inject(AuthService).authenticate();

  if (currentTab == '' || currentTab == 'home'){
    if (isLoggedIn){
      return true;
    } else {
      router.navigateByUrl('login');
    }
  } else {
    if (isLoggedIn){
      router.navigateByUrl('home');
    } else {
      return true;
    }
  }

  return true;
};
