package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import org.testng.Assert;

public class RegressionUserOriginatorDetailsUtil extends FunctionReference{

	private String[] input = null;
	private String testCase = "";

	
	public RegressionUserOriginatorDetailsUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserOriginatorDetailsUtil() {
	}
	
	public void testUserOriginatorDetails() throws Exception {	
		
		String userOEVPPvalue = rxml.data("userOEVPPvalue");
		waitForElementPresent(xpath(userOriginatorDetails));
		try {
			Assert.assertTrue(isElementPresent(xpath(userOriginatorDetails)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		waitForElementPresent(xpath(userOEVPP));
		type(xpath(userOEVPP), userOEVPPvalue);
		
		if(isElementPresent(xpath(userNoneApply))) {
			waitForElementPresent(xpath(userNoneApply));
			click(xpath(userNoneApply));
		}
		if(isElementPresent(xpath(userAVMAck))) {
			waitForElementPresent(xpath(userAVMAck));
			click(xpath(userAVMAck));
		}
		
	    if (resultcount != 0) {
			Assert.fail();
	    }
		
	}
	
	public void testOriginatorToProductSelection() throws Exception {
		click(xpath(userOriginatorToProductSelection));
		waitForElementPresent(xpath(userProductSelectionList));	
		waitForElementPresent(xpath(userProductSelectionListOverview));	
	}
	
	public void smokeOriginator() throws Exception{	
		resultcount = 0;	
		testCase = "RP Property Hub Originator details: " + input[0];
				
		waitForElementPresent(xpath(userOriginatorDetails));
		try {
			Assert.assertTrue(isElementPresent(xpath(userOriginatorDetails)));
		} catch (AssertionError e) {
			fail("Originator Details modal");
			takeScreenshot();
			resultcount++;
		}
		String oevpp = input[13];
		
		if(isElementPresent(xpath(userOEVPP))) {
		waitForElementPresent(xpath(userOEVPP));	
		type(xpath(userOEVPP), oevpp);
		}
				
		if(isElementPresent(xpath(userNoneApply))) {
			waitForElementPresent(xpath(userNoneApply));
			click(xpath(userNoneApply));
		}
		if(isElementPresent(xpath(userAVMAck))) {
			waitForElementPresent(xpath(userAVMAck));
			click(xpath(userAVMAck));
		}		
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		
		Thread.sleep(6000);		
	}
	
	public void smokeOriginatorProceed() throws Exception {
		waitForElementPresent(xpath(userOriginatorDetails));
		click(xpath(userOriginatorProceed));
		waitForElementPresent(xpath(userProductSelectionList));	
		waitForElementPresent(xpath(userProductSelectionListOverview));	
	}

}
