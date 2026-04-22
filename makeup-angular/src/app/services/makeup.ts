import { Injectable } from '@angular/core';
import { Makeup } from '../model/makeup.model';

@Injectable({
  providedIn: 'root'
})
export class MakeupService {
  makeups: Makeup[] = [];
  makeup!: Makeup;

  constructor() {
    this.makeups = [
      { idMakeup: 1, nomMakeup: "Rouge à Lèvres", prixMakeup: 25.99, dateCreation: new Date("01/14/2023") },
      { idMakeup: 2, nomMakeup: "Mascara", prixMakeup: 15.50, dateCreation: new Date("05/20/2022") },
      { idMakeup: 3, nomMakeup: "Fond de Teint", prixMakeup: 45.00, dateCreation: new Date("03/10/2024") }
    ];
  }

  listeMakeups(): Makeup[] {
    return this.makeups;
  }

  ajouterMakeup(makeup: Makeup) {
    this.makeups.push(makeup);
  }

  supprimerMakeup(makeup: Makeup) {
    const index = this.makeups.indexOf(makeup, 0);
    if (index > -1) {
      this.makeups.splice(index, 1);
    }
  }

  consulterMakeup(id: number): Makeup {
    this.makeup = this.makeups.find(m => m.idMakeup == id)!;
    return this.makeup;
  }

  updateMakeup(makeup: Makeup) {
    const index = this.makeups.indexOf(makeup, 0);
    if (index > -1) {
      this.makeups.splice(index, 1);
      this.makeups.splice(index, 0, makeup);
    }
  }
}