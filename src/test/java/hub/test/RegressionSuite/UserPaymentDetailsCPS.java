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
public class UserPaymentDetailsCPS extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://stage-cbalender.rppropertyhub.com/login");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

//	@Test(description="User - Payment Details", priority=0)
//	public void RT_07988_Payment_CPS_Successful_Transaction() throws Exception {
//		
//		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
//		util.LoginChannel("cbalender");
//		util.slas_dynamic(getDataFromxls(0, "User_PaymentOnAccount.xls" , 0, 1));
//		util.startNewTransaction();
//		util.proceedProductSelection();
//		util.Originator_Page(getDataFromxls(0, "User_PaymentOnAccount.xls" , 1, 1), "0", getDataFromxls(0, "User_PaymentOnAccount.xls" , 2, 1));
//		util.originatorToProductSelection();
//		click(xpath(proceedToProductValuation));
//		util.Product_Selection_select_Product("2");
//		click(xpath(proceedtoInstuction));
//		util.Instruction_Input_Fields();
//		util.Payment_CPS_Successful();
//		util.Logout_link();
//	}
	
	@Test(description="User - Payment Details", priority=1)
	public void RT_02964_Payment_CPS_Price() throws Exception {
		
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
		Thread.sleep(5000);
		Assert.assertEquals(getText(xpath(paymentDetailTotalPrice)), "$49.00");
		util.Logout_link();
		
	}
	
	@Test(description="User - Payment Details", priority=2)
	public void RT_08982_Payment_CPS_Kill_widget() throws Exception {
		
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
		util.Payment_CPS_Kill_widget();
	}
}
