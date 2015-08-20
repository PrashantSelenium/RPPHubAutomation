package hub.test.RegressionSuite;

import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;
import static org.openqa.selenium.By.xpath;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class UserPaymentDetailsOnAccount extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", ATULocation);
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://stage-bankmelbourne.rppropertyhub.com/login");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="User - Payment Details", priority=0)
	public void RT_07988_Payment_On_Account_Password_Not_Displayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("bankmelbourne");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Product_Selection_select_Product("2");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		util.Payment_Validate_Account_Password_Field_Hidden();
	}
	
	@Test(description="User - Payment Details", priority=1)
	public void RT_02834_Payment_Validate_Back_Btn() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Payment_Validate_Back_Btn();
		util.Logout_link();
	}
	
	@Test(description="User - Payment Details", priority=2)
	public void RT_2290_Payment_Successful_OnAccount_Purchase() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		if(isElementPresent(xpath(logout))){ util.Logout_link(); Thread.sleep(2000); }
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("1");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		util.Payment_Successful_OnAccount_Purchase("Proceed");
		click(xpath(startNewOrder));
		Thread.sleep(3000);
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
	}
	
	@Test(description="User - Payment Details", priority=3)
	public void RT_2290_Payment_Validation_Message() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		if(!isElementPresent(xpath(propertySearch))){	util.LoginChannel("cbalender"); }
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("1");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		util.Payment_Validation_Message();
	}
	
	@Test(description="User - Payment Details", priority=4)
	public void RT_3552_Payment_Navigate_Back_InstructionDetails() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Payment_Navigate_Back_InstructionDetails();
	}
	
	@Test(description="User - Payment Details", priority=5)
	public void RT_2706_Payment_HTTPS() throws Exception {
		
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.toLowerCase().contains("https"));
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Logout_link();
    	Thread.sleep(3000);
	}
	
	@Test(description="User - Payment Details", priority=6)
	public void RT_2906_Payment_Product_Names() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		driver.navigate().to("https://stage-cbalender.rppropertyhub.com/login");
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("1");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		Thread.sleep(7000);
		Assert.assertTrue(getDataFromxls(0, "User_PaymentOnAccount.xls" , 8, 1).contains(getText(xpath(PaymentProductName))));
		util.Logout_link();
	}
	
	@Test(description="User - Payment Details", priority=7)
	public void RT_2932_Payment_Product_Price() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("2");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		Thread.sleep(5500);
		Assert.assertTrue(getDataFromxls(0, "User_PaymentOnAccount.xls" , 9, 1).contains(getText(xpath(MainTotalAmount))));
	}
	
	@Test(description="User - Payment Details", priority=8)
	public void RT_2980_Instruction_Details_fields_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Instruction_fields_Verification();
		util.Logout_link();
	}
	
	@Test(description="User - Payment Details", priority=9)
	public void RT_2838_Payment_Successful_OnAccount() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("1");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		Thread.sleep(5000);
		util.Payment_Successful_OnAccount_Purchase("Confirm");
		click(xpath(startNewOrder));
		Thread.sleep(3000);
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		util.Logout_link();
	}
	
	@Test(description="User - Payment Details", priority=10)
	public void RT_2995_Payment_No_Data_Saved() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("1");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		Thread.sleep(5000);
		util.Payment_No_Saved_Data();
	}
	
	@Test(description="User - Payment Details", priority=11)
	public void RT_2787_Payment_Security_Inconsistent() throws Exception {
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Payment_Security_Inconsistent();	
		//WITH LOGOUT
	}
	
	@Test(description="User - Payment Details", priority=12)
	public void RT_2220_Payment_TermsAndCondition() throws Exception {
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("1");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		Thread.sleep(7000);
		util.Payment_TermsAndCondition();		
	}
	
}


