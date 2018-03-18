package com.example.demo;

import java.util.Date;
import java.util.List;

public class coursewise_assesments {
	String examname;
	Date date;
	float maxscore;
	float classavg;
    float classtop;
    List<coursewise_audience> audience;
	public coursewise_assesments(String examname, Date date, float maxscore, float classavg, float classtop,
			List<coursewise_audience> audience) {
		super();
		this.examname = examname;
		this.date = date;
		this.maxscore = maxscore;
		this.classavg = classavg;
		this.classtop = classtop;
		this.audience = audience;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(float maxscore) {
		this.maxscore = maxscore;
	}
	public float getClassavg() {
		return classavg;
	}
	public void setClassavg(float classavg) {
		this.classavg = classavg;
	}
	public float getClasstop() {
		return classtop;
	}
	public void setClasstop(float classtop) {
		this.classtop = classtop;
	}
	public List<coursewise_audience> getAudience() {
		return audience;
	}
	public void setAudience(List<coursewise_audience> audience) {
		this.audience = audience;
	}
    
    
}
