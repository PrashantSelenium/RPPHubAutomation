package hub.utilities;

import static org.openqa.selenium.By.xpath;

import org.testng.Assert;

import hub.library.FunctionReference;

public class UserMyTransactionsUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public UserMyTransactionsUtil(String[] i) {
		input = i;
	}
	
	public UserMyTransactionsUtil() {
	}
	
	public void testMyTransactionsNavigation() throws Exception {		
		resultcount = 0;	
		testCase = "RP Property Hub My Transactions: " + input[0];
				
		waitForElementPresent(xpath(userMyTransactions));
		click(xpath(userMyTransactions));
		Thread.sleep(3000);    
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userMyTransactionList)));
		} catch (Exception e) {
			fail("My tansactions list");
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
