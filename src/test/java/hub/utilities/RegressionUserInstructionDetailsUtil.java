package hub.utilities;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class RegressionUserInstructionDetailsUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public RegressionUserInstructionDetailsUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserInstructionDetailsUtil() {
	}

	@Test(description = "Proceed to instruction details")
	public void testProceedInstructionDetails() throws Exception {	
		click(By.linkText(userProceedToInstructionDetails));				
	}
	
	public void testInstructionDetailsForm() throws Exception {

		String customerFName = rxml.data("customerFName");
		String customerLName = rxml.data("customerLName");
		String customerContact = rxml.data("customerContact");
		String customerEmail = rxml.data("customerEmail");

		waitForElementPresent(xpath(userInstructionDetails));
		waitForElementPresent(xpath(userCustomerFName));
		waitForElementPresent(xpath(userCustomerLName));
		waitForElementPresent(xpath(userCustomerContact));
		waitForElementPresent(xpath(userCustomerEmail));
		
		type(xpath(userCustomerFName),customerFName);		
		type(xpath(userCustomerLName),customerLName);	
		type(xpath(userCustomerContact),customerContact);	
		type(xpath(userCustomerEmail),customerEmail);	
		
		waitForElementPresent(xpath(userSameAsCustomer));
		click(xpath(userSameAsCustomer));
	}
	
	public void smokeInstructionDetailsForm() throws Exception {
		
		resultcount = 0;	
		testCase = "RP Property Hub Instruction Details: " + input[0];

		waitForElementPresent(xpath(userInstructionDetails));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userInstructionDetails)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		
		if(isElementPresent(xpath(userCustomerFName))){
		type(xpath(userCustomerFName), input[16]);	
		}
		if(isElementPresent(xpath(userCustomerLName))){
		type(xpath(userCustomerLName), input[17]);	
		}
		if(isElementPresent(xpath(userCustomerContact))){
		type(xpath(userCustomerContact), input[18]);	
		}
		if(isElementPresent(xpath(userCustomerEmail))){
		type(xpath(userCustomerEmail), input[19]);	
		}
		if(isElementPresent(xpath(userSameAsCustomer))){
		waitForElementPresent(xpath(userSameAsCustomer));
		click(xpath(userSameAsCustomer));
		}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	public void testCartCountCheck() throws Exception{
		Thread.sleep(1000);
		resultcount = 0;	
		testCase = "RP Property Hub My Cart count: " + input[0];
			
		try {
			Assert.assertEquals("(1)", getText(xpath(userCart)));
		} catch (AssertionError e) {
			fail("Cart count");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	public void testProductSelectionNav() throws Exception {
		waitForElementPresent(xpath(userNavProductSelection));
		try {
			Assert.assertTrue(isElementPresent(xpath(userNavProductSelection)));
			} catch (AssertionError e) {
				takeScreenshot();
				resultcount++;
			}
		click(xpath(userNavProductSelection));
	}
	
	public void testCartCountPopup() throws Exception {
		waitForElementPresent(xpath(userCartCountPopup));
		try {
			Assert.assertEquals("You can only purchase one product per transaction. To change your selection please select Change Product and remove your existing product form your cart.", getText(xpath(userCartCountPopup)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userCartCountContinue)));
			} catch (AssertionError e) {
				fail("Cart Count Continue button" + " is not present");
				takeScreenshot();
				resultcount++;
			}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userCartCountChange)));
			pass("Cart Count Change Product button" + " is present");
			} catch (AssertionError e) {
				fail("Cart Count Change Product button" + " is not present");
				takeScreenshot();
				resultcount++;
			}
		
	    if (resultcount != 0) {
			Assert.fail();
	    }
		
	}

	public void testCartCountContinue() throws Exception {
		click(xpath(userCartCountContinue));
	}
	
	public void testCartCountChangeProduct() throws Exception {
		click(xpath(userCartCountChange));

		if (resultcount != 0) {
			Assert.fail();
	    }	
	}

}
