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
		
		public String environment = "https://stage-";
	
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
			click(xpath(infoIcon));
			Assert.assertEquals(getValue(xpath(userOEVPP)),getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y));
			y++;
		}while(y!=17);

	}
	public void doataPropertyExclusions() throws Exception{
		Assert.assertEquals(getText(xpath(oevppLabel)), "* Owners Estimated Value / Purchase Price");
		Assert.assertEquals(getText(xpath(oevppLabelDollar)), "$ ");
		Assert.assertTrue(isElementPresent(xpath(userOEVPP)),"OEV/PP field is not present");
		
	}

	public void doataRequired() throws Exception{
		click(xpath(userOriginatorToProductSelection));
		waitForElement error message
		verify error message
		select none apply 
		error message disappears		
	}


}
