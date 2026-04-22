import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Makeup } from '../model/makeup.model';
import { MakeupService } from '../services/makeup';

@Component({
  selector: 'app-add-makeup',
  imports: [FormsModule],
  templateUrl: './add-makeup.html',
  styleUrl: './add-makeup.css'
})
export class AddMakeupComponent implements OnInit {
  newMakeup = new Makeup();

  constructor(private makeupService: MakeupService) {}

  ngOnInit(): void {}

  addMakeup() {
    this.makeupService.ajouterMakeup(this.newMakeup);
    this.newMakeup = new Makeup();
  }
}