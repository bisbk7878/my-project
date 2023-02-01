package com.learnspringjpa.spring.data.jpa.learning;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.learnspringjpa.spring.data.jpa.learning.entity.Course;
import com.learnspringjpa.spring.data.jpa.learning.entity.Teacher;
import com.learnspringjpa.spring.data.jpa.learning.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourse() {
		
		List<Course> course=courseRepository.findAll();
		
		System.out.println("Courses are: " +course);
		
	}
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher = Teacher.builder()
				         .firstName("Priyan")
				         .lastName("shar")
				         .build();
		
		Course course = Course.builder()
				        .title("DataBas")
				        .credit(7)
				        .teacher(teacher)
				        .build();
		courseRepository.save(course);
	}
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0,3);                                
		Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
		
		List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
		
		long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
		
		System.out.println("Total element :" +totalElements);
		System.out.println("TotalPages :"+totalPages);
		System.out.println("Courses= " +courses);
			
	}
	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2,Sort.by("credit").descending());
		
		List<Course> course = courseRepository.findAll(sortByTitle).getContent();
		
		
		System.out.println("Courses sorted : "+course);
		
	}
	
	

}
