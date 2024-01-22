package Mislanious;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class checkElementPresentcondition {

	private WebDriver driver;
	private ExplicitWait waitTime;
	private Actions act;
	private JavascriptExecutor js;
	@BeforeMethod
	public void setUp() 
	{
		//System.setProperty("webdriver.chrome.driver","C:\\MyWorkspace\\SeleniumStudy2023\\resources\\driver\\chromedriver.exe");
		WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		waitTime = new ExplicitWait(driver);
		driver.get("http://omayo.blogspot.com");
		driver.manage().window().maximize();
	}
	@Test
	public boolean isElementPresent() 
	{
		boolean flag=false;

		try 
		{
			WebElement dropdownField =waitTime.waitforclickable(driver, 20,  driver.findElement(By.id("drop1")));
			flag= true;

		}
		catch (Exception e) 
		{
			e.getCause();
			flag= false;
		}
		return flag;
	}
	@Test
	public boolean isElementVisible() 
	{

		WebElement dropdownField =waitTime.waitforclickable(driver, 20,  driver.findElement(By.id("drop1")));
		return dropdownField.isDisplayed();

	}
	@Test
	public void isElementsEmpty() 
	{

		WebElement dropdownField =waitTime.waitforclickable(driver, 20,  driver.findElement(By.id("drop1")));
		List<WebElement> elements = driver.findElements(By.id("drop1"));
		if(elements.size()<0) {

		}

	}

}
