package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wishListPage extends pageBase {

	public wishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="h1")
	public WebElement wishListPageHeader;

	@FindBy(name="removefromcart")
	WebElement removefromcartCheckBox;
	
	@FindBy(name="addtocart")
	WebElement addtocartCheckBox;
	
	@FindBy(css="input.button-2.update-wishlist-button")
	WebElement updateWishListBtn;
	
	@FindBy(css="a.product-name")
	public WebElement productName;
	
	@FindBy(css="div.no-data")
	public WebElement EmptyWishList;
	
	public void removeProductFromWishList()
	{
		clickButton(removefromcartCheckBox);
		clickButton(updateWishListBtn);
	}
	
	
	
}
