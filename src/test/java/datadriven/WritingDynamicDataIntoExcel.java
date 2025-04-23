package datadriven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File ---> Workbook ---> Sheets ---> Rows ---> Cells 

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile_dynamic.xlsx"); //return current data folder
		
		XSSFWorkbook workbook=new XSSFWorkbook(); 	// Create workbook instance
		XSSFSheet sheet=workbook.createSheet("DynamicData");    // Access the desired sheet (by name)
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter how many rows?");
		int noOfRows=sc.nextInt();
		
		System.out.println("Enter how many cells?");
		int noOfCells=sc.nextInt();
		
		for(int r=0; r<=noOfRows; r++)            //no of creating/rows //outer for loop
		{
			XSSFRow currentrow=sheet.createRow(r);  //created a new row
			
			for(int c=0; c<noOfCells; c++)           //no. of columns/cells  //inner for loop for creating cells in particular row
			{                                          // Loop through each cell in the row
				XSSFCell cell=currentrow.createCell(c);  //inside the row, created a new cell
				cell.setCellValue(sc.next());            //inside the cell, added data // Set the value in the cell
			}
		}
		
		workbook.write(file); //attach workbook to the file // Write workbook data to the file
		workbook.close();     // Close the workbook to release resources
		file.close();         // Close the file stream
		 
		System.out.println("File is created.........");

	}

}
