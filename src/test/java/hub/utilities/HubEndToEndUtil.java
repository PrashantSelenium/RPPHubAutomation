package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

public class HubEndToEndUtil extends FunctionReference {

	//Login	
	public void hubUserLogin (String username, String password) throws Exception {
		resultcount = 0;	
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
		resultcount = 0;	
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
	public void propertyDetails() throws Exception {
		checkPendingTransactionSectionNotVisible();
		proceedtoProductSelection();
		
	}
	
	
	
	public void checkPendingTransactionSectionNotVisible() throws InterruptedException, IOException {
		resultcount = 0;	
		String str = "End to End Test - Pending Transaction";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				if (isElementPresent(xpath(pendingTransactionMessage))) {
					click(By.linkText("Start a new transaction for this property")); 
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
	
	public void proceedtoProductSelection() throws Exception {	
		Thread.sleep(3000);	
		resultcount = 0;
		String str = "End to End Test - Proceed to Product Selection";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementPresent(xpath(proceedtoProductSelection));
		if(ready.equalsIgnoreCase("complete")){
			if (isElementPresent(xpath(proceedtoProductSelection))){
				resultcount = 0;		    	
		    	try {
					Assert.assertTrue(isElementPresent(xpath(proceedtoProductSelection)));
					click(xpath(proceedtoProductSelection));
					waitForElementPresent(xpath(productTabsMenu));
					Assert.assertTrue(isElementPresent(xpath(productTabsMenu)));
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
}
