import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Makeup } from '../model/makeup.model';
import { MakeupService } from '../services/makeup';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-makeups',
  imports: [CommonModule, RouterLink],
  templateUrl: './makeups.html',
  styleUrl: './makeups.css'
})
export class MakeupsComponent implements OnInit {
  makeups: Makeup[] = [];

  constructor(private makeupService: MakeupService) {
    this.makeups = makeupService.listeMakeups();
  }

  ngOnInit(): void {}

  supprimerMakeup(m: Makeup) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
      this.makeupService.supprimerMakeup(m);
  }
}