import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { ConsultarReservasComponent } from './pages/consultar-reservas/consultar-reservas.component';
import { ConsultarReservaIdComponent } from './pages/consultar-reserva-id/consultar-reserva-id.component';
import { CancelarReservaComponent } from './pages/cancelar-reserva/cancelar-reserva.component';
import { ReservarCanchaComponent } from './pages/reservar-cancha/reservar-cancha.component';

@NgModule({
  declarations: [
    AppComponent,
    ConsultarReservasComponent,
    ConsultarReservaIdComponent,
    CancelarReservaComponent,
    ReservarCanchaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

