package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends pageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(id="FullName")
WebElement FullNameTxt;

@FindBy(id="Email")
WebElement EmailTxt;

@FindBy(id="Enquiry")
WebElement EnquiryTxt;

@FindBy(css="input.button-1.contact-us-button")
WebElement sendEmailBtn;

@FindBy(css="div.result")
public WebElement enquirySuccessMessage;


public void sendEnquiry(String fullName,String email,String enquiryMessage)
{
	setElementTxt(FullNameTxt, fullName);
	setElementTxt(EmailTxt, email);
	setElementTxt(EnquiryTxt, enquiryMessage);
	clickButton(sendEmailBtn);
	
}
}
