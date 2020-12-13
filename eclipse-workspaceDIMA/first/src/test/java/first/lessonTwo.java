package first;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 

public class lessonTwo {
 
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty(
	             "webdriver.chrome.driver",
	             "C:\\chrome\\new\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();



		 String[] itemsNeeded= {"Printed Summer Dress", "Printed Chiffon Dress"};





		 driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");

		 

		 addItems(driver,itemsNeeded);

		 }

		 public static  void addItems(WebDriver driver,String[] itemsNeeded)

		 {

		 int j=0;

		 List<WebElement> products=driver.findElements(By.xpath("//a[@class='product-name']"));

		 for(int i=0;i<products.size();i++)

		 {

		 //Brocolli - 1 Kg

		 //Brocolli,    1 kg

		 String[] name=products.get(i).getText().split("-");

		 String formattedName=name[0].trim();

		 //format it to get actual vegetable name

		 //convert array into array list for easy search

		 //  check whether name you extracted is present in arrayList or not-

		 List<String> itemsNeededList = Arrays.asList(itemsNeeded);

		 if(itemsNeededList.contains(formattedName))

		 {

		 j++;

		 //click on Add to cart

		 driver.findElements(By.partialLinkText("Add to cart")).get(i).click();

		 if(j==itemsNeeded.length)

		 {

		 break;

		 }

		 }

		 }

		 }

}