import { Component, OnInit } from '@angular/core';
import {CourseDetails} from "../../model/course-details";
import {ActivatedRoute} from "@angular/router";
import {CourseService} from "../../service/course.service";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  public course: CourseDetails;

  constructor(private route: ActivatedRoute, private courseService: CourseService) { }

  ngOnInit(): void {
    let courseId = this.route.snapshot.params['id'];
    this.courseService.getCourse(courseId).subscribe(data => {
      this.course = data;
    });
  }
}
