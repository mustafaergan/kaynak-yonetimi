import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListUserComponent} from './list-user/list-user.component';
import {ListRoleComponent} from './list-role/list-role.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MatNativeDateModule} from '@angular/material';
import {AdminRoutingModule} from './admin-routing.module';
import {MaterialModule} from './material-module';

@NgModule({
  declarations: [ListUserComponent, ListRoleComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
  ]
})
export class AdminModule { }
