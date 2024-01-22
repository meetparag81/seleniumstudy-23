package Mislanious;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class GetTitle {
  private ChromeDriver driver;
private Actions act;
private JavascriptExecutor js;
private ExplicitWait waitTime;
@BeforeMethod
public void beforeMethod() 
{
	  WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		waitTime = new ExplicitWait(driver);
		String username="admin";
		  String password="admin";
		String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	  
}
@Test
  public void getTitle() 
  {
	  
	  System.out.println(driver.getTitle());
	  Assert.assertEquals("The Internet", driver.getTitle());
  }
 

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
