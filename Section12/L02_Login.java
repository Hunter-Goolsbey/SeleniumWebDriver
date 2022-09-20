package Section12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L02_Login {
	WebDriver driver;
	
	@BeforeSuite
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream("/Users/The-Intern/Documents/JResources/workspace/HelloWorld/src/Section12/L02_config.properties");
		prop.load(data);
		
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void signin() {
		driver.findElement(By.cssSelector("[Title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("button#submit-login")).click();
		System.out.println("user has logged in");
	}
}
