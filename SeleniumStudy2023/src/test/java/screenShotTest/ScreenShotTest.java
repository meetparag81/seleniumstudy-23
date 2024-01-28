package screenShotTest;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

public class ScreenShotTest implements IReporter {
  @Test
  public void SreenshotCreationTest() 
  {
	  
		}

  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

@Override
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	
	
}

}
