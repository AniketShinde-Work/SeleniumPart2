package miscellaneoustopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//broken url example
		//Step1 - is to get the urls using selenium methods
		
		WebElement foot = driver.findElement(By.id("gf-BIG"));
		List<WebElement> footLinks = foot.findElements(By.tagName("a"));
		SoftAssert a = new SoftAssert();
		
		
		for(WebElement link : footLinks) {
			
			
			String url =link.getAttribute("href");
			
			//Making an httpConnection
			HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int resCode = con.getResponseCode();
			System.out.println(resCode);
			
			if(resCode>400) {
				System.out.println("broken lin -> "+link.getText());
				a.assertTrue(false);
			}
		}
		a.assertAll();//This line is to report the failure at the end
		
		
	
		
		
		
		
	}

}
