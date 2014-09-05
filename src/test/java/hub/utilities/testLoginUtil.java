package hub.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;
import org.testng.Assert;

import com.thoughtworks.selenium.Selenium;

import hub.library.FunctionReference;

public class testLoginUtil extends FunctionReference{
	String [] input = null;
	public testLoginUtil(String[] i) {
		input = i;
	}

	public void typeUsername() throws InterruptedException{
		waitForElementPresent(By.xpath("//*[@id='userName']"));
		type(By.xpath("//*[@id='userName']"),input[1]);
		type(By.xpath("//*[@id='password']"),input[2]);
	}
	
	public void clickLogin() throws InterruptedException{
		waitForElementPresent(By.xpath("//*[@value='Login']"));
		try{
			Assert.assertTrue(isElementPresent(By.xpath("//*[@value='Login']")));
			click(By.xpath("//*[@value='Login']"));
		}catch(Exception e){
			fail("Login Button not present.");
		}
	}
	
	public void checkErrorMessage() throws InterruptedException{
		waitForElementVisible(By.xpath("//*[@id='hubLoginError']"));
		waitForElementVisible(By.xpath("//*[@id='flashMessage']"));
		try{
			Assert.assertTrue(isElementVisible(By.xpath("//*[@id='hubLoginError']")));
			Assert.assertTrue(isElementVisible(By.xpath("//*[@id='flashMessage']")));
		}catch(Exception e){
			fail("Error message not visible.");
		}
	}
	
	public void checkIfCorrect() throws InterruptedException{
		waitForElementVisible(By.xpath("//*[@id='hubLoginError']"));
		waitForElementVisible(By.xpath("//*[@id='flashMessage']"));
		try{
			Assert.assertEquals(getText(By.xpath("//*[@id='hubLoginError']")), input[3]);
		}catch(Exception e){
			fail("Error Message not correct.");
		}
	}
	
}
