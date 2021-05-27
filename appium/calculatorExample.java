package examples;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class calculatorExample {
	AndroidDriver<MobileElement> driver;
	
  @Test
  public void additionTest() {
	  
	  //find digit 5 and click
	  MobileElement digit5=driver.findElementById("digit_5");
	  digit5.click();
	  //find + sign and click
	  driver.findElementByAccessibilityId("plus").click();
	  //find digit 5 again and click
	  driver.findElementById("digit_5").click();
	  //find equal sign and click
	  driver.findElementByAccessibilityId("equals").click();
	  //find result and get text and print
	  String s1=driver.findElementById("result").getText();
	  System.out.println(s1);
	  //assertion to compare the result with expected value
	  assertEquals(s1,"10");
	  
  }
  @BeforeClass
  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "Pixel4Emulator");
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", ".Calculator");
	    desiredCapabilities.setCapability("noReset", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
  }

  @AfterClass
  public void tearDown() {
	  //close the application
	  driver.quit();
  }

}
