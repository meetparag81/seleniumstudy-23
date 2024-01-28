package javascriptExecutorTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class javascripexecutorsyntaxes {
	WebDriver driver;
	private JavascriptExecutor js;
	private ExplicitWait waittime;
	private String title;
	private screenshotCreation sc;

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
		sc=new screenshotCreation(driver);
		// open url using javascriptexecutor
		js.executeScript("window.location.href='https://in.search.yahoo.com/?fr2=inr';");

	}

	// get title of a page using executor
	@Test(enabled = true)
	public void GetTitleofPage() {

		 title = js.executeScript("return document.title;").toString();
		Assert.assertEquals(title, "Yahoo Search - Web Search");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title;");
		Assert.assertEquals(title, "Yahoo Search - Web Search");


	}
	//get URL
	@Test(enabled = true)
	public void getURLUsingJsExecutor() {
		//correct syntax1
		String currentUrl = (String) js.executeScript("return document.URL");
		if(currentUrl.equals(driver.getCurrentUrl())) {
			Assert.assertTrue(true);
		}
//Correct syntax2
		String URL1 = js.executeScript("return document .URL").toString();
		//String URL2= js.executeScript().toString(documentURL);
		//String URL3= js.executeScript(return document URL;).toString();
		Assert.assertEquals(currentUrl, URL1);		


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
	public void BackgroundcolorSecondtext() throws InterruptedException {

		WebElement emailIcon = waittime.waitforclickable(driver, 30,driver.findElement((By.xpath(("//a[@id='ymail']")))));
		js.executeScript("arguments[0].click();", emailIcon);
		WebElement signinButton = waittime.waitforclickable(driver, 30,	driver.findElement((By.xpath(("//a[text()='Sign in']")))));
		js.executeScript("arguments[0].click()", signinButton);
		WebElement userName = waittime.waitforclickable(driver, 30, driver.findElement((By.name("username"))));
		String orignalstyleusename = userName.getAttribute("style");
		//backgroundcolorby Firstway
		Thread.sleep(5000);
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');", userName);
		// send the input
		js.executeScript("arguments[0].value='paragborawake81';", userName);
		Thread.sleep(5000);
		js.executeScript("arguments[0].setAttribute('style','" + orignalstyleusename + "');", userName);
		
		WebElement Next = waittime.waitforclickable(driver, 30,driver.findElement(By.xpath("//input[@name='signin']")));
		String orignalstyleNext = Next.getAttribute("style");
		Thread.sleep(5000);
		//backgroundcolorby secondway		
		js.executeScript("arguments[0].style.backgroundColor = 'yellow'; arguments[0].style.border = '2px solid red';", Next);
		
		Thread.sleep(5000);
		js.executeScript("arguments[0].setAttribute('style','" + orignalstyleNext + "');", Next);
		js.executeScript("arguments[0].click();", Next);

	}
	//get text
	@Test(priority = 1, enabled = true)
	public void getTextOfAnElement() throws InterruptedException 
	{
	System.out.println();
	
	WebElement webelement = waittime.getElementwithPolltime(driver, driver.findElement(By.xpath("//*[contains(text(),'Cricket')]")), 30, 5);
	String text = (String) js.executeScript("return arguments[0].textContent;", webelement);
	String text1 = (String) js.executeScript("return arguments[0].text;", webelement);

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
	public void ScrollToTop() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://jqueryui.com/");
		js.executeScript("window.scrollBy(0, 250);");
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		String firstWindow = driver.getWindowHandles().iterator().next();
		driver.switchTo().window(firstWindow);
		WebElement help = waittime.waitforclickable(driver, 30,	driver.findElement((By.xpath("(//a[text()='Help'][contains(@href,'https')])[2]"))));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", help);
		Thread.sleep(3000);
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');", help);
		String Actual = js.executeScript("return document.title;").toString();
		Assert.assertEquals(Actual, "Yahoo Search - Web Search");

	}
	//scrollbottom and top
		@Test(priority = 3, enabled = true)
		public void ScrollBottomAndTop() throws InterruptedException {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://jqueryui.com/");
			js.executeScript("window.scrollBy(0, 250);");
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");	

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

	@AfterMethod
	public void TearDown(ITestResult result) throws IOException {
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
