package qa.HDFCBank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.HDFCBank.Base.BaseClass;

public class loginPage extends BaseClass{
	
	WebDriver localDriver;
	
//	public loginPage(WebDriver remoteDriver) {
//		localDriver = remoteDriver;
//		PageFactory.initElements(localDriver, this);
//	}
	
	public loginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "uid")
	WebElement userId;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	@FindBy(name="btnReset")
	WebElement resetButton;
	
	public void login(String uID, String pWord) {
		userId.sendKeys(uID);
		password.sendKeys(pWord);
		loginButton.click();
	}
	
	
	public void reset(String uID, String pWord) {
		userId.sendKeys(uID);
		password.sendKeys(pWord);
		resetButton.click();
	}

}
