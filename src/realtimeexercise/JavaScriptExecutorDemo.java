package realtimeexercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor jsdriver=(JavascriptExecutor)driver;
		jsdriver.executeScript("window.scroll(0,800)");
		jsdriver.executeScript("document.querySelector('.tableFixHead').scroll(0,100)");
		
		  List<WebElement> numb = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		  int sum = 0;
		  
		  for(int i = 0;i < numb.size(); i++ ) {
			  String innerNumber = numb.get(i).getText();
			  int actualNumber = Integer.parseInt(innerNumber);
			  System.out.println(actualNumber);
			  sum = sum+actualNumber;
			
		  }
		  
		  System.out.println(sum);
		  
		  String total = driver.findElement(By.className("totalAmount")).getText();
		  String[] regTotal =  total.split(":");
		  int trimTotal = Integer.parseInt(regTotal[1].trim());
		  
		  Assert.assertEquals(sum, trimTotal);
		  if(sum==trimTotal) {
			  System.out.println("Both numbers are equals");
		  }
		
	}

}
