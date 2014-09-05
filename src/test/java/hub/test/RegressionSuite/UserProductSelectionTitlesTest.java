package hub.test.RegressionSuite;

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
import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserTitlesUtil;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class UserProductSelectionTitlesTest extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}

public class UserProductSelectionTitles extends TestInitReference{
	
	@Test(description="Title Documents Available in Product Selection")
	public void multipleTitleDocumentTest(Class<?> clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[27];
		log(testcase);
		logInput(input);
		
		try{
			UserTitlesUtil utu = new UserTitlesUtil(input);	
			utu.titleLogin();
			utu.titleSLAS();
			utu.startNewTransaction();
			utu.proceedProductSelection();
			utu.testLandTitlestab();
			utu.testPropertyTitleSearchProduct();			
			

		} catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
		
		
	} 
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException {
		Object[][] data = null; 
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/titleDocument.xls");
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
}
