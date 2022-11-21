package qa.HDFCBank.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	public static Properties prop;
	
	public readConfig() {
		
		File src = new File("./Configuration/config.properties");
		
				try {
					
					FileInputStream fis = new FileInputStream(src);
					prop = new Properties();
					prop.load(fis);
					
				}catch(Exception e) {
					System.out.println(e);
				}
				
	}
	
	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserId() {
		String uid = prop.getProperty("userID");
		return uid;
	}
	
	public String getPwd() {
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getChromeDriverPath() {
		String path = prop.getProperty("chromeDriverPath");
		return path;
	}
	
	public String getFirefoxDriverPath() {
		String path = prop.getProperty("firefoxDriverPath");
		return path;
	}

}
