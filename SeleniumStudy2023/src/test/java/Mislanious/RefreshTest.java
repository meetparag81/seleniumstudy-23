package Mislanious;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;
import actionSyntax.ActionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class RefreshTest {
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
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	@Test(priority=1,enabled=true)
	public void refreshByTheNavigate() throws InterruptedException 
	{

		driver.navigate().to("http://omayo.blogspot.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		Thread.sleep(10000);
	}
	@Test(priority=2,enabled=true)
	public void refreshByCurrentUrl() throws InterruptedException 
	{

		driver.navigate().to("http://omayo.blogspot.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to(driver.getCurrentUrl());
		Thread.sleep(10000);



	}
	@Test(priority=3,enabled=true)
	public void refreshByF5() throws InterruptedException 
	{
		driver.navigate().to("http://omayo.blogspot.com/");
		driver.navigate().back();
		driver.navigate().forward();			
		driver.findElement(By.tagName("body")).sendKeys(Keys.F5);
		Thread.sleep(10000);


	}
	@Test(priority=4,enabled=true)
	public void RefreshByJavascriptExecutor() throws InterruptedException
	{
		driver.navigate().forward();
		driver.navigate().back();
		js.executeScript("location.reload(true);");
		Thread.sleep(10000);

	}
	@Test(priority=4,enabled=true)
	public void ActionsclassTrefresh() throws InterruptedException
	{
		Actions act1 = new Actions(driver);
		act1.sendKeys(Keys.F5).build().perform();
		
		Thread.sleep(10000);

	}
	
	

	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}
