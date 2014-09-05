package hub.utilities;

import static org.openqa.selenium.By.xpath;

import org.testng.Assert;

import hub.library.FunctionReference;

public class UserMyAccountUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public UserMyAccountUtil(String[] i) {
		input = i;
	}
	
	public UserMyAccountUtil() {
	}
	
	public void testMyAccountNavigation() throws Exception {		
		resultcount = 0;	
		testCase = "RP Property Hub My Account: " + input[0];
				
		waitForElementPresent(xpath(userMyAccount));
		click(xpath(userMyAccount));
		Thread.sleep(3000);    
		
		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountFN)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountLN)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountEmail)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	

}
