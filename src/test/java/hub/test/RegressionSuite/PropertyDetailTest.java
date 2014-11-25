package hub.test.RegressionSuite;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.EndtoEndUtil.EndtoEndUtil;
import hub.utilities.RegressionSuiteUtil.PropertyDetailUtil;

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
public class PropertyDetailTest extends TestInitReference {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHub/conf/atu.properties");
	}

	String testCase = "Smoke Test";
	
	@Test(description="Smoke Test", dataProvider = "Data-Provider-Function")
	public void testEndtoEnd(Class clzz, String[] input) {
		String testcase = input[0];
		log(testcase);
		logInput(input);
		setAuthorInfoForReports();
		driver.manage().deleteAllCookies();
		try {
			
			PropertyDetailUtil pdu = new PropertyDetailUtil(input);	
			switch (input[0].toUpperCase()) {
		
			case "RT-02902":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.startNewTransaction();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02599":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.startNewTransaction();
				Thread.sleep(3000);
				pdu.checkPropertyAttributes();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02600":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.startNewTransaction();
				Thread.sleep(3000);
				pdu.checkChangePropertyAddress();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
			
			case "RT-02601":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.startNewTransaction();
				Thread.sleep(3000);
				pdu.checkProceedtoProductSelection();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02699":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.checkPendingTransactionIfUsesHttpProtocol();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-03119":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.coverFlow();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02609":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.testLogout();
				Thread.sleep(3000);
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				pdu.deletePendingTransaction();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02611":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.testLogout();
				Thread.sleep(3000);
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				pdu.checkPendingTransactionSection();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-03106":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.checkPropertyPhoto();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02604":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.checkHomeButtonOK();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.checkHomeButtonCancel();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-03121":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.proceedProductSelection();
				Thread.sleep(3000);
				pdu.addProduct();
				Thread.sleep(3000);
				pdu.checkChangePropertyAddressWithPopup();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.checkPendingTransactionSectionNotVisible();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02610":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.checkIfUrlContainsGuestId();
				Thread.sleep(3000);
				pdu.testLogout();
				
				break;
				
			case "RT-02607":
				pdu.login();
				Thread.sleep(3000);
				pdu.slas();
				Thread.sleep(3000);
				pdu.checkStoredDataOnPage();
				Thread.sleep(3000);
				pdu.testLogout();
				
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/propertyDetail.xls");
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
