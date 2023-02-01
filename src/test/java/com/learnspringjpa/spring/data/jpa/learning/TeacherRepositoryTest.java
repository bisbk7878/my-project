package com.learnspringjpa.spring.data.jpa.learning;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnspringjpa.spring.data.jpa.learning.entity.Course;
import com.learnspringjpa.spring.data.jpa.learning.entity.Teacher;
import com.learnspringjpa.spring.data.jpa.learning.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
	
	Course courseDba = Course.builder()
			        .title("DBA")
			        .credit(5)
			        .build();
	Course courseJava = Course.builder()
	        .title("Java")
	        .credit(7)
	        .build();
	
	
	Teacher teacher = Teacher.builder()
			          .firstName("Tarun")
			          .lastName("Rohila")
			          .courses(List.of(courseDba,courseJava))
			          .build();
	
	teacherRepository.save(teacher);
	
	}		      
	

}
