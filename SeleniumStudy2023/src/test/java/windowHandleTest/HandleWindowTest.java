package windowHandleTest;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class HandleWindowTest {
  private WebDriver driver;
private Actions act;
private JavascriptExecutor js;
private ExplicitWait waitTime;
private screenshotCreation sc;
@BeforeMethod
public void beforeMethod() 
{
	  WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		waitTime = new ExplicitWait(driver);
		sc=new screenshotCreation(driver);
		driver.get("https://demo.guru99.com/popup.php");
}
@Test
  public void hadleWindows() throws InterruptedException 
{
	WebElement element = waitTime.waitforclickable(driver, 30,driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")));
	js.executeScript("arguments[0].scrollIntoView(true);", element);
	//js.executeScript("arguments[0].scrollInToView(true);", element);
//	js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",element);
	js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');", element);
	element.click();
	String parentwindow = driver.getWindowHandle();
	Set<String> noofwindows = driver.getWindowHandles();
	for (String window : noofwindows) {
		if(!parentwindow.equals(window))
		{
			Thread.sleep(2000);
			driver.switchTo().window(window);
			WebElement EmailId = waitTime.waitforclickable(driver, 30, driver.findElement(By.name("emailid")));
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", EmailId);
			  js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red:');", driver.findElement(By.name("emailid")));
			  driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com"); 
			  Thread.sleep(2000);
			  WebElement  LoginButton = waitTime.waitforclickable(driver, 30, driver.findElement(By.name("btnLogin")));
			  js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red:');",LoginButton );
              driver.findElement(By.name("btnLogin")).click();			
              Thread.sleep(5000);            
		// Closing the Child Window.
                  driver.close();	
		}
		
		
	}
	Thread.sleep(5000);
	driver.switchTo().window(parentwindow);
  }
  
  

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException 
	{
		String status="";
		String methodName = result.getMethod().getMethodName();
		int statuscount= result.getStatus();
		if(statuscount==1) {
			status="passed";
		}
		else if (statuscount==0) {
			status="failed";
		}
		sc.takeScreenshot(driver, methodName, status);
		driver.quit();		

	}
}
