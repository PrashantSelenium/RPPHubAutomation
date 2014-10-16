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
         //driver.get("https://stage-acme.rppropertyhub.com/login");
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
		//util.Logout_link();
	}
	
	@Test(description="User - Property Search", priority=1)
	public void RT_06768_PropertySearch_Link_Navigation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.PropertySearch_Link_Navigation();
	}
	
	@Test(description="User - Property Search", priority=2)
	public void RT_02697_PropertySearch_HTTPS() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.PropertySearch_HTTPS();
	}
	
	@Test(description="User - Property Search", priority=3)
	public void RT_02566_CFA_Confirm_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Confirm_Button();
	}
	
	@Test(description="User - Property Search", priority=4)
	public void RT_02565_CFA_Clear_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Clear_Button();
	}
	
	@Test(description="User - Property Search", priority=5)
	public void RT_02563_CFA_Back_To_Search_Button() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Back_To_Search_Button();
	}
	
	@Test(description="User - Property Search", priority=6)
	public void RT_02561_CFA_Search_Not_Triggered_No_UnitStreetLot_Number() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Not_Triggered_No_UnitStreetLot_Number();
	}
	
	@Test(description="User - Property Search", priority=7)
	public void RT_02559_CFA_Search_Triggered() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Search_Triggered();
	}
	
	@Test(description="User - Property Search", priority=8)
	public void RT_06771_CFA_Validation_message() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Validation_message();
	}
	
	@Test(description="User - Property Search", priority=9)
	public void RT_02564_CFA_Back_To_Search_Button_back_CFA() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Back_To_Search_Button_back_CFA();
	}
	
	@Test(description="User - Property Search", priority=10)
	public void RT_02568_CFA_mandatory_validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_mandatory_validation();
	}
	
	@Test(description="User - Property Search", priority=11)
	public void RT_02562_CFA_No_address_Matched() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_No_address_Matched();
	}
	
	@Test(description="User - Property Search", priority=12)
	public void RT_02553_CFA_Form_validation() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Form_validation();
	}
	
	@Test(description="User - Property Search", priority=13)
	public void RT_02560_CFA_Searching_UI() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Searching_UI();
	}
	
	@Test(description="User - Property Search", priority=14)
	public void RT_02627_CFA_Different_Property_Type() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Different_Property_Type();
	}
	
	@Test(description="User - Property Search", priority=15)
	public void RT_02627_CFA_Branding() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Branding();
	}
	
	@Test(description="User - Property Search", priority=16)
	public void RT_02839_CFA_Suburb_Suggestion() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.CFA_Suburb_Suggestion();
	}
	
	@Test(description="User - Property Search", priority=17)
	public void RT_02552_Property_Search_Did_You_Mean() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		//util.Property_Search_Did_You_Mean();
	}
	
	@Test(description="User - Property Search", priority=18)
	public void RT_02549_Property_Search_Ghost_Text() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.Property_Search_Ghost_Text();
	}
}



