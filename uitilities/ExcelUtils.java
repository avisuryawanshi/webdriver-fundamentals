package uitilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fi;     // For reading files
	public static FileOutputStream fo;    // For writing files
	public static XSSFWorkbook wb;        // For representing the workbook
	public static XSSFSheet ws;           // For representing the sheet
	public static XSSFRow row;            // For representing rows
	public static XSSFCell cell;          // For representing cells
	public static CellStyle style;        // For applying styles to cells

	
//--------- Method to get the number of rows in a sheet--------------------------------------------------
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);    // Open file in read mode
		wb=new XSSFWorkbook(fi);           // Load the workbook
		ws=wb.getSheet(xlsheet);           // Access the specified sheet
		int rowcount=ws.getLastRowNum() ;  // Get the last row number
		wb.close();                        // Close the workbook
		fi.close();                        // Close the file input stream
		return rowcount;	               // Return the row count
	}
	
//----------- Method to get the number of cells in a specific row------------------------------------------
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException 
	{
	    fi=new FileInputStream(xlfile);     // Open the file in read mode
	    wb=new XSSFWorkbook(fi);            // Load the workbook
	    ws=wb.getSheet(xlsheet) ;           // Access the specified sheet
	    row=ws.getRow(rownum);              // Get the specified row
	    int cellcount=row.getLastCellNum(); // Get the last cell number (cell count)
	    wb.close();                         // Close the workbook
	    fi.close();                         // Close the file input stream
	    return cellcount;                   // Return the cell count
	}
	
//------------ Method to get cell data as String-------------------------------------------------------------------
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException 
	{
	    fi=new FileInputStream (xlfile);    // Open the file in read mode
	    wb=new XSSFWorkbook(fi);            // Load the workbook
	    ws=wb.getSheet(xlsheet) ;           // Access the specified sheet
	    row=ws.getRow(rownum);              // Get the specified row
	    cell=row.getCell(colnum);           // Get the specified cell
	    
	    String data;
    try {
	    	//data=cell.toString();  
	    	DataFormatter formatter = new DataFormatter(); // Option 1: Using DataFormatter
		    data = formatter.formatCellValue(cell); // Handles various cell data types // This may throw an exception if the cell is empty
	    }
   catch(Exception e)
        {
	       data=" ";                         // Default value in case of exception // Assign an empty string if an exception occurs
	    }
    	wb.close();                          // Close the workbook
	    fi.close();                          // Close the file input stream
	    return data;                         // Return the cell data
	}
	
//------------- Method to set cell data-----------------------------------------------------------------------------------------
	
	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException
	{
	    fi=new FileInputStream(xlfile);      // Open file for reading
	    wb=new XSSFWorkbook(fi);             // Load workbook
	    ws=wb.getSheet(xlsheet);             // Get the sheet
	    row=ws.getRow(rownum);               // Get the row
	    
	    cell=row.createCell(colnum);         // Create cell
	    cell.setCellValue(data);             // Set cell value
	   
	    fo=new FileOutputStream(xlfile);     // Open file for writing
	    wb.write(fo);                        // Write changes to file
	    wb.close();                          // Close workbook
	    fi.close();                          // Close the input stream
	    fo.close();                          // Close output stream
	}

//-------------- Method to fill a cell with green color---------------------------------------------------------------------
	
	/*public static void fillGreenColor (String xlfile, String xlsheet, int rownum, int colnum) throws IOException 
	{
	    fi=new FileInputStream(xlfile);
	    wb=new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row=ws.getRow(rownum);
	    cell=row.getCell(colnum);
	    
	    style=wb.createCellStyle();
	    
	    style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); //default method
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    cell.setCellStyle(style);
	    wb.write(fo);
	    wb.close();
	    fi.close();            //Close input stream before opening output stream
	    fo.close();
	}*/

	 public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
	        FileInputStream fi = null;
	        FileOutputStream fo = null;
	        XSSFWorkbook wb = null;

	        try {
	            fi = new FileInputStream(xlfile);
	            wb = new XSSFWorkbook(fi);
	            XSSFSheet ws = wb.getSheet(xlsheet);
	            XSSFRow row = ws.getRow(rownum);
	            if (row == null) row = ws.createRow(rownum);
	            XSSFCell cell = row.getCell(colnum);
	            if (cell == null) cell = row.createCell(colnum);

	            CellStyle style = wb.createCellStyle();
	            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            cell.setCellStyle(style);

	            fi.close(); // Close input stream before writing to the output stream

	            fo = new FileOutputStream(xlfile);
	            wb.write(fo);
	        } finally {
	            if (fi != null) fi.close();
	            if (fo != null) fo.close();
	            if (wb != null) wb.close();
	        }
	    }
//--------------- Method to fill a cell with red color------------------------------------------------------------------
	
	/*public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
	    fi=new FileInputStream(xlfile);
	    wb=new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row=ws.getRow(rownum);
	    cell=row.getCell(colnum);
	    
	    style=wb.createCellStyle();
	    
	    style.setFillForegroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
	    wb.write(fo);
	    wb.close();
	    fi.close();   // Close input stream before opening output stream
	    fo.close();

}*/
	 
	 public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
	        FileInputStream fi = null;
	        FileOutputStream fo = null;
	        XSSFWorkbook wb = null;

	        try {
	            fi = new FileInputStream(xlfile);
	            wb = new XSSFWorkbook(fi);
	            XSSFSheet ws = wb.getSheet(xlsheet);
	            XSSFRow row = ws.getRow(rownum);
	            if (row == null) row = ws.createRow(rownum);
	            XSSFCell cell = row.getCell(colnum);
	            if (cell == null) cell = row.createCell(colnum);

	            CellStyle style = wb.createCellStyle();
	            style.setFillForegroundColor(IndexedColors.RED.getIndex());
	            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            cell.setCellStyle(style);

	            fi.close(); // Close input stream before writing to the output stream

	            fo = new FileOutputStream(xlfile);
	            wb.write(fo);
	        } finally {
	            if (fi != null) fi.close();
	            if (fo != null) fo.close();
	            if (wb != null) wb.close();
	        }
	    }


}
