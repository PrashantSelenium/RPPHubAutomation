package hub.test.RegressionSuite;

import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.junit.Assert;
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
public class UserPaymentDetailsCPS extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
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
	public void RT_08834_Payment_CPS_Successful_Transaction() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentCPS.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentCPS.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentCPS.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("2");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
 		util.Payment_CPS_Successful();
		util.Logout_link();
	}
	
	@Test(description="User - Payment Details", priority=1)
	public void RT_8982_Payment_CPS_Kill_Widget() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();	
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentCPS.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentCPS.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentCPS.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("2");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		util.Payment_CPS_Kill_widget();
	}
	
	@Test(description="User - Payment Details", priority=2)
	public void RT_2964_Payment_CPS_Price_display() throws Exception {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		if(!isElementPresent(xpath(MainTotalAmount))){
			click(xpath(instructionNavBar));
			Thread.sleep(5000);
			click(xpath(ProceedToPaymentDetails));
			Thread.sleep(12000);
			if(!isElementVisible(xpath(TermsandConditionPaymentDetails))) { Thread.sleep(7000); }
			if(!isElementVisible(xpath(TermsandConditionPaymentDetails))) { Thread.sleep(7000); }
			if(!isElementVisible(xpath(InvoiceName))) { Thread.sleep(7000); }
			if(!isElementVisible(xpath(InvoiceName))) { Thread.sleep(7000); }
		}		
		Assert.assertEquals(getText(xpath(MainTotalAmount)), "$49.00");
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();	
		util.Logout_link();
	}
	
	@Test(description="User - Payment Details", priority=3)
	public void RT_8980_Payment_CPS_Kill_Widget_BackBTN() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();	
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentCPS.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentCPS.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentCPS.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("2");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		util.Payment_CPS_Kill_widget_backbtn();
		driver.switchTo().defaultContent();
		util.Logout_link();
	}
	
	@Test(description="User - Payment Details", priority=4)
	public void RT_8981_Payment_CPS_Kill_Widget_Payment_Navigate_Bar() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();	
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentCPS.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentCPS.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentCPS.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("2");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		util.Payment_CPS_Kill_widget_Payment_nav_bar();
	}
	
	@Test(description="User - Payment Details", priority=5)
	public void RT_8976_Payment_CPS_Fields_Validated() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();	
		util.Payment_CPS_Invoice_Field_validated();
	}
	
    @Test(description="User - Payment Details", priority=6)
	public void RT_2984_Payment_CPS_Fields_Displayed() throws Exception { 
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();	
		util.Payment_CPS_Fields_displayed();
	}
    
	@Test(description="User - Payment Details", priority=7)
	public void RT_8829_Payment_CPS_Payment_Form_Displayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();	
		util.Payment_CPS_Displayed_On_Creadit_card_OnCCPreAuth();
    	util.Logout_link();
	}
    
    @Test(description="User - Payment Details", priority=8)
	public void RT_08828_Payment_CPS_Fields_not_Displayed() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("bankmelbourne");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Product_Selection_select_Product("2");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
      Thread.sleep(3000);
		Assert.assertFalse(isElementPresent(xpath(InvoiceName)));
		Assert.assertFalse(isElementPresent(xpath(InvoiceEmail)));
		util.Logout_link();
    }
    
    @Test(description="User - Payment Details", priority=9)
	public void RT_08834_Payment_CPS_OnAccount_CreditCard_Fields() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("cbalender");
		util.slas_dynamic(getDataFromxls(0, "User_PaymentCPS.xls" , 0, 1));
		util.startNewTransaction();
		util.proceedProductSelection();
		util.Originator_Page(getDataFromxls(0, "User_PaymentCPS.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentCPS.xls" , 2, 1));
		util.originatorToProductSelection();
		click(xpath(proceedToProductValuation));
		util.Product_Selection_select_Product("1");
		util.Product_Selection_select_Product("1");
		click(xpath(proceedtoInstuction));
		util.Instruction_Input_Fields();
		waitForElementPresent(xpath(paymentOnAccountFields));
		waitForElementVisible(xpath(paymentOnAccountFields));
		Thread.sleep(5000);
 		Assert.assertTrue(getText(xpath(paymentOnAccountFields)).contains("* Account Password:"));
 		Assert.assertTrue(isElementPresent(xpath(paymentCPSFields)));
	}
    
}
