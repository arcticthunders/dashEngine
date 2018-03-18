package com.example.demo;

import java.util.List;

public class classteacher_marklist {
	String standard;
	String division;
	String classteacherid;
	String classteachername;
	String examname;
	List<classteacher_courses> courses;
	public classteacher_marklist(String standard, String division, String classteacherid, String classteachername,
			String examname, List<classteacher_courses> courses) {
		super();
		this.standard = standard;
		this.division = division;
		this.classteacherid = classteacherid;
		this.classteachername = classteachername;
		this.examname = examname;
		this.courses = courses;
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
	public String getClassteacherid() {
		return classteacherid;
	}
	public void setClassteacherid(String classteacherid) {
		this.classteacherid = classteacherid;
	}
	public String getClassteachername() {
		return classteachername;
	}
	public void setClassteachername(String classteachername) {
		this.classteachername = classteachername;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public List<classteacher_courses> getCourses() {
		return courses;
	}
	public void setCourses(List<classteacher_courses> courses) {
		this.courses = courses;
	}
	
	

}
