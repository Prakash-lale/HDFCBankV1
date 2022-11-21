package qa.HDFCBank.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import qa.HDFCBank.Base.BaseClass;

public class extentReporter extends BaseClass {
	
public static ExtentReports extendReportsGenerator() {
		
		ExtentReports extentreports = new ExtentReports();
		
		String timestamp = new SimpleDateFormat("yyyy-mm-dd-hh-mm-hh-ss").format(new Date());
		String reportname = "Report-"+timestamp+".html";
		
		String reportPath = System.getProperty("user.dir")+"\\Reports\\"+reportname;
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reportPath);
		
		extentreports.attachReporter(sparkreporter);
		
		return extentreports;
		
	}

}
