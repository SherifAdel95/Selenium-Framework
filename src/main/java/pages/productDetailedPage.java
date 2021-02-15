package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailedPage extends pageBase {

	public productDetailedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="strong.current-item")
	public WebElement productNameReadCrumb;
	
	@FindBy(id="price-value-4")
	public WebElement productPriceLabel;
	
	@FindBy(linkText = "Add your review")
	WebElement AddReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement wishListBtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	@FindBy(css = "div.compare-products")
	WebElement AddToCompareBtn;
	
	
	public void AddReview()
	{
		clickButton(AddReviewLink);
	}
	public void AddToWishList()
	{
		clickButton(wishListBtn);
	}
	
	public void AddToCompare()
	{
		clickButton(AddToCompareBtn);
	}
	public void addToCart()
	{
		clickButton(addToCartBtn);
	}
}
