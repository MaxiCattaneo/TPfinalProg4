import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; // agregá HttpHeaders
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {
  private apiUrl = 'http://localhost:8080/api/reservas'; 

  constructor(private http: HttpClient) {}

  private getAuthHeaders() {
    const token = localStorage.getItem('token'); // o donde tengas guardado el JWT
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

  getReservas(): Observable<any> {
    return this.http.get(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  getReservaPorId(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/consultarReserva/${id}`, { headers: this.getAuthHeaders() });
  }

  cancelarReserva(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/cancelarReserva/${id}`, { headers: this.getAuthHeaders() });
  }

  reservarCancha(reserva: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/reservarCancha`, reserva, { headers: this.getAuthHeaders() });
  }
}
