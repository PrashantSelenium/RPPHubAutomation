package hub.utilities;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;
import static org.testng.AssertJUnit.assertEquals;

public class RegressionUserPaymentDetailsUtil extends FunctionReference{
	private String[] input = null;
	private String testCase = "";

	
	public RegressionUserPaymentDetailsUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserPaymentDetailsUtil() {
	}

	public void testUserPaymentDetails() throws Exception {	
		waitForElementPresent(xpath(userPaymentDetailsForm));
	}
	
	public void testUserPaymentDetailsRemove() throws Exception {	
		click(xpath(userPaymentDetailsRemove));
	}
	
	public void testUserProceedToPayment() throws Exception {	
		click(By.linkText(userProceedToPaymentDetails));
	}

	public void testPaymentCartCountPopup() throws Exception {
		pass("Test Report: Payment Cart Count Popup " + browser + " browser");
		
		click(xpath(userNavProductSelection));
		waitForElementPresent(xpath(userCartCountPopup));
		
		try {
			Assert.assertEquals("You can only purchase one product per transaction. To change your selection please select Change Product and remove your existing product form your cart.", getText(xpath(userCartCountPopup)));
			pass("Cart Count popup message" + " is correct");
		} catch (AssertionError e) {
			fail("Cart Count popup message" + " is not correct");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userCartCountOk)));
			pass("Cart Count Ok button" + " is present");
			} catch (AssertionError e) {
				fail("Cart Count Ok button" + " is not present");
				takeScreenshot();
				resultcount++;
			}
		click(xpath(userCartCountOk));
	}
	
	public void testUserPaymentDetailsRemoveOk() throws Exception {		
		waitForElementPresent(xpath(userPaymentDetailsRemovePopup));	
		try {
			Assert.assertTrue(isElementPresent(xpath(userPaymentDetailsRemovePopup)));
		pass("Cart Count Ok button" + " is present");
		} catch (AssertionError e) {
			fail("Cart Count Ok button" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		click(xpath(userPaymentDetailsRemoveOk));
	}

	public void smokePaymentForm() throws Exception{
		
		resultcount = 0;	
		testCase = "RP Property Hub Payment Details: " + input[0];
				
		waitForElementPresent(xpath(userPaymentDetailsForm));
		
		try {
			Assert.assertEquals(input[20], getText(xpath(userPaymentItem)));
		} catch (AssertionError e) {
			fail("Item on Cart");
			takeScreenshot();
			resultcount++;
		}
		
	    if(isElementPresent(xpath(userPaymentTermsConditions))){
			click(xpath(userPaymentTermsConditions));	
			}
		
		if(isElementPresent(xpath(userPaymentPassword))){
			type(xpath(userPaymentPassword), input[21]);	
			}
		
		if(isElementPresent(xpath(userPaymentBroker))){
			type(xpath(userPaymentBroker), input[22]);	
			}
		
		if(isElementPresent(xpath(userPaymentCreditName))){
			type(xpath(userPaymentCreditName), input[23]);	
			}
		if(isElementPresent(xpath(userPaymentCreditEmail))){
			type(xpath(userPaymentCreditEmail), input[24]);	
			}
		if(isElementPresent(xpath(userPaymentCreditNumber))){
			type(xpath(userPaymentCreditNumber), input[25]);	
			}
		if(isElementPresent(xpath(userPaymentCreditSecurity))){
			type(xpath(userPaymentCreditSecurity), input[26]);	
			}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
}
