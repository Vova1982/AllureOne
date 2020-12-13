package first;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class threeLesson {
	private WebDriver driver;
	@BeforeMethod 
	public void SetUp() {
		 System.setProperty(
	             "webdriver.chrome.driver",
	             "C:\\chrome\\new\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();

		
		
	}

	@Test
	public void url() throws InterruptedException {
		driver.navigate().to("https://www.amazon.ca/");
		
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      String title = driver.getTitle();
	   WebElement text=   driver.findElement(By.id("twotabsearchtextbox"));
	  text.sendKeys("w");
	      if(text.equals("w")) {
	    	  System.out.println(text.getText());}
	      else {
	    	  driver.findElement(By.id("nav-search-submit-text")).click();
	      }
	}
 
}
 