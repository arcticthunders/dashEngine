package com.example.demo;

import java.time.LocalTime;

public class timetable {

	private String day;
	private String courseId;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	private String standard;
	private String division;
	private String teacherId;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public LocalTime getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(LocalTime timeFrom) {
		this.timeFrom = timeFrom;
	}
	public LocalTime getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(LocalTime timeTo) {
		this.timeTo = timeTo;
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
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public timetable(String day, String courseId, LocalTime timeFrom, LocalTime timeTo, String standard, String division,
			String teacherId) {
		super();
		this.day = day;
		this.courseId = courseId;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.standard = standard;
		this.division = division;
		this.teacherId = teacherId;
	}
	

	
}
