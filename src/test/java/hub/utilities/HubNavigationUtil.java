package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import atu.testng.reports.ATUReports;

public class HubNavigationUtil extends FunctionReference {

	//Login	
	public void hubUserLogin (String username, String password) throws Exception {
		resultcount = 0;	
		String str = "Login";
		
		waitForElementPresent(xpath(userLoginUsername));
		try {
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
			Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
			Assert.assertTrue(isElementPresent(xpath(loginButton)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		waitForElementPresent(xpath(loginButton));
		click(xpath(loginButton));
		
		if (resultcount != 0) {
			fail(str);
		} else {
			pass(str);
		}
	}
	
	//Property Search	
	public void searchAddress(String address) throws Exception {
		resultcount = 0;	
		String str = "Search Address";
				
		waitForElementPresent(xpath(userPropertySearch));
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			fail("SLAS field");
			resultcount++;
		}
				
		type(xpath(userPropertySearch), address);	
		waitForElementPresent(xpath(userSearchButton));
		click(xpath(userSearchButton));
		
		if (resultcount != 0) {
				fail(str);
			} else {
				pass(str);
			}
		Thread.sleep(3000);
	}
	
	//Property Details
	public void propertyDetails() throws Exception {
		checkPendingTransactionSectionNotVisible();
		proceedToProductSelection();
		Thread.sleep(3000);	
	}
	
	//Product Selection
	public void productSelectionManipultation(List<HashMap<String, Object>> productSelectionList) throws InterruptedException, IOException {
		
		for (int x = 0; x < productSelectionList.size(); x++) {
			
			HashMap<String, Object> map = productSelectionList.get(x);
			HashMap<String, String> productsAndTabMap =  (HashMap<String, String>) map.get("TabProductObject");
			
			String productTab = productsAndTabMap.get("Tab");
			String productXpath = productsAndTabMap.get("Products");
			productSelection(map, productTab, productXpath);
			
		}
		String btnNextXpath = "//*[@id='instructionDetails']/a[2]";
		waitForElementPresent(xpath(btnNextXpath));
		click(xpath(btnNextXpath));
		
	}
	
	public void productSelection(HashMap<String, Object> originatorMap, String productTab, String productXpath) throws InterruptedException, IOException {
		resultcount = 0;	
		String str = "Product Selection";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				
				fillOutOriginatorFields(originatorMap);
				String productTabLink = "";
				productTabLink = dynamicProductTabLink.replace("{?}", productTab);
				
				if (!productTab.trim().equals("")) {
					
					waitForElementPresent(xpath(productTabLink));
					click(xpath(productTabLink));
					Thread.sleep(3000);
					
					//Add to cart product
					addToCartProduct(productXpath);
					Thread.sleep(3000);
					
				} else {
					fail(str + " Product Tab Name not indicated.");
				}
				
			} catch (AssertionError e) {
				fail(str);
				resultcount++;
			}

			if (resultcount != 0) {
				fail(str);
			} else {
				pass(str);
			}
		}
	}
	
	//Instruction Details
	public void instructionDetails(HashMap<String, Object> map) throws InterruptedException, IOException {
		resultcount = 0;	
		String str = "Instruction Details";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			fillOutFormFields(map, str);
			
			String btnNextXpath = "//*[@id='paymentDetails']/a[2]";
			waitForElementPresent(xpath(btnNextXpath));
			click(xpath(btnNextXpath));
		}
	}
	
	//Payment Details
	public void paymentDetails(HashMap<String, Object> map) throws InterruptedException, IOException {
		resultcount = 0;	
		String str = "Payment Details";
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			fillOutFormFields(map, str);
			
			String btnConfirmXpath = "//*[@id='hubNavigation_next']";
			waitForElementPresent(xpath(btnConfirmXpath));
			click(xpath(btnConfirmXpath));
		}
	}
	
	//Payment Details - CPS
	public void paymentDetailsCps(HashMap<String, Object> map) {
		resultcount = 0;	
		String str = "Payment Detail CPS";
		
		String cardNumber = map.get("CardNumber").toString();
		String cardholder = map.get("CardHolder").toString();
		
		String xp = map.get("ExpiryDate").toString();
		
		String dateExpiry = "";
		String dateExpiry2 = "";
		
		if (xp != null && xp.contains(EventUtil.SEPARATOR)) {
			String[] arr = xp.split(EventUtil.SEPARATOR);
			
			dateExpiry = arr[0];
			dateExpiry2 = arr[1];
		
		} else {
			//Set to default value.
			dateExpiry = "12";
			dateExpiry2 = "19";
		}
		

		String cvc2 = map.get("SecurityCode").toString();;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				Thread.sleep(5000);
				waitForElementVisible(xpath("//iframe[@id='card_payment_iframe']"));
				Thread.sleep(2000);
				
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='card_payment_iframe']")));
				isElementVisible(By.xpath("//*[@id='CardNumber']"));
				type(xpath("//*[@id='CardNumber']"), cardNumber);
				type(xpath("//*[@id='CardHolderName']"), cardholder);
				type(xpath("//*[@id='DateExpiry_1']"), dateExpiry);
				type(xpath("//*[@id='DateExpiry_2']"), dateExpiry2);
				type(xpath("//*[@id='Cvc2']"), cvc2);
				click(xpath("//*[@id='Add']"));
				
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
				resultcount++;
			}

			if (resultcount != 0) {
				fail(str);
			} else {
				pass(str);
			}
		}
	}
	
	/* 
	 * Supporting methods...
	 */
	public void checkPendingTransactionSectionNotVisible() throws InterruptedException, IOException {
		resultcount = 0;	
		String str = "Pending Transaction";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		
		if(ready.equalsIgnoreCase("complete")){
			
			try {
				if (isElementPresent(xpath(pendingTransactionMessage))) {
					click(By.linkText("Start a new transaction for this property")); 
				}
			} catch (AssertionError e) {
				resultcount++;
			}

			if (resultcount != 0) {
				fail(str);
			} else {
				pass(str);
			}
		}
	}
	
	public void proceedToProductSelection() throws Exception {	
		Thread.sleep(3000);	
		resultcount = 0;
		String str = "Proceed to Product Selection";
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
					resultcount++;
				}     
		    
		    if (resultcount != 0) {
				fail(str);
			} else {
				pass(str);
			}
		    
		    }
		}
	}
	
	public void fillOutOriginatorFields(HashMap<String, Object> originatorMap) throws InterruptedException {
		Thread.sleep(1000);
		String disabled = driver.findElement(By.id("div_questionnaire")).getAttribute("class");
		
		if (isElementPresent(xpath(userOriginatorDetails)) && disabled.contains("simplemodal-data")) {
			
			fillOutFormFields(originatorMap, "Originator");
			
			try {
				waitForElementPresent(xpath(proceedToProductSelection));
				click(xpath(proceedToProductSelection));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void addToCartProduct(String productXpath) throws InterruptedException, IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		waitForElementPresent(xpath(proceedtoProductSelection));
		
		if(ready.equalsIgnoreCase("complete")){
			if (!productXpath.equals("")) {
				if (productXpath.contains(EventUtil.SEPARATOR)) {
					String[] xpath = productXpath.split(EventUtil.SEPARATOR);
					
					for (int x = 0; x < xpath.length; x++) {

						waitForElementPresent(xpath(xpath[x]));
						click(xpath(xpath[x]));
						Thread.sleep(1000);
						
					}
					pass("Adding product to Cart");
				} else {

					waitForElementPresent(xpath(productXpath));
					click(xpath(productXpath));
					Thread.sleep(1000);

				}
			}
		}
		
	}
	
	public void fillOutFormFields(HashMap<String, Object> map, String test) throws InterruptedException {
		Thread.sleep(5000);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			
			if (entry.getValue() instanceof String) {
				
				String key = entry.getKey();
				String value = entry.getValue().toString();
				
				if (value != null && !value.trim().equals("") && value.contains(EventUtil.SEPARATOR)) {
					String[] strValueArray = value.split(EventUtil.SEPARATOR);

					if (isElementPresent(xpath(strValueArray[0]))) {
						try {
							String type = strValueArray[2].trim();
							String fieldValue = strValueArray[1].trim();
							String xpath = strValueArray[0].trim();
							
							//Fill the element.
							EventUtil.fillOutField(type, fieldValue, xpath);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						pass(test);
						
					} else {
						fail(test + " - Element for " + strValueArray[0] + " - " + key + " does not exist");
					}
					
				} 
				
			}
		}
	}
		
}
