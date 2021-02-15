package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class contactUsTest extends testBase {
	
	HomePage homeObj;
	ContactUsPage contactUsObj;
	String name="sherif Adel";
	String email="shico@gmail.com";
	String EnquiryMessage="Test Message";
	@Test
	public void userCanUseContactUs()
	{
		homeObj=new HomePage(driver);
		homeObj.openContantUsPage();
		contactUsObj=new ContactUsPage(driver);
		contactUsObj.sendEnquiry(name, email, EnquiryMessage);
		Assert.assertTrue(contactUsObj.enquirySuccessMessage.getText().contains("Your enquiry has been successfully sent"));
	}

}
