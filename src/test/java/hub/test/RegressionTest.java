package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.RegressionUserHubLoginUtil;
import hub.utilities.RegressionUserInstructionDetailsUtil;
import hub.utilities.RegressionUserOrderConfirmationUtil;
import hub.utilities.RegressionUserOriginatorDetailsUtil;
import hub.utilities.RegressionUserPaymentDetailsUtil;
import hub.utilities.RegressionUserProductSelectionUtil;
import hub.utilities.RegressionUserPropertyDetailsUtil;
import hub.utilities.RegressionUserSingleLineSearchUtil;
import hub.utilities.UserHubLoginUtil;
import hub.utilities.UserInstructionDetailsUtil;
import hub.utilities.UserMyAccountUtil;
import hub.utilities.UserMyTransactionsUtil;
import hub.utilities.UserOrderConfirmationUtil;
import hub.utilities.UserOriginatorDetailsUtil;
import hub.utilities.UserPaymentDetailsUtil;
import hub.utilities.UserProductSelectionUtil;
import hub.utilities.UserPropertyDetailsUtil;
import hub.utilities.UserSingleLineSearchUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegressionTest extends TestInitReference {

	String testCase = "Smoke Test";
	
	@Test(description="Smoke Test", dataProvider = "Data-Provider-Function")
	public void testSmokeTest(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[27];
		log(testcase);
		logInput(input);
		
		try {
			RegressionUserHubLoginUtil uhlu = new RegressionUserHubLoginUtil(input);			
			RegressionUserSingleLineSearchUtil islsu = new RegressionUserSingleLineSearchUtil(input);
			RegressionUserPropertyDetailsUtil updu = new RegressionUserPropertyDetailsUtil(input);
			RegressionUserProductSelectionUtil upsu = new RegressionUserProductSelectionUtil(input);
			
			switch (input[5].toUpperCase()) {
			case "CFA":
				uhlu.smokeLogin();
				islsu.smokeCFA();
				updu.startNewTransaction();
				updu.proceedProductSelection();						
				upsu.smokeProductTab();
		        break;
			case "SLAS":
				uhlu.smokeLogin();
				islsu.smokeSLAS();
				updu.startNewTransaction();
				updu.proceedProductSelection();						
				upsu.smokeProductTab();
		        break;
			case "DEEP":
				uhlu.smokeDeepLink();	
				break;
			default:
				fail(testcase);
		        Assert.fail("Invalid Test Data");
		        break;
			}									
			
			switch (input[6].toUpperCase()) {
			case "AVAILABLE":
				if (input[12].equalsIgnoreCase("Originator")) {
					RegressionUserOriginatorDetailsUtil uodu = new RegressionUserOriginatorDetailsUtil(input);
					uodu.smokeOriginator();
					uodu.smokeOriginatorProceed();
				}
				upsu.smokeAddProduct();
				RegressionUserInstructionDetailsUtil uidu = new RegressionUserInstructionDetailsUtil(input);
				uidu.testCartCountCheck();
				uidu.testProceedInstructionDetails();
				uidu.smokeInstructionDetailsForm();
				RegressionUserPaymentDetailsUtil upd = new RegressionUserPaymentDetailsUtil(input);
				upd.testUserProceedToPayment();
				upd.smokePaymentForm();
				RegressionUserOrderConfirmationUtil uocu = new RegressionUserOrderConfirmationUtil(input);
				uocu.testConfirmPayment();				
				uocu.testMortgageValuation();
				uocu.smokeOrderConfirmationDetails();
				uocu.testStartNewOrder();
				UserMyAccountUtil uma = new UserMyAccountUtil(input);
				uma.testMyAccountNavigation();
				UserMyTransactionsUtil umtu = new UserMyTransactionsUtil(input);
				umtu.testMyTransactionsNavigation();
				uhlu.testLogout();
		        break;
			case "NOT AVAILABLE":
				upsu.smokeNotAvailableProduct();
		        break;
			case "DEEP":
				upsu.testDeepLinkProductSelection();
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/endtoend (version 1).xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

}
