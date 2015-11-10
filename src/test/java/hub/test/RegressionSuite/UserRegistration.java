package hub.test.RegressionSuite;

import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class UserRegistration extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", ATULocation);
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           //driver.navigate().to("https://stage-acme.rppropertyhub.com/signup");
          
           driver.get("https://stage-acme.rppropertyhub.com/signup");
    }
        
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="User - Registration", priority=0)
	public void RT_06801_BranchID_validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.BranchIDvalidation();
	}
		
	@Test(description="User - Registration", priority=1)
	public void RT_06781_Confirm_Password_MinChar() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.ConfirmPasswordMinChar();
	}

	@Test(description="User - Registration", priority=2)
	public void RT_06779_EmailAddress_validation() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.EmailAddress_Validation();
	}
	
	@Test(description="User - Registration", priority=3)
	public void RT_06782_Validation_Messages() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.validation_messages();
	}

	@Test(description="User - Registration", priority=4)
	public void RT_06778_EmailAddress_Invalid_Format() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.EmailAddress_FormatValidation();
	}
	
	@Test(description="User - Registration", priority=5)
	public void RT_06767_Initial_Display() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Registration_InitialDisplay();
	}
	
	@Test(description="User - Registration", priority=6)
	public void RT_06777_TermsAndCondition_validation() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.TermsAndCondition_Validation();
	}
	
	@Test(description="User - Registration", priority=7)
	public void RT_06798_Duplicate_Username() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Duplicate_Username();
	}
	
	@Test(description="User - Registration", priority=8)
	public void RT_06793_EmailAddress_Suffix_Disabled() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.EmailAddress_Suffix_Disabled();
	}
	
	@Test(description="User - Registration", priority=9)
	public void RT_06793_EmailAddress_Suffix_Enabled() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.EmailAddress_Suffix_Enabled();
	}
	
	@Test(description="User - Registration", priority=10)
	public void RT_06799_First_Lastname_Char_Limit() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.FirstLastname_char_Limit();
	}
	
	@Test(description="User - Registration", priority=11)
	public void RT_06797_Phone_Mobile_validation() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Phone_Mobile_validation();
	}
	
	@Test(description="User - Registration", priority=12)
	public void RT_06780_Password_Min_Char() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Password_Min_Char();
	}
	
	@Test(description="User - Registration", priority=13)
	public void RT_06796_Special_Char_Usage() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Special_Char_Usage();
	}
	
	@Test(description="User - Registration", priority=14)
	public void RT_06769_Link_Navigation() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Link_Navigation();
	}
	
	@Test(description="User - Registration", priority=15)
	public void RT_06775_Validation_code_error() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Validation_code_error();
	}
	
	@Test(description="User - Registration", priority=16)
	public void  Validation_channel_field() throws Exception {

		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		Boolean isChannelTypeFieldActive = util.validationChannelField();
		if(isChannelTypeFieldActive){}
		else{
			util.adminEnableField("Channel");
		}
		util.validationchannelField();
	}
	
}


