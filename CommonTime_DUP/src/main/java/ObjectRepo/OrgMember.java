package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgMember {
	
	public OrgMember(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="image")
	private WebElement image;
	
	@FindBy(xpath="//span[text()='Years Of Experience']")
	private WebElement exp;
	
	@FindBy(xpath="//li[text()='3 Years']")
	private WebElement yearsOfExp;
	
	@FindBy(xpath="//button[text()='Add Organization Member']")
	private WebElement addOrgMbr;
	
	public WebElement getName()
	{
		return name;
	}
	
	public void uploadImg(String filePath)
	{
		image.sendKeys(filePath);
	}
	
	public void yearsOfExp()
	{
		exp.click();
		yearsOfExp.click();
	}
	
	public WebElement addOrgMbr()
	{
		return addOrgMbr;
	}
}
