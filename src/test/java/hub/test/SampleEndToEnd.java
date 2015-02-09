package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.HubEndToEndUtil;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleEndToEnd extends TestInitReference {
	
	@Test
	public void sample() throws Exception {
		
		HubEndToEndUtil endToEnd = new HubEndToEndUtil();
		
		//Login
		String username = getDataFromxls(0, "EndToEndUtilData.xls", 1, 1);
		String password = getDataFromxls(0, "EndToEndUtilData.xls", 2, 1);
		endToEnd.hubUserLogin(username.trim(), password.trim());
		
		//Property Search
		String addressToSearch = getDataFromxls(0, "EndToEndUtilData.xls", 2, 1);
		endToEnd.searchAddress(addressToSearch);
		
		//Property Details
		endToEnd.propertyDetails();
		
		
		
	}
	
//	@Test(description="Sample Test", dataProvider = "Data-Provider-Function")
//	public void sample(Class clzz, String[] input) {
//		System.out.println("test");
//	}

//	//This function will provide the parameter data
//	@DataProvider(name = "Data-Provider-Function")
//	public Object[][] parameterIntTestProvider() throws IOException {
//		Object[][] data = null; 
//		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/EndToEndUtilData.xls");
//		data = rxd.getData();
//		return data;
//	}
	
	@BeforeMethod
    public void reinitializeBrowser() throws Exception {
    	String url = getDataFromxls(0, "EndToEndUtilData.xls", 1, 0);
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }
}
