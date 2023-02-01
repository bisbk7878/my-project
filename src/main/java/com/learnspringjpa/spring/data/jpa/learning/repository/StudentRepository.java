package com.learnspringjpa.spring.data.jpa.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learnspringjpa.spring.data.jpa.learning.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>  {
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByGuardianName(String guardianName);
	
	//JPQL Query
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	//Native Query
	@Query(
		value="SELECT * FROM tbl_student s where s.email_address = ?1",
		nativeQuery = true
			)
	Student getStudentByEmailAddressNative(String emailId);
	
	@Query(
			value="SELECT * FROM tbl_student s where s.email_address = :emailId",
			nativeQuery = true
				)
		Student getStudentByEmailAddressNativeNamedParam(
			@Param("emailId") String emailId
			);
	@Modifying //to modify/delete a record in database
	@Transactional
	@Query(
			value="update tbl_student set first_name = ?1 where email_address = ?2",
			nativeQuery = true
			)
	int updateStudentNameByEmailId(String firstName,String emailId);

}
