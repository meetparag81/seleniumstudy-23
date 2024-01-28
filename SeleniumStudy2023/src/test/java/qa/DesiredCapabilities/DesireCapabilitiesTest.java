package qa.DesiredCapabilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ScrenshotMechanism.screenshotCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import waitMechanism.ExplicitWait;

public class DesireCapabilitiesTest {
  
  WebDriver driver;
	private JavascriptExecutor js;
	private ExplicitWait waittime;
	private String title;
	private screenshotCreation sc;
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		  
		  
	  }

@Test
  public void chromeBrowsercapabilitiesTest()
  {
	  ChromeOptions options = new ChromeOptions();
		//options.setCapability("acceptInsecureCerts", true);
			options.setAcceptInsecureCerts(true);
	WebDriverManager.chromedriver().driverVersion("120.0").setup();
	driver = new ChromeDriver(options);
	waittime = new ExplicitWait(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	js = (JavascriptExecutor) driver;
	sc=new screenshotCreation(driver);	
		driver.get("https://expired.badssl.com/");
  }
@Test
public void edgeBrowsercapabilitiesTest()
{
	  EdgeOptions options = new EdgeOptions();
		//options.setCapability("acceptInsecureCerts", true);
			options.setAcceptInsecureCerts(true);
			options.setCapability("ms:inPrivate", true);
			 //options.setCapability("start-maximized",true);
			 options.addArguments("--start-maximized");

	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver(options);
	waittime = new ExplicitWait(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	js = (JavascriptExecutor) driver;
	sc=new screenshotCreation(driver);	
		driver.get("https://expired.badssl.com/");
}
@Test
public void firefoxBrowsercapabilitiesTest()
{
	   FirefoxOptions options = new FirefoxOptions();
		//options.setCapability("acceptInsecureCerts", true);
			options.setAcceptInsecureCerts(true);
			options.setCapability("ms:inPrivate", true);
			 //options.setCapability("start-maximized",true);
			 options.addArguments("--start-maximized");
			    // Path to the Firefox profile
		        String firefox_profile_path = "/path/to/firefox/profile";

		        // Create a Firefox profile object
		        ProfilesIni profile = new ProfilesIni();
		        FirefoxProfile firefox_profile = profile.getProfile("automation");
		        // Create a Firefox options object
		         

		        // Set the Firefox profile to the Firefox options object
		        options.addPreference("webdriver.firefox.profile", firefox_profile_path);
		  

	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver(options);
	waittime = new ExplicitWait(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	js = (JavascriptExecutor) driver;
	sc=new screenshotCreation(driver);	
		driver.get("https://expired.badssl.com/");
}
@Test
public void operaBrowsercapabilitiesTest()
{
	/*
	 * OperaOptions options = new OperaOptions();
	 * options.setBinary("path/to/your/opera");
	 * //options.setCapability("acceptInsecureCerts", true);
	 * //options.setExperimentalOption(title, options);
	 * //options.setAcceptInsecureCerts(true);
	 * 
	 * //options.setCapability("start-maximized",true);
	 * options.addArguments("--start-maximized"); DesiredCapabilities cap = new
	 * DesiredCapabilities();
	 * 
	 * cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	 * cap.setCapability(OperaOptions.CAPABILITY, options); //
	 * WebDriverManager.operadriver().setup(); driver = new OperaDriver(options);
	 * System.out.println("OperaDriver Started");
	 */
			
		  

	
	
	waittime = new ExplicitWait(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	js = (JavascriptExecutor) driver;
	sc=new screenshotCreation(driver);	
		driver.get("https://expired.badssl.com/");
}



  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
