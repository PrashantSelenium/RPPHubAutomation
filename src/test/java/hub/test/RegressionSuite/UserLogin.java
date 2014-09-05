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
public class UserLogin extends TestInitReference {
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

	@Test(description="User - Login", priority=0)
	public void RT_05397_Link_Navigation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Link_Navigation();
        
	}
		
	@Test(description="User - Login", priority=1)
	public void RT_02582_Login_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Login_Validation();
        
	}
	
	@Test(description="User - Login", priority=2)
	public void RT_05394_Login_Initial_Display() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Login_InitialDisplay();
        
	}
	
	@Test(description="User - Login", priority=3)
	public void RT_2695_Login_Security() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Login_Security();
        
	}
	
	@Test(description="User - Login", priority=4)
	public void RT_2578_Login_Succesful_login() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Login_Successful_login();
        util.Logout_link();
	}
	
	@Test(description="User - Login", priority=5)
	public void RT_2569_Register_New_Account_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Register_New_Account_Button();
        
	}
}
