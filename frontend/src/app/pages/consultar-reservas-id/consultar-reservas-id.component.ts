import { Component } from '@angular/core';
import { ReservasService } from 'src/app/services/reservas.service';

@Component({
  selector: 'app-consultar-reserva-id',
  templateUrl: './consultar-reserva-id.component.html'
})
export class ConsultarReservaIdComponent {
  reservaId: number = 0;
  reserva: any;

  constructor(private reservasService: ReservasService) {}

  buscarReserva() {
    this.reservasService.getReservaPorId(this.reservaId).subscribe(data => {
      this.reserva = data;
    });
  }
}
