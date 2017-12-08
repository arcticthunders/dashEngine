package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends MongoRepository<com.example.demo.attendance,Date>{

	
	@Query("{'date' : {$ge : ?0}}") 
  List<attendance> findDateBetween(Date dateF);




	

}
