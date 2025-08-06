import { Routes } from '@angular/router';
import { ConsultarReservasComponent } from './pages/consultar-reservas/consultar-reservas.component';
import { ConsultarReservaIdComponent } from './pages/consultar-reservas-id/consultar-reservas-id.component';
import { CancelarReservaComponent } from './pages/cancelar-reservas/cancelar-reservas.component';
import { ReservarCanchaComponent } from './pages/reservar-cancha/reservar-cancha.component';

export const routes: Routes = [
  { path: '', redirectTo: 'consultar-reservas', pathMatch: 'full' },
  { path: 'consultar-reservas', component: ConsultarReservasComponent },
  { path: 'consultar-reserva-id', component: ConsultarReservaIdComponent },
  { path: 'cancelar-reserva', component: CancelarReservaComponent },
  { path: 'reservar-cancha', component: ReservarCanchaComponent }
];
