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
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHubxxx/conf/atu.properties");
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
	        ATUReports.indexPageDescription = "Corlogic-Hub";
	        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
	    }
	
	@Test(description="End To End Smoke Test", dataProvider = "Data-Provider-Function")
	public void testLogin(Class<?> clzz, String[] input) {

		try {
			UserHubEndToEndUtil_SmokeTest endtoend = new UserHubEndToEndUtil_SmokeTest(input);
					
			switch (input[0].toUpperCase()) {
  			case "LOGIN":
				System.out.println("2 In Progress - " + input[0]);
				resultcount = endtoend.SuccessfulLogin();
					if (resultcount != 0) { 
						System.out.println("2 FAILED - " + input[0]);
						Assert.fail(input[0]); } 
						else { passed(input[0], "2"); }
		        break;
		        
			case "HEALTHCHECK":
				System.out.println("1 In Progress - " + input[0]);
				resultcount = endtoend.HealthCheck();
			        if (resultcount != 0) { 
			        	System.out.println("1 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        	else { passed(input[0], "1"); }
			    break;
			       
			case "CFA":
				System.out.println("3 In Progress - " + input[0]);
				resultcount = endtoend.validateCantFindAddress();
			        if (resultcount != 0) { 
			        	System.out.println("3 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "3"); }
		        break;
		        		        
			case "SINGLELINEADDRESS":
				System.out.println("4 In Progress - " + input[0]);
				resultcount = endtoend.SingleLineAddress();
			        if (resultcount != 0) { 
			        	System.out.println("4 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "4"); }
		        break;
		        
			case "PRODUCTSELECTIONVALUATION":
				System.out.println("5 In Progress - " + input[0]);
				resultcount = endtoend.ProductSelectionValuation();
			        if (resultcount != 0) { 
			        	System.out.println("5 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "5"); }
		        break;
			case "INSTRUCTIONDETAILS":
				System.out.println("6 In Progress - " + input[0]);
				resultcount = endtoend.instructionDetails();
			        if (resultcount != 0) { 
			        	System.out.println("6 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "6"); }
		        break;
		        
			case "PAYMENTDETAILS":
				System.out.println("7 In Progress - " + input[0]);
				resultcount = endtoend.paymentDetails();
			        if (resultcount != 0) { 
			        	System.out.println("7 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "7"); }
		        break;
		    
			case "ORDERCONFIRMATION":
				System.out.println("8 In Progress - " + input[0]);
				resultcount = endtoend.OrderConfirmation();
			        if (resultcount != 0) { 
			        	System.out.println("8 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "8"); }
		        break;
		        
			case "MYTRANSACTION":
				System.out.println("9 In Progress - " + input[0]);
				resultcount = endtoend.myTransaction();
			        if (resultcount != 0) { 
			        	System.out.println("9 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "9"); }
		        break;
		        
			case "LOGOUT":
				System.out.println("10 In Progress - " + input[0]);
				resultcount = endtoend.Logout();
			        if (resultcount != 0) { 
			        	System.out.println("10 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "10"); }
		        break;
		        
			case "DEEPLINK":
				System.out.println("11 In Progress - " + input[0]);
				resultcount = endtoend.deepLink();
			        if (resultcount != 0) { 
			        	System.out.println("11 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "11"); }
		        break;
		        
			case "ADMINPROMOTION":
				System.out.println("12 In Progress - " + input[0]);
				resultcount = endtoend.adminPromotion(PromoCode);
			        if (resultcount != 0) { 
			        	System.out.println("12 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "12"); }
		        break;
		    
			case "MYACCOUNT":
				System.out.println("13 In Progress - " + input[0]);
				resultcount = endtoend.myAccount();
			        if (resultcount != 0) { 
			        	System.out.println("13 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "13"); }
		        break;
		        
			case "MENUNAVIGATION":
				System.out.println("14 In Progress - " + input[0]);
				resultcount = endtoend.menuNavigation();
			        if (resultcount != 0) { 
			        	System.out.println("14 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "14"); }
		        break;
		        
			case "CBABROKER":
				System.out.println("15 In Progress - " + input[0]);
				resultcount = endtoend.EndToEndCBABroker();
			        if (resultcount != 0) { 
			        	System.out.println("15 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "15"); }
		        break;        

			case "PROMOTIONWORKFLOW":
				System.out.println("16 In Progress - " + input[0]);
				resultcount = endtoend.PromotionWorkFlow(PromoCode);
			        if (resultcount != 0) { 
			        	System.out.println("16 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "16"); }
		        break;   
		        	        
			case "BUILDVERSION":
				System.out.println("17 In Progress - " + input[0]);
				resultcount = endtoend.BuildVersion();
		        if (resultcount != 0) { 
		        	System.out.println("17 FAILED - " + input[0]);
		        	Assert.fail(input[0]); } 
		        else { passed(input[0], "17"); }
	        break;
		        		        
			case "CFACOMBANK":
				System.out.println("18 In Progress - " + input[0]);
				resultcount = endtoend.CFACombank();
		        if (resultcount != 0) { 
		        	System.out.println("18 FAILED - " + input[0]);
		        	Assert.fail(input[0]); } 
		        else { passed(input[0], "18"); }
	        break;
		        
			case "AUSSIESELECT":
				System.out.println("19 In Progress - " + input[0]);
				resultcount = endtoend.aussieSelectEndToEnd();
			        if (resultcount != 0) { 
			        	System.out.println("19 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "19"); }
		        break;
		        
			case "BANKMELBOURNE":
				System.out.println("20 In Progress - " + input[0]);
				resultcount = endtoend.EndToEnd("bankmelbourne");
			        if (resultcount != 0) { 
			        	System.out.println("20 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "20"); }
		        break;
		        
			case "WPCBROKER":
				System.out.println("21 In Progress - " + input[0]);
				resultcount = endtoend.EndToEnd("wpcbroker");
			        if (resultcount != 0) { 
			        	System.out.println("21 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "21"); }
		        break;
		            
			case "PROPERTYTITLE":
				System.out.println("22 In Progress - " + input[0]);
				resultcount = endtoend.propertyTitle();
			        if (resultcount != 0) { 
			        	System.out.println("22 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "22"); }
		        break; 
			
			case "RULEX":
				System.out.println("23 In Progress - " + input[0]);
				resultcount = endtoend.rulex();
			        if (resultcount != 0) { 
			        	System.out.println("23 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        else { passed(input[0], "23"); }
		        break; 
		        
				case "RESETPASSWORD":
				System.out.println("24 In Progress - " + input[0]);
				resultcount = endtoend.ResetPassword();
			        if (resultcount != 0) { 
			        	System.out.println("24 FAILED - " + input[0]);
			        	Assert.fail(input[0]); } 
			        	else { passed(input[0], "24"); }
		        break;   
	        
//			case "IDENTITYVERIFICATION":
//				System.out.println("In Progress - " + input[0]);
//				resultcount = endtoend.identityVerification();
//			        if (resultcount != 0) { 
//			        	System.out.println("FAILED - " + input[0]);
//			        	Assert.fail(input[0]); } 
//			        	else	 { passed(input[0]); }
//		        break; 
		        
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
