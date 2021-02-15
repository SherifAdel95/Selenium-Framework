package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;
import pages.productDetailedPage;
import pages.productReviwPage;
import pages.searchPage;

public class AddProductReviewTest extends testBase {

	HomePage homeObj;
	UserRegistrationPage registerObj;
	searchPage searchObj;
	productDetailedPage productObj;
	productReviwPage reviewObj;
	String productName="Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void UserCanRegister()
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj=new UserRegistrationPage(driver);
		registerObj.userRegistriation("sherif", "Adel", "test2174@gmail.com", "123456");
		Assert.assertTrue(registerObj.RegistrationSucessMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = {"UserCanRegister"})
	public void UserCanSearchUsingAutoSuggest()
	{
		searchObj=new searchPage(driver);
		searchObj.searchUsingAutoSuggest("MACB");
		productObj=new productDetailedPage(driver);
		Assert.assertEquals(productObj.productNameReadCrumb.getText(), productName);
	}
	@Test(dependsOnMethods = {"UserCanSearchUsingAutoSuggest"})
	public void UserCanAddReview()
	{
		productObj.AddReview();
	}
	@Test(dependsOnMethods = {"UserCanAddReview"})
	public void userCanSubmitReview()
	{
		reviewObj=new productReviwPage(driver);
		reviewObj.AddProductReview("Test", "test", 2);
		Assert.assertTrue(reviewObj.ReviewSuccessMessage.getText().contains("Product review is successfully added"));
	}
	@Test(dependsOnMethods = {"userCanSubmitReview"})
	public void UserLogOut()
	{
		registerObj.userLogout();

	}
}
