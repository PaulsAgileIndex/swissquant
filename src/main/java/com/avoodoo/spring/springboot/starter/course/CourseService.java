package com.avoodoo.spring.springboot.starter.course;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class CourseService {
	
	@Inject
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();		
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
		
	public Course getCourseById(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourseById(String id) {
		courseRepository.delete(id);
	}
	
}
