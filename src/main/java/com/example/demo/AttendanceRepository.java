package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends MongoRepository<com.example.demo.attendance,Date>{

	
	@Query("{'RollNumber' : ?0}") 
  List<attendance> find(String Rno);

  @Query("{ \"$and\": [ { \"$and\": [       { 'date' :{ $gte : ?0}}     ,      { 'date' : {$lte : ?1}}   ] } , { 'status' : false }   ]}") 
  List<attendance> findDateBetween(Date dateF,Date dateT);

  @Query("{\"$and\": [ { \"$and\": [ {  \"$and\": [       { 'date' :{ $gte : ?1}}     ,      { 'date' : {$lte : ?2}}   ] } , { 'status' : false }   ]} , { 'RollNumber' : ?0 }]}")
  List<attendance> findRnoDateBetween(String Rno,Date dateF,Date dateT);

	
  
}







