package hub.test.RegressionSuite;


import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.AdminRegressionSuiteUtil;
import hub.utilities.EndToEnd.UserHubEndToEndUtil_SmokeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class AdminCartAndPayment extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://dev.rppropertyhub.com/admin");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="User - Cart and Payment", priority=0)
	public void Validation_AccountPassword_InitialValue() throws Exception {
		
		//AdminRegressionSuiteUtil util = new AdminRegressionSuiteUtil();
		//util.Validation_AccountPassword_InitialValue();
	}
	
	@Test(description="User - Cart and Payment", priority=1)
	public void Configurable_Account_Password() throws Exception {
		
		AdminRegressionSuiteUtil util = new AdminRegressionSuiteUtil();
		util.SetAccountPassword_StaffID_Value(false, true);
        
	}
	
	@Test(description="User - Cart and Payment", priority=2)
	public void Account_Password_OFF_Payment_Details_validation() throws Exception {
		UserHubEndToEndUtil_SmokeTest util = new UserHubEndToEndUtil_SmokeTest();
		AdminRegressionSuiteUtil util2 = new AdminRegressionSuiteUtil();

		util.SuccessfulLogin();
		util.validateCantFindAddress();
		util2.validateProceedProductSelection();
		util.SingleLineAddress();
		util.ProductSelectionValuation();
		util.instructionDetails();
		util2.Account_Password_OFF_Payment_Details_validation();
	}
	
	@Test(description="User - Cart and Payment", priority=3)
	public void Account_Password_On_Payment_Details_validation() throws Exception {
		UserHubEndToEndUtil_SmokeTest util = new UserHubEndToEndUtil_SmokeTest();
		AdminRegressionSuiteUtil util2 = new AdminRegressionSuiteUtil();
		
		util2.SetAccountPassword_StaffID_Value(true, true);
		
		util.SuccessfulLogin();
		util.validateCantFindAddress();
		util2.validateProceedProductSelection();
		util.SingleLineAddress();
		util.ProductSelectionValuation();
		util.instructionDetails();
		
		util2.Account_Password_On_Payment_Details_validation();
	}
	
	@Test(description="User - Cart and Payment", priority=4)
	public void Account_Password_and_StaffID_are_OFF_Payment_Details_validation() throws Exception {
		UserHubEndToEndUtil_SmokeTest util = new UserHubEndToEndUtil_SmokeTest();
		AdminRegressionSuiteUtil util2 = new AdminRegressionSuiteUtil();
		util2.SetAccountPassword_StaffID_Value(false, false);
		
		util.SuccessfulLogin();
		util.validateCantFindAddress();
		util2.validateProceedProductSelection();
		util.SingleLineAddress();
		util.ProductSelectionValuation();
		util.instructionDetails();

		util2.Account_Password_OFF_Payment_Details_validation();
	}
	
	@Test(description="User - Cart and Payment", priority=5)
	public void StaffID_are_OFF_Payment_Details_validation() throws Exception {
		UserHubEndToEndUtil_SmokeTest util = new UserHubEndToEndUtil_SmokeTest();
		AdminRegressionSuiteUtil util2 = new AdminRegressionSuiteUtil();
		util2.SetAccountPassword_StaffID_Value(true, false);
		
		util.SuccessfulLogin();
		util.validateCantFindAddress();
		util2.validateProceedProductSelection();
		util.SingleLineAddress();
		util.ProductSelectionValuation();
		util.instructionDetails();

		util2.StaffID_OFF_Payment_Details_validation();
	}
	

}
