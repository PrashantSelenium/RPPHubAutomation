package hub.utilities.RegressionSuiteUtil;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;
import hub.library.ReadXmlData;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.thoughtworks.selenium.Selenium;

public class AdminRegressionSuiteUtil extends FunctionReference {
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	//private String[] input = null;
	public Selenium selenium;
	
	public AdminRegressionSuiteUtil(String[] i) {
		//input = i;
	}
	
	public AdminRegressionSuiteUtil() {
	}


	public void adminLogin() throws Exception{
		driver.navigate().to("https://dev.rppropertyhub.com/admin");
		
		waitForElementPresent(xpath(adminLoginUsername));	
		isElementPresent(xpath(adminLoginUsername));
		isElementPresent(xpath(adminLoginPassword));
		isElementPresent(xpath(adminLoginButton));
		
		type(xpath(adminLoginUsername), "Portia.Canlas@twistresources.com");
		type(xpath(adminLoginPassword), "482Center");
		click(xpath(adminLoginButton));
		
		waitForElementPresent(xpath(adminLinkLogout));		
	}
	
	public void channelListNav() throws Exception{		
		waitForElementPresent(xpath(adminChannels));			
		actionType(xpath(adminChannels), "Channels");
	    click(xpath(adminChannelList));		
	    Thread.sleep(2000);
	}
	
	public void channelListSearch() throws Exception{
		waitForElementPresent(xpath(channelListHeader));
		isElementPresent(xpath(channelListSearchField));
		System.out.println(getDataFromxls(0, "AVMSource.xls", 0, 0));
		Thread.sleep(2000);
		type(xpath(channelListSearchField), getDataFromxls(0, "AVMSource.xls", 0, 0));
		click(xpath(channelListSearchBtn));		
		Thread.sleep(2000);
	}
	
	public void channelListEdit() throws Exception{
		waitForElementPresent(xpath(channelListRow));
		actionType(xpath(channelListRow), "channel_list_container");	
		click(xpath(channelListLender));
		Thread.sleep(3000);
	}
	
	public void channelPropertyAddressNav() throws Exception{
		waitForElementPresent(xpath(channelPropertyAddressNav));
		click(xpath(channelPropertyAddressNav));
		Thread.sleep(3000);
	}
	
	public void channelAVMSourceSection() throws Exception{
		waitForElementPresent(xpath(propAddressAVMSource));
		isElementPresent(xpath(propAddressAVMSource));
		Assert.assertEquals(getText(xpath(propAddressAVMSource)), "AVM Source");
	}
	
	public void channelAVMSourceOptions() throws Exception{
		waitForElementPresent(xpath(propAddressDropdownLabel));
		isElementPresent(xpath(propAddressDropdownLabel));
		
		waitForElementPresent(xpath(propAddressDropdown));
		isElementPresent(xpath(propAddressDropdown));
		select(xpath(propAddressDropdown), "avmSource1");
		Assert.assertEquals(getValue(xpath(propAddressDropdown)), "Internal");
		select(xpath(propAddressDropdown), "avmSource2");
		Assert.assertEquals(getValue(xpath(propAddressDropdown)), "CBA AVM");
	}
	 
	public void SetAccountPassword_StaffID_Value(boolean AccountPasswordValue, boolean StaffIDValue ) throws Exception{
		
		adminLogin();
		
	    	Assert.assertTrue(isElementPresent(xpath(adminHomeMenu)));
	    	Assert.assertTrue(isElementPresent(xpath(adminChannelsMenu)));
		
		actionType(xpath(adminChannels), "Channel List");
	    click(xpath(adminChannelList));
	    if(!isElementPresent(xpath(channelListHeader))){ Thread.sleep(3000);}
	    if(!isElementPresent(xpath(channelListHeader))){ Thread.sleep(3000);}
	    Assert.assertTrue(isElementPresent(xpath(channelListHeader)));
	    
	    type(xpath(adminChannelSearchTextField), getDataFromxls(0, "adminCartCount.xls", 1, 20));
	    Thread.sleep(500);
	    click(xpath(channelSearchBtn));
	    Thread.sleep(1000);
	    
	    if(!isElementVisible(xpath(channelResult))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(channelResult))){ Thread.sleep(2000); }
	    
	    actionType(xpath(channelResult), " Commonwealth Bank (Lender)");
	    click(xpath(baseProductEdit));
	    waitForElementPresent(xpath(adminChannelCartAndPayment));
	    waitForElementVisible(xpath(adminChannelCartAndPayment));
	    
	    if(!isElementVisible(xpath(adminChannelCartAndPayment))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(adminChannelCartAndPayment))){ Thread.sleep(2000); }
	    
	    Assert.assertTrue(isElementPresent(xpath(adminChannelCartAndPayment)));
	    click(xpath(adminChannelCartAndPayment));
	    
	    waitForElementPresent(xpath(adminAccountPasswordCheckbox));
	    waitForElementVisible(xpath(adminAccountPasswordCheckbox));
	    
	    if(!isElementVisible(xpath(adminAccountPasswordCheckbox))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(adminAccountPasswordCheckbox))){ Thread.sleep(2000); }
	    
	    Assert.assertTrue(isElementPresent(xpath(adminAccountPasswordCheckbox)));
	    Assert.assertTrue(isElementPresent(xpath(adminStaffIDCheckbox)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountHeaderMessage)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountMainHeaderMessage)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountReenterStaffIDLabel)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountReenterAccountPasswordLabel)));
	    
	    String getaccountvalue = driver.findElement(By.xpath(adminAccountPasswordCheckbox)).getAttribute("checked");
	    String getstaffidvalue = driver.findElement(By.xpath(adminStaffIDCheckbox)).getAttribute("checked");
	    //account password set value and validation
	    if(AccountPasswordValue == true){
	    	//check if account password is not yet checked
	    	if(getaccountvalue == null){
	    		click(xpath(adminAccountPasswordCheckbox));
	    	}
	    }else{
	    	//check if account password is checked
	    	if(getaccountvalue.equals("true")){
	    		click(xpath(adminAccountPasswordCheckbox));
	    		}
	    	}
	    
	    //staff id set value and validation
	    if(StaffIDValue == true){
	    	//check if account password is not yet checked
	    	if(getstaffidvalue == null){
	    		click(xpath(adminStaffIDCheckbox));
	    	}
	    }else{
	    	//check if account password is checked
	    	if(getstaffidvalue.equals("true")){
	    		click(xpath(adminStaffIDCheckbox));
	    		}
	    	}
	    click(xpath(adminButtonSave));
	    Thread.sleep(1000);
	    
	}
	
	public void Validation_AccountPassword_InitialValue() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("dmin")){
			adminLogin();
			}else{
			click(xpath(adminChannelList));
			}
		
	    	Assert.assertTrue(isElementPresent(xpath(adminHomeMenu)));
	    	Assert.assertTrue(isElementPresent(xpath(adminChannelsMenu)));
		
		actionType(xpath(adminChannels), "Channel List");
	    click(xpath(adminChannelList));
	    if(!isElementPresent(xpath(channelListHeader))){ Thread.sleep(3000);}
	    if(!isElementPresent(xpath(channelListHeader))){ Thread.sleep(3000);}
	    Assert.assertTrue(isElementPresent(xpath(channelListHeader)));
	    
	    type(xpath(adminChannelSearchTextField), getDataFromxls(0, "adminCartCount.xls", 1, 20));
	    Thread.sleep(500);
	    click(xpath(channelSearchBtn));
	    Thread.sleep(1000);
	    
	    if(!isElementVisible(xpath(channelResult))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(channelResult))){ Thread.sleep(2000); }
	    
	    actionType(xpath(channelResult), " Commonwealth Bank (Lender)");
	    click(xpath(baseProductEdit));
	    waitForElementPresent(xpath(adminChannelCartAndPayment));
	    waitForElementVisible(xpath(adminChannelCartAndPayment));
	    
	    if(!isElementVisible(xpath(adminChannelCartAndPayment))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(adminChannelCartAndPayment))){ Thread.sleep(2000); }
	    
	    Assert.assertTrue(isElementPresent(xpath(adminChannelCartAndPayment)));
	    click(xpath(adminChannelCartAndPayment));
	    
	    waitForElementPresent(xpath(adminAccountPasswordCheckbox));
	    waitForElementVisible(xpath(adminAccountPasswordCheckbox));
	    
	    if(!isElementVisible(xpath(adminAccountPasswordCheckbox))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(adminAccountPasswordCheckbox))){ Thread.sleep(2000); }
	    
	    Assert.assertTrue(isElementPresent(xpath(adminAccountPasswordCheckbox)));
	    Assert.assertTrue(isElementPresent(xpath(adminStaffIDCheckbox)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountHeaderMessage)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountMainHeaderMessage)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountReenterStaffIDLabel)));
	    Assert.assertTrue(isElementPresent(xpath(adminOnAccountReenterAccountPasswordLabel)));
	    
	    String getaccountvalue = driver.findElement(By.xpath(adminAccountPasswordCheckbox)).getAttribute("checked");
	    String getstaffidvalue = driver.findElement(By.xpath(adminStaffIDCheckbox)).getAttribute("checked");
	    
	    Assert.assertEquals(getaccountvalue, "true");
	    Assert.assertEquals(getstaffidvalue, "true");
	}	

	public void Logout_link() throws Exception{
		
		click(xpath(adminLinkLogout));
		waitForElementPresent(xpath(adminLoginUsername));
		waitForElementVisible(xpath(adminLoginUsername));
		if(!isElementPresent(xpath(adminLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(adminLoginUsername))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(adminLoginUsername)), "Logout not Successful");
	}
	
	public void Account_Password_OFF_Payment_Details_validation() throws Exception{
		waitForElementPresent(xpath(NextBtnInstructionDetails));
		waitForElementVisible(xpath(NextBtnInstructionDetails));
		click(xpath(NextBtnInstructionDetails));
		Thread.sleep(5000);
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
	    	Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)));
	    	Assert.assertFalse(isElementPresent(xpath(AccountPasswordPaymentDetails)));
	    	Assert.assertTrue(isElementPresent(xpath(AccountIDPaymentDetails)));

	}
	
	public void Account_Password_On_Payment_Details_validation() throws Exception{
		waitForElementPresent(xpath(NextBtnInstructionDetails));
		waitForElementVisible(xpath(NextBtnInstructionDetails));
		click(xpath(NextBtnInstructionDetails));
		Thread.sleep(5000);
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
	    	Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)));
	    	Assert.assertTrue(isElementPresent(xpath(AccountPasswordPaymentDetails)));
	    	Assert.assertTrue(isElementPresent(xpath(AccountIDPaymentDetails)));

	}
	
	public void StaffID_OFF_Payment_Details_validation() throws Exception{
		waitForElementPresent(xpath(NextBtnInstructionDetails));
		waitForElementVisible(xpath(NextBtnInstructionDetails));
		click(xpath(NextBtnInstructionDetails));
		Thread.sleep(5000);
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
	    	Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)));
	    	Assert.assertTrue(isElementPresent(xpath(AccountPasswordPaymentDetails)));
	    	Assert.assertFalse(isElementPresent(xpath(AccountIDPaymentDetails)));

	}
	
	
	public void Admin_config_Base_Product_CBAAVM() throws Exception{
		
		adminLogin();
		actionType(xpath(adminProducts), "Products");
	    click(xpath(adminBaseProductLink));

	    waitForElementPresent(xpath(baseProductHeader));
    	waitForElementVisible(xpath(baseProductHeader));
	     
	    	Assert.assertTrue(isElementPresent(xpath(baseProductHeader)));
	    
	    type(xpath(baseProductSearch), "CBA Lender");
	    Thread.sleep(1000);
	    click(xpath(baseProductSearchBtn));
	    Thread.sleep(3000);
	    actionType(xpath(baseProductListContainer), "Modified By");
	    click(xpath(baseProductEdit));   
	    Thread.sleep(5000);
	    waitForElementPresent(xpath(baseProductValexResponseAVMSource));
    	waitForElementVisible(xpath(baseProductValexResponseAVMSource));
    	if(!isElementVisible(xpath(baseProductValexResponseAVMSource))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(baseProductValexResponseAVMSource))){ Thread.sleep(2000); }
	    
	    Boolean BRERequiredCheckbox = driver.findElement(By.xpath(baseProductBRECheckbox)).isSelected();

	    if(BRERequiredCheckbox){
	    	int x=0;
	    	 do{
	    		 x++;
	    		 driver.findElement(By.id("breServiceCode")).sendKeys(Keys.DOWN);
	    	 }while(x<=15);
	    	 driver.findElement(By.id("breServiceCode")).sendKeys(Keys.ENTER);
	    	 Assert.assertTrue(getText(xpath(BREServiceCode)).contains("CBAAVM"));
	    	 Assert.assertEquals(getValue(xpath(BREServiceCode)), "45");
	    	 click(xpath(baseProductBRECheckbox));
	    	 click(xpath(adminPromotionSave));
	    	 waitForElementVisible(xpath(baseProductValexResponseAVMSource));
	     	 waitForElementVisible(xpath(baseProductBRECheckbox));
	      	if(!isElementVisible(xpath(baseProductBRECheckbox))){ Thread.sleep(2000); }
	 	    if(!isElementPresent(xpath(baseProductBRECheckbox))){ Thread.sleep(2000); }
	 	    
	 	    BRERequiredCheckbox = driver.findElement(By.xpath(baseProductBRECheckbox)).isSelected();
	    	Assert.assertTrue(!BRERequiredCheckbox);
	    	 
	    }else{
	    	 click(xpath(baseProductBRECheckbox));
	    	 Thread.sleep(500);
	    	 int x=0;
	    	 do{
	    		 x++;
	    		 driver.findElement(By.id("breServiceCode")).sendKeys(Keys.DOWN);
	    	 }while(x<=15);
	    	 driver.findElement(By.id("breServiceCode")).sendKeys(Keys.ENTER);
	    	 Assert.assertTrue(getText(xpath(BREServiceCode)).contains("CBAAVM"));
	    	 Assert.assertEquals(getValue(xpath(BREServiceCode)), "45");
	    	 
	    	 click(xpath(adminPromotionSave));
	    	 waitForElementVisible(xpath(baseProductValexResponseAVMSource));
	     	 waitForElementVisible(xpath(baseProductBRECheckbox));
	      	if(!isElementVisible(xpath(baseProductBRECheckbox))){ Thread.sleep(2000); }
	 	    if(!isElementPresent(xpath(baseProductBRECheckbox))){ Thread.sleep(2000); }
	 	    BRERequiredCheckbox = driver.findElement(By.xpath(baseProductBRECheckbox)).isSelected();
	    	Assert.assertTrue(BRERequiredCheckbox);
	    }
	}
	
	
	public void Admin_config_Channel_Product_Selection_CBAAVM() throws Exception{
		
		adminLogin();
		actionType(xpath(adminChannels), "Channels");
	    click(xpath(adminChannelsLink));

	    waitForElementPresent(xpath(channelListHeader));
    	waitForElementVisible(xpath(channelListHeader));
	     
	    	Assert.assertTrue(isElementPresent(xpath(channelListHeader)));
	    
	    type(xpath(channelListSearchField), "CBALender");
	    Thread.sleep(1000);
	    click(xpath(channelListSearchBtn));
	    Thread.sleep(3000);
	    actionType(xpath(channelContainer), "Modified By");
	    click(xpath(baseProductEdit));   
	    Thread.sleep(5000);
	    waitForElementPresent(xpath(channelListProductSelectionTab));
    	waitForElementVisible(xpath(channelListProductSelectionTab));
    	if(!isElementVisible(xpath(channelListProductSelectionTab))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(channelListProductSelectionTab))){ Thread.sleep(2000); }
	    click(xpath(channelListProductSelectionTab));
	    
	    waitForElementPresent(xpath(channelPropertyProfilerReport));
    	waitForElementVisible(xpath(channelPropertyProfilerReport));
    	if(!isElementVisible(xpath(channelPropertyProfilerReport))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(channelPropertyProfilerReport))){ Thread.sleep(2000); }
	    Assert.assertTrue(isElementPresent(xpath(channelPropertyProfilerReport)));

	    	int x=0;
	    	 do{
	    		 x++;
	    		 driver.findElement(By.id("110_breCodeValue")).sendKeys(Keys.DOWN);
	    	 }while(x<=15);
	    	 driver.findElement(By.id("110_breCodeValue")).sendKeys(Keys.ENTER);
	    	 Assert.assertTrue(getText(xpath(channelCBALenderEMPValue)).contains("CBAAVM"));
	    	 Assert.assertEquals(getValue(xpath(channelCBALenderEMPValue)), "45");
	    	 click(xpath(channelProductSelectionSaveBtn));
	    	 Assert.assertEquals(getValue(xpath(channelCBALenderEMPValue)), "45");
	    	 
	    	 x=0;
	    	 do{
	    		 x++;
	    		 driver.findElement(By.id("84_breCodeValue")).sendKeys(Keys.UP);
	    	 }while(x<=15);
	    	 driver.findElement(By.id("84_breCodeValue")).sendKeys(Keys.ENTER);
	    	 Assert.assertTrue(getText(xpath(channelCBALenderEMPValue)).contains("Not Applicable"));
	    	 Assert.assertEquals(getValue(xpath(channelCBALenderEMPValue)), "1");
	    	 click(xpath(channelProductSelectionSaveBtn));
	    	 Assert.assertEquals(getValue(xpath(channelCBALenderEMPValue)), "1");
	}
	
	public void Product_Selection_Not_Applicable() throws Exception{
			
			waitForElementPresent(xpath(changeAddressLink));
			waitForElementVisible(xpath(changeAddressLink));
			click(xpath(changeAddressLink));		
			Thread.sleep(3000);
			
			waitForElementPresent(xpath(userPropertySearch));
			waitForElementVisible(xpath(userPropertySearch));
			if(!isElementPresent(xpath(userPropertySearch)));{ Thread.sleep(2000); }
	    	if(!isElementPresent(xpath(userPropertySearch)));{ Thread.sleep(2000); }
			
			type(xpath(propertySearch), "56 Maxweld Street Ardeer VIC 3022");
			click(xpath(propertySearchbtn));
			
			waitForElementPresent(xpath(completeAddress));
			waitForElementVisible(xpath(completeAddress));
			if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
	    	if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
	    	
		if(isElementPresent(xpath(pendingTransaction))){
			click(xpath(pendingTransaction));
			}
				
			waitForElementPresent(xpath(proceedNextLink));
			waitForElementVisible(xpath(proceedNextLink));
			click(xpath(proceedNextLink));
			Thread.sleep(10000);
			waitForElementPresent(xpath(productNavBar));
			waitForElementVisible(xpath(productNavBar));
			
				Assert.assertTrue(isElementPresent(xpath(productNavBar)));
				Assert.assertTrue(isElementPresent(xpath(instructionNavBar)));
				Assert.assertTrue(isElementPresent(xpath(paymentNavBar)));
				Assert.assertTrue(isElementPresent(xpath(orderNavBar)));

			waitForElementPresent(xpath(purchaseBtn));
			waitForElementVisible(xpath(purchaseBtn));
			if(!isElementVisible(xpath(purchaseBtn))){ Thread.sleep(7000); }
			if(!isElementVisible(xpath(purchaseBtn))){ Thread.sleep(7000); }

				Assert.assertTrue(isElementPresent(xpath(purchaseBtn)));
			
			click(xpath(valuationsTab));
			Thread.sleep(4000);
			waitForElementPresent(xpath(unitPriceValuation));
			waitForElementVisible(xpath(unitPriceValuation));

			type(xpath(unitPriceValuation), "315000");
			click(xpath(noneApplyCheckboxValuation));
			click(xpath(avm));
			click(xpath(proceedToProductValuation));
			Thread.sleep(3000);
			waitForElementPresent(xpath(purchaseBtnSingle));
			waitForElementVisible(xpath(purchaseBtnSingle));
			Assert.assertEquals(getValue(xpath(purchaseBtnSingle)), "Not Available");

		}
	
	public void Login_Successful_login() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 1, 1));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 2, 1));
		click(xpath(loginButton));

		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		
		Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
	}
	
	public void Admin_config_Channel_Product_Selection_AVM_Applicable() throws Exception{
		
		waitForElementPresent(xpath(changeAddressLink));
		waitForElementVisible(xpath(changeAddressLink));
		click(xpath(changeAddressLink));		
		Thread.sleep(3000);
		
		waitForElementPresent(xpath(userPropertySearch));
		waitForElementVisible(xpath(userPropertySearch));
		if(!isElementPresent(xpath(userPropertySearch)));{ Thread.sleep(2000); }
    	if(!isElementPresent(xpath(userPropertySearch)));{ Thread.sleep(2000); }
		
		type(xpath(propertySearch), "56 Maxweld Street Ardeer VIC 3022");
		click(xpath(propertySearchbtn));
		
		waitForElementPresent(xpath(completeAddress));
		waitForElementVisible(xpath(completeAddress));
		if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
    	if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
    	
	if(isElementPresent(xpath(pendingTransaction))){
		click(xpath(pendingTransaction));
		}
			
		waitForElementPresent(xpath(proceedNextLink));
		waitForElementVisible(xpath(proceedNextLink));
		click(xpath(proceedNextLink));
		Thread.sleep(10000);
		waitForElementPresent(xpath(productNavBar));
		waitForElementVisible(xpath(productNavBar));
		
			Assert.assertTrue(isElementPresent(xpath(productNavBar)));
			Assert.assertTrue(isElementPresent(xpath(instructionNavBar)));
			Assert.assertTrue(isElementPresent(xpath(paymentNavBar)));
			Assert.assertTrue(isElementPresent(xpath(orderNavBar)));

		waitForElementPresent(xpath(purchaseBtn));
		waitForElementVisible(xpath(purchaseBtn));
		if(!isElementVisible(xpath(purchaseBtn))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(purchaseBtn))){ Thread.sleep(7000); }

			Assert.assertTrue(isElementPresent(xpath(purchaseBtn)));
		
		click(xpath(valuationsTab));
		Thread.sleep(4000);
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));

		type(xpath(unitPriceValuation), "315000");
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		Thread.sleep(3000);
		waitForElementPresent(xpath(purchaseBtnSingle));
		waitForElementVisible(xpath(purchaseBtnSingle));
		Assert.assertEquals(getValue(xpath(purchaseBtnSingle)), "Add to cart");

	}
	
	public void Admin_config_Channel_Product_Selection_CBAAVM_SETTOENABLE() throws Exception{
		adminLogin();
		actionType(xpath(adminChannels), "Channels");
	    click(xpath(adminChannelsLink));
	
	    waitForElementPresent(xpath(channelListHeader));
		waitForElementVisible(xpath(channelListHeader));
	     
	    	Assert.assertTrue(isElementPresent(xpath(channelListHeader)));
	    
	    type(xpath(channelListSearchField), "CBALender");
	    Thread.sleep(1000);
	    click(xpath(channelListSearchBtn));
	    Thread.sleep(3000);
	    actionType(xpath(channelContainer), "Modified By");
	    click(xpath(baseProductEdit));   
	    Thread.sleep(5000);
	    waitForElementPresent(xpath(channelListProductSelectionTab));
		waitForElementVisible(xpath(channelListProductSelectionTab));
		if(!isElementVisible(xpath(channelListProductSelectionTab))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(channelListProductSelectionTab))){ Thread.sleep(2000); }
	    click(xpath(channelListProductSelectionTab));
	    
	    waitForElementPresent(xpath(channelPropertyProfilerReport));
		waitForElementVisible(xpath(channelPropertyProfilerReport));
		if(!isElementVisible(xpath(channelPropertyProfilerReport))){ Thread.sleep(2000); }
	    if(!isElementPresent(xpath(channelPropertyProfilerReport))){ Thread.sleep(2000); }
	    Assert.assertTrue(isElementPresent(xpath(channelPropertyProfilerReport)));
	
	    	int x=0;
	    	 do{
	    		 x++;
	    		 driver.findElement(By.id("110_breCodeValue")).sendKeys(Keys.DOWN);
	    	 }while(x<=15);
	    	 driver.findElement(By.id("110_breCodeValue")).sendKeys(Keys.ENTER);
	    	 Assert.assertTrue(getText(xpath(channelCBALenderEMPValue)).contains("CBAAVM"));
	    	 Assert.assertEquals(getValue(xpath(channelCBALenderEMPValue)), "45");
	    	 click(xpath(channelProductSelectionSaveBtn));
	    	 Assert.assertEquals(getValue(xpath(channelCBALenderEMPValue)), "45");
	}
	
	public void baseProductNavigation() throws Exception {				
		actionType(xpath(adminProducts), "Products");			
		waitForElementPresent(xpath(adminBaseProductLink));
		Assert.assertTrue(isElementPresent(xpath(adminBaseProductLink)),"Base Product Link is not present");
		click(xpath(adminBaseProductLink));
		waitForElementPresent(xpath(baseProductHeader));
		Assert.assertTrue(isElementPresent(xpath(baseProductHeader)),"Base Product screen is not displayed");
		Thread.sleep(3000);
	}
	
	public void baseProductSearchIdentity() throws Exception {
		Thread.sleep(3000);
		type(xpath(baseProductSearch), getDataFromxls(0, "User_OrderConfirmation.xls", 1, 2));
		click(xpath(baseProductSearchBtn));
		Thread.sleep(3000);
	}
	public void baseProductSearchCredit() throws Exception {
		Thread.sleep(3000);
		type(xpath(baseProductSearch), getDataFromxls(0, "User_OrderConfirmation.xls", 1, 1));
		click(xpath(baseProductSearchBtn));
		Thread.sleep(3000);
	}
	public void configIdentityVerification() throws Exception {
		actionType(xpath(baseProductNameList), "Name");
		click(xpath(baseProductEdit));
		Thread.sleep(3000);
		if(getValue(xpath(baseProdTypeField))!="Report") {
			selectOption(xpath(baseProdTypeField), "27");
		}
		if(getValue(xpath(baseProdReportSourceField))!="Veda") {
			selectOption(xpath(baseProdReportSourceField), "49");
		}
		if(getValue(xpath(baseProdReportTypeField))!="IDMatrix") {
			selectOption(xpath(baseProdReportTypeField), "IDMatrix");
		}
		click(xpath(baseProdSaveBtn));
		Thread.sleep(2000);
		Assert.assertEquals(getValue(xpath(baseProdTypeField)), "27");
		Assert.assertEquals(getValue(xpath(baseProdReportSourceField)), "49");
		Assert.assertEquals(getValue(xpath(baseProdReportTypeField)), "IDMatrix");
		
	}
	
	public void configCreditScore() throws Exception {
		actionType(xpath(baseProductNameList), "Name");
		click(xpath(baseProductEdit));
		Thread.sleep(3000);
		if(getValue(xpath(baseProdTypeField))!="Report") {
			selectOption(xpath(baseProdTypeField), "27");
		}
		if(getValue(xpath(baseProdReportSourceField))!="Veda") {
			selectOption(xpath(baseProdReportSourceField), "49");
		}
		if(getValue(xpath(baseProdReportTypeField))!="Credit") {
			selectOption(xpath(baseProdReportTypeField), "Credit");
		}
		click(xpath(baseProdSaveBtn));
		Thread.sleep(2000);
		Assert.assertEquals(getValue(xpath(baseProdTypeField)), "27");
		Assert.assertEquals(getValue(xpath(baseProdReportSourceField)), "49");
		Assert.assertEquals(getValue(xpath(baseProdReportTypeField)), "Credit");
		
	}
}
	



