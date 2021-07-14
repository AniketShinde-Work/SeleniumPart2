package miscellaneoustopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Certification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SSL certification
		
		//1st thing to do is set - General chrome browser setting using DesiredCapabilities
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		
		//1 way we can accept certificate is 
		ch.acceptInsecureCerts();
		
		//2nd way to accept certificate is
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//2nd thing to do is set the local browser settings using ChromeOptions
		ChromeOptions c= new ChromeOptions();
		c.merge(ch);
		 
		//now pass c of ChromeOptions in chromeDriver constructor as a argument
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

}
