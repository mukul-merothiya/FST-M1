package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity4 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
	}

	@Test
	public void exampleTestCase() {
    boolean s1=driver.findElement(By.id("tab0")).isDisplayed();
    //System.out.println(s1);
    if(s1==true)
    {
    	System.out.println("THIS IS HOME PAGE");
    }
    //String title=driver.getTitle();
    //System.out.println(title);
    



	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}