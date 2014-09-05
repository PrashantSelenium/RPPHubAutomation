package hub.utilities.RegressionSuiteUtil;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import hub.library.FunctionReference;
import hub.utilities.RegressionSuiteUtil.*;;

public class UserTitlesUtil extends FunctionReference{
	private String[] input = null;
	private String testCase = "";
	public UserTitlesUtil(String [] i){
		input = i;
	}
	public void titleLogin() throws InterruptedException, IOException{
		driver.navigate().to(input[1]);	
		
			waitForElementPresent(xpath(userLoginUsername));
			
			String username = "";
			String password = "";
			
			username = input[2];
			password = input[3];

			type(xpath(userLoginUsername), username);
			type(xpath(userLoginPassword), password);
			click(xpath(loginButton));	
			Thread.sleep(3000);	
	}
	
	public void titleSLAS() throws Exception {
		waitForElementPresent(xpath(userPropertySearch));
		type(xpath(userPropertySearch), input[11]);		
		click(xpath(userSearchButton));
		Thread.sleep(3000);	
	}
	
	public void startNewTransaction() throws Exception {				
	    if (isElementPresent(xpath(userPendingTransactionMessage))){
	    	System.out.println("User has Pending transactions!");
	        click(By.linkText("Start a new transaction for this property"));      	    
	    }
        Thread.sleep(3000);	
	}
	
	public void proceedProductSelection() throws Exception {		
		waitForElementPresent(xpath(userProceedToProductSelection));
		click(xpath(userProceedToProductSelection));
		Thread.sleep(3000);
	}
	
	public void testLandTitlestab() throws Exception {
		resultcount = 0;	
		testCase = "Land Titles tab is displayed in Product Selection screen";
				
		waitForElementPresent(xpath(input[12]));
		try{
			Assert.assertTrue(isElementPresent(xpath(input[12])));
		} catch (AssertionError e) {
			fail("Land Titles tab is not displayed");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(input[12]));
		Thread.sleep(3000);
	}	
	
	public void testPropertyTitleSearchProduct() throws Exception {
		resultcount = 0;	
		testCase = "Property Title Search product have the correct information displayed in the Product Selection screen";
				
		waitForElementPresent(xpath(titleName));
		try{
			Assert.assertTrue(isElementPresent(xpath(titleName)));
			Assert.assertEquals(getText(xpath(titleName)), "Property Title Search");
		} catch (AssertionError e) {
			fail("Incorrect product name for Property Title Search");
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(titleShort)));
			Assert.assertEquals(getText(xpath(titleShort)), "A search of the title of the subject property.");
		} catch (AssertionError e) {
			fail("Incorrect short description for Property Title Search");
			takeScreenshot();
			resultcount++;
		}
		
		click(xpath(titleMoreDetails));
		
		try{
			Assert.assertTrue(isElementPresent(xpath(titleLong)));
			Assert.assertEquals(getText(xpath(titleLong)), "Provides information regarding the registered owners, registered interests and other affectations on title.");
		} catch (AssertionError e) {
			fail("Incorrect long description for Property Title Search");
			takeScreenshot();
			resultcount++;
		}
	}
	
	public void instructionDetailsinput() throws Exception {				
		waitForElementPresent(xpath(nextBtn));
		waitForElementVisible(xpath(nextBtn));
		click(xpath(nextBtn));
		waitForElementPresent(xpath(FnameInstructionDetails));
		waitForElementVisible(xpath(FnameInstructionDetails));
		Thread.sleep(5000);
		
		if(isElementPresent(xpath(FnameInstructionDetails))){
			type(xpath(FnameInstructionDetails), input[17]);	
			}
		if(isElementPresent(xpath(LnameInstructionDetails))){
			type(xpath(LnameInstructionDetails), input[18]);	
			}
		if(isElementPresent(xpath(MobileInstructionDetails))){
			type(xpath(MobileInstructionDetails), input[19].substring(0, 10));	
			}
		if(isElementPresent(xpath(instructionDetailSameAsCustomerCheckbox))){
			click(xpath(instructionDetailSameAsCustomerCheckbox));	
			}
		if(isElementPresent(xpath(instructionDetailAddress))){
			type(xpath(instructionDetailAddress), input[20]);	
			}
		if(isElementPresent(xpath(EmailInstructionDetails))){
			type(xpath(EmailInstructionDetails), input[21]);	
			}
		
		waitForElementPresent(xpath(NextBtnInstructionDetails));
		waitForElementVisible(xpath(NextBtnInstructionDetails));
		click(xpath(NextBtnInstructionDetails));
	}
	public void PaymentDetailTitleDocuments() throws Exception {	
	
	waitForElementPresent(xpath(LabelPaymentDetails));
	waitForElementVisible(xpath(LabelPaymentDetails));
	Thread.sleep(5000);

	
	try{ Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails))); }
		catch(AssertionError e){
			fail(input[0] + " - Terms and Condition is not Displayed");
			resultcount++;
    		}
	try{ Assert.assertTrue(getText(xpath(paymentDetailPrice)).contains("$")); }
		catch(AssertionError e){
			fail(input[0] + " - Incorrect Price display");
			resultcount++;
    		}
	try{ Assert.assertTrue(getText(xpath(paymentDetailTotalPrice)).contains("$")); }
	catch(AssertionError e){
		fail(input[0] + " - Incorrect Price display");
		resultcount++;
		}
	try{ Assert.assertTrue(isElementPresent(xpath(AccountIDPaymentDetails))); }
		catch(AssertionError e){
			fail(input[0] + " - Account ID is not Displayed");
			resultcount++;
	if(isElementPresent(xpath(paymentDetailTitle1))){
		try{ Assert.assertTrue(getText(xpath(paymentDetailTitle1)).contains("$")); }
		catch(AssertionError a){
			fail(input[0] + " - Multiple Titles display");
			resultcount++;
		}
	if(isElementPresent(xpath(paymentDetailTitle2))){
		try{ Assert.assertTrue(getText(xpath(paymentDetailTitle1)).contains("$")); }
		catch(AssertionError a){
			fail(input[0] + " - Multiple Titles display");
			resultcount++;
			}
	}
	}
    }
	}
	
	public void AdminPromotionConfig() throws Exception {
	driver.navigate().to("stage-acme.rppropertyhub.com/admin");
	Thread.sleep(5000);
	Admin_TitleDocumentsUtil utu = new Admin_TitleDocumentsUtil(input);	
	utu.adminLogin();
	
	waitForElementPresent(xpath(adminProducts));
	waitForElementVisible(xpath(adminProducts));
	
    actionType(xpath(adminProducts), "Products");
    click(xpath(adminPromotionsLink));
	
    waitForElementPresent(xpath(adminPromotionsHeader));
	waitForElementVisible(xpath(adminPromotionsHeader));
    
    try{
    	Assert.assertTrue(isElementPresent(xpath(adminPromotionsHeader)));
    	}
    	catch(AssertionError e){
    		fail(input[0] + " - Base Product page not displayed");
    		resultcount++;
    		}
    click(xpath(baseProductAddNew));
    Thread.sleep(2000);
	
    
    //ENTER NEW FIELDS and VALUE to follow
	}
	
	public void ProductSelectionPageFromPaymentDetails() throws Exception {	
		
		waitForElementPresent(xpath(LabelPaymentDetails));
		waitForElementVisible(xpath(LabelPaymentDetails));
		Thread.sleep(5000);
	}
	
}
