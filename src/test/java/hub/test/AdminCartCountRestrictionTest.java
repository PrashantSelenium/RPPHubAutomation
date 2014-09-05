  package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.AdminCartCountRestrictionUtil;
import hub.utilities.AdminLoginUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminCartCountRestrictionTest extends TestInitReference{
	
	@Test(description="Admin Cart Count Restriction", dataProvider = "Data-Provider-Function")
	public void testAdminCartCountRestriction(Class clzz,String[] input) throws Exception {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[3];
		log(testcase);
		logInput(input);
		
		try {
			AdminCartCountRestrictionUtil accru = new AdminCartCountRestrictionUtil(input);
			switch (input[3].toUpperCase()) {
				case "SUCCESS":
					accru.testActiveCartCount();
			        break;
				case "REQUIRE CART COUNT":
					accru.testRequiredCartCount();
			        break;
				case "INVALID":
					accru.testInvalidInput();
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
		
		if (resultcount != 0) {
			Assert.fail();
		}
		
	}
	

		

	
	@BeforeMethod
	public void resetUI() throws Exception
	{
		new AdminLoginUtil().testAdminLogin();
		new AdminCartCountRestrictionUtil().testAdminCartCountRestriction();
	}
	//This function will provide the parameter data
		@DataProvider(name = "Data-Provider-Function")
		public Object[][] parameterIntTestProvider() throws IOException {
			Object[][] data = null;
			ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/adminCartCount.xls");
			data = rxd.getData();
			return data;
		}

}
