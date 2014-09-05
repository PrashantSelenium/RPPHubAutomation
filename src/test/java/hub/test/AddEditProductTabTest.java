package hub.test;

import java.io.IOException;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.AdminLoginUtil;
import hub.utilities.AdminProductTabUtil;
import hub.utilities.AdminPromotionCodeUtil;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddEditProductTabTest extends TestInitReference{

	String testCase = "Admin Base Product Add New";
	
	@Test(description="Admin Base Product Add New", dataProvider = "Data-Provider-Function")
	public void testBaseProductAddNew(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0];
		log(testcase);
		logInput(input);
		
		try {			

			AdminProductTabUtil aptu = new AdminProductTabUtil(input);
			
			switch (input[1].toUpperCase()) {
			case "ADD":
				aptu.adminLogin();
				aptu.navigateToChannelListPage();
				aptu.testAdding();
				Thread.sleep(5000);
		        break;
//		        
//			case "EDIT":
//				aptu.adminLogin();
//				aptu.navigateToChannelListPage();
//				aptu.testEditing();
//				
//		        break;
		        
//			case "EDITING":
//				aptu.adminLogin();
//				aptu.navigateToChannelListPage();
//				aptu.testEditing();
//				
//		        break;
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/ProductTab_1.xls");
		data = rxd.getData();
		return data;
	}
}
