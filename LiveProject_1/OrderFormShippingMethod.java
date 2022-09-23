package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFormShippingMethod {
	
	public WebDriver driver;
	
	By deliveryMsgTextbox = By.cssSelector("textarea#delivery_message");
	By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");
	
	public OrderFormShippingMethod(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement deliveryMsgTextbox() {
		return driver.findElement(deliveryMsgTextbox);
	}
	
	public WebElement continueBtn() {
		return driver.findElement(continueBtn);
	}
}
