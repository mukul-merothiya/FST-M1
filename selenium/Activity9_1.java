package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity9_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the browser
	
		 driver.get("https://training-support.net/selenium/selects");
		 
	        //WebElement selectedValue = driver.findElement(By.id("single-value"));
	        //WebElement selectValue = driver.findElement(By.id("single-select"));
	        Select dropDown = new Select(driver.findElement(By.id("single-select")));
	        dropDown.selectByVisibleText("Option 2");
	        WebElement option = dropDown.getFirstSelectedOption();
	        String defaultItem = option.getText();

	        System.out.println(defaultItem );
	        
	        

	        Thread.sleep(2000);
	        
	        dropDown.selectByIndex(3);
	        WebElement option2 = dropDown.getFirstSelectedOption();
	        String defaultItem2 = option2.getText();

	        System.out.println(defaultItem2 );
	       
	        dropDown.selectByValue("4");
	        WebElement option3 = dropDown.getFirstSelectedOption();
	        String defaultItem3 = option3.getText();

	        System.out.println(defaultItem3 );
	        
	      //Get all options
	        List<WebElement> options = dropDown.getOptions();
	        //Print them
	        for(WebElement option4 : options) {
	            System.out.println("Option: " + option4.getText());
	        }
		
		 driver.close();
	}

}