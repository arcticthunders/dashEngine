package com.example.demo;

import java.time.LocalTime;

public class slots {
	LocalTime from;
	LocalTime to;
	String course_id;
	String course_name;
	String teacher_id;
	String teacher_name;
	String venue;
	public slots(LocalTime from, LocalTime to, String course_id, String course_name, String teacher_id,
			String teacher_name, String venue) {
		super();
		this.from = from;
		this.to = to;
		this.course_id = course_id;
		this.course_name = course_name;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
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
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	

}
