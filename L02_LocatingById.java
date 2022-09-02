package Section04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L02_LocatingById {
	
	public static void main(String[] args) {
		//local directory appears syntactically different as I am using MacOS
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationtesting.co.uk/buttons");
		driver.findElement(By.id("btn_one")).click();
	}

}
