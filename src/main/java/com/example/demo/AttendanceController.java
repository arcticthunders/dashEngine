package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.Connection;






@Controller

public class AttendanceController extends HttpServlet {
	
	private static final long serialVersionUID = -1999869522797487110L;
	private AttendanceRepository attRepo;
    
	String url="jdbc:mysql://localhost:3306/accelerate_dash";
	String userName="root";
	String password="Jafry@123";

	public AttendanceController(AttendanceRepository attRepo) {
		super();
		this.attRepo = attRepo;
	}

	 @GetMapping("/attendance")
	 @ResponseBody
	    public List<com.example.demo.attendance> getAll(){
	    	
			List<com.example.demo.attendance> att =  this.attRepo.findAll();

	        return att;
	    }
	    /*
	    @GetMapping("/{rno}")
	    @ResponseBody
	    public List<com.example.demo.attendance> get(@PathVariable("rno") String rno) {
	    	
			List<com.example.demo.attendance> att =  this.attRepo.find(rno);

	        return att;
	    }
	    */
	    
	  
		
		@GetMapping("/{rno}/{dateF}/{dateT}")
	    @ResponseBody
	    public com.example.demo.AttendanceRollNumber get(@PathVariable("rno") String rno,@PathVariable("dateF") String dateF,@PathVariable("dateT") String dateT) throws Exception {
	    	  SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
			   
			   Date date1=formatter1.parse(dateF);
			   Date date2=formatter1.parse(dateT);
			List<com.example.demo.attendance> att =  this.attRepo.findRnoDateBetween(rno,date1,date2);
			int attCount=att.size();
			
			List<String> absentDays = new ArrayList<String>();
			for (int i=0; i<att.size();i++) {
		absentDays.add(att.get(i).getDate().toString());
			}
			com.example.demo.AttendanceRollNumber e=new com.example.demo.AttendanceRollNumber(rno,dateF,dateT,attCount,absentDays);
		

	        return  e;
	    }
	    
	    
	   /* @GetMapping("/{rno}")
	    @ResponseBody
	    public JSONArray get(@PathVariable("rno") String rno) {
	    	
	    	List<com.example.demo.attendance> att1 =  this.attRepo.find(rno);
	    	

	        return att;
	    }
	    */
	    
	    @PostMapping("/uploadExcelFile")
		  protected void uploadFile(HttpServletRequest request,
	              HttpServletResponse response) throws ServletException, IOException,Exception {
			  Part filePart = request.getPart("file");
			  HSSFWorkbook workbook  = new HSSFWorkbook(filePart.getInputStream());				
			  HSSFSheet sheet= workbook.getSheetAt(0);
				int length=sheet.getPhysicalNumberOfRows();
				//HSSFRow row= sheet.getRow(1);
				List<com.example.demo.attendance> attendance1 = new ArrayList<com.example.demo.attendance>();
				System.out.println(length);
				
				for(int i=1;i<length;i++) {
					HSSFRow row1= sheet.getRow(i);
		
					for(int k=0;k<3;k++) {
						if(row1.getCell(k)==null)
						{
							int m=i+1;
							int n=k+1;
						   throw new Exception("empty cell found at [" + m + "," + n + "]");
					}
						
								}
				}
					for(int i=0;i<length;i++) {
						HSSFRow row= sheet.getRow(i);
						String rno=row.getCell(0).getStringCellValue();
						Boolean stat=row.getCell(1).getBooleanCellValue();
						Date date=row.getCell(2).getDateCellValue();
						
					 
					attendance e = new attendance(rno,stat,date);
				
						workbook.close();
						attendance1.add(e);
				this.attRepo.deleteAll();	
			  this .attRepo.save(attendance1);

				   
				 
			    	
			    	
			    	
			    	
			    		
					
					
				}
				
			  
	    }
	    
	    @GetMapping("/")
	    public String index() {
	        return "upload";
	    }
	
	    
	   @GetMapping("/{dateFrom}/{dateTo}")
	   @ResponseBody
	   public com.example.demo.AttendanceDateRange getRange(@PathVariable("dateFrom") String dateFrom,@PathVariable("dateTo") String dateTo) throws Exception{
		   SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		   
		   Date date1=formatter1.parse(dateFrom);
		   Date date2=formatter1.parse(dateTo);
		   List<com.example.demo.attendance> att =  this.attRepo.findDateBetween(date1,date2);
		   List<com.example.demo.dayWiseList> attdayList = new  ArrayList<com.example.demo.dayWiseList>();
		  
		   Date today = new Date();
		   Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		   int count=0;
		   int counter=0;
		   while(att.size()>count) {
			   
			   List<com.example.demo.absenteeList> attList = new  ArrayList<com.example.demo.absenteeList>();
				  counter=0;
				 
			   String date =att.get(count).getDate();
			   String rno=att.get(count).getrollNumber();
			  
			   for(int i=count;i<att.size();i++)
				  
			   {   
				   if(date.equals(att.get(i).getDate()) && !(date.equals(tomorrow.toString())) ) {
					   
					   com.example.demo.absenteeList abLs=new com.example.demo.absenteeList(att.get(i).getrollNumber(), "", "", "", 0);
					   attList.add(abLs);
					att.get(i).setDate(tomorrow);
					counter++;
					
					   
					
				   }
				   
			   }
			   if(counter!=0)
			   {
			   com.example.demo.dayWiseList dwLs=new com.example.demo.dayWiseList(date, "", counter, attList);
			  
			   attdayList.add(dwLs);
			   
			   
			   }
			   count++;
			 
		   }
		   com.example.demo.AttendanceDateRange att1= new com.example.demo.AttendanceDateRange(dateFrom, dateTo, attdayList);
		   return att1;
	    }
	 
	
}