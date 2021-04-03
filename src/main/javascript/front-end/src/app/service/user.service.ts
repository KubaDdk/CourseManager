import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";
import {UserForm} from "../model/user-form";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private httpClient: HttpClient;

  constructor(httpClinet: HttpClient) {
    this.httpClient = httpClinet;
  }

  public getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>('/api/users');
  }

  public getUser(id: number): Observable<User> {
    return this.httpClient.get<User>('/api/users/' + id);
  }

  public save(user: UserForm) {
    return this.httpClient.post<User>('/api/users', user);
  }

  public getTeacherList(): Observable<User[]> {
    return this.httpClient.get<User[]>('/api/users/?type=TEACHER');
  }

}
