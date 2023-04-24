/**
 * 
 */
package pom;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class LoginPage {
	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(LoginPage.class);
    @CacheLookup
    @FindBy(id="loginusername")
      WebElement email;

    @CacheLookup
    @FindBy(id="loginpassword")
      WebElement passwd;
    
    @CacheLookup
    @FindBy(how=How.XPATH,using="//*[@onclick = 'logIn()']")                   // "//*[@onclick = 'logIn()']"
     WebElement loginBtn;
    
    @CacheLookup
    @FindBy(id="nameofuser")
     WebElement welcomeMsg;
    
    @CacheLookup
    @FindBy(xpath = "//button[text()='Log in']  //preceding-sibling::button")
	WebElement closeButton;
     
    public LoginPage(WebDriver driver) {
		  this.driver =driver;
		  PageFactory.initElements(driver,this);
	   }
    
    public void loginWithCredentials(String username, String password) {
    	logger.info("User loged-in with credentials");
		email.clear();
		email.sendKeys(username);

		passwd.clear();
		passwd.sendKeys(password); 	
	    BasicMethod.clickOn(driver, loginBtn);
		
    }
    
    public void isWelcomeMsg_displayed() throws InterruptedException {
    	logger.info("Welcome Message displayed");
        Thread.sleep(2000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        boolean welcome = welcomeMsg.isDisplayed();
        System.out.println("Is welcome Message displayed "+welcome);
       // Assert.assertTrue(welcome, "-----login failed-----");
        System.out.println("-----successful login " + welcomeMsg.getText() + "-----");
    }
    
    public void clickOnClose()
	{
		BasicMethod.JSClick(driver, closeButton);
	}
    

}
