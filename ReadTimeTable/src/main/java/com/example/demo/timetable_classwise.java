package com.example.demo;

import java.util.List;

public class timetable_classwise {
	String Standard;
	String division;
	List<days> days;
	public timetable_classwise(String standard, String division, List<com.example.demo.days> days) {
		super();
		Standard = standard;
		this.division = division;
		this.days = days;
	}
	public String getStandard() {
		return Standard;
	}
	public void setStandard(String standard) {
		Standard = standard;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public List<days> getDays() {
		return days;
	}
	public void setDays(List<com.example.demo.days> days) {
		this.days = days;
	}
	

}
