package hub.test.endtoend;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import hub.library.ReadXlsData;
import hub.library.TestInitReferenceSmokeTest;
import hub.utilities.EndToEnd.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

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
public class EndToEnd_SmokeTest extends TestInitReferenceSmokeTest {
	{
		System.setProperty("atu.reporter.config", ATULocation);
	}
	private DateFormat dateFormat = new SimpleDateFormat("HHmmss");
	private Date date = new Date();
	public String PromoCode = "Promo".concat(dateFormat.format(date)).substring(0, 10);;
		
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
	           driver.navigate().to("https://stage-cbalender.rppropertyhub.com/login");
	    }
	    
	    @AfterClass
	    public void closedriver(){
	    	driver.quit();
	    }
	    
	    private void setIndexPageDescription() {
	        ATUReports.indexPageDescription = "Hub";
	        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
	    }
	
	@Test(description="End To End Smoke Test", dataProvider = "Data-Provider-Function")
	public void testLogin(Class<?> clzz, String[] input) {
//		String testcase = "Smoke Test - " + input[0];
//		log(testcase);
//		logInput(input);

		try {
			UserHubEndToEndUtil_SmokeTest endtoend = new UserHubEndToEndUtil_SmokeTest(input);
					
			switch (input[0].toUpperCase()) {
			case "LOGIN":
				resultcount = endtoend.SuccessfulLogin();
					if (resultcount != 0) { Assert.fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		        
			case "HEALTHCHECK":
				resultcount = endtoend.HealthCheck();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
			    break;
			       
			case "CFA":
				resultcount = endtoend.validateCantFindAddress();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        		        
			case "SINGLELINEADDRESS":
				resultcount = endtoend.SingleLineAddress();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "PRODUCTSELECTIONVALUATION":
				resultcount = endtoend.ProductSelectionValuation();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
			case "INSTRUCTIONDETAILS":
				resultcount = endtoend.instructionDetails();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "PAYMENTDETAILS":
				resultcount = endtoend.paymentDetails();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		    
			case "ORDERCONFIRMATION":
				resultcount = endtoend.OrderConfirmation();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "MYTRANSACTION":
				resultcount = endtoend.myTransaction();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "LOGOUT":
				resultcount = endtoend.Logout();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "DEEPLINK":
				resultcount = endtoend.deepLink();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "ADMINPROMOTION":
				resultcount = endtoend.adminPromotion(PromoCode);
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		    
			case "MYACCOUNT":
				resultcount = endtoend.myAccount();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "MENUNAVIGATION":
				resultcount = endtoend.menuNavigation();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "CBABROKER":
				resultcount = endtoend.EndToEndCBABroker();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;        

			case "PROMOTIONWORKFLOW":
				resultcount = endtoend.PromotionWorkFlow(PromoCode);
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;   
		        
			case "RESETPASSWORD":
				resultcount = endtoend.ResetPassword();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;   
	        
			case "IDENTITYVERIFICATION":
				resultcount = endtoend.identityVerification();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else	 { pass(input[0]); }
		        break; 
		        
			case "BUILDVERSION":
				resultcount = endtoend.BuildVersion();
		        if (resultcount != 0) { Assert.fail(input[0]); } 
		        	else { pass(input[0]); }
	        break;
		        		        
			case "CFACOMBANK":
				resultcount = endtoend.CFACombank();
		        if (resultcount != 0) { Assert.fail(input[0]); } 
		        	else { pass(input[0]); }
	        break;
		        
			case "AUSSIESELECT":
				resultcount = endtoend.aussieSelectEndToEnd();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "BANKMELBOURNE":
				resultcount = endtoend.EndToEnd("bankmelbourne");
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		        
			case "WPCBROKER":
				resultcount = endtoend.EndToEnd("wpcbroker");
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else { pass(input[0]); }
		        break;
		            
			case "PROPERTYTITLE":
				resultcount = endtoend.propertyTitle();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else	 { pass(input[0]); }
		        break; 
			
			case "RULEX":
				resultcount = endtoend.rulex();
			        if (resultcount != 0) { Assert.fail(input[0]); } 
			        	else	 { pass(input[0]); }
		        break; 
			
			default:
				Assert.fail(input[0]);
		        AssertJUnit.fail("Invalid Test Data");
		        break;
			}
		} catch (Exception e) {
			Assert.fail(input[0]);
			e.printStackTrace();
	        AssertJUnit.fail("Exception was thrown");
		}

	}
}
