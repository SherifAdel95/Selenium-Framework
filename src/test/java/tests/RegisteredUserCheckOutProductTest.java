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

public class RegisteredUserCheckOutProductTest extends testBase {
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
	public void userCanRegister()
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation("sherif", "adel", "test21@gmail.com", "123456");
		Assert.assertTrue(RegisterObj.RegistrationSucessMessage.getText().contains("Your registration completed"));
		
	}
	@Test(dependsOnMethods = {"userCanRegister"})
	public void UserCanAddProductsToCart() throws InterruptedException 
	{
		searchObj=new searchPage(driver);
		ProductObj=new productDetailedPage(driver);
		cartPage=new shoppingCartPage(driver);
		
		searchObj.searchUsingAutoSuggest("MACB");
		Assert.assertEquals(ProductObj.productNameReadCrumb.getText(), productName);
		ProductObj.addToCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(cartPage.shoppingCartPageTitle.isDisplayed());
		Assert.assertEquals(cartPage.productName.getText(), productName);
	}
	@Test(dependsOnMethods = {"UserCanAddProductsToCart"})
	public void userCheckOut()
	{
		cartPage.openCheckoutpage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkOutObj=new checkOutPage(driver);
		checkOutObj.registeredUserCheckout("Egypt", "Alex","FakeAddress","777" , "111111");
		Assert.assertEquals(checkOutObj.productName.getText(),productName);
		checkOutObj.confirmOrder();
		Assert.assertTrue(checkOutObj.successfulOrderMessage.getText().contains("Your order has been successfully"));
		
		checkOutObj.openOrderDetailedPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderObj=new orderDetailedPage(driver);
		orderObj.downloadOrderDetailsInPdf();
	}
	
	@Test(dependsOnMethods = {"userCheckOut"})
	public void usercanLogOut()
	{
		RegisterObj.userLogout();
	}
	
}

