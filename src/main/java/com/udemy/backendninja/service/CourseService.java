package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.CourseModel;

public interface CourseService {
	
	public abstract List<CourseModel> listAllCourses();
	public abstract CourseModel addCourse(CourseModel course);
	public abstract int removeCourse(int id);
	public abstract CourseModel updateCourse (CourseModel course);

}
