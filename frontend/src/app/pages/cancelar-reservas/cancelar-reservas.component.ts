import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReservasService } from '../../services/reservas.service';

@Component({
  selector: 'app-cancelar-reservas',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cancelar-reservas.component.html'
})
export class CancelarReservaComponent implements OnInit {
  reservas: any[] = [];
  mensaje: string = '';

  constructor(private reservasService: ReservasService) {}

  ngOnInit(): void {
    this.cargarReservas();
  }

  cargarReservas(): void {
    this.reservasService.getReservasDelUsuario().subscribe({
      next: (data) => this.reservas = data,
      error: () => this.mensaje = 'Error al cargar las reservas.'
    });
  }

  cancelar(id: number): void {
    this.reservasService.cancelarReserva(id).subscribe({
      next: () => {
        this.mensaje = `Reserva ${id} cancelada con éxito.`;
        this.cargarReservas();
      },
      error: () => this.mensaje = 'Error al cancelar la reserva.'
    });
  }
}
