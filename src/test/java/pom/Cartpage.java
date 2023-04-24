/**
 * 
 */
package pom;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import log4j_file.LOG4j_Demo;
import utils.BasicMethod;
import utils.ScreenShot;

/**
 * @author Seema dube
 *
 */
public class Cartpage {
	private WebDriver driver; 
	Cartpage cartpage;
	private static Logger logger = LogManager.getLogger(Cartpage.class);
	
	@CacheLookup
    @FindBy(how=How.CLASS_NAME,using="list-group-item")
	 List<WebElement> categoriesListElements;
	
   
    @CacheLookup
	@FindBy(how=How.LINK_TEXT,using="Samsung galaxy s6")
    WebElement  itemLink ;
    
    @CacheLookup
	@FindBy(xpath = "//a[text()='Laptops']")             
    WebElement laptops;									
    
    @CacheLookup
	@FindBy(xpath = "//a[text()='Sony vaio i5']")
	WebElement sonyLap;
   
    @CacheLookup
	@FindBy(xpath ="//*[@onclick = 'addToCart(1)']")
    WebElement addToCartBtn_m_s6;
    
    @CacheLookup
	@FindBy(xpath ="//*[@onclick = 'addToCart(8)']")
    WebElement addToCartBtn_sonylap;
    
    @CacheLookup
	@FindBy(how=How.LINK_TEXT,using="Cart")
    WebElement CartBtn;
    
       
    @CacheLookup
    @FindBy(how=How.LINK_TEXT,using="Delete")
    WebElement  deleteBtn; 
    
    @CacheLookup
    @FindBy(xpath = "//*[text() = 'Place Order']")       
	WebElement placeOrderBtn;
    
    public Cartpage(WebDriver driver) {
		  this.driver =driver;
		  PageFactory.initElements(driver,this); }
    
    public void gotoCategory() {	    	
    	     
            if (!categoriesListElements.isEmpty()) {
                categoriesListElements.get(1).click();
                String selectedCategory = categoriesListElements.get(1).getText();
                System.out.println("-----selected category is " + selectedCategory + "-----");
            } else {
                System.out.println("-----there is no categories-----");
            }
           
            
            boolean phoneItem = itemLink.isDisplayed();
            Assert.assertTrue(phoneItem, "-----phone category has no items-----");
            System.out.println("-----phones category has item called " + itemLink.getText() + "-----");
        }
  

     public void addMobileToCart() {
    	 logger.info("Product added to cart");
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
         BasicMethod.clickOn(driver, itemLink);         
         addToCartBtn_m_s6.click();
     }
     public void clickOnPlaceOrder_M() {   
    	 logger.info("order placed clicked");
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10)); 
        BasicMethod.clickOn(driver,placeOrderBtn);
        }
     
    public void ProductAddedAlertMsg() throws InterruptedException {
        Thread.sleep(2000);
        logger.warn("Product added to cart alert Msg");
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println("-----item status is : " + alertMsg + "-----");
        driver.switchTo().alert().accept();
    }
    
     
    public void openCart() {
    	 logger.info("Product 9added to cart button clicked");
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10)); 
    	CartBtn.click();
    }

    
    
    public void deleteCartItem()  {
    	 logger.info("Product deleted from cart ");
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
         BasicMethod.clickOn(driver, deleteBtn);
         
         //deleteBtn.click();
    }
    
    
    
}
