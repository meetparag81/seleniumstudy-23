package ScrenshotMechanism;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class screenshotCreation {
	WebDriver _driver;

	public screenshotCreation(WebDriver driver) {
		this._driver = _driver;
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

	public void takeScreenshot(WebDriver driver, ITestResult result) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folderName = result.getStatus() == ITestResult.FAILURE ? "fail" : "pass";
		File folder = new File(folderName);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String fileName = result.getName() + ".png";
		File dest = new File(folder, fileName);
		FileUtils.copyFile(screenshot, dest);
	}

}
