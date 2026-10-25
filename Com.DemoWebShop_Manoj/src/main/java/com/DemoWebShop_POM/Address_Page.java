package com.DemoWebShop_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address_Page {
	
	public Address_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Add new']")
	private WebElement addNewAddressBtn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private List<WebElement> deleteAddressBtn;

	public List<WebElement> getDeleteAddressBtn() {
		return deleteAddressBtn;
	}

	public WebElement getNewAddAddressBtn() {
		return addNewAddressBtn;
	}
	
	

}
