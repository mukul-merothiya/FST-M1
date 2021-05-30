package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity9_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\MUKULMEROTHIYA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Open the browser
	
		 driver.get("https://training-support.net/selenium/selects");
		 Select multilist = new Select(driver.findElement(By.id("multi-select")));
		 if(multilist.isMultiple())
		 {
			 //select Javascript
			 multilist.selectByVisibleText("Javascript");
			 WebElement option = multilist.getFirstSelectedOption();
		        String defaultItem = option.getText();
		        System.out.println(defaultItem);
		        multilist.deselectAll();
		        

	            //Select 'NodeJS' by value
	            multilist.selectByValue("node");
	            WebElement option1 = multilist.getFirstSelectedOption();
		        String defaultItem1 = option1.getText();
		        System.out.println(defaultItem1);
		        multilist.deselectAll();
	            
	            //Select 4,5, and 6 options by index
	            for(int i=4; i<=6; i++) {
	                multilist.selectByIndex(i);
	                WebElement option2 = multilist.getFirstSelectedOption();
			        String defaultItem2 = option2.getText();
			        System.out.println(defaultItem2);
			        multilist.deselectAll();
	            }
	            //System.out.println(chosen.getText());
	        	
	          
		 }
		 

		
		 driver.close();
	}

}