package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationWithDDTandExcel extends testBase {
	HomePage homeObj;
	UserRegistrationPage RegisterObj;
	LoginPage loginObj;

	@DataProvider(name="ExcelData")
	public Object[][] userRegistrationData() throws IOException
	{
		//Get data from excel sheet reader
		ExcelReader ER=new ExcelReader();
		return ER.getExcelData();

	}

	@Test(priority = 1,dataProvider = "ExcelData")
	public void userCanRegister(String firstName,String lastName,String email,String password)
	{
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		RegisterObj=new UserRegistrationPage(driver);
		RegisterObj.userRegistriation(firstName,lastName,email,password);
		Assert.assertTrue(RegisterObj.RegistrationSucessMessage.getText().contains("Your registration completed"));
		RegisterObj.userLogout();
		homeObj.OpenLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.UserLogin(email,password);
		Assert.assertTrue(RegisterObj.LogoutBtn.getText().contains("Log out"));
		RegisterObj.userLogout();	
	}
	
}
