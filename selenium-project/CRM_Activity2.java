package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity2 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the chrome driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();
	}

	@Test
	public void exampleTestCase() {
		// Check the url of image on the page
		WebElement url=driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/img"));
		System.out.println("Src attribute is: "+ url.getAttribute("src"));



	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}