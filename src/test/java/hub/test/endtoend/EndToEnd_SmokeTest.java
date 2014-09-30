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
public class EndToEnd_SmokeTest extends TestInitReferenceSmokeTest {
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
			case "LOGIN":
				resultcount = endtoend.SuccessfulLogin();
					if (resultcount != 0) { fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		        
			case "HEALTHCHECK":
				resultcount = endtoend.HealthCheck();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "CFA":
				resultcount = endtoend.validateCantFindAddress();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "PRODUCTSELECTION":
				resultcount = endtoend.validateProceedProductSelection();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "SINGLELINEADDRESS":
				resultcount = endtoend.SingleLineAddress();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "PRODUCTSELECTIONVALUATION":
				resultcount = endtoend.ProductSelectionValuation();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
			case "INSTRUCTIONDETAILS":
				resultcount = endtoend.instructionDetails();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "PAYMENTDETAILS":
				resultcount = endtoend.paymentDetails();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		    
			case "ORDERCONFIRMATION":
				resultcount = endtoend.OrderConfirmation();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "MYTRANSACTION":
				resultcount = endtoend.myTransaction();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "LOGOUT":
				resultcount = endtoend.Logout();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
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
		        
			case "WPCBROKER":
				resultcount = endtoend.EndToEnd("wpcbroker");
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		     
			case "AUSSIESELECT":
				resultcount = endtoend.aussieSelectEndToEnd();
			        if (resultcount != 0) { fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "BANKMELBOURNE":
				resultcount = endtoend.EndToEnd("bankmelbourne");
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/EndToEnd_SmokeTest.xls");
		data = rxd.getData();
		return data;
	}
    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://stage-cbalender.rppropertyhub.com/login");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}
