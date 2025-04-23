package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadDataFromExcelDemo {

	public static void main(String[] args) throws IOException {
		
		 // Dynamically capture the Excel file path from the project directory
        String filePath = System.getProperty("user.dir") + "\\testdata\\data.xlsx";

        // Open the Excel file in read mode
        FileInputStream file = new FileInputStream(filePath);

        // Load the workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Access the desired sheet by name
        XSSFSheet sheet = workbook.getSheet("sheet1");

        // Get the total number of rows and cells in the sheet
        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(0).getLastCellNum();

        // Print the summary of the sheet
        System.out.println("********** Excel Data Summary **********");
        System.out.println("Total Rows: " + totalRows);     //5
        System.out.println("Total Columns: " + totalCells); //4
        System.out.println("****************************************");
        System.out.println("Reading Excel Data:\n");

        // Print the header row (column names)
        XSSFRow headerRow = sheet.getRow(0);
        for (int c = 0; c < totalCells; c++) 
        {
            XSSFCell cell = headerRow.getCell(c);
            System.out.printf("%-20s", (cell != null ? cell.toString() : "NULL")); // Left-align with width 20
        }
        System.out.println();

        // Print a separator line
        System.out.println("--------------------------------------------------------------------");

        // Read data using nested loops (rows and columns)
        for (int r = 1; r <= totalRows; r++) // Start from row 1 (skip the header row)
        { 
            XSSFRow currentRow = sheet.getRow(r);
            if (currentRow != null) 
            {
                for (int c = 0; c < totalCells; c++) 
                {
                    XSSFCell cell = currentRow.getCell(c);
                    System.out.printf("%-20s", (cell != null ? cell.toString() : "NULL")); // Left-align with width 20
                }
                System.out.println(); // New line after each row
            }
        }

        // Close the workbook and file stream
        workbook.close();
        file.close();

	}

}
