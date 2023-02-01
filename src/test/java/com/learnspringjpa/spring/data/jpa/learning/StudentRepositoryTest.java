package com.learnspringjpa.spring.data.jpa.learning;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnspringjpa.spring.data.jpa.learning.entity.Guardian;
import com.learnspringjpa.spring.data.jpa.learning.entity.Student;
import com.learnspringjpa.spring.data.jpa.learning.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				           .emailId("bishalb78@gmail.com")
				           .firstName("Bishal")
				           .lastName("BK")
				           //.guardianName("Kamala")
				          // .guardianEmail("Kamala@gmail.com")
				          // .guardianMobile("00000000") 
				           .build();
		
		studentRepository.save(student);	
	}
	
	@Test
	public void saveStudentWithGaurdian() {
		
		Guardian guardian = Guardian.builder()
		                    .email("bishalbk123@gmail.com")
		                    .name("Vishal")
		                    .mobile("98236589")
		                    .build();
		Student student =Student.builder()
				         .firstName("Binita")
				         .lastName("BK")
				         .emailId("binitausa@gmail.com")
				         .guardian(guardian)
				          .build();
		
		studentRepository.save(student);
	}
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("studentlist = "+studentList);
	}
	@Test
	public void printStudentByFirstName() {
		List<Student> students=studentRepository.findByFirstName("Binita");
		System.out.println("student = "+ students);
		
		
	}
	@Test
	public void printStudentBasedonGuardianName() {
		List<Student> students=studentRepository.findByGuardianName("Vishal");
		System.out.println("Student = " +students);
	}

	@Test
	public void printgetStudentByEmailAddress() {
		Student student=studentRepository.getStudentByEmailAddress("bishalbk123@gmail.com");
		System.out.println("Student = " +student);
	}
	@Test
	public void printgetStudentByEmailAddressNative() {
		Student studentss=studentRepository.getStudentByEmailAddressNative("bishalb7878@gmail.com");
		System.out.println("Student = " +studentss);
	}
	
	@Test
	public void printgetStudentByEmailAddressNativeNamedParam() {
		Student studentsss = studentRepository.getStudentByEmailAddressNativeNamedParam("binitakb12@gmail.com");
		System.out.println("Student =" +studentsss);
	}
	
	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId("BishalSunar","bishalb7878@gmail.com" );
		
	}
	
	

}
