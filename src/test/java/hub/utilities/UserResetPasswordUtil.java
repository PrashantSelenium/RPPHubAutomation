package hub.utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.openqa.selenium.By.*;
import hub.library.FunctionReference;

public class UserResetPasswordUtil extends FunctionReference{
			
		private String[] input = null;
		private String testCase = "";
		
		public UserResetPasswordUtil(String[] i) {
			input = i;
		}
		
		public UserResetPasswordUtil() {
		}
		
		public void testOldForgottenPassword() throws Exception {
			try {
				String styleval = driver.findElement(By.xpath(oldForgotPassword)).getAttribute("type");
				Assert.assertEquals(styleval, "hidden");
				pass("Old Password");
			} catch (AssertionError e) {
				fail("Old Password");
				
				resultcount++;
			}
		}

		public void testResetPasswordSuccess() throws Exception {

			
			waitForElementPresent(xpath(userResetPasswordSuccessPopup));
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordSuccessPopup)));											 
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			waitForElementPresent(xpath(userResetPasswordEmailSent));
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordEmailSent)));
				Assert.assertEquals("Email has been sent",getText(xpath(userResetPasswordEmailSent)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			waitForElementPresent(xpath(userResetPasswordSuccessPopupMessage));
			try {
				Assert.assertEquals("When you recieve your sign in information, follow the directions in the email to activate and/or reset your account.", getText(xpath(userResetPasswordSuccessPopupMessage)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			
			click(xpath(userResetPasswordSuccessPopupClose));
			
			Thread.sleep(3000);
			if (resultcount != 0) {
				Assert.fail();
			} else {
				pass(testCase);
			}
		}
		
		public void testResetPasswordEmpty() throws Exception {

			testResetPasswordSetup();
			Assert.assertEquals("RP Property Hub - Login", driver.getTitle());
			waitForElementPresent(xpath(userForgotPasswordEmpty));
			try {
				Assert.assertTrue(isElementPresent(xpath(userForgotPasswordEmpty)));
			} catch (AssertionError e) {
				fail("Error message missing");
				
				resultcount++;
			}	
			try {
				Assert.assertEquals("Username and/or Email Address field should not be empty.", getText(xpath(userForgotPasswordEmpty)));
			} catch (AssertionError e) {
				fail("Error message incorrect");
				
				resultcount++;
			}	
			Thread.sleep(3000);
			if (resultcount != 0) {
				Assert.fail();
			} else {
				pass(testCase);
			}
		}

		public void testResetPasswordFail() throws Exception {

			testResetPasswordSetup();
			Assert.assertEquals("RP Property Hub - Login", driver.getTitle());
			waitForElementPresent(xpath(userForgotPasswordError));
			try {
				Assert.assertTrue(isElementPresent(xpath(userForgotPasswordError)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}	

			try {
				Assert.assertEquals("Invalid Username and/or Email Address.", getText(xpath(userForgotPasswordError)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}	
				
			Thread.sleep(3000);
			if (resultcount != 0) {
				Assert.fail();
			} else {
				pass(testCase);
			}
		}
		
		
		public void testResetPasswordLink() throws Exception{			
			
			waitForElementPresent(xpath(userResetPasswordNewPass));
			try {
				Assert.assertEquals("Enter a new password for twistqatest@gmail.com below. Your password must be at least eight characters long.",getText(xpath(userResetPasswordChangeMessage)));
				Assert.assertEquals("It must contain at least one number and two letters.",getText(xpath(userResetPasswordChangeMessage2)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}	
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordNewPass)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}	
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordConfirmPass)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}	
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordCancelBtn)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}	
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordResetPassBtn)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}	
			
			type(xpath(userResetPasswordNewPass), "Test!ng123");
			type(xpath(userResetPasswordConfirmPass), "Test!ng123");
//			click(xpath(userResetPasswordCancelBtn));
			click(xpath(userResetPasswordResetPassBtn));
			waitForElementPresent(xpath(userForgotPasswordBtn));
			
			try {
			Assert.assertTrue(isElementPresent(xpath("//div[@id='flashMessageContent']")));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
		}
		
		public void testOneTimePassword() throws Exception{
			waitForElementPresent(xpath(userOneTimePasswordFirstPopup));
			try{
			Assert.assertEquals("Because you share an email account, we need you to provide a one time password to proceed. You will be sent an email with a link to confirm your one time password. Once you confirm this password, you will be able to activate your account or reset the account password.",getText(xpath(userOneTimePasswordMessage)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			try {
				Assert.assertTrue(isElementPresent(xpath(userOneTimePasswordLabel)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			try {
				Assert.assertTrue(isElementPresent(xpath(userOneTimePasswordField)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}			
			try {
				Assert.assertTrue(isElementPresent(xpath(userOneTimePasswordConfirm)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			try {
				Assert.assertTrue(isElementPresent(xpath(userOneTimePasswordClose)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			
			String passOneNumber = "";
			String passLowerCase = "";
			String passUpperCase = "";
			String passSpecial = "";
			String oneTimePass = "";
			
			passOneNumber = rxml.data("passOneNumber");
			passLowerCase = rxml.data("passLowerCase");
			passUpperCase = rxml.data("passUpperCase");
			passSpecial = rxml.data("passSpecial");
			oneTimePass = rxml.data("oneTimePass");
			
			type(xpath(userOneTimePasswordField), passOneNumber);
			click(xpath(userOneTimePasswordConfirm));
			showPasswordValidation();
			
			type(xpath(userOneTimePasswordField), passLowerCase);
			click(xpath(userOneTimePasswordConfirm));
			showPasswordValidation();
			
			type(xpath(userOneTimePasswordField), passUpperCase);
			click(xpath(userOneTimePasswordConfirm));
			showPasswordValidation();
			
			type(xpath(userOneTimePasswordField), passSpecial);
			click(xpath(userOneTimePasswordConfirm));
			showPasswordValidation();
			
			type(xpath(userOneTimePasswordField), oneTimePass);
			click(xpath(userOneTimePasswordConfirm));
			
			
						
		}
		
		public void showPasswordValidation() throws Exception {
			waitForElementPresent(xpath(userShowValidation));
			try {
				Assert.assertTrue(isElementPresent(xpath(userShowValidation)));
				Assert.assertTrue(isElementPresent(xpath(userShowValidationOneNumber)));
				Assert.assertTrue(isElementPresent(xpath(userShowValidationLowerCase)));
				Assert.assertTrue(isElementPresent(xpath(userShowValidationUpperCase)));
				Assert.assertTrue(isElementPresent(xpath(userShowValidationSpecialChar)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			try {
				Assert.assertEquals("Password must have three of the following four categories:", getText(xpath(userShowValidation)));
				Assert.assertEquals("Have at least one number", getText(xpath(userShowValidationOneNumber)));
				Assert.assertEquals("Have at least one lower case letter", getText(xpath(userShowValidationLowerCase)));
				Assert.assertEquals("Have at least one upper case letter", getText(xpath(userShowValidationUpperCase)));
				Assert.assertEquals("Have at least one special character", getText(xpath(userShowValidationSpecialChar)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			
		}
		
		public void testResetPasswordSetup () throws InterruptedException, IOException {
			resultcount = 0;
			waitForElementPresent(xpath(userForgotPasswordBtn));
			try {
				Assert.assertTrue(isElementPresent(xpath(userForgotPasswordBtn)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			
			click(xpath(userForgotPasswordBtn));
			waitForElementPresent(xpath(userForgotPasswordInstruction));
			
			try {
				Assert.assertTrue(isElementPresent(xpath(userForgotPasswordInstruction)));
			} catch (AssertionError e) {
				fail("Forgot password label");
				
				resultcount++;
			}
			try {
				Assert.assertEquals("Enter Username and Email Address below.",getText(xpath(userForgotPasswordInstruction)));
			} catch (AssertionError e) {
				fail("Forgot password label");
				
				resultcount++;
			}
			waitForElementPresent(xpath(userForgotPasswordUsername));
			try {
				Assert.assertTrue(isElementPresent(xpath(userForgotPasswordUsername)));
			} catch (AssertionError e) {
				fail("Username");
				
				resultcount++;
			}
			waitForElementPresent(xpath(userForgotPasswordEmailAddress));
			try {
				Assert.assertTrue(isElementPresent(xpath(userForgotPasswordEmailAddress)));
			} catch (AssertionError e) {
				fail("Email");
				
				resultcount++;
			}
			waitForElementPresent(xpath(userResetPasswordBtn));
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordBtn)));
			} catch (AssertionError e) {
				fail("Reset Password Button");
				
				resultcount++;
			}
/*			waitForElementPresent(xpath(userResetPasswordMessage));
			try {
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordMessage)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}
			try {
				Assert.assertEquals("An email, with a password reset link, has been sent",getText(xpath(userResetPasswordMessage)));
			} catch (AssertionError e) {
				fail(testCase);
				
				resultcount++;
			}*/
			
			String username = "";
			String emailAddress = "";
			if (input == null) {
				username = rxml.data("userUsername2");
				emailAddress = rxml.data("userEmail");
			} else {
				testCase = "RP Property Reset Password: " + input[0];
				username = input[1];
				emailAddress = input[2];
			}
			type(xpath(userForgotPasswordUsername), username);
			type(xpath(userForgotPasswordEmailAddress), emailAddress);
			click(xpath(userResetPasswordBtn));
		}
		


}
