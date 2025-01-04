import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Auth/service/auth.service';

@Component({
  selector: 'app-etudiant',
  imports: [],
  templateUrl: './etudiant.component.html',
  styleUrl: './etudiant.component.scss'
})
export class EtudiantComponent implements OnInit{

  ngOnInit(): void {
    this.getStudent();
  }

  constructor(
    private authService: AuthService
  ){}

  public getStudent(){
    this.authService.getStudent().subscribe((res: any) => {
      console.log(res)
    })
  }


}
