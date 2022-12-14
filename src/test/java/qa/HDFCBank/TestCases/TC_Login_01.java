package qa.HDFCBank.TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.HDFCBank.Base.BaseClass;
import qa.HDFCBank.Pages.homePage;
import qa.HDFCBank.Pages.loginPage;
import qa.HDFCBank.Utils.readConfig;

@Listeners({ qa.HDFCBank.Utils.Reporting.class })
public class TC_Login_01 extends BaseClass {

	loginPage lp;
	homePage hp;
	readConfig readconfig = new readConfig();

	public TC_Login_01() {
		super();
	}

	// invocationCount is an attribute that defines the number of time a single
	// method has to run in single execution
	@Test(invocationCount = 3)
	public void loginTest() {
		lp = new loginPage();
		lp.login(readconfig.getUserId(), readconfig.getPwd());
		if (isAlertPrasent() == true) {
			driver.switchTo().alert().accept();
		} else {
			hp = new homePage();
			System.out.println(hp.getmanagerId());
			Assert.assertTrue(hp.getmanagerId().contains("Manger Id"));
		}
	}

	@Test
	public void resetTest() {
		lp = new loginPage();
		lp.reset(readconfig.getUserId(), readconfig.getPwd());
		Assert.assertTrue(true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public Boolean isAlertPrasent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
