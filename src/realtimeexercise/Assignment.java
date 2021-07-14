package realtimeexercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		WebElement lblText=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]"));
		driver.findElement(By.id("checkBoxOption2")).click();
		String optionbox=lblText.getText();
		
		//Selecting the Dropdown
		WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));
		Select sel= new Select(selectElement);
		sel.selectByVisibleText(optionbox);
		
		
		//alertExample
		driver.findElement(By.id("name")).sendKeys(optionbox);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertInfo = driver.switchTo().alert().getText();
		
		if(alertInfo.contains(optionbox)) {
			System.out.println("The word "+optionbox + " is present in this line -> "+ alertInfo);
		}
		
	}

}
