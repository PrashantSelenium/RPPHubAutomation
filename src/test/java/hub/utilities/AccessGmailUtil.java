package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

public class AccessGmailUtil extends FunctionReference{
	
	public void accessGmail() throws Exception {
		driver.navigate().to("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/");
		type(xpath("//input[@id='Email']"), "twistqatest@gmail.com");
		type(xpath("//input[@id='Passwd']"), "twist123");
		click(xpath("//input[@id='signIn']"));
		
//		waitForElementPresent(xpath("//iframe[@id='gth-talk-plugin-frame-id']"));
//		click(xpath("//iframe[@id='gth-talk-plugin-frame-id']"));
		waitForElementPresent(xpath("(//tr)[5]")); 
		click(xpath("(//tr)[5]"));
//		waitForElementPresent(xpath("(//a)[63]"));
		click(xpath("//a[contains(@href, '/Reset-Password')]"));
//		click(xpath("(//a)[53]"));
		
		
//		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}

}
