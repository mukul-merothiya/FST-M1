package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity8 {
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
	public void exampleTestCase() throws InterruptedException {
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.id("moduleTab_9_Accounts")).click();
		Thread.sleep(2000);
		
		//System.out.println(driver.findElement(By.xpath("//form[@id='MassUpdate']/div/table/tbody/tr/td[3]/b/a")).getText());
		for (int i=1;i<10;i=i+2)
		{
		System.out.println(driver.findElement(By.xpath("//form[@id='MassUpdate']/div/table/tbody/tr["+i+"]/td[3]/b/a")).getText());
		}
		
		
		
	
	}


	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}