package us.co.automationtesting;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks{

	public AddRemoveItemBasketTest() throws IOException {
		super();
	}
	
	@Test
	public void addRemoveitem() throws IOException {
		
		ExtentManager.log("Starting addRemoveItemBasketTest...");
		
		Homepage home = new Homepage();
		home.getTestStoreLink().click();
		ShopHomepage shopHome = new ShopHomepage();
		ExtentManager.pass("Reached the shop homepage");
		shopHome.getProdOne().click();
		
		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Reached the shop product page");
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.pass("Have successfully selected product size");
		shopProd.getQuantIncrease().click();
		ExtentManager.pass("Have successfully increased quantity");
		shopProd.getAddToCartBtn().click();
		ExtentManager.pass("Have successfully added product to cart");
		
		//Thread.sleep(10000);
		
		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shopHome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart();
		cart.getDeleteItemTwo().click();
		
		waitForElementInvisible(cart.getDeleteItemTwo(), Duration.ofSeconds(10));
		
		//Thread.sleep(5000);
		System.out.println(cart.getTotalAmount().getText());
		
		try {
			// using an assertion to make sure the total amount is what we are expecting
			Assert.assertEquals(cart.getTotalAmount().getText(), "$45.23");
			ExtentManager.pass("The total amount matches the expected amount.");
		} catch (AssertionError e) {
			Assert.fail("Cart amount did not match the expected amount, it found " + cart.getTotalAmount().getText() +
					" expected $45.23");
			ExtentManager.fail("The total amount did not match the expected amount.");
		}
		
	}
}
