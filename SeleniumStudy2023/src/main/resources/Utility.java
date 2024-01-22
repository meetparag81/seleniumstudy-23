import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	private WebDriver _webdriver
	public Utility(WebDriver driver) {
		this._webdriver=driver;
	}
	
	public void takeScreenshot(WebDriver driver, String fileName, String status) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime myObj = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("MMddHH");
		String formattedDate = myObj.format(myFormat);
		fileName = fileName + formattedDate;
		if (status.equals("passed")) {
			String foldername = status + "Screenshots/";
		} else if (status.equals("failed")) {
			String foldername = status + "Screenshots/";
		} else if (status.equals("skiped")) {
			String foldername = status + "Screenshots/";
		}
		FileUtils.copyFile(screenshot, new File("Screenshots"+"_"+status+"/" + fileName + ".png"));
	}

}
