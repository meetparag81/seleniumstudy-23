package enanabledOrselected;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.DriverFactory;
import ScrenshotMechanism.screenshotCreation;
import actionSyntax.ActionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class testselected_And_enabled {
	
	private ChromeDriver driver;
	private screenshotCreation sc;
	private ExplicitWait waittime;
	private ActionPage act;
	private JavascriptExecutor js;
	private DriverFactory driverfactory;
	@BeforeMethod
	public void setUp() {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\MyWorkspace\\SeleniumStudy2023\\resources\\driver\\chromedriver.exe");
		 */
		WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		sc = new screenshotCreation(driver);
		waittime = new ExplicitWait(driver);
		js = (JavascriptExecutor) driver;
		act = new ActionPage(driver);
		driver.get("http://omayo.blogspot.com");
		driver.manage().window().maximize();

	}
	@Test(priority=2,enabled=false)
	public void IsSelected() 
	{
		WebElement checkboxtext= waittime.waitforclickable(driver, 30, driver.findElement((By.xpath(("//div[contains(text(),'Orange')]")))));
		js.executeScript("arguments[0].scrollIntoView();", checkboxtext);
		 WebElement checkbox = waittime.waitforclickable(driver, 30, driver.findElement(By.xpath("//input[@id='checkbox1']")));
		 String orignalstyle = checkbox.getAttribute("style");
		js.executeScript("arguments[0].setAttribute('style','background:yellow;,border:2px solid red;');", checkbox);
		js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", checkbox);
        System.out.println(checkbox.isSelected());
	}
	@Test(priority=1,enabled=true)
	public void TestIsMultiple() throws InterruptedException  {
		Thread.sleep(3000);
        
        //Write code here
       WebElement dropdownField =waittime.waitforclickable(driver, 20,  driver.findElement(By.id("drop1")));
       Select select = new Select(dropdownField) ;
       
       System.out.println(select.isMultiple());
	}
	@AfterMethod
	public void TearDown() 
	{
		driver.quit();
	}

}
