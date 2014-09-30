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
public class UserFeedback extends TestInitReference {
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

	@Test(description="User - Feedback", priority=0)
	public void RT_06786_Feedback_Validation_Messages() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.validation_Message_Feedback();
	}
	
	@Test(description="User - Feedback", priority=1)
	public void RT_06791_Successfully_Sent_Feedback() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Successfully_Sent_Feedback();
	}
	
	@Test(description="User - Feedback", priority=2)
	public void RT_06785_Fields_Validation_Feedback() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.validation_Feedback_Fields();
	}
	
	@Test(description="User - Feedback", priority=3)
	public void RT_06794_Check_Close_button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.validate_close();
	}
	
	@Test(description="User - Feedback", priority=4)
	public void RT_06788_Contact_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Contact_Validation();
	}
	
	@Test(description="User - Feedback", priority=5)
	public void RT_06787_Email_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Email_Validation();
	}
}


