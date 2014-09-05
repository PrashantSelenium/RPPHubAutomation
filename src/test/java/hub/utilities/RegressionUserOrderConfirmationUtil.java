package hub.utilities;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;

import junit.framework.Assert;
import hub.library.FunctionReference;

public class RegressionUserOrderConfirmationUtil extends FunctionReference{
	private String[] input = null;
	private String testCase = "";

	
	public RegressionUserOrderConfirmationUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserOrderConfirmationUtil() {
	}
	
	public void testConfirmPayment() throws Exception {	
		click(xpath(userConfirmPayment));
		Thread.sleep(30000);
	}
	
	public void smokeOrderConfirmationDetails() throws Exception {
		
		resultcount = 0;	
		testCase = "RP Property Hub Order Confirmation Details: " + input[0];
		
		waitForElementPresent(xpath(userOrderItem));
		
	    try {
	        Assert.assertTrue(isElementPresent(By.cssSelector("label.bold")));
	      } catch (AssertionError e) {
			fail("Hub Reference");
			takeScreenshot();
			resultcount++;
	      }
	    
	    String hubref = getText(By.cssSelector("label.bold > span"));
	    System.out.println(hubref);
	    
	    try {
	    	Assert.assertTrue(isElementPresent(By.linkText("Download PDF")));
	      } catch (AssertionError e) {
			fail("Download PDF link");
			takeScreenshot();
			resultcount++;
	      }
	    try {
	        Assert.assertTrue(isElementPresent(By.linkText("Start new order")));
	      } catch (AssertionError e) {
			fail("Start new order link");
			takeScreenshot();
			resultcount++;
	      }
	    
//	    takeScreenshot();
	    
	    try {
	        Assert.assertEquals(input[20], getText(xpath(userOrderItem)));
	      } catch (Error e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
	      }
	    
	    /*try {
	    	Assert.assertEquals(input[16], getText(xpath(userOrderDetailFN)));
	      } catch (Error e) {
		    	fail(testCase);
				takeScreenshot();
				resultcount++;
	      }
	    try {
	    	Assert.assertEquals(input[17], getText(xpath(userOrderDetailFN)));
	      } catch (Error e) {
		    	fail(testCase);
				takeScreenshot();
				resultcount++;
	      }
	    try {
	    	Assert.assertEquals(input[18], getText(xpath(userOrderDetailFN)));
	      } catch (Error e) {
		    	fail(testCase);
				takeScreenshot();
				resultcount++;
	      }
	    
	    try {
	    	Assert.assertEquals(input[19], getText(xpath(userOrderDetailFN)));
	      } catch (Error e) {
		    	fail(testCase);
				takeScreenshot();
				resultcount++;
	      }*/
	    
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	public void testStartNewOrder() throws Exception{
		click(By.linkText("Start new order"));
		Thread.sleep(3000);
	}
	
	public void testMortgageValuation() throws Exception {
		Thread.sleep(3000);	
		
		if(isElementPresent(xpath(userMortgagePopup))) {
			resultcount = 0;	
			testCase = "RP Property Hub Mortgage Valuation Notification: " + input[0];
			
			waitForElementPresent(xpath(userMortgagePopup));
			try {
				Assert.assertTrue(isElementPresent(xpath(userMortgagePopup)));
			} catch (AssertionError e) {
				fail("Mortgage Valuation Popup");
				takeScreenshot();
				resultcount++;
			}
			
			click(xpath(userMortgagePopupOkBtn));
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
		

	}
}
