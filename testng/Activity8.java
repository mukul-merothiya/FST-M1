package TestNG_Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] { { "admin", "password" } };
	}

	@Test(dataProvider = "Authentication")

	public void f(String username, String password) {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String message = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals("Welcome Back, admin", message);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// Open browser
		driver.get("https://www.training-support.net/selenium/login-form");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		// Close the browser
		driver.quit();
	}

}
