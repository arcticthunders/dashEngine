package com.example.demo;

public class coursewise_audience {
	String rollnumner;
	String name;
	String standard;
	String division;
	float score;
	char grade;
	public coursewise_audience(String rollnumner, String name, String standard, String division, float score,
			char grade) {
		super();
		this.rollnumner = rollnumner;
		this.name = name;
		this.standard = standard;
		this.division = division;
		this.score = score;
		this.grade = grade;
	}
	public String getRollnumner() {
		return rollnumner;
	}
	public void setRollnumner(String rollnumner) {
		this.rollnumner = rollnumner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	

}
