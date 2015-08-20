package hub.test.endtoend;

import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MacquarieBRE extends TestInitReference {
		    
    @BeforeClass
    public void init() {
           driver.navigate().to("https://stage-mbms.rppropertyhub.com/Login");
    }
    
	@Test(description="User - Login", priority=0)
	public void Macquarie_product() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("mbms");
		util.MacquarieBRE_CorrectProduct();
	}
}
