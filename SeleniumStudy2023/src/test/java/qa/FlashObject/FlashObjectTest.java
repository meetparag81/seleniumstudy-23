package qa.FlashObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Flash.FlashObjectWebDriver;
import ScrenshotMechanism.screenshotCreation;
import actionSyntax.ActionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;


public class FlashObjectTest {
	public WebDriver driver;
	private FlashObjectWebDriver  flashApp;
	private ExplicitWait waittime;
	private JavascriptExecutor js;
	private screenshotCreation sc;
	private ActionPage act;
	@BeforeMethod
	public void beforeMethod() 
	{
		WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver= new ChromeDriver();
		sc = new screenshotCreation(driver);
		waittime = new ExplicitWait(driver);
		js = (JavascriptExecutor) driver;
		act = new ActionPage(driver);
		flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		driver.get("http://demo.guru99.com/test/flash-testing.html");
	}
	@Test
	public void Guru99FlashobjectTest() throws InterruptedException 
	{

		// Pass the URL of video		

		Thread.sleep(5000);		
		flashApp.callFlashObject("Play");			
		Thread.sleep(5000);		
		flashApp.callFlashObject("StopPlay");			
		Thread.sleep(5000);		
		flashApp.callFlashObject("SetVariable","/:message","Flash testing using selenium Webdriver");
		System.out.println(flashApp.callFlashObject("GetVariable","/:message"));
	}


	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}
