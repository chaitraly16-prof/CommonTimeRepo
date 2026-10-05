package genericUtilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public WebDriver launchBrowser(String browser)
	{
		WebDriver driver;
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
		    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		    options.addArguments("--window-size=1920,1080");
			options.addArguments("--force-device-scale-factor=1");
			
			
			driver = new ChromeDriver(options);
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void implicitWaitMethod(WebDriver driver, int sec)
	{                                
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void handlingWindows(WebDriver driver, String targetTitle) {
		Set<String> windowIds = driver.getWindowHandles();
		for(String windowId:windowIds) {
			driver.switchTo().window(windowId);
			if(driver.getTitle().contains(targetTitle))
				break;
		}
	}
	
	public void selectByVisibleText(WebElement dropdown, String status) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(status);
	}
	
	public void selectByValue(WebElement dropdown, String value)
	{
		Select s = new Select(dropdown);
		s.selectByValue(value);
	}
}


