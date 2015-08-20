package hub.test.endtoend;

import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IDMatrix extends TestInitReference {
	    
    @BeforeClass
    public void init() {

           driver.navigate().to("https://stage-acme.rppropertyhub.com/Login");
    }
    
    @Test(description="User - ID Matrix", priority=0)
	public void ID_Matrix() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		
			//Test Identity Verification using Mock Service
			util.IDMatrix();	
	}
}
