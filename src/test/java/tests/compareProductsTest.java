package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.compareProductsPage;
import pages.productDetailedPage;
import pages.searchPage;

public class compareProductsTest extends testBase {
	
	String product1_Name="Apple MacBook Pro 13-inch";
	String product2_Name="Asus N551JK-XO076H Laptop";
	searchPage searchObj;
	productDetailedPage ProductObj;
	compareProductsPage compareObj;
	
	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException
	{
		searchObj=new searchPage(driver);
		ProductObj=new productDetailedPage(driver);
		compareObj=new compareProductsPage(driver);
		
		searchObj.searchUsingAutoSuggest("MACB");
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), product1_Name);
		ProductObj.AddToCompare();
		
		searchObj.searchUsingAutoSuggest("asus");
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), product2_Name);
		ProductObj.AddToCompare();
		Thread.sleep(2000);
		
		driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");
		Assert.assertTrue(compareObj.compareProductsPageHeader.isDisplayed());
		Assert.assertEquals(compareObj.product1_DisplayedName.getText(), product1_Name);
		Assert.assertEquals(compareObj.product2_DisplayedName.getText(), product2_Name);
		compareObj.compareProducts();
	}

	@Test(dependsOnMethods = {"UserCanCompareProducts"})
	public void userCanClearCompareList()
	{
		compareObj.clearCompareList();
		Assert.assertTrue(compareObj.emptyCompareList.getText().contains("You have no items to compare."));
	}
}
