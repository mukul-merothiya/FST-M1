package project;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Activity6 {
	WebDriverWait wait;

	AndroidDriver<MobileElement> driver;

	@Test
	public void f() {
		driver.get("https://www.training-support.net/selenium");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.view.View[2][@text='Selenium']")));

		MobileElement title = driver.findElementByXPath("//android.view.View[2][@text='Selenium']");
		String pageTitle = title.getText();
		System.out.println("The page Title is: " + pageTitle);
		Assert.assertEquals(pageTitle, "Selenium");

		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]").click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
		MobileElement popUpTitle = driver.findElementByXPath("//android.view.View[2][@text='Popups']");
		String popUpPagetTitle = popUpTitle.getText();
		System.out.println("The page Title is: " +popUpPagetTitle);
		Assert.assertEquals(popUpPagetTitle, "Popups");

		driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//android.widget.Button[@text='Log in']")));
		driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("admin");
		driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password");
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();

		String LoginMsg = driver.findElementByXPath("//android.view.View[1]/android.view.View[4]").getText();      
		System.out.println(LoginMsg); 

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//android.widget.Button[@text='Log in']")));

		driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("s");
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Sign In')]")));

		System.out.println(LoginMsg); 
		
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
