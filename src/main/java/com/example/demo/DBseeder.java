/*
package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBseeder implements CommandLineRunner {
	private AttendanceRepository attrepo;
	static List<com.example.demo.attendance> attendance1 = new ArrayList<com.example.demo.attendance>(
			
			);
	public DBseeder (AttendanceRepository attrepo) {
		this.attrepo=attrepo;
	}
	

	



	@Override
	public void run(String... arg0) throws Exception,FileNotFoundException, IOException {
    	
		
		//String url="jdbc:mysql://localhost:3306/accelerate_dash";
		//String userName="root";
		//String password="Jafry@123";
		
		
		
		
    	
    	
	    String excelFilePath = "/home/rithvik/Desktop/excel.xls";
        FileInputStream file = new FileInputStream(new File(excelFilePath));
		
		//FileInputStream file = new FileInputStream(new File("excel.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet= workbook.getSheetAt(0);
		int length=sheet.getPhysicalNumberOfRows();
		//HSSFRow row= sheet.getRow(1);
	
		System.out.println(length);
	
		
	
			for(int i=0;i<length;i++) {
				HSSFRow row= sheet.getRow(i);
				String rno=row.getCell(0).getStringCellValue();
				Boolean stat=row.getCell(1).getBooleanCellValue();
				Date date=row.getCell(2).getDateCellValue();
				
			 
			attendance e = new attendance(rno,stat,date);
			
			/*
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(url,userName,password);   
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT * FROM students_masterlist");  
				while(rs.next())  
				{ 
					System.out.println(rs.getString(1));
					
					if((rs.getString(1)).equals((e.getRollNumber()))) {
						System.out.println(e.getRollNumber());
						attendance1.add(e);
					}
				  		
				}
				con.close();  
				}catch(Exception ex){ System.out.println(ex);}  
			*/
		/*
				workbook.close();
				attendance1.add(e);
		this.attrepo.deleteAll();	
	  this .attrepo.save(attendance1);

		   
		 */
	    	
	    	
	    	
	    /*	
	    		
			
			
		}
		
		

	
	
	 while(rs.next())
	 	{
			  	if(rs.getString(2)==e.getRollNumber())
			  		attendance1.add(e);
			}
	 
   
	
	
}
	
}
*/

