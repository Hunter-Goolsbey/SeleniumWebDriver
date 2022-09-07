package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L07_Alerts {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationtesting.co.uk/popups.html");
		
		driver.findElement(By.cssSelector("[onclick='alertTrigger\\(\\)']")).click();
		
		Thread.sleep(3000);
		
		
		//to select "cancel", use .dismiss()
		driver.switchTo().alert().accept();

	}

}
