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

public class Activity5 {
	WebDriverWait wait;

	AndroidDriver<MobileElement> driver;


	@Test
	public void f() throws InterruptedException {
		
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net/selenium");
		
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
    	
        //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingForward()"));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"Login // Form\")")).click();
        //driver.findElementByXPath("//android.view.View[contains(@text,'Login Form')]").click();
        
        //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"Login Form\"))")).click();
        driver.findElementByXPath("//android.view.View[contains(@text,'Login Form')]").click(); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
        //driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("username"))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("username")));
        //driver.findElementById("username").sendKeys("admin");
        //driver.findElementById("password").sendKeys("password");
        //driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
        
		driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys("admin");
		driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("password");
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
        //String s=driver.findElementById("action-confirmation").getText();
        //assertEquals(s,"Welcome Back,admin");
		//wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("action-confirmation")));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				String LoginMsg = driver.findElementByXPath("//android.view.View[contains(@resource-id,'action-confirmation')]").getText();      
		System.out.println(LoginMsg);     
		
		assertEquals(LoginMsg,"Welcome Back, admin");
        
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
		//driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//android.widget.Button[@text='Log in']")));
		
		driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").clear();
		driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys("s");
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
        //String s2=driver.findElementById("action-confirmation").getText();
        //assertEquals(s2,"Invalid Credentials");
		
		Thread.sleep(200);
		String LoginMsg2 = driver.findElementByXPath("//android.view.View[contains(@resource-id,'action-confirmation')]").getText();      
		System.out.println(LoginMsg2);
		assertEquals(LoginMsg2,"Invalid Credentials");

        
        
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
