/**
 * 
 */
package com.cumcumber.MyProject_DemoBlaze;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.Common;
import utils.ScreenShot;
import pom.Cartpage;
import pom.IndexPage;
import pom.LoginPage;
import pom.PlaceOrderDetail;


/**
 * @author Seema Dube
 *
 */public class Index_stepdefinitions {
	 
	 WebDriver driver;
		String browser="chrome";
		String url="https://www.demoblaze.com";  
		
		
		@Before
		public void setup() {
			Common cmn =new Common();
			cmn.setupBrowser(browser, url);
			driver=cmn.getDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
	@Given("user is on demoblaze.com")
	public void user__is_on_demoblaze_com() {
		IndexPage obj =new IndexPage(driver);		
	    driver.get(url);
	    obj.isLogoDisplayed();
	    obj.pageTitleValidation();
	}

	@Then("user move to the sign-up page")
	public void user_move_to_the_sign_up_page() {
	   driver.findElement(By.id("signin2")).click();
	   System.out.println("  " +driver.getTitle());	
	}

	@When("user enter username as {string} ans password as {string}")
	 public void IndexPage(String username,String password) {
		
		IndexPage obj =new IndexPage(driver);		
		obj.signup(username, password);
		ScreenShot.captureScreenshot(driver,"signup");
	}
    
	@Then("user should successfully sign-up")	
	public void user_should_successfully_sign_up() {
		ScreenShot.captureScreenshot(driver,"signup_done");
		System.out.println("sign-up successfully");
	}
	@When("user enter existing username as {string} ans password as {string}")
	public void user_enter_existing_username_as_ans_password_as(String username, String password) {
		
		IndexPage obj =new IndexPage(driver);
		obj.signup(username, password);
		ScreenShot.captureScreenshot(driver,"signup_existing_user");
	}

	@Then("user should get an alert message")
	public void user_should_get_an_alert_message() throws InterruptedException {
		
		IndexPage obj =new IndexPage(driver);
		//obj.userExistAlertMsg();
		ScreenShot.captureScreenshot(driver,"signup_existing_user_alert");
	}
	
	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		IndexPage obj =new IndexPage(driver);
		obj.pageTitleValidation();		
		
			}

	@Then("user open Login Page																																																																																										+")
	public void user_open_login_page() {
		driver.findElement(By.id("login2")).click();
		String title = driver.getTitle();
		 System.out.println(title);
		 System.out.println("login page opened");
	}
	
	@When("I enter username as {string} ans password as {string}")
	public void login(String username,String password) {
		
		LoginPage log =new LoginPage(driver);
		log.loginWithCredentials(username, password);
		System.out.println("Enter login  value");
		ScreenShot.captureScreenshot(driver,"login");
	}

	@Then("I should successfully login")
	public void validLogin() throws InterruptedException {
		
		LoginPage log =new LoginPage(driver);
		log.isWelcomeMsg_displayed();	
		
	    }
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		ScreenShot.captureScreenshot(driver,"login_welcome_Msg");
		 System.out.println("On Login page");
	}
	
	//  user can place order for product
	
	@Then("user click on phones category and check item display")
	public void user_click_on_phones_category_and_check_item_display() {
		Cartpage cart =new Cartpage(driver);
		cart.gotoCategory(); 
	}

	@When("user click on random item and add it to cart")
	public void user_click_on_random_item_and_add_it_to_cart() {
		Cartpage cart =new Cartpage(driver);
		cart.addMobileToCart();
		ScreenShot.captureScreenshot(driver,"item_added_");
		System.out.println("  Random Product phone.......");
	}

	@Then("alert of item added is displayed and user accept that")
	public void alert_of_item_added_is_displayed_and_user_accept_that() throws InterruptedException {
		
		Cartpage cart =new Cartpage(driver);
		cart.ProductAddedAlertMsg();
		
	}

	@Then("user navigate to cart page")
	public void user_navigate_to_cart_page() {
		ScreenShot.captureScreenshot(driver,"item_added_alert");
	    Cartpage cart =new Cartpage(driver); 
		cart.openCart(); 
	} 

	@Then("user click on place order button")
	public void user_click_on_place_order_button() {
		Cartpage cart =new Cartpage(driver);
		
		cart.clickOnPlaceOrder_M();
		ScreenShot.captureScreenshot(driver,"order_placed");
	}

	@Then("user fill Detail to place order then click on purchase button")
	public void user_fill_detail_to_place_order_then_click_on_purchase_button() {
		PlaceOrderDetail obj =new PlaceOrderDetail(driver);
		
	    obj.OrderInfo();
	    ScreenShot.captureScreenshot(driver,"order_detail");
	}

	@Then("order Confirmation  Message is displayed and user click on ok button")
	public void order_confirmation_message_is_displayed_and_user_click_on_ok_button() throws InterruptedException {
		PlaceOrderDetail obj =new PlaceOrderDetail(driver);
		
	    obj.OrderConfirmationMsg();
	    ScreenShot.captureScreenshot(driver,"order_confirmation_msg");
	}
	
	@Then("user fill Detail name and card to place order then click on purchase button")
	public void user_fill_detail_name_and_card_to_place_order_then_click_on_purchase_button() {
		PlaceOrderDetail obj =new PlaceOrderDetail(driver);
		
	    obj.OrderInfo_with_name_card();
	    ScreenShot.captureScreenshot(driver,"order_with_name_card");
	}
   
	@Then("user try to place order for product without giving name detail then click on purchase button")
	public void user_try_to_place_order_for_product_without_giving_name_detail_then_click_on_purchase_button() {
		PlaceOrderDetail obj =new PlaceOrderDetail(driver);
		
	    obj.OrderInfo_withoutName();
	    ScreenShot.captureScreenshot(driver,"order_NoName_detail"); 
	}

	@Then("alert message for incomplete detail is displayed and user accept that")
	public void alert_message_for_incomplete_detail_is_displayed_and_user_accept_that() throws InterruptedException {
		PlaceOrderDetail obj =new PlaceOrderDetail(driver);		
	    obj.incompleteInfoMsg(); 
	    ScreenShot.captureScreenshot(driver,"misingInfo_alert");
	   // obj.clickOnClose();
	}
	@Then("user delete item from cart")
	public void user_delete_item_from_cart() {
	    Cartpage cart =new Cartpage(driver);
	    ScreenShot.captureScreenshot(driver,"before_deleting_item");
	    cart.deleteCartItem();
	    ScreenShot.captureScreenshot(driver,"after_deleting_item");
	}
	
 }
