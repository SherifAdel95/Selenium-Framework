package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.productDetailedPage;
import pages.searchPage;

public class changeCurrency extends testBase {

	HomePage homeObj;
	searchPage searchObj;
	productDetailedPage productObj;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void UserCanChangeCurrency()
	{
		homeObj=new HomePage(driver);
		homeObj.changeCurrency();
	}
	
	
	@Test(dependsOnMethods = {"UserCanChangeCurrency"})
	public void userCanSearchUsingAutoSuggest()
	{
		
		searchObj=new searchPage(driver);
		productObj=new productDetailedPage(driver);
		searchObj.searchUsingAutoSuggest("macb");
		Assert.assertEquals(productObj.productNameReadCrumb.getText(),productName);
		Assert.assertTrue(productObj.productPriceLabel.getText().contains("€"));
		
	}

}
