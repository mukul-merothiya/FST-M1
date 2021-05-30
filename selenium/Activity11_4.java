package automationframework;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity11_4 {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the browser
		driver.get("https://www.training-support.net/selenium/tab-opener");

		// Find the page title and print it
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		String s1=driver.getWindowHandle();
		System.out.println("Parent Window "+s1);
		
		driver.findElement(By.linkText("Click Me!")).click();
		
		Set<String> handles=driver.getWindowHandles();
		System.out.println("All window handles: " + handles);
		
        //Loop through each handle
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
 
        //Print the handle of the current window
        System.out.println("Current window handle: " + driver.getWindowHandle());
 
        //Wait for page to load completely
        wait.until(ExpectedConditions.titleIs("Newtab"));
 
        //Print New Tab Title
        System.out.println("New Tab Title is: " + driver.getTitle());
 
        //Get heading on new page
        String newTabText = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("New tab heading is: " + newTabText);
 
        //Open Another Tab
        driver.findElement(By.linkText("Open Another One!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
 
        //Make sure the new tab's handle is part of the handles set
        handles = driver.getWindowHandles();
        System.out.println("All window handles: " + handles);
 
        //Loop through the handles set till we get to the newest handle
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
 
        //Print the handle of the current window
        System.out.println("New tab handle: " + driver.getWindowHandle());
 
        //Wait for the newest tab to load completely
        wait.until(ExpectedConditions.titleIs("Newtab2"));
 
        //Print New Tab Title
        System.out.println("New Tab Title is: " + driver.getTitle());
 
        //Get heading on new page
        newTabText = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("New tab heading is: " + newTabText);
		
		

 
		
		
		// Close the browser
		driver.close();

	}

}