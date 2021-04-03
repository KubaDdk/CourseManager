import { Component, OnInit } from '@angular/core';
import {User} from "../../model/user";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  private userService: UserService;
  users: User[];


  constructor(userService: UserService) {
    this.userService = userService;
  }

  ngOnInit(): void {
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    });
  }

}
