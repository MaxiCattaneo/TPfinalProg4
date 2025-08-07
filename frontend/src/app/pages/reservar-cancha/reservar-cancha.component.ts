import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

interface Complejo {
  id: number;
  nombre: string;
}

interface Cancha {
  id: number;
  nombre: string;
}

interface Turno {
  id: number;
  horaInicio: string;
}

@Component({
  selector: 'app-reservar-cancha',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reservar-cancha.component.html',
  styleUrls: ['./reservar-cancha.component.css']
})
export class ReservarCanchaComponent implements OnInit {
  complejos: Complejo[] = [];
  canchas: Cancha[] = [];
  turnos: Turno[] = [];

  complejoSeleccionado: number | null = null;
  canchaSeleccionada: number | null = null;
  turnoSeleccionado: number | null = null;
  fechaSeleccionada: string = '';

  mensaje: string = '';
  exito: boolean = false;

  private API_BASE = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.cargarComplejos();
    this.cargarTurnos();
  }

  cargarComplejos(): void {
    this.http.get<Complejo[]>(`${this.API_BASE}/complejos`).subscribe({
      next: (data) => {
        this.complejos = data;
      },
      error: (err) => {
        console.error('Error cargando complejos:', err);
        this.mostrarMensaje('Error cargando complejos', false);
      }
    });
  }

  cargarTurnos(): void {
    this.http.get<Turno[]>(`${this.API_BASE}/turnos`).subscribe({
      next: (data) => {
        this.turnos = data;
      },
      error: (err) => {
        console.error('Error cargando turnos:', err);
        this.mostrarMensaje('Error cargando turnos', false);
      }
    });
  }

  onCambiarComplejo(): void {
    if (!this.complejoSeleccionado) {
      this.canchas = [];
      this.canchaSeleccionada = null;
      return;
    }
    this.http.get<Cancha[]>(`${this.API_BASE}/complejos/${this.complejoSeleccionado}/canchas`).subscribe({
      next: (data) => {
        this.canchas = data;
        this.canchaSeleccionada = null;
      },
      error: (err) => {
        console.error('Error cargando canchas:', err);
        this.mostrarMensaje('Error cargando canchas', false);
      }
    });
  }

  hacerReserva(): void {
    if (!this.complejoSeleccionado || !this.canchaSeleccionada || !this.turnoSeleccionado || !this.fechaSeleccionada) {
      this.mostrarMensaje('Complete todos los campos', false);
      return;
    }

    const reservaDTO = {
      Idcancha: this.canchaSeleccionada,
      Idturno: this.turnoSeleccionado,
      fecha: this.fechaSeleccionada
    };

    this.http.post(`${this.API_BASE}/reservas/reservar`, reservaDTO).subscribe({
      next: () => {
        this.mostrarMensaje('Reserva realizada con éxito', true);
        this.resetFormulario();
      },
      error: (err) => {
        console.error('Error al hacer reserva:', err);
        this.mostrarMensaje('Error al realizar la reserva', false);
      }
    });
  }

  mostrarMensaje(texto: string, exito: boolean): void {
    this.mensaje = texto;
    this.exito = exito;
    setTimeout(() => {
      this.mensaje = '';
    }, 5000);
  }

  resetFormulario(): void {
    this.complejoSeleccionado = null;
    this.canchaSeleccionada = null;
    this.turnoSeleccionado = null;
    this.fechaSeleccionada = '';
  }
}
