package us.co.automationtesting;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import base.BasePage;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends BasePage{

	public AddRemoveItemBasketTest() throws IOException {
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
	public void addRemoveitem() throws InterruptedException {
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
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shopHome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart(driver);
		cart.getDeleteItemTwo().click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 120);
		
		//wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));
		
		Thread.sleep(5000);
		System.out.println(cart.getTotalAmount().getText());
		
		Assert.assertEquals(cart.getTotalAmount().getText(), "$45.23");
		
		
		
		
		
		
		
		
	}
}
