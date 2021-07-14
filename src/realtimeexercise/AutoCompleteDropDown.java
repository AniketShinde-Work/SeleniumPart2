package realtimeexercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		List<WebElement> countries = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		for(int i=0;i<countries.size();i++) {
			String count = countries.get(i).getText();
			if(count.equalsIgnoreCase("India")) {
				countries.get(i).click();
			}
		}
		
		
		
		
	}

}
