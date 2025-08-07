import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';


export const JwtInterceptor: HttpInterceptorFn = (req, next) => {
	console.log('Interceptor instanciado y ejecutado');

  const authService = inject(AuthService);
  const token = authService.getToken();


  if (token) {
    const cloned = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${token}`)
    });
    return next(cloned);
  }

  return next(req);
};
