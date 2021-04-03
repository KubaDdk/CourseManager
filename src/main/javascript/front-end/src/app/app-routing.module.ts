import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserListComponent} from "./view/user-list/user-list.component";
import {UserComponent} from "./view/user/user.component";
import {UserFormComponent} from "./view/user-form/user-form.component";
import {CourseComponent} from "./view/course/course.component";
import {CourseListComponent} from "./view/course-list/course-list.component";
import {AssignTeacherComponent} from "./view/assign-teacher/assign-teacher.component";

const routes: Routes = [
  { path: 'users', component: UserListComponent},
  { path: 'users/:id', component: UserComponent},
  { path: 'adduser', component: UserFormComponent},
  { path: 'courses', component: CourseListComponent },
  { path: 'courses/assign-teacher', component: AssignTeacherComponent },
  { path: 'courses/:id', component: CourseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
