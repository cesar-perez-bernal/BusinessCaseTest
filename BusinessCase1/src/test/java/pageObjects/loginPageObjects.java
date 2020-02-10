package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPageObjects {
	public loginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (how = How.ID, using = "email")
	private WebElement usernameLbl;
	
	@FindBy (how = How.ID, using = "passwd")
	private WebElement passwordLbl;
	
	@FindBy (how = How.ID, using = "SubmitLogin")
	private WebElement loginButton;
	
	@FindBy (how = How.CLASS_NAME, using = "page-heading")
	private WebElement myAccount;
	
	@FindBy (how = How.XPATH, using = "//div[@class='alert alert-danger']//li")
	private WebElement alertDanger;
	
	public void enterUsername(String username) {
		usernameLbl.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordLbl.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String getTextFromMyAccount() {
		String validator = myAccount.getText().trim();
		return validator;
	}
	
	public String getTextFromAlertDanger() {
		String validator = alertDanger.getText().trim();
		return validator;
	}
}
