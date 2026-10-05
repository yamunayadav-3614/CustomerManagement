package ObjectRepository;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//declaration
	@FindBy(name="user_name")
	private WebElement usernametbx;
	@FindBy(name="user_password")
	private WebElement pwtbx;
	@FindBy(id="submitButton")
	private WebElement lgbtn;
	
	//intiallization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	//utillization

	public WebElement getUsernametbx() {
		return usernametbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	//business logic
	public void login(WebDriver driver,String un,String pwd) {
		LoginPage lp=new LoginPage(driver);
		lp.getUsernametbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pwd);
		lp.getLgbtn().click();
	}
	
	
	
	
	
	
	
	
}
