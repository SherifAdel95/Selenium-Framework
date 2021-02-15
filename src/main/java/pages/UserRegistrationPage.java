package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPage extends pageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")	
	WebElement genderRbtn;
	@FindBy(id = "FirstName")	
	WebElement FirstNameTxt;
	@FindBy(id = "LastName")	
	WebElement LastNameTxt;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement DateOfBirthDay;
	Select birthDay=new Select(DateOfBirthDay);
	
	@FindBy(name = "DateOfBirthDay")
	WebElement DateOfBirthMonth;
	Select birthMonth=new Select(DateOfBirthMonth);
	
	@FindBy(name = "DateOfBirthYear")
	WebElement DateOfBirthYear;
	Select birthYear=new Select(DateOfBirthYear);
	
	@FindBy(id = "Email")	
	WebElement EmailTxt;
	
	@FindBy(id = "Password")	
	WebElement PasswordTxt;
	
	@FindBy(id = "ConfirmPassword")	
	WebElement ConfirmPasswordTxt;
	
	@FindBy(id = "register-button")	
	WebElement register_button;
	
	@FindBy(css = "div.result")
	public WebElement RegistrationSucessMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement LogoutBtn;
	
	@FindBy(linkText = "My account")
	WebElement MyaccountBtn;
	
	public void userRegistriation(String firstName,String lastName,String email,String password)
	{
		clickButton(genderRbtn);
		setElementTxt(FirstNameTxt,firstName);
		setElementTxt(LastNameTxt,lastName);
		birthDay.selectByValue("14");
		birthMonth.selectByValue("4");
		birthYear.selectByValue("1994");
		setElementTxt(EmailTxt,email);
		setElementTxt(PasswordTxt,password);
		setElementTxt(ConfirmPasswordTxt,password);
		clickButton(register_button);	
	}
	
	public void userLogout()
	{
		clickButton(LogoutBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openMyAccount()
	{
		clickButton(MyaccountBtn);
	}
	

}
