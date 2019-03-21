import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SignupComponent} from './signup/signup.component';
import {LoginComponent} from './login/login.component';
import {UserRoutingModule} from './user-routing.module';
import {ThemeModule} from '../theme/theme.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {UserService} from '../service/user.service';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [SignupComponent, LoginComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    ThemeModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers : [UserService]
})
export class UserModule { }
