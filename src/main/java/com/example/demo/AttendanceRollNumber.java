package com.example.demo;

import java.util.Date;
import java.util.List;

public class AttendanceRollNumber {
	String rollNumber;
	String dateFrom;
	String dateTo;
	int absentCount;
	List<String> absentDays;
	
	
	public AttendanceRollNumber(String rollNumber, String dateFrom, String dateTo, int absentCount, List<String> absentDays) {
		super();
		this.rollNumber = rollNumber;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.absentCount = absentCount;
		this.absentDays = absentDays;
	}

	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public int getAbsentCount() {
		return absentCount;
	}
	public void setAbsentCount(int absentCount) {
		this.absentCount = absentCount;
	}
	public List<String> getAbsentDays() {
		return absentDays;
	}
	public void setAbsentDays(List<String> absentDays) {
		this.absentDays = absentDays;
	}
	
	

}
