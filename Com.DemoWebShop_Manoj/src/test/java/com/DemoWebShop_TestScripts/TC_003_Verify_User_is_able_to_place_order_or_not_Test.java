package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DemoWebShop_GenericUtility.BaseTest;
import com.DemoWebShop_GenericUtility.ListenersUtility;
import com.DemoWebShop_POM.Books_Page;
import com.DemoWebShop_POM.Checkout_Page;
import com.DemoWebShop_POM.ShoppingCart_Page;

@Listeners(ListenersUtility.class)
public class TC_003_Verify_User_is_able_to_place_order_or_not_Test extends BaseTest{
	
	@Test
	public void placeOrder() throws IOException, InterruptedException
	{
		System.out.println("Place order");
		
		homepage.getSearchTextField().sendKeys(fileutility.readDataFromPropertyFile("productName"));
		homepage.getSearchBtn().click();
		
		Books_Page bookspage = new Books_Page(driver);
		webdriverutility.javaScriptClick(driver, bookspage.getAddToCart());
		
		Thread.sleep(2000);
		homepage.getShoppingCartBtn().click();
		
		ShoppingCart_Page cartpage = new ShoppingCart_Page(driver);
		cartpage.gettermsOfServiceBtn().click();
		cartpage.getCheckOutBtn().click();
		
		Checkout_Page checkoutpage = new Checkout_Page(driver);
		checkoutpage.getContinueBtn().get(0).click();
		checkoutpage.getContinueBtn().get(1).click();
		checkoutpage.getContinueBtn().get(2).click();
		checkoutpage.getContinueBtn().get(3).click();
		checkoutpage.getContinueBtn().get(4).click();
		
		checkoutpage.getConfirmBtn().click();
		
		Thread.sleep(3000);
		webdriverutility.webPageScreenshot(driver);


		
		
	}

}
