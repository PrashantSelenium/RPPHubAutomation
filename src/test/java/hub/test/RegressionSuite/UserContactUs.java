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
public class UserContactUs extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}
	    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://dev-acme.rppropertyhub.com/login");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

	@Test(description="User - Contact Us", priority=0)
	public void RT_03079_Close_Button_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Close_Button_Validation();
	}
	

	@Test(description="User - Contact Us", priority=1)
	public void RT_03083_Invalid_Contact_Number() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Invalid_Contact_Number();
	}
	
	@Test(description="User - Contact Us", priority=2)
	public void RT_03078_Field_Cannot_Be_Empty() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Field_Cannot_Be_Empty();
	}
	
	@Test(description="User - Contact Us", priority=3)
	public void RT_03074_Validation_Message() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Validation_Message();
	}
		
	@Test(description="User - Contact Us", priority=4)
	public void RT_03073_Validation_Asterisk() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Validation_Asterisk();
	}
	
	@Test(description="User - Contact Us", priority=5)
	public void RT_03080_Close_Contact_Us() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Close_Contact_Us();
	}
	
	@Test(description="User - Contact Us", priority=6)
	public void RT_03071_Contact_Us_Link_Modal_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Contact_Us_Link_Modal_Validation();
	}
	
	@Test(description="User - Contact Us", priority=7)
	public void RT_03081_Wheres_My_Reference_Number_Image() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Wheres_My_Reference_Number_Image();
	}
	
	@Test(description="User - Contact Us", priority=8)
	public void RT_03077_Send_Inquiry_Color() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Send_Inquiry_Color();
	}
	
	@Test(description="User - Contact Us", priority=9)
	public void RT_03077_Send_Inquiry_Background_Color() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Send_Inquiry_Background_Color();
	}

	@Test(description="User - Contact Us", priority=10)
	public void RT_03085_One_Checkbox_only() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.One_Checkbox_only();
	}
	
	@Test(description="User - Contact Us", priority=11)
	public void RT_07683_Enquiry_Successfully_Sent() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Enquiry_Successfully_Sent();
	}
	
	@Test(description="User - Contact Us", priority=12)
	public void RT_03082_CFA_New_Fields_Validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.CFA_New_Fields_Validation();
	}
	
	
	
}


