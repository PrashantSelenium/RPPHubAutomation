package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.AccessGmailUtil;
import hub.utilities.UserResetPasswordUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserResetPasswordTestOptionA extends TestInitReference {

	String testCase = "Test Reset Password";
	
	@Test(description="Test Reset Password", dataProvider = "Data-Provider-Function")
	public void testResetPassword(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[4];
		log(testcase);
		logInput(input);
		
		try {
//			AccessGmailUtil agu = new AccessGmailUtil();
//			agu.accessGmail();
			driver.navigate().to("https://stage-aussieselect.rppropertyhub.com");
			UserResetPasswordUtil urpt = new UserResetPasswordUtil(input);
			urpt.testOldForgottenPassword();
			
			switch (input[3].toUpperCase()) {
				case "SUCCESS":
					urpt.testResetPasswordSetup();
			        urpt.testResetPasswordSuccess();
			        AccessGmailUtil agu = new AccessGmailUtil();
					agu.accessGmail();
					urpt.testResetPasswordLink();
			        break;
				case "EMPTY":
			        urpt.testResetPasswordEmpty();
			        break;
				case "FAIL":
			        urpt.testResetPasswordFail();
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/userResetpassword.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.navigate().to("https://stage-aussieselect.rppropertyhub.com");
    }
}
