package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.loadPropertiesFile;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationTestWithDDTandPropertiesFile extends testBase {

	HomePage homeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	String fName=loadPropertiesFile.userData.getProperty("firstName");
	String LName=loadPropertiesFile.userData.getProperty("lastName");
	String emailAdd=loadPropertiesFile.userData.getProperty("email");
	String password=loadPropertiesFile.userData.getProperty("password");
	
	
	@Test(priority = 1)
	public void userCanRegister()
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation(fName,LName,emailAdd,password);
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
		loginObj.UserLogin(emailAdd,password);
		Assert.assertTrue(RegisterObj.LogoutBtn.getText().contains("Log out"));
	}
	@Test(dependsOnMethods = {"registeredUserCanLogin"})
	public void UserLogout()
	{
		RegisterObj.userLogout();	
	}
}
