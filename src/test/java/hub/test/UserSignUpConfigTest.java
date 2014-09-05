package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.UserSignupUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserSignUpConfigTest extends TestInitReference {

	String testCase = "Signup Configurations and Validations";
	
	@Test(description="Signup Configurations and Validations", dataProvider = "Data-Provider-Function")
	public void testSignUp(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[22];
		log(testcase);
		logInput(input);
		
		try {
			UserSignupUtil usu = new UserSignupUtil(input);
			usu.testSignupNavigation();
			usu.testSignupFields();
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/testRegMyAccountConfig.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

}
