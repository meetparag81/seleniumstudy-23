package waitMechanism;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Implicitwait {

	WebDriver _driver;

	public Implicitwait(WebDriver driver) {
		this._driver = driver;

	}

	public void staticwait(long input) throws InterruptedException {
		Thread.sleep(input);

	}

	public void implicitWait(long waittime) {

		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waittime));
	}

}
