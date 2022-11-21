package qa.HDFCBank.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import qa.HDFCBank.Base.BaseClass;

public class myUtils extends BaseClass{
	
	public static String takeScreenshots(String testname) throws IOException {
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		
		String timestampe = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date());
		
		File sourceFile = tk.getScreenshotAs(OutputType.FILE);
		
		String filepath = System.getProperty("user.dir")+"\\Screenshots\\"+testname+"-"+timestampe+".png";
		
		File destFile = new File(filepath);
		
		FileHandler.copy(sourceFile, destFile);
		
		return filepath;
		
	}

}
