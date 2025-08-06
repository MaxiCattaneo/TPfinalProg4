import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultarReservasComponent } from './pages/consultar-reservas/consultar-reservas.component';
import { ConsultarReservaIdComponent } from './pages/consultar-reservas-id/consultar-reservas-id.component';
import { CancelarReservaComponent } from './pages/cancelar-reservas/cancelar-reservas.component';
import { ReservarCanchaComponent } from './pages/reservar-cancha/reservar-cancha.component';

const routes: Routes = [
  { path: '', redirectTo: 'consultar-reservas', pathMatch: 'full' },
  { path: 'consultar-reservas', component: ConsultarReservasComponent },
  { path: 'consultar-reservas-id', component: ConsultarReservaIdComponent },
  { path: 'cancelar-reservas', component: CancelarReservaComponent },
  { path: 'reservar-cancha', component: ReservarCanchaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
