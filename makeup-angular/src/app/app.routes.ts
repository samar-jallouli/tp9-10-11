import { Routes } from '@angular/router';
import { MakeupsComponent } from './makeups/makeups';
import { AddMakeupComponent } from './add-makeup/add-makeup';
import { UpdateMakeup } from './update-makeup/update-makeup';

export const routes: Routes = [
  { path: "makeups", component: MakeupsComponent },
  { path: "add-makeup", component: AddMakeupComponent },
  { path: "updateMakeup/:id", component: UpdateMakeup},
  { path: "", redirectTo: "makeups", pathMatch: "full" }
];