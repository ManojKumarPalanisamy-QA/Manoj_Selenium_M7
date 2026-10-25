package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import com.DemoWebShop_GenericUtility.BaseTest;
import com.DemoWebShop_POM.Address_Page;

public class TC_002_Verify_User_is_able_to_delete_address_or_not_Test extends BaseTest {

	@Test
	public void deleteAddress() throws InterruptedException, IOException
	{
		System.out.println("Delete address test script");
		webdriverutility.javaScriptScrollTillElement(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
		
		Address_Page addresspage = new Address_Page(driver);
		addresspage.getDeleteAddressBtn().get(0).click();
		
		webdriverutility.javaScriptPopupAccept(driver);
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		webdriverutility.webPageScreenshot(driver);
		
	}


}
