package allureReport.com.allure;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestOne {
WebDriver driver;
@BeforeTest
public void setUp() {
  {
	  System.setProperty(
	             "webdriver.chrome.driver",
	             "C:\\chrome\\new\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
@Test
public void logoPresent() {
  
	  List<WebElement> products=driver.findElements(By.xpath("//*[@class='product-name']"));
	   System.out.println(products.size());
}
@Test
public void logoTest() {
	
}
@Test
public void registrationTest() {
	
}
@AfterClass
public void teardown() {}
}
