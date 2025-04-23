package webTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		//1) Find the total numbers of rows in a table(1st approach)
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();  //multiple table on web page use this approach to find single table
		//System.out.println("number of rows:" +rows); //7
		
		//List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")); 
	    //System.out.println("Number of rows: " + rows.size());
	     
	    //3rd approach- Alternative approach: Using tag name// this is counting the rows from all the tables which are present in your web page 
	    //int rows=driver.findElements(By.tagName("tr")).size();     //single table on your web page
	    //System.out.println("number of rows:" +rows);

//============================================================================================================
		
		//2) Find the total numbers of columns in a table
		
		int columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size(); 
		//System.out.println("number of columns:" +columns); //7
		
		//Alternative approach: Using tag name
		//int columns=driver.findElements(By.tagName("tr")).size();  //single table 
		//System.out.println("number of columns:" +columns); //19
		
//============================================================================================================	
		
		// 3) Read data from specific row and column
		//String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		//System.out.println(bookName); //Master In Selenium
		
		//capture last row and 3rd column(Javascript)
		String book=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[3]")).getText();// just change row no. & column no. tr and td
		//System.out.println(book);     //Javascript
		
//============================================================================================================
		
		// 4) Read data from All the row and columns
		
		/*System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "price"); //print header part column names approach 1
		
		// Print headers dynamically  approach 2
		for (int c = 1; c <= columns; c++) {
		    String header = driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th[" + c + "]")).getText();
		    System.out.print(header + "\t");
		
		//using nested for loop
		for(int r=2;r<=rows;r++)    //outer for loop repeating the rows // Outer loop for rows
		{
			for(int c=1;c<=columns;c++)  //inner for loop repeating the columns // Inner loop for columns
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ r +"]//td["+ c +"]")).getText();// Use dynamic XPath to locate the table cell
				System.out.print(value+ "\t");  // Print the cell value with a tab space for alignment
			}
			System.out.println(); // New line after each row
		}
//============================================================================================================	
		
		//5) Print all Author names from a Table Using Loops (conditional based)
		
		for(int r=2;r<=rows;r++)
		{
			String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ r +"]//td[2]")).getText();
			System.out.println(authorName);
		}
//============================================================================================================	
		
		//5) Print Author name mukesh from a Table Using Loops (conditional based)
		
		for(int r=2;r<=rows;r++)
		{
			String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ r +"]//td[2]")).getText();
			if(authorName.equals("Mukesh"))
			{
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ r +"]//td[1]")).getText();
				System.out.println(bookName + "\t" + authorName);
			}
	    } */ 
//============================================================================================================
		
		//6) Find total price of all the book
		
		int total=0;
		for(int r=2;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ r +"]//td[4]")).getText();
			total=total+Integer.parseInt(price);
		}
		System.out.println("Total price of the books:" +total);

}}
