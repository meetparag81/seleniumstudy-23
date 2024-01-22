package Mislanious;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class ListcountTest {

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
	public void Listcountofsimilatobject() 
	{
		int count=	driver.findElements(By.tagName("a")).size();
	}

	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}


