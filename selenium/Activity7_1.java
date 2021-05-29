package automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        //WebDriver driver = new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,20);

        //Open the browser
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");

        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class,'password')]")).sendKeys("password");
driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
String s1=driver.findElement(By.id("action-confirmation")).getText();
System.out.println(s1);



    
        
        


       
        //Close the browser
        driver.close();

    }

}