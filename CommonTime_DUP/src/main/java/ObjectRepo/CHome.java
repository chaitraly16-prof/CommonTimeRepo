package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CHome {
	
	public CHome(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()='Sign In']")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[text()='Lessons']")
	private WebElement lessons;
	
	@FindBy(xpath="//a[text()='Artists']")
	private WebElement artists;
	
	@FindBy(xpath="//a[@class='chat-btn']")
	private WebElement chat;
	
	@FindBy(xpath="//input[@name='msg']")
	private WebElement message;
	
	@FindBy(xpath="//button[text()='Send']")
	private WebElement sendMessage;
	
	@FindBy(xpath="//button[@id='category-dropdown']")
	private WebElement categoryDD;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu show\"]/descendant::input[@name=\"categories[]\"][1]")
	private WebElement ddValue;
	
	@FindBy(xpath="//button[@id='profession-dropdown']")
	private WebElement professionDD;
	
	@FindBy(xpath="//button[@id='lang-dropdown']")
	private WebElement languageDD;
	
	@FindBy(xpath=" //button[@id=\"profession-dropdown\"]/following-sibling::ul/descendant::input[@name=\"professions[]\"][1]")
	private WebElement professionList;
	
	public WebElement getProfession()
	{
		return professionList;
	}
	
	public WebElement getLang()
	{
		return languageList;
	}
	
	@FindBy(xpath="  //button[@id=\"lang-dropdown\"]/following-sibling::ul/descendant::input[@name=\"languages[]\"][1]")
	private WebElement languageList;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu show\"]/descendant::input[@name=\"professions[]\"][1]")
	private WebElement pddValue;
	
	@FindBy(xpath="//div[@class=\"favourite\"]/img")
	private WebElement favourite;
	
//	@FindBy(xpath="//a[text()=\"My Account\"]")
//	private WebElement myAccount;
	
//	@FindBy(id = "nav-dropdown")
//	private WebElement dropdownBox;
	
	@FindBy(xpath="//img[@id='nav-dropdown']")
	private WebElement dropdown;
	
//	@FindBy(xpath="//li[@class=\"nav-item d-none d-lg-block\"]/img]")
//	private WebElement dropdown;

	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement account;
	
	@FindBy(xpath="//span[text()=\"Favorites\"]")
	private WebElement favourites;
	
	public WebElement getSignIn()
	{
		return signIn;
	}
	
	public WebElement lessonsLink()
	{
		return lessons;
	}
	
	public WebElement artistsLink()
	{
		return artists;
	}
	
	public WebElement getChatBtn()
	{
		return chat;
	}
	
	public WebElement typeMessage()
	{
		return message;
	}
	
	public WebElement sendMessage()
	{
		return sendMessage;
	}
	
	public WebElement filterCategory()
	{
		return categoryDD;
	}
	
	public WebElement categoryValue()
	{
		return ddValue;
	}
	
	public WebElement filterProfession()
	{
		return professionDD;
	}
	
	public WebElement filterLanguage()
	{
		return languageDD;
	}
	
	public WebElement professionValue()
	{
		return pddValue;
	}
	
	public WebElement addFav()
	{
		return favourite;
	}
	
	public WebElement accDropDown()
	{
		return dropdown;
	}
	
	public WebElement clickAccount()
	{
		return account;
	}

	public WebElement favouritesLink()
	{
		return favourites;
	}
	
	
}
