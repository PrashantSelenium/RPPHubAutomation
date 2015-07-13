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
public class UserProductSelectionOriginator extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://stage-cbalender.rppropertyhub.com/Login");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }
    
    @Test(description="User - Product Selection", priority=0)
	public void RT_02619_No_Prompt_Originator_Details() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.noPromptOriginatorDetails();	
	}
	@Test(description="User - Product Selection", priority=1)
	public void RT_02654_Prompt_Originator_Details() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.promptOriginatorDetails();	
	}
	@Test(description="User - Product Selection", priority=2)
	public void RT_02269_Proceed_Product_Selection_Link_Originator() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.originatorToProductSelection();	
	}
	@Test(description="User - Product Selection", priority=3)
	public void RT_03117_Information_Icon_Hover() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.informationIcon();	
	}
	@Test(description="User - Product Selection", priority=4)
	public void RT_03107_Property_Type_Field() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.propertyType();	
	}
	@Test(description="User - Product Selection", priority=5)
	public void RT_02678_OEVPP_Required_Numeric() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.oevppRequiredNumeric();	
	}
	@Test(description="User - Product Selection", priority=6)
	public void RT_02375_OEVPP_Formatted() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.oevppFormatted();	
	}
	@Test(description="User - Product Selection", priority=7)
	public void RT_08844_Loan_Amount_Not_Active() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loanAmountNotActive();
	}
	@Test(description="User - Product Selection", priority=8)
	public void RT_02977_DAOTA_Exclusions() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.daotaPropertyExclusions();	
	}
	@Test(description="User - Product Selection", priority=9)
	public void RT_03108_DAOTA_Required() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.daotaRequired();	
	}
	@Test(description="User - Product Selection", priority=10)
	public void RT_Loan_Purpose() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loanPurpose();
	}
	@Test(description="User - Product Selection", priority=11)
	public void RT_03109_AVM_Ack_Display() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.avmAckDisplay();
	}
	@Test(description="User - Product Selection", priority=12)
	public void RT_03110_AVM_Ack_Required() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.avmAckRequired();
	}
	@Test(description="User - Product Selection", priority=13)
	public void RT_03111_AVM_Ack_Replaced() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loanAppDisplay();
		util.Logout_link();
	}
	@Test(description="User - Product Selection", priority=14)
	public void RT_08846_Loan_Amount_Value() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("amp");
		util.slas();
		util.startNewTransaction();
		util.proceedProductSelection();
		util.loanAmountValidInput();
		util.Logout_link();
	} 
	@Test(description="User - Product Selection", priority=15)
	public void RT_08846_Loan_Amount_Mandatory() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loanAmountMandatory();
		util.Logout_link(); 
	}
	
	@Test(description="User - Product Selection", priority=16)
	public void RT_08846_Admin_Setup_ValuationPurpose() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.AdminSetup_ValuationPurpose();
	}
	
	@Test(description="User - Product Selection", priority=17)
	public void RT_08846_OriginatorQuestion_ValuationPurposeDisplayd() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("acme");
		util.slas_dynamic("56 Maxwell Avenue Gorokan NSW 2263");
		util.startNewTransaction();
		util.validateValuationPurposeIsDisplayed();
		
	}

}
