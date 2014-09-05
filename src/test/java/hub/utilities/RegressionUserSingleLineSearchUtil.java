package hub.utilities;

import static org.openqa.selenium.By.xpath;

import org.junit.Assert;

import hub.library.FunctionReference;

public class RegressionUserSingleLineSearchUtil extends FunctionReference{
	private String[] input = null;
	private String testCase = "";
	
	public RegressionUserSingleLineSearchUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserSingleLineSearchUtil() {
	}
	
	public void testUserSingleLineSearch(String propertyAddress) throws Exception {

		waitForElementPresent(xpath(userPropertySearch));
		type(xpath(userPropertySearch), propertyAddress);		
		click(xpath(userSearchButton));

	}
	
	public void smokeSLAS() throws Exception {
		resultcount = 0;	
		testCase = "RP Property Hub Single Line Address Search: " + input[0];
				
		waitForElementPresent(xpath(userPropertySearch));
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			fail("SLAS field");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertEquals("Enter your property address or street name here.", getValue(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			fail("SLAS placeholder text");
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(userPropertySearch), input[10]);		
		click(xpath(userSearchButton));
		
		if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		Thread.sleep(3000);
}
	
	public void smokeCFA() throws Exception {
		resultcount = 0;	
		testCase = "RP Property Hub Can't Find Address: " + input[0];

		waitForElementPresent(xpath(userCFAButton));		
		click(xpath(userCFAButton));
		waitForElementPresent(xpath(userCFAConfirm));
		
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAUnitNumber)));
		} catch (AssertionError e) {
			fail("Unit Number");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetNumber)));
		} catch (AssertionError e) {
			fail("Street Number");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFALotNumber)));
		} catch (AssertionError e) {
			fail("Lot Number");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetName)));
		} catch (AssertionError e) {
			fail("Street Name");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetType)));
		} catch (AssertionError e) {
			fail("Street Type");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStatePostcode)));
		} catch (AssertionError e) {
			fail("State/Postcode");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFABackSearch)));
		} catch (AssertionError e) {
			fail("Back to search");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAClear)));
		} catch (AssertionError e) {
			fail("Clear button");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAConfirm)));
		} catch (AssertionError e) {
			fail("Confirm button");
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(userCFAUnitNumber), input[5]);
		type(xpath(userCFAStreetNumber), input[6]);
		type(xpath(userCFALotNumber), input[7]);
		type(xpath(userCFAStreetName), input[8]);
		type(xpath(userCFAStreetType), input[9]);
		type(xpath(userCFAStatePostcode), input[10]);
		
		click(xpath(userCFAConfirm));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
				
		Thread.sleep(3000);
	}
}
