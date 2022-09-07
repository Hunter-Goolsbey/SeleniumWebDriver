package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L08_RadioButtons {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationtesting.co.uk/dropdown.html");
		
		//[for='demo-priority-low']
		//[for='demo-priority-normal']
		//[for='demo-priority-high']
		
		driver.findElement(By.cssSelector("[for='demo-priority-low']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("[for='demo-priority-normal']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("[for='demo-priority-high']")).click();
	}

}
