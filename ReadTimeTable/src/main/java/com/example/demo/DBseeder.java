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
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBseeder implements CommandLineRunner {
	private timetableRepository timerepo;
	static List<com.example.demo.timetable> timetable1 = new ArrayList<com.example.demo.timetable>(
			
			);
	public DBseeder (timetableRepository timerepo) {
		this.timerepo=timerepo;
	}
	

	




	@SuppressWarnings("deprecation")
	@Override
	public void run(String... arg0) throws Exception,FileNotFoundException, IOException {
    	
		
		//String url="jdbc:mysql://localhost:3306/accelerate_dash";
		//String userName="root";
		//String password="Jafry@123";
		
		
		
		
    	
    	
	    String excelFilePath = "/home/rithvik/Desktop/timetable.xls";
        FileInputStream file = new FileInputStream(new File(excelFilePath));
		
		
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet= workbook.getSheetAt(0);
		int rows=sheet.getPhysicalNumberOfRows();
		int columns =sheet.getRow(0).getLastCellNum();
	    String[] days=new String[] {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
	    ArrayList<String> timefrom = new ArrayList<String>();
	
	    ArrayList<String> timeto = new ArrayList<String>();		 
		HSSFRow row_one= sheet.getRow(0);
		String cellone=row_one.getCell(0).getStringCellValue();
		String[] class_details = cellone.split("-");
		String standard=class_details[0];
		String division =class_details[1];
		
		for(int k=1;k<columns;k++) {
			String value=row_one.getCell(k).getStringCellValue();
			String[] parts = value.split("-");
			timefrom.add(parts[0]);
			timeto.add(parts[1]);
		}
	
			for(int i=1;i<rows;i++) {
				HSSFRow row= sheet.getRow(i);
				for(int k=1;k<columns;k++) {
					String day=days[i-1];
					String values=row.getCell(k).getStringCellValue();
					String parts1[]=values.split("-");
					String course_id=parts1[0];
					String teacher_id=parts1[1];
					String time_from=timefrom.get(k-1);
					String time_to=timeto.get(k-1);
					timetable t=new timetable(day,course_id,time_from,time_to,standard,division,teacher_id);
					workbook.close();
					timetable1.add(t);
					
					this.timerepo.deleteAll();
					this.timerepo.save(timetable1);
				}
				
			}
	}}
	
*/
