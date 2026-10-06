package Lesson;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ListenerUtility.CommonTimeListener;
import ObjectRepo.ArtModules;
import ObjectRepo.CHome;
import ObjectRepo.Clogin;
import ObjectRepo.CreateLesson;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyUtility;
import genericUtilities.WebDriverUtility;
import BaseUtility.BaseClass;
@Listeners(CommonTimeListener.class)
public class PersonalInfoTest extends BaseClass {
	
	@Test  (groups="smoke") //PASS
	public void verifyAccount() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PropertyUtility pu = new PropertyUtility();
		
		driver.get(pu.getPropertyData("url"));
		CHome ch = new CHome(driver);
		ch.getSignIn().click();
		Clogin cl = new Clogin(driver);
		cl.login(pu.getPropertyData("learner.username"), pu.getPropertyData("learner.password"));
		driver.findElement(By.xpath("//span[text()=\"Personal Info\"]")).click();
		
		String expectedName = "Chaithrali H";

		String actualName = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//input[@name='name']")
		    )
		).getAttribute("value");

		Assert.assertEquals(actualName, expectedName);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
		    "document.getElementById('nav-dropdown').click();"
		);
		js.executeScript(
			    "document.querySelector(\"ul.dropdown-list a[href='/logout/']\").click();"
			);
	}
	
	@Test  (groups="system")  //PASS
	
	public void createLesson() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	PropertyUtility pu = new PropertyUtility();
	ExcelFileUtility efl = new ExcelFileUtility();
	WebDriverUtility wu = new WebDriverUtility();
	
	driver.get(pu.getPropertyData("url"));
	CHome ch = new CHome(driver);
	ch.getSignIn().click();
	Clogin cl = new Clogin(driver);
	cl.login(pu.getPropertyData("artist.username"), pu.getPropertyData("artist.password"));
	driver.findElement(By.xpath("//span[text()=\"Planned Lessons\"]")).click();
	
	CreateLesson crl = new CreateLesson(driver);
	String lessName = efl.ReadData("lsnInfo",1,0);
	crl.getName().sendKeys(lessName);
	String desc = efl.ReadData("lsnInfo", 1, 1);
	crl.getDesc().sendKeys(desc);
	String link = efl.ReadData("lsnInfo", 1, 2);
	crl.getLink().sendKeys(link);
	String filePath = System.getProperty("user.dir")
	            + "./src/test/resources/Screenshot 2026-10-02 183957.png";

	crl.uploadImg(filePath);
	crl.selectLsnType();
	crl.selectLsnDur();
	crl.selectNoOfLsn();
	crl.getPricePerLsn(40);
	crl.getSub();
	crl.getAgeGroup().click();   
	crl.selectAgeGroup("8-10");
	crl.getLangGroup().click();
	crl.selectLangGroup("English");
	crl.addLesson().click();
	ch.lessonsLink().click();
	ch.filterProfession().click();
	ch.getProfession().click();
	ch.filterLanguage().click();
	ch.getLang().click();
	
//	String expectedLsnName = "Basic Acting Skills";
	WebElement lsnName = driver.findElement(By.xpath("(//div[@class='name']/a[text()=\"Basic Acting Skills\"])[1]"));

	wait.until(ExpectedConditions.visibilityOf(lsnName));
	String actualLsnName = lsnName.getText();
	System.out.println(actualLsnName);
	Assert.assertTrue(actualLsnName.contains(lessName));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript(
	    "document.getElementById('nav-dropdown').click();"
	);
	js.executeScript(
		    "document.querySelector(\"ul.dropdown-list a[href='/logout/']\").click();"
		);
}
	
	
}


