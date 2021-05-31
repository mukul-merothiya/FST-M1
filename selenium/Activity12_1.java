package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity12_1 {

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver
		// WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the browser
		driver.get("https://training-support.net/selenium/iframes");

		// Find the page title and print it
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		driver.switchTo().frame(0);
		//Perform operation on the first frame
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());
        
    	
        //Click button in iFrame 1
        WebElement button1 = driver.findElement(By.cssSelector("button"));
        System.out.println(button1.getText());
        System.out.println(button1.getCssValue("background-color"));
        button1.click();
 
        //Print New Button Info
        System.out.println(button1.getText());
        System.out.println(button1.getCssValue("background-color"));
 
        //Switch back to parent page
        driver.switchTo().defaultContent();
 
        //Switch to second iFrame on the page
        driver.switchTo().frame(1);
 
        //Perform operation on the second frame
        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading2.getText());
 
        //Click button in iFrame 2
        WebElement button2 = driver.findElement(By.cssSelector("button"));
        System.out.println(button2.getText());
        System.out.println(button2.getCssValue("background-color"));
        button2.click();
 
        //Print New Button Info
        System.out.println(button2.getText());
        System.out.println(button2.getCssValue("background-color"));
 
        //Switch back to parent page
        driver.switchTo().defaultContent();
 

		
		// Close the browser
		driver.close();

	}

}