package us.co.automationtesting;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import base.BasePage;
import pageObjects.Homepage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

public class OrderCompleteTest extends BasePage{

	public OrderCompleteTest() throws IOException {
		super();
	}
	
	
	@BeforeTest
	public void setup() throws IOException {
		driver = getDriver();
		driver.get(getUrl());	
	}
	
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
	
	@Test
	public void endToEndTest() throws InterruptedException {
		
		Homepage home = new Homepage(driver);
		home.getTestStoreLink().click();
		ShopHomepage shopHome = new ShopHomepage(driver);
		shopHome.getProdOne().click();
		
		ShopProductPage shopProd = new ShopProductPage(driver);
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();
		
		//Thread.sleep(5000);
		
		ShopContentPanel cPanel = new ShopContentPanel(driver);
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart(driver);
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		
		//Thread.sleep(3000);
		
		cart.getProceedCheckoutBtn().click();
		
		OrderFormPersInfo pinfo = new OrderFormPersInfo(driver);
		pinfo.getGenderMr().click();
		pinfo.getFirstNameField().sendKeys("Jeremy");
		pinfo.getLastnameField().sendKeys("Smith");
		pinfo.getEmailField().sendKeys("jeremysmith@test.com");
		pinfo.getTermsConditionsCheckbox().click();
		pinfo.getContinueBtn().click();
		
		OrderFormDelivery orderDelivery = new OrderFormDelivery(driver);
		orderDelivery.getAddressField().sendKeys("123 Main Street");
		orderDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77021");
		//Thread.sleep(5000);
		orderDelivery.getContinueBtn().click();
		
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod(driver);
		shipMethod.deliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on porch");
		shipMethod.continueBtn().click();
		
		OrderFormPayment orderPay = new OrderFormPayment(driver);
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();
	}
}
