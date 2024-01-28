package javascriptExecutorTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class JS_Syntaxcheck {

	private static ExplicitWait waittime;
	private static WebDriver driver;


	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println();
		
		WebDriverManager.chromedriver().driverVersion("120.0").setup();
		driver = new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		waittime = new ExplicitWait(driver);
		WebElement userName; 
		//OpenURL
		js.executeScript("window.location.href='https://in.search.yahoo.com/?fr2=inr';");
		WebElement emailIcon = waittime.waitforclickable(driver, 30,driver.findElement((By.xpath(("//a[@id='ymail']")))));
		//scroll to View
		js.executeScript("arguments[0].scrollIntoView(true)",emailIcon);
	String	orignalstyleEmailIcon=emailIcon.getAttribute("style");
//highlight an element
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');", emailIcon);
		
		//click the element
		js.executeScript("arguments[0].click();", emailIcon);
		
		Thread.sleep(5000);
		  WebElement signinButton = waittime.waitforclickable(driver, 30, driver.findElement((By.xpath(("//a[text()='Sign in']")))));
		  
		  js.executeScript("arguments[0].click()", signinButton);
		  Thread.sleep(5000);
		 userName = waittime.getElementwithPolltime(driver,driver.findElement(By.xpath("//input[@id='login-username']")) ,30,2);
		boolean flag= waittime.isStale(userName);
		if(flag==false) 
		{
			userName = waittime.waitforclickable(driver, 30, driver.findElement((By.xpath("//input[@id='login-username']"))));	
		}
		 
		
		String orignalstyleusename = userName.getAttribute("style");
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');",userName);
		// send the input
		js.executeScript("arguments[0].value='paragborawake81';",userName);
		js.executeScript("arguments[0].setAttribute('style','" + orignalstyleusename + "');", userName);
		WebElement Next  =waittime.waitforclickable(driver, 30,driver.findElement(By.name("signin")));
		js.executeScript("arguments[0].click();",Next);
		//get URL
	String URL=	js.executeScript("return document.URL").toString();
		//get title
	String Title=	js.executeScript("return document.title").toString();
		//scroll to bottom
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0,document.body.sctoolHeight)");
		//scroll to Up
	//	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0,-document.scrollHeight)");
				//scroll by pixcel
				//js.executeScript("window.scrollBy(0, -250);");
				js.executeScript("window.scrollBy(0,-250);");
				driver.quit();
	}





}


