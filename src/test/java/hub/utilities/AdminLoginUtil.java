package hub.utilities;
import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class AdminLoginUtil extends FunctionReference{
	ReadXmlData rxml = new ReadXmlData();
	String testCase = "Admin Console Login";
	String adminUsername = rxml.data("adminUsername");
	String adminPassword = rxml.data("adminPassword");
	
	public void testAdminLogin() throws Exception {
		if (isElementPresent(xpath(adminLinkLogout))){
			
		}
		else{
		pass("Test Report: " + testCase + browser + " browser");
		
		waitForElementPresent(xpath(adminLoginUsername));		
		isElementPresent(xpath(adminLoginPassword));
		type(xpath(adminLoginUsername), adminUsername);
		type(xpath(adminLoginPassword), adminPassword);
		click(xpath(adminLoginButton));
		waitForElementPresent(xpath(adminLinkLogout));
		driver.navigate().to("https://olddev.rppropertyhub.com/n/Admin-Console/myrp-620");
		
			
			waitForElementPresent(xpath(adminChannelTable));
			
			try {
				Assert.assertEquals("Channel Manager", getText(xpath(adminChannelHeader)));
				pass("Channel Manager" + " is present");
			} catch (AssertionError e) {
				fail("Channel Manager" + " is not present");
				takeScreenshot();
				resultcount++;
			}
			
		    if (resultcount != 0) {
				Assert.fail();
		    } else {
		    	pass("PASSED");
		    }
		}
		
	}
		
	public void adminLogin() throws Exception {
		resultcount = 0;	
		testCase = "Admin Console Successful Login";
		
		waitForElementPresent(xpath(adminLoginUsername));			
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginUsername)));
		} catch (AssertionError e) {
			fail("Password" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginPassword)));
		} catch (AssertionError e) {
			fail("Password" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginButton)));
		} catch (AssertionError e) {
			fail("Password" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(adminLoginUsername), adminUsername);
		type(xpath(adminLoginPassword), adminPassword);
		click(xpath(adminLoginButton));
		waitForElementPresent(xpath(adminLinkLogout));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}

}
