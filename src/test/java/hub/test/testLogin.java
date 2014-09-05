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
		driver.navigate().to("https://stage.rppropertyhub.com/Login");
		testLoginUtil login = new testLoginUtil(input);
		if(!input[0].equals("ID")){
			login.typeUsername();
			Thread.sleep(3000);
			login.clickLogin();
			login.checkErrorMessage();
			login.checkIfCorrect();
		}
	}
	
	@DataProvider(name = "loginTestdata")
	public Object[][] loginTestdata() throws IOException {
		Object[][] data = null;
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/loginData.xls");
		data = rxd.getData();
		return data;
	}
	
}
