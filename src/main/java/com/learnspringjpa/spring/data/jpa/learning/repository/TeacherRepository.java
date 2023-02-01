package com.learnspringjpa.spring.data.jpa.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnspringjpa.spring.data.jpa.learning.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
	
	
}
