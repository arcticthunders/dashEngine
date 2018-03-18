package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface marklistRepository extends MongoRepository<com.example.demo.marklist,String> {

	@Query("{ \"$or\": [{ 'course_id' :?0} , { 'student_id' : ?0}]}")
	List<marklist> findMarkCourseID(String id);
	
	@Query("{ 'examid' :?0}")
	List<marklist> findExamid(int id);
	
	@Query("{ \"$and\": [{\"$and\": [{ 'standard' :?0} , { 'division' : ?1}]} , { 'testname' : ?2}]}")
	List<marklist> findmarkstandard(String standard,String division,String testname);

	@Query("{ \"$and\": [{ 'teacher_id' : ?0},{ 'course_id' :?1}]}")
	List<marklist> findmarkteacher(String teacherid, String courseid);

	

}


