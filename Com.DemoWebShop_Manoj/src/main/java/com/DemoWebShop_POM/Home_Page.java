package com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "small-searchterms")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBtn;
	
	@FindBy(partialLinkText = "Addresses")
	private WebElement addressesBtn;
	
	@FindBy(partialLinkText = "Log out")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
	private WebElement shoppingCartBtn;

	
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getAddressesBtn() {
		return addressesBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getShoppingCartBtn() {
		return shoppingCartBtn;
	}

	
}
