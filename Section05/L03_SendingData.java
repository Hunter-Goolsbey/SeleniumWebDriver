package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L03_SendingData {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationtesting.co.uk/contactForm.html");
		

		//input[name= 'first_name']
		//input[name= 'last_name']
		//input[name= 'email']
		//textarea[name='message']
		
		driver.findElement(By.cssSelector("input[name= 'first_name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[name= 'last_name']")).sendKeys("Smith");
		driver.findElement(By.cssSelector("input[name= 'email']")).sendKeys("johnsmith@test.com");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("This is a message.");
	}

}
