package datadriven;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
Row 1: "Java", "19", "Automation"
Row 2: "Python", "3", "Automation"
Row 3: "C#", "5", "Automation"
*/

//Excel File ---> Workbook ---> Sheets ---> Rows ---> Cells 

public class WritingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx"); //return current data folder
		
		XSSFWorkbook workbook=new XSSFWorkbook(); 	// Create workbook instance
		XSSFSheet sheet=workbook.createSheet("Data");    // Access the desired sheet (by name)
		
		XSSFRow row1=sheet.createRow(0);
			row1.createCell(0).setCellValue("JAVA");
			row1.createCell(1).setCellValue("19");
			row1.createCell(2).setCellValue("Automation");
			
		XSSFRow row2=sheet.createRow(1);
			row2.createCell(0).setCellValue("Python");
			row2.createCell(1).setCellValue("3");
			row2.createCell(2).setCellValue("Automation");
			
		XSSFRow row3=sheet.createRow(2);
			row3.createCell(0).setCellValue("C#");
			row3.createCell(1).setCellValue("5");
			row3.createCell(2).setCellValue("Automation");
			
		workbook.write(file);
		workbook.close();  //Close the workbook
		file.close();
		
		System.out.println("File is created.........");
		//System.out.println("File is created successfully at: " + filePath);

	}

}
