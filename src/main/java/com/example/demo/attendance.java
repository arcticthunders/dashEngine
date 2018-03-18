package com.example.demo;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class attendance {

private Date date;
private String rollNumber;
private Boolean status;



public attendance(String rollNumber, Boolean status,Date date) {
	super();
	this.rollNumber = rollNumber;
	this.status = status;
     this.date=date;
	
}

public String getDate() {
	String date1=date.toString();
		return date1;
}

public void setDate(Date date)  {
	
       this.date = date;
}

public String getrollNumber() {
	return rollNumber;
}
public void setRollNumber(String rollNumber) {
	this.rollNumber = rollNumber;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}

}
