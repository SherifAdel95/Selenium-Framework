package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage extends pageBase {

	public searchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="small-searchterms")
	WebElement searchTxt;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement>productList;
	
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productLink;
	
	public void productSearch(String productName)
	{
		setElementTxt(searchTxt, productName);
		clickButton(searchBtn);	
		
		
	}
	public void openProductDetailedPage()
	{
		clickButton(productLink);
	}
	
	public void searchUsingAutoSuggest(String productName)
	{

		setElementTxt(searchTxt, productName);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		productList.get(0).click();
		
		
		
	}
}
