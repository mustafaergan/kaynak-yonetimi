import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import User from '../model/user';
import {environment} from '../../environments/environment';
import {CrudService} from './abstract/crud.service';

@Injectable({
  providedIn: 'root'
})
export class UserService extends CrudService<User, Number> {

  constructor(protected http: HttpClient) {
    super(environment.server + 'posts', http);
  }

  // checkUser(model: User) {
  //   this.http.post(`${this.uri}/check`, model)
  //     .subscribe(res => console.log('Done'));
  // }

}
