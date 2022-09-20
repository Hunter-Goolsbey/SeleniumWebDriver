package Section11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L13_DependsOnMethods {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://teststore.automationtesting.co.uk/login?back=my-account");
	}
	
	@Test
	public void enterEmail() {
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
	}
	
	@Test
	public void enterPassword() {
		driver.findElement(By.cssSelector("section input[name='password']")).sendKeys("test123");
	}
	
	@Test(dependsOnMethods = {"enterPassword"})
	public void clickBtn() {
		driver.findElement(By.cssSelector("button#submit-login")).click();
	}
	
}
