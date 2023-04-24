package utils;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.commons.lang3.RandomStringUtils;


public class BasicMethod {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static void explicitWait(WebDriver driver, int Seconds, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void JSClick(WebDriver driver, WebElement ele)
	{
		BasicMethod.explicitWait(driver, 10, ele);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
		
	}
	
	
	public static void sendKeys(WebDriver driver, WebElement ele, String txt)
	{
		BasicMethod.explicitWait(driver, 10, ele);
		ele.clear();
		ele.sendKeys(txt);
	}
	
	public static void clickOn(WebDriver driver, WebElement ele)
	{
		BasicMethod.explicitWait(driver, 10, ele);
		ele.click();
	}
	
	public static String handleAlert(WebDriver driver,Alert alert)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		String alertTxt = alert.getText();
		alert.accept();
		
		return alertTxt;
	}
	
		
}
