package hub.test;

import hub.library.FunctionReference;
import hub.library.TestInitReference;
import hub.utilities.UserHubLoginUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginSecurityTest extends TestInitReference {
	
	@Test(description="Login Security")
	public void testLoginSecurity() {
		String testcase = "Testing Testcase - Login Security";
		
		try {
			driver.navigate().to("https://stage-cbalender.rppropertyhub.com");
			UserHubLoginUtil uhlu = new UserHubLoginUtil();
			uhlu.testLoginSecurity();
		} catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}		
		
	}


}
