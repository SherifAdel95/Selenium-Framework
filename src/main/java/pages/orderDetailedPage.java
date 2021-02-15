package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderDetailedPage extends pageBase {

	public orderDetailedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(css="a.button-2.print-order-button")
WebElement printLink;

@FindBy(css="a.button-2.pdf-invoice-button")
WebElement pdfInvoiceLink;

public void printOrderDetails()
{
	clickButton(printLink);
}

public void downloadOrderDetailsInPdf()
{
	clickButton(pdfInvoiceLink);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
