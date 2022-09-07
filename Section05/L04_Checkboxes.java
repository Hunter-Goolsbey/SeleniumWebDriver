package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L04_Checkboxes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationtesting.co.uk/dropdown.html");
		
		System.out.println(driver.findElement(By.cssSelector("input#cb_red")).isSelected());
		
		
		System.out.println(driver.findElement(By.cssSelector("input#cb_green")).isSelected());

	}

}
