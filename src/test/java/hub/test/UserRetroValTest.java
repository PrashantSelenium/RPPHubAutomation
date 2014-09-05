package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.UserHubLoginUtil;
import hub.utilities.UserOriginatorDetailsUtil;
import hub.utilities.UserProductSelectionUtil;
import hub.utilities.UserPropertyDetailsUtil;
import hub.utilities.UserSingleLineSearchUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRetroValTest extends TestInitReference {
	
	String testCase = "Retro Val Check Availability";	

	@Test(description="Retro Val Check Availability", dataProvider = "Data-Provider-Function")
	public void testUserRetroVal(Class clzz, String[] input) throws Exception {
		
		String testcase = "Testing Testcase - " + input[0] + " : " + input[6];
		log(testcase);
		logInput(input);
		
		try {
			driver.navigate().to("https://stage-bgl.rppropertyhub.com");
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
			upsu.testUserNavigateToTab();
			upsu.testRetroVal(input);
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/retroValCheckAvailability.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }
}
