package com.example.demo;

import java.util.List;

public class coursewise_marklist {
	String teacherid;
	String teachername;
	String courseid;
	String coursename;
	List<coursewise_assesments> assesments;
	public coursewise_marklist(String teacherid, String teachername, String courseid, String coursename,
			List<coursewise_assesments> assesments) {
		super();
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.courseid = courseid;
		this.coursename = coursename;
		this.assesments = assesments;
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
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public List<coursewise_assesments> getAssesments() {
		return assesments;
	}
	public void setAssesments(List<coursewise_assesments> assesments) {
		this.assesments = assesments;
	}
	
	

}
