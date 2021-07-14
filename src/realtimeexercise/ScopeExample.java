package realtimeexercise;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		/*interview question in HCL
		Question- find the total number of anchor tags in footer of the page
		Aniket way to solve*/
		
//		int anch= driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size();
//		System.out.println(anch);
		
		/*Sir's way to solve by limiting webdriver scope and putting the scope of footer
		in anch*/ 
		
//		WebElement anch= driver.findElement(By.cssSelector("div[id='gf-BIG']"));
//		System.out.println(anch.findElements(By.tagName("a")).size());
		
		/*Find the anchor link in first column of the footer */
		
		WebElement anchor=driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		anchor.findElements(By.tagName("a")).size();
		
		/*click on each link of the column and check if the links are working*/
		for(int i=1;i<anchor.findElements(By.tagName("a")).size();i++) 
		{
			
			String clickontab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			anchor.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
		}
		
			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			while(it.hasNext())//hasnext tells us wheter next index is present or not
			{
				driver.switchTo().window(it.next());//next actually moves to the next index
				System.out.println(driver.getTitle());
			}
			
		

	}

}
