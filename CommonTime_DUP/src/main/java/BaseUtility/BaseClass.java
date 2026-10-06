package BaseUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ObjectRepo.ArtModules;
import ObjectRepo.CHome;
import ObjectRepo.Clogin;
import genericUtilities.PropertyUtility;
import genericUtilities.WebDriverUtility;


public class BaseClass {
	public WebDriver driver;
	public WebDriverUtility wu = new WebDriverUtility();
	public static WebDriver sdriver;
	public PropertyUtility pu = new PropertyUtility();
	
	@BeforeClass
	public void configBC() throws Exception
	{
		String BROWSER = System.getProperty("browser" , pu.getPropertyData("chrome"));
		System.out.println("Launch the browser");
		driver = wu.launchBrowser("chrome");
		sdriver=driver;
		wu.maximizeBrowser(driver);
		wu.implicitWaitMethod(driver,3);
	}
	
	@BeforeMethod
	public void configBM() throws Exception
	{
		driver.get(pu.getPropertyData("url"));

		System.out.println("---login---");
	}
	
	@AfterMethod
	public void configAM() throws Exception
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		ArtModules am = new ArtModules(driver);
//		Actions a = new Actions(driver);
//		wait.until(ExpectedConditions.visibilityOf(am.getDropdown()));
//		wait.until(ExpectedConditions.elementToBeClickable(am.getDropdown()));
//		am.getDropdown().click();
//		wait.until(ExpectedConditions.elementToBeClickable(am.getLogOut()));
//		a.moveToElement(am.getLogOut()).click().perform();
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
		System.out.println("===Close the browser");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("===Close DB, Report Backup===");
		
	}
}


