package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	WebDriverWait wait;

	AndroidDriver<MobileElement> driver;


	@Test
	public void f() {
		
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net/selenium");
		
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
    	
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
        driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("taskInput")));
		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys("Add tasks to list");
		driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys("Get number of tasks");
		driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys("Clear the list");
		driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
		
		driver.findElementByXPath("//android.view.View[@text='Add tasks to list']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@text='Get number of tasks']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@text='Clear the list']").click();
		
		
		//driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Add tasks to list')]")).click();
		//driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Get number of tasks')]")).click();
		//driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Clear the list')]")).click();
		
		//.findElement(MobileBy.xpath("//android.view.View[contains(@text,'Clear List')]")).click();
		MobileElement clearListBtn = driver.findElementByXPath("//android.view.View[3][@class='android.view.View']");
		clearListBtn.click();
		
		
		
		
		
		
       
        
        
	}

	

	


	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Pixel4Emulator");
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appPackage", "com.android.chrome");
		desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		desiredCapabilities.setCapability("noReset", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		wait = new WebDriverWait(driver, 10);
	}

	@AfterClass
	public void tearDown() {
		// close the application
		driver.quit();
	}
}
