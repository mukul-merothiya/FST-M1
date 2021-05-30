package automationframework;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity11_2 {

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver
		// WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the browser
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		// Find the page title and print it
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		WebElement confirm=driver.findElement(By.id("confirm"));
		confirm.click();
		Alert confirmalert=driver.switchTo().alert();
		
		String s1=confirmalert.getText();
		System.out.println(s1);
		confirmalert.accept();
		

        //Close the browser with Cancel
        //confirmalert.dismiss();
 
		
		
		// Close the browser
		driver.close();

	}

}