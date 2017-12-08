package com.example.demo;


//import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class attendance {

private Date date;
private String RollNumber;
private Boolean status;



public attendance(String RollNumber, Boolean status,Date date) {
	super();
	this.RollNumber = RollNumber;
	this.status = status;
     this.date=date;
	
}

public Date getDate() {

	return date;
}

public void setDate(Date date) {

       this.date = date;
}

public String getRollNumber() {
	return RollNumber;
}
public void setRollNumber(String RollNumber) {
	this.RollNumber = RollNumber;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}

}
