package Section12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class L03_Login {
	WebDriver driver;
	
	@BeforeSuite
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream("/Users/The-Intern/Documents/JResources/workspace/HelloWorld/src/Section12/L03_config.properties");
		prop.load(data);
		
		
		
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
			
			driver = new ChromeDriver();
			
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/geckodriver");
			
			driver = new FirefoxDriver();
			
		} else {
			System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/msedgeDriver");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
