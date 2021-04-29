package TestNG_Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	WebDriver driver;
  @Test
  public void f1() {
	  String title= driver.getTitle();
	  Assert.assertEquals(title, "Target Practice");
  }
  @Test
  public void f2() {
	  //String s1=driver.findElement(By.xpath("//button[@class='ui black button']")).getText();
	  //System.out.println(s1);
	  WebElement blackbutton=driver.findElement(By.xpath("//button[@class='ui black button']"));
		  Assert.assertTrue(blackbutton.isDisplayed());
		  Assert.assertEquals(blackbutton.getText(), "black");
  }
  @Test(enabled=false)
  public void f3() {
	  System.out.println("This method should be skipped");
  
  }
  @Test
  public void f4() throws SkipException
  {
	    String condition ="Skip Test";

	    if(condition.equals("Skip Test")){
		throw new SkipException("Skipping - This is not ready for testing ");
	    }
	  
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		 //Open browser
	    driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterClass() {
	    //Close the browser
	    driver.quit();
  }

}
