package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class setUpClass {
	public static WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-features=VizDisplayCompositor");
		 options.addArguments("start-maximized");
	        options.addArguments("enable-automation"); 
	        options.addArguments("--headless"); 
	        options.addArguments("--no-sandbox"); 
	        options.addArguments("--disable-infobars"); 
	        options.addArguments("--disable-dev-shm-usage"); 
	        options.addArguments("--disable-browser-side-navigation"); 
	        options.addArguments("--disable-gpu"); 
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.automationpractice.com/index.php");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
