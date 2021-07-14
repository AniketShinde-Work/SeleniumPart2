package realtimeexercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("ez-accept-all")).click();
		driver.findElement(By.id("travel_date")).click();
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("September")) 
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
	
		
		List<WebElement> list = driver.findElements(By.className("day"));
		int listSize = list.size();
		for(int i=0;i<listSize;i++) {
			String dateText = list.get(i).getText();
			if(dateText.equalsIgnoreCase("22")) {
				list.get(i).click();
				break;
			}
			
		}
		
		
		//Make my trip example
		/*driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//div[@class='fsw_inner']/div[1]")).click();
		driver.findElement(By.xpath("//label[@for='departure']/span")).click();
		
		List<WebElement> day = driver.findElements(By.xpath("//div[@class='dateInnerCell']/p[1]"));
		int daySize = day.size();
		for(int i=0;i<daySize;i++) {
			String getDate = day.get(i).getText();
			if(getDate.equalsIgnoreCase("15")) {
				day.get(i).click();
				break;
			}
		}*/
		
		
	}

}
