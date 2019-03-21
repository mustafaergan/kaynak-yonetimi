import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import Person from '../model/Person';
import {environment} from '../../environments/environment';
import {CrudService} from './abstract/crud.service';

@Injectable({
  providedIn: 'root'
})
export class PersonService extends CrudService<Person, Number> {

  constructor(protected http: HttpClient) {
    super(environment.server + '/person', http);
  }

  // checkPerson(model: Person) {
  //   this.http.post(`${this.uri}/check`, model)
  //     .subscribe(res => console.log('Done'));
  // }

}
