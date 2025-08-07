import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ReservaDTO {
  id: number;
  fecha: string;
  nombreUsuario: string;
  nombreCancha: string;
  nombreComplejo: string;
  horaInicio: string;
}

@Injectable({
  providedIn: 'root'
})
export class ReservasService {
  private apiUrl = 'http://localhost:8080/api/reservas'; 

  constructor(private http: HttpClient) {}

  private getAuthHeaders() {
    const token = localStorage.getItem('token'); 
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

  getReservas(): Observable<ReservaDTO[]> {
    return this.http.get<ReservaDTO[]>(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  getReservaPorId(id: number): Observable<ReservaDTO> {
    return this.http.get<ReservaDTO>(`${this.apiUrl}/consultarReserva/${id}`, { headers: this.getAuthHeaders() });
  }

  cancelarReserva(id: number): Observable<void> {
    // Aquí el endpoint DELETE /api/reservas/{id}
    return this.http.delete<void>(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  reservarCancha(reserva: any): Observable<any> {
    // Aquí el endpoint POST /api/reservas/reservar
    return this.http.post(`${this.apiUrl}/reservar`, reserva, { headers: this.getAuthHeaders() });
  }
}
