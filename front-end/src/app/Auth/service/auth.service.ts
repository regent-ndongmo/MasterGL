import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { Login } from '../../model/login';
import { Register } from '../../model/register';
import { ApiResponse } from '../../interface/api-response';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = `${environment.apiUrl}`;
  private apiBaseUrl = `${environment.apiBaseUrl}`;


  private componentState: BehaviorSubject<boolean>;
  currentState ;

  constructor(private httpClient: HttpClient, private router: Router) {
    const savedState = localStorage.getItem('componentState');
    this.componentState = new BehaviorSubject<boolean>(savedState === 'true');
    this.currentState = this.componentState.asObservable();
  }

  changeState(state: boolean) {
    localStorage.setItem('componentState', state.toString());
    this.componentState.next(state);
  }


  private buttonClicked = new BehaviorSubject<boolean>(false);
  buttonClicked$ = this.buttonClicked.asObservable();

  clickButton(): void {
    this.buttonClicked.next(true);
  }
  
  login(data: Login): Observable<ApiResponse>  {
    return this.httpClient.post<ApiResponse>(`${this.apiUrl}/login`, data);
  }

  getStudent(): Observable<any> {
    const token = localStorage.getItem('token');
    if (!token) {
      throw new Error('Token not found');
    }
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'accept': '*/*'
    });
    return this.httpClient.get(`${this.apiBaseUrl}/etudiant/`, { headers });
  }
  register(data: Register) {
    return this.httpClient.post(`${this.apiUrl}/signup`, data);
  }
  //
  verify(data: any) {
    return this.httpClient.post(`${this.apiUrl}/verify`, data);
  }
  resendVerificationCode(data: any) {
    return this.httpClient.post(`${this.apiUrl}/resend-verification`, data);
  }

  verifyResetCode(data: any) {
    return this.httpClient.post(`${this.apiUrl}/verify-reset-code`, data);
  }

  resetPassword(data: any) {
    return this.httpClient.post(`${this.apiUrl}/reset-password`, data);
  }


  // Méthode pour vérifier si l'utilisateur est authentifié
  isAuthenticated(): boolean {
    return !!localStorage.getItem('user');
  }

  // Méthode pour obtenir le rôle de l'utilisateur
  getRole(): string{
    const user = localStorage.getItem('currentuser');
    return user ? JSON.parse(user).role : "client";
  }

  // Méthode pour se déconnecter
  logout() {
    if(confirm("Voulez vous vous deconnecter de tout vos compte ? ")){
      this.changeState(false);
      console.log("currentuser", localStorage.getItem('currentuser'));
      localStorage.removeItem('currentuser');
      console.log("currentuser after:", localStorage.getItem('currentuser'));
      this.router.navigate(['/dashboard'])
    }

  }

  //
  forgotPassword(data: { email: string }): Observable<any> {
    return this.httpClient.post(`${this.apiUrl}/forgot-password`, data);
  }
}
