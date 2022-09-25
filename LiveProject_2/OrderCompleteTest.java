package us.co.automationtesting;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.support.ui.Select;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;


@Listeners(resources.Listeners.class)
public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
	}
	
	@Test
	public void endToEndTest() throws InterruptedException, IOException {
		
		ExtentManager.log("Starting OrderCompleteTest...");
		
		Homepage home = new Homepage();
		home.getTestStoreLink().click();
		ExtentManager.pass("Have successfully reached store homepage");
		
		ShopHomepage shopHome = new ShopHomepage();
		shopHome.getProdOne().click();
		ExtentManager.pass("Have successfully clicked on product");
		
		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Have successfully reached shop product page");
		
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.pass("Have successfully selected product size");
		
		shopProd.getQuantIncrease().click();
		ExtentManager.pass("Have successfully increased quantity");
		
		shopProd.getAddToCartBtn().click();
		ExtentManager.pass("Have successfully added item to cart");
		
		//Thread.sleep(5000);
		
		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart();
		ExtentManager.pass("Have successfully clicked reached the shopping cart page");
		cart.getHavePromo().click();
		ExtentManager.pass("Have successfully selected the promo button");
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		
		//Thread.sleep(3000);
		
		cart.getProceedCheckoutBtn().click();
		ExtentManager.pass("Have successfully selected the checkout button");
		
		OrderFormPersInfo pinfo = new OrderFormPersInfo();
		pinfo.getGenderMr().click();
		pinfo.getFirstNameField().sendKeys("Jeremy");
		pinfo.getLastnameField().sendKeys("Smith");
		pinfo.getEmailField().sendKeys("jeremysmith@test.com");
		pinfo.getTermsConditionsCheckbox().click();
		pinfo.getContinueBtn().click();
		ExtentManager.pass("Have successfully entered customer details");
		
		OrderFormDelivery orderDelivery = new OrderFormDelivery();
		orderDelivery.getAddressField().sendKeys("123 Main Street");
		orderDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77021");
		//Thread.sleep(5000);
		orderDelivery.getContinueBtn().click();
		ExtentManager.pass("Have successfully entered delivery info");
		
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		shipMethod.deliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on porch");
		shipMethod.continueBtn().click();
		ExtentManager.pass("Have successfully selected the shipping method");
		
		OrderFormPayment orderPay = new OrderFormPayment();
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();
		ExtentManager.pass("Have successfully placed order");
	}
}
