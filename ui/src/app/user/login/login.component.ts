import { Component, OnInit } from '@angular/core';
import User from '../../model/user';
import {UserService} from '../../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: User = new User();

  constructor(private userService: UserService) {
  }

  onSubmit() {
    this.userService.findOne(1);
    // this.userService.checkUser(this.model);
  }

  ngOnInit() {
  }

}
