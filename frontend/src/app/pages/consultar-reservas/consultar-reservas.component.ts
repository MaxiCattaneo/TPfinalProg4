import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservasService, ReservaDTO } from '../../services/reservas.service'; // Importá la interfaz

@Component({
  selector: 'app-consultar-reservas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './consultar-reservas.component.html',
  styleUrls: ['./consultar-reservas.component.css']
})
export class ConsultarReservasComponent implements OnInit {

  reservas: ReservaDTO[] = [];  // Cambiado de any[] a ReservaDTO[]

  constructor(private reservasService: ReservasService) {}

  ngOnInit(): void {
    this.reservasService.getReservas().subscribe({
      next: (data: ReservaDTO[]) => {  // Tipado explícito
        this.reservas = data;
      },
      error: (err) => {
        console.error('Error al cargar reservas', err);
      }
    });
  }
}
