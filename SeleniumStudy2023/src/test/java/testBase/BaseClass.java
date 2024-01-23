package testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	private DesiredCapabilities dc;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public WebDriver initalizeBrowser(String browsername,boolean flag) throws MalformedURLException 
	{
		WebDriver driver = null;
		boolean remotedriverflag=false;
		if(flag==true) 
		{
			AbstractDriverOptions options = null;
			if(browsername.equals("chrome")) 
			{
				WebDriverManager.chromedriver().driverVersion("120.0").setup();
				//ChromeDriverManager.chromedriver().driverVersion("120.0").setup();
				//ChromeDriverManager.chromedriver().setup();
				 options = new ChromeOptions();
					//options.setCapability("browserVersion", "120.0");
					options.setCapability("platformName", "Windows");
					options.setCapability("acceptInsecureCerts", true);
					options.setCapability("platformName", "Windows");
					((ChromiumOptions<ChromeOptions>) options).addArguments("--disable-infobars");
					((ChromiumOptions<ChromeOptions>) options).addArguments("--disable-notifications");
					((ChromiumOptions<ChromeOptions>) options).addArguments("--disable-single-click-autofill");
			        ((ChromiumOptions<ChromeOptions>) options).addArguments("--disable-popup-blocking");
			        ((ChromiumOptions<ChromeOptions>) options).addArguments("--disable-infobars");
			        ((ChromiumOptions<ChromeOptions>) options).addArguments("--disable-notifications");
			        
			        ((ChromiumOptions<ChromeOptions>) options).setExperimentalOption("prefs", 
			                new ImmutableMap.Builder<String, Object>()
			                    .put("profile.default_content_setting_values.automatic_downloads", 1)
			                    .put("download.prompt_for_download", false).build());
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
					remotedriverflag=true;

					
				}
				else if (browsername.equals("edge")) 
				{
					WebDriverManager.edgedriver().driverVersion("120.0").setup();
				 options = new EdgeOptions();
				 
				 
						 //Set the desired capabilities
						 options.setCapability("ignoreZoomSetting", true);
						 options.setCapability("requireWindowFocus", true);
						 options.setCapability("acceptInsecureCerts", true);
						 options.setCapability("ignoreProtectedModeSettings", true);
						 //options.setCapability("initialBrowserUrl", "https://www.example.com");
						 options.setCapability("ms:inPrivate", true);
						 options.setCapability("start-maximized",true);
				 

				

			}
			else if (browsername.equals("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
			      // Path to the Firefox profile
		        String firefox_profile_path = "/path/to/firefox/profile";

		        // Create a Firefox profile object
		        ProfilesIni profile = new ProfilesIni();
		        FirefoxProfile firefox_profile = profile.getProfile("automation");
		        // Create a Firefox options object
		         options = new FirefoxOptions();

		        // Set the Firefox profile to the Firefox options object
		        ((FirefoxOptions) options).addPreference("webdriver.firefox.profile", firefox_profile_path);



		       
			}
			
			else if (browsername.equals("safari")) 
			{
				dc.setBrowserName("safari");

			}else if (browsername.equals("opera")) 
			{
				
				WebDriverManager.operadriver().setup();
				/*
				 * OperaOptions options1 = new OperaOptions(); driver = new RemoteWebDriver(new
				 * URL("http://localhost:4444/wd/hub"), (Capabilities) options1);
				 */
			}
			else if (browsername.equals("ie")) 
			{
				WebDriverManager.iedriver().setup();
				
				dc.setCapability("ignoreZoomSetting", true);
				dc.setCapability("requireWindowFocus", true);
				dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				dc.setCapability("ignoreProtectedModeSettings", true);
				dc.setCapability("initialBrowserUrl", "https://www.example.com");
				dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

				 options = new InternetExplorerOptions();
				driver = new InternetExplorerDriver((InternetExplorerOptions) options);
				((InternetExplorerOptions) options).waitForUploadDialogUpTo(Duration.ofSeconds(2));
				
				dc.setBrowserName("internet explorer");

			}
			if(browsername.equals("opera")) 
			{
				
			}
			else 
			{
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			}
			
			
			
		}
		else 
		{
//desiredcapabilities
			dc= new DesiredCapabilities();

			ChromeOptions options = new ChromeOptions();
			options.setCapability("acceptInsecureCerts", true);
			dc.setBrowserName("chrome");
			driver =  new RemoteWebDriver( new URL("http://localhost:4444/wd/hub"),dc);
			
		}
			
		
		
	
		return driver;
		
		
	}

}


