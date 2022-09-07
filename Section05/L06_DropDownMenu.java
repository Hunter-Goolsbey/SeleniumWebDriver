package Section05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class L06_DropDownMenu {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://automationtesting.co.uk/dropdown.html");
		
		Select menuItem = new Select(driver.findElement(By.cssSelector("select#cars")));
		
		//menuItem.selectByVisibleText("Honda");
		
		menuItem.selectByValue("jeep");

	}

}
