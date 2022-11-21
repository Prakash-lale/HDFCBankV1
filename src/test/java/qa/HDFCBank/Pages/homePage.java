package qa.HDFCBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.HDFCBank.Base.BaseClass;

public class homePage extends BaseClass{
	
	public homePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[@class='layout']//table//tr//td[contains(text(),\"Manger Id\")]")
	WebElement managerId; 
	
	
	public String getmanagerId() {
		
		String mText = managerId.getText();
		return mText;
		
	}

}
