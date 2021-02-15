package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends testBase {
	UserRegistrationPage RegisterObj;
	HomePage homeObj;
	LoginPage pageObj;
	MyAccountPage MyaccountObj;
	@Test(priority = 1)
	public void userCanRegister()
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation("sherif", "adel", "test217@gmail.com", "123456");
		Assert.assertTrue(RegisterObj.RegistrationSucessMessage.getText().contains("Your registration completed"));
		
	}
	@Test(dependsOnMethods = {"userCanRegister"})
	public void RegisteredUserCanChangePassword()
	{
		MyaccountObj=new MyAccountPage(driver);
		
		RegisterObj.openMyAccount();
		MyaccountObj.openChangePasswordPage();
		MyaccountObj.changePassword("123456", "232232");
		Assert.assertTrue(MyaccountObj.resultLbl.getText().contains("Password was changed"));
		
	}
	
	@Test(dependsOnMethods = {"RegisteredUserCanChangePassword"})
	public void UserCanLogout()
	{
		RegisterObj.userLogout();
		
		
	}
	@Test(dependsOnMethods = {"UserCanLogout"})
	public void UserCanLogin()
	{
		pageObj=new LoginPage(driver);
		homeObj.OpenLoginPage();
		pageObj.UserLogin("test217@gmail.com", "232232");
		Assert.assertTrue(RegisterObj.LogoutBtn.getText().contains("Log out"));
		RegisterObj.userLogout();
		
	}
}
