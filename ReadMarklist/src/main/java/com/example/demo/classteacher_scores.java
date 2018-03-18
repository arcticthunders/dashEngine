package com.example.demo;

public class classteacher_scores {

	String rollnumber;
	String name;
	float marks;
	public classteacher_scores(String rollnumber, String name, float marks) {
		super();
		this.rollnumber = rollnumber;
		this.name = name;
		this.marks = marks;
	}
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
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	
}
