package hub.test;

import static org.openqa.selenium.By.xpath;
import hub.library.ReadXlsData;
import hub.library.TestInitReference;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HubDbTrackerTest extends TestInitReference {

	String testCase = "Test DB Tracker";
	
	@Test(description="Test DB Tracker")
	public void testDbTracker() {

		try {
//		     type(xpath("//input[@name='userName']"), "adm"); 	
//		     type(xpath("//input[@name='password']"), "P@55w0rd");
//		     click(xpath("//input[@type='submit']"));
//		     Thread.sleep(3000);
//		     Assert.assertTrue(isElementPresent(xpath("//textarea[@id='sqlStatement']")));
		     
		     for(int i=0; i<1000; i++) {
		    	 
		    	System.out.println("Refresh # " + i);
		        driver.navigate().refresh();
		        Thread.sleep(3000);
//		        try{
//		        Assert.assertTrue(isElementPresent(xpath("//textarea[@id='sqlStatement']")));
//		        } catch (AssertionError e){
//		        	fail(testCase);
//					takeScreenshot();
//		        }
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
