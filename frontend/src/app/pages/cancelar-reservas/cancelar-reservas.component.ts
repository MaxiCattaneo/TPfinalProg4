import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReservasService } from '../../services/reservas.service';

@Component({
  selector: 'app-cancelar-reservas',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cancelar-reservas.component.html'
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
