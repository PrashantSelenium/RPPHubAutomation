package hub.utilities.EndtoEndUtil;

import static org.openqa.selenium.By.xpath;

import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;
import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.SettingsFile;
import atu.testrecorder.ATUTestRecorder;

import com.thoughtworks.selenium.Selenium;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.asprise.util.ocr.OCR;
import com.aspose.ocr.*;

public class EndtoEndUtil extends FunctionReference{
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	private String[] input = null;
	private String testCase = "";
	public Selenium selenium;
	
	public EndtoEndUtil(String[] i) {
		input = i;
	}
	
	public EndtoEndUtil() {
	}
	
	public int NewUserRegistration() throws Exception{
		driver.navigate().to(input[1]);	
		resultcount = 0;
		waitForElementPresent(xpath(registerButton));
		
		try{ 
			Assert.assertTrue(isElementPresent(xpath(registerButton)));
			click(xpath(registerButton));
			waitForElementPresent(xpath(signupCaptchaImg));
			
			}
			catch(AssertionError e) {
				fail(input[0] + " - Login - Register Button Invalid Display");
				resultcount++;
				}
								
		try{ 
			Assert.assertTrue(isElementPresent(xpath(signupCaptchaImg)));
			}
			catch(AssertionError e) {
				fail(input[0] + " - Not Redirected in Register Page");
				resultcount++;
				}	
		OcrEngine ocr = new OcrEngine();
		
		String imgUrl = driver.findElement(xpath(signupCaptchaImg)).getAttribute("src");
//		String captcha = driver.manage().getCookieNamed("myrp_cptr").getValue();
//		System.out.println(captcha);
//		URL url = new URL(imgUrl);
//		 BufferedImage image = ImageIO.read(url);
//		 ocr.setImage(ImageStream.fromFile(imgUrl));
//		 String asd = ocr.getText().toString();
//		 System.out.println(asd);
//		 String s = new OCR().recognizeCharacters(image);
//		 System.out.println("Text From Image : \n"+ s);
//		 System.out.println("Length of total text : \n"+ s.length());
//		 String imageText  = new OCR().recognizeCharacters((RenderedImage) image);
//		 System.out.println("Text From Image : \n"+ imageText);
//		 System.out.println("Length of total text : \n"+ imageText.length());

//			type(xpath(firstNameReg), input[5]);
//			type(xpath(lastNameReg), input[6]);
//			type(xpath(staffIDReg), input[7]);
//			type(xpath(branchIDReg), input[8]);
//			type(xpath(bodyIDReg), input[9]);
//			driver.findElement(By.id("userRoleReg")).sendKeys(Keys.DOWN);
//			driver.findElement(By.id("userRoleReg")).sendKeys(Keys.DOWN);
//			driver.findElement(By.id("userRoleReg")).sendKeys(Keys.ENTER);
//			type(xpath(emailReg), input[10]);
//			type(xpath(confirmEmailReg), input[11]);
//			type(xpath(mobileReg), input[12]);
//			type(xpath(phoneReg), input[13]);
//			type(xpath(usernameReg), input[14]);
//			type(xpath(passwordReg), input[15]);
//			type(xpath(confirmPasswordReg), input[16]);
//			type(xpath(securityQuestionReg), input[17]);
//			type(xpath(answerReg), input[18]);
//			click(xpath(agreementReg));
//			Thread.sleep(5000);
			
//		try{
//		    waitForElementPresent(xpath(userPropertySearch));
//		    Assert.assertTrue(isElementPresent(xpath(welcomeSignIn)));	    	
//		    }
//		    catch(AssertionError e){
//		    	fail(input[0] + " - Hello User is not properly displayed");
//		    	resultcount++;
//		    	}

	return resultcount;
	}
	
	public void endToEndLogin () throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = "RP Property Hub Login: " + input[0];

		driver.navigate().to(input[1]);	
//		driver.navigate().to(input[1].replaceAll("stage", "dev"));	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
 		if(ready.equalsIgnoreCase("complete")){
			waitForElementPresent(xpath(userLoginUsername));
			try {
				Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
				Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
				Assert.assertTrue(isElementPresent(xpath(loginButton)));
			} catch (AssertionError e) {
				resultcount++;
			}
			
			String username = "";
			String password = "";
			
			username = input[2];
			password = input[3];

			type(xpath(userLoginUsername), username);
			type(xpath(userLoginPassword), password);
			click(xpath(loginButton));
			Thread.sleep(3000);
//			driver.navigate().to("https://dev-cbalender.rppropertyhub.com/PropertySearch");
			if(!input[5].equalsIgnoreCase("DEEP")){
				waitForElementPresent(xpath(userPropertySearch));
				
				try {
					Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
					ATUReports.add("Login", "Username and Password","Proceed to property search","PASSED",true);
				} catch (AssertionError e) {
					ATUReports.add("Login","Username and Password","Proceed to property search","FAILED", true);
					resultcount++;
				}
			}
			
			
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
			
		}
		
	}
	
	public void endToEndCoverFlow () throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = "RP Property Hub Login: " + input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			if (input[5].equalsIgnoreCase("isCoverflow")) {
				waitForElementPresent(xpath(coverFlow));
				
				try {
					Assert.assertTrue(isElementPresent(xpath(coverFlow)));
				} catch (AssertionError e) {
					fail("Coverflow");
					resultcount++;
				}
				
			} else {
				try {
					Assert.assertFalse(isElementPresent(xpath(coverFlow)));
				} catch (AssertionError e) {
					fail("Coverflow");
					resultcount++;
				}
			}
			
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
		
	}
	
	public void endToEndSLAS() throws Exception {
		resultcount = 0;	
		testCase = "RP Property Hub Single Line Address Search: " + input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			waitForElementPresent(xpath(userPropertySearch));
			try {
				Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
			} catch (AssertionError e) {
				fail("SLAS field");
				
				resultcount++;
			}
			
			try {
				Assert.assertEquals("Enter your property address or street name here.", getValue(xpath(userPropertySearch)));
			} catch (AssertionError e) {
				fail("SLAS placeholder text");
				
				resultcount++;
			}
			
			type(xpath(userPropertySearch), input[10]);		
			click(xpath(userSearchButton));
			
			if (resultcount != 0) {
					fail(testCase);
					ATUReports.add("FAILED", true);
				} else {
					pass(testCase);
				}
//			Thread.sleep(3000);
		}
	}
	
	public void startNewTransaction() throws Exception {	
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		if(ready.equalsIgnoreCase("complete")){
			if (isElementPresent(xpath(userPendingTransactionMessage))){
		    	System.out.println("User has Pending transactions!");
				resultcount = 0;	
				testCase = "RP Property Hub Start new transaction: " + input[0];
		    	
		    	try {
					Assert.assertTrue(isElementPresent(By.linkText("Start a new transaction for this property")));
				} catch (AssertionError e) {
					fail("Start new transaction");
					resultcount++;
				}
		        click(By.linkText("Start a new transaction for this property"));      
		    
		    if (resultcount != 0) {
				fail(testCase);
				ATUReports.add("FAILED", true);
			} else {
				pass(testCase);
			}
		    
		    }
//	        Thread.sleep(3000);	
		}
	}
	
	public void proceedProductSelection() throws Exception {
		resultcount = 0;	
		testCase = "RP Property Hub Proceed to product selection: " + input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		Thread.sleep(2000);
		if(ready.equalsIgnoreCase("complete")){
			waitForElementPresent(xpath(userProceedToProductSelection),30);
			
			try {
				Assert.assertTrue(isElementPresent(xpath(userProceedToProductSelection)));
				click(xpath(userProceedToProductSelection));
			} catch (Exception e) {
				fail("Proceed to product selection");
				resultcount++;
			}
			
			
		    if (resultcount != 0) {
		    	ATUReports.add("FAILED", true);
				fail(testCase);
			} else {
				pass(testCase);
			}
			Thread.sleep(2000);
		}
	
	}
	
	public void regressionProductTab() throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
		
		if(ready.equalsIgnoreCase("complete")){
			waitForElementPresent(xpath(productTabsMenu));	
			String productTab = input[11];
				click(xpath(productTab));		
			Thread.sleep(3000);
		}
		
		
	}
	
	public void smokeOriginator() throws Exception{	
		resultcount = 0;	
		testCase = "RP Property Hub Originator details: " + input[0];
		waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			waitForElementPresent(xpath(userOriginatorDetails));
			try {
				Assert.assertTrue(isElementPresent(xpath(userOriginatorDetails)));
			} catch (AssertionError e) {
				fail("Originator Details modal");
				ATUReports.add("FAILED", true);
				resultcount++;
			}
			String oevpp = input[13];
			
			if(isElementPresent(xpath(userOEVPP))) {
			waitForElementPresent(xpath(userOEVPP));	
			type(xpath(userOEVPP), oevpp);
			}
			
			if (input[28].equalsIgnoreCase("Costing")){
				if(isElementPresent(xpath(costingReport))) {
					waitForElementPresent(xpath(costingReport));
					click(xpath(costingReport));
				}
				if(isElementPresent(xpath(loanApplication))) {
					waitForElementPresent(xpath(loanApplication));
					click(xpath(loanApplication));
				}
			} else if(input[28].equalsIgnoreCase("Construction")){
				if(isElementPresent(xpath(construction))) {
					waitForElementPresent(xpath(construction));
					click(xpath(construction));
				}
				if(isElementPresent(xpath(userNoneApply))) {
					waitForElementPresent(xpath(userNoneApply));
					click(xpath(userNoneApply));
				}
				if(isElementPresent(xpath(userAVMAck))) {
					waitForElementPresent(xpath(userAVMAck));
					click(xpath(userAVMAck));
				}
			} else if(input[28].equalsIgnoreCase("Company Title")){
				if(isElementPresent(xpath(companyTitle))) {
					waitForElementPresent(xpath(companyTitle));
					click(xpath(companyTitle));
				}
				
				if(isElementPresent(xpath(loanApplication))) {
					waitForElementPresent(xpath(loanApplication));
					click(xpath(loanApplication));
				}
					
			} else if(input[28].equalsIgnoreCase("leasehold")){
				if(isElementPresent(xpath(leasehold))) {
					waitForElementPresent(xpath(leasehold));
					click(xpath(leasehold));
				}
				
				if(isElementPresent(xpath(loanApplication))) {
					waitForElementPresent(xpath(loanApplication));
					click(xpath(loanApplication));
				}
					
			} else {
				if(isElementPresent(xpath(userNoneApply))) {
					waitForElementPresent(xpath(userNoneApply));
					click(xpath(userNoneApply));
				}
				if(isElementPresent(xpath(userAVMAck))) {
					waitForElementPresent(xpath(userAVMAck));
					click(xpath(userAVMAck));
				}
			}
			
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		
//			Thread.sleep(6000);	
		}
	
				
			
	}
	
	public void smokeOriginatorProceed() throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		Thread.sleep(3000);
		if(ready.equalsIgnoreCase("complete")){
			waitForElementPresent(xpath(userOriginatorDetails));
			click(xpath(userOriginatorProceed));
			waitForElementPresent(xpath(userProductSelectionList));	
			waitForElementPresent(xpath(userProductSelectionListOverview));	
		}
		
		
	}
	
	public void regressionAddProduct() throws Exception {
		Thread.sleep(6500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
		
		if(ready.equalsIgnoreCase("complete")){
			resultcount = 0;	
			testCase = "RP Property Hub Add to cart: " + input[0];
					
			String addToCart = input[14];
			waitForElementPresent(xpath(addToCart));
			waitForElementVisible(xpath(addToCart));
			try {
				Assert.assertEquals("Add to cart", getValue(xpath(addToCart)));
			} catch (AssertionError e) {
				fail("Add to cart");
				ATUReports.add("FAILED", true);
				resultcount++;
			}
			click(xpath(addToCart));
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
			
//			Thread.sleep(6000);
		}
	}
	
	public void testCartCountCheck() throws Exception{
		Thread.sleep(3000);
		waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
		waitForElementPresent(By.linkText(userProceedToInstructionDetails));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			resultcount = 0;	
			testCase = "RP Property Hub My Cart count: " + input[0];
				
			try {
				Assert.assertEquals("(1)", getText(xpath(userCart)));
			} catch (AssertionError e) {
				fail("Cart count");
				ATUReports.add("FAILED", true);
				resultcount++;
			}
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
		
	}
	
	public void testProceedInstructionDetails() throws Exception {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementPresent(By.linkText(userProceedToInstructionDetails));
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			click(By.linkText(userProceedToInstructionDetails));
		}
						
	}
	
	public void regressionInstructionDetailsForm() throws Exception {
 		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementPresent(By.linkText("Proceed to payment details"));
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
		if(ready.equalsIgnoreCase("complete")){
			resultcount = 0;	
			testCase = "RP Property Hub Instruction Details: " + input[0];

			waitForElementPresent(xpath(userInstructionDetails));
			
			try {
				Assert.assertTrue(isElementPresent(xpath(userInstructionDetails)));
			} catch (AssertionError e) {
				fail(testCase);
				ATUReports.add("FAILED", true);
				resultcount++;
			}
			
			if(isElementPresent(xpath(userCustomerFName))){
			type(xpath(userCustomerFName), input[16]);	
			}
			if(isElementPresent(xpath(userCustomerLName))){
			type(xpath(userCustomerLName), input[17]);	
			}
			if(isElementPresent(xpath(userCustomerContact))){
			type(xpath(userCustomerContact), input[18]);	
			}
			if(isElementPresent(xpath(userCustomerEmail))){
			type(xpath(userCustomerEmail), input[19]);	
			}
			if(isElementPresent(xpath(userSameAsCustomer))){
				waitForElementVisible(xpath(userSameAsCustomer));
			click(xpath(userSameAsCustomer));
			}
//			System.out.println();
//			if(isElementPresent(xpath(loanAmount))){
//				type(xpath(loanAmount), "1000");	
//			}
			
			if (input[28].equalsIgnoreCase("Costing")){
				if(isElementPresent(xpath(builderName))){
					waitForElementVisible(xpath(builderName));
					type(xpath(builderName),input[29]);
				}
				if(isElementPresent(xpath(builderContactNumber))){
					waitForElementVisible(xpath(builderContactNumber));
					type(xpath(builderContactNumber),input[30]);
				}
				if(isElementPresent(xpath(applicationId))){
					waitForElementVisible(xpath(applicationId));
					type(xpath(applicationId),input[31]);
				}
			}
			
			
			if (input[28].equalsIgnoreCase("Company Title")){

				if(isElementPresent(xpath(builderContactNumber))){
					waitForElementVisible(xpath(builderContactNumber));
					type(xpath(builderContactNumber),input[30]);
				}
				if(isElementPresent(xpath(applicationId))){
					waitForElementVisible(xpath(applicationId));
					type(xpath(applicationId),input[31]);
				}
			}
			
			if (input[28].equalsIgnoreCase("Construction")){
				if(isElementPresent(xpath(builderName))){
					waitForElementVisible(xpath(builderName));
					type(xpath(builderName),input[29]);
				}
				if(isElementPresent(xpath(builderContactNumber))){
					waitForElementVisible(xpath(builderContactNumber));
					type(xpath(builderContactNumber),input[30]);
				}
			}
			
			if(isElementPresent(xpath("//*[@id='4_1_value']"))){
				waitForElementVisible(xpath("//*[@id='4_1_value']"));
				if(isElementVisible(xpath("//*[@id='4_1_value']"))){
					type(xpath("//*[@id='4_1_value']"),input[33]);
				}
			}
			
			if(isElementPresent(xpath(applicationId))){
				waitForElementVisible(xpath(applicationId));
				if(isElementVisible(xpath(applicationId))){
					type(xpath(applicationId),input[31]);
				}
			}
			
			
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
		
	}
	
	public void testUserProceedToPayment() throws Exception {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			click(By.linkText(userProceedToPaymentDetails));
		}
		
		Thread.sleep(10000);
		
		regressionPaymentForm();
	}
	
	public void regressionPaymentForm() throws Exception{

			resultcount = 0;	
			testCase = "RP Property Hub Payment Details: " + input[0];
			waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
			waitForElementPresent(xpath(confirmPayment));
			
			try {
				Assert.assertEquals(input[20], getText(xpath(userPaymentItem)));
			} catch (AssertionError e) {
				fail("Item on Cart");
				ATUReports.add("FAILED", true);
				resultcount++;
			}
			
		    if(isElementPresent(xpath(userPaymentTermsConditions))){
				click(xpath(userPaymentTermsConditions));	
				}
			
			if(isElementPresent(xpath(userPaymentPassword))){
				type(xpath(userPaymentPassword), input[21]);	
				}
			
			if(isElementPresent(xpath(userPaymentBroker))){
				type(xpath(userPaymentBroker), input[22]);	
				}
			
			if(isElementPresent(xpath(userPaymentCreditName))){
				type(xpath(userPaymentCreditName), input[23]);	
				}
			if(isElementPresent(xpath(userPaymentCreditEmail))){
				type(xpath(userPaymentCreditEmail), input[24]);	
				}
			if(isElementPresent(xpath(userPaymentCreditNumber))){
				type(xpath(userPaymentCreditNumber), input[25]);	
				}
			if(isElementPresent(xpath(userPaymentCreditSecurity))){
				type(xpath(userPaymentCreditSecurity), input[26]);	
				}
			
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		
	}
	
	public void testConfirmPayment() throws Exception {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			click(xpath(userConfirmPayment));
		}
		
		Thread.sleep(6000);
		if(isElementPresent(By.xpath("//iframe[@id='card_payment_iframe']"))){
			try{
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='card_payment_iframe']")));
				isElementVisible(By.xpath("//*[@id='CardNumber']"));
				type(xpath("//*[@id='CardNumber']"), "4111111111111111");
				type(xpath("//*[@id='CardHolderName']"), "Twist");
				type(xpath("//*[@id='DateExpiry_1']"), "12");
				type(xpath("//*[@id='DateExpiry_2']"), "15");
				type(xpath("//*[@id='Cvc2']"), "1234");
				click(xpath("//*[@id='Add']"));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		Thread.sleep(6000);
		
	}
	
	public void testMortgageValuation() throws Exception {
//		Thread.sleep(3000);	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			if(isElementPresent(xpath(userMortgagePopup))) {
				resultcount = 0;	
				testCase = "RP Property Hub Mortgage Valuation Notification: " + input[0];
				
				waitForElementPresent(xpath(userMortgagePopup));
				try {
					Assert.assertTrue(isElementPresent(xpath(userMortgagePopup)));
				} catch (AssertionError e) {
					fail("Mortgage Valuation Popup");
					ATUReports.add("FAILED", true);
					resultcount++;
				}
				
				click(xpath(userMortgagePopupOkBtn));
				
				if (resultcount != 0) {
					fail(testCase);
				} else {
					pass(testCase);
				}
			}
		}

	}
	
public void regressionOrderConfirmationDetails() throws Exception {
	Thread.sleep(6000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String ready = (String) js.executeScript("return document.readyState");
	waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
	if(ready.equalsIgnoreCase("complete")){
		resultcount = 0;	
		testCase = "RP Property Hub Order Confirmation Details: " + input[0];
		
		waitForElementPresent(xpath(userOrderItem));
		
	    try {
	        Assert.assertTrue(isElementPresent(By.cssSelector("label.bold")));
	      } catch (AssertionError e) {
			fail("Hub Reference");
			ATUReports.add("FAILED", true);
			resultcount++;
	      }
	    
	    try {
	    	Assert.assertTrue(isElementPresent(By.linkText("Download PDF")));
	      } catch (AssertionError e) {
			fail("Download PDF link");
			ATUReports.add("FAILED", true);
			resultcount++;
	      }
	    try {
	        Assert.assertTrue(isElementPresent(By.linkText("Start new order")));
	      } catch (AssertionError e) {
			fail("Start new order link");
			ATUReports.add("FAILED", true);
			resultcount++;
	      }
	    
//	    takeScreenshot();
	    
	    try {
	        Assert.assertEquals(input[20], getText(xpath(userOrderItem)));
	      } catch (Error e) {
			fail(testCase);
			ATUReports.add("FAILED", true);
			resultcount++;
	      }
	    
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
		
	}

public void testDownloadPDF() throws Exception{
	
	resultcount = 0;	
	testCase = "RP Property Hub Logout: " + input[0];
			
	waitForElementPresent(By.linkText("Download PDF"));
	
	try {
		Assert.assertTrue(isElementPresent(By.linkText("Download PDF")));
	} catch (Exception e) {
		fail("Logout link");
		ATUReports.add("FAILED", true);
		resultcount++;
	}
	
	click(By.linkText("Download PDF"));
	Thread.sleep(2000);
	if(isElementVisible(xpath("//*[@id='hubCboxClose']"))){
		click(xpath("//*[@id='hubCboxClose']"));
	}
//	Thread.sleep(3000);
	
	if (resultcount != 0) {
		fail(testCase);
	} else {
		pass(testCase);
	}
	Thread.sleep(1000);
}

public void testPopup() throws Exception{
	
	resultcount = 0;	
	testCase = "RP Property Hub Popup: " + input[0];
	Thread.sleep(2500);
	 if(input[32].equalsIgnoreCase("popup")){
		 try {
				Assert.assertTrue(isElementPresent(xpath("//*[@id='hubCboxLoadedContent']/div")));
				click(xpath("//*[@id='hubCboxClose']"));
			} catch (Exception e) {
				fail("Pop up");
				ATUReports.add("FAILED", true);
				resultcount++;
			}
	   }else {
		   try {
				Assert.assertFalse(isElementPresent(xpath("//*[@id='hubCboxLoadedContent']/div")));
			} catch (Exception e) {
				fail("Pop up");
				ATUReports.add("FAILED", true);
				resultcount++;
			}
	   }

	Thread.sleep(1000);
	
	if (resultcount != 0) {
		fail(testCase);
	} else {
		pass(testCase);
	}
}

	public void testLogout() throws Exception{
	
		resultcount = 0;	
		testCase = "RP Property Hub Logout: " + input[0];
				
		waitForElementPresent(xpath(userLogoutLink));
	
//		driver.switchTo().window();
		try {			
			Assert.assertTrue(isElementPresent(xpath(userLogoutLink)));
		} catch (Exception e) {
			fail("Logout link");
			ATUReports.add("FAILED", true);
			resultcount++;
		}
		click(xpath(userLogoutLink));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
//		Thread.sleep(3000);
	}
	
}
