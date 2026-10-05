package Event;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ObjectRepo.CHome;
import ObjectRepo.Clogin;
import genericUtilities.PropertyUtility;

public class UpdateEventTest extends BaseClass {
	
	@Test  (groups="integration")   //PASS
	public void verifyMessage() throws Exception
	{
		PropertyUtility pu = new PropertyUtility();
		CHome ch = new CHome(driver);
		ch.getSignIn().click();
		Clogin cl = new Clogin(driver);
		cl.login(pu.getPropertyData("learner.username"), pu.getPropertyData("learner.password"));
		ch.artistsLink().click();
		
		WebElement artist = driver.findElement(
			    By.xpath("//div[@id='artist-list']/descendant::a[contains(@href,'artist')][2]"));
		String expectedArtist = artist.getText();

        artist.click();
		ch.getChatBtn().click();
		ch.typeMessage().click();
		ch.typeMessage().sendKeys("Hi, Are you available now");
		ch.sendMessage().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement home = wait.until(
		    ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Home']")));
		home.click();
		
		WebElement artistName = driver.findElement(
			    By.xpath("//td[@class='username']//a[contains(@href,'/artist/')]")
			);

			String actualArtist = artistName.getText().trim();

			Assert.assertEquals(actualArtist,expectedArtist);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript(
			    "document.getElementById('nav-dropdown').click();"
			);
			js.executeScript(
				    "document.querySelector(\"ul.dropdown-list a[href='/logout/']\").click();"
				);
	}
}
