package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private String url;
	private Properties prop;
	public static String screenShotDestinationPath;

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/config.properties");
		prop.load(data);
	}

	public static WebDriver getDriver() throws IOException {
		return WebDriverInstance.getDriver();
	}

	public String getUrl() throws IOException {
		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/config.properties");
		prop.load(data);
		url = prop.getProperty("url");
		return url;
	}

	public static String takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String destinationFile = "/Users/The-Intern/Documents/JResources/workspace/liveproject1/target/screenshots"
				+ timestamp() + ".png";
		screenShotDestinationPath = destinationFile;
		try {
			FileUtils.copyFile(srcFile, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return name;
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static void waitForElementInvisible(WebElement element, Duration timer) throws IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), timer);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static String getScreenShotDestinationPath() {
		return screenShotDestinationPath;
	}
}
