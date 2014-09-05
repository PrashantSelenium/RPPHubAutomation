package hub.test.endtoend;

import hub.library.ReadXlsData;
import hub.library.TestInitReferenceSmokeTest;
import hub.utilities.EndToEnd.*;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class EndToEnd_SmokeTest_Part2 extends TestInitReferenceSmokeTest {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}

	@Test(description="End To End Smoke Test", dataProvider = "Data-Provider-Function")
	public void testLogin(Class<?> clzz, String[] input) {
		String testcase = "Smoke Test - " + input[0];
		log(testcase);
		logInput(input);

		try {
			UserHubEndToEndUtil_SmokeTest endtoend = new UserHubEndToEndUtil_SmokeTest(input);
			
			switch (input[0].toUpperCase()) {
		        
			case "DEEPLINK":
				resultcount = endtoend.deepLink();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "ADMINPROMOTION":
				resultcount = endtoend.adminPromotion();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		    
			case "MYACCOUNT":
				resultcount = endtoend.myAccount();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "MENUNAVIGATION":
				resultcount = endtoend.menuNavigation();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			default:
				fail(testcase);
		        Assert.fail("Invalid Test Data");
		        break;
			}
		} catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}

	}

	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException {
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/EndToEnd_SmokeTestPart2.xls");
		data = rxd.getData();
		return data;
	}
    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://stage-cbalender.rppropertyhub.com");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}
