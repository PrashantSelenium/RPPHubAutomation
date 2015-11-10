package hub.test.endtoend;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;

import hub.library.ReadXlsData;
import hub.library.TestInitReferenceSmokeTest;
import hub.utilities.EndToEnd.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;


//************************************************************************************************************************//
//THINGS TO CONSIDER BEFORE RUNNING THE SCRIPT																		      //
//																														  //
//Change EndToEnd_SmokeTest.java @BeforeClass URL - "Stage-" for stage "Dev-" for dev and "https://CHANNEL" for production//
//Update UserHubEndToEndUtil_smoketest.java - Set environment string based from the list								  //
//Update EndToEnd_smoketest.xls based - Search for the BuildVersion and update to current Version name					  //
//																														  //
//************************************************************************************************************************//

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Titles extends TestInitReferenceSmokeTest {
	{
		System.setProperty("atu.reporter.config", "/tooltwist/eclipse/RPPHubxxx/conf/atu.properties");
	}
	private DateFormat dateFormat = new SimpleDateFormat("HHmmss");
	private Date date = new Date();
	public String PromoCode = "Promo".concat(dateFormat.format(date)).substring(0, 10);;
		
	//This function will provide the parameter data
		@DataProvider(name = "Data-Provider-Function")
		public Object[][] parameterIntTestProvider() throws IOException {
			Object[][] data = null;
			ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/EndToEnd_SmokeTestPart2.xls");
			data = rxd.getData();
			return data;
		}

	    @BeforeClass
	    public void init() {
	           ATUReports.setWebDriver(driver);
	           setIndexPageDescription();
	           driver.navigate().to("https://dev-cbalender.rppropertyhub.com/login");
	    }
	    
	    @AfterClass
	    public void closedriver(){
	    	driver.quit();
	    }
	    
	    private void setIndexPageDescription() {
	        ATUReports.indexPageDescription = "Corlogic-Hub";
	        ATUReports.setAuthorInfo("Automation Tester", Utils.getCurrentTime(),"1.0");
	    }
	
	@Test(description="End To End Smoke Test", dataProvider = "Data-Provider-Function")
	public void testLogin(Class<?> clzz, String[] input) throws Exception {
		
		UserHubEndToEndUtil_SmokeTest endtoend = new UserHubEndToEndUtil_SmokeTest();
		switch (input[0].toUpperCase()) {
		
		case "PROPERTYTITLE":
			int x=0;
			do{
			endtoend.propertyTitle();
			}while(x<=20);
	    break; 
		}
			        
		 
	}
}
