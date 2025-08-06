import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultarReservasComponent } from './pages/consultar-reservas/consultar-reservas.component';
import { ConsultarReservaIdComponent } from './pages/consultar-reserva-id/consultar-reserva-id.component';
import { CancelarReservaComponent } from './pages/cancelar-reserva/cancelar-reserva.component';
import { ReservarCanchaComponent } from './pages/reservar-cancha/reservar-cancha.component';

const routes: Routes = [
  { path: '', redirectTo: 'consultar-reservas', pathMatch: 'full' },
  { path: 'consultar-reservas', component: ConsultarReservasComponent },
  { path: 'consultar-reserva-id', component: ConsultarReservaIdComponent },
  { path: 'cancelar-reserva', component: CancelarReservaComponent },
  { path: 'reservar-cancha', component: ReservarCanchaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
