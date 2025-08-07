import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service'; 

@Component({
  selector: 'app-inicio',
  standalone: true,
  templateUrl: './inicio.html',
  styleUrl: './inicio.css'
})
export class InicioComponent {
  constructor(
    private router: Router,
    private authService: AuthService
  ) {}

  redirigirReserva() {
    if (this.authService.isAuthenticated()) {
      this.router.navigate(['/reservar-cancha']);
    } else {
      this.router.navigate(['/login']);
    }
  }
}
