package hub.test;

import java.io.IOException;

import javax.xml.xpath.XPath;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.testLoginUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testLogin extends TestInitReference{
	
	@Test(dataProvider="loginTestdata")
	public void testLogin(Class clzz,String [] input) throws InterruptedException{
		driver.navigate().to("https://iqtest01:ab-74USA-6@sit.qv.co.nz");

	}
	
	@DataProvider(name = "loginTestdata")
	public Object[][] loginTestdata() throws IOException {
		Object[][] data = null;
				return data;
	}
	
}
