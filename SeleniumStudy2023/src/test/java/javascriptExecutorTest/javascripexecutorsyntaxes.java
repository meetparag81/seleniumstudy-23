package javascriptExecutorTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class javascripexecutorsyntaxes {
	WebDriver driver;
	private JavascriptExecutor js;
	private ExplicitWait waittime;

	/*
	 * public javascripexecutorsyntaxes(WebDriver _driver) { this.driver = _driver;
	 * 
	 * }
	 */

	@BeforeTest
	public void setUp() {

		WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		waittime = new ExplicitWait(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		// open url using javascriptexecutor
		js.executeScript("window.location.href='https://in.search.yahoo.com/?fr2=inr';");

	}

	// get title of a page using executor
	@Test(enabled = false)
	public void GetTitleofPage() {

		String title = js.executeScript("return document.title;").toString();
		Assert.assertEquals(title, "Yahoo Search - Web Search");

	}

	// click the element
	@Test(enabled = false)
	public void ClickThePage() {
		System.out.println();
		waittime = new ExplicitWait(driver);
		WebElement emailIcon = waittime.waitforclickable(driver, 30,driver.findElement((By.xpath(("//a[@id='ymail']")))));
		js.executeScript("arguments[0].click();", emailIcon);
	}

	// send the input//backgroundcolor
	@Test(priority = 1, enabled = true)
	public void SignInThePage() throws InterruptedException {

		WebElement emailIcon = waittime.waitforclickable(driver, 30,driver.findElement((By.xpath(("//a[@id='ymail']")))));
		js.executeScript("arguments[0].click();", emailIcon);
		WebElement signinButton = waittime.waitforclickable(driver, 30,	driver.findElement((By.xpath(("//a[text()='Sign in']")))));
		js.executeScript("arguments[0].click()", signinButton);
		WebElement userName = waittime.waitforclickable(driver, 30, driver.findElement((By.name("username"))));
		js.executeScript("arguments[0].value='paragborawake81';", userName);
		WebElement Next = waittime.waitforclickable(driver, 30,driver.findElement(By.xpath("//input[@name='signin']")));
		String orignalstyle = Next.getAttribute("style");
		Thread.sleep(3000);
		//backgroundcolor
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');", Next);
		Thread.sleep(3000);
		js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", Next);
		js.executeScript("arguments[0].click();", Next);

	}
//scrollintoViewOrScrollUptoElement
	@Test(priority = 2, enabled = true)
	public void ScrollToDown() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://jqueryui.com/");
		js.executeScript("window.scrollBy(0, 250);");
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String firstWindow = driver.getWindowHandles().iterator().next();
		driver.switchTo().window(firstWindow);
		WebElement help = waittime.waitforclickable(driver, 30,	driver.findElement((By.xpath("(//a[text()='Help'][contains(@href,'https')])[2]"))));
		js.executeScript("arguments[0].scrollIntoView();", help);

		String Actual = js.executeScript("return document.title;").toString();
		Assert.assertEquals(Actual, "Yahoo Search - Web Search");

	}

	@Test(priority = 3, enabled = true)
	public void ScrollToUp() {
		Set<String> windowhandles = driver.getWindowHandles();
		String lastwindow = windowhandles.toArray()[windowhandles.size() - 1].toString();
		driver.switchTo().window(lastwindow);
		js.executeScript("window.scrollBy(0, -250);");
		WebElement githubElement = waittime.waitforclickable(driver, 30,
				driver.findElement((By.xpath("//a[text()='GitHub']"))));
		js.executeScript("arguments[0].scrollIntoView(true);", githubElement);
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",githubElement);

	}

	@Test(priority = 4, enabled = true)
	public void RefeshThePage() {

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://jqueryui.com/");

		js.executeScript("location.reload();");

	}

	@AfterTest
	public void TearDown() {
		driver.close();
	}

}
