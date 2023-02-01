package com.learnspringjpa.spring.data.jpa.learning;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnspringjpa.spring.data.jpa.learning.entity.Course;
import com.learnspringjpa.spring.data.jpa.learning.entity.CourseMaterial;
import com.learnspringjpa.spring.data.jpa.learning.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    @Autowired
	private CourseMaterialRepository repository;
    
    @Test
    public void SaveCourseMaterial() {
    	
    	Course course= Course.builder()
    			         .title("DSA")
                         .credit(6) 
                         .build();
    	CourseMaterial courseMaterial=CourseMaterial.builder()
    			                       .url("www.google.com")
    			                       .course(course)
    			                       .build();
    	   
    	repository.save(courseMaterial);
    }
    
    @Test
    public void printAllCourseMaterial() {
    	List<CourseMaterial> courseMaterial = repository.findAll();
    	System.out.println("CourseMaterial = "+courseMaterial);
    }
    
    
          
	
}
