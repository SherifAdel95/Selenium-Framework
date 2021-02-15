package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class productHoverMenuTest extends testBase{

	HomePage homeObj;
	@Test
	public void UserCanSelectSubCategory()
	{
		homeObj=new HomePage(driver);
		homeObj.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
	}
	
}
