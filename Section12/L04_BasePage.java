package Section12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class L04_BasePage {
	public static WebDriver driver;
		
	private String url;
	
	public WebDriver getDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream("/Users/The-Intern/Documents/JResources/workspace/HelloWorld/src/Section12/L04_config.properties");
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
		
		return driver;
		
	}
	
	public String getUrl() throws IOException {
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream("/Users/The-Intern/Documents/JResources/workspace/HelloWorld/src/Section12/L04_config.properties");
		prop.load(data);
		url = prop.getProperty("url");
		return url;
	}
	
	public void takeSnapShot(WebDriver webdriver) throws IOException {
		File srcFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File("/Users/The-Intern/Documents/JResources/Screenshots/" + timestamp() + ".png");
		
		FileUtils.copyFile(srcFile, destinationFile);
	}
	
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
