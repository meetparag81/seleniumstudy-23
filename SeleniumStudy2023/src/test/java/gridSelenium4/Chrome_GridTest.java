package gridSelenium4;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class Chrome_GridTest extends BaseClass {
	
	private WebDriver driver;
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		System.out.println();
		boolean browseroptions=true;
	driver=	initalizeBrowser("chrome",browseroptions);
		
	}
	@Test
	public void gridTest() 
	{
		driver.get("https://the-internet.herokuapp.com/");
		Assert.assertEquals(driver.getTitle(), "The Internet");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
