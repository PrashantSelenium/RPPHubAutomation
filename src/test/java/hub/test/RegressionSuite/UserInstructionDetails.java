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
public class UserInstructionDetails extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://dev-cbalender.rppropertyhub.com/Login");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="User - Instruction Details", priority=0)
	public void RT_02286_Instruction_Back_Button_Functionality() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.insBackBtn();
	}
	@Test(description="User - Instruction Details", priority=1)
	public void RT_02630_Completed_Instruction_Validations() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.instructionValidation();
	}
	@Test(description="User - Instruction Details", priority=2)
	public void RT_02647_Mandatory_Instruction_Validations() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.insMandatoryFields();
	}
	@Test(description="User - Instruction Details", priority=3)
	public void RT_02643_Instruction_Toggle_Sections() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.instructionToggleSections();
	}
	@Test(description="User - Instruction Details", priority=4)
	public void RT_03088_Minimum_Data_Requirement() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.minimumDataRequirement();
	}
	@Test(description="User - Instruction Details", priority=5)
	public void RT_02633_Email_Validations() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.insEmailValidations();
	}
	@Test(description="User - Instruction Details", priority=6)
	public void RT_03098_The_Customer_Is() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.theCustomerIs();
	}
	@Test(description="User - Instruction Details", priority=7)
	public void RT_03089_Construction_Fields() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.insConstructionFields();
	}
	@Test(description="User - Instruction Details", priority=8)
	public void RT_02646_Reset_Instruction_Details() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.insResetForms();
	}
	@Test(description="User - Instruction Details", priority=9)
	public void RT_02277n02638_Proceed_Payment_Details_n_PleaseWait() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.insProceedPayment();
	}

	
}
