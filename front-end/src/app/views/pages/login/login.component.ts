import { Component } from '@angular/core';
import { CommonModule, NgStyle } from '@angular/common';
import { IconDirective } from '@coreui/icons-angular';
import { ContainerComponent, RowComponent, ColComponent, TextColorDirective, CardComponent, CardBodyComponent, InputGroupComponent, InputGroupTextDirective, FormControlDirective, ButtonDirective } from '@coreui/angular';
import { Router, RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../../Auth/service/auth.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    standalone: true,
    imports: [ContainerComponent, HttpClientModule, ReactiveFormsModule, CommonModule, RowComponent, RouterModule, ColComponent, TextColorDirective, CardComponent, CardBodyComponent, InputGroupComponent, InputGroupTextDirective, IconDirective, FormControlDirective, ButtonDirective, NgStyle]
})
export class LoginComponent {
  loginForm!: FormGroup;
  constructor(private service: AuthService, private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }
  onSubmit() {
    if (this.loginForm.invalid) {
      console.log(this.loginForm.value);
      
      // Log les erreurs pour chaque champ
      console.log('Form Errors:', this.loginForm.errors);
      Object.keys(this.loginForm.controls).forEach((controlName) => {
        const control = this.loginForm.get(controlName);
        if (control && control.invalid) {
          console.log(`${controlName} Errors:`, control.errors);
        }
      });
  
      alert('Please fill all the required fields correctly.');
      return;
    }
  
    const payload = this.loginForm.value;
    console.log('payload:', payload);
  
    this.service.login(payload).subscribe(
      (res: any) => {
        localStorage.setItem('currentuser', payload.email);
        console.log(localStorage.getItem('currentuser'));
        
        this.router.navigate(['/dashboard']);
      },
      (err) => {
        console.error('login error:', err);
  
        // Handle the 500 status with email conflict message
        if (err.status === 500) {
          // Attempt to parse the error response for more details
          if (err.error && typeof err.error.message === 'string' && err.error.message.includes('email')) {
            alert('An error occurred while creating your account. Please review your informations and try again.');
          } else {
            alert('A server error occurred. Please try again later.');
          }
        } else {
          alert('An unexpected error occurred. Please try again later.');
        }
      }
    );
  }
}
