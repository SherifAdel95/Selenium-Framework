package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import pages.checkOutPage;
import pages.orderDetailedPage;
import pages.productDetailedPage;
import pages.searchPage;
import pages.shoppingCartPage;

public class CheckOutProductAsGuest extends testBase {
	HomePage homeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	searchPage searchObj;
	productDetailedPage ProductObj;
	shoppingCartPage cartPage;
	checkOutPage checkOutObj;
	String productName="Apple MacBook Pro 13-inch";
	orderDetailedPage orderObj;
	
	@Test(priority = 1)
	public void UserCanAddProductsToCart() 
	{
		searchObj=new searchPage(driver);
		ProductObj=new productDetailedPage(driver);
		cartPage=new shoppingCartPage(driver);
		
		searchObj.searchUsingAutoSuggest("MACB");
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), productName);
		ProductObj.addToCart();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(cartPage.shoppingCartPageTitle.isDisplayed());
		Assert.assertEquals(cartPage.productName.getText(), productName);
	}
	
	@Test(dependsOnMethods = {"UserCanAddProductsToCart"})
	public void usercanCheckOutAsAGuest() throws InterruptedException
	{
		cartPage.openCheckoutpage();
		checkOutObj=new checkOutPage(driver);
		checkOutObj.continueAsAGuest();
		checkOutObj.checkOutAsAGuest("sherif", "adel" ,"guest411@gmail.com", "Egypt", "Alex", "randomAddress", "777", "11111111");
		checkOutObj.confirmOrder();
		checkOutObj.openOrderDetailedPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObj=new orderDetailedPage(driver);
		orderObj.downloadOrderDetailsInPdf();

	}
}
