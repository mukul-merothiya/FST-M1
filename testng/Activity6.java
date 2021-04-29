package TestNG_Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver;
	
  @Test
  @Parameters({"username", "password"})
  public void f() {
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  String message=driver.findElement(By.id("action-confirmation")).getText();
	    Assert.assertEquals("Welcome Back, admin",message);
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		 //Open browser
	    driver.get("https://www.training-support.net/selenium/login-form");
	    driver.manage().window().maximize();
	   
	    
  }

  @AfterClass
  public void afterClass() {
	    //Close the browser
	    driver.quit();
  }

}
