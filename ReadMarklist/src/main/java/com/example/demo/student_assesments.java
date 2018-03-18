package com.example.demo;

import java.util.Date;

public class student_assesments {
	String testName;
	Date testDate;
	float maxscore;
	float score;
	char grade;
	float classavg;
	float classTop;
	String teacherComments;
	Boolean parentAcknowledgementStatus;
	String parentComments;
	public student_assesments(String testName, Date testDate, float maxscore, float score, char grade, float classavg,
			float classTop, String teacherComments, Boolean parentAcknowledgementStatus, String parentComments) {
		super();
		this.testName = testName;
		this.testDate = testDate;
		this.maxscore = maxscore;
		this.score = score;
		this.grade = grade;
		this.classavg = classavg;
		this.classTop = classTop;
		this.teacherComments = teacherComments;
		this.parentAcknowledgementStatus = parentAcknowledgementStatus;
		this.parentComments = parentComments;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	public float getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(float maxscore) {
		this.maxscore = maxscore;
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
	public float getClassavg() {
		return classavg;
	}
	public void setClassavg(float classavg) {
		this.classavg = classavg;
	}
	public float getClassTop() {
		return classTop;
	}
	public void setClassTop(float classTop) {
		this.classTop = classTop;
	}
	public String getTeacherComments() {
		return teacherComments;
	}
	public void setTeacherComments(String teacherComments) {
		this.teacherComments = teacherComments;
	}
	public Boolean getParentAcknowledgementStatus() {
		return parentAcknowledgementStatus;
	}
	public void setParentAcknowledgementStatus(Boolean parentAcknowledgementStatus) {
		this.parentAcknowledgementStatus = parentAcknowledgementStatus;
	}
	public String getParentComments() {
		return parentComments;
	}
	public void setParentComments(String parentComments) {
		this.parentComments = parentComments;
	}
	
	

}
