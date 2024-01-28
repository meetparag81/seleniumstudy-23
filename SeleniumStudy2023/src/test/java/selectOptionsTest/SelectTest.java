package selectOptionsTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;
import actionSyntax.ActionPage;
import waitMechanism.ExplicitWait;

public class SelectTest {

	private ChromeDriver driver;
	private screenshotCreation sc;
	private ExplicitWait waittime;
	private ActionPage act;
	private JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {

		
		driver = new ChromeDriver();
		sc = new screenshotCreation(driver);
		waittime = new ExplicitWait(driver);
		js = (JavascriptExecutor) driver;
		act = new ActionPage(driver);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();

	}
	@Test (priority = 1, enabled = false)
	public void SelectByIndex() throws InterruptedException 
	{
		driver.navigate().to("http://omayo.blogspot.com/");
		 //Write code here
        WebElement dropdownField = driver.findElement(By.id("drop1"));
        
        Select select = new Select(dropdownField);
         select.selectByIndex(3);
        
        WebElement multiSelectionBoxField = driver.findElement(By.id("multiselect1"));
        Select select2 = new Select(multiSelectionBoxField);
       String  orignalstyle=multiSelectionBoxField.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",multiSelectionBoxField);
        Thread.sleep(5000); 
        select2.selectByIndex(3);
         Thread.sleep(5000);
         select2.selectByIndex(0);
         Thread.sleep(5000);
         select2.selectByIndex(3);
         Thread.sleep(5000);
         js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", multiSelectionBoxField);
	}
	@Test(priority = 2, enabled = false)
	public void selectcolour() throws InterruptedException {

		WebElement WidgetTextElemet = waittime.waitforclickable(driver,30,	driver.findElement((By.xpath("//div[text()='Widgets']"))));
		js.executeScript("arguments[0].scrollIntoView(true);", WidgetTextElemet);
		WebElement WidgetElemet = waittime.waitforclickable(driver,30,	driver.findElement((By.xpath("//div[text()='Widgets']//following::div[@class='icon']"))));
		js.executeScript("arguments[0].scrollIntoView(true);", WidgetTextElemet);
		WidgetElemet.click();
		 WebElement SelectMenu=waittime.waitforclickable(driver, 30, driver.findElement((By.xpath("//span[text()='Select Menu']//ancestor::li"))));
		 js.executeScript("arguments[0].scrollIntoView(true);", SelectMenu);
		 js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",SelectMenu);
		 SelectMenu.click();
		WebElement selectElement=waittime.waitforclickable(driver, 30, driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		List<WebElement> carsoptions = sel.getOptions();
		for (WebElement colour : carsoptions) 
		{
			if(colour.getText().equals("Yellow"))
			{
				js.executeScript("arguments[0].scrollIntoView(true);", selectElement);
				js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",colour);
				Thread.sleep(5000);
				sel.selectByVisibleText("Purple");
				break;
			}


			
			

		}
	}
	@Test(priority = 3, enabled = false)
	public void selectcountry() throws InterruptedException {

		WebElement WidgetTextElemet = waittime.waitforclickable(driver,30,	driver.findElement((By.xpath("//div[text()='Widgets']"))));
		js.executeScript("arguments[0].scrollIntoView(true);", WidgetTextElemet);
		WebElement WidgetElemet = waittime.waitforclickable(driver,30,	driver.findElement((By.xpath("//div[text()='Widgets']//following::div[@class='icon']"))));
		js.executeScript("arguments[0].scrollIntoView(true);", WidgetTextElemet);
		WidgetElemet.click();
		 WebElement SelectMenu=waittime.waitforclickable(driver, 30, driver.findElement((By.xpath("//span[text()='Select Menu']//ancestor::li"))));
		 js.executeScript("arguments[0].scrollIntoView(true);", SelectMenu);
		 js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",SelectMenu);
		 SelectMenu.click();
		WebElement selectElement=waittime.waitforclickable(driver, 30, driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		List<WebElement> carsoptions = sel.getOptions();
		for (WebElement car : carsoptions) 
		{
			if(car.getText().equals("Volvo"))
			{
				js.executeScript("arguments[0].scrollIntoView(true);", selectElement);
				String orignalstyle = car.getAttribute("style");
				js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",car);
				sel.selectByVisibleText("Volvo");
				js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", car);
			}


			sel.selectByVisibleText("Opel");
			Thread.sleep(5000);
			sel.deselectByVisibleText("Volvo");
			break;

		}
	}	
	@Test(priority = 4, enabled = false)
	public void SelectByVisibleText() throws InterruptedException 
	{
		driver.navigate().to("http://omayo.blogspot.com/");
		 //Write code here
        WebElement dropdownField = driver.findElement(By.id("drop1"));
        
        Select select = new Select(dropdownField);
         select.selectByVisibleText("doc 3");
        
        WebElement multiSelectionBoxField = driver.findElement(By.id("multiselect1"));
        Select select2 = new Select(multiSelectionBoxField);
       String  orignalstyle=multiSelectionBoxField.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",multiSelectionBoxField);
         select2.selectByVisibleText("Audi");
         select2.selectByVisibleText("Volvo");
         select2.deselectByVisibleText("Audi");
         js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", multiSelectionBoxField);
	}
	@Test(priority=4,enabled=false)
	public void TestIsMultiple() throws InterruptedException  {
		Thread.sleep(3000);
        
        //Write code here
       WebElement dropdownField =waittime.waitforclickable(driver, 20,  driver.findElement(By.id("drop1")));
       Select select = new Select(dropdownField) ;
       //check element supports  the selection of multiple options  
       System.out.println(select.isMultiple());
	}
	@Test(priority=5,enabled=false)
	public void getOptionsTest() throws InterruptedException  {
		driver.navigate().to("http://omayo.blogspot.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		//Write code here
		WebElement dropdownField =waittime.waitforclickable(driver, 20,  driver.findElement(By.id("drop1")));
		Select select = new Select(dropdownField) ;

		for (WebElement element: select.getOptions()) 
		{
			System.out.println("elements in dropdown fields are "+element.getText());
			select.selectByVisibleText(element.getText());

		}
	}
	@Test(priority=6,enabled=false)
	public void SelectFirstOption() throws InterruptedException  {
		driver.navigate().to("http://omayo.blogspot.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		//Write your code here
		WebElement multiselectionBoxField = driver.findElement(By.id("multiselect1"));

		Select select = new Select(multiselectionBoxField);
		select.selectByVisibleText("Volvo");
		select.selectByVisibleText("Hyundai");

		WebElement element = select.getFirstSelectedOption();

		System.out.println("The firstSelected optionn this dropdown field is "+element.getText());

	}
	@Test (priority=7,enabled=true)
	public void getAllSelectedOptions()
	{
		driver.navigate().to("http://omayo.blogspot.com/");
		 //Write code here
       WebElement dropdownField = driver.findElement(By.id("drop1"));
       
       Select select = new Select(dropdownField);
        select.selectByVisibleText("doc 3");
       
       WebElement multiSelectionBoxField = driver.findElement(By.id("multiselect1"));
       Select select2 = new Select(multiSelectionBoxField);
      String  orignalstyle=multiSelectionBoxField.getAttribute("style");
       js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",multiSelectionBoxField);
        select2.selectByVisibleText("Audi");
        select2.selectByVisibleText("Volvo");
        select2.selectByVisibleText("Swift");
        js.executeScript("arguments[0].setAttribute('style','" + orignalstyle + "');", multiSelectionBoxField);
		WebElement multiselectionBoxField = driver.findElement(By.id("multiselect1"));

		Select sel = new Select(multiselectionBoxField);
		WebElement opt = sel.getFirstSelectedOption();
		List<WebElement> opts = sel.getAllSelectedOptions();
		int counter=0;
		for (WebElement wb : opts) 
		{
			if(wb.getText().equals("Audi")||wb.getText().equals("Volvo")||wb.getText().equals("Swift")) 
			{
				System.out.println(wb.getText()+"is at index"+counter);
				counter++;
			}
			
			
		}
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException 
	{
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
