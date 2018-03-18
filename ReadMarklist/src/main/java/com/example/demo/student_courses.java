package com.example.demo;

import java.util.List;

public class student_courses {
	String course_id;
	String coursename;
	String teacherid;
	String teachername;
	List<student_assesments> assesments;
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public List<student_assesments> getAssesments() {
		return assesments;
	}
	public void setAssesments(List<student_assesments> assesments) {
		this.assesments = assesments;
	}
	public student_courses(String course_id, String coursename, String teacherid, String teachername,
			List<student_assesments> assesments) {
		super();
		this.course_id = course_id;
		this.coursename = coursename;
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.assesments = assesments;
	}
	
	

}
