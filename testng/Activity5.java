package TestNG_Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;

	@Test(groups = { "HeaderTests", "ButtonTests" })
	public void pageTitleTest() {

		System.out.println("New page title is: " + driver.getTitle());

		Assert.assertEquals(driver.getTitle(), "Target Practice");
	}

	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
	public void headerTest() {

		String s1 = driver.findElement(By.id("third-header")).getText();

		Assert.assertEquals(s1, "Third header");
	}

	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
	public void buttonTest1() {

		String s2 = driver.findElement(By.xpath("//button[@class='ui olive button']")).getText();

		Assert.assertEquals(s2, "Olive");
	}

	@Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
	public void buttonTest2() {

		WebElement button2 = driver.findElement(By.xpath("//button[@class='ui brown button']"));
		Assert.assertEquals(button2.getCssValue("color"), "rgba(255, 255, 255, 1)");
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// Open browser
		driver.get("https://www.training-support.net/selenium/target-practice");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		// Close the browser
		driver.quit();
	}

}
