/**
 * 
 */
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.productDetailedPage;
import pages.searchPage;
import pages.shoppingCartPage;


/**
 * @author sherif
 *
 */
public class addProductsToCartTest extends testBase {

	String product1_Name="Apple MacBook Pro 13-inch";
	String price4Laptops="$7,200.00";
	searchPage searchObj;
	productDetailedPage ProductObj;
	shoppingCartPage cartPage;
	

	@Test(priority = 1)
	public void UserCanAddProductsToCart() throws InterruptedException 
	{
		searchObj=new searchPage(driver);
		ProductObj=new productDetailedPage(driver);
		cartPage=new shoppingCartPage(driver);
		
		searchObj.searchUsingAutoSuggest("MACB");
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), product1_Name);
		ProductObj.addToCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(cartPage.shoppingCartPageTitle.isDisplayed());
		Assert.assertEquals(cartPage.productName.getText(), product1_Name);
	}

	@Test(dependsOnMethods = {"UserCanAddProductsToCart"})
	public void userCanChangeProductQuantity()
	{
		cartPage.changeItemQuantity("4");
		Assert.assertEquals(cartPage.TotalPrice.getText(),price4Laptops);		
	}
	@Test(dependsOnMethods = {"userCanChangeProductQuantity"})
	public void UserCanChangeRemoveItemFromCart() 
	{	
		
		cartPage.removeItemFromCart();
		Assert.assertTrue(cartPage.cartEmptyMessage.getText().contains("Your Shopping Cart is empty!"));
		
		
	}
}
