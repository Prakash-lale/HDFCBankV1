package qa.HDFCBank.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import qa.HDFCBank.Utils.readConfig;

public class BaseClass {
	
	public static WebDriver driver;
	
	readConfig readconfig = new readConfig();
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browserName) {
		if(browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("Google chrome") || browserName.equalsIgnoreCase("GC")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox") || browserName.equalsIgnoreCase("FF") || browserName.equalsIgnoreCase("Mizila Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
			driver = new FirefoxDriver(); 
			System.out.println("Firefox Started "+Thread.currentThread().getId());
		}else {
			Reporter.log("Sorry we do not support this broswer");
		} 
		
		
		driver.get(readconfig.getApplicationURL());
		
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
