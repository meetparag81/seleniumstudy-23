package Mislanious;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class AuthenticationpopupTest {
	private WebDriver driver;
	private ExplicitWait waitTime;
	private Actions act;
	private JavascriptExecutor js;
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		waitTime = new ExplicitWait(driver);
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
	  
  }
  @Test
  public void authenticationPopupTest() 
  {
	  String username="admin";
	  String password="admin";
      String authenticationsyntax = "//https://username:password@the-internet.herokuapp.com/basic_auth";
	  String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.navigate().to(URL);
		WebElement element = waitTime.waitforclickable(driver, 20, driver.findElement(By.xpath("//*[contains(text(),'Congratulations')]")));
		Assert.assertEquals(element.getText(), "Congratulations! You must have the proper credentials.");
		
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
