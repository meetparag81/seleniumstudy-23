package waitMechanism;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	WebDriver _driver;

	public ExplicitWait(WebDriver driver) {
		this._driver = driver;
	}

	public WebDriverWait dynamicWait(WebDriver driver, long timeOutInSeconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	}

	public WebElement waitforclickable(WebDriver driver, long timeOutInSeconds, WebElement element) {
		return dynamicWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));

	}

	public WebElement waitforvisibillity(WebDriver driver, long timeOutInSeconds, WebElement element) {
		return dynamicWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));

	}

	public Boolean waitforstalness(WebDriver driver, long timeOutInSeconds, WebElement element) {
		return dynamicWait(driver, timeOutInSeconds).until(ExpectedConditions.stalenessOf(element));

	}

	public Boolean waitforSelectable(WebDriver driver, long timeOutInSeconds, WebElement element) {
		return dynamicWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeSelected(element));

	}

	public List<WebElement> waitforElementstoBeVisible(WebDriver driver, long timeOutInSeconds,
			List<WebElement> element) {
		return dynamicWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfAllElements(element));

	}

	public Boolean waitforElementstoBeVisible(WebDriver driver, long timeOutInSeconds, WebElement element) {
		return dynamicWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeSelected(element));

	}

	public Alert alertIsPresent(WebDriver driver, long timeOutInSeconds) {
		return dynamicWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());

	}

	public  WebElement getElementwithPolltime(WebDriver driver, WebElement element, long waittime,long pollingtime) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(waittime))
				.pollingEvery(Duration.ofSeconds(pollingtime)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public  boolean isStale(WebElement element) {
	    try {
	        element.isEnabled();
	        return false;
	    } 
	    catch (StaleElementReferenceException sere) 
	    {
	        return true;
	    }
	}


}
