import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Makeup } from '../model/makeup.model';
import { MakeupService } from '../services/makeup';

@Component({
  selector: 'app-update-makeup',
  imports: [FormsModule, CommonModule],
  templateUrl: './update-makeup.html',
  styles: ``
})
export class UpdateMakeupComponent implements OnInit {
  currentMakeup = new Makeup();

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private makeupService: MakeupService
  ) {}

  ngOnInit() {
    this.currentMakeup = this.makeupService.consulterMakeup(
      this.activatedRoute.snapshot.params['id']
    );
    console.log(this.currentMakeup);
  }

  updateMakeup() {
    this.makeupService.updateMakeup(this.currentMakeup);
    this.router.navigate(['makeups']);
  }
}