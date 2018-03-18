package com.example.demo;

import java.util.List;

public class dayWiseList {
	
	String date;
	String day;
	int absenteeCount;
	List<com.example.demo.absenteeList> absenteeList;
	public dayWiseList(String date, String day, int absenteeCount, List<com.example.demo.absenteeList> absenteeList) {
		super();
		this.date = date;
		this.day = day;
		this.absenteeCount = absenteeCount;
		this.absenteeList = absenteeList;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getAbsenteeCount() {
		return absenteeCount;
	}
	public void setAbsenteeCount(int absenteeCount) {
		this.absenteeCount = absenteeCount;
	}
	public List<com.example.demo.absenteeList> getAbsenteeList() {
		return absenteeList;
	}
	public void setAbsenteeList(List<com.example.demo.absenteeList> absenteeList) {
		this.absenteeList = absenteeList;
	}
	
	

}
