package CI;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;
import java.net.URL;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import atu.testng.reports.utils.Platform;

public class WebDriverTest {

    private WebDriver driver;
    {
    //@Parameters{("support-tooltwist", "69845b25-d4b1-4420-9c59-b1dcf06b479d", "os", "browser", "browserVersion")};
    }
    
    @BeforeMethod
	public void setUp(@Optional("support-tooltwist") String username,
                      @Optional("69845b25-d4b1-4420-9c59-b1dcf06b479d") String key,
                      @Optional("xp") String os,
                      @Optional("Firefox") String browser,
                      @Optional("28.0") String browserVersion, Method method) 
                    		  
                  throws Exception {

        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", os);
        capabilities.setCapability("name", method.getName());
        // Create the connection to Sauce Labs to run the tests
        this.driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
    }

    @Test
    public void webDriver() throws Exception {
        // Make the browser get the page and check its title
        driver.get("http://www.amazon.com/");
        AssertJUnit.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    private void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}

	@AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}