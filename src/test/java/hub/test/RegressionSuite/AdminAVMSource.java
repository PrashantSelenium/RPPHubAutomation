package hub.test.RegressionSuite;

import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.AdminRegressionSuiteUtil;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;
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
public class AdminAVMSource extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="Admin - Login", priority=0)
	public void RT_Admin_Success_Login() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.adminLogin();
	}
	
	@Test(description="Channel List - Navigation", priority=1)
	public void RT_Channel_List_Navigation() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.channelListNav();
	}
	@Test(description="Channel List - Search", priority=2)
	public void RT_Channel_List_Search() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.channelListSearch();
	}
	@Test(description="Channel List - Edit", priority=3)
	public void RT_Channel_List_Edit() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.channelListEdit();
	}
	
	@Test(description="Channel - Property Address Navigation", priority=4)
	public void RT_Channel_Property_Address_Navgation() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.channelPropertyAddressNav();
	}
	
	@Test(description="Channel - Property Address AVM Source", priority=5)
	public void RT_Channel_Property_Address_AVMSource() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.channelAVMSourceSection();
	}
	
	@Test(description="Channel - Property Address AVMSource Options", priority=6)
	public void Base_Product_CBA_AVM_BRE_Service_Code() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.Admin_config_Base_Product_CBAAVM();
	}
	
	@Test(description="Channel - Property Address AVMSource Options", priority=7)
	public void Admin_config_Channel_Product_Selection_CBAAVM() throws Exception {
		
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		//autil.Admin_config_Channel_Product_Selection_CBAAVM();
	}
	
	@Test(description="Channel - Property Address AVMSource Options", priority=8)
	public void Admin_config_Channel_Product_Selection_AVM_NotApplicable() throws Exception {
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		driver.navigate().to("https://dev-cbalender.rppropertyhub.com/login");
		Thread.sleep(2000);	
		autil.Login_Successful_login();
		Thread.sleep(5000);
		driver.navigate().to("https://dev-cbalender.rppropertyhub.com/PropertySearch");
		autil.Product_Selection_Not_Applicable();
		
	}
	
	@Test(description="Channel - Property Address AVMSource Options", priority=9)
	public void Admin_config_Channel_Product_Selection_AVM_Applicable() throws Exception {
		AdminRegressionSuiteUtil autil = new AdminRegressionSuiteUtil();
		autil.Admin_config_Channel_Product_Selection_CBAAVM_SETTOENABLE();
		driver.navigate().to("https://dev-cbalender.rppropertyhub.com/login");
		Thread.sleep(2000);	
		autil.Login_Successful_login();
		Thread.sleep(5000);
		driver.navigate().to("https://dev-cbalender.rppropertyhub.com/PropertySearch");
		autil.Admin_config_Channel_Product_Selection_AVM_Applicable();
		
	}
	
	
	
}


