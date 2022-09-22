package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.TestStoreLoginPage;

public class StoreLoginTest {
	
	
	@Test
	public void login() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://teststore.automationtesting.co.uk/login?back=my-account");
		
		TestStoreLoginPage logPage = new TestStoreLoginPage(driver);
		
		logPage.getEmail().sendKeys("test@test.com");
		logPage.getPassword().sendKeys("test123");
		logPage.getLoginBtn().click();
		
		
	}
}
