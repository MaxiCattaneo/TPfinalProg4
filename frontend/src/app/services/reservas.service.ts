import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {
  private apiUrl = 'http://localhost:8080/api/reservas'; 

  constructor(private http: HttpClient) {}

  getReservas(): Observable<any> {
    return this.http.get(`${this.apiUrl}`);
  }

  getReservaPorId(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/consultarReserva/${id}`);
  }

  cancelarReserva(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/cancelarReserva/${id}`);
  }

  reservarCancha(reserva: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/reservarCancha`, reserva);
  }
}
