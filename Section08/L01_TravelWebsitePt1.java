package Section08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class L01_TravelWebsitePt1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.easyjet.com/en");
		driver.findElement(By.id("ensCloseBanner")).click();
		
		driver.findElement(By.cssSelector("input[name='origin']")).click();
		driver.findElement(By.cssSelector("input[name='origin']")).sendKeys("London");
		
		List<WebElement> origins = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 li>a>span")));
			
		for(WebElement origin:origins) {
			if(origin.getText().contains("Luton")) {
				origin.click();
			}
		}
	}

}
