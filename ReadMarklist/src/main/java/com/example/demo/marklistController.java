package com.example.demo;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
public class marklistController extends HttpServlet {
	
	
	 
	  String url="jdbc:mysql://148.66.152.246/dash_hmyhss";
		String userName="anasjafry";
		String password="Abhijith@1993";
	
	private static final long serialVersionUID = 1L;
	private marklistRepository markrepo;

	public marklistController(marklistRepository markrepo) {
		super();
		this.markrepo = markrepo;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public com.example.demo.student_marklist get_mark_course(@PathVariable("id") String id)throws Exception{
		
		
		List<marklist> mark =  this.markrepo.findMarkCourseID(id);
		int counter=0;

		
		ArrayList<String> standard = new ArrayList<String>();
		 ArrayList<String> division = new ArrayList<String>();
		 ArrayList<String> course_id = new ArrayList<String>();
		 ArrayList<String> teacher_id = new ArrayList<String>();
		 ArrayList<String> testname = new ArrayList<String>();
		 ArrayList<Float> maxscore = new ArrayList<Float>();
		 ArrayList<Float> classavg = new ArrayList<Float>();
		 ArrayList<Float> topmark = new ArrayList<Float>();
		 ArrayList<Date> dateofexam = new ArrayList<Date>();
		 String studentname=null;
		 String parentname=null;
		 String parentnumber=null;
		 String std=null;
		 String div=null;
		 String classteacherid=null;
		 String classteachername=null;
		 
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,userName,password);   
	
			
				      Statement s2 = con.createStatement();
				      while(counter<mark.size()) 
				      {
				    	    int exam_id=mark.get(counter).getExamid();
				    	  	s2.execute("SELECT * FROM `d_exammasterlist` WHERE `examid`= '"+ exam_id + "'" );    
				    	  	ResultSet rs2 = s2.getResultSet(); // 
				    	  	while ( rs2.next() )
				    	  	{ 

								standard.add(rs2.getString(2));
								division.add(rs2.getString(3));
								course_id.add(rs2.getString(4));
						        teacher_id.add(rs2.getString(5));
						        testname.add(rs2.getString(6));
						        maxscore.add(rs2.getFloat(7));
						        classavg.add(rs2.getFloat(8));
						        topmark.add(rs2.getFloat(9));
						        dateofexam.add(rs2.getDate(10));
				    	  	}
				    	  	System.out.println(id);
				    	  	counter++;
				      
				      }
				      
				      s2.execute("SELECT * FROM `d_studentsmasterlist` WHERE `roll`= '"+ id + "'" ); 
				      ResultSet rs3 = s2.getResultSet();
				      while(rs3.next()) 
				      {
				      std=rs3.getString(3);
				      div=rs3.getString(4);
				      studentname=rs3.getString(4) + rs3.getString(5);
				      parentnumber=rs3.getString(13);
				      } 
				     
				      
				      s2.execute("SELECT * FROM `d_parentsmasterlist` WHERE `parentId`= '"+ parentnumber + "'" );
				      ResultSet rs4 = s2.getResultSet();
				      while(rs4.next()) 
				      parentname=rs4.getString(1);
				    
				      
				      s2.execute("SELECT * FROM `d_classmasterlist` WHERE `class`= '"+ std + "'AND `division`= ' " + div + "'"  );
				      ResultSet rs5= s2.getResultSet();
				      while(rs5.next())
				      classteacherid=rs5.getString(3);
				      System.out.println( classteacherid);
				      
				      s2.execute("SELECT * FROM `d_teachersmasterlist` WHERE `teacherId`= '"+ classteacherid + "'" );
				      ResultSet rs6= s2.getResultSet();
				      while(rs6.next())
				      classteachername= rs6.getString(2) + rs6.getString(3);
				      System.out.println( classteachername);
				     
			        
			con.close();  
			}catch(Exception ex){ System.out.println(ex);} 		
		
		   
		   List<com.example.demo.student_courses> courses =new ArrayList<com.example.demo.student_courses>();
		   int count=0;
		   String read ="read";
		   while(count<mark.size())
		   {   
			   List<com.example.demo.student_assesments> assesments =new  ArrayList<com.example.demo.student_assesments>();
			   String courseid=course_id.get(count);
			   String teacherid =teacher_id.get(count);
			   if(!(courseid.equals(read)))
			 {	   
				   
			   for(int i=count;i<mark.size();i++)
			   {  
				
			    	  if(courseid.equals(course_id.get(i)))
			    		 
			      {
			    	  com.example.demo.student_assesments a = new com.example.demo.student_assesments(testname.get(i),dateofexam.get(i),maxscore.get(i), mark.get(i).getMark(),'A',classavg.get(i),topmark.get(i)," ",false," ");
			          course_id.set(i, read);
			    	  assesments.add(a);
			      }
			      
			   } 
			   
			 }
			   com.example.demo.student_courses c = new com.example.demo.student_courses(courseid, " ", teacherid, " ", assesments);
			   
			   courses.add(c);
			 
			count++;   
		   }
		   com.example.demo.student_marklist marklist = new com.example.demo.student_marklist(id, studentname, parentname, parentnumber, std, div, classteacherid, classteachername, courses);		   
		   
		   return marklist;
		
		
		
		
		
		/*
		
		int[] examid=null;
		String[] standard = null;
		 String[] division = null;
		 String[] course_id = null;
		 String[] teacher_id = null;
		 String[] testname = null;
		 Double[] maxscore = null;
		 Double[] classavg = null;
		 Double[] topmark = null;
		 Date[] dateofexam = null;
		 
		int count=0;
		int i=0;
		
		
		 try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(url,userName,password);   
		
				
					      Statement s2 = con.createStatement();
					      s2.execute("SELECT * FROM `d_exammasterlist` WHERE `course_id`=id ");    
					      ResultSet rs2 = s2.getResultSet(); // 
					      while ( rs2.next() ){
					        examid[count] = rs2.getInt(1);
							standard[count]=rs2.getString(2);
							division[count]=rs2.getString(3);
							course_id[count]=rs2.getString(4);
					        teacher_id[count]=rs2.getString(5);
					        testname[count]=rs2.getString(6);
					        maxscore[count]=rs2.getDouble(7);
					        classavg[count]=rs2.getDouble(8);
					        topmark[count]=rs2.getDouble(9);
					        dateofexam[count]=rs2.getDate(10);
					        count++;
					      }
					      System.out.println(id);
					     
				        
				con.close();  
				}catch(Exception ex){ System.out.println(ex);} 		
		
		 List<exammarklist> marklist_main=new ArrayList<exammarklist>(); 
		 List<com.example.demo.student_courses> courses =new ArrayList<com.example.demo.student_courses>();
		   while(i<count)
		   {
			 exammarklist m =this.markrepo.findMarkCourseID(examid[count]);
			 
			 String read ="read";
		   }
		   
		   */
	
		  
		   //List<exammarklist> mark =  this.markrepo.findMarkCourseID(id);
		   
		   /*
		   
		   List<com.example.demo.student_courses> courses =new ArrayList<com.example.demo.student_courses>();
		   int count=0;
		   String read ="read";
		   while(count<mark.size())
		   {   
			   List<com.example.demo.student_assesments> assesments =new  ArrayList<com.example.demo.student_assesments>();
			   String rollNumber = mark.get(count).getStudent_id();
			   String courseid=mark.get(count).getCourse_id();
			   if(!(rollNumber.equals(read)) && !(courseid.equals(read)))
			 {	   
				   
			   for(int i=count;i<mark.size();i++)
			   {  
				 
			      if(rollNumber.equals(mark.get(i).getStudent_id()))
			    	  if(courseid.equals(mark.get(i).getCourse_id()))
			    		 
			      {
			    	  com.example.demo.student_assesments a = new com.example.demo.student_assesments(mark.get(i).getTestname(), new Date(), mark.get(i).getMaxscore(), mark.get(i).getMark(),' ', mark.get(i).getMaxscore(), mark.get(i).getMaxscore(), " ", false, " ");
			    	  mark.get(i).setStudent_id(read);
			    	  mark.get(i).setCourse_id(read);
			    	  assesments.add(a);
			      }
			      
			   } 
			   
			 }
			   com.example.demo.student_courses c = new com.example.demo.student_courses(courseid, " ", mark.get(count).getTeacher_id(), " ", assesments);
			   
			   courses.add(c);
			 
			count++;   
		   }
		   com.example.demo.student_marklist marklist = new com.example.demo.student_marklist(id, " ", " ", " ", " ", " ",  " ", " ", courses);		   
		   
		   return marklist;
		   */
	}
	
	

	@RequestMapping(value = "/{standard}/{division}/{testname}", method = RequestMethod.GET)
	@ResponseBody
	public com.example.demo.classteacher_marklist getMarklist(@PathVariable("standard") String standard, @PathVariable("division") String division ,  @PathVariable("testname") String testname)
	{
		
       int counter=0;
        List<Integer> examid= new ArrayList<Integer>();
		ArrayList<String> std = new ArrayList<String>();
		 ArrayList<String> div = new ArrayList<String>();
		 ArrayList<String> course_id = new ArrayList<String>();
		 ArrayList<String> teacher_id = new ArrayList<String>();
		 ArrayList<String> test_name = new ArrayList<String>();
		 ArrayList<Float> maxscore = new ArrayList<Float>();
		 ArrayList<Float> classavg = new ArrayList<Float>();
		 ArrayList<Float> topmark = new ArrayList<Float>();
		 ArrayList<Date> dateofexam = new ArrayList<Date>();
		 String classteacherid=null;
		  String classteachername=null;
		  List<com.example.demo.classteacher_courses> courses = new ArrayList<com.example.demo.classteacher_courses>();
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,userName,password);   
	
			
				      Statement s2 = con.createStatement();
				 
				    	    
				    	  	s2.execute("SELECT * FROM `d_exammasterlist` WHERE `division`='" + division + "' AND  `standard`= '" + standard  +"' AND  `testname`='" +testname +"'" );    
				    	  	ResultSet rs2 = s2.getResultSet(); 
				    	  	while ( rs2.next() )
				    	  	{ 
                                examid.add(rs2.getInt(1));
								std.add(rs2.getString(2));
								div.add(rs2.getString(3));
								course_id.add(rs2.getString(4));
						        teacher_id.add(rs2.getString(5));
						        test_name.add(rs2.getString(6));
						        maxscore.add(rs2.getFloat(7));
						        classavg.add(rs2.getFloat(8));
						        topmark.add(rs2.getFloat(9));
						        dateofexam.add(rs2.getDate(10));
						        counter++;
				    	  	}
				    	  	
				    	  	
				    	  
				    		
				    		int count=0;
				    		while(count<counter) 
				    		{
				    	    String courseid=course_id.get(count);
				    		List<com.example.demo.classteacher_scores> scores = new ArrayList<com.example.demo.classteacher_scores>();		
				    		List<marklist> mark =  this.markrepo.findExamid(examid.get(count));
				    		 for(int i=0;i<mark.size();i++)
				    		   { 
				    			 String name = null;
				    			 s2.execute("SELECT * FROM `d_studentsmasterlist` WHERE  `roll`='" + mark.get(i).getStudent_id() + "' ");
				    			 ResultSet rs3 = s2.getResultSet(); 
				    			 while(rs3.next())
				    				 name = rs3.getString(5) + " " + rs3.getString(6);
				    			 com.example.demo.classteacher_scores s= new com.example.demo.classteacher_scores(mark.get(i).getStudent_id(), name, mark.get(i).getMark());
				    			 scores.add(s);
				    		   }
				    		 
				    		
				    		 if(!scores.isEmpty())
				    			{
				    			 String course_name = null;
				    			 s2.execute("SELECT `name` FROM `d_coursemasterlist` WHERE   `courseId`='" + courseid + "' ");
				    			 ResultSet rs4 = s2.getResultSet(); 
				    			 while(rs4.next())
				    				 course_name=rs4.getString(1);
				    			com.example.demo.classteacher_courses c = new com.example.demo.classteacher_courses(courseid, course_name, maxscore.get(count) , scores);
				    			courses.add(c);
				    			}
				    			count++;
				    		
				    		}
				    		   s2.execute("SELECT * FROM `d_classmasterlist` WHERE `class`= '"+ standard + "'AND `division`= ' " + division + "'"  );
							      ResultSet rs5= s2.getResultSet();
							      
								while(rs5.next())
							      classteacherid=rs5.getString(3);
							      
							      s2.execute("SELECT * FROM `d_teachersmasterlist` WHERE `teacherId`= '"+ classteacherid + "'" );
							      ResultSet rs6= s2.getResultSet();
							    
								while(rs6.next())
							      classteachername= rs6.getString(2) + rs6.getString(3);
				    		
				   
		     
			        
			con.close();  
			}catch(Exception ex){ System.out.println(ex);} 	
	
		com.example.demo.classteacher_marklist marklist = new com.example.demo.classteacher_marklist(standard, division, classteacherid, classteachername, testname , courses);
		return marklist;	
  
	}
	
		
		
	// code for mongo 07/03/18
		/*
		List<com.example.demo.classteacher_courses> courses = new ArrayList<com.example.demo.classteacher_courses>();
		int count=0;
		while(count<counter) 
		{
	    String courseid=course_id.get(count);
		List<com.example.demo.classteacher_scores> scores = new ArrayList<com.example.demo.classteacher_scores>();		
		List<marklist> mark =  this.markrepo.findExamid(examid.get(count));
		 for(int i=0;i<mark.size();i++)
		   { 
			 com.example.demo.classteacher_scores s= new com.example.demo.classteacher_scores(mark.get(i).getStudent_id(), " ", mark.get(i).getMark());
			 scores.add(s);
		   }
		 
		
		 if(!scores.isEmpty())
			{
			com.example.demo.classteacher_courses c = new com.example.demo.classteacher_courses(courseid, " ", maxscore.get(count) , scores);
			courses.add(c);
			}
			count++;
		
		}
		com.example.demo.classteacher_marklist marklist = new com.example.demo.classteacher_marklist(standard, division, " ", " ", testname , courses);
		return marklist;
		
		*/
		
		/*
		List<com.example.demo.classteacher_courses> courses = new ArrayList<com.example.demo.classteacher_courses>();
		int count =0;
		String read="read";
		while(count<counter)
		{   
			List<com.example.demo.classteacher_scores> scores = new ArrayList<com.example.demo.classteacher_scores>();
		
			String courseid=course_id.get(count);
			if(!(courseid.equals(read)))
			{
				 for(int i=count;i<counter;i++)
				   { 
					
					 if(standard.equals(mark.get(i).getStandard()))
						 if(division.equals(mark.get(i).getDivision()))
							 if(courseid.equals(mark.get(i).getCourse_id()))
						 {
							 com.example.demo.classteacher_scores s= new com.example.demo.classteacher_scores(mark.get(i).getStudent_id(), " ", mark.get(i).getMark());
							 mark.get(i).setStandard(read);
							 mark.get(i).setDivision(read);
							 scores.add(s);
							 
						 }
				   }
				 
				 
			}
			if(!scores.isEmpty())
			{
			com.example.demo.classteacher_courses c = new com.example.demo.classteacher_courses(courseid, " ",(float) 40.0 , scores);
			courses.add(c);
			}
			count++;
			
		}
		com.example.demo.classteacher_marklist marklist = new com.example.demo.classteacher_marklist(standard, division, " ", " ", testname , courses);
		return marklist;
		*/
		
	
	
	
	@RequestMapping(value = "/{teacherid}/{courseid}", method = RequestMethod.GET)
	@ResponseBody
	public  com.example.demo.coursewise_marklist getmarks(@PathVariable("courseid") String courseid, @PathVariable("teacherid") String teacherid)
	{
		
		int counter=0;
        List<Integer> examid= new ArrayList<Integer>();
		ArrayList<String> std = new ArrayList<String>();
		 ArrayList<String> div = new ArrayList<String>();
		 ArrayList<String> course_id = new ArrayList<String>();
		 ArrayList<String> teacher_id = new ArrayList<String>();
		 ArrayList<String> test_name = new ArrayList<String>();
		 ArrayList<Float> maxscore = new ArrayList<Float>();
		 ArrayList<Float> classavg = new ArrayList<Float>();
		 ArrayList<Float> topmark = new ArrayList<Float>();
		 ArrayList<Date> dateofexam = new ArrayList<Date>();
		
		
		 try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(url,userName,password);   
		
				
					      Statement s2 = con.createStatement();
					 
					    	    
					    	  	s2.execute("SELECT * FROM `d_exammasterlist` WHERE `course_id`='" + courseid + "' AND  `teacher_id`= '" + teacherid  +"'" );    
					    	  	ResultSet rs2 = s2.getResultSet(); 
					    	  	while ( rs2.next() )
					    	  	{ 
	                                examid.add(rs2.getInt(1));
									std.add(rs2.getString(2));
									div.add(rs2.getString(3));
									course_id.add(rs2.getString(4));
							        teacher_id.add(rs2.getString(5));
							        test_name.add(rs2.getString(6));
							        maxscore.add(rs2.getFloat(7));
							        classavg.add(rs2.getFloat(8));
							        topmark.add(rs2.getFloat(9));
							        dateofexam.add(rs2.getDate(10));
							        counter++;
					    	  	}
					    	  
					    	  	
					      
					   
					     
				        
				con.close();  
				}catch(Exception ex){ System.out.println(ex);}	
	  	System.out.print(counter);
		List<com.example.demo.coursewise_assesments> assesments = new ArrayList<com.example.demo.coursewise_assesments>();
		int count=0;
		while(count<counter)
		{   
			List<com.example.demo.coursewise_audience> audience = new ArrayList<com.example.demo.coursewise_audience>();
			List<marklist> mark =  this.markrepo.findExamid(examid.get(count));
				 for(int i=0;i<mark.size();i++)
				   { 
						 
							com.example.demo.coursewise_audience a=new com.example.demo.coursewise_audience(mark.get(i).getStudent_id(), " " , std.get(count),div.get(count), mark.get(i).getMark(), 'A');
							 audience.add(a);
					
				   }
	
			if(!audience.isEmpty())
			{
			com.example.demo.coursewise_assesments c = new com.example.demo.coursewise_assesments(test_name.get(count), dateofexam.get(count), maxscore.get(count), classavg.get(count) ,topmark.get(count), audience);
			assesments.add(c);
			}
			count++;
			
		}
		com.example.demo.coursewise_marklist marklist = new com.example.demo.coursewise_marklist(teacherid, " ", courseid, " " , assesments);
		return marklist;
		
		
		/*
        List<com.example.demo.marklist> mark =  this.markrepo.findmarkteacher(teacherid,courseid);
		
		List<com.example.demo.coursewise_assesments> assesments = new ArrayList<com.example.demo.coursewise_assesments>();
		int count =0;
		String read="read";
		while(count<mark.size())
		{   
			List<com.example.demo.coursewise_audience> audience = new ArrayList<com.example.demo.coursewise_audience>();
		
			String examname = mark.get(count).getTestname();
			if(!(mark.get(count).getStandard().equals(read)))
			{
				 for(int i=count;i<mark.size();i++)
				   { 
						 if(teacherid.equals(mark.get(i).getTeacher_id()))
							 if(courseid.equals(mark.get(i).getCourse_id()))
								 if(examname.equals(mark.get(i).getTestname()))
						 {
							com.example.demo.coursewise_audience a=new com.example.demo.coursewise_audience(mark.get(i).getStudent_id(), " " , mark.get(i).getStandard(), mark.get(i).getDivision(), mark.get(i).getMark(), 'A');
							 mark.get(i).setStandard(read);
							 audience.add(a);
							 
						 }
				   }
				 
				 
			}
			if(!audience.isEmpty())
			{
			com.example.demo.coursewise_assesments c = new com.example.demo.coursewise_assesments(examname, new Date(), mark.get(count).getMaxscore(), 10, 10, audience);
			assesments.add(c);
			}
			count++;
			
		}
		com.example.demo.coursewise_marklist marklist = new com.example.demo.coursewise_marklist(teacherid, " ", courseid, " " , assesments);
		return marklist;
		*/
		
	}
	
	
	
	
	
	  @GetMapping("/")
	    public String index() {
	        return "upload";
	    }
	
	
	  
	
	  
	  @PostMapping("/uploadExcelFile")
	  protected void uploadFile(HttpServletRequest request,
              HttpServletResponse response) throws ServletException, IOException, Exception{
		  Part filePart = request.getPart("file");
		 
			
            int id=0;
			String standard=request.getParameter("standard");
			String division =request.getParameter("division");
			String course_id=request.getParameter("course_id");
			String teacher_id=request.getParameter("teacher_id");
			String testname=request.getParameter("testname");
			String maxscore=request.getParameter("maxscore");
			float maxScore =Float.parseFloat(maxscore);
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		  
		  try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(url,userName,password);   
			
				  String query = "INSERT INTO `d_exammasterlist`(`examid`, `standard`, `division`, `course_id`, `teacher_id`, `testname`, `max_marks`, `class_avg`, `top_marks`, `dateofexam`)"
					        + " VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ? )";

					      // create the mysql insert preparedstatement
					      PreparedStatement preparedStmt = con.prepareStatement(query);
					      preparedStmt.setString (1, "");
					      preparedStmt.setString (2, standard);
					      preparedStmt.setString   (3, division);
					      preparedStmt.setString(4, course_id);
					      preparedStmt.setString    (5, teacher_id);
					      preparedStmt.setString    (6, testname);
					      preparedStmt.setFloat(7, maxScore);  
					      preparedStmt.setFloat    (8, 0);
					      preparedStmt.setFloat    (9, 0);
					      preparedStmt.setDate    (10, date);
					      

					      // execute the preparedstatement
					      preparedStmt.execute();
				
					      Statement s2 = con.createStatement();
					      s2.execute("SELECT MAX(examid) FROM d_exammasterlist");    
					      ResultSet rs2 = s2.getResultSet(); // 
					      while ( rs2.next() ){
					        id = rs2.getInt(1);
					      }
					      System.out.println(id);
					      
				
					     
				        
				con.close();  
				}catch(Exception ex){ System.out.println(ex);} 
		  
		  
		  
	     
	      List<com.example.demo.marklist> marklist1= new ArrayList<com.example.demo.marklist>();
			
			//FileInputStream file = new FileInputStream(new File("excel.xls"));
	      HSSFWorkbook workbook  = new HSSFWorkbook(filePart.getInputStream());
			HSSFSheet sheet= workbook.getSheetAt(0);
			int rows=sheet.getPhysicalNumberOfRows();
		
			for (int i=1;i<rows;i++) {
				HSSFRow row=sheet.getRow(i);
				if(row.getCell(1)==null) {
					int m=i+1;
					int n=2;
				   throw new Exception("empty cell found at [" + m + "," + n + "]");
				}
			}
			for (int i=1;i<rows;i++) {
				HSSFRow row=sheet.getRow(i);
				String student_id=row.getCell(0).getStringCellValue();
				float mark=(float) row.getCell(1).getNumericCellValue();
				marklist m=new marklist(id,student_id,mark);
				workbook.close();
				marklist1.add(m);
				//this.markrepo.deleteAll();
				
				
			}
					
			this.markrepo.save(marklist1);
			
			  
			  try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(url,userName,password);   
				
						      
						      float sum=0;
						      
						      List<marklist> mark =  this.markrepo.findExamid(id);
						      float max= mark.get(0).getMark();
						      for(int k=0;k<mark.size();k++)
						      {
						    	  sum+=mark.get(k).getMark();
						    	  if(mark.get(k).getMark()>max)
						    		  max=mark.get(k).getMark();
						      }
						      float avg=sum/mark.size();
						     //  1
						      
						      Statement stmt = null;
						      stmt = con.createStatement();
						      String sql = "UPDATE `d_exammasterlist` SET `class_avg`='" + avg  +"' ,`top_marks`= '" + max+ "' WHERE `examid`='" + id  +"'" ;
						      stmt.executeUpdate(sql);					      
						      /*
						              String query2= "UPDATE `d_exammasterlist` SET `class_avg`=? AND `top_marks`=?  WHERE `examid`=? ";
						    		  PreparedStatement preparedstatement = con.prepareStatement(query2);
						    		  preparedstatement.setFloat(1,avg );  
						    		  preparedstatement.setFloat    (2, max);
						    		  preparedstatement.setInt(3, id); 
						    		  preparedstatement.executeUpdate();
						     */
					        
					con.close();  
					}catch(Exception ex){ System.out.println(ex);} 
			

	  }
	

}
