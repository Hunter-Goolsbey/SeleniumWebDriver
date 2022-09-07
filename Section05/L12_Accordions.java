package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L12_Accordions {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.automationtesting.co.uk/accordion.html");
		
		//driver.findElement(By.cssSelector(".accordion > div:nth-of-type(1)")).click();
		//driver.findElement(By.cssSelector(".accordion > div:nth-of-type(1)")).click();
		
		//driver.findElement(By.cssSelector(".accordion > div:nth-of-type(3)")).click();
		//driver.findElement(By.cssSelector(".accordion > div:nth-of-type(3)")).click();
		
		//driver.findElement(By.cssSelector(".accordion > div:nth-of-type(5)")).click();
		//driver.findElement(By.cssSelector(".accordion > div:nth-of-type(5)")).click();
		
		for(int i=0; i<10; i++) {
			driver.findElement(By.cssSelector(".accordion > div:nth-of-type(1)")).click();
			driver.findElement(By.cssSelector(".accordion > div:nth-of-type(3)")).click();
			driver.findElement(By.cssSelector(".accordion > div:nth-of-type(5)")).click();
		}
	}
}
