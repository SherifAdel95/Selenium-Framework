package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationTest extends testBase {

	HomePage homeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	
	@Test(priority = 1)
	public void userCanRegister()
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation("sherif", "adel", "test1@gmail.com", "123456");
		Assert.assertTrue(RegisterObj.RegistrationSucessMessage.getText().contains("Your registration completed"));
		
	}
	@Test(dependsOnMethods = {"userCanRegister"})
	public void registeredUserLogout()
	{
		RegisterObj.userLogout();
		
	}
	@Test(dependsOnMethods = {"registeredUserLogout"})
	public void registeredUserCanLogin()
	{
		homeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.UserLogin("test1@gmail.com", "123456");
		Assert.assertTrue(RegisterObj.LogoutBtn.getText().contains("Log out"));
	}
	@Test(dependsOnMethods = {"registeredUserCanLogin"})
	public void UserLogout()
	{
		RegisterObj.userLogout();	
	}
}
