package realtimeexercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		

		WebElement tb = driver.findElement(By.cssSelector(".left-align #product" ));
		System.out.println(tb.findElements(By.tagName("tr")).size());
		System.out.println(tb.findElements(By.cssSelector("tr th")).size());
		List<WebElement> web = tb.findElements(By.xpath("//tbody/tr[3]"));

		for(int i=0;i<web.size();i++) {
			System.out.println(web.get(i).getText());
		}

	}

}
