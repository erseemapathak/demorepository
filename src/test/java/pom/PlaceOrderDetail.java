/**
 * 
 */
package pom;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.BasicMethod;

/**
 * @author Pathak
 *
 */
public class PlaceOrderDetail {

	private WebDriver driver;
	PlaceOrderDetail order;
	private static Logger logger = LogManager.getLogger(PlaceOrderDetail.class);

	@CacheLookup
	@FindBy(id = "name")
	WebElement uname; 

	@CacheLookup
	@FindBy(id = "country")
	WebElement nationality; 

	@CacheLookup
	@FindBy(id="city")
	 WebElement  ucity;
	 
	@CacheLookup
    @FindBy(id="card")
    WebElement  money; 
	
    @CacheLookup
	@FindBy(id="month")
	WebElement mm;  
	
	@CacheLookup
    @FindBy(id="year")
    WebElement yr;

    @CacheLookup
	@FindBy(xpath="//*[@onclick = 'purchaseOrder()']")
	WebElement purchaseBtn;     
	
	@CacheLookup
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	WebElement thnqmsg ;   
	
	@CacheLookup	
	@FindBy(xpath="//*[text() = 'OK']")
	WebElement  okBtn ;  	
	
	 @CacheLookup
	    @FindBy(xpath = "(//*[@class='btn btn-secondary'])[2]")
		WebElement closeButton;
	    
	    public PlaceOrderDetail(WebDriver driver) {
			  this.driver =driver;
			  PageFactory.initElements(driver,this);
		   }

	public void OrderInfo() {
		logger.info("oder information provided");
		uname.clear();
		BasicMethod.sendKeys(driver, uname, "Kabir");
		logger.info("oder information provided-name");
		nationality.clear();
		BasicMethod.sendKeys(driver, nationality, "Norway");	
		logger.info("oder information provided-Country");
		ucity.clear();
		BasicMethod.sendKeys(driver, ucity, "Oslo");
		logger.info("oder information provided-city");
		money.clear();
		BasicMethod.sendKeys(driver, money, "BOB 8990 1234 5678 6789");	
		logger.info("oder information provided-Card detail");
		mm.clear();
		BasicMethod.sendKeys(driver, mm, "December");
		logger.info("oder information provided-Month");
		yr.clear();
		BasicMethod.sendKeys(driver, yr, "2025");	
		logger.info("oder information provided-year");
	}
	
	
	public void OrderInfo_with_name_card() {
		uname.clear();
		BasicMethod.sendKeys(driver, uname, "Kabir");		
		money.clear();	
		BasicMethod.sendKeys(driver, money, "BOB 8990 1234 5678 6789");		
			
	}
	
	public void OrderInfo_withoutName() {
				
		nationality.clear();
		BasicMethod.sendKeys(driver, nationality, "Norway");	
		ucity.clear();
		BasicMethod.sendKeys(driver, ucity, "Oslo");	
		money.clear();
		BasicMethod.sendKeys(driver, money, "BOB 8990 1234 5678 6789");	
		mm.clear();
		BasicMethod.sendKeys(driver, mm, "December");		
		yr.clear();
		BasicMethod.sendKeys(driver, yr, "2025");			
	}
	public void incompleteInfoMsg() throws InterruptedException {
		purchaseBtn.click();
		Thread.sleep(2000);
		//BasicMethod.clickOn(driver, okBtn);
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("-----item status is : " + alertMsg + "-----");
        driver.switchTo().alert().accept();
    }
	public void clickOnClose()
	{   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));    
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='btn btn-secondary'])[2]")));
		BasicMethod.JSClick(driver, closeButton);
	}
		
	public void OrderConfirmationMsg() throws InterruptedException {
		purchaseBtn.click();
        Thread.sleep(2000);
        
        boolean thanks = thnqmsg.isDisplayed();
        Assert.assertTrue(thanks, "-----order not completed-----");
        System.out.println("-----order status is " + thnqmsg.getText() + "-----");
        
        BasicMethod.clickOn(driver, okBtn);
    }
  	
}
