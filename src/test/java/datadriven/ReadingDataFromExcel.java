package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Scenario:
 * ==========
 * This program reads data from an Excel file and prints it in a structured format.
 * It is useful in Data-Driven Testing, where test data is maintained externally 
 * in an Excel sheet rather than being hardcoded into test scripts.
 *
	 * Steps:
	 * 1. Open an Excel file (.xlsx) using Apache POI in reading mode.
	 * 2. Navigate to the desired sheet. Access the workbook and a specific sheet.
	 * 3. Read and print the total number of rows and columns.
	 * 4. Use nested for loops to read and print data
	 * 5. Extract and display data in a properly formatted table.
	 * 6. Close the workbook and file after processing.
 */

//Excel File ---> Workbook ---> Sheets ---> Rows ---> Cells 

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

//=================================================================================================================================
// Approach 1: Open the file in read mode 
//=================================================================================================================================
		
		//String filePath = "testdata/data.xls"; 
        //FileInputStream file = new FileInputStream(filePath);
        
		// *Load the Excel file*
		//FileInputStream file = new FileInputStream("C:\\Users\\ASUS\\eclipse-workspace\\webdriver-fundamentals\\testdata\\data.xlsx");
		
// =================================================================================================================================
// Approach 1: Capture absolute path of the Excel file dynamically // Open the Excel file in read mode
// =================================================================================================================================
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx"); //return current data folder
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);   // Create/Load workbook instance
		XSSFSheet sheet = workbook.getSheet("sheet1");    // Access the desired sheet (by name)
		//XSSFSheet sheet = workbook.getSheetAt(0);       // Alternative: Access by index (0-based) Sheet1
			
		// Get the total number of rows and cells in the sheet
		int totalRows=sheet.getLastRowNum();              // Last row index
		int totalCells=sheet.getRow(0).getLastCellNum();  // Total columns in first row
// =================================================================================================================================	
		// Print the summary of the sheet
        System.out.println("********** Excel Data Summary **********");
        System.out.println("Total Rows: " + totalRows);     //5
        System.out.println("Total Columns: " + totalCells); //4
        System.out.println("****************************************");
        System.out.println("Reading Excel Data:\n");
		
        //-------------------------------------------------------
        // Print the header row with proper spacing/formatting (column names)
        //-------------------------------------------------------
        XSSFRow headerRow = sheet.getRow(0); // Fetch the first row (headers)
        for (int c = 0; c < totalCells; c++) 
        {
            XSSFCell cell = headerRow.getCell(c);
            System.out.printf("%-20s", (cell != null ? cell.toString() : "NULL")); // Left-align with width 20
        }
        System.out.println();

        // Print a separator line
        System.out.println("--------------------------------------------------------------------");
		
// =================================================================================================================================
// Read data using nested loops (through all rows and columns)
// =================================================================================================================================
        
        // Loop through rows
        for (int r = 1; r <= totalRows; r++)             //outer for loop, rows/ incrementing/repeat the row 0-5 // Skip header row (start from 1)
		{
			XSSFRow currentRow = sheet.getRow(r);     	 //Extract r-row no. // Get the current row 
			
			// Loop through columns
			for (int c = 0; c < totalCells; c++)         //inner for loop, columns/ repeat the column 0-4 
			{
				XSSFCell cell = currentRow.getCell(c);   //c- cell no. // Get the cell at column `c` // Get the cell value
				System.out.printf("%-20s", (cell != null ? cell.toString() : "NULL")); // Left-align with width 20
				//System.out.print(cell.toString() + "\t"); // Print cell data-extracting the data // Print cell value with tab space 
			}
			
			System.out.println(); // Print a new line after each row
		}
		
		workbook.close();  //Close the workbook/resources
		file.close();
		
		// Indicate successful execution
        System.out.println("\nExcel Data Read Successfully!");
	}

}
