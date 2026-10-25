package com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.DemoWebShop_GenericUtility.BaseTest;
import com.DemoWebShop_POM.AddNewAddress_Page;
import com.DemoWebShop_POM.Address_Page;
//import com.aventstack.extentreports.Status;

public class TC_001_Verify_User_is_able_to_add_address_or_not_Test extends BaseTest {

	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("Add address to the test script");

		webdriverutility.javaScriptScrollTillElement(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
//		test.log(Status.INFO, "Clicked on address button");
		// Add comments

		Address_Page addresspage = new Address_Page(driver);
		addresspage.getNewAddAddressBtn().click();
//		test.log(Status.INFO, "Clicked on add New address button");

		AddNewAddress_Page newaddresspage = new AddNewAddress_Page(driver);
		newaddresspage.getFirstNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 0));
		newaddresspage.getLastNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 1));
		newaddresspage.getEmailTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 2));

		webdriverutility.selectByVisibleText(newaddresspage.getCountryDropDown(),
				fileutility.readDataFromExcelFile("Sheet1", 1, 3));
		
		newaddresspage.getCityTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 4));
		newaddresspage.getAddressTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 5));
		newaddresspage.getZipCodeTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 6));
		newaddresspage.getPhoneNumberTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 7));
		newaddresspage.getSaveAddressBtn().click();
//		test.log(Status.INFO, "New address added successfully");
		
		Thread.sleep(3000);
		
		webdriverutility.webPageScreenshot(driver);
//		test.log(Status.INFO, "Taken screenshot with added new address");


	}

}
