package actionSyntax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionPage {
	private WebDriver _driver;
	private Actions act;

	public ActionPage(WebDriver driver) {
		_driver = driver;
		act = new Actions(driver);
	}

	public WebElement movetoElement(WebElement element) {
		act.moveToElement(element);
		return element;
	}

}
