export class Register {
  email: string;
  nom: string;
  prenom: string;
  numeroCNI: string;
  numeroTelephone:string;
  password: string;
  adresse: string;

  constructor(email: string,nom: string,prenom: string,numeroCNI: string,numeroTelephone:string,password: string,adresse: string){
    this.email = email;
    this.nom =   nom;
    this.prenom =   prenom;
    this.numeroCNI =   numeroCNI;
    this.numeroTelephone =   numeroTelephone;
    this.password =   password;
    this.adresse =   adresse;
  }
}
