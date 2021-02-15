package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends pageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(linkText = "Change password")
WebElement ChangepasswordLink;

@FindBy(id = "OldPassword")
WebElement OldPasswordTxt;

@FindBy(id = "NewPassword")
WebElement NewPasswordTxt;

@FindBy(id = "ConfirmNewPassword")
WebElement ConfirmNewPasswordTxt;

@FindBy(css = "input.button-1.change-password-button")
WebElement changePasswordBtn;


@FindBy(css = "div.result")
public WebElement resultLbl;
	

public void openChangePasswordPage()
{
	clickButton(ChangepasswordLink);
}
public void changePassword(String oldPassword,String newPassword)
{
	setElementTxt(OldPasswordTxt, oldPassword);
	setElementTxt(NewPasswordTxt, newPassword);
	setElementTxt(ConfirmNewPasswordTxt, newPassword);
	clickButton(changePasswordBtn);
	
	
}

}

