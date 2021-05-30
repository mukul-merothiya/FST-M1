package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity10_1 {

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver
		// WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action=new Actions(driver);

		// Open the browser
		driver.get("https://training-support.net/selenium/input-events");

		// Find the page title and print it
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		WebElement cube=driver.findElement(By.id("wrapD3Cube"));
		action.click(cube);
		WebElement cubeval=driver.findElement(By.className("active"));
		String S1=cubeval.getText();
		System.out.println("Left Click "+S1);
		
		action.doubleClick(cube).perform();
		WebElement cubeval1=driver.findElement(By.className("active"));
		String S2=cubeval1.getText();
		System.out.println("Double Click "+S2);
		
		action.contextClick(cube).perform();
		WebElement cubeval2=driver.findElement(By.className("active"));
		String S3=cubeval2.getText();
		System.out.println("Double Click "+S3);
		

		
		// Close the browser
		driver.close();

	}

}