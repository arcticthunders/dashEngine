package com.example.demo;

import java.util.List;

public class AttendanceDateRange {
	
	String dateF;
	String DateT;
	List<com.example.demo.dayWiseList> daywise;
	public AttendanceDateRange(String dateF, String dateT, List<dayWiseList> daywise) {
		super();
		this.dateF = dateF;
		DateT = dateT;
		this.daywise = daywise;
	}
	public String getDateF() {
		return dateF;
	}
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}
	public String getDateT() {
		return DateT;
	}
	public void setDateT(String dateT) {
		DateT = dateT;
	}
	public List<dayWiseList> getDaywise() {
		return daywise;
	}
	public void setDaywise(List<dayWiseList> daywise) {
		this.daywise = daywise;
	}
	
	

}
 