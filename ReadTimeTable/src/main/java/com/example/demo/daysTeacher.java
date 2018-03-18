package com.example.demo;

import java.util.List;

public class daysTeacher {
	String day;
	List<slotsTeacher> slots;
	public daysTeacher(String day, List<slotsTeacher> slots) {
		super();
		this.day = day;
		this.slots = slots;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public List<slotsTeacher> getSlots() {
		return slots;
	}
	public void setSlots(List<slotsTeacher> slots) {
		this.slots = slots;
	}
	

}
