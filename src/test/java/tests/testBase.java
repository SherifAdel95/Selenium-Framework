package tests;


import java.util.HashMap;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utility.helper;

public class testBase {

	public static WebDriver driver;
	public static String downloadPath=System.getProperty("user.dir")+".\\Downloads";
	
	public static FirefoxOptions firefoxOption()
	{
		FirefoxOptions option=new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disbaled", true);
		return option;
		
	}
	public static ChromeOptions chromeOption()
	{
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Object> chromePrefs= new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory",downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	
		
	}
	
	
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome")String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver= new ChromeDriver(chromeOption());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver= new FirefoxDriver(firefoxOption());
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
	
		driver.navigate().to("https://demo.nopcommerce.com");

	}
	
	//Take screenshot when test case fail and add it to scrrenshots's folder
	@AfterMethod
	public void screenShotOnFailure(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking screenshot.....");
			helper.captureScreenShot(driver, result.getName());	
		}
	}
	
	@AfterSuite
	public void closeDriver()
	{
		//driver.quit();
	}
	

	
	
}
