package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends pageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(id="FriendEmail")
WebElement FriendEmailTxt;

@FindBy(id="PersonalMessage")
WebElement PersonalMessageTxt;

@FindBy(css="input.button-1.send-email-a-friend-button")
WebElement sendEmailBtn;

@FindBy(css="div.result")
public WebElement EmailSucessMessage;

public void emailFriend(String FriendEmail,String Message)
{
	setElementTxt(FriendEmailTxt, FriendEmail);
	setElementTxt(PersonalMessageTxt, Message);
	clickButton(sendEmailBtn);
}
	
}
