import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservasService } from '../../services/reservas.service'; // Ajustá ruta según tu estructura

@Component({
  selector: 'app-consultar-reservas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './consultar-reservas.component.html',
  styleUrls: ['./consultar-reservas.component.css']
})
export class ConsultarReservasComponent implements OnInit {

  reservas: any[] = [];

  constructor(private reservasService: ReservasService) {}

  ngOnInit(): void {
    this.reservasService.getReservas().subscribe({
      next: (data) => {
        this.reservas = data;
      },
      error: (err) => {
        console.error('Error al cargar reservas', err);
      }
    });
  }
}
