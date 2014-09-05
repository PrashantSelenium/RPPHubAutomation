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

public class UserResetPasswordTestOptionB extends TestInitReference {

	String testCase = "Test Reset Password Option B";
	
	@Test(description="Test Reset Password Option B")
	public void testResetPasswordOptionB() {
		
		try {			
			driver.navigate().to("https://stage-bankmelbourne.rppropertyhub.com");
			UserResetPasswordUtil urpt = new UserResetPasswordUtil();
			urpt.testResetPasswordSetup();
			urpt.testOneTimePassword();
			Thread.sleep(3000);
			urpt.testResetPasswordSuccess();
			
					
		} catch (Exception e) {
			fail(testCase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
	}
	
	
}
