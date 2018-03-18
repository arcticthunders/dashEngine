package com.example.demo;

public class absenteeList {

	String rollNumber;
	String name;
	String className;
	String division;
	int leaveApplicationStatus;
	
	public absenteeList(String rollNumber, String name, String className, String division, int leaveApplicationStatus) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.className = className;
		this.division = division;
		this.leaveApplicationStatus = leaveApplicationStatus;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getLeaveApplicationStatus() {
		return leaveApplicationStatus;
	}
	public void setLeaveApplicationStatus(int leaveApplicationStatus) {
		this.leaveApplicationStatus = leaveApplicationStatus;
	}
	
	
	
	
}
