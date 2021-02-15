package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationWithDDTandJsonFile extends testBase {
	HomePage homeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;



	@Test
	public void userCanRegister()
	{
		JsonDataReader reader=new JsonDataReader();
		reader.jsonReader();
		
		
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation(reader.firstName,reader.lastName,reader.email,reader.password);
		Assert.assertTrue(RegisterObj.RegistrationSucessMessage.getText().contains("Your registration completed"));
		RegisterObj.userLogout();
		
		homeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.UserLogin(reader.email, reader.password);
		Assert.assertTrue(RegisterObj.LogoutBtn.getText().contains("Log out"));
		RegisterObj.userLogout();
	}
}