package Section09;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L03_Cookies {

	public static void main(String[] args) throws InterruptedException {
		//local directory appears syntactically different as I am using MacOS
		System.setProperty("webdriver.chrome.driver", "/Users/The-Intern/Documents/JResources/driverV1/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://teststore.automationtesting.co.uk/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.linkText("CLOTHES")).click();
		driver.findElement(By.cssSelector("img[alt='hummingbird printed t-shirt']")).click();
		driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn.btn-secondary")).click();
		
		driver.manage().deleteAllCookies();
	}

}
