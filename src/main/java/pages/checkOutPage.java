package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class checkOutPage extends pageBase {

	public checkOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement continueAsGuestBtn;
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstnameTxt;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastnameTxt;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countrydropList;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement AddressTxt;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxt;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxt;
	
	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement continueToShippingBtn;
	
	@FindBy(id="shippingoption_0")
	WebElement groundShippingBtn;
	
	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement continueToPaymentbtn;
	
	@FindBy(id="paymentmethod_0")
	WebElement cashPaymentbtn;
	
	@FindBy(css="input.button-1.payment-method-next-step-button")
	WebElement continueToShippingInfoBtn;
	
	@FindBy(css="input.button-1.payment-info-next-step-button")
	WebElement continueToconfirmOrderBtn;
	
	@FindBy(css="td.product")
	public WebElement productName;
	
	
	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css="strong")
	public WebElement successfulOrderMessage;
	
	@FindBy(css = "div.details-link")
	WebElement detaliedOrderLink;
	
	
	public void continueAsAGuest() throws InterruptedException
	{
		clickButton(continueAsGuestBtn);
		Thread.sleep(1000);
	}
	
	public void checkOutAsAGuest(String firstName,String lastName,String email,
			String countryName,String city,String address,String zipCode,String phoneNumber) throws InterruptedException
	{
		setElementTxt(firstnameTxt,firstName);
		setElementTxt(lastnameTxt,lastName);
		setElementTxt(emailTxt, email);
		select=new Select(countrydropList);
		select.selectByVisibleText(countryName);
		setElementTxt(cityTxt, city);
		setElementTxt(AddressTxt, address);
		setElementTxt(zipCodeTxt, zipCode);
		setElementTxt(phoneNumberTxt, phoneNumber);
		clickButton(continueToShippingBtn);
		Thread.sleep(2000);
		clickButton(groundShippingBtn);
		clickButton(continueToPaymentbtn);
		Thread.sleep(1000);
		clickButton(cashPaymentbtn);
		clickButton(continueToShippingInfoBtn);
		Thread.sleep(1000);
		clickButton(continueToconfirmOrderBtn);
		Thread.sleep(1000);
	}
	
	
	public void registeredUserCheckout(String countryName,String city,String address,String zipCode,String phoneNumber) 
	{
		select=new Select(countrydropList);
		select.selectByVisibleText(countryName);
		setElementTxt(cityTxt, city);
		setElementTxt(AddressTxt, address);
		setElementTxt(zipCodeTxt, zipCode);
		setElementTxt(phoneNumberTxt, phoneNumber);
		clickButton(continueToShippingBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(groundShippingBtn);
		clickButton(continueToPaymentbtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(cashPaymentbtn);
		clickButton(continueToShippingInfoBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(continueToconfirmOrderBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void confirmOrder()
	{
		clickButton(confirmBtn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void openOrderDetailedPage()
	{
		clickButton(detaliedOrderLink);
	}
}
