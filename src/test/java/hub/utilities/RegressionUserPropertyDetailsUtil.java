package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegressionUserPropertyDetailsUtil extends FunctionReference{
	private String[] input = null;
	private String testCase = "";
	
	public RegressionUserPropertyDetailsUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserPropertyDetailsUtil() {
	}
	
	public void testPropertyDetails() throws Exception {
		waitForElementPresent(xpath(userPropertyDetails));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertyDetails)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
	
		if (resultcount != 0) {
			Assert.fail();
		}

	}
	
	public void startNewTransaction() throws Exception {		

			
	    if (isElementPresent(xpath(userPendingTransactionMessage))){
	    	System.out.println("User has Pending transactions!");
			resultcount = 0;	
			testCase = "RP Property Hub Start new transaction: " + input[0];
	    	
	    	try {
				Assert.assertTrue(isElementPresent(By.linkText("Start a new transaction for this property")));
			} catch (AssertionError e) {
				fail("Start new transaction");
				takeScreenshot();
				resultcount++;
			}
	        click(By.linkText("Start a new transaction for this property"));      
	    
	    if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	    
	    }
        Thread.sleep(3000);	
	}
	
	public void proceedProductSelection() throws Exception {
		resultcount = 0;	
		testCase = "RP Property Hub Proceed to product selection: " + input[0];
		
		waitForElementPresent(xpath(userProceedToProductSelection),30);
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userProceedToProductSelection)));
		} catch (Exception e) {
			fail("Proceed to product selection");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(userProceedToProductSelection));
		
	    if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
	}
}
