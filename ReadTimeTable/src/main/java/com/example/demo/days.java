package com.example.demo;

import java.util.List;

public class days {
	String day;
	List<slots> slots;
	public days(String day, List<com.example.demo.slots> slots) {
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
	public List<slots> getSlots() {
		return slots;
	}
	public void setSlots(List<com.example.demo.slots> slots) {
		this.slots = slots;
	}
	

}
