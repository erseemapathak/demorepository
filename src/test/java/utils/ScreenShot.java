package utils;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ScreenShot {

	public static void captureScreenshot(WebDriver driver,String screenshotName)
		{	
		try {
			TakesScreenshot ts =(TakesScreenshot)driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("./Screenshots_Myproject/"+screenshotName+".png"));
			//System.out.println("Screenshot taken");
			Reporter.log("Screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception while taking Screenshot"+e.getMessage());
			}
		
		}
	
}
