package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity8_2 {

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver
		// WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the browser
		driver.get("https://training-support.net/selenium/tables");

		// Find the page title and print it
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);

		int row = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr")).size();
		System.out.println("Total number of rows " + row);
		int col = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th")).size();
		System.out.println("Total number of columns " + col);
		String S1=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText();
		System.out.println(" Value at 2rd row and 2nd column is "+S1);
		driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();
		String S2=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText();
		System.out.println(" Value at 2rd row and 2nd column after sort is "+S2);
		String S3=driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr")).getText();
		System.out.println(S3);
		
		

		// Close the browser
		driver.close();

	}

}