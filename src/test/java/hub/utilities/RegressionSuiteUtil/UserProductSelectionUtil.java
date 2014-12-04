package hub.utilities.RegressionSuiteUtil;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

import com.thoughtworks.selenium.Selenium;

public class UserProductSelectionUtil extends FunctionReference {
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	//private String[] input = null;
	public Selenium selenium;
	
	public UserProductSelectionUtil(String[] i) {
		//input = i;
	}
	
	public UserProductSelectionUtil() {
	}
		
		public String environment = "https://dev-";
	
	public void successfulLogin() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 1, 2));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 2, 2));
		click(xpath(loginButton));

		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		
		Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
	}
	
	public void slas() throws Exception {
		waitForElementPresent(xpath(userPropertySearch));
		waitForElementVisible(xpath(userPropertySearch));
		if(!isElementPresent(xpath(userPropertySearch))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userPropertySearch))){ Thread.sleep(3000); }

		try {
			Assert.assertEquals("Enter your property address or street name here.", getValue(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			fail("SLAS placeholder text");
		}
		type(xpath(userPropertySearch), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 0));		
		click(xpath(userSearchButton));
		Thread.sleep(3000);
	}
	
	public void proceedProductSelection() throws Exception {	
		waitForElementPresent(xpath(userProceedToProductSelection));
		waitForElementVisible(xpath(userProceedToProductSelection));
		if(isElementPresent(xpath(userProceedToProductSelection))){
			click(xpath(userProceedToProductSelection));
			}
		Thread.sleep(6000);
	}
	
	public void startNewTransaction() throws Exception {
		if(isElementPresent(xpath(userPendingTransactionMessage))){
	        click(By.linkText("Start a new transaction for this property"));      
	    }
        Thread.sleep(3000);	
	}	
	public void changeAddressLink() throws Exception {
	    click(By.linkText("Change property address"));    
        Thread.sleep(3000);	
        waitForElementPresent(xpath(userPropertySearch));
		waitForElementVisible(xpath(userPropertySearch));
	}	
	
	public void noPromptOriginatorDetails() throws Exception{
		successfulLogin();
		slas();
		startNewTransaction();
		proceedProductSelection();
		waitForElementPresent(xpath(productTabsMenu));
		waitForElementVisible(xpath(productTabsMenu));
		Assert.assertFalse(isElementVisible(xpath(userOriginatorDetails)), "Originator Details should not display on tab not requiring BRE");	
	}
	
	public void promptOriginatorDetails() throws Exception{		
		waitForElementPresent(xpath(productTabsMenu));
		waitForElementVisible(xpath(productTabsMenu));
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));	
		
		waitForElementPresent(xpath(userOriginatorDetails));
		waitForElementVisible(xpath(userOriginatorDetails));
		Assert.assertTrue(isElementPresent(xpath(userOriginatorDetails)),"Originator Details is not displayed");
		Thread.sleep(3000);
		Assert.assertEquals(getText(xpath(originatorHeader)),"Please provide the following details to proceed:");		
	}

	public void originatorToProductSelection() throws Exception{
		waitForElementPresent(xpath(userOriginatorDetails));
		waitForElementVisible(xpath(userOriginatorDetails));
		Assert.assertTrue(isElementPresent(xpath(iconOriginatorToProductSelection)),"Procced to product selection icon is not displayed");
		Assert.assertTrue(isElementPresent(xpath(userOriginatorToProductSelection)),"Procced to product selection link is not displayed");		
	}

	public void informationIcon() throws Exception{
		Assert.assertTrue(isElementPresent(xpath(infoIcon)),"OEVPP Information icon is not displayed");
		actionType(xpath(infoIcon),"OEVPP Information Icon");
		Assert.assertEquals(getTooltip(xpath(infoIcon)), "This value is used to accurately price the products and services for this property. If you are buying the property then use the Contract Price, if not use your most accurate estimate of the current value of the property.");
		
	}

	public void propertyType() throws Exception{
		Assert.assertEquals(getText(xpath(propertyTypeLabel)), "* Is this a...?");
		Assert.assertTrue(isElementPresent(xpath(propertyTypeSelect)),"Property Type field is not present");
		Assert.assertEquals(getValue(xpath(propertyTypeSelect)), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, 0));
		
		int y=1;
		
		do{
			selectOption(xpath(propertyTypeSelect), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, y));
			String val = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, y);
			Assert.assertEquals(getText(xpath("//form[@id='propertyDetailQuestions']//option[@value='"+val+"']")), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y));
			y++;
		}while(y!=8);
		selectOption(xpath(propertyTypeSelect), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, 0));
		
	}

	public void oevppRequiredNumeric() throws Exception{
		Assert.assertEquals(getText(xpath(oevppLabel)), "* Owners Estimated Value / Purchase Price");
		Assert.assertEquals(getText(xpath(oevppLabelDollar)), "$ ");
		Assert.assertTrue(isElementPresent(xpath(userOEVPP)),"OEV/PP field is not present");
		click(xpath(userOEVPP));
		click(xpath(userOriginatorToProductSelection));
		Assert.assertTrue(isElementVisible(xpath(oevppErrorMsg)),"Error message is not displayed");
		Assert.assertEquals(getText(xpath(oevppErrorMsg)), " Field should not be empty.");
		type(xpath(userOEVPP),(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 8)));
		Assert.assertEquals(getValue(xpath(userOEVPP)),getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 8));
		click(xpath(userOriginatorToProductSelection));
		Thread.sleep(3000);
	}

	public void oevppFormatted() throws Exception{
		int y=9;		
		do{
			click(xpath(userOEVPP));
			type(xpath(userOEVPP),(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, y)));
			Thread.sleep(1000);
			click(xpath(infoIcon));
			Assert.assertEquals(getValue(xpath(userOEVPP)),getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y));
			y++;
		}while(y!=17);
	}

	public void daotaPropertyExclusions() throws Exception{
		Assert.assertEquals(getText(xpath(daotaLabel)), "* Do Any Of These Apply?");
		int x=1;
		int y=17;
		do{
		System.out.println("Checking "+getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, y));
		String excId = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, y);
		String excText = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y);
		Assert.assertTrue(isElementPresent(xpath("//form[@id='propertyDetailQuestions']//input[@id='"+excId+"']")), excText+" is not present");	
		Assert.assertTrue(getText(xpath("//*[@id='propertyDetailQuestions']/div[2]/table[1]/tbody/tr[7]/td[3]/span["+x+"]")).contains(excText));
		x++;
		y++;
		}while(y!=33);
	}

	public void daotaRequired() throws Exception{
		click(xpath(xButton));
		Thread.sleep(3000);
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));
		Thread.sleep(3000);
		click(xpath(userOriginatorToProductSelection));
		Assert.assertTrue(isElementVisible(xpath(daotaErrorMsg)),"Error message is not displayed");
		Assert.assertEquals(getText(xpath(daotaErrorMsg)), " Field should be checked..");	
	}
	
	public void loanPurpose() throws Exception{
		Assert.assertEquals(getText(xpath(loanPurposeLabel)), "* Loan Purpose");
		int y=33;
		do{
		String loanPId = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, y);
		String loanPText = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y);
		Assert.assertTrue(isElementPresent(xpath("//form[@id='propertyDetailQuestions']//input[@value='"+loanPId+"']")), loanPText+" is not present");	
		y++;
		}while(y!=38);
	}

	public void avmAckDisplay() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(avmAckLabel)), "AVM Acknowledgement is not displayed");	
		Assert.assertEquals(getText(xpath(avmAckLabel)), "* AVM Acknowledgement");
		Assert.assertTrue(isElementVisible(xpath(avmAckSelect)), "AVM Acknowledgement checkbox is not displayed");
		Assert.assertTrue(getText(xpath(avmAckDesc)).contains("Before ordering an Automated Valuation Report I have informed the customer that"));
	}
	
	public void avmAckRequired() throws Exception{
		click(xpath(xButton));
		Thread.sleep(3000);
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));
		Thread.sleep(3000);
		click(xpath(userOriginatorToProductSelection));
		Assert.assertTrue(isElementVisible(xpath(avmAckError)),"AVM Ack error message is not displayed");
		Assert.assertEquals(getText(xpath(avmAckError)), " Field should be checked..");			
	}
	
	public void loanAppDisplay() throws Exception{
		click(xpath(daotaCompanyTitle));
		Thread.sleep(2000);
		Assert.assertTrue(isElementVisible(xpath(loanAppLabel)), "Loan Application is not displayed");	
		Assert.assertEquals(getText(xpath(loanAppLabel)), "* Loan Application");
		Assert.assertTrue(isElementVisible(xpath(loanAppSelect)), "Loan Application checkbox is not displayed");
		Assert.assertEquals(getText(xpath(loanAppDesc)),"I confirm this valuation request is required for a Home Loan Application (CHL / VAS Decision) / Loan Maintenance Application(CHLM)");
	}
	public void loanAppRequired() throws Exception{
		click(xpath(xButton));
		Thread.sleep(3000);
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));
		Thread.sleep(3000);
		click(xpath(userOriginatorToProductSelection));
		Thread.sleep(3000);
		Assert.assertTrue(isElementVisible(xpath(avmAckError)),"AVM Ack error message is not displayed");
//		Assert.assertTrue(isElementVisible(xpath(loanAppError)),"Loan App error message is not displayed");
		Assert.assertEquals(getText(xpath(avmAckError)), " Field should be checked..");			
	}

	public void urlHttps() throws Exception{
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("https"));
	}

	public void lenderEmpowermentNoRPID() throws Exception{
		click(xpath(xButton));
		Thread.sleep(3000);
		changeAddressLink();	
		Thread.sleep(3000);
		click(xpath(cantFindAddressbtn));
		type(xpath(unitNumberSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 39));
		type(xpath(streetNumberSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 39));
		type(xpath(streetNameSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, 39));
		type(xpath(streetTypeSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 4, 39));
		type(xpath(suburbSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 5, 39));
		click(xpath(confirmbtnSearchAddress));
		Thread.sleep(3000);
		proceedProductSelection();
		Assert.assertFalse(isElementVisible(xpath(productLenderEmpowerment)), "Lender Empowerment is not offered");		
		Thread.sleep(3000);
	}
	
	public void lenderEmpowermentMetropolitan() throws Exception{
		changeAddressLink();
		Thread.sleep(3000);
		type(xpath(userPropertySearch), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 38));		
		click(xpath(userSearchButton));
		Thread.sleep(3000);
		startNewTransaction();
		proceedProductSelection();
		Assert.assertTrue(isElementVisible(xpath(productLenderEmpowerment)), "Lender Empowerment is not offered");		
	}

	public void productOnAccount() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(onAccountDisplay)), "On Account text is not displayed");
		Assert.assertEquals(getText(xpath(onAccountDisplay)), "Price: On Account");		
	}

	public void cartLinkFunctionality() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(cartCount)), "Cart Count link is not displayed");
		Assert.assertEquals(getText(xpath(cartCount)), "(0)");	
		click(xpath(cartCount));
		Thread.sleep(2000);
		Assert.assertTrue(isElementVisible(xpath(emptyCartMessage)), "Empty Cart Message is not displayed");
		Assert.assertEquals(getText(xpath(emptyCartMessage)), "Please add an item to cart to proceed.");
		Assert.assertTrue(isElementVisible(xpath(emptyCartOkBtn)), "Empty Cart Ok Button is not displayed");
		Assert.assertTrue(isElementVisible(xpath(emptyCartXBtn)), "Empty Cart X Button is not displayed");
		click(xpath(emptyCartOkBtn));
		Thread.sleep(2000);
		click(xpath(instructionDetailsTab));
		Thread.sleep(2000);
		Assert.assertTrue(isElementVisible(xpath(emptyCartMessage)), "Empty Cart Message is not displayed");
		Assert.assertEquals(getText(xpath(emptyCartMessage)), "Please add an item to cart to proceed.");
		Assert.assertTrue(isElementVisible(xpath(emptyCartOkBtn)), "Empty Cart Ok Button is not displayed");
		Assert.assertTrue(isElementVisible(xpath(emptyCartXBtn)), "Empty Cart X Button is not displayed");		
		click(xpath(emptyCartOkBtn));
		Thread.sleep(2000);
		click(xpath(productLenderEmpowerment));
		waitForElementVisible(xpath(lenderEmpAdded));
		Assert.assertEquals(getText(xpath(cartCount)), "(1)");	
		click(xpath(cartCount));
		Thread.sleep(3000);		
		Assert.assertTrue(isElementVisible(xpath(cartInstructionMessage)), "Instruction details message is not displayed");
		Assert.assertTrue(getText(xpath(cartInstructionMessage)).contains("Cart and Payment screen will not be available until mandatory fields from Instruction Details are filled in."));
		Assert.assertTrue(getText(xpath(cartInstructionMessage)).contains("Do you want to move forward to the Instruction Details screen?"));
		click(xpath(emptyCartXBtn));
		Thread.sleep(3000);	
	}
	


}
