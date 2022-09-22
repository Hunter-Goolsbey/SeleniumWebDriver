package uk.co.automationtesting.mavenproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;


public class L07_Surefire {
	
	WebDriver driver;
	
	@Test
	public void testNG() {
		AssertJUnit.assertEquals("demo","demo");
	}
}
