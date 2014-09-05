package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.UserHubLoginUtil;
import hub.utilities.UserInstructionDetailsUtil;
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

public class UserCartCountRestrictionTest extends TestInitReference {
	
	String testCase = "Cart Count Restriction";	

	@Test(description="Cart Count Restriction", dataProvider = "Data-Provider-Function")
	public void testCartCountRestriction(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[6];
		log(testcase);
		logInput(input);
		
		try {
			UserHubLoginUtil hlu = new UserHubLoginUtil();
			hlu.hubUiLogin();
			
			UserSingleLineSearchUtil uslsu = new UserSingleLineSearchUtil();
			uslsu.testUserSingleLineSearch(input [1]);
			UserPropertyDetailsUtil updu = new UserPropertyDetailsUtil();
			updu.testPropertyDetails();
			updu.startNewTransaction();
			updu.proceedProductSelection();
			
			UserOriginatorDetailsUtil uodu = new UserOriginatorDetailsUtil();
			uodu.testUserOriginatorDetails();
			uodu.testOriginatorToProductSelection();
			
			UserProductSelectionUtil upsu = new UserProductSelectionUtil();
			upsu.testAddToCart();

			UserInstructionDetailsUtil uidu = new UserInstructionDetailsUtil();
			
			uidu.testInstructionDetailsForm();
			uidu.testCartCountCheck();
			uidu.testProductSelectionNav();
			uidu.testCartCountPopup();	
			uidu.testCartCountContinue();
			uidu.testProductSelectionNav();
			uidu.testCartCountChangeProduct();

			UserPaymentDetailsUtil upaydu = new UserPaymentDetailsUtil();
			upaydu.testPaymentCartCountPopup();
			upaydu.testUserPaymentDetailsRemove();
			upaydu.testUserPaymentDetailsRemoveOk();

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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/userCartCount.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

}