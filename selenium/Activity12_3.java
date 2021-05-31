package automationframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12_3 {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("https://www.training-support.net/selenium/popups");
driver.manage().window().maximize();
Actions builder = new Actions(driver);

//Check the title of the page
String title = driver.getTitle();
//Print the title of the page
System.out.println("Page title is: " + title);
WebElement button=driver.findElement(By.xpath("//button[@class='ui huge inverted orange button']"));

builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
String tooltipText = button.getAttribute("data-tooltip");
System.out.println("Tooltip text: " + tooltipText);
button.click();


//Wait for modal to appear
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

//Find username and pasword and fill in the details
driver.findElement(By.id("username")).sendKeys("admin");
Thread.sleep(1000);
driver.findElement(By.id("password")).sendKeys("password");
driver.findElement(By.xpath("//button[text()='Log in']")).click();

//Read the login message
String message = driver.findElement(By.id("action-confirmation")).getText();
System.out.println(message);
//Close browser
driver.close();


}
}
