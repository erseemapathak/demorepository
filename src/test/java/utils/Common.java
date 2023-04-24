package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Common {
private WebDriver driver;
	
public static void readPropertiesFile() {
	Properties prop = new Properties();
	try {
		InputStream input =new FileInputStream("C:\\Users\\Pathak\\eclipse-workspace-new\\MyProject_DemoBlaze\\src\\main\\java\\config\\config.properties");
		 prop.load(input);
		 System.out.println("hello proprties");
		 System.out.println(prop.getProperty("browser"));
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
	public void setupBrowser(String browser,String url)
	{ 
		String currDir=System.getProperty("user.dir");
		String fs=System.getProperty("file.separator");
		String path=currDir+fs+"drivers"+fs;

		String osName=System.getProperty("os.name");
		System.out.println( " O  S  name-"+osName);
		String fileExt =osName.contains("Windows")? ".exe":" ";

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", path +"chromedriver" + fileExt);
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) 
		 {  driver = new EdgeDriver(); 
		 }     
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", path +"msedgedriver " + fileExt);
			driver = new EdgeDriver();
		}
		else {
			System.out.println("valid browser was not provided hence quitting the automation run");
			System.exit(0);
		}
		if(url!="")
			driver.get(url);
			else
			driver.get("about:blank");
		}
	public WebDriver getDriver() {
		return this.driver;
	}
	public void closeTab() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}
}
