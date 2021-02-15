package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationWithDDT extends testBase {
	HomePage homeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;

	@DataProvider(name="TestData") 
	public static Object[][] userData()
	{
		return new Object[][]{
				{"Sherif","Adel","guest2@gmail.com","123456"},
				{"Ahmed","salah","test2@gmail.com","987654"}
		};
	}

	@Test(priority = 1,dataProvider = "TestData")
	public void userCanRegister(String fName,String lName,String email,String password)
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation(fName,lName,email,password);
		Assert.assertTrue(RegisterObj.RegistrationSucessMessage.getText().contains("Your registration completed"));
		RegisterObj.userLogout();
		homeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.UserLogin(email, password);
		Assert.assertTrue(RegisterObj.LogoutBtn.getText().contains("Log out"));
		RegisterObj.userLogout();
	}
}