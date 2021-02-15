package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productReviwPage extends pageBase {

	public productReviwPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(id="AddProductReview_Title")
WebElement ReviewTitleTxt;

@FindBy(id="AddProductReview_ReviewText")
WebElement ReviewTxt;

@FindBy(id="addproductrating_1")
WebElement Star1RatingBtn;

@FindBy(id="addproductrating_2")
WebElement Star2RatingBtn;

@FindBy(id="addproductrating_3")
WebElement Star3RatingBtn;

@FindBy(id="addproductrating_4")
WebElement Star4RatingBtn;


@FindBy(id="addproductrating_5")
WebElement Star5RatingBtn;

@FindBy(css="input.button-1.write-product-review-button")
WebElement SubmitReview;

@FindBy(css="div.result")
public WebElement ReviewSuccessMessage;

public void AddProductReview(String title,String reviewMessage,int rating)
{
	setElementTxt(ReviewTitleTxt, title);
	setElementTxt(ReviewTxt, reviewMessage);
	switch(rating)
	{
	case 1:
		clickButton(Star1RatingBtn);
		break;
	case 2:
		clickButton(Star2RatingBtn);
		break;
	case 3:
		clickButton(Star3RatingBtn);
		break;
	case 4:
		clickButton(Star4RatingBtn);
		break;
	case 5:
		clickButton(Star5RatingBtn);
		break;	
	default:
		break;
	}
clickButton(SubmitReview);	
	
	
}

}
