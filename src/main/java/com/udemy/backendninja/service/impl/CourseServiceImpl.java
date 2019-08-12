package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.CourseModel;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		List<CourseModel> listCourseOut = new ArrayList<CourseModel>();
		List<Course> listCourseEntity = courseJpaRepository.findAll();
		
		for(Course course: listCourseEntity) {
			listCourseOut.add(courseConverter.entity2model(course));
		}
		return listCourseOut;
	}

	@Override
	public CourseModel addCourse(CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()");
		Course courseEntity = courseConverter.model2entity(courseModel);		
		Course courseEntityRet = new Course();
		courseEntityRet = courseJpaRepository.save(courseEntity);
		CourseModel courseModelret = courseConverter.entity2model(courseEntityRet);		
		return courseModelret; 
	}

	@Override
	public int removeCourse(int id) {
		LOG.info("Call: " + "removeCourse()");
		Course courseEntityToDelete = courseJpaRepository.findById(id);
		if (courseEntityToDelete != null) {
			
		} else {

		}
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public CourseModel updateCourse(CourseModel courseModel) {
		Course courseEntity = courseConverter.model2entity(courseModel);
		Course courseEntityRet = courseJpaRepository.save(courseEntity);
		CourseModel courseModelret = courseConverter.entity2model(courseEntityRet);			
		return courseModelret;
	}

}
