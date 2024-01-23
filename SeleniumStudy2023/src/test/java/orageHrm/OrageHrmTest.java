package orageHrm;

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

import waitMechanism.ExplicitWait;

public class OrageHrmTest {
	private WebDriver driver;
	private ExplicitWait waitTime;
	private Actions act;
	private JavascriptExecutor js;
  @Test
  public void orageHrmLoginTest()
  {
	  
	WebElement username= waitTime.getElementwithPolltime(driver, driver.findElement(By.xpath("//input[@name='username']")), 60, 5);
	username.sendKeys("Admin");
	WebElement password= waitTime.getElementwithPolltime(driver, driver.findElement(By.xpath("//input[@name='password']")), 60, 5);
	password.sendKeys("admin123");
	 waitTime.getElementwithPolltime(driver, driver.findElement(By.xpath("//button[@type='submit']")), 10, 1).click();
	 Assert.assertEquals(driver.getTitle(), "OrangeHRM");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver = new ChromeDriver();
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		waitTime = new ExplicitWait(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
  }
  @Test

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}
