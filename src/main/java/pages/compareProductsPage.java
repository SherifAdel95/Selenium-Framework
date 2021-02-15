package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class compareProductsPage extends pageBase {

	public compareProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="h1")
	public WebElement compareProductsPageHeader;
	
	@FindBy(css="a.clear-list")
	WebElement clearListBtn;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement product2_DisplayedName;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement product1_DisplayedName;
	
	
	
	@FindBy(css="table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName = "td")
	public List<WebElement> allCols;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(css="div.no-data")
	public WebElement emptyCompareList;
	
	
	public void clearCompareList()
	{
		clickButton(clearListBtn);
	}
	public void compareProducts()
	{
		//Get all rows
		System.out.println(allRows.size());
		System.out.println(allCols.size());
		//Get data from each row
		for(WebElement row:allRows)
		{
			System.out.print(row.getText()+"\t");
			for(WebElement col:allCols)
			{
				System.out.print(col.getText()+"\t");
			}
		}
		
	}
}
