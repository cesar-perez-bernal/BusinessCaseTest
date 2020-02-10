package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.loginPageObjects;
import pageObjects.productsPage;

public class loginSteps {
	WebDriver driver = setUpClass.driver;
	loginPageObjects loginMethods =  new loginPageObjects(driver);
	HomePage homePageMethods = new HomePage(driver);
	productsPage productsMethods = new productsPage(driver);
	
	//Scenario 1
	@Given ("The user enter to login page")
	public void user_on_login_page() {
		homePageMethods.clickSignIn();
	}
	
	@When ("The user enter username as {string}")
	public void username(String username) {
		loginMethods.enterUsername(username);
	}
	
	@And ("The user enter password as {string}")
	public void the_username_password_as(String password) {
		loginMethods.enterPassword(password);
	}
	
	@And ("The user clicks on sign in button")
	public void click_login() {
		loginMethods.clickLoginButton();
	}
	
	@Then("The user should be logged correctly")
	public void verify_login() {
		assertTrue(loginMethods.getTextFromMyAccount().equalsIgnoreCase("MY ACCOUNT"));
	}
	
	//Scenario 2
	@Then("The page should display authentication failed")
	public void authenticationFailed() {
		assertTrue(loginMethods.getTextFromAlertDanger().equalsIgnoreCase("Authentication failed."));
	}
	
	//Scenario 3
	@Then("The page should display invalid password")
	public void invalidPassword() {
		assertTrue(loginMethods.getTextFromAlertDanger().equalsIgnoreCase("Invalid password."));
	}
	
	//Scenario 5
	@When ("Now the user clicks on sign in button")
	public void clickSignIn() {
		loginMethods.clickLoginButton();
	}
	
	@Then("The page should display email address required")
	public void emailRequired() {
		assertTrue(loginMethods.getTextFromAlertDanger().equalsIgnoreCase("An email address required."));
	}
	
	//Scenario 6
	@Then("The page should display password required")
	public void passRequired() {
		assertTrue(loginMethods.getTextFromAlertDanger().equalsIgnoreCase("Password is required."));
	}
	
	//Scenario 7
	@When ("Now the user enter password as {string}")
	public void enterPassword (String password) {
		loginMethods.enterPassword(password);
	}
	
	//Scenario8
	@And ("The user clicks on Women")
	public void clickOnWomen() {
		homePageMethods.clickWomenTab();
	}
	
	@And ("The user clicks on any product")
	public void clickOnAnyProduct() {
		productsMethods.selectARandomProduct();
	}
	
	@Then ("Click on proceed to checkout")
	public void clickOnProceedToCheckout() {
		productsMethods.clickProceedToCheckout();
	}
	
	@And ("Click on proceed to checkout Again")
	public void clickOnProceedToCheckoutAgain() {
		productsMethods.clickProceedToCheckoutNewWindow();
	}
	
	@And ("Click on proceed to checkout once again")
	public void clickOnProceedToCheckoutOnceAgain() {
		productsMethods.clickProceedToCheckoutNewWindowAgain();
	}
	
	@And ("Click agree terms and proceed")
	public void proceedOneMoreTime() {
		productsMethods.clickAgreeToTermsAndProceed();
	}
	
	@And ("Pay product")
	public void payMethod() {
		productsMethods.pay();
	}
	
	@And ("Confirm the order")
	public void confirmOder() {
		productsMethods.confirmOrder();
	}
	
	@Then ("Confirm success message")
	public void confirmOrder() {
		assertTrue(productsMethods.orderComplete().equalsIgnoreCase("Your order on My Store is complete."));
	}
}
