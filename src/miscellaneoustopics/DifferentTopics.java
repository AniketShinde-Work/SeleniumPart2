package miscellaneoustopics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class DifferentTopics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//to maximize the browser 
		driver.manage().window().maximize();
		
		//to delete the cookies
		//driver.manage().deleteAllCookies();
		
		//to delete the single cookie
		
		//driver.manage().deleteCookieNamed("sessionKey");//add any cookie name you want to delete
		
		
		driver.get("https://google.com");
		
		
		//Taking the screenshot for that we have to type cast the driver object to TakesScreenshot
		TakesScreenshot tss = (TakesScreenshot)driver;
		
		//we want the ss in output in file format
		File ss = tss.getScreenshotAs(OutputType.FILE);
		
		//now store the output in a folder
		FileUtils.copyFile(ss,new File("D:\\Eclipse_project_Copy\\ScreenShots\\first.png"));
		
	}

}
