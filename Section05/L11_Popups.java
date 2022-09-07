package Section05;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L11_Popups {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.automationtesting.co.uk/popups.html");
		
		driver.findElement(By.cssSelector("[onclick='popup\\(\\)']")).click();
		
		String MainWindow = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator <String> iterate = handles.iterator();
		
		while(iterate.hasNext()) {
		
			String child = iterate.next();
			
			if(!MainWindow.equalsIgnoreCase(child)) {
				Thread.sleep(3000);
				driver.switchTo().window(child);
				driver.close();
			}
		}
		Thread.sleep(3000);
		driver.switchTo().window(MainWindow);
		driver.close();
	}
}
