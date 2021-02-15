package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.productDetailedPage;
import pages.searchPage;
import pages.wishListPage;

public class AddProductToWishList extends testBase {
	
	String productName="Apple MacBook Pro 13-inch";
	searchPage searchObj;
	productDetailedPage ProductObj;
	wishListPage wishListobj;
	
	@Test(priority = 1)
	public void UserCanSearchUsingAutoSuggest()
	{
		searchObj=new searchPage(driver);
		searchObj.searchUsingAutoSuggest("MACB");
		ProductObj=new productDetailedPage(driver);
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), productName);
		
	}
	@Test(dependsOnMethods = {"UserCanSearchUsingAutoSuggest"})
	public void userCanAddProductToWishList()
	{
		ProductObj.AddToWishList();
		driver.navigate().to("https://demo.nopcommerce.com"+"/wishlist");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wishListobj=new wishListPage(driver);
		Assert.assertTrue(wishListobj.wishListPageHeader.isDisplayed());
		Assert.assertEquals(wishListobj.productName.getText(),productName);
	}
	@Test(dependsOnMethods = {"userCanAddProductToWishList"})
	public void userCanRemoveProductFromWishList()
	{
		wishListobj.removeProductFromWishList();
		Assert.assertTrue(wishListobj.EmptyWishList.getText().contains("The wishlist is empty!"));
	}
}

