package com.example.demo;

import java.util.List;

public class timetable_teacher {
 String teacher_id;
 String teacher_name;
 List<daysTeacher> days;
public timetable_teacher(String teacher_id, String teacher_name, List<daysTeacher> days) {
	super();
	this.teacher_id = teacher_id;
	this.teacher_name = teacher_name;
	this.days = days;
}
public String getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(String teacher_id) {
	this.teacher_id = teacher_id;
}
public String getTeacher_name() {
	return teacher_name;
}
public void setTeacher_name(String teacher_name) {
	this.teacher_name = teacher_name;
}
public List<daysTeacher> getDays() {
	return days;
}
public void setDays(List<daysTeacher> days) {
	this.days = days;
}
 
 
 
}
