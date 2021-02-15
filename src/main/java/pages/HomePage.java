package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends pageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor)driver;
		action= new Actions(driver);
	}
@FindBy(linkText = "Register")	
WebElement RegisterLink;

@FindBy(linkText = "Log in")	
WebElement LoginLink;

@FindBy(linkText = "Contact us")
WebElement contactUsLink;

@FindBy(id="customerCurrency")
WebElement currenyList;

@FindBy(linkText = "Computers")
WebElement computerMenu;

@FindBy(linkText = "Notebooks")
WebElement NotebooksMenu;

@FindBy(linkText = "Desktops")
WebElement DesktopsMenu;


public void openRegistrationPage()
{
	RegisterLink.click();
}
public void OpenLoginPage()
{
	LoginLink.click();
}

public void openContantUsPage()
{
	scrollToBottom();
	clickButton(contactUsLink);
	
}

public void changeCurrency()
{
	select=new Select(currenyList);
	select.selectByVisibleText("Euro");
	
}

public void selectNotebooksMenu()
{
	action.moveToElement(computerMenu).perform();
	action.moveToElement(NotebooksMenu).click().perform();
	
}

}
