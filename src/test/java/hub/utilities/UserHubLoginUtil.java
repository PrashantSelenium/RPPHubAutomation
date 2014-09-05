package hub.utilities;

import static org.openqa.selenium.By.xpath;

import java.awt.event.KeyEvent;
import java.io.IOException;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.testng.Assert;

import java.nio.file.*;

import javax.swing.KeyStroke;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.internal.seleniumemulation.ControlKeyDown;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.Selenium;

public class UserHubLoginUtil extends FunctionReference {
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	private String[] input = null;
	private String testCase = "";
	public Selenium selenium;
	
	public UserHubLoginUtil(String[] i) {
		input = i;
	}
	
	public UserHubLoginUtil() {
	}
	
	public void hubUiLogin() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(userPropertySearch));
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));											 
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertEquals("Enter your property address or street name here.", getValue(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		}
	}

	public void testHubLoginSuccess() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(userPropertySearch));
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));											 
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			Assert.fail();
		} else {
			pass(testCase);
		}
	}
	
	public void testHubLoginEmpty() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(hubLoginError));
		try {
			Assert.assertTrue(isElementPresent(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	

		try {
			Assert.assertEquals(emptyErrorMessage, getText(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	
					
		if (resultcount != 0) {
			Assert.fail();
		} else {
			pass(testCase);
		}
	}

	public void testHubLoginFail() throws Exception {

		hubLoginSetup();
		waitForElementPresent(xpath(hubLoginError));
		try {
			Assert.assertTrue(isElementPresent(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	

		try {
			Assert.assertEquals(invalidErrorMessage, getText(xpath(hubLoginError)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}	
		
	
		if (resultcount != 0) {
			Assert.fail();
		} else {
			pass(testCase);
		}
	}
	
	public void smokeLogin () throws InterruptedException, IOException {
		resultcount = 0;	
		testCase = "RP Property Hub Login: " + input[0];
		
		driver.navigate().to(input[1]);				
		waitForElementPresent(xpath(userLoginUsername));
		try {
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
			Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
			Assert.assertTrue(isElementPresent(xpath(loginButton)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		String username = "";
		String password = "";
		
		username = input[2];
		password = input[3];

		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		click(xpath(loginButton));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	private void hubLoginSetup () throws InterruptedException, IOException {
		resultcount = 0;
		waitForElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginPassword));
		isElementPresent(xpath(loginButton));
		
		String username = "";
		String password = "";
		if (input == null) {
			username = rxml.data("userUsername");
			password = rxml.data("userPassword");
		} else {
			testCase = "RP Property Hub Login: " + input[0];
			username = input[1];
			password = input[2];
		}
		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		click(xpath(loginButton));
	}

	public void smokeDeepLink() throws InterruptedException, IOException{
		resultcount = 0;
		testCase = "RP Property Hub Deep Link Login: " + input[0];
		
		driver.navigate().to(input[1] + input[10]);
		waitForElementPresent(xpath(userLoginUsername));
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
			Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
			Assert.assertTrue(isElementPresent(xpath(loginButton)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}		
		
		String username = "";
		String password = "";
		username = input[2];
		password = input[3];

		type(xpath(userLoginUsername), username);
		type(xpath(userLoginPassword), password);
		click(xpath(loginButton));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		
		Thread.sleep(3000);
	}
	
	public void testLoginSecurity () throws Exception {
		resultcount = 0;
		testCase = "RP Property Hub Login Security";
		waitForElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginPassword));
		isElementPresent(xpath(loginButton));
		
		type(xpath(userLoginUsername), "loginsecurity");
		type(xpath(userLoginPassword), "1234567890");
		click(xpath(loginButton));
		type(xpath(userLoginPassword), "qwertyuiop");
		click(xpath(loginButton));
		type(xpath(userLoginPassword), "q1w2e3r4t5y6");
		click(xpath(loginButton));
		
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(loginSecurityError));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(loginSecurityError)));
		} catch (AssertionError e) {
			fail("Login security error");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertEquals(loginSecurityMessage, getText(xpath(loginSecurityError)));
		} catch (AssertionError e) {
			fail("Login security message");
			takeScreenshot();
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
		
	}
	
	public void testLogout() throws Exception{
		
		resultcount = 0;	
		testCase = "RP Property Hub Logout: " + input[0];
				
		waitForElementPresent(xpath(userLogoutLink));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userLogoutLink)));
		} catch (Exception e) {
			fail("Logout link");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(userLogoutLink));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
	}
	
public void WidgetTileActivated() throws Exception{
		
		
		resultcount = 0;	
		testCase = "RP Property Hub Logout: " + input[0];
				
		waitForElementPresent(xpath(userLogoutLink));
		
			//User Manual
			try{ 
				Assert.assertTrue(isElementPresent(xpath(userManual)));
				}
				catch(AssertionError e) {
					fail(input[0] + " - User Manual Link is not Visible");
					takeScreenshot(input[0]);
					resultcount++;
					}
			//Contact Us
			try{ 
				Assert.assertTrue(isElementPresent(xpath(contactUs)));
				}
				catch(AssertionError e) {
					fail(input[0] + " - Contact Us Link is not Visible");
					takeScreenshot(input[0]);
					resultcount++;
					}
			//Feedback
			try{ 
				Assert.assertTrue(isElementPresent(xpath(feedback)));
				}
				catch(AssertionError e) {
					fail(input[0] + "  - Feedback Link is not Visible");
					takeScreenshot(input[0]);
					resultcount++;
					}

				
		if (resultcount != 0) {
			fail(input[0]);
		} else {
			pass(input[0]);
		}
	}
	
	public void LinkValidation() throws Exception{
	
		resultcount = 0;	
		testCase = "RP Property Hub Logout: " + input[0];
				
		waitForElementPresent(xpath(userLogoutLink));

			//User Manual
			try{ 
				//Assert.assertTrue(isElementPresent(xpath(userManual)));
				click(xpath(userManual));
				Thread.sleep(5000);
				driver.findElement(By.id("userName")).sendKeys(Keys.ENTER);
				Thread.sleep(15000);
				Path path = Paths.get("/Users/anthony/Downloads/Hub_ChannelProductSelection.pdf");
				Assert.assertTrue(Files.exists(path));
				}
				catch(AssertionError e) {
					fail(input[0] + " - User Manual file not downloaded");
					takeScreenshot(input[0]);
					resultcount++;
					}
			//Contact Us
			try{ 
				//Assert.assertTrue(isElementPresent(xpath(contactUs)));
				click(xpath(contactUs));
				Thread.sleep(15000);
				Assert.assertEquals(input[2], getText(xpath(contactUsPage)));				
				driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
				Thread.sleep(10000);
				}
				catch(AssertionError e) {
					fail(input[0] + " - Contact Us link is not functioning");
					takeScreenshot(input[0]);
					resultcount++;
					}
			//Feedback
			try{ 
				//Assert.assertTrue(isElementPresent(xpath(feedback)));
				click(xpath(feedback));
				Thread.sleep(15000);
				Assert.assertEquals(getText(xpath(feedbackPage)), input[3]);				
				driver.findElement(By.id("feedbackName")).sendKeys(Keys.ESCAPE);
				Thread.sleep(5000);
				}
				catch(AssertionError e) {
					fail(input[0] + "  - Feedback Link is not functioning" + " " + input[3] + " " + getText(xpath(feedbackPage)));
					takeScreenshot(input[0]);
					resultcount++;
					}

				
		if (resultcount != 0) {
			fail(input[0]);
		} else {
			pass(input[0]);
		}
	}

	
	public void testLoginCredential () throws Exception {
		resultcount = 0;
		testCase = input[0];
		waitForElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginPassword));
		isElementPresent(xpath(loginButton));
		
		type(xpath(userLoginUsername), input[2]);
		type(xpath(userLoginPassword), input[3]);
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(loginErrorMessage));
		System.out.println(getText(xpath(loginErrorMessage)));
		try{
			Assert.assertEquals(getText(xpath(loginErrorMessage)), input[4]);
		}catch(Exception e){
			fail("Validation message should be "+input[4]);
			takeScreenshot(input[0]);
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
		
	}
	
	public void testValidationColor () throws Exception {
		resultcount = 0;
		testCase = input[0];
		waitForElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginUsername));
		isElementPresent(xpath(userLoginPassword));
		isElementPresent(xpath(loginButton));
		
		type(xpath(userLoginUsername), input[2]);
		type(xpath(userLoginPassword), input[3]);
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(loginErrorMessage));
		System.out.println(getText(xpath(loginErrorMessage)));
		try{
			Assert.assertEquals(getText(xpath(loginErrorMessage)), input[4]);
		}catch(Exception e){
			fail("Validation message should be "+input[4]);
			takeScreenshot(input[0]);
			resultcount++;
		}
		
		try{
			String color = driver.findElement(By.xpath(loginErrorMessage)).getCssValue("color");
			System.out.println(color);
			System.out.println(rpDataRed);
		}catch(Exception e){
			fail("Color should be RPData red");
			takeScreenshot(input[0]);
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(script, args)
		
	}
}

