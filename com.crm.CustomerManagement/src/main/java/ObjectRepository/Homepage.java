package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.CustomerManagement.GenericLibrary.SeleniumUtillity;

public class Homepage {
//declaration
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement profileelement;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutelement;
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgelement;
//	intiallization
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//utillization
	public WebElement getProfileelement() {
		return profileelement;
	}
	public WebElement getSignoutelement() {
		return signoutelement;
	}
	public WebElement getOrgelement() {
		return orgelement;
	}
	//Bussiness Logic
	public void logout(WebDriver driver) {
		Homepage hp=new Homepage(driver);
		WebElement element = hp.getProfileelement();
		SeleniumUtillity s=new SeleniumUtillity();
		s.mouseHover(driver, element);
		hp.getSignoutelement().click();
		
		
	}
	
	
}
