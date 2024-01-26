package qa.iframeHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class IframeHandleTest {
	private WebDriver driver;
	private ExplicitWait waitTime;
	private JavascriptExecutor js;
	private Actions act;
	private screenshotCreation sc;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		waitTime = new ExplicitWait(driver);
		sc=new screenshotCreation(driver);
		driver.get("https://demo.guru99.com/test/guru99home/");
	}
  @Test
  public void FindIframeonPage() 
  {
	  int size = driver.findElements(By.tagName("iframe")).size();
	  if(size>0) 
	  {
		//switching the frame by ID
		  driver.switchTo().frame("a077aa5e"); 
		  System.out.println("********We are switch to the iframe*******");
	  }
	  
	//Clicks the iframe
	WebElement element = waitTime.waitforclickable(driver,30, driver.findElement(By.xpath("html/body/a/img")));
	js.executeScript("arguments[0].scrollIntoView();", element);
	js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px border:4px solid red;');",element);
	element.click();
	  System.out.println("*********We are done***************");
	    

  }
}
