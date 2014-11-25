package hub.test.endtoend;

import hub.library.ReadXlsData;
import hub.library.TestInitReferenceSmokeTest;
import hub.utilities.EndToEnd.*;

import java.io.IOException;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;


//************************************************************************************************************************//
//THINGS TO CONSIDER BEFORE RUNNING THE SCRIPT																		      //
//																														  //
//Change EndToEnd_SmokeTest.java @BeforeClass URL - "Stage-" for stage "Dev-" for dev and "https://CHANNEL" for production//
//Update UserHubEndToEndUtil_smoketest.java - Set environment string based from the list								  //
//Update EndToEnd_smoketest.xls based - Search for the BuildVersion and update to current Version name					  //
//																														  //
//************************************************************************************************************************//

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Sample extends TestInitReferenceSmokeTest {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}

	public class WebDriverTest {

	    @Before
	    public void setUp() throws Exception {
	        // Choose the browser, version, and platform to test
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        capabilities.setCapability("version", "5");
	        capabilities.setCapability("platform", Platform.XP);
	        // Create the connection to Sauce Labs to run the tests
	        driver = new RemoteWebDriver(
	                new URL("http://support-tooltwist:69845b25-d4b1-4420-9c59-b1dcf06b479d@ondemand.saucelabs.com:80/wd/hub"),
	                capabilities);
	    }

	    @Test
	    public void webDriver() throws Exception {
	        // Make the browser get the page and check its title
	        driver.get("http://www.amazon.com/");
	        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
	    }

	    private void assertEquals(String string, String title) {
			// TODO Auto-generated method stub
			
		}

		@After
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

	}

}
