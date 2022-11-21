package qa.HDFCBank.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.HDFCBank.Base.BaseClass;
import qa.HDFCBank.Pages.loginPage;
import qa.HDFCBank.Utils.readExcelData;

public class TC_LoginDDT_02 extends BaseClass{
	
	loginPage loginpage;
	
	public TC_LoginDDT_02() {
		super();
	}
	
	@DataProvider(name="Data For Login")
	public Object[][] excelDataProvider() throws IOException {
		Object[][] data = readExcelData.readExcel(); 
		return data;
	}
	
	@Test(dataProvider = "Data For Login")
	public void loginDDTTest(String uid, String pwd) {
		loginpage = new loginPage();
		loginpage.login(uid,pwd);
	}

}
