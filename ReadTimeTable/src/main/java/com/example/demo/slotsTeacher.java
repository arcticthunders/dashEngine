package com.example.demo;

import java.time.LocalTime;

public class slotsTeacher {
LocalTime from;
LocalTime to;
String course_id;
String course_name;
String standard;
String division;
String venue;
public slotsTeacher(LocalTime from, LocalTime to, String course_id, String course_name, String standard,
		String division, String venue) {
	super();
	this.from = from;
	this.to = to;
	this.course_id = course_id;
	this.course_name = course_name;
	this.standard = standard;
	this.division = division;
	this.venue = venue;
}
public LocalTime getFrom() {
	return from;
}
public void setFrom(LocalTime from) {
	this.from = from;
}
public LocalTime getTo() {
	return to;
}
public void setTo(LocalTime to) {
	this.to = to;
}
public String getCourse_id() {
	return course_id;
}
public void setCourse_id(String course_id) {
	this.course_id = course_id;
}
public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}
public String getStandard() {
	return standard;
}
public void setStandard(String standard) {
	this.standard = standard;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getVenue() {
	return venue;
}
public void setVenue(String venue) {
	this.venue = venue;
}



	
}
