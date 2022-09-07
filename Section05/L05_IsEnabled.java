package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L05_IsEnabled {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationtesting.co.uk/buttons.html");
		
		System.out.println(driver.findElement(By.cssSelector("button#btn_four")).isEnabled());
		System.out.println(driver.findElement(By.cssSelector("button#btn_three")).isEnabled());

	}

}
