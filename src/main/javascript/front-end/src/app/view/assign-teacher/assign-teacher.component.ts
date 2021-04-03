import { Component, OnInit } from '@angular/core';
import {User} from "../../model/user";
import {ActivatedRoute} from "@angular/router";
import {LessonService} from "../../service/lesson.service";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-assign-teacher',
  templateUrl: './assign-teacher.component.html',
  styleUrls: ['./assign-teacher.component.css']
})
export class AssignTeacherComponent implements OnInit {

  public teacherId:number;
  public lessonBlockId: number;
  public teachers: User[];

  constructor(private route: ActivatedRoute, private lessonService: LessonService, private userService: UserService) { }

  ngOnInit(): void {
    this.lessonBlockId = this.route.snapshot.queryParams['lessonBlockId'];
    this.userService.getTeacherList().subscribe(data => {
      this.teachers = data;
    });
  }

  onSubmit() {
    this.lessonService.assignTeacher(this.teacherId, this.lessonBlockId);
  }

}
