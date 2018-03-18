package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface timetableRepository  extends MongoRepository<com.example.demo.timetable, String>{

	
	 @Query("{ \"$and\": [{ 'Standard' :?0} , { 'Division' : ?1}]}") 
	List<timetable> findTimeTable(String standard, String division);



@Query(" {'teacherId':?0 } ")
	List<timetable> findTeacherTimeTable(String teacherId);

}
