package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArtModules {
	WebDriver driver;
	public ArtModules(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Artist Courses']")
	private WebElement artCourses;
	
	@FindBy(xpath="//span[text()='Arts Org Events']")
	private WebElement orgEvents;
	
	@FindBy(xpath="//a[normalize-space()=\"Edit Series\"]")
	private WebElement editSeries;
	
	@FindBy(xpath="//span[@class='select2-selection select2-selection--multiple']")
	private WebElement eventCategory;
	
	@FindBy(xpath="//li[text()='Exhibition']")
	private WebElement categoryValue;
	
	@FindBy(xpath="//button[text()='Save Changes']")
	private WebElement saveSeriesBtn;
	
//	@FindBy(xpath="//img[@src='/static/main/img/dropdown.78a7b956170f.png']")
//	private WebElement dropdown;
	
	@FindBy(xpath="//img[@id='nav-dropdown']/parent::li")
	private WebElement dropdown;
	
	@FindBy(xpath="//a[text()='Log Out']")
	private WebElement logOut;
	
	
	
	
	
	@FindBy(id = "nav-dropdown")
	private WebElement dropdowns;

	@FindBy(xpath = "//ul[@class='dropdown-list']//a[@href='/account/']")
	private WebElement account;

	@FindBy(xpath = "//ul[@class='dropdown-list']//a[@href='/logout/']")
	private WebElement logOuts;


	public WebElement getDropdowns() {
	    return dropdowns;
	}

	public WebElement getAccount() {
	    return account;
	}

	public WebElement getLogOuts() {
	    return logOuts;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public WebElement getCourseLink()
	{
		return artCourses;
	}
	
	public WebElement getEventsLink()
	{
		return orgEvents;
	}
	
	public WebElement getEditSeries()
	{
		return editSeries;
	}
	
	public WebElement addCategory()
	{
		return eventCategory;
	}
	
	public WebElement addCategoryValue()
	{
		return categoryValue;
	}
	
	public WebElement getSaveSeriesBtn()
	{
		return saveSeriesBtn;
	}
	
	public WebElement getDropdown()
	{
		return dropdown;
	}
	
	public WebElement getLogOut()
	{
		return logOut;
	}
	
	@FindBy(xpath="//a[text()=\"Add a New Course\"]")
	private WebElement addCourse;
	
	public WebElement addNewCourse()
	{
		return addCourse;
	}
	
	@FindBy(name="start_date")
	private WebElement startDate;
	
	public WebElement getStartDate()
	{
		return startDate;
	}
	
	@FindBy(xpath="//div[text()=\"October, \"]/following::div[text()=\"7\"]")
	private WebElement startDateValue;
	
	public WebElement getStartDateValue()
	{
		return startDateValue;
	}
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="description")
	private WebElement description;
	
	@FindBy(xpath="//span[text()='Lesson Duration']")
	private WebElement lsnDuration;
	
	@FindBy(xpath = "//li[text()='60 minutes']")
	private WebElement duration;
	
	@FindBy(xpath="//span[text()='Lesson Subject']")
	private WebElement lsnSubject;
	
	@FindBy(xpath = "//li[text()='Acting Director']")
	private WebElement subValue;
	
	@FindBy(xpath="//input[@placeholder=\"Age Group\"]")
	private WebElement age;
	
	@FindBy(xpath = "//li[text()='8-10']")
	private WebElement ageGroupOptions;
	
	@FindBy(xpath="//span[text()='Course Status']")
	private WebElement status;
	
	@FindBy(xpath="//li[text()='Draft']")
	private WebElement courseStatus;
	
	@FindBy(xpath="//button[text()='Save Course']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[@href='/account/artist-courses-edit/']")
	private WebElement editBtn;
	
	@FindBy(xpath = "//span[text()='60 minutes']")
	private WebElement editDuration;
	
	@FindBy(xpath = "//li[text()='90 minutes']")
	private WebElement editDurValue;
	
	@FindBy(xpath = "//span[text()='Music Therapist']")
	private WebElement editSub;
	
	@FindBy(xpath = "//li[text()='Acting Director']")
	private WebElement editSubValue;
	
	@FindBy(xpath="//button[@class='submit-btn']")
	private WebElement editSaveBtn;
	
	public void selectLsnDur()
	{
		lsnDuration.click();
		duration.click();
	}
	
	public WebElement editLsnDur()
	{
		return editDuration;
	}
	
	public void lsnDurValue()
	{
		editDurValue.click();
	}
	
	public void getSubject()
	{
		lsnSubject.click();
		subValue.click();
	}
	
	public WebElement getName(String courseName)
	{
		return name;
	}
	
	public WebElement getDesc()
	{
		return description;
	}
	
	public WebElement getAgeGroup()
	{
		return age;
	}
	
	public WebElement getAgeGroupOptions()
	{
		return ageGroupOptions;
	}
	
	public WebElement getStatus()
	{
		return status;
	}
	
	public WebElement getCourseStatus()
	{
		return courseStatus;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
//	public void getEditBtn(String courseName)
//	{
//		editBtn.click();
//	}
	
//	public void clickEditCourse(String courseName) {
//
//	    WebElement editBtn = 
//	    		driver.findElement(By.xpath("//div[@class='series-block']/descendant::div[text()="+ courseName +"]/following::div[@class='series-btn']/a[normalize-space()='Edit']"));
//	    editBtn.click();
//	}
	
	public void getEditSub()
	{
		editSub.click();
	}
	
	public void getEditSubValue()
	{
		editSubValue.click();
	}
	
	public WebElement getEdSaveBtn()
	{
		return editSaveBtn;
	}
}
