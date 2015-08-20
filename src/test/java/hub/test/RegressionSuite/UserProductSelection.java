package hub.test.RegressionSuite;


import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import atu.testng.reports.ATUReports;
//import atu.testng.reports.listeners.ATUReportsListener;
//import atu.testng.reports.listeners.ConfigurationListener;
//import atu.testng.reports.listeners.MethodListener;
//import atu.testng.reports.utils.Utils;

//@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class UserProductSelection extends TestInitReference {
//	{
//		System.setProperty("atu.reporter.config", ATULocation);
//	}
	    
    @BeforeClass
    public void init() {
//           ATUReports.setWebDriver(driver);
//           setIndexPageDescription();
           driver.navigate().to("https://stage-cbalender.rppropertyhub.com/Login");
    }
    
//    private void setIndexPageDescription() {
//        ATUReports.indexPageDescription = "Hub";
//        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
//    }
    
	@Test(description="User - Product Selection", priority=0)
	public void RT_02704_Url_Https() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Successful_login_CBALender();
		util.slas();
		util.startNewTransaction();
		util.proceedProductSelection();
		util.urlHttps();
	}
	@Test(description="User - Product Selection", priority=1)
	public void RT_02904_PP_No_RPID() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.lenderEmpowermentNoRPID();
	}
	@Test(description="User - Product Selection", priority=2)
	public void RT_02903_Empowerment_Metropolitan_Regional() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.lenderEmpowermentMetropolitan();
	}	
	@Test(description="User - Product Selection", priority=3)
	public void RT_02620_Product_Details() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.productDetails();
	}
	@Test(description="User - Product Selection", priority=4)
	public void RT_03099_Product_Details_More() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.productDetailsMore();
	}
	@Test(description="User - Product Selection", priority=5)
	public void RT_02658_On_Account() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.productOnAccount();
	}
	@Test(description="User - Product Selection", priority=6)
	public void RT_02650_Cart_Link() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.cartLinkFunctionality();
	}	
	@Test(description="User - Product Selection", priority=7)
	public void RT_02617_Workflow_Bar() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.workflowBar();
	}
	@Test(description="User - Product Selection", priority=8)
	public void RT_03127_Product_Tab_Not_Active() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.productTabNotActive();
	}	
	@Test(description="User - Product Selection", priority=9)
	public void RT_08845_Loan_Amount_Active() throws Exception {		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loanAmountActive();
	}
	@Test(description="User - Product Selection", priority=10)
	public void RT_02651_Link_Navigation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loginToProdSelection();
        util.validate_Back_Button();
	}
	@Test(description="User - Product Selection", priority=11)
	public void RT_02652_validate_Next_ProceedToInstruction_Link_NotVisible() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
        util.validate_Next_ProceedToInstruction_Link_NotVisible();
	}
	@Test(description="User - Product Selection", priority=12)
	public void RT_02652_validate_Next_Button_function() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
        util.validate_Next_Button_function();
	}
	@Test(description="User - Product Selection", priority=13)
	public void RT_02650_validate_ProceedToInstruction_Link_function() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loginToProdSelection();
		util.validate_ProceedToInstruction_Link_function();
		util.Logout_link();
	}
	@Test(description="User - Product Selection", priority=14)
	public void RT_02665_validate_Add_To_Cart_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loginToProdSelection();
		util.validate_Add_To_Cart_Button();
		util.Logout_link();
	}
	@Test(description="User - Product Selection", priority=15)
	public void RT_03102_validate_correct_products_displayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loginToProdSelection();
		util.validate_correct_products_displayed();
		util.Logout_link();
	}
	@Test(description="User - Product Selection", priority=16)
	public void RT_02656_validate_On_Credit_Card_Price() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loginToProdSelection();
		util.validate_On_Credit_Card_Price();
		util.Logout_link();
	}	
	@Test(description="User - Product Selection", priority=17)
	public void RT_03104_validate_No_Product_Available_message() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("amp");
		util.validate_No_Product_Available_message();
	}	
	@Test(description="User - Product Selection", priority=18)
	public void RT_02657_validate_PreAuth_Price() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loginToProdSelection();
		util.validate_On_Credit_Card_Price();
		util.Logout_link();
	}	
	@Test(description="User - Product Selection", priority=19)
	public void RT_02622_validate_SampleReport_Link() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.loginToProdSelection();
		util.validate_On_Credit_Card_Price();
		util.validate_Sample_Report_Link();
		util.Logout_link();
	}	
}