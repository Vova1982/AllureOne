package first;

 
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class lessonOne {
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
	driver.navigate().to("http://automationpractice.com/index.php");
	
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      String title = driver.getTitle();
     System.out.println("This is " + title);//a[@class='product-name']
     Thread.sleep(5000);

     
     List<WebElement> products=driver.findElements(By.xpath("//*[@class='product-name']"));
   System.out.println(products.size());
   
      driver.findElement(By.linkText("Women")).click();
    driver.findElement(By.id("search_query_top")).sendKeys ("Skirt");
    System.out.println(driver.getTitle());
    driver.findElement(By.name("submit_search")).click();
    driver.findElement(By.partialLinkText("Printed Dress")).click();
    //check if the same text 
    WebElement confermText = driver.findElement(By.xpath("//h1[contains(text(),'Printed Dress')]")); 
    String finishText = confermText.getText();
    Assert.assertTrue(finishText.contains("Printed Dress"));
    
    Boolean Display = driver.findElement(By.xpath("//h1[contains(text(),'Printed Dress')]")).isDisplayed();
  //To print the value
  System.out.println("Element displayed is : "+Display);
  
  //click multiple times on the button 
  for(int i=0; i<5;i++) {
	  driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]/span/i")).click();
	  //wait 2 seconds
	   Thread.sleep(2000);
  }
 
  Select size = new Select(driver.findElement(By.id("group_1")));
  size.selectByVisibleText("M");
  
  if(driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]/span/i")).isDisplayed() ){
	    // if clicked in the above condition is True then it has to be opened in a new window
	    driver.findElement(By.id("add_to_cart")).click();
	    System.out.println("I am gonna order");
	}

	else {
	    System.out.println("element not present -- so it entered the else loop");
	}
//open a new window
  String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
  driver.findElement(By.partialLinkText("Proceed to checkout")).sendKeys(selectLinkOpeninNewTab);

for(String SubWindow:driver.getWindowHandles()) {
	driver.switchTo().window(SubWindow);
	}
//convert from string to double
String TotalPrice = driver.findElements(By.id("total_product")).get(0).getText();
TotalPrice =TotalPrice.substring(1);
double amount1Value=Double.parseDouble(TotalPrice);
System.out.println(TotalPrice);

String total_shipping= driver.findElements(By.id("total_shipping")).get(0).getText();
//covert from string to double
total_shipping =total_shipping.substring(1);
double amount2Value=Double.parseDouble(total_shipping);
System.out.println(total_shipping);


//Suma
		double totalOfProducts=amount1Value+amount2Value;
		System.out.println(totalOfProducts+" sum of products");
		
		
		String total_amount= driver.findElement(By.id("total_price")).getText();
		total_amount =total_amount.substring(1);
		double totalValue=Double.parseDouble(total_amount);
		System.out.println(totalValue+"Total value of products");
		Assert.assertEquals(totalOfProducts, totalValue);
}
}
 
