package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity7 {
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
		
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='adspan_e3b6f9f3-b87c-2486-fa8c-6061ba037e94']/span")).click();
		Thread.sleep(3000);
	    String s1=driver.findElement(By.xpath("//span[@class='phone']")).getText();
		//System.out.println(driver.switchTo().alert().getText());
		
		
		System.out.println(s1);
		
	
	}


	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}