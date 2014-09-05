package hub.utilities.RegressionSuiteUtil;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import com.thoughtworks.selenium.Selenium;

public class Admin_TitleDocumentsUtil extends FunctionReference {
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	private String[] input = null;
	public Selenium selenium;
	
	public Admin_TitleDocumentsUtil(String[] i) {
		input = i;
	}
	
	public Admin_TitleDocumentsUtil() {
	}


	public int adminLogin() throws Exception{
		String URL = driver.getCurrentUrl();
		if(URL.equalsIgnoreCase("https://olddev.rppropertyhub.com/admin")){
			Thread.sleep(2000);
		}
		
		waitForElementPresent(xpath(adminLoginUsername));
		waitForElementVisible(xpath(adminLoginUsername));
		type(xpath(adminLoginUsername), "Portia.Canlas@twistresources.com");
		
		
		if(URL.equalsIgnoreCase("https://olddev.rppropertyhub.com/admin")){
			type(xpath(adminLoginPassword), "Canlas482Center");	
			}
		if(URL.contains("stage")){
			type(xpath(adminLoginPassword), "482Center");
			}
	    click(xpath(adminLoginButton));
	    if(URL.equalsIgnoreCase("https://olddev.rppropertyhub.com/admin")){
			Thread.sleep(1000);
		}
	    try{
	    	waitForElementPresent(xpath(adminHome));
	    	waitForElementVisible(xpath(adminHome));
	    	Assert.assertTrue(isElementPresent(xpath(adminHome)));	
	    	Assert.assertTrue(isElementPresent(xpath(adminProducts)));
	    	Assert.assertTrue(isElementPresent(xpath(adminChannels)));
	    	Assert.assertTrue(isElementPresent(xpath(adminUsers)));
	    	Assert.assertTrue(isElementPresent(xpath(adminUtilities)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Menu are not properly displayed");
	    		resultcount++;
	    		}
	    
	return resultcount;
	}
	
	public int adminLogout() throws Exception{
		
		click(xpath(adminLogout));

		waitForElementPresent(xpath(adminLoginUsername));
		waitForElementVisible(xpath(adminLoginUsername));

	    try{
	    	Assert.assertTrue(isElementPresent(xpath(adminLoginUsername)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Did not Logout");
	    		resultcount++;
	    		}
	    
	return resultcount;
	}
	
	public int validateTitleInProductType() throws Exception{
		adminLogin();
		waitForElementPresent(xpath(adminProducts));
    	waitForElementVisible(xpath(adminProducts));
    	
	    actionType(xpath(adminProducts), "Products");
	    click(xpath(adminBaseProductLink));
	    
	    waitForElementPresent(xpath(baseProductHeader));
    	waitForElementVisible(xpath(baseProductHeader));
	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductHeader)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Base Product page not displayed");
	    		resultcount++;
	    		}
	    click(xpath(baseProductAddNew));
	    Thread.sleep(2000);
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductType)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductType));
	    Thread.sleep(500);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.TAB);
	    Thread.sleep(1000);

	    try{
	    	Assert.assertEquals(getValue(By.id("productType")), "42");
	    	Assert.assertTrue(getText(By.id("productType")).contains(input[1]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    click(xpath(baseProductHeader));
	    alertAccept();
	    waitForElementPresent(xpath(baseProductAddNew));
    	waitForElementVisible(xpath(baseProductAddNew));
    	
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductAddNew)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Add New Link not displayed");
	    		resultcount++;
	    		}
	    actionType(xpath(baseProductListContainer), "Modified By");
	    click(xpath(baseProductEdit));
	    
	    Thread.sleep(2000);
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductType)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductType));
	    Thread.sleep(500);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.TAB);
	    Thread.sleep(1000);

	    try{
	    	Assert.assertEquals(getValue(By.id("productType")), "42");
	    	Assert.assertTrue(getText(By.id("productType")).contains(input[1]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}

	return resultcount;
	}
	
	public int validateTitleInReportSource() throws Exception{
    	
	    actionType(xpath(adminProducts), "Products");
	    click(xpath(adminBaseProductLink));
	    alertAccept();
	    waitForElementPresent(xpath(baseProductHeader));
    	waitForElementVisible(xpath(baseProductHeader));
	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductHeader)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Base Product page not displayed");
	    		resultcount++;
	    		}
	    click(xpath(baseProductAddNew));
	    Thread.sleep(2000);
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductType)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductType));
	    Thread.sleep(500);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.TAB);
	    Thread.sleep(1000);

	    try{
	    	Assert.assertEquals(getValue(By.id("productType")), "42");
	    	Assert.assertTrue(getText(By.id("productType")).contains(input[1]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductReportSource));
	    Thread.sleep(500);
		driver.findElement(By.id("reportSourceLookup")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("reportSourceLookup")).sendKeys(Keys.ENTER);
	    Thread.sleep(1000);

	    try{
	    	Assert.assertEquals(getValue(By.id("reportSourceLookup")), "43");
	    	Assert.assertTrue(getText(By.id("reportSourceLookup")).contains(input[2]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Report Source value is not " + input[2]);
	    		resultcount++;
	    		}
	      
	    click(xpath(baseProductHeader));
	    alertAccept();
	    waitForElementPresent(xpath(baseProductAddNew));
    	waitForElementVisible(xpath(baseProductAddNew));
    	
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductAddNew)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Add New Link not displayed");
	    		resultcount++;
	    		}
	    actionType(xpath(baseProductListContainer), "Modified By");
	    click(xpath(baseProductEdit));
	    
	    Thread.sleep(2000);
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductType)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + "Not redirected to Edit Product");
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductType));
	    Thread.sleep(500);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.TAB);
	    Thread.sleep(1000);

	    try{
	    	Assert.assertEquals(getValue(By.id("productType")), "42");
	    	Assert.assertTrue(getText(By.id("productType")).contains(input[1]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}

	return resultcount;
	}
	
	public int PropertyTitleSearchConfiguration() throws Exception{

	    actionType(xpath(adminProducts), "Products");
	    click(xpath(adminBaseProductLink));
	    alertAccept();
	    waitForElementPresent(xpath(baseProductHeader));
    	waitForElementVisible(xpath(baseProductHeader));
	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductHeader)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Base Product page not displayed");
	    		resultcount++;
	    		}
	    
	    type(xpath(baseProductSearch), "Property Title");
	    Thread.sleep(1000);
	    click(xpath(baseProductSearchBtn));
	    Thread.sleep(3000);
	    actionType(xpath(baseProductListContainer), "Modified By");
	    click(xpath(baseProductEdit));   
	    Thread.sleep(5000);
	    waitForElementPresent(xpath(baseProductValexResponseAVMSource));
    	waitForElementVisible(xpath(baseProductValexResponseAVMSource));

	    try{

	    	Assert.assertEquals(getValue(xpath(baseProductName)), input[1]);
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product name value is not " + input[1]);
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductDataGroup)), input[2].substring(0, 2));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Data Group incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductType)), input[3].substring(0, 2));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type Group incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductReportSource)), input[4].substring(0, 2));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Report Source incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductReportType)).substring(0, 12), input[5].substring(0, 12));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Report Type incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductValexServiceType)).substring(0, 12), input[5].substring(0, 12));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Valex Service Type incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductValSubType)), input[6].substring(0, 2));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " ValSub Type incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductValSubTypeNote)).substring(0, 12), input[5].substring(0, 12));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " ValSub Type Note incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductConstruction)), input[7]);
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Construction incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductValexRequestAVMSource)), input[8].substring(0, 2));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Valex Request AVM Source incorrect value");
	    		resultcount++;
	    		}
	    try{
	    	Assert.assertEquals(getValue(xpath(baseProductValexResponseAVMSource)), input[8].substring(0, 2));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Valex Response AVM Source incorrect value");
	    		resultcount++;
	    		}
	    

	return resultcount;
	}
	
	public int validateTitleInReportType() throws Exception{
   
	    actionType(xpath(adminProducts), "Products");
	    click(xpath(adminBaseProductLink));
	    alertAccept();
	    waitForElementPresent(xpath(baseProductHeader));
    	waitForElementVisible(xpath(baseProductHeader));
	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductHeader)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Base Product page not displayed");
	    		resultcount++;
	    		}
	    click(xpath(baseProductAddNew));
	    Thread.sleep(2000);
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductType)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductType));
	    Thread.sleep(500);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.TAB);
	    Thread.sleep(1000);

	    try{
	    	Assert.assertEquals(getValue(By.id("productType")), "42");
	    	Assert.assertTrue(getText(By.id("productType")).contains(input[1]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductReportSource));
	    Thread.sleep(500);
		driver.findElement(By.id("reportSourceLookup")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("reportSourceLookup")).sendKeys(Keys.ENTER);
	    Thread.sleep(3000);

	    try{
	    	Assert.assertEquals(getValue(By.id("reportSourceLookup")), "43");
	    	Assert.assertTrue(getText(By.id("reportSourceLookup")).contains(input[2]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Report Source value is not " + input[2]);
	    		resultcount++;
	    		}
	    
	    waitForElementPresent(xpath(baseProductReportType));
    	waitForElementVisible(xpath(baseProductReportType));
	    click(xpath(baseProductReportType));
	    Thread.sleep(500);
		driver.findElement(By.id("reportType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("reportType")).sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
	    
	    try{

	    	Assert.assertEquals(getValue(By.id("reportType")), input[3]);
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Report Type-1 value is not " + input[3]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductHeader));
	    alertAccept();
	    waitForElementPresent(xpath(baseProductAddNew));
    	waitForElementVisible(xpath(baseProductAddNew));
    	
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductAddNew)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Add New Link not displayed");
	    		resultcount++;
	    		}
	    actionType(xpath(baseProductListContainer), "Modified By");
	    click(xpath(baseProductEdit));
	    
	    Thread.sleep(2000);
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(baseProductType)));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + "Not redirected to Edit Product");
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductType));
	    Thread.sleep(500);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("productType")).sendKeys(Keys.TAB);
	    Thread.sleep(1000);

	    try{
	    	Assert.assertEquals(getValue(By.id("productType")), "42");
	    	Assert.assertTrue(getText(By.id("productType")).contains(input[1]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Type value is not " + input[1]);
	    		resultcount++;
	    		}
	    
	    click(xpath(baseProductReportSource));
	    Thread.sleep(500);
		driver.findElement(By.id("reportSourceLookup")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("reportSourceLookup")).sendKeys(Keys.ENTER);
	    Thread.sleep(3000);

	    try{
	    	Assert.assertEquals(getValue(By.id("reportSourceLookup")), "43");
	    	Assert.assertTrue(getText(By.id("reportSourceLookup")).contains(input[2]));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Report Source value is not " + input[2]);
	    		resultcount++;
	    		}
	    
	    waitForElementPresent(xpath(baseProductReportType));
    	waitForElementVisible(xpath(baseProductReportType));
	    click(xpath(baseProductReportType));
	    Thread.sleep(500);
		driver.findElement(By.id("reportType")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("reportType")).sendKeys(Keys.ENTER);

		return resultcount;
	}
	
	
	public int validateCustomProducts() throws Exception{

	    actionType(xpath(adminProducts), "Products");
	    click(xpath(adminCustomProductLink));
	    alertAccept();
	    waitForElementPresent(xpath(customProductHeader));
    	waitForElementVisible(xpath(customProductHeader));
    	
    	type(xpath(customProductSearch), input[1]);
    	Thread.sleep(500);
    	click(xpath(customProductSearchBtn));
    	Thread.sleep(5000);
    	
    	waitForElementPresent(xpath(customProductSearchResult));
    	waitForElementVisible(xpath(customProductSearchResult));
    	
    	if(getText(xpath(customProductSearchResult)).contains(input[1])){}
    	else{Thread.sleep(7000);}

    	click(xpath(baseProductEdit));
    	Thread.sleep(2000);
    	waitForElementPresent(xpath(customProductShortDesc));
    	waitForElementVisible(xpath(customProductShortDesc));

    	try{
	    	Assert.assertEquals(getValue(xpath(customProductSearch)), input[1]);
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Product Name incorrect value");
	    		resultcount++;
	    		}
    	try{
	    	Assert.assertEquals(getValue(xpath(customProductShortDesc)), input[2]);
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Short Description incorrect value");
	    		resultcount++;
	    		}
    	try{
	    	Assert.assertEquals(getValue(xpath(customProductLongDesc)), input[3]);
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Long Description incorrect value");
	    		resultcount++;
	    		}
    	try{
	    	Assert.assertEquals(getValue(xpath(customProductProductTab)), input[4].substring(0, 2));
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " Construction incorrect value");
	    		resultcount++;
	    		}
    	return resultcount;
	}
	
	public int validateProductDataGroups() throws Exception{

	 actionType(xpath(adminProducts), "Products");
	 click(xpath(adminProductDataGroupsLink));
	 alertAccept();
	waitForElementPresent(xpath(ProductDataGroupsSearch));
 	waitForElementVisible(xpath(ProductDataGroupsSearch));
 	
 	type(xpath(ProductDataGroupsSearch), input[1]);
 	Thread.sleep(500);
 	click(xpath(ProductDataGroupsSearchBtn));
 	Thread.sleep(5000);
 	
 	waitForElementPresent(xpath(ProductDataGroupsSearchResult));
 	waitForElementVisible(xpath(ProductDataGroupsSearchResult));
 	
 	if(getText(xpath(ProductDataGroupsSearchResult)).contains(input[1])){}
 	else{Thread.sleep(7000);}

 	click(xpath(baseProductEdit));
 	Thread.sleep(2000);
 	
 	try{
 		Assert.assertTrue(driver.findElement(xpath(ProductDataGroupsFirstNameCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " First Name is not selected");
    		resultcount++;
    		}
 	try{
 		Assert.assertTrue(driver.findElement(xpath(ProductDataGroupsLastNameCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " Last Name is not selected");
    		resultcount++;
    		}
 	try{
 		Assert.assertTrue(driver.findElement(xpath(ProductDataGroupsContactNumberCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " Contact Number is not selected");
    		resultcount++;
    		}
 	try{
 		Assert.assertTrue(driver.findElement(xpath(ProductDataGroupsEmailCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " Email is not selected");
    		resultcount++;
    		}
 	try{
 		Assert.assertTrue(driver.findElement(xpath(ProductDataGroupsFirstNameMandatoryCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " Email is not selected");
    		resultcount++;
    		}
 	try{
 		Assert.assertTrue(driver.findElement(xpath(ProductDataGroupsLastNameMandatoryCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " Email is not selected");
    		resultcount++;
    		}
 	try{
 		Assert.assertFalse(driver.findElement(xpath(ProductDataGroupsContactNumberMandatoryCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " Email is not selected");
    		resultcount++;
    		}
 	try{
 		Assert.assertFalse(driver.findElement(xpath(ProductDataGroupsEmailMandatoryCheckbox)).isSelected());
    	}
    	catch(AssertionError e){
    		fail(input[0] + " Email is not selected");
    		resultcount++;
    		}
 	return resultcount;
	}
	
	public void alertAccept() throws Exception{
	int val = alertvalidation();
	
	if(val != 0){ }
	else{
		driver.switchTo().alert().accept();
	}
    Thread.sleep(2000);
	}

	public int alertvalidation() throws Exception{
	try{
        driver.switchTo().alert();
        return 0;
    }//try
    catch(Exception e){
    	return 1;
    }
	}
}