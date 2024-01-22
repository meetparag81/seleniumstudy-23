package Mislanious;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;
import actionSyntax.ActionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class CookiesDeleteTest {
	private WebDriver driver;
	private ExplicitWait waittime;
	private screenshotCreation sc;
	private JavascriptExecutor js;
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
			driver.navigate().to("http://omayo.blogspot.com/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  }
  @Test
  public void cookiesDlete()
  {
	  //delete cookies by name 
	  driver.manage().deleteCookieNamed("__utmb");
	  //delete all cookies 
	  driver.manage().deleteAllCookies();
	  //driver.manage().deleteCookie("__utmb");
  }
 

  @AfterMethod
  public void afterMethod() {
  }

}
