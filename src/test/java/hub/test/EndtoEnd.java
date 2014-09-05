package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.EndtoEndProductSelectionUtil;
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

public class EndtoEnd extends TestInitReference {

	String testCase = "Smoke Test";
	
	@Test(description="Smoke Test", dataProvider = "Data-Provider-Function")
	public void testSmokeTest(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[27];
		log(testcase);
		logInput(input);
		
		try {
			UserHubLoginUtil uhlu = new UserHubLoginUtil(input);			
			UserSingleLineSearchUtil islsu = new UserSingleLineSearchUtil(input);
			UserPropertyDetailsUtil updu = new UserPropertyDetailsUtil(input);
			EndtoEndProductSelectionUtil etepsu = new EndtoEndProductSelectionUtil(input);
			
			switch (input[4].toUpperCase()) {
			case "CFA":
				uhlu.smokeLogin();
				islsu.smokeCFA();
				updu.startNewTransaction();
				updu.proceedProductSelection();						
				etepsu.smokeProductTab();
		        break;
			case "SLAS":
				uhlu.smokeLogin();
				islsu.smokeSLAS();
				updu.startNewTransaction();
				updu.proceedProductSelection();						
				etepsu.smokeProductTab();
		        break;
			case "DEEP":
				uhlu.smokeDeepLink();	
				break;
			default:
				fail(testcase);
		        Assert.fail("Invalid Test Data");
		        break;
			}									
			
			switch (input[15].toUpperCase()) {
			case "AVAILABLE":
				if (input[12].equalsIgnoreCase("Originator")) {
					UserOriginatorDetailsUtil uodu = new UserOriginatorDetailsUtil(input);
					uodu.smokeOriginator();
					uodu.smokeOriginatorProceed();
				}
				etepsu.smokeAddProduct();
				UserInstructionDetailsUtil uidu = new UserInstructionDetailsUtil(input);
				uidu.testCartCountCheck();
				uidu.testProceedInstructionDetails();
				uidu.smokeInstructionDetailsForm();
				UserPaymentDetailsUtil upd = new UserPaymentDetailsUtil(input);
				upd.testUserProceedToPayment();
				upd.smokePaymentForm();
				UserOrderConfirmationUtil uocu = new UserOrderConfirmationUtil(input);
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
				etepsu.smokeNotAvailableProduct();
		        break;
			case "DEEP":
				etepsu.testDeepLinkProductSelection();
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/smokeTestStage.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

}
