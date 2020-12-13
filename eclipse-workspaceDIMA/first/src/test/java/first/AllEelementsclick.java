package first;

 
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllEelementsclick {
	private WebDriver driver;
	@BeforeMethod 
	public void SetUp() {
		 System.setProperty(
	             "webdriver.chrome.driver",
	             "C:\\chrome\\new\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php?id_category=8&controller=category");
		
		
	}

	@Test
	public void url() throws InterruptedException {
		
		
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      String title = driver.getTitle();
	      System.out.println(title);
	      boolean isChecked =false;
	      List<WebElement> radioBattons = driver.findElements(By.xpath("//input[@type='checkbox']"));
	      int size = radioBattons.size();
	      System.out.println("Total amount is: "+size);
	      for(int i =0; i<size;i++) {
	    	  isChecked = radioBattons.get(i).isSelected();
	    	  if (!isChecked) {
	    	 
	    		  radioBattons.get(i).click();
	    		 
	    		   	    		  Thread.sleep(2000);
	    	  }
	    	  
	      }
	}
}