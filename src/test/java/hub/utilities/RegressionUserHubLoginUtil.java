package hub.utilities;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import hub.library.FunctionReference;

import org.testng.Assert;

public class RegressionUserHubLoginUtil extends FunctionReference {
	
	private String[] input = null;
	private String testCase = "";
	
	public RegressionUserHubLoginUtil(String[] i) {
		input = i;
	}
	
	public RegressionUserHubLoginUtil() {
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
		
		driver.navigate().to("https://"+input[2]);				
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
		
		username = input[7];
		password = input[8];

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
}

