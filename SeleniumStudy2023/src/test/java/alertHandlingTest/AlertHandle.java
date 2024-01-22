package alertHandlingTest;

import org.openqa.selenium.WebDriver;

import waitMechanism.ExplicitWait;

public class AlertHandle {
	private WebDriver _driver;
	private ExplicitWait explicitWait;

	AlertHandle(WebDriver driver) {
		this._driver = driver;
		explicitWait = new ExplicitWait(driver);
	}

	public void acceptAlert() {
		explicitWait.alertIsPresent(_driver, 30).accept();
	}

}
