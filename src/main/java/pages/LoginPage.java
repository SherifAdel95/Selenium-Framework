package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="Email")
	WebElement Emailtxt;
	
	@FindBy(id="Password")
	WebElement PasswordTxt;
	
	@FindBy(id="RememberMe")
	WebElement RememberMeBox;
	
	
	@FindBy(css = "input.button-1.login-button")
	WebElement LoginBtn;
	
	public void UserLogin(String email,String password)
	{
		setElementTxt(Emailtxt, email);
		setElementTxt(PasswordTxt, password);
		clickButton(RememberMeBox);
		clickButton(LoginBtn);
		
		
		
	}

}
