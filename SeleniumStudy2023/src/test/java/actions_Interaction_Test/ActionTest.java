package actions_Interaction_Test;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class ActionTest {

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
	//drag and drop
	@Test(priority=1,enabled=true)
	public void DragElemetFromSurceToDestination() throws InterruptedException 
	{
		driver.navigate().to("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement osloBox = driver.findElement(By.id("box1"));
		String orignalstyle = osloBox.getAttribute("style");
		//js.executeScript("arguments[0].setAttribute('style','background:yellow;,border:2px solid red;');",  searchBoxField);
		js.executeScript("arguments[0].setAttribute('style','background:yellow;,border:2px solid red;');", osloBox);
          WebElement norwayBox = driver.findElement(By.id("box101"));
          act.clickAndHold(osloBox).pause(Duration.ofSeconds(15));
          act.moveToElement(norwayBox).build().perform();
          act.dragAndDrop(norwayBox, osloBox).build().perform();
          
          js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", osloBox);
		
	}
	//ContextOrRightClick
	@Test(priority=2,enabled=true)
	public void context_Or_RighClick() throws InterruptedException
	{

        WebElement searchBoxField = driver.findElement(By.name("q"));
        js.executeScript("arguments[0].setAttribute('style','background:yellow;,border:2px solid red;');",  searchBoxField);
        act.contextClick(searchBoxField).build().perform();
        Thread.sleep(5000);
	}
	//DoubleClick
	@Test(priority=3,enabled=false)
	public void doubleClick() throws InterruptedException
	{
		
        WebElement doubleClickOption = driver.findElement(By.id("testdoubleclick"));
        js.executeScript("arguments[0].scrollIntoView();", doubleClickOption);
        js.executeScript("arguments[0].setAttribute('style','background:yellow;,border:2px solid red;');",doubleClickOption);
        act.doubleClick(doubleClickOption).build().perform();
        Thread.sleep(5000);
        
	}
	//DragandDropBy to handle slider
	@Test(priority=4,enabled=false)
	public void slidetheslider() throws InterruptedException {
		System.out.println();
		driver.navigate().to("https://jqueryui.com/slider");
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement frameele = driver.findElement((By.xpath("//iframe[@class='demo-frame']")));
		driver.switchTo().frame(frameele);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		waitTime.waitforclickable(driver, 20, element);

		try {
			act.dragAndDropBy(element, 100, 0).build().perform();
		} catch (Exception e) {
			System.out.println("wrapperexception" + e);
			System.out.println("Underlying exception" + e.getCause());
		}
	}
	//DragandDropBy to handle slider
	@Test(priority=5,enabled=false)
	public void DrangAndDropSliderTest() throws InterruptedException
	{
		driver.navigate().to("http://omayo.blogspot.com/p/page3.html");
		WebElement element =  driver.findElement(By.xpath("//a[@aria-labelledby='price-min-label']"));
		String orignalstyle = element.getAttribute("style");
		//js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:2px solid red;');", Element);
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:2px solid red;');",element);
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.dragAndDropBy(element, 100, 0).build().perform();
		Thread.sleep(2000);
		act.dragAndDropBy(element, -200, 0).build().perform();
		Thread.sleep(2000);
	}
	
	// Use Tab from keyboard to navigate two  input boxes
	@Test(priority=6,enabled=false)
	public void TabBySendKeys() throws InterruptedException 
	{	  
		Thread.sleep(4000);
		WebElement userId =waitTime.waitforclickable(driver, 30, driver.findElement(By.name("userid")));
		String orignalstyle = userId.getAttribute("style");

		js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:2px solid red;');",userId);
		driver.findElement(By.name("userid")).sendKeys("arun");
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", userId);
		//act.sendKeys(Keys.TAB).build();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		String orignalstylepass = userId.getAttribute("style");
		WebElement password =waitTime.waitforclickable(driver, 30, driver.findElement(By.name("pswrd")));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:2px solid red;');",password);
		driver.findElement(By.name("pswrd")).sendKeys("arun");
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style','" + orignalstylepass + "');", password);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(4000);
		act.sendKeys(Keys.ENTER);

	}
	//SendText in capitalLetter
	@Test(priority=7,enabled=false)
	public void SendTheStringInCapitalLetter() throws InterruptedException 
	{
		WebElement Element =  waitTime.waitforclickable(driver, 30, driver.findElement((By.xpath(("//textarea[@id='ta1']")))));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:2px solid red;');", Element);
		Thread.sleep(10000);
		act.keyDown(Element, Keys.SHIFT).sendKeys("capital").keyUp(Keys.SHIFT);
		Thread.sleep(4000);
		act.keyDown(Element, Keys.SHIFT).sendKeys("capital").keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(10000);


	}
	//open link using keyboard action
	@Test(priority=9,enabled=true)
	public void hoverWaitAndClick() throws InterruptedException {
		WebElement Element =  waitTime.waitforclickable(driver, 30, driver.findElement((By.xpath(("//textarea[@id='ta1']")))));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:2px solid red;');", Element);
		// Create an instance of the Actions class
		

		// Move the mouse cursor to the element and click on it in one chain
		act.moveToElement(Element).pause(20).click().build().perform();

	}

	@Test(priority=8,enabled=false)
	public void openLinkUsingControlkey() throws InterruptedException {
		System.out.println();
		// WebElement element =  driver.findElement(By.xpath("(//a[contains(@class,'ui-slider-handle')])[1]"));
		Actions act = new Actions(driver);
		Thread.sleep(10000);
		String parentwindow = driver.getWindowHandle();
		act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//a[text()='Open a popup window']"))).keyUp(Keys.CONTROL).build().perform();
		Set<String> windows = driver.getWindowHandles();
		for (String string : windows) 
		{
			if(!string.equals(parentwindow)) {
				driver.switchTo().window(string);
				Thread.sleep(5000);
				driver.close();
				
			}


		}
		driver.switchTo().window(parentwindow);
		String tile = driver.getTitle();
		Assert.assertEquals(tile, "omayo (QAFox.com)");
	}
	//open link using keyboard action
	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}
}
