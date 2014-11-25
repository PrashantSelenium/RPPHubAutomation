package hub.utilities.RegressionSuiteUtil;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;
import atu.testng.reports.ATUReports;

import com.thoughtworks.selenium.Selenium;

public class PropertyDetailUtil extends FunctionReference{
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	private String[] input = null;
	private String testCase = "";
	public Selenium selenium;
	
	public PropertyDetailUtil(String[] i) {
		input = i;
	}
	
	public PropertyDetailUtil() {
	}
	
	public void login () throws InterruptedException, IOException {
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
				waitForElementPresent(xpath(userPropertySearch));
				
				try {
					Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
					ATUReports.add("Login", "Username and Password","Proceed to property search","PASSED",true);
				} catch (AssertionError e) {
					ATUReports.add("Login","Username and Password","Proceed to property search","FAILED", true);
					resultcount++;
				}
			
			
			
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
			
		}
		
	}
	
	public void coverFlow() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
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
	
	public void deletePendingTransaction() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				Assert.assertTrue(isElementPresent(xpath(pendingTransactionMessage)));
				Assert.assertTrue(isElementPresent(xpath(deletePendingTransaction)));
				click(xpath(deletePendingTransaction));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}
			
			Thread.sleep(5000);
			
			try {
				Assert.assertFalse(isElementPresent(xpath(pendingTransactionMessage)));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}
			

			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
		
	}
	
	public void checkPendingTransactionSection() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				Assert.assertTrue(isElementPresent(xpath(pendingTransactionMessage)));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}

			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
	}
	
	public void checkPendingTransactionSectionNotVisible() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				Assert.assertTrue(!isElementPresent(xpath(pendingTransactionMessage)));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}

			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
	}
	
	public void checkPropertyPhoto() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			if (input[5].equalsIgnoreCase("hasPhoto")) {
				try {
					WebElement image = driver.findElement(By.xpath(propertyPhoto)); 
					String src = image.getAttribute("src"); 
					Assert.assertTrue(!src.contains("no_photo_available"));
				} catch (AssertionError e) {
					fail("Coverflow");
					resultcount++;
				}
			} else {
				try {
					WebElement image = driver.findElement(By.xpath(propertyPhoto)); 
					String src = image.getAttribute("src"); 
					Assert.assertTrue(src.contains("no_photo_available"));
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
	
	public void checkIfUrlContainsGuestId() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			String url = driver.getCurrentUrl();
			
			try {
				Assert.assertTrue(url.contains("hubtk"));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}
		
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
	}
	
	public void checkStoredDataOnPage() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			String url = driver.getCurrentUrl();
		
			String hubcid = driver.manage().getCookieNamed("hubcid").getValue();
			
			try {
				Assert.assertTrue(hubcid.equals(getValue(xpath(customerId))));
				Assert.assertTrue(url.contains(getValue(xpath(guestId))));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}
		
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
	}
	
	public void checkHomeButtonOK() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			waitForElementPresent(xpath(homeButton));
			try {
				Assert.assertTrue(isElementPresent(xpath(homeButton)));
				click(xpath(homeButton));
				waitForElementPresent(xpath(okButton));
				click(xpath(okButton));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}
		
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
	}
	
	public void checkHomeButtonCancel() throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = input[0];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			String url = driver.getCurrentUrl();
			waitForElementPresent(xpath(homeButton));
			try {
				Assert.assertTrue(isElementPresent(xpath(homeButton)));
				click(xpath(homeButton));
				waitForElementPresent(xpath(cancelButton));
				click(xpath(cancelButton));
				String currentURL = driver.getCurrentUrl();
				Assert.assertTrue(url.equalsIgnoreCase(currentURL));
			} catch (AssertionError e) {
				fail("Coverflow");
				resultcount++;
			}
		
			if (resultcount != 0) {
				fail(testCase);
			} else {
				pass(testCase);
			}
		}
	}
	
	public void slas() throws Exception {
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
			
			type(xpath(userPropertySearch), input[4]);		
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
	
	public void checkPropertyAttributes() throws Exception {	
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementPresent(xpath(propertyPhoto));
		if(ready.equalsIgnoreCase("complete")){
			if (isElementPresent(xpath(propertyPhoto))){
				resultcount = 0;		    	
		    	try {
					Assert.assertTrue(isElementPresent(xpath(propertyPhoto)));
					Assert.assertTrue(isElementPresent(xpath(bedrooms)));
					Assert.assertTrue(isElementPresent(xpath(bathRooms)));
					Assert.assertTrue(isElementPresent(xpath(carSpace)));
					Assert.assertTrue(isElementPresent(xpath(landArea)));
					Assert.assertTrue(isElementPresent(xpath(lotNumber)));
				} catch (AssertionError e) {
					fail(input[0]);
					resultcount++;
				}
		    
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
	
	public void checkChangePropertyAddress() throws Exception {	
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementPresent(xpath(changePropertyAdress));
		if(ready.equalsIgnoreCase("complete")){
			if (isElementPresent(xpath(changePropertyAdress))){
				resultcount = 0;		    	
		    	try {
					Assert.assertTrue(isElementPresent(xpath(changePropertyAdress)));
					click(xpath(changePropertyAdress));
					waitForElementPresent(xpath(userPropertySearch));
					Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
				} catch (AssertionError e) {
					fail(input[0]);
					resultcount++;
				}     
		    
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
	
	public void checkProceedtoProductSelection() throws Exception {	
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementPresent(xpath(proceedtoProductSelection));
		if(ready.equalsIgnoreCase("complete")){
			if (isElementPresent(xpath(proceedtoProductSelection))){
				resultcount = 0;		    	
		    	try {
					Assert.assertTrue(isElementPresent(xpath(proceedtoProductSelection)));
					click(xpath(proceedtoProductSelection));
					waitForElementPresent(xpath(productTabsMenu));
					Assert.assertTrue(isElementPresent(xpath(productTabsMenu)));
				} catch (AssertionError e) {
					fail(input[0]);
					resultcount++;
				}     
		    
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
	
	public void checkPendingTransactionIfUsesHttpProtocol() throws Exception {	
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		if(ready.equalsIgnoreCase("complete")){
			if (isElementPresent(xpath(userPendingTransactionMessage))){
		    	System.out.println("User has Pending transactions!");
				resultcount = 0;	
				testCase = input[0];
				String url = driver.getCurrentUrl();
		    	try {
					Assert.assertTrue(url.contains("https"));
				} catch (AssertionError e) {
					fail(input[0]);
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
	
	public void addProduct() throws Exception {
		Thread.sleep(6500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		waitForElementNotPresent(xpath("//*[class='blockUI blockOverlay']"));
		
		if(ready.equalsIgnoreCase("complete")){
			resultcount = 0;	
			testCase = "RP Property Hub Add to cart: " + input[0];
					
			String addToCart = input[5];
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
	
	public void checkChangePropertyAddressWithPopup() throws Exception {	
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementPresent(xpath(changePropertyAdress));
		if(ready.equalsIgnoreCase("complete")){
			if (isElementPresent(xpath(changePropertyAdress))){
				resultcount = 0;		    	
		    	try {
					Assert.assertTrue(isElementPresent(xpath(changePropertyAdress)));
					click(xpath(changePropertyAdress));
					waitForElementPresent(xpath(okButton));
					click(xpath(okButton));
				} catch (AssertionError e) {
					fail(input[0]);
					resultcount++;
				}     
		    
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
		
		waitForElementPresent(xpath(userLoginUsername));
		try {
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
			Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
			Assert.assertTrue(isElementPresent(xpath(loginButton)));
		} catch (AssertionError e) {
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
//		Thread.sleep(3000);
	}
	
}
