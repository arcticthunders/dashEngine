package com.example.demo;

import java.util.List;

public class student_marklist {

	String rollnumber;
	String name;
	String parentName;
	String parentmobile;
	String standard;
	String division;
	String classteacherid;
	String classteachername;
	List<student_courses> courses;
	public String getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentmobile() {
		return parentmobile;
	}
	public void setParentmobile(String parentmobile) {
		this.parentmobile = parentmobile;
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
	public List<student_courses> getCourses() {
		return courses;
	}
	public void setCourses(List<student_courses> courses) {
		this.courses = courses;
	}
	public student_marklist(String rollnumber, String name, String parentName, String parentmobile, String standard,
			String division, String classteacherid, String classteachername, List<student_courses> courses) {
		super();
		this.rollnumber = rollnumber;
		this.name = name;
		this.parentName = parentName;
		this.parentmobile = parentmobile;
		this.standard = standard;
		this.division = division;
		this.classteacherid = classteacherid;
		this.classteachername = classteachername;
		this.courses = courses;
	}
	
	
}
