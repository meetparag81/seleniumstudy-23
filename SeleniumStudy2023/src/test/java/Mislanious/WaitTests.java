package Mislanious;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class WaitTests {
	private WebDriver driver;
	private ExplicitWait waitTime;
	private Actions act;
	private JavascriptExecutor js;
	

	@BeforeMethod
	public void setUp() {
		
	WebDriverManager.chromedriver().driverVersion("120.0").setup();
	driver = new ChromeDriver();
	act = new Actions(driver);
	js = (JavascriptExecutor) driver;
	waitTime = new ExplicitWait(driver);
	driver.get("http://omayo.blogspot.com");
	driver.manage().window().maximize();
}
	@Test
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void explicitWait() {
		
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	@Test
	public void fluentWait(WebElement element) {
		
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
