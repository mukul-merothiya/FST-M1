package automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_12_2 {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("https://www.training-support.net/selenium/nested-iframes");
driver.manage().window().maximize();

//Check the title of the page
String title = driver.getTitle();
//Print the title of the page
System.out.println("Page title is: " + title);
driver.switchTo().frame(0);
driver.switchTo().frame(0);


//Get heading text in iFrame
WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
System.out.println(frameHeading1.getText());

//Switch back to parent page
driver.switchTo().defaultContent();

//Switch to first iFrame on the page
driver.switchTo().frame(0);

//Switch to second iFrame in that frame
driver.switchTo().frame(1);

//Get heading text in iFrame
WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
System.out.println(frameHeading2.getText());

//Close browser
driver.close();


}
}
