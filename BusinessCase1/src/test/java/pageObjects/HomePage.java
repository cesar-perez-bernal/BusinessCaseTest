package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (how = How.CLASS_NAME, using = "login")
	private WebElement signInBtn;
	
	@FindBy (how = How.XPATH, using = "//a[@title='Women']")
	private WebElement womenTab;
	//CREATE 1 for 3
	
	public void clickSignIn() {
		signInBtn.click();
	}
	
	public void clickWomenTab() {
		womenTab.click();
	}
}
