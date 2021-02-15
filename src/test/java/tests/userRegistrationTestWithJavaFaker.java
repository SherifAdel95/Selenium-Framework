package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationTestWithJavaFaker extends testBase {

	HomePage homeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;
	Faker fakeData=new Faker();
	String firstName=fakeData.name().firstName();
	String lastName=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.number().digits(6).toString();

	@Test(priority = 1)
	public void userCanRegister()
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation(firstName, lastName, email, password);
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
		loginObj.UserLogin(email,password);
		Assert.assertTrue(RegisterObj.LogoutBtn.getText().contains("Log out"));
	}
	@Test(dependsOnMethods = {"registeredUserCanLogin"})
	public void UserLogout()
	{
		RegisterObj.userLogout();	
	}
}
