package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingCartPage extends pageBase {

	public shoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(css="h1")
public WebElement shoppingCartPageTitle;

@FindBy(name="removefromcart")
WebElement removeFromCartBtn;

@FindBy(css="td.product")
public WebElement productName;

@FindBy(css="input.button-2.update-cart-button")
WebElement updateShoopingCartBtn;

@FindBy(className =  "qty-input")
WebElement productQuantity;

@FindBy(css="span.product-unit-price")
public WebElement productPrice;

@FindBy(css="span.product-subtotal")
public WebElement TotalPrice;

@FindBy(id="termsofservice")
WebElement termsCheckbox;

@FindBy(id="checkout")
WebElement checkoutBtn;

@FindBy(css="div.no-data")
public WebElement cartEmptyMessage;

public void removeItemFromCart()
{
	clickButton(removeFromCartBtn);
	clickButton(updateShoopingCartBtn);
}

public void changeItemQuantity(String quantity)
{
	clearText(productQuantity);
	setElementTxt(productQuantity, quantity);
	clickButton(updateShoopingCartBtn);
}
public void openCheckoutpage()
{
	clickButton(termsCheckbox);
	clickButton(checkoutBtn);
}

}
