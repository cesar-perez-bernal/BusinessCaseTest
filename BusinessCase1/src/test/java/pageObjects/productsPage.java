package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.setUpClass;

public class productsPage {
	WebDriver driver = setUpClass.driver;
	
	public productsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='product-image-container']")})
	private List<WebElement> products;
	
	@FindBy (how = How.CLASS_NAME, using = "button ajax_add_to_cart_button btn btn-default")
	private WebElement addToCartButton;
	
	@FindBy (how = How.CLASS_NAME, using = "availability")
	private WebElement availability;
	
	@FindBy (how = How.XPATH, using = "//div[@id='layer_cart']")
	private WebElement popUpCart;
	
	@FindBy (how = How.XPATH, using = "//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckoutButton;
	
	@FindBy (how = How.XPATH, using = "//a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']")
	private WebElement proceedToCheckoutButton2;
	
	@FindBy (how = How.XPATH, using = "//button[@name='processAddress']")
	private WebElement proceedToCheckoutButton3;
	
	@FindBy (how = How.XPATH, using = "//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy (how = How.XPATH, using = "//button[@type='submit' and @name='processCarrier']")
	private WebElement proceedToCheckoutButton4;
	
	@FindBy (how = How.XPATH, using = "//a[@class='cheque']")
	private WebElement payByCheque;
	
	@FindBy (how = How.XPATH, using = "//button[@type='submit' and @class='button btn btn-default button-medium']")
	private WebElement cofirmOrder;
	
	@FindBy (how = How.XPATH, using = "//p[@class='alert alert-success']")
	private WebElement successfulOrder;
	
	public void selectARandomProduct() {
		WebElement random;
		Random randomizer = new Random();
		int randomNumber = randomizer.nextInt(products.size()-1);
		random = products.get(randomNumber);
		System.out.println(randomNumber);
		Actions action = new Actions(driver);
		action.moveToElement(random).build().perform();
		test(randomNumber+1).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(popUpCart));
	}
	
	private WebElement test(int index) {
		return driver.findElement(By.xpath("//a[@data-id-product='" + index +"' and @class='button ajax_add_to_cart_button btn btn-default']"));	
	}
	
	public void clickProceedToCheckout() {
		proceedToCheckoutButton.click();
	}
	
	public void clickProceedToCheckoutNewWindow() {
		proceedToCheckoutButton2.click();
	}
	
	public void clickProceedToCheckoutNewWindowAgain() {
		proceedToCheckoutButton3.click();
	}
	
	public void clickAgreeToTermsAndProceed() {
		checkbox.click();
		proceedToCheckoutButton4.click();
	}
	
	public void pay() {
		payByCheque.click();
	}
	
	public void confirmOrder() {
		cofirmOrder.click();	
	}
	
	public String orderComplete() {
		String validator = successfulOrder.getText().trim();
		return validator;
	}
}
