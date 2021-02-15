package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.productDetailedPage;
import pages.searchPage;

public class searchProductByAutoComplete extends testBase {

	String productName="Apple MacBook Pro 13-inch";
	searchPage searchObj;
	productDetailedPage ProductObj;
	
	@Test
	public void UserCanSearchUsingAutoSuggest()
	{
		searchObj=new searchPage(driver);
		searchObj.searchUsingAutoSuggest("MACB");
		ProductObj=new productDetailedPage(driver);
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), productName);
		
	}
	
}
