import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-binding',
  imports: [FormsModule],
  templateUrl: './binding.html',
})
export class BindingComponent {
  titre: string = 'Gestion Makeup';
  status: boolean = true;

  changerTitre() {
    this.titre = 'Nouveau Titre Makeup';
  }
}