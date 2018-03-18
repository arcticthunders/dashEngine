package com.example.demo;

import java.util.List;

public class classteacher_courses {
 String courseid;
 String coursename;
 float maxmarks;
 List<classteacher_scores> scores;
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
public float getMaxmarks() {
	return maxmarks;
}
public void setMaxmarks(float maxmarks) {
	this.maxmarks = maxmarks;
}
public List<classteacher_scores> getScores() {
	return scores;
}
public void setScores(List<classteacher_scores> scores) {
	this.scores = scores;
}
public classteacher_courses(String courseid, String coursename, float maxmarks, List<classteacher_scores> scores) {
	super();
	this.courseid = courseid;
	this.coursename = coursename;
	this.maxmarks = maxmarks;
	this.scores = scores;
}
 
}
