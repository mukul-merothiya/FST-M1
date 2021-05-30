package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity10_2 {

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver
		// WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action=new Actions(driver);

		// Open the browser
		driver.get("https://training-support.net/selenium/input-events");
		WebElement keypressed=driver.findElement(By.id("keyPressed"));

		// Find the page title and print it
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	Action actionsequence=action.sendKeys("M").build();
	actionsequence.perform();
		String S1=keypressed.getText();
		System.out.println("KeyPressed is "+S1);
		
		
        Action actionSequence2 = action
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build();
        actionSequence2.perform();
        String s2 = keypressed.getText();
        System.out.println("Pressed key is: " + s2);

		
		// Close the browser
		driver.close();

	}

}