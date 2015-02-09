package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class HubEndToEndUtil extends FunctionReference {

	//Login	
	public void hubUserLogin (String username, String password) throws Exception {
		int resultcount = 0;	
		String str = "End to End Test - Login";
		
		waitForElementPresent(xpath(userLoginUsername));
		try {
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
			Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
			Assert.assertTrue(isElementPresent(xpath(loginButton)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		click(xpath(loginButton));
		
		if (resultcount != 0) {
			fail(str);
		} else {
			pass(str);
		}
	}
	
	//Property Search	
	public void searchAddress(String address) throws Exception {
		int resultcount = 0;	
		String str = "End to End Test - Search Address";
				
		waitForElementPresent(xpath(userPropertySearch));
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			fail("SLAS field");
			resultcount++;
		}
				
		type(xpath(userPropertySearch), address);		
		click(xpath(userSearchButton));
		
		if (resultcount != 0) {
				fail(str);
			} else {
				pass(str);
			}
		Thread.sleep(3000);
	}
	
	//Property Details
	public void propertyDetails() throws InterruptedException, IOException {
		checkPendingTransactionSectionNotVisible();
		
	}
	
	
	
	public void checkPendingTransactionSectionNotVisible() throws InterruptedException, IOException {
		int resultcount = 0;	
		String str = "End to End Test - Pending Transaction";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				if (isElementPresent(xpath(pendingTransactionMessage))) {
					click(xpath(pendingTransactionMessage));
				}
			} catch (AssertionError e) {
				fail(str);
				resultcount++;
			}

			if (resultcount != 0) {
				fail(str);
			} else {
				pass(str);
			}
		}
	}
}
