package project;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity1 {
	WebDriverWait wait;

	AndroidDriver<MobileElement> driver;

	@Test
	public void f() {

		String[] taskname = { "Complete Activity with Google Tasks", "Complete Activity with Google Keep",
				"Complete the second Activity Google Keep" };

		for (int i = 0; i < taskname.length; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
			driver.findElementByAccessibilityId("Create new task").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
			driver.findElementById("add_task_title").sendKeys(taskname[i]);
			driver.findElementById("add_task_done").click();
		}
			
	    //List<MobileElement> ObjectList = driver.findElementsById("content");
	    //System.out.println(ObjectList.size());
		
		String S1=driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();

		System.out.println(S1);
		assertEquals(S1,"Complete Activity with Google Keep");
		
		String S2=driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();

		System.out.println(S2);
		assertEquals(S2,"Complete Activity with Google Tasks");
		
		String S3=driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();

		System.out.println(S3);
		assertEquals(S3,"Complete the second Activity Google Keep");
		
		//driver.findElementById("tasks_list").
		
		wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("taskname"),3));
		List<MobileElement> tasksadded=driver.findElementsById("taskname");
		assertEquals(tasksadded.size(),3);
		assertEquals(tasksadded.get(2).getText(),"Complete Activity with Google Tasks");
		
		
	}

	

	


	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Pixel4Emulator");
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appPackage", "com.google.android.apps.tasks");
		desiredCapabilities.setCapability("appActivity", ".ui.TaskListsActivity");
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
