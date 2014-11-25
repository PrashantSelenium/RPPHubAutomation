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
		Thread.sleep(3000);
	}
	
	public void promptOriginatorDetails() throws Exception{
		successfulLogin();
		slas();
		proceedProductSelection();
		
		waitForElementPresent(xpath(productTabsMenu));
		waitForElementVisible(xpath(productTabsMenu));
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));	
		
		waitForElementPresent(xpath(userOriginatorDetails));
		waitForElementVisible(xpath(userOriginatorDetails));
		Thread.sleep(3000);
	}

}
