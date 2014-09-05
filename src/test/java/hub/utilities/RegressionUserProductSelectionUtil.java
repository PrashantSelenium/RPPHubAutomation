package hub.utilities;

import static org.openqa.selenium.By.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

import hub.library.FunctionReference;
import hub.library.ObjectReference;
import hub.library.ReadXmlData;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegressionUserProductSelectionUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public RegressionUserProductSelectionUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserProductSelectionUtil() {
	}
	
	public void testUserNavigateToTab() throws Exception {
		waitForElementPresent(xpath(userProductSelectionList));		
	    click(xpath(userRetroReportsTabLink));
		waitForElementPresent(xpath(userRetroReportsTab));
		waitForElementPresent(xpath(userRetroCheckAvailability));
	}
	
	public void testRetroVal(String[] input) throws Exception {

		String bedroomValue = rxml.data("bedroomValue");
		String bathroomValue = rxml.data("bathroomValue");
		String carspaceValue = rxml.data("carspaceValue");
		String retroAvmTabName = rxml.data("retroAvmTabName");
		try {
			Assert.assertEquals(retroAvmTabName, getText(xpath(userRetroReportsTabLink)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		
//		try {
//			Assert.assertEquals("* Note: Retro Product can not be ordered for the dates beyond 01/01/2009.", getText(xpath(errorRetroValuationDate)));
//			pass("Valuation Date Error Message " + " is present");
//		} catch (AssertionError e) {
//			fail("Valuation Date Error Message " + " is not present");
//			takeScreenshot();
//			resultcount++;
//		}
			
		waitForElementPresent(xpath(userRetroValuationDate));
		click(xpath(userRetroValuationDate));
//		waitForElementsPresent((xpath(userDatePickerMonth)), (xpath(userDatePickerYear)), 30);
		try {
			Assert.assertTrue(isElementPresent(xpath(userDatePickerMonth)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userDatePickerYear)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		


		//waitForElementPresent(xpath(userDatePickerYear));
		select((xpath(userDatePickerMonth)), input[3]); 
		select((xpath(userDatePickerYear)), input[4]);
		click(By.linkText(input[5]));
		select((xpath(userRetroBedroom)), bedroomValue);
		select((xpath(userRetroBathroom)), bathroomValue);
		select((xpath(userRetroCarspace)), carspaceValue);
		
		//waitForElementPresent(xpath(userRetroCheckAvailability));
		
		if(isElementPresent(xpath(userRetroCheckAvailability))){
		click(xpath(userRetroCheckAvailability));		
		} else {
			click(xpath("//input[@id='checkAvailability']"));
		}
		
		if(input[6] == "Not Available"){
			waitForElementPresent(xpath(errorRetroContainer));
			try {
				Assert.assertEquals("Please change the details and try again.", getText(xpath(errorRetroContainer)));
				pass("Error Message " + " is present");
			} catch (AssertionError e) {
				fail("Error Message " + " is not present");
				takeScreenshot();
				resultcount++;
			}
		} else {
			waitForElementPresent(xpath("//input[@id='purchaseButton]"));
		}


	}
	
	public void smokeProductTab() throws Exception{
		
		waitForElementPresent(xpath(productTabsMenu));	
		String productTab = input[11];
		
		if (isElementPresent(xpath(userOriginatorDetails))) {
		click(xpath(productTab));
		}
		
		Thread.sleep(3000);
	}
	

	public void smokeNotAvailableProduct() throws Exception {
		
		Thread.sleep(3000);
		
		resultcount = 0;	
		testCase = "RP Property Hub Product Not Available: " + input[0];
		
		waitForElementPresent(xpath(input[14]));
			try {
				Assert.assertFalse(isElementPresent(xpath(input[14])));
			} catch (AssertionError e) {
				fail("Purchase button");
				takeScreenshot();
				resultcount++;
			}
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
		
	
	
	public void smokeAddProduct() throws Exception {
		Thread.sleep(35000);
		resultcount = 0;	
		testCase = "RP Property Hub Add to cart: " + input[0];
				
		String addToCart = input[14];
		waitForElementPresent(xpath(addToCart));
		try {
			Assert.assertEquals("Add to cart", getValue(xpath(addToCart)));
		} catch (AssertionError e) {
			fail("Add to cart");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(addToCart));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		
		Thread.sleep(6000);
	}
	
	public void testAddToCart() throws Exception {
		waitForElementPresent(xpath(userValuationsTab));
		click(xpath(userAddToCart));	
	    if (resultcount != 0) {
			Assert.fail();
	    }
	}
	
	public void testDeepLinkProductSelection() throws Exception {
		
		resultcount = 0;	
		testCase = "RP Property Hub Deep Linking: " + input[0];
				
		waitForElementPresent(xpath("//div[@id='workspace']"));
		
		try {
			Assert.assertEquals("RP Property Hub - Product Selection", driver.getTitle());
		} catch (AssertionError e) {
			fail("Deep link Product Selection page");
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
