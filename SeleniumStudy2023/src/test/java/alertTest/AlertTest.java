package alertTest;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;

public class AlertTest {
	private WebDriver driver;
	private screenshotCreation sc;

	@Test
	public void AlertTest() {
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\MyWorkspace\\SeleniumStudy2023\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		sc = new screenshotCreation(driver);

	}

	@Test(priority = 1, enabled = true)
	public void acceptAlert() throws InterruptedException, IOException {

		driver.findElement(By.name("cusid")).sendKeys("53920");
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(7000);
		driver.switchTo().alert().accept();
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String status = Thread.currentThread().getStackTrace()[1].getMethodName();
		boolean isPassed = true;
		status = isPassed ? "passed" : "failed";

		System.out.println(methodName);
		System.out.println("status of" + methodName + "is " + status);
		sc.takeScreenshot(driver, methodName, status);
	}

	@Test(priority = 1, enabled = false)
	public void acceptAlert(ITestResult result) throws InterruptedException, IOException {
		driver.findElement(By.name("cusid")).sendKeys("53920");
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(7000);
		driver.switchTo().alert().accept();
		sc.takeScreenshot(driver, result);
	}

	@Test(priority = 3, enabled = true)
	public void dismissAlert() throws InterruptedException {

		driver.findElement(By.name("cusid")).sendKeys("53920");
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(7000);
		driver.switchTo().alert().dismiss();
	}

	@Test(priority = 4, enabled = true)
	public void gettextfromAlert() throws InterruptedException {

		driver.findElement(By.name("cusid")).sendKeys("53920");
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(7000);
		String Actual = driver.switchTo().alert().getText();
		Assert.assertEquals(Actual, "Do you really want to delete this Customer?");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
