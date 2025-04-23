package datadriven;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInSpecificCellAndRow {

	public static void main(String[] args) throws IOException {
		
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile_random.xlsx"); //return current data folder
		
		XSSFWorkbook workbook=new XSSFWorkbook(); 	// Create workbook instance
		XSSFSheet sheet=workbook.createSheet("RandomData");    // Access the desired sheet (by name)
		
		XSSFRow row=sheet.createRow(3);
		XSSFCell cell=row.createCell(4);
		
		cell.setCellValue("WELCOME"); 
	
		workbook.write(file); //attach workbook to the file // Write workbook data to the file
		workbook.close();     // Close the workbook to release resources
		file.close();         // Close the file stream
		 
		System.out.println("File is created.........");


	}

}
