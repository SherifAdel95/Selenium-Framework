package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.productDetailedPage;
import pages.searchPage;

public class searchProductTest extends testBase{

	String productName="Apple MacBook Pro 13-inch";
	searchPage searchObj;
	productDetailedPage ProductObj;
	@Test(enabled = false)
	public void userCanSearchProduct()
	{
		searchObj=new searchPage(driver);
		searchObj.productSearch(productName);
		searchObj.openProductDetailedPage();
		ProductObj=new productDetailedPage(driver);
		Assert.assertTrue(ProductObj.productNameReadCrumb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(enabled =true)
	public void UserCanSearchUsingAutoSuggest()
	{
		searchObj=new searchPage(driver);
		searchObj.searchUsingAutoSuggest("MACB");
		ProductObj=new productDetailedPage(driver);
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), productName);
		
	}
	
}
