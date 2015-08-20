package hub.test.RegressionSuite;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.Admin_TitleDocumentsUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Admin_TitleDocuments extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", ATULocation);
	}

	@Test(description="Admin - Title Documents", dataProvider = "Data-Provider-Function", priority=0)
	public void BSG_Title_Service(Class<?> clzz, String[] input) {
		String testcase = "Admin - Title Documents - " + input[0];
		log(testcase);
		logInput(input);

		try {
			Admin_TitleDocumentsUtil Admin_TitleDocument = new Admin_TitleDocumentsUtil(input);
			
			switch (input[0].toUpperCase()) {
			case "COMPLETED PROCESSED REPORT":
				resultcount = Admin_TitleDocument.validateTitleInReportSource();
					if (resultcount != 0) { fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		        
			case "BSG TITLE SERVICE":
				resultcount = Admin_TitleDocument.validateTitleInProductType();
					if (resultcount != 0) { fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		        
			case "PROPERTY TITLE CONFIGURATION":
				resultcount = Admin_TitleDocument.PropertyTitleSearchConfiguration();
					if (resultcount != 0) { fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		        
			case "REPORT TYPE TITLES":
				resultcount = Admin_TitleDocument.validateTitleInReportType();
					if (resultcount != 0) { fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		    
			case "CUSTOM PRODUCTS CONFIGURATION":
				resultcount = Admin_TitleDocument.validateCustomProducts();
					if (resultcount != 0) { fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		        
			case "PRODUCT DATA GROUPS CONFIGURATION":
				resultcount = Admin_TitleDocument.validateProductDataGroups();
					if (resultcount != 0) { fail(input[0]); } 
						else { pass(input[0]); }
		        break;
		        
			default:
				fail(testcase);
		        Assert.fail("Invalid Test Data");
		        break;
			}
		} catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}

	}

	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException {
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/Admin_Title_Document.xls");
		data = rxd.getData();
		return data;
	}
    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           driver.navigate().to("https://olddev.rppropertyhub.com/admin");
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
    }

}
