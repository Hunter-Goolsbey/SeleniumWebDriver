package uk.co.automationtesting.mavenproject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class L06_Pom {
	
	WebDriver driver;
	
	public void testng() {
		Assert.assertEquals("demo","demo");
	}
}
