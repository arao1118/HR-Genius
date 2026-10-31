import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
export interface Employee { id:number; employeeCode:string; firstName:string; lastName:string; email:string; status:string; }
@Injectable({providedIn:'root'})
export class ApiService {
  private http=inject(HttpClient);
  private baseUrl='http://localhost:8080/api';
  employees():Observable<Employee[]>{return this.http.get<Employee[]>(`${this.baseUrl}/employees`);}
  health():Observable<{status:string;application:string}>{return this.http.get<{status:string;application:string}>(`${this.baseUrl}/health`);}
}
