import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './view/user-list/user-list.component';
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./service/user.service";
import { UserComponent } from './view/user/user.component';
import { UserFormComponent } from './view/user-form/user-form.component';
import {FormsModule} from "@angular/forms";
import { CourseComponent } from './view/course/course.component';
import { CourseListComponent } from './view/course-list/course-list.component';
import { AssignTeacherComponent } from './view/assign-teacher/assign-teacher.component';


@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserComponent,
    UserFormComponent,
    CourseComponent,
    CourseListComponent,
    AssignTeacherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
