package hub.test.endtoend;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.EndtoEndUtil.EndtoEndUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
public class EndtoEnd extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}

	String testCase = "Smoke Test";
	
	@Test(description="Smoke Test", dataProvider = "Data-Provider-Function")
	public void testEndtoEnd(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[27];
		log(testcase);
		logInput(input);
		setAuthorInfoForReports();
		driver.manage().deleteAllCookies();
		try {
			
			EndtoEndUtil etou = new EndtoEndUtil(input);	
			switch (input[4].toUpperCase()) {
		
			case "SLAS":
				
				etou.endToEndLogin();
				Thread.sleep(3000);
				etou.endToEndCoverFlow();
				Thread.sleep(3000);
				etou.endToEndSLAS();
				Thread.sleep(3000);
				etou.startNewTransaction();
				Thread.sleep(3000);
				etou.proceedProductSelection();	
				etou.regressionProductTab();								
				Thread.sleep(3000);
				
				if (input[12].equalsIgnoreCase("Originator")) {
				etou.smokeOriginator();
				Thread.sleep(3000);
				etou.smokeOriginatorProceed();	
				Thread.sleep(10000);
				}
				
				etou.regressionAddProduct();
				Thread.sleep(3000);
				etou.testCartCountCheck();
				Thread.sleep(5000);
				etou.testProceedInstructionDetails();
				Thread.sleep(6000);
				etou.regressionInstructionDetailsForm();
				Thread.sleep(3000);
				etou.testUserProceedToPayment();
				Thread.sleep(3000);
				etou.regressionPaymentForm();
				Thread.sleep(3000);
				etou.testConfirmPayment();				
				Thread.sleep(3000);
				etou.testMortgageValuation();
				Thread.sleep(3000);
				etou.regressionOrderConfirmationDetails();
				Thread.sleep(3000);
				etou.testPopup();
				Thread.sleep(3000);
				etou.testDownloadPDF();
				Thread.sleep(3000);
				etou.testLogout();
				
				break;
				
			case "DEEP":
				
				etou.endToEndLogin();
				Thread.sleep(3000);
//				etou.endToEndCoverFlow();
//				Thread.sleep(3000);
//				etou.endToEndSLAS();
//				Thread.sleep(3000);
//				etou.startNewTransaction();
//				Thread.sleep(3000);
//				etou.proceedProductSelection();	
				etou.regressionProductTab();								
				Thread.sleep(3000);
				
				if (input[12].equalsIgnoreCase("Originator")) {
				etou.smokeOriginator();
				Thread.sleep(3000);
				etou.smokeOriginatorProceed();	
				Thread.sleep(10000);
				}
				
				etou.regressionAddProduct();
				Thread.sleep(3000);
				etou.testCartCountCheck();
				Thread.sleep(5000);
				etou.testProceedInstructionDetails();
				Thread.sleep(6000);
				etou.regressionInstructionDetailsForm();
				Thread.sleep(3000);
				etou.testUserProceedToPayment();
				Thread.sleep(3000);
				etou.regressionPaymentForm();
				Thread.sleep(3000);
				etou.testConfirmPayment();				
				Thread.sleep(3000);
				etou.testMortgageValuation();
				Thread.sleep(3000);
				etou.regressionOrderConfirmationDetails();
				Thread.sleep(3000);
				etou.testPopup();
				Thread.sleep(3000);
				etou.testDownloadPDF();
				Thread.sleep(3000);
				etou.testLogout();
				
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/endToEndDataTestOnly.xls");
		data = rxd.getData();
		return data;
	}
	
//    @AfterMethod
//    public void reinitializeBrowser() throws InterruptedException, IOException {
//    	driver.manage().deleteAllCookies();
//    	driver.get(url);
//    }
    
    @BeforeClass
    public void init() {
           ATUReports.setWebDriver(driver);
           setIndexPageDescription();
           setAuthorInfoForReports();
    }
    
    private void setIndexPageDescription() {
        ATUReports.indexPageDescription = "Hub";
    }
    
    private void setAuthorInfoForReports() {
        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),
                     "1.0");
 }

}
