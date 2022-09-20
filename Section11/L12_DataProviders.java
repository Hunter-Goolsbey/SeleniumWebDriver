package Section11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class L12_DataProviders {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		
		//data set 1
		
		data[0][0] = "test2@test.com";
		data[0][1] = "test12345";
		
		//data set 2
		
		data[1][0] = "test@test.com";
		data[1][1] = "test123";
		
		
		//data set 3
		
		data[2][0] = "doesntexist@test.com";
		data[2][1] = "xxxxxxx";
		
		return data;
	}
	
	
	@Test(dataProvider="getData")
	public void signin(String email, String password) {
		driver.get("https://automationtesting.co.uk/");
		driver.findElement(By.cssSelector("[Title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("user has logged in");
		driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
		System.out.println("user has logged out");
	}
	
	@AfterSuite
	public void end() {
		driver.close();
		driver.quit();
		
	}
}