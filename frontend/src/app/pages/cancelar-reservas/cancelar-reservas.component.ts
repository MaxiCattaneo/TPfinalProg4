import { Component } from '@angular/core';
import { ReservasService } from '../../services/reservas.service';

@Component({
  selector: 'app-cancelar-reserva',
  templateUrl: './cancelar-reserva.component.html'
})
export class CancelarReservaComponent {
  reservaId: number = 0;
  mensaje = '';

  constructor(private reservasService: ReservasService) {}

  cancelar() {
    this.reservasService.cancelarReserva(this.reservaId).subscribe(() => {
      this.mensaje = 'Reserva cancelada con éxito';
    }, () => {
      this.mensaje = 'Error al cancelar la reserva';
    });
  }
}
