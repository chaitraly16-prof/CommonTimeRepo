package ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateLesson {
	
	WebDriver driver;
	
	public CreateLesson(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="description")
	private WebElement description;
	
	@FindBy(name="links")
	private WebElement links;
	
	@FindBy(name="image")
	private WebElement image;
	
	@FindBy(id="select2-session_type-container")
	private WebElement lessonType;
	
	@FindBy(xpath = "//li[contains(normalize-space(),'Group Lesson (3-5 learners)')]")
	private WebElement groupLesson;
	
	@FindBy(xpath="//span[text()='Lesson Duration']")
	private WebElement lsnDuration;
	
	@FindBy(xpath = "//li[text()='60 minutes']")
	private WebElement duration;
	
	@FindBy(xpath="//span[text()='No. of Lessons']")
	private WebElement noOfLsns;
	
	@FindBy(xpath = "//li[text()='3']")
	private WebElement lsnValue;
	
	@FindBy(xpath = "//input[@type='number' and @name='price']")
	private WebElement pricePerLesson;
	
	@FindBy(xpath="//span[text()='Lesson Subject']")
	private WebElement lsnSubject;
	
	@FindBy(xpath = "//li[text()='Acting Director']")
	private WebElement subValue;
	
	@FindBy(xpath="//input[@placeholder=\"Age Group\"]")
	private WebElement age;
	
	@FindBy(xpath="//input[@placeholder='Language']")
	private WebElement language;
	
	@FindBy(xpath="//li[text()='English']")
	private List<WebElement> languageGroup;
	
	public void selectLangGroup(String langGroup) {

		for (WebElement option : languageGroup) {
		    if (option.getText().trim().equals("English")) {
		        option.click();
		        break;
		    }
		}
	}
	
//	@FindBy(xpath = "//li[text()='8-10' and @id='select2-age_group-result-nkev-3']")
//	private List< WebElement> ageGroupOptions;
	
	@FindBy(xpath = "//li[text()='8-10']")
	private List<WebElement> ageGroupOptions;
	
	public void selectAgeGroup(String ageGroup) {

		for (WebElement option : ageGroupOptions) {
		    if (option.getText().trim().equals("8-10")) {
		        option.click();
		        break;
		    }
		}
	}
	
	@FindBy(xpath="//button[text()='Add Lesson Offer']")
	private WebElement lessonOffer;
	
	@FindBy(xpath = "//a[normalize-space()='Book Now']")
	private WebElement bookNow;
	
	public WebElement getName()
	{
		return name;
	}
	
	public WebElement getDesc()
	{
		return description;
	}
	
	public WebElement getLink()
	{
		return links;
	}
	
	public void uploadImg(String filePath)
	{
		image.sendKeys(filePath);
	}
	
	public void createLsn(String lessName)
	{	
		name.sendKeys(lessName);
	}
	
	public void selectLsnType()
	{
		lessonType.click();
		groupLesson.click();
	}
	
	public void selectLsnDur()
	{
		lsnDuration.click();
		duration.click();
	}
	
	public void selectNoOfLsn()
	{
		noOfLsns.click();
		lsnValue.click();
	}
	
	public void getPricePerLsn(int price)
	{
		pricePerLesson.sendKeys(String.valueOf(price));
	}
	
	public void getSub()
	{
		lsnSubject.click();
		subValue.click();
	}
	
	public WebElement getAgeGroup()
	{
		return age;
	}
	
	public WebElement getLangGroup()
	{
		return language;
	}
	
	public WebElement addLesson()
	{
		return lessonOffer;
	}
	
	public WebElement bookLesson()
	{
		return bookNow;
	}
	
	
	
	

	
	

}
