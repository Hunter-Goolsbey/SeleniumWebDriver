package Section12;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class L04_Login extends L04_BasePage{
	
	
	@Test
	public void signin() throws IOException {
		
		driver = getDriver();
		driver.get(getUrl());
		
		driver.findElement(By.cssSelector("[Title] .hidden-sm-down")).click();
		driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test123");
		driver.findElement(By.cssSelector("button#submit-login")).click();
		
		takeSnapShot(driver);
		
		System.out.println("user has logged in");
	}
}
