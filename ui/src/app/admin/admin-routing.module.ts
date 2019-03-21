import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListUserComponent} from './list-user/list-user.component';
import {ListRoleComponent} from './list-role/list-role.component';

const routes: Routes = [
  {path: 'user', component: ListUserComponent},
  {path: 'role', component: ListRoleComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
