package com.example.demo;



import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class timetableController {
private timetableRepository timerepo;

public timetableController(timetableRepository timerepo) {
	super();
	this.timerepo = timerepo;
}

@GetMapping("/{standard}/{division}")
@ResponseBody
public  timetable_classwise gettimetable(@PathVariable("standard") String standard,@PathVariable("division") String division) throws Exception{
	   
	   List<com.example.demo.days> days =new ArrayList<com.example.demo.days>();
	   
	   List<com.example.demo.timetable> time =  this.timerepo.findTimeTable(standard,division);
	   String read ="read";
	   for(int i=0;i<time.size();i++) 
	   { 
		   List<com.example.demo.slots> slots = new ArrayList<com.example.demo.slots>();
		   String day=time.get(i).getDay();
		   //System.out.println(day);
		   if(!(day.equals(read))) 
		   {
		   for(int j=0;j<time.size(); j++) 
		   {
		      String dayj = time.get(j).getDay();
		     
			   if(day.equals(dayj))
			   {
				  
				   com.example.demo.slots slts= new com.example.demo.slots(time.get(j).getTimeFrom(), time.get(j).getTimeTo(), time.get(j).getCourseId(), "", time.get(j).getTeacherId(), " ", " ");
				   slots.add(slts);
				   time.get(j).setDay(read);
			   }
			   
		   }
		   com.example.demo.days d = new com.example.demo.days(day, slots);
		   days.add(d);
	   }
	   }
	   com.example.demo.timetable_classwise timetable = new com.example.demo.timetable_classwise(standard, division, days);
	   
	   return timetable;
 }

@GetMapping("/{teacherid}")
@ResponseBody
public timetable_teacher getteachertimetable(@PathVariable("teacherid") String teacherId)throws Exception{
	  
	   List<com.example.demo.timetable> time =  this.timerepo.findTeacherTimeTable(teacherId);
	   List<com.example.demo.daysTeacher> days =new ArrayList<com.example.demo.daysTeacher>();
	   
	   int count=0;
	   String read = "read";
	   while(count<time.size()) {
		   List<com.example.demo.slotsTeacher> slots = new ArrayList<com.example.demo.slotsTeacher>();
		  String day=time.get(count).getDay();
		  if(!(day.equals(read))) 
		  {
		  for(int i=count;i<time.size();i++) 
			if(day.equals(time.get(i).getDay()))  
			{
				com.example.demo.slotsTeacher slts= new com.example.demo.slotsTeacher(time.get(i).getTimeFrom(), time.get(i).getTimeTo(), time.get(i).getCourseId(), "",time.get(i).getStandard(),time.get(i).getDivision(), "");
			    slots.add(slts);
			    time.get(i).setDay(read);
		    }
		    
		   com.example.demo.daysTeacher d=new com.example.demo.daysTeacher(day, slots);
		   days.add(d);
		  }  
		   count++;
	   }
	   com.example.demo.timetable_teacher timetable = new com.example.demo.timetable_teacher(teacherId, "", days);
	   
	   
	   
	   return timetable;
}
@GetMapping("/")
public String index() {
    return "upload";
}

@PostMapping("/uploadExcelFile")
protected void uploadFile(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException, Exception {
	  Part filePart = request.getPart("file");	
	  List<com.example.demo.timetable> timetable1 = new ArrayList<com.example.demo.timetable>();
	  HSSFWorkbook workbook  = new HSSFWorkbook(filePart.getInputStream());
		HSSFSheet sheet= workbook.getSheetAt(0);
		int rows=sheet.getPhysicalNumberOfRows();
		int columns =sheet.getRow(0).getLastCellNum();
	    String[] days=new String[] {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
	    ArrayList<LocalTime> timefrom = new ArrayList<LocalTime>();
	
	    ArrayList<LocalTime> timeto = new ArrayList<LocalTime>();		 
		HSSFRow row_one= sheet.getRow(0);
		String cellone=row_one.getCell(0).getStringCellValue();
		String[] class_details = cellone.split("-");
		String standard=class_details[0];
		String division =class_details[1];
		
		for(int k=1;k<columns;k++) {
			String value=row_one.getCell(k).getStringCellValue();
			String[] parts = value.split("-");
			timefrom.add(LocalTime.parse(parts[0]));
			timeto.add(LocalTime.parse(parts[1]));
		}
		
	
		for(int i=1;i<rows;i++) {
			HSSFRow row1= sheet.getRow(i);
			for(int k=1;k<columns;k++) {
				if(row1.getCell(k)==null)
				{
					int m=i+1;
					int n=k+1;
				   throw new Exception("empty cell found at [" + m + "," + n + "]");
			}
						}
		}
	
			for(int i=1;i<rows;i++) {
				HSSFRow row= sheet.getRow(i);
				for(int k=1;k<columns;k++) {
					String day=days[i-1];
					String values=row.getCell(k).getStringCellValue();
					String parts1[]=values.split("-");
					String course_id=parts1[0];
					String teacher_id=parts1[1];
					LocalTime time_from=timefrom.get(k-1);
					LocalTime time_to=timeto.get(k-1);
				
						timetable t=new timetable(day,course_id,time_from,time_to,standard,division,teacher_id);
						workbook.close();
						timetable1.add(t);
					
						
					this.timerepo.deleteAll();
					this.timerepo.save(timetable1);
				}
				
			}

		




}

}
