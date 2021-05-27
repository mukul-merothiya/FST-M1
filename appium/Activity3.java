package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
	WebDriverWait wait;

	AndroidDriver<MobileElement> driver;

	@Test
	public void f() {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
        driver.findElementById("new_note_button").click();
//wait.until(ExpectedConditions.elementToBeSelected(MobileBy.id("editable_title")));
driver.findElementById("editable_title").sendKeys("Test Title");
driver.findElementById("edit_note_text").sendKeys("Sample Notes");

driver.findElementById("menu_reminder").click();
driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView").click();

wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("save")));
driver.findElementById("save").click();
driver.findElementByAccessibilityId("Navigate up").click();
driver.findElementByAccessibilityId("Open navigation drawer").click();
driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.ImageView").click();
String S=driver.findElementById("index_note_title").getText();
System.out.println(S);
assertEquals(S,"Test Title");

		
	}

	

	


	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Pixel4Emulator");
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appPackage", "com.google.android.keep");
		desiredCapabilities.setCapability("appActivity", ".activities.BrowseActivity");
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
