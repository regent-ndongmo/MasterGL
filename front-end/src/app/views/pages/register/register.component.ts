import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonDirective, CardBodyComponent, CardComponent, ColComponent, ContainerComponent, InputGroupComponent, InputGroupTextDirective, RowComponent, TextColorDirective } from '@coreui/angular';
import { IconDirective, IconSetService, IconModule } from '@coreui/icons-angular';
import { AuthService } from '../../../Auth/service/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { cilContact, cilHome, cilLocationPin, cilLockLocked, cilMap, cilPhone, cilUser } from '@coreui/icons';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  standalone: true,
  imports: [ IconModule, HttpClientModule, RouterModule, CommonModule, ReactiveFormsModule, ContainerComponent,IconDirective, RowComponent, ColComponent, TextColorDirective, CardComponent, CardBodyComponent, InputGroupComponent, InputGroupTextDirective, ButtonDirective],
  providers: [IconSetService],
})
export class RegisterComponent {
  registerForm!: FormGroup;

  constructor(private service: AuthService, private fb: FormBuilder, private router: Router, private iconSetService: IconSetService) {
    this.iconSetService.icons = { cilContact, cilUser, cilMap, cilLocationPin, cilLockLocked, cilPhone, cilHome };    
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
      Object.keys(this.registerForm.controls).forEach((controlName) => {
        const control = this.registerForm.get(controlName);
        control?.markAsTouched({ onlySelf: true });
      });
      alert('Please fill all the required fields correctly.');
      return;
    }
  
    const { confirmPassword, ...formValues } = this.registerForm.value;
    const payload = {
      ...formValues,
      role: { id: 1 },
    };
  
    this.service.register(payload).subscribe(
      (res: any) => {
        console.log('Registration successful:', res);
        res.status(200).json({ message: 'User registered successfully' });
        alert('Registration successful! Redirecting to login...');
        this.router.navigate(['/login']);
      },
      (err) => {
        // console.error('Registration error:', err);  
        if (err.status === 500) {
          if (err.error && typeof err.error.message === 'string' && err.error.message.includes('email')) {
            alert('This email is already in use. Please use another email.');
          } else {
            alert('A server error occurred. Please try again later.');
          }
        } else if (err.status === 400) {
          alert('Invalid data provided. Please review your information.');
        } else if (err.status === 409) {
          alert('The email is already registered. Try logging in.');
        } else if (err.status === 200) {
          console.log('Registration successful:', payload);
          alert('Registration successful! Redirecting to login...');
          this.router.navigate(['/login']);
        }else{
          alert('An unexpected error occurred. Please try again later.');
        }
      }
    );
  }  
}
