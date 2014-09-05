package hub.test;

import java.io.IOException;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.AdminBaseProductUtil;
import hub.utilities.AdminLoginUtil;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminBaseProductAddNewTest extends TestInitReference{

	String testCase = "Admin Base Product Add New";
	
	@Test(description="Admin Base Product Add New", dataProvider = "Data-Provider-Function")
	public void testBaseProductAddNew(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[14];
		log(testcase);
		logInput(input);
		
		try {
			driver.navigate().to("https://olddev.rppropertyhub.com/n/Admin-Console/myrp-872");			
	        
			AdminLoginUtil alu = new AdminLoginUtil();
			AdminBaseProductUtil abpu = new AdminBaseProductUtil(input);
			
			switch (input[1].toUpperCase()) {
			case "FIELDS":
				alu.adminLogin();
				abpu.testBaseProductNavigation();
				abpu.testBaseProductAddNewLink();
				abpu.testBaseProductAddNewFields();
				abpu.testBaseProductReport();
				abpu.testBaseProductService();
				abpu.testBaseProductProcessedReport();
				abpu.testBaseProductAddNewCancel();
				
				Alert test = driver.switchTo().alert();
				test.getText();
				test.accept();
				Thread.sleep(30000);
		        break;
			case "MANDATORY":
				alu.adminLogin();
				abpu.testBaseProductNavigation();
				abpu.testBaseProductAddNewLink();
				abpu.testBaseProductFillOut();
				abpu.testBaseProductAddNewSave();
				abpu.testBaseProductValidation();
				Thread.sleep(6000);
		        break;
			case "SUCCESS":
				alu.adminLogin();
				abpu.testBaseProductNavigation();
				abpu.testBaseProductAddNewLink();
				abpu.testBaseProductFillOut();
				abpu.testBaseProductActivate();
				abpu.testBaseProductAddNewSave();
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
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/testBaseProduct.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }
}
