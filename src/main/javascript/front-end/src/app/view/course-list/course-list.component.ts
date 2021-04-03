import { Component, OnInit } from '@angular/core';
import {Course} from "../../model/course";
import {CourseService} from "../../service/course.service";

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  public courses: Course[];

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.getCourses().subscribe(data => {
      this.courses = data;
    });
  }

}
