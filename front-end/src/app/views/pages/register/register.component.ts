import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonDirective, CardBodyComponent, CardComponent, ColComponent, ContainerComponent, InputGroupComponent, InputGroupTextDirective, RowComponent, TextColorDirective } from '@coreui/angular';
import { IconDirective } from '@coreui/icons-angular';
import { AuthService } from '../../../Auth/service/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  standalone: true,
  imports: [ HttpClientModule, RouterModule, CommonModule, ReactiveFormsModule, ContainerComponent,IconDirective, RowComponent, ColComponent, TextColorDirective, CardComponent, CardBodyComponent, InputGroupComponent, InputGroupTextDirective, ButtonDirective],
})
export class RegisterComponent {
  registerForm!: FormGroup;

  constructor(private service: AuthService, private fb: FormBuilder, private router: Router) {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      numeroCNI: ['', Validators.required],
      numeroTelephone: ['', [Validators.required, Validators.pattern(/^(((((\+?\d{1,3}[- ]?)?\d{1}[- ]?)?\d{2,3}[- ]?)?\d{2,3}[- ]?)?\d{2,3}[- ]?)?\d{0,2}$/)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
      adresse: ['', Validators.required],
    }, { validator: this.passwordMatchValidator });
  }

  passwordMatchValidator(group: FormGroup) {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { mismatch: true };
  }

  onSubmit() {
    if (this.registerForm.invalid) {
      // Log les erreurs pour chaque champ
      console.log('Form Errors:', this.registerForm.errors);
      Object.keys(this.registerForm.controls).forEach((controlName) => {
        const control = this.registerForm.get(controlName);
        if (control && control.invalid) {
          console.log(`${controlName} Errors:`, control.errors);
        }
      });
  
      alert('Please fill all the required fields correctly.');
      return;
    }
  
    const { confirmPassword, ...formValues } = this.registerForm.value; // Exclude confirmPassword
    const payload = {
      ...formValues,
      role: {
        id: 1, // Include role.id with a value of 3
      },
    };
    console.log('payload:', payload);
  
    this.service.register(payload).subscribe(
      (res: any) => {
        console.log(res);
        this.router.navigate(['/login']);
      },
      (err) => {
        console.error('Registration error:', err);
  
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
