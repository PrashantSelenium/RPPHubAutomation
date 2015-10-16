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
public class UserMyAccount extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", ATULocation);
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://dev-acme.rppropertyhub.com/login");
    }
    
    private void setIndexPageDescription() { 
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="User - My Account", priority=0)
	public void RT_02527_Cancel_button_validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Cancel_button_validation();
        
	}
	
	@Test(description="User - My Account", priority=1)
	public void RT_02901_MyAccount_SpecialChar_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_SpecialChar_Validation();
        
	}
	
	@Test(description="User - My Account", priority=2)
	public void RT_02517_MyAccount_Field_Label() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Field_Label();
        
	}
	

	@Test(description="User - My Account", priority=3)
	public void RT_02528_Blank_FirstLast_position() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Blank_FirstLast_position();
        
	}
	
	@Test(description="User - My Account", priority=4)
	public void RT_02514_MyAccount_Required_Fields_Asterisk() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Required_Fields_Asterisk();
        
	}
	
	@Test(description="User - My Account", priority=5)
	public void RT_02708_MyAccount_Security_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Security_Validation();
        
	}
	
	@Test(description="User - My Account", priority=6)
	public void RT_02525_MyAccount_Save_Successfully() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Save_Successfully();
        
	}
	
	@Test(description="User - My Account", priority=7)
	public void RT_02535_MyAccount_Navigation_CBALender() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Navigation_CBALender();
        
	}
	
	@Test(description="User - My Account", priority=8)
	public void RT_02902_MyAccount_Logout_Link() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Logout_Link();
        
	}
	
	@Test(description="User - My Account", priority=9)
	public void RT_025395_MyAccount_Link_Navigation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Link_Navigation();
        
	}
	
	@Test(description="User - My Account", priority=10)
	public void RT_02521_MyAccount_EmailAddress_FormatValidation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_EmailAddress_FormatValidation();
        
	}
	
	@Test(description="User - My Account", priority=11)
	public void RT_04436_MyAccount_Branch_ID_Not_Null() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Branch_ID_Not_Null();
        
	}
	
	@Test(description="User - My Account", priority=12)
	public void RT_04435_MyAccount_BranchIDvalidation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_BranchIDvalidation();
        
	}
	
	@Test(description="User - My Account", priority=13)
	public void RT_02529_MyAccount_Unable_To_Save_Twice() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Unable_To_Save_Twice();
        
	}
	
	@Test(description="User - My Account", priority=14)
	public void RT_02523_MyAccount_Phone_Mobile_validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Phone_Mobile_validation();
        
	}
	
	@Test(description="User - My Account", priority=15)
	public void RT_02518_MyAccount_EmailAddress_Suffix_Enabled() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_EmailAddress_Suffix_Enabled();
        
	}
	
	@Test(description="User - My Account", priority=16)
	public void RT_02520_MyAccount_EmailAddress_Suffix_Disabled() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_EmailAddress_Suffix_Disabled();
        
	}
	
	@Test(description="User - My Account", priority=17)
	public void RT_02522_MyAccount_EmailAddress_Suffix_Enabled_Invalid_message() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_EmailAddress_Suffix_Enabled_Invalid_message();
        
	}
	
	@Test(description="User - My Account", priority=18)
	public void RT_02547_MyAccount_Password_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Password_Validation();
        
	}
	
	@Test(description="User - My Account", priority=19)
	public void RT_02546_Previous_Username_Can_Be_Use() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Previous_Username_Can_Be_Use();
        
	}
	
	@Test(description="User - My Account", priority=20)
	public void RT_02545_MyAccount_Duplicate_Username() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyAccount_Duplicate_Username();
        
	}


}
