import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReservasService } from '../../services/reservas.service';

@Component({
  selector: 'app-consultar-reservas-id',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './consultar-reservas-id.component.html',
  styleUrls: ['./consultar-reservas-id.component.css']
})
export class ConsultarReservaIdComponent {
  reservaId: number = 0;
  reserva: any;

  constructor(private reservasService: ReservasService) {}

  buscarReserva() {
    this.reservasService.getReservaPorId(this.reservaId).subscribe((data: any) => {
      this.reserva = data;
    });
  }
}