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
public class UserPropertySearch extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://stage-acme.rppropertyhub.com/login");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="User - Property Search", priority=0)
	public void RT_02902_PropertySearch_Logout() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Login_Successful_login();
		util.Logout_link();
	}
	
	@Test(description="User - Property Search", priority=1)
	public void RT_06768_PropertySearch_Link_Navigation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.PropertySearch_Link_Navigation();
	}
	
	@Test(description="User - Property Search", priority=2)
	public void RT_02697_PropertySearch_HTTPS() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.PropertySearch_HTTPS();
	}
	
	@Test(description="User - Property Search", priority=3)
	public void RT_02566_CFA_Confirm_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.CFA_Confirm_Button();
	}
	
	@Test(description="User - Property Search", priority=4)
	public void RT_02565_CFA_Clear_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.CFA_Clear_Button();
	}
	
	@Test(description="User - Property Search", priority=5)
	public void RT_02563_CFA_Back_To_Search_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.CFA_Back_To_Search_Button();
	}
	
	@Test(description="User - Property Search", priority=6)
	public void RT_02561_CFA_Search_Not_Triggered_No_UnitStreetLot_Number() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.CFA_Not_Triggered_No_UnitStreetLot_Number();
	}
	
	@Test(description="User - Property Search", priority=7)
	public void RT_02559_CFA_Search_Triggered() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.CFA_Search_Triggered();
	}
	
	@Test(description="User - Property Search", priority=8)
	public void RT_06771_CFA_Validation_message() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.CFA_Validation_message();
	}
	
	
}


