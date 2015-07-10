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
public class UserMyTransaction extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
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

	@Test(description="User - My Transaction", priority=0)
	public void RT_2177_My_Transaction_Successful_Purchase_Displayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_MyTransaction.xls", 1, 0));
		util.startNewTransaction();
		util.Originator_Page(getDataFromxls(0, "User_MyTransaction.xls", 2, 0), "0", "Purchase");
		util.OriginatorToProductSelectionClickLink();
		util.Product_Selection_select_Product("1");
		util.ProceedToInstructionDetails_ClickLink();
		util.Instruction_Input_Fields();
		util.PaymentOnAccountInputField(getDataFromxls(0, "User_MyTransaction.xls", 3, 0), getDataFromxls(0, "User_MyTransaction.xls", 4, 0));
		util.ocPropertyDetailsTile();
		util.MyTransaction_SuccessfulTransaction_Displayed();
	}
	
	@Test(description="User - My Transaction", priority=1)
	public void RT_2973_My_Transaction_Buttons_Displayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyTransaction_HistoryUploadDocumentBTN_Displayed();
	}
	
	@Test(description="User - My Transaction", priority=2)
	public void RT_5421_My_Transaction_Link_Navigation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyTransaction_MenuNavigation();
		util.Link_Navigation();
	}
	
	@Test(description="User - My Transaction", priority=3)
	public void RT_2975_My_Transaction_Date_Status_Displayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyTransaction_DateAndStatus();
	}
	
	@Test(description="User - My Transaction", priority=4)
	public void RT_2972_My_Transaction_ColumnNames() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyTransaction_ColumnNames();
	}
	
	@Test(description="User - My Transaction", priority=5)
	public void RT_2974_My_Transaction_CorrectInformation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyTransaction_CorrectInformation();
	}
	
	@Test(description="User - My Transaction", priority=6)
	public void RT_2709_My_Transaction_HTTPS() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyTransaction_HTTPS();
		util.Logout_link();
	}
	
	@Test(description="User - My Transaction", priority=7)
	public void RT_2038_My_Transaction_NoAvailableTransaction() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("banksa");
		util.MyTransaction_NoAvailableTransaction();
	}
	
	@Test(description="User - My Transaction", priority=8)
	public void RT_9928_My_Transaction_ValexToolHidden() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.MyTransaction_ValexToolHidden();
		util.Logout_link();
	}
	
	@Test(description="User - My Transaction", priority=9)
	public void RT_9929_My_Transaction_ValexToolDisplayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("acme");
		util.MyTransaction_ValexToolDisplayed();
	}
}


