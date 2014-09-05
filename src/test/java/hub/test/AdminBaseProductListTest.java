package hub.test;

import hub.library.TestInitReference;
import hub.utilities.AdminBaseProductUtil;
import hub.utilities.AdminLoginUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminBaseProductListTest extends TestInitReference{

	String testCase = "Admin Base Product List";
	
	@Test(description="Admin Base Product List")
	public void testBaseProductList() {
		String testcase = "Testing Testcase - ";

		
		
		try {
			driver.navigate().to("https://stage.rppropertyhub.com/n/Admin-Console/myrp-872");
			AdminLoginUtil alu = new AdminLoginUtil();
			alu.adminLogin();
			AdminBaseProductUtil abpu = new AdminBaseProductUtil();
			abpu.testBaseProductNavigation();
		} catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
	}
}
