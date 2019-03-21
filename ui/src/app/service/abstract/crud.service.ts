import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CrudOperations} from './crud-operation';

export abstract class CrudService<T, ID> implements CrudOperations<T, ID> {

  protected base: string;
  protected http: HttpClient;
  protected options: {};

  protected constructor(
    base: string,
    http: HttpClient,
    options?: {}
  ) {
    this.base = base;
    this.http = http;
    this.options = options;
  }

  save(t: T): Observable<T>  {
    return this.http.post(this.base, t, this.options) as Observable<T>;
  }

  update(id: ID, t: T): Observable<T>  {
    return this.http.put(this.base + '/' + id, t, this.options) as Observable<T>;
  }

  findOne(id: ID): Observable<T> {
    return this.http.get(this.base + '/' + id, this.options) as Observable<T>;
  }

  findAll(): Observable<T[]> {
    return this.http.get(this.base, this.options) as  Observable<T[]> ;
  }

  delete(id: ID) {
    return this.http.delete(this.base + '/' + id, this.options) as Observable<T>;
  }
}
