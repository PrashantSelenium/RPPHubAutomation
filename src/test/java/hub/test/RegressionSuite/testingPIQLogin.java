package hub.test.RegressionSuite;


import junit.framework.Assert;
import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;
import static org.openqa.selenium.By.xpath;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class testingPIQLogin extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
   
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }
    @BeforeClass
    public void init() {
           driver.navigate().to("http://iqtest01:ab-74USA-6@sit.qv.co.nz/");
    }
	@Test(description="User - Login", priority=0)
	public void RT_05397_Link_Navigation() throws Exception {
		
		Assert.assertTrue(isElementPresent(xpath("//*[@id='loginButton']")));
	}
}
