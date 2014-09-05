package hub.utilities;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import hub.library.FunctionReference;

public class AdminPromotionCodeUtil extends FunctionReference{
String [] input;
	public AdminPromotionCodeUtil() {
	}
	public AdminPromotionCodeUtil(String[] i) {
		input = i;
	}
	
	public void navigateToPromoListPage() throws Exception{
		Thread.sleep(1000);
		actionType(xpath(productsTab), "Promotions");
		click(xpath(adminPromotionsTab));
		waitForElementPresent(xpath(adminPromotionsSearchTextField));
		
	}
	
	public void checkPromotionCodeForm(){
		try {
			click(xpath(adminPromotionListAddNewText));
			pass("Successfully navaigate to Promotion Code Add New page");
			waitForElementPresent(xpath(adminPromotionNew_HeaderText));
			
			checkPromotionNewHeader();
			checkPromotionNewButtons();
			checkHorizontalLines();
			
			checkAddNewFormLabels();
			testMandatoryFieldsValidaiton();
			checkAddNewFormFields();
			
			fieldInputTest();
		} catch (Exception e) {
			fail("Fail to execute testing");
			e.printStackTrace();
		}
		
	}
	
	public void checkPromotionListHeader() throws Exception {
		Thread.sleep(1000);
		resultcount = 0;
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHeaderText)));
			pass("Admin Promotion Code : Header Text is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not present");
			resultcount++;
		}
		
		try {
			Assert.assertEquals("PROMOTIONS", getText(xpath(adminPromotionListHeaderText)));
			pass("Admin Promotion Code : Header Text is equal to PROMOTIONS");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not equal to PROMOTIONS");
			resultcount++;
		}

//		Actions action = new Actions(webdriver); action.moveToElement();
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListAddNewText)));
			pass("Admin Promotion Code : Header Add New Link is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Add New Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHelpLink)));
			pass("Admin Promotion Code : Header Help Link is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHelpIcon)));
			pass("Admin Promotion Code : Header Help icon is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help icon is not present");
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail("Fail on testing of header container");
		} else {
			pass("Successful on testing of header container");
		}
		
	}
	
	public void checkHorizontalLines(){
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HorizontalLine1)));
			pass("Admin Promotion Code : Horizontal Line 1 is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Horizontal Line 1  is not present");
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HorizontalLine2)));
			pass("Admin Promotion Code : Horizontal Line 2 is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Horizontal Line 2 is not present");
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HorizontalLine3)));
			pass("Admin Promotion Code : Horizontal Line 3 is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Horizontal Line 3 is not present");
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HorizontalLine4)));
			pass("Admin Promotion Code : Horizontal Line 4 is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Horizontal Line 4 is not present");
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HorizontalLine5)));
			pass("Admin Promotion Code : Horizontal Line 5 is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Horizontal Line 5 is not present");
		}
	}
	
	public void checkAttributes() throws Exception{
		resultcount = 0;
		type(xpath(adminPromotionsSearchTextField),input[1]);
		click(xpath(adminPromotionsSearchButton));
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchTextField)));
			pass("Admin Promotion Code : Search input is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Search input is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchCloseButton)));
			pass("Admin Promotion Code : Close Button is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Close Button is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchButton)));
			pass("Admin Promotion Code : Search Button is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Search Button is not present");
			takeScreenshot();
			resultcount++;
		}
			
		if (resultcount != 0) {
			fail("Fail on testing of search container");
		} else {
			pass("Successful on testing of search container");
		}
	}
	
	public void adminLogin() throws Exception {
		resultcount = 0;	
		driver.navigate().to("http://localhost:37080/ttsvr/n/myrp-872");
		waitForElementPresent(xpath(adminLoginUsername));			
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginUsername)));
			pass("Login Username is present");
		} catch (AssertionError e) {
			fail("Login Username is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginPassword)));
			pass("Login Password is present");
		} catch (AssertionError e) {
			fail("Login Password is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginButton)));
			pass("Login button is present");
		} catch (AssertionError e) {
			fail("Login button is not present");
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(adminLoginUsername), "robert.velasco@twistresources.com");
		type(xpath(adminLoginPassword), "123456");
		click(xpath(adminLoginButton));
		waitForElementPresent(xpath(adminLinkLogout));
		
		if (resultcount != 0) {
			fail("Fail to login");
		} else {
			pass("Login successful");
		}
	}
	
	public void checkAddNewFormLabels(){
		resultcount = 0;
		String xpaths[] = {adminPromotionNew_Name,adminPromotionNew_Description,adminPromotionNew_CodePrefix, adminPromotionNew_CodeNumber, adminPromotionNew_Multiplier, adminPromotionNew_UserLimit, 
				adminPromotionNew_StartDate, adminPromotionNew_FinishDate, adminPromotionNew_Status, adminPromotionNew_Type, adminPromotionNew_TypeValue, adminPromotionNew_Channel, adminPromotionNew_BaseProduct, 
				adminPromotionNew_WeekDays, adminPromotionNew_Region};
		
		String labels[] = {"* Name:","* Description:","* Code Prefix:", "* Code Number:", "* Code Multiplier:", "* User Limit:", "* Start Date:", "* End Date:", "* Status:", 
				"* Type:", "* Type Value:", "* Channel:", "* Base Product:", "* Weekdays:", "* Regions:"};

		for (int i = 0; i < xpaths.length; i++) {
			try {
				Assert.assertTrue(isElementPresent(xpath(xpaths[i])));
				pass("Admin Promotion Code Add New: " + labels[i] + " label is present");
			} catch (AssertionError e) {
				fail("Admin Promotion Code Add New: " + labels[i] + " label is not present");
				resultcount++;
			}
			
			try {
				Assert.assertEquals(labels[i], getText(xpath(xpaths[i])));
				pass("Admin Promotion Code Add New: Label is equal to '" + labels[i] + "'");
			} catch (AssertionError e) {
				fail("Admin Promotion Code Add New: Label is not equal to '" + labels[i] + "'");
				resultcount++;
			}
		}

		if (resultcount != 0) {
			fail("Fail on testing of Promotion Code Form Labels");
		} else {
			pass("Successful on testing of Promotion Code Form Labels");
		}
		
	}
	
	public void testMandatoryFieldsValidaiton() throws InterruptedException, IOException{
		click(xpath(adminPromotionNew_Save));
		Thread.sleep(1000);
		waitForElementPresent(xpath(adminPromotionNew_HeaderText));
		
		String xpaths[] = {adminPromotionNew_Input_Name, adminPromotionNew_Input_Description, adminPromotionNew_Input_CodePrefix, adminPromotionNew_Input_CodeNumber, 
				adminPromotionNew_Input_chk_Multiplier, adminPromotionNew_Input_txtbox_Multiplier, adminPromotionNew_Input_chk_UserLimit, adminPromotionNew_Input_txtbox_UserLimit, 
				adminPromotionNew_Input_StartDate, adminPromotionNew_Input_FinishDate, adminPromotionNew_Input_Status, adminPromotionNew_Input_Type, adminPromotionNew_Input_TypeValue, 
				adminPromotionNew_Input_Channel, adminPromotionNew_Input_BaseProduct, adminPromotionNew_Input_chk_WeekDays_Sun, adminPromotionNew_Input_chk_WeekDays_Mon, 
				adminPromotionNew_Input_chk_WeekDays_Tue, adminPromotionNew_Input_chk_WeekDays_Wed, adminPromotionNew_Input_chk_WeekDays_Thu, adminPromotionNew_Input_chk_WeekDays_Fri, 
				adminPromotionNew_Input_chk_WeekDays_Sat, adminPromotionNew_Input_chk_Region_Act, adminPromotionNew_Input_chk_Region_Nt, adminPromotionNew_Input_chk_Region_Nsw, 
				adminPromotionNew_Input_chk_Region_Qld, adminPromotionNew_Input_chk_Region_Sa, adminPromotionNew_Input_chk_Region_Tas, adminPromotionNew_Input_chk_Region_Vic, 
				adminPromotionNew_Input_chk_Region_Wa};
		
		String errorMsgXpath[] = {"Name field should not be empty.@@textbox", "Description field should not be empty.@@textbox", "Code Prefix field should not be empty.@@textbox", "Code Number field should not be empty.@@textbox", 
				"Code Multiplier field should not be empty.@@checkbox", "Code Multiplier field should not be empty.@@textbox", "User Limit field should not be empty.@@checkbox", "User Limit field should not be empty.@@textbox", 
				"Start Date field should not be empty.@@textbox", "End Date field should not be empty.@@textbox", "dp@@dropdown", "dp@@dropdown", "Type Value field should not be empty.@@textbox", 
				"dp@@dropdown", "Please select atleast one.@@select", "Please select atleast one.@@checkboxdays", "Please select atleast one.@@checkboxdays", 
				"Please select atleast one.@@checkboxdays", "Please select atleast one.@@checkboxdays", "Please select atleast one.@@checkboxdays", "Please select atleast one.@@checkboxdays", 
				"Please select atleast one.@@checkboxdays", "Please select atleast one.@@checkboxregion", "Please select atleast one.@@checkboxregion", "Please select atleast one.@@checkboxregion", 
				"Please select atleast one.@@checkboxregion", "Please select atleast one.@@checkboxregion", "Please select atleast one.@@checkboxregion", "Please select atleast one.@@checkboxregion", 
				"Please select atleast one.@@checkboxregion"};
		
		String inputFields[] = {"Name", "Description", "Code Prefix", "Code Number", "Checkbox Multiplier", "Textbox Multiplier", "Checkbox User Limit", "Textbox User Limit", 
				"Start Date", "FinishDate", "Status", "Type", "Type Value", "Channel", "BaseProduct", "Checkbox WeekDays Sunday", "Checkbox WeekDays Monday", 
				"Checkbox WeekDays Tuesday", "Checkbox WeekDays Wednesday", "Checkbox WeekDays Thursday", "Checkbox WeekDays Friday", 
				"Checkbox WeekDays Saturday", "Checkbox Region ACT", "Checkbox Region NT", "Checkbox Region NSW", "Checkbox Region QLD", "Checkbox Region SA", 
				"Checkbox Region TAS", "Checkbox Region VIC", "Checkbox Region WA"};
		
		boolean isDaysErrMsgShouldDisplay = true;
		boolean isRegionErrMsgShouldDisplay = true;
		String daysErrMsg = "";
		String regionErrMsg = "";
		
		
		for (int i = 0; i < xpaths.length; i++) {
			String[] errMsg = errorMsgXpath[i].split("@@");
			String fieldType = errMsg[1].trim(); 
			
			By byXpath = xpath(xpaths[i]);
			if (fieldType.equalsIgnoreCase("checkboxdays")) {

				boolean isChecked = Boolean.parseBoolean(getValue(byXpath, "checked"));
				
				if (isChecked) {
					isDaysErrMsgShouldDisplay = false;
				} else {
					daysErrMsg = getText(xpath(adminPromotionNew_WeekdaysErrMsg));
				}
				
			} else if (fieldType.equalsIgnoreCase("checkboxregion")) { 
				
				boolean isChecked = Boolean.parseBoolean(getValue(byXpath, "checked"));
				
				if (isChecked) {
					isRegionErrMsgShouldDisplay = false;
				} else {
					regionErrMsg = getText(xpath(adminPromotionNew_RegionErrMsg));
				}
			
			} else if (fieldType.equalsIgnoreCase("textbox")) {
				String value = driver.findElement(By.xpath(xpaths[i])).getText();
				
				if (value.equals("")) {

//					String label = getText(xpath("(//*[@id='errorMessage']/label)["+ (i) +"]"));
					String errorMsgValue = getText(xpath("(//*[@id='errorMessage'])["+ (i+1) +"]"));
					
					if (errMsg[0].equals("User Limit field should not be empty.")) {
						errorMsgValue = getText(xpath(adminPromotionNew_UserLimitErrMsg));
					} else if (errMsg[0].equals("Code Multiplier field should not be empty.")) {
						errorMsgValue = getText(xpath(adminPromotionNew_CodeMultiErrMsg));
					}
					
					if (errorMsgValue.equals(errMsg[0])) {
						pass("Pass to display correct validation message in input fields "+inputFields[i]);
					} else {
						fail("Fail to display correct validation message in input fields "+inputFields[i]);
					}
				}
			} else if (fieldType.equalsIgnoreCase("select")) {
				boolean hasSelected = Boolean.parseBoolean(getValue(byXpath, "checked"));
				if (!hasSelected) {
					String err = getText(xpath(adminPromotionNew_BaseProdErrMsg));
					
					if (err.equals(errMsg[0])) {
						pass("Pass to display correct validation message in input fields "+inputFields[i]);
					} else {
						fail("Fail to display correct validation message in input fields "+inputFields[i]);
					}
					
				} 
			}

		}
		
		if (isDaysErrMsgShouldDisplay) {
			if (daysErrMsg.equals("Please select atleast one.")) {
				pass("Pass to display correct validation message in input fields Weekdays");
			} else {
				fail("Fail to display correct validation message in input fields Weekdays");
			}
		}
		
		if (isRegionErrMsgShouldDisplay) {
			if (regionErrMsg.equals("Please select atleast one.")) {
				pass("Pass to display correct validation message in input fields Region");
			} else {
				fail("Fail to display correct validation message in input fields Region");
			}
		}
	}
	
	public void checkAddNewFormFields() throws InterruptedException{
		resultcount = 0;
		Thread.sleep(1000);
		String xpaths[] = {adminPromotionNew_Input_Name, adminPromotionNew_Input_Description, adminPromotionNew_Input_CodePrefix, adminPromotionNew_Input_CodeNumber, 
				adminPromotionNew_Input_chk_Multiplier, adminPromotionNew_Input_txtbox_Multiplier, adminPromotionNew_Input_chk_UserLimit, adminPromotionNew_Input_txtbox_UserLimit, 
				adminPromotionNew_Input_StartDate, adminPromotionNew_Input_FinishDate, adminPromotionNew_Input_Status, adminPromotionNew_Input_Type, adminPromotionNew_Input_TypeValue, 
				adminPromotionNew_Input_Channel, adminPromotionNew_Input_BaseProduct, adminPromotionNew_Input_chk_WeekDays_Sun, adminPromotionNew_Input_chk_WeekDays_Mon, 
				adminPromotionNew_Input_chk_WeekDays_Tue, adminPromotionNew_Input_chk_WeekDays_Wed, adminPromotionNew_Input_chk_WeekDays_Thu, adminPromotionNew_Input_chk_WeekDays_Fri, 
				adminPromotionNew_Input_chk_WeekDays_Sat, adminPromotionNew_Input_chk_Region_Act, adminPromotionNew_Input_chk_Region_Nt, adminPromotionNew_Input_chk_Region_Nsw, 
				adminPromotionNew_Input_chk_Region_Qld, adminPromotionNew_Input_chk_Region_Sa, adminPromotionNew_Input_chk_Region_Tas, adminPromotionNew_Input_chk_Region_Vic, 
				adminPromotionNew_Input_chk_Region_Wa};
		
		String inputFields[] = {"Name", "Description", "Code Prefix", "Code Number", "Checkbox Multiplier", "Textbox Multiplier", "Checkbox User Limit", "Textbox User Limit", 
				"Start Date", "FinishDate", "Status", "Type", "Type Value", "Channel", "BaseProduct", "Checkbox WeekDays Sunday", "Checkbox WeekDays Monday", 
				"Checkbox WeekDays Tuesday", "Checkbox WeekDays Wednesday", "Checkbox WeekDays Thursday", "Checkbox WeekDays Friday", 
				"Checkbox WeekDays Saturday", "Checkbox Region ACT", "Checkbox Region NT", "Checkbox Region NSW", "Checkbox Region QLD", "Checkbox Region SA", 
				"Checkbox Region TAS", "Checkbox Region VIC", "Checkbox Region WA"};
		
		for (int i = 0; i < xpaths.length; i++) {
			try {
				Assert.assertTrue(isElementPresent(xpath(xpaths[i])));
				pass("Admin Promotion Code Add New: Input field " + inputFields[i] + " is present");
			} catch (AssertionError e) {
				fail("Admin Promotion Code Add New: Input field " + inputFields[i] + " is not present");
				resultcount++;
			}
		}
		
		if (resultcount != 0) {
			fail("Fail on testing of Promotion Code Form Input Fields");
		} else {
			pass("Successful on testing of Promotion Code Form Input Fields");
		}
		
	}
	
	public void fieldInputTest(){
		//This String array is properly arranged base on the Test Data. You may encounter problem once this array is modify or re-arrange.
		String xpaths[] = {adminPromotionNew_Input_Name, adminPromotionNew_Input_Description, adminPromotionNew_Input_CodePrefix, adminPromotionNew_Input_CodeNumber, 
				adminPromotionNew_Input_chk_Multiplier, adminPromotionNew_Input_txtbox_Multiplier, adminPromotionNew_Input_chk_UserLimit, adminPromotionNew_Input_txtbox_UserLimit, 
				adminPromotionNew_Input_StartDate, adminPromotionNew_Input_FinishDate, adminPromotionNew_Input_Status, adminPromotionNew_Input_Type, adminPromotionNew_Input_TypeValue, 
				adminPromotionNew_Input_Channel, adminPromotionNew_Input_BaseProduct, adminPromotionNew_Input_chk_WeekDays_Sun, adminPromotionNew_Input_chk_WeekDays_Mon, 
				adminPromotionNew_Input_chk_WeekDays_Tue, adminPromotionNew_Input_chk_WeekDays_Wed, adminPromotionNew_Input_chk_WeekDays_Thu, adminPromotionNew_Input_chk_WeekDays_Fri, 
				adminPromotionNew_Input_chk_WeekDays_Sat, adminPromotionNew_Input_chk_Region_Act, adminPromotionNew_Input_chk_Region_Nt, adminPromotionNew_Input_chk_Region_Nsw, 
				adminPromotionNew_Input_chk_Region_Qld, adminPromotionNew_Input_chk_Region_Sa, adminPromotionNew_Input_chk_Region_Tas, adminPromotionNew_Input_chk_Region_Vic, 
				adminPromotionNew_Input_chk_Region_Wa};
		
		String inputFields[] = {"Name", "Description", "Code Prefix", "Code Number", "Checkbox Multiplier", "Multiplier Field", "Checkbox User Limit", "User Limit Field", 
				"Start Date", "FinishDate", "Status", "Type", "Type Value", "Channel", "BaseProduct", "Checkbox WeekDays Sunday", "Checkbox WeekDays Monday", 
				"Checkbox WeekDays Tuesday", "Checkbox WeekDays Wednesday", "Checkbox WeekDays Thursday", "Checkbox WeekDays Friday", 
				"Checkbox WeekDays Saturday", "Checkbox Region ACT", "Checkbox Region NT", "Checkbox Region NSW", "Checkbox Region QLD", "Checkbox Region SA", 
				"Checkbox Region TAS", "Checkbox Region VIC", "Checkbox Region WA"};
		//Test Data starts at column 4 of adminPromotion.xls
		int col= 4;
		boolean isHasError = false;
		
		for (int i = 0; i < xpaths.length; i++) {
			//Get field type
			String fieldType = "";
			if (input[col] != null) {
				fieldType = input[col].trim();
			}
			//Add 1 to move to field value
			col = col + 1;
			
			String value = "";
			if (input[col] != null) {
				value = input[col].trim();
			}
			
			try {
				if (fieldType.equalsIgnoreCase("textbox")) {
					
					type(xpath(xpaths[i]), value);
	
				} else if (fieldType.equalsIgnoreCase("checkbox")) {
					click(xpath(xpaths[i]));
//						Assert.assertFalse(isElementVisible(xpath(baseProdConstructionLabel)));
				} else if (fieldType.equalsIgnoreCase("calendar")) {
					click(xpath(xpaths[i]));
				} else if (fieldType.equalsIgnoreCase("dropdown")) {
					selectDropdownOption(xpath(xpaths[i]), value);
				} else if (fieldType.equalsIgnoreCase("list")) {
					click(xpath(xpaths[i]));
				} else if (fieldType.equalsIgnoreCase("numeric")) {
					//test if numeric field is accepting character value
					boolean isPass = testNumericField(i, xpaths, inputFields, value);
					if (isPass) {
						type(xpath(xpaths[i]), value);
					}
					
				}
			} catch (Exception e) {
				fail("Fail to enter input in " + inputFields[i]);
				isHasError = true;
			}
			//Add another 1 to prepare for the next field
			col = col + 1;
			pass("Success in filling of " + inputFields[i]);
		}
			
		if (isHasError) {
			fail("Unable to complete process due to error");
		} else {
			pass("COMPLETE!!!");
		}
		
		try {
			click(xpath(adminPromotionNew_Save));
			checkFlashMessage();
		} catch (InterruptedException | IOException e) {
			fail("Error on clicking save button");
		}
	
	}
	
	public void checkFlashMessage() {
		try {
			waitForElementPresent(xpath(adminLinkLogout));
			pass("Flash message display");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail("Flash message did not display");
		}
		
		Assert.assertTrue(isElementPresent(xpath(adminPromotion_FlashMessage)));
		pass("Flash message is present");
	}
	
	 public void selectDropdownOption(By by, String value) {
	       Select dropdown = new Select(driver.findElement(by));
	       dropdown.selectByVisibleText(value);
	   }
	
	public boolean testNumericField(int index, String[] xpaths, String[] inputFields, String val) throws Exception {
		boolean isPass = true;
		type(xpath(xpaths[index]), "test");
		
		String value = driver.findElement(By.xpath(xpaths[index])).getText();
		
		if (value.equals("")) {
			pass(inputFields[index] + " is not accepting character values");
			isPass = true;
		} else {
			fail(inputFields[index] + " is accepting character values");
			isPass = false;
		}
		
		type(xpath(xpaths[index]), "<>'*");
		String value2 = driver.findElement(By.xpath(xpaths[index])).getText();
		
		if (value2.equals("")) {
			pass(inputFields[index] + " is not accepting character values");
			isPass = true;
		} else {
			fail(inputFields[index] + " is accepting character values");
			isPass = false;
		}
		
		//This is to test the maximum input length of a field 
		String [] strArr = val.split("_");
		int maxLength = 0;
		
		if (strArr[0] != null && strArr[0].equals("")) {
			maxLength = Integer.parseInt(strArr[0].trim());
		}
		
		String testInput = "";
		for (int i = 0; i < maxLength + 1; i++) {
			testInput += String.valueOf(i);
		}
		
		type(xpath(xpaths[index]), testInput);
		String str = driver.findElement(By.xpath(xpaths[index])).getText();
		//Final test
		if (str.length() > maxLength) {
			fail(inputFields[index] + " is accepting more than " + maxLength + " digits");
			isPass = false;
		} else {
			pass(inputFields[index] + " is not accepting more than " + maxLength + " digits");
			isPass = true;
		}
		
		return isPass;
	}
	
	public void checkPromotionNewHeader() throws Exception{
		Thread.sleep(1000);
		resultcount = 0;
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HeaderText)));
			pass("Admin Promotion Code : Header Text is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not present");
			resultcount++;
		}
		
		try {
			Assert.assertEquals("PROMOTIONS", getText(xpath(adminPromotionNew_HeaderText)));
			pass("Admin Promotion Code : Header Text is equal to PROMOTIONS");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not equal to PROMOTIONS");
			resultcount++;
		}

		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_ShowHistoryText)));
			pass("Admin Promotion Code : Header Show History Link is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Show History Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HelpLink)));
			pass("Admin Promotion Code : Header Help Link is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HelpIcon)));
			pass("Admin Promotion Code : Header Help icon is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help icon is not present");
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail("Fail on testing of Promotion Code Add New header container");
		} else {
			pass("Successful on testing of Promotion Code Add New header container");
		}
	}

	public void checkPromotionNewButtons() throws Exception{
		resultcount = 0;
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_Cancel)));
			pass("Admin Promotion Code : Cancel Button is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Cancel Button is not present");
			resultcount++;
		}

		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_Save)));
			pass("Admin Promotion Code : Save Button is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Save Button is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_Back)));
			pass("Admin Promotion Code : Back Button is present");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Back Button is not present");
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail("Fail on testing of Buttons");
		} else {
			pass("Successful on testing of Buttons");
		}
	}
	
	public void testSearch() throws Exception {
       String str = "";
       type(xpath(adminPromotionsSearchTextField),input[1]);
       click(xpath(adminPromotionsSearchButton));
       waitForElementPresent(xpath(adminPromotionsSearchTextField));
       try {
           Assert.assertTrue(isElementPresent(xpath(result)));
           str=driver.findElement(By.xpath(result)).getText();
           if (str.equalsIgnoreCase(input[1]))
           {
               pass("Successful on searching");
           } else {
               fail("Result not match");
               takeScreenshot();
               resultcount++;
           }
       } catch (AssertionError e) {
           if (input[2].equalsIgnoreCase("SUCCESS"))
           {
               pass("No result found");
           } else {
               fail("Should display no result");
           }
       }
	}
	
}
