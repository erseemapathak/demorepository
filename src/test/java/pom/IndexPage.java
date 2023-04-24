/**
 * 
 */
package pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.BasicMethod;

/**
 * @author Pathak
 *
 */
public class IndexPage {

	 private WebDriver driver;
	 private static Logger logger = LogManager.getLogger(IndexPage.class);

	    @CacheLookup
	    @FindBy(id="sign-username")
	      WebElement email;

	    @CacheLookup
	    @FindBy(id="sign-password")
	      WebElement passwd;
	    
	    @CacheLookup
	    @FindBy(how=How.LINK_TEXT,using="Sign up")
	     WebElement signupBtn;
	    
	    @CacheLookup
	    @FindBy(how=How.CLASS_NAME,using="list-group-item")
	    List<WebElement> categoryList;
	    
	    @CacheLookup  
	    @FindBy(xpath = "//a[text()='Phones']")
		WebElement phones;
	    
	    @CacheLookup
		@FindBy(xpath = "//a[text()='Iphone 6 32gb']")
		WebElement Iphone;
		
	    @CacheLookup
		@FindBy(xpath = "//a[text()='Laptops']")
		WebElement laptops;
	    
	    @CacheLookup
		@FindBy(xpath = "//a[text()='Sony vaio i7']")
		WebElement sonyLap;
		
	    @CacheLookup
		@FindBy(xpath = "//a[text()='Monitors']")
		WebElement monitors;
	    
	    		
	    @CacheLookup
		@FindBy(xpath = "//img[@src='bm.png']")
		WebElement logo;
		
	    @CacheLookup
		@FindBy(xpath ="//a[text()='Cart']")
	    WebElement openCart;
	    
	    public IndexPage(WebDriver driver) {
		  this.driver =driver;
		  PageFactory.initElements(driver,this);
	   }
	    
	    public boolean isLogoDisplayed()
		{   
			return logo.isDisplayed();
		}
	   
	    public void pageTitleValidation()
		{  String expectedTitle = "STORE";
		String actualTitle = driver.getTitle();
		
		System.out.println("Page Title -" + driver.getTitle());
		assertTrue(actualTitle.equals(expectedTitle), "Mismatch in the page title");
		
		}
	    
	    public void signup(String username,String password) 
	    {   
	    	logger.info("User sign-up");
		    email.clear();
		    email.sendKeys(username);
		
		    passwd.clear();
		    passwd.sendKeys(password);
		    BasicMethod.JSClick(driver, signupBtn);
		    
		 }
	    
	   
	    public void userExistAlertMsg() throws InterruptedException {
	    	logger.info("sign up with Existing user id Alert Msg");
	        Thread.sleep(2000);
	        String alertMsg = driver.switchTo().alert().getText();
	        System.out.println("-----item status is : " + alertMsg + "-----");
	        driver.switchTo().alert().accept();
	    }
	    
	    

	    
	  
	  }
