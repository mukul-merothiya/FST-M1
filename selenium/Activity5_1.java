package automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity5_1 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        //WebDriver driver = new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
        Boolean x1=driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed();
        System.out.println("CheckBox is displayed: "+x1);
        driver.findElement(By.id("toggleCheckbox")).click();
        Boolean x2=driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed();
        System.out.println("CheckBox is displayed: "+x2);

       
        //Close the browser
        driver.close();

    }

}