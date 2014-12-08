package hub.test.RegressionSuite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.EndtoEndUtil.EndtoEndUtil;
import hub.utilities.RegressionSuiteUtil.UserProductSelectionUtil;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class UserProductSelectionTest extends TestInitReference {
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
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.noPromptOriginatorDetails();	
	}
	@Test(description="User - Product Selection", priority=1)
	public void RT_02654_Prompt_Originator_Details() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.promptOriginatorDetails();	
	}
	@Test(description="User - Product Selection", priority=2)
	public void RT_02269_Proceed_Product_Selection_Link() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.originatorToProductSelection();	
	}
	@Test(description="User - Product Selection", priority=3)
	public void RT_03117_Information_Icon_Hover() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.informationIcon();	
	}
	@Test(description="User - Product Selection", priority=4)
	public void RT_03107_Property_Type_Field() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.propertyType();	
	}
	@Test(description="User - Product Selection", priority=5)
	public void RT_02678_OEVPP_Required_Numeric() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.oevppRequiredNumeric();	
	}
	@Test(description="User - Product Selection", priority=6)
	public void RT_02375_OEVPP_Formatted() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.oevppFormatted();	
	}
	
	@Test(description="User - Product Selection", priority=7)
	public void RT_08844_Loan_Amount_Not_Active() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.loanAmountNotActive();
	}
	
	@Test(description="User - Product Selection", priority=8)
	public void RT_02977_DAOTA_Exclusions() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.daotaPropertyExclusions();	
	}
	
	@Test(description="User - Product Selection", priority=9)
	public void RT_03108_DAOTA_Required() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.daotaRequired();	
	}
	
	@Test(description="User - Product Selection", priority=10)
	public void RT_Loan_Purpose() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.loanPurpose();
	}
	@Test(description="User - Product Selection", priority=11)
	public void RT_03109_AVM_Ack_Display() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.avmAckDisplay();
	}
	@Test(description="User - Product Selection", priority=12)
	public void RT_03110_AVM_Ack_Required() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.avmAckRequired();
	}
	@Test(description="User - Product Selection", priority=13)
	public void RT_03111_AVM_Ack_Replaced() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.loanAppDisplay();
	}
	@Test(description="User - Product Selection", priority=14)
	public void RT_Loan_App_Required() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.loanAppRequired();
	}
	@Test(description="User - Product Selection", priority=15)
	public void RT_02704_Url_Https() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.urlHttps();
	}
	@Test(description="User - Product Selection", priority=16)
	public void RT_02904_PP_No_RPID() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.lenderEmpowermentNoRPID();
	}
	@Test(description="User - Product Selection", priority=17)
	public void RT_02903_Empowerment_Metropolitan_Regional() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.lenderEmpowermentMetropolitan();
	}	
	@Test(description="User - Product Selection", priority=18)
	public void RT_02620_Product_Details() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.productDetails();
	}
	@Test(description="User - Product Selection", priority=19)
	public void RT_03099_Product_Details_More() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.productDetailsMore();
	}
	@Test(description="User - Product Selection", priority=20)
	public void RT_02658_On_Account() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.productOnAccount();
	}
	@Test(description="User - Product Selection", priority=21)
	public void RT_02650_Cart_Link() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.cartLinkFunctionality();
	}	
	@Test(description="User - Product Selection", priority=22)
	public void RT_02617_Workflow_Bar() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.workflowBar();
	}
	@Test(description="User - Product Selection", priority=23)
	public void RT_03127_Product_Tab_Not_Active() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.productTabNotActive();
	}	
	@Test(description="User - Product Selection", priority=24)
	public void RT_08845_Loan_Amount_Active() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.loanAmountActive();
	}
	@Test(description="User - Product Selection", priority=25)
	public void RT_08846_Loan_Amount_Mandatory() throws Exception {		
		UserProductSelectionUtil util = new UserProductSelectionUtil();
		util.loanAmountMandatory();
	}

}
