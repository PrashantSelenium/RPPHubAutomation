package hub.test;

import static org.openqa.selenium.By.xpath;
import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.UserPropertyDetailsUtil;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoadPropertySearchTest extends TestInitReference {

	String testCase = "Test Property Search";
	
	@Test(description="Test Property Search")
	public void testDbTracker() {

		try {
//			driver.navigate().to("https://stage-cbalender.rppropertyhub.com");
		    waitForElementPresent(xpath(userLoginUsername));
			isElementPresent(xpath(userLoginUsername));
			isElementPresent(xpath(userLoginPassword));
			isElementPresent(xpath(userLoginButton));
			
			type(xpath(userLoginUsername), "jennifer-lender");
			type(xpath(userLoginPassword), "1234test");
			click(xpath(userLoginButton));
			waitForElementPresent(xpath(userPropertySearch));
			
			try {
				Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));											 
			} catch (AssertionError e) {
				fail(testCase);
				takeScreenshot();
				resultcount++;
			}
			type(xpath(userPropertySearch), "406/6 Watt Street Newcastle NSW 2300");		
			click(xpath(userSearchButton));
			UserPropertyDetailsUtil updu = new UserPropertyDetailsUtil();
			updu.testPropertyDetails();
			updu.startNewTransaction();
			updu.proceedProductSelection();
			
			waitForElementPresent(xpath(userAddToCart));
			click(xpath(userAddToCart));
			click(By.linkText(userProceedToInstructionDetails));
			
			waitForElementPresent(xpath(userInstructionDetails));
		     
		     for(int i=0; i<100; i++) {
		    	 
		    	System.out.println("Refresh # " + i);
		        driver.navigate().refresh();
		        Thread.sleep(3000);
//		    try {
//				Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));											 
//			} catch (AssertionError e) {
//				fail(testCase);
//				takeScreenshot();
//				resultcount++;
//			}
		        Set<Cookie> cookies = driver.manage().getCookies();
		        Assert.assertFalse(cookies.isEmpty());
		        for (Cookie eachCookie : cookies) {
		        	StringBuffer cookieData = new StringBuffer("");
					cookieData.append(eachCookie.getName());
					cookieData.append("=");
					cookieData.append(eachCookie.getValue());
					System.out.println(cookieData.toString());
				
				}
		        
		     }
		} catch (Exception e) {
			fail(testCase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
	}
}
