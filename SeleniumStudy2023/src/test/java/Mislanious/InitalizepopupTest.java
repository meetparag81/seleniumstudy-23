package Mislanious;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class InitalizepopupTest {

	private WebDriver driver;
	private Actions act;
	private JavascriptExecutor js;
	private ExplicitWait waitTime;
	@BeforeMethod
	public void setUp() 
	{	
		WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		waitTime = new ExplicitWait(driver);
		driver.get("http://omayo.blogspot.com");
	}
	@Test
	public void initalizePopUpTest()
	{
		System.out.println("");	
		//create popup
		js.executeScript("alert('I am an alert box!')");
		Alert alert = driver.switchTo().alert();
		//get text from popup
		String text= alert.getText();
		if(text.equals("I am an alert box!")) 
		{
			//accept the popup
			alert.accept();
		}

	}

}
