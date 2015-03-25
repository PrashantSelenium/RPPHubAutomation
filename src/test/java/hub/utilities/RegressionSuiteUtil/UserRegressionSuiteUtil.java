package hub.utilities.RegressionSuiteUtil;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.thoughtworks.selenium.Selenium;

public class UserRegressionSuiteUtil extends FunctionReference {
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	//private String[] input = null;
	public Selenium selenium;
	
	public UserRegressionSuiteUtil(String[] i) {
		//input = i;
	}
	
	public UserRegressionSuiteUtil() {
	}
	
		//enviroment list
		//Stage = https://stage-
		//Dev = https://dev-
		//Production = https://www.
		
		public String environment = "https://stage-";
	
	public void BranchIDvalidation() throws Exception{
		
		//getDataFromxls(0, "User_Registration.xls", 0, 0);
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
	    	Assert.assertTrue(isElementPresent(xpath(staffIDReg)), "Staff ID not visible");	
	    	Assert.assertTrue(isElementPresent(xpath(branchIDReg)), "Branch ID not visible");	
	    	Assert.assertTrue(isElementPresent(xpath(bodyIDReg)), "Body ID not visible");	
	}
	
	public void ConfirmPasswordMinChar() throws Exception{
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		type(xpath(confirmPasswordReg), getDataFromxls(0, "User_Registration.xls", 1, 0));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		String styleval = driver.findElement(By.xpath(signUpErrorConfirmEmailNotMatch)).getAttribute("style");
		Assert.assertEquals(styleval, "display: block;", "Password not match is not displayed");
		Assert.assertEquals(getText(xpath(signUpErrorConfirmEmailNotMatch)), getDataFromxls(0, "User_Registration.xls", 1, 0));
    }
	
	public void EmailAddress_Validation() throws Exception{
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		type(xpath(emailReg), getDataFromxls(0, "User_Registration.xls", 1, 1));
		type(xpath(confirmEmailReg), getDataFromxls(0, "User_Registration.xls", 2, 1));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		String styleval = driver.findElement(By.xpath(signUpErrorEmailNotMatch)).getAttribute("style");
		Assert.assertFalse(styleval.contains("display: none;"), "Email not match is not displayed");
		Assert.assertEquals(getText(xpath(signUpErrorEmailNotMatch)), getDataFromxls(0, "User_Registration.xls", 3, 1));
    }
	
	public void validation_messages() throws Exception{
		
		driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/signup"));
		waitForElementPresent(xpath(firstNameReg));
		waitForElementVisible(xpath(firstNameReg));
		if(!isElementPresent(xpath(firstNameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(firstNameReg))){ Thread.sleep(2000); }
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(firstNameReg));
		waitForElementVisible(xpath(firstNameReg));
		if(!isElementPresent(xpath(firstNameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(firstNameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorFN)), getDataFromxls(0, "User_Registration.xls", 1, 2), "First name - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorLN)), getDataFromxls(0, "User_Registration.xls", 2, 2), "Last name - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorStaffId)), getDataFromxls(0, "User_Registration.xls", 3, 2), "Staff ID - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorUserRole)), getDataFromxls(0, "User_Registration.xls", 4, 2), "User Role - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorEmail)), getDataFromxls(0, "User_Registration.xls", 5, 2), "Email - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorConfirmEmail)), getDataFromxls(0, "User_Registration.xls", 6, 2), "Confirm Email - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorPhone)), getDataFromxls(0, "User_Registration.xls", 7, 2), "Phone - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorUsername)), getDataFromxls(0, "User_Registration.xls", 8, 2), "Username - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorPassword)), getDataFromxls(0, "User_Registration.xls", 9, 2), "Password - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorConfirmPass)), getDataFromxls(0, "User_Registration.xls", 10, 2), "Confirm Password - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorSecurityQuestion)), getDataFromxls(0, "User_Registration.xls", 11, 2), "Security Question - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorSecurityAnswer)), getDataFromxls(0, "User_Registration.xls", 12, 2), "Security Answer - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorTermsnConditions)), getDataFromxls(0, "User_Registration.xls", 13, 2), "Terms and Conditions - incorrect or no validation message");
		Assert.assertEquals(getText(xpath(signUpErrorCaptcha)), getDataFromxls(0, "User_Registration.xls", 14, 2), "Validation Code - incorrect or no validation message");
    }
	
	public void EmailAddress_FormatValidation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/signup"));
		}
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		type(xpath(emailReg), getDataFromxls(0, "User_Registration.xls", 1,3));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_Registration.xls", 6, 3));
		
		type(xpath(emailReg), getDataFromxls(0, "User_Registration.xls", 2,3));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_Registration.xls", 6, 3));
		type(xpath(emailReg), getDataFromxls(0, "User_Registration.xls", 3,3));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_Registration.xls", 6, 3));
		
		type(xpath(emailReg), getDataFromxls(0, "User_Registration.xls", 4,3));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_Registration.xls", 6, 3));
		
		type(xpath(emailReg), getDataFromxls(0, "User_Registration.xls", 5,3));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_Registration.xls", 6, 3));
	}

	public void Registration_InitialDisplay() throws Exception{
		
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/signup"));
		}
		
		Assert.assertTrue(isElementPresent(xpath(leftLogoReg)));
		Assert.assertTrue(isElementPresent(xpath(rightLogoReg)));
		Assert.assertTrue(isElementPresent(xpath(poweredByBar)));
		Assert.assertTrue(URL.contains("https"));
	}
	
	public void TermsAndCondition_Validation() throws Exception{
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorTermsnConditions)), getDataFromxls(0, "User_Registration.xls", 1, 4));
	}
	
	public void Duplicate_Username() throws Exception{
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		type(xpath(usernameReg), getDataFromxls(0, "User_Registration.xls", 1, 5));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(suggestion1)), getDataFromxls(0, "User_Registration.xls", 2, 5));
		Assert.assertEquals(getText(xpath(suggestion2)), getDataFromxls(0, "User_Registration.xls", 3, 5));
		Assert.assertEquals(getText(xpath(suggestion3)), getDataFromxls(0, "User_Registration.xls", 4, 5));
	}
	
	public void EmailAddress_Suffix_Disabled() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/signup"));
		}
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertFalse(isElementPresent(xpath(emailsuffix)), "Suffix for email address is enabled");
	}
	
	public void EmailAddress_Suffix_Enabled() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/signup"));
		}
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(emailsuffix)), "Suffix for email address is Disabled");
	}
	
	public void UserRole_Dropdown_validation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/signup"));
		}
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		driver.findElement(By.id("userRole")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("userRole")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("userRole")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("userRole")).sendKeys(Keys.ENTER);
		
		Assert.assertEquals(getValue(xpath(userRoleReg)), "14");
	}
	
	public void FirstLastname_char_Limit() throws Exception{
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		type(xpath(firstNameReg), getDataFromxls(0, "User_Registration.xls", 1, 6));
		type(xpath(lastNameReg), getDataFromxls(0, "User_Registration.xls", 2, 6));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getValue(xpath(firstNameReg)), getDataFromxls(0, "User_Registration.xls", 3, 6));
		Assert.assertEquals(getValue(xpath(lastNameReg)), getDataFromxls(0, "User_Registration.xls", 3, 6));
		
	}
	
	public void Phone_Mobile_validation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/signup"));
		}
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		type(xpath(phoneReg), getDataFromxls(0, "User_Registration.xls", 1, 7));
		type(xpath(mobileReg), getDataFromxls(0, "User_Registration.xls", 1, 7));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorMobileInvalid)), getDataFromxls(0, "User_Registration.xls", 3, 7));
		Assert.assertEquals(getText(xpath(signUpErrorPhoneInvalid)), getDataFromxls(0, "User_Registration.xls", 4, 7));
		
		type(xpath(phoneReg), getDataFromxls(0, "User_Registration.xls", 2, 7));
		type(xpath(mobileReg), getDataFromxls(0, "User_Registration.xls", 2, 7));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorMobileInvalid)), getDataFromxls(0, "User_Registration.xls", 3, 7));
		Assert.assertEquals(getText(xpath(signUpErrorPhoneInvalid)), getDataFromxls(0, "User_Registration.xls", 4, 7));
			
	}
	public void Password_Min_Char() throws Exception{
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		type(xpath(passwordReg), getDataFromxls(0, "User_Registration.xls", 1, 8));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorPasswordMinChar)), getDataFromxls(0, "User_Registration.xls", 2, 8));
		}
	
	public void Special_Char_Usage() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/signup"));
		}
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		type(xpath(emailReg), getDataFromxls(0, "User_Registration.xls", 1, 9));
		type(xpath(confirmEmailReg), getDataFromxls(0, "User_Registration.xls", 1, 9));
		type(xpath(phoneReg), getDataFromxls(0, "User_Registration.xls", 1, 9));
		type(xpath(mobileReg), getDataFromxls(0, "User_Registration.xls", 1, 9));
		type(xpath(usernameReg), getDataFromxls(0, "User_Registration.xls", 1, 9));
		type(xpath(validationCodeReg), getDataFromxls(0, "User_Registration.xls", 1, 9));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_Registration.xls", 2, 9));		
		Assert.assertEquals(getText(xpath(signUpErrorMobile)), getDataFromxls(0, "User_Registration.xls", 3, 9));
		Assert.assertEquals(getText(xpath(signUpErrorPhone)), getDataFromxls(0, "User_Registration.xls", 4, 9));
		Assert.assertEquals(getText(xpath(signUpErrorUsernameSymbol)), getDataFromxls(0, "User_Registration.xls", 5, 9));
		Assert.assertEquals(getText(xpath(signUpErrorCaptchaValidation)), getDataFromxls(0, "User_Registration.xls", 6, 9));
		}
	
	public void Link_Navigation() throws Exception{
		
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		click(xpath(contactUs));
		Assert.assertTrue(isElementPresent(xpath(contactUsName)));
		driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
		click(xpath(feedback));
		Assert.assertTrue(isElementPresent(xpath(feedbackName)));
		driver.findElement(By.id("feedbackName")).sendKeys(Keys.ESCAPE);
	}
	
	public void Validation_code_error() throws Exception{
		
		waitForElementPresent(xpath(staffIDReg));
		waitForElementVisible(xpath(staffIDReg));
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(staffIDReg))){ Thread.sleep(2000); }
		
		type(xpath(validationCodeReg), getDataFromxls(0, "User_Registration.xls", 1, 10));
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorCaptchaValidation)), getDataFromxls(0, "User_Registration.xls", 3, 10));
		
		click(xpath(doneBTNReg));
		waitForElementPresent(xpath(usernameReg));
		waitForElementVisible(xpath(usernameReg));
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(usernameReg))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorCaptcha)), getDataFromxls(0, "User_Registration.xls", 2, 10));
	}

	public void Login_Validation() throws Exception{
	
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		Assert.assertEquals(getText(xpath(loginMandatoryFields)), getDataFromxls(0, "User_Login.xls", 4, 0), "Empty Username and Password");
		Assert.assertEquals(getText(xpath(loginNotEmpty)), getDataFromxls(0, "User_Login.xls", 1, 0), "Empty Username and Password");
		
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 3, 0));
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		Assert.assertEquals(getText(xpath(loginMandatoryFields)), getDataFromxls(0, "User_Login.xls", 4, 0), "Empty Username and valid Password");
		Assert.assertEquals(getText(xpath(loginNotEmpty)), getDataFromxls(0, "User_Login.xls", 1, 0), "Empty Username and valid Password");
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 2, 0));
		type(xpath(userLoginPassword), "");
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		Assert.assertEquals(getText(xpath(loginMandatoryFields)), getDataFromxls(0, "User_Login.xls", 4, 0), "Valid Username and empty Password");
		Assert.assertEquals(getText(xpath(loginNotEmpty)), getDataFromxls(0, "User_Login.xls", 1, 0), "Valid Username and empty Password");

		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 5, 0));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 6, 0));
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		Assert.assertEquals(getText(xpath(invalidErrorMessage)), getDataFromxls(0, "User_Login.xls", 7, 0), "Invalid Username and Password");
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 2, 0));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 6, 0));
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		Assert.assertEquals(getText(xpath(invalidErrorMessage)), getDataFromxls(0, "User_Login.xls", 7, 0), "Valid Username and invalid Password");
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 5, 0));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 3, 0));
		click(xpath(loginButton));
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		Assert.assertEquals(getText(xpath(invalidErrorMessage)), getDataFromxls(0, "User_Login.xls", 7, 0), "Invalid Username and valid Password");
	}
	
	public void Login_InitialDisplay() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		}
		
		Assert.assertTrue(isElementPresent(xpath(leftLogoReg)));
		Assert.assertTrue(isElementPresent(xpath(rightLogoReg)));
		Assert.assertTrue(isElementPresent(xpath(poweredByBar)));
		Assert.assertTrue(URL.contains("https"));
	}	
	
	public void Login_Security() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		Assert.assertTrue(URL.contains("https"));
	}	
	
	public void Successful_login() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		}
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 1, 1));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 2, 1));
		click(xpath(loginButton));

		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		
		Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
	}
	
	public void Successful_login_CBALender() throws Exception{
		
		
		driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 1, 1));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 2, 1));
		click(xpath(loginButton));

		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		
		Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
	}

	public void Logout_link() throws Exception{
		
		click(xpath(userLogoutLink));
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(userLoginUsername)), "Logout not Successful");
	}
	public void Register_New_Account_Button() throws Exception{

		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		
		click(xpath(registerButton));
		waitForElementPresent(xpath(firstNameReg));
		waitForElementVisible(xpath(firstNameReg));
		if(!isElementPresent(xpath(firstNameReg))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(firstNameReg))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(firstNameReg)), "Register New Account button not Functioning");
		driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
	}
	
	public void Cancel_button_validation() throws Exception{
		
		Successful_login();
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Thread.sleep(1000);
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		type(xpath(myAccountFN), getDataFromxls(0, "User_MyAccount.xls", 1, 0));
		type(xpath(myAccountLN), getDataFromxls(0, "User_MyAccount.xls", 2, 0));
		click(xpath(myAccountCancelBtn));
		
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getValue(xpath(myAccountFN)), getDataFromxls(0, "User_MyAccount.xls", 3, 0));
		Assert.assertEquals(getValue(xpath(myAccountLN)), getDataFromxls(0, "User_MyAccount.xls", 4, 0));
	}
	
	public void MyAccount_SpecialChar_Validation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("login")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		type(xpath(myAccountFN), getDataFromxls(0, "User_MyAccount.xls", 6, 1));
		type(xpath(myAccountLN), getDataFromxls(0, "User_MyAccount.xls", 6, 1));
		type(xpath(myAccountSecurityQuestion), getDataFromxls(0, "User_MyAccount.xls", 6, 1));
		type(xpath(myAccountSecurityAnswer), getDataFromxls(0, "User_MyAccount.xls", 6, 1));
		type(xpath(myAccountStaffId), getDataFromxls(0, "User_MyAccount.xls", 6, 1));
		type(xpath(myAccountBranchId), getDataFromxls(0, "User_MyAccount.xls", 6, 1));
		click(xpath(myAccountSavebtn));
		
		waitForElementPresent(xpath(myAccountDialogBoxOK));
		waitForElementVisible(xpath(myAccountDialogBoxOK));
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "Save not Successful - Special Character");
		click(xpath(myAccountDialogBoxOK));
		
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		type(xpath(myAccountFN), getDataFromxls(0, "User_MyAccount.xls", 1, 1));
		type(xpath(myAccountLN), getDataFromxls(0, "User_MyAccount.xls", 2, 1));
		type(xpath(myAccountSecurityQuestion), getDataFromxls(0, "User_MyAccount.xls", 3, 1));
		type(xpath(myAccountSecurityAnswer), getDataFromxls(0, "User_MyAccount.xls", 4, 1));
		type(xpath(myAccountStaffId), getDataFromxls(0, "User_MyAccount.xls", 5, 1));
		type(xpath(myAccountBranchId), getDataFromxls(0, "User_MyAccount.xls", 5, 1));
		click(xpath(myAccountSavebtn));
		
		waitForElementPresent(xpath(myAccountDialogBoxOK));
		waitForElementVisible(xpath(myAccountDialogBoxOK));
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "Save not Successful - Special Character");
		click(xpath(myAccountDialogBoxOK));
	}
	
	public void MyAccount_Field_Label() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("login")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelFN)), "First Name not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelLN)), "Last Name not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelEmail)), "Email not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelMobile)), "Mobile not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelPhone)), "Phone not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelUsername)), "Usrename not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelNewPassword)), "New Password not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelConfirmPassword)), "Confirm Password not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelSecQuestion)), "Security Question not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelSecAnswer)), "Security Answer not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelStaffID)), "Staff ID not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelBranchID)), "Branch ID not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelBodyID)), "Body ID not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelUserRole)), "User Role not Displayed Properly");		
	}
	
	public void Blank_FirstLast_position() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("login")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		type(xpath(myAccountFN), getDataFromxls(0, "User_MyAccount.xls", 1, 2));
		type(xpath(myAccountLN), getDataFromxls(0, "User_MyAccount.xls", 2, 2));
		type(xpath(myAccountStaffId), getDataFromxls(0, "User_MyAccount.xls", 3, 2));
		click(xpath(myAccountSavebtn));
		
		waitForElementPresent(xpath(myAccountDialogBoxOK));
		waitForElementVisible(xpath(myAccountDialogBoxOK));
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "Save not Successful - Special Character");
		click(xpath(myAccountDialogBoxOK));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getValue(xpath(myAccountFN)), getDataFromxls(0, "User_MyAccount.xls", 4, 2), "First Name Space not removed");
		Assert.assertEquals(getValue(xpath(myAccountLN)), getDataFromxls(0, "User_MyAccount.xls", 5, 2), "Last Name Space not removed");
		Assert.assertEquals(getValue(xpath(myAccountStaffId)), getDataFromxls(0, "User_MyAccount.xls", 6, 2), "Staff ID Name Space not removed");
	}
	
	public void MyAccount_Required_Fields_Asterisk() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("login")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		
		Assert.assertTrue(getText(xpath(myAccountLabelFN)).contains("*"), "First Name not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelLN)).contains("*"), "Last Name not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelEmail)).contains("*"), "Email not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelMobile)).contains("*"), "Mobile not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelPhone)).contains("*"), "Phone not Displayed Properly");
		Assert.assertFalse(getText(xpath(myAccountLabelNewPassword)).contains("*"), "New Password not Displayed Properly");
		Assert.assertFalse(getText(xpath(myAccountLabelConfirmPassword)).contains("*"), "Confirm Password not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelSecQuestion)).contains("*"), "Security Question not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelSecAnswer)).contains("*"), "Security Answer not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelStaffID)).contains("*"), "Staff ID not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelBranchID)).contains("*"), "Branch ID not Displayed Properly");
		Assert.assertFalse(getText(xpath(myAccountLabelBodyID)).contains("*"), "Body ID not Displayed Properly");
		Assert.assertTrue(getText(xpath(myAccountLabelUserRole)).contains("*"), "User Role not Displayed Properly");
		
		type(xpath(myAccountFN), "");
		Thread.sleep(300);
		type(xpath(myAccountLN), "");
		Thread.sleep(300);
		type(xpath(myAccountEmail), "");
		Thread.sleep(300);
		type(xpath(myAccountMobile), "");
		Thread.sleep(300);
		type(xpath(myAccountPhone), "");
		Thread.sleep(300);
 		type(xpath(myAccountUsername), "");
 		Thread.sleep(300);
		type(xpath(myAccountSecurityQuestion), "");
		Thread.sleep(300);
		type(xpath(myAccountSecurityAnswer), "");
		Thread.sleep(300);
		type(xpath(myAccountStaffId), "");
		Thread.sleep(300);
		type(xpath(myAccountBranchId), "");
		Thread.sleep(300);
		type(xpath(bodyIDReg), "");
		Thread.sleep(300);
		driver.findElement(By.id("userRole")).sendKeys(Keys.UP);
		driver.findElement(By.id("userRole")).sendKeys(Keys.UP);
		driver.findElement(By.id("userRole")).sendKeys(Keys.UP);
		driver.findElement(By.id("userRole")).sendKeys(Keys.UP);
		driver.findElement(By.id("userRole")).sendKeys(Keys.UP);
		driver.findElement(By.id("userRole")).sendKeys(Keys.UP);
		driver.findElement(By.id("userRole")).sendKeys(Keys.ENTER);
		click(xpath(myAccountSavebtn));
		
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(signUpErrorFN)), "First Name error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(signUpErrorLN)), "Last Name error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(signUpErrorEmail)), "Email error not Displayed Properly");
		//Assert.assertTrue(isElementPresent(xpath(signUpErrorMobile)), "Mobile error not Displayed Properly");
		//Assert.assertTrue(isElementPresent(xpath(signUpErrorPhone)), "Phone error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(signUpErrorUsername)), "Username error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelNewPassword)), "New Password error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountLabelConfirmPassword)), "Confirm Password error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(signUpErrorSecurityQuestion)), "Security Question error not Displayed Properly");
		//Assert.assertTrue(isElementPresent(xpath(signUpErrorSecurityAnswer)), "Security Answer error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountErrorStaffId)), "Staff ID error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(myAccountErrorBranchId)), "Branch ID error not Displayed Properly");
		Assert.assertFalse(isElementPresent(xpath(signUpErrorProfId)), "Body ID error not Displayed Properly");
		Assert.assertTrue(isElementPresent(xpath(signUpErrorUserRole)), "User Role error not Displayed Properly");
	}
	
	public void MyAccount_Security_Validation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("login")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		String URL2 = driver.getCurrentUrl();
		Assert.assertTrue(URL2.contains("https"), "URL does not uses HTTPS");
	}
	
	public void MyAccount_Save_Successfully() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("login")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Thread.sleep(1000);
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		type(xpath(myAccountFN), getDataFromxls(0, "User_MyAccount.xls", 6, 3));
		type(xpath(myAccountLN), getDataFromxls(0, "User_MyAccount.xls", 6, 3));
		type(xpath(myAccountSecurityQuestion), getDataFromxls(0, "User_MyAccount.xls", 6, 3));
		type(xpath(myAccountSecurityAnswer), getDataFromxls(0, "User_MyAccount.xls", 6, 3));
		type(xpath(myAccountStaffId), getDataFromxls(0, "User_MyAccount.xls", 6, 3));
		type(xpath(myAccountBranchId), getDataFromxls(0, "User_MyAccount.xls", 6, 3));
		click(xpath(myAccountSavebtn));
		
		waitForElementPresent(xpath(myAccountDialogBoxOK));
		waitForElementVisible(xpath(myAccountDialogBoxOK));
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "Save not Successful - Special Character");
		click(xpath(myAccountDialogBoxOK));
		Thread.sleep(1000);
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		type(xpath(myAccountFN), getDataFromxls(0, "User_MyAccount.xls", 1, 3));
		type(xpath(myAccountLN), getDataFromxls(0, "User_MyAccount.xls", 2, 3));
		type(xpath(myAccountSecurityQuestion), getDataFromxls(0, "User_MyAccount.xls", 3, 3));
		type(xpath(myAccountSecurityAnswer), getDataFromxls(0, "User_MyAccount.xls", 4, 3));
		type(xpath(myAccountStaffId), getDataFromxls(0, "User_MyAccount.xls", 5, 3));
		type(xpath(myAccountBranchId), getDataFromxls(0, "User_MyAccount.xls", 5, 3));
		click(xpath(myAccountSavebtn));
		
		waitForElementPresent(xpath(myAccountDialogBoxOK));
		waitForElementVisible(xpath(myAccountDialogBoxOK));
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "Save not Successful - Special Character");
		click(xpath(myAccountDialogBoxOK));
		Thread.sleep(1000);
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Assert.assertEquals(getValue(xpath(myAccountFN)), getDataFromxls(0, "User_MyAccount.xls", 1, 3), "First Name");
		Assert.assertEquals(getValue(xpath(myAccountLN)), getDataFromxls(0, "User_MyAccount.xls", 2, 3), "Last Name");
		Assert.assertEquals(getValue(xpath(myAccountSecurityQuestion)), getDataFromxls(0, "User_MyAccount.xls", 3, 3), "Security Question");
		Assert.assertEquals(getValue(xpath(myAccountSecurityAnswer)), getDataFromxls(0, "User_MyAccount.xls", 4, 3), "Security Answer");
		Assert.assertEquals(getValue(xpath(myAccountStaffId)), getDataFromxls(0, "User_MyAccount.xls", 5, 3), "Staff ID");
		Assert.assertEquals(getValue(xpath(myAccountBranchId)), getDataFromxls(0, "User_MyAccount.xls", 5, 3), "Branch ID");
	}
	
	public void MyAccount_Navigation_CBALender() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		URL = driver.getCurrentUrl();
		if(!URL.contains("login")){
			Logout_link();
		}
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
		
		type(xpath(userLoginUsername), getDataFromxls(0, "User_MyAccount.xls", 1, 4));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_MyAccount.xls", 2, 4));
		click(xpath(loginButton));

		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		
		Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
	}
	
	public void MyAccount_Logout_Link() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("login")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		Logout_link();
	}
	
	public void MyAccount_Link_Navigation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		}
		
		String URL2 = driver.getCurrentUrl();
		if(URL2.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		
		Link_Navigation();
		Registration_InitialDisplay();
	}
	
	public void MyAccount_Shift_ShiftTab_keys() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)), "My Account button not Functioning");
		driver.findElement(xpath(myAccountFN));
		Assert.assertTrue(driver.findElement(xpath(myAccountFN)).isSelected());
		driver.findElement(By.id("firstName")).sendKeys(Keys.TAB);
		Assert.assertTrue(driver.findElement(xpath(myAccountLN)).isSelected());
	}
	
	public void MyAccount_EmailAddress_FormatValidation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		type(xpath(emailReg), getDataFromxls(0, "User_MyAccount.xls", 1,5));
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_MyAccount.xls", 6, 5));
		
		type(xpath(emailReg), getDataFromxls(0, "User_MyAccount.xls", 2,5));
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_MyAccount.xls", 6, 5));
		type(xpath(emailReg), getDataFromxls(0, "User_MyAccount.xls", 3,5));
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_MyAccount.xls", 6, 5));
		
		type(xpath(emailReg), getDataFromxls(0, "User_MyAccount.xls", 4,5));
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_MyAccount.xls", 6, 5));
		
		type(xpath(emailReg), getDataFromxls(0, "User_MyAccount.xls", 5,5));
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_MyAccount.xls", 6, 5));
	}
	
	public void MyAccount_Branch_ID_Not_Null() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertEquals(getValue(xpath(myAccountBranchId)), getDataFromxls(0, "User_MyAccount.xls", 1, 6));
	}
	
	public void MyAccount_BranchIDvalidation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
	    	Assert.assertTrue(isElementPresent(xpath(myAccountStaffId)), "Staff ID not visible");	
	    	Assert.assertTrue(isElementPresent(xpath(myAccountBranchId)), "Branch ID not visible");	
	    	Assert.assertTrue(isElementPresent(xpath(myAccountProfId)), "Body ID not visible");	
	}
	
	public void MyAccount_Unable_To_Save_Twice() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		click(xpath(myAccountSavebtn));
	    	Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "DialogBox not visible");	
	}
	
	public void MyAccount_Phone_Mobile_validation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
			
			type(xpath(myAccountMobile), getDataFromxls(0, "User_MyAccount.xls", 1, 7));
			type(xpath(myAccountPhone), getDataFromxls(0, "User_MyAccount.xls", 1, 7));
			click(xpath(myAccountSavebtn));
			waitForElementPresent(xpath(myAccountFN));
			waitForElementVisible(xpath(myAccountFN));
			if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
			
			Assert.assertEquals(getText(xpath(signUpErrorMobileInvalid)), getDataFromxls(0, "User_MyAccount.xls", 3, 7), "Incorrect Mobile validation message");
			Assert.assertEquals(getText(xpath(signUpErrorPhoneInvalid)), getDataFromxls(0, "User_MyAccount.xls", 4, 7), "Incorrect Phone validation message");
			
			type(xpath(phoneReg), getDataFromxls(0, "User_MyAccount.xls", 2, 7));
			type(xpath(mobileReg), getDataFromxls(0, "User_MyAccount.xls", 2, 7));
			click(xpath(myAccountSavebtn));
			waitForElementPresent(xpath(myAccountFN));
			waitForElementVisible(xpath(myAccountFN));
			if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
			
			Assert.assertEquals(getText(xpath(signUpErrorMobileInvalid)), getDataFromxls(0, "User_MyAccount.xls", 3, 7), "Incorrect Mobile validation message");
			Assert.assertEquals(getText(xpath(signUpErrorPhoneInvalid)), getDataFromxls(0, "User_MyAccount.xls", 4, 7), "Incorrect Phone validation message");
			
	}

	public void MyAccount_EmailAddress_Suffix_Disabled() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		}
		
		String URL2 = driver.getCurrentUrl();
		if(URL2.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertFalse(isElementPresent(xpath(emailsuffix)), "Suffix for email address is enabled");
	}
	
	public void MyAccount_EmailAddress_Suffix_Enabled() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		
		String URL2 = driver.getCurrentUrl();
		if(URL2.contains("ogin")){
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
			
			type(xpath(userLoginUsername), getDataFromxls(0, "User_MyAccount.xls", 1, 8));
			type(xpath(userLoginPassword), getDataFromxls(0, "User_MyAccount.xls", 2, 8));
			click(xpath(loginButton));

			waitForElementPresent(xpath(propertySearch));
			waitForElementVisible(xpath(propertySearch));
			if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
			if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(emailsuffix)), "Suffix for email address is Disabled");
	}
	
	public void MyAccount_EmailAddress_Suffix_Enabled_Invalid_message() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		
		String URL2 = driver.getCurrentUrl();
		if(URL2.contains("ogin")){
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(3000); }
			
			type(xpath(userLoginUsername), getDataFromxls(0, "User_MyAccount.xls", 1, 9));
			type(xpath(userLoginPassword), getDataFromxls(0, "User_MyAccount.xls", 2, 9));
			click(xpath(loginButton));

			waitForElementPresent(xpath(propertySearch));
			waitForElementVisible(xpath(propertySearch));
			if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
			if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(3000); }
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(emailsuffix)), "Suffix for email address is Disabled");
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Assert.assertEquals(getText(xpath(signUpErrorEmailInvalidInput)), getDataFromxls(0, "User_MyAccount.xls", 3, 9), "Incorrect Email validation message");
	}
	
	public void MyAccount_Password_Validation() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		}
		
		String URL2 = driver.getCurrentUrl();
		if(URL2.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Thread.sleep(500);
		type(xpath(myAccountPassword), getDataFromxls(0, "User_MyAccount.xls", 1, 10));
		type(xpath(myAccountConfirmPassword), getDataFromxls(0, "User_MyAccount.xls", 2, 10));
		
		click(xpath(myAccountSavebtn));
		Assert.assertEquals(getText(xpath(myAccountErrorPasswordNotMatch)), getDataFromxls(0, "User_MyAccount.xls", 3, 10), "Incorrect Password not Match validation message");
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Thread.sleep(500);
		type(xpath(myAccountPassword), getDataFromxls(0, "User_MyAccount.xls", 1, 10));
		type(xpath(myAccountConfirmPassword), getDataFromxls(0, "User_MyAccount.xls", 1, 10));
		
		click(xpath(myAccountSavebtn));
	    Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "DialogBox not visible");	
	}
	
	public void Previous_Username_Can_Be_Use() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		}
		
		String URL2 = driver.getCurrentUrl();
		if(URL2.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		type(xpath(myAccountUsername), getDataFromxls(0, "User_MyAccount.xls", 2, 11));
		
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountDialogBoxOK));
		waitForElementVisible(xpath(myAccountDialogBoxOK));
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "DialogBox not visible");	
		
		click(xpath(myAccountDialogBoxOK));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Thread.sleep(1000);
		type(xpath(myAccountUsername), getDataFromxls(0, "User_MyAccount.xls", 1, 11));
		click(xpath(myAccountSavebtn));
		waitForElementPresent(xpath(myAccountDialogBoxOK));
		waitForElementVisible(xpath(myAccountDialogBoxOK));
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountDialogBoxOK))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(myAccountDialogBoxOK)), "DialogBox not visible");	
	}
	
	public void MyAccount_Duplicate_Username() throws Exception{
		
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		}
		
		String URL2 = driver.getCurrentUrl();
		if(URL2.contains("ogin")){
			Successful_login();
		}
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		type(xpath(myAccountUsername), getDataFromxls(0, "User_MyAccount.xls", 1, 12));
		
		click(xpath(myAccountSavebtn));
		
		Assert.assertTrue(isElementPresent(xpath(myAccountSuggestion1)));	
		Assert.assertTrue(isElementPresent(xpath(myAccountSuggestion2)));	
		Assert.assertTrue(isElementPresent(xpath(myAccountSuggestion3)));	
	}
	
	public void Close_Button_Validation() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsClosebtn)));	
	}
	
	public void Invalid_Contact_Number() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));		
		type(xpath(contactUsContactNumber), getDataFromxls(0, "User_ContactUs.xls", 1, 0));		
		click(xpath(contactUsSendEnquiry));
		Assert.assertEquals(getText(xpath(contactUsInvalidContactNumber)), getDataFromxls(0, "User_ContactUs.xls", 2, 0), "Incorrect Contact Number validation message");
	}
	
	public void Field_Cannot_Be_Empty() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));		

		click(xpath(contactUsSendEnquiry));
		click(xpath(contactUsSendEnquiry));
		
		Assert.assertEquals(getText(xpath(contactUsNameFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 1), "Incorrect Name validation message");
		Assert.assertEquals(getText(xpath(contactUsEmailFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 1), "Incorrect Email validation message");
		Assert.assertEquals(getText(xpath(contactUsPropertyAddressFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 1), "Incorrect Property Address validation message");
		Assert.assertEquals(getText(xpath(contactUsContactNumberFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 1), "Incorrect Contact Number validation message");
		Assert.assertEquals(getText(xpath(contactUsContactNotesFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 1), "Incorrect Contact Notes validation message");
		
	}
	
	public void Validation_Message() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));		

		click(xpath(contactUsSendEnquiry));
		click(xpath(contactUsSendEnquiry));
		
		Assert.assertEquals(getText(xpath(contactUsNameFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 2), "Incorrect Name validation message");
		Assert.assertEquals(getText(xpath(contactUsEmailFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 2), "Incorrect Email validation message");
		Assert.assertEquals(getText(xpath(contactUsPropertyAddressFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 2), "Incorrect Property Address validation message");
		Assert.assertEquals(getText(xpath(contactUsContactNumberFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 2), "Incorrect Contact Number validation message");
		Assert.assertEquals(getText(xpath(contactUsContactNotesFieldRequiredError)), getDataFromxls(0, "User_ContactUs.xls", 1, 2), "Incorrect Contact Notes validation message");
		Assert.assertEquals(getText(xpath(contactUsUrgentMatterChooseOneError)), getDataFromxls(0, "User_ContactUs.xls", 2, 2), "Incorrect Urgent Matter validation message");
		
		String color = driver.findElement(By.xpath(contactUsUrgentMatterChooseOneError)).getCssValue("color");
		Assert.assertEquals(color, getDataFromxls(0, "User_ContactUs.xls", 3, 2), "Incorrect Font Color");
	}
	
	public void Validation_Asterisk() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));		
	
		Assert.assertTrue(getText(xpath(contactUsNameLabel)).contains("*"), "Asterisk Missing - Name");
		Assert.assertTrue(getText(xpath(contactUsPropertyAddressLabel)).contains("*"), "Asterisk Missing - Property Address");
		Assert.assertTrue(getText(xpath(contactUsUrgentMatterLabel)).contains("*"), "Asterisk Missing - Urgent Matter");
		Assert.assertTrue(getText(xpath(contactUsContactNotesLabel)).contains("*"), "Asterisk Missing - Contact Notes");
		Assert.assertTrue(getText(xpath(contactUsEmailLabel)).contains("*"), "Asterisk Missing - Email");
		Assert.assertTrue(getText(xpath(contactUsContactNumberLabel)).contains("*"), "Asterisk Missing - Contact Number");
		
	}
	
	public void Close_Contact_Us() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		
		click(xpath(contactUsClosebtn));
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
	}
	
	public void Contact_Us_Link_Modal_Validation() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}

		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		
	}
	
	public void Wheres_My_Reference_Number_Image() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		
		actionType(xpath(contactUsWheresMyRefNumber), "Where's my reference number?");
		click(xpath(contactUsWheresMyRefNumber));

		String styleval = driver.findElement(By.xpath(contactUsWheresMyRefNumberImg)).getAttribute("style");
		Assert.assertTrue(styleval.contains("display: none;"), "Reference Number Not Displayed");
		
	}
	
	public void Send_Inquiry_Color() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		
		String color = driver.findElement(By.xpath(contactUsSendEnquiry)).getCssValue("color");
		Assert.assertEquals(color, getDataFromxls(0, "User_ContactUs.xls", 1, 3), "Incorrect Font Color");
	}
	
	public void Send_Inquiry_Background_Color() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		
		String color = driver.findElement(By.xpath(contactUsSendEnquiry)).getCssValue("background-color");
		Assert.assertEquals(color, getDataFromxls(0, "User_ContactUs.xls", 2, 3), "Incorrect Background Color");		
	}
	
	public void One_Checkbox_only() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		
		click(xpath(contactUsCheckboxYes));
		String styleVal = driver.findElement(By.xpath(contactUsCheckboxNoBut)).getAttribute("disabled");
		Assert.assertEquals(styleVal, "true", "Answer Sometime Today is not disabled");	
		styleVal = driver.findElement(By.xpath(contactUsCheckboxNoGive)).getAttribute("disabled");
		Assert.assertEquals(styleVal, "true", "Next Business Day is not disabled");	
		click(xpath(contactUsCheckboxYes));
		
		click(xpath(contactUsCheckboxNoBut));
		styleVal = driver.findElement(By.xpath(contactUsCheckboxYes)).getAttribute("disabled");
		Assert.assertEquals(styleVal, "true", "Answer ASAP is not disabled");	
		styleVal = driver.findElement(By.xpath(contactUsCheckboxNoGive)).getAttribute("disabled");
		Assert.assertEquals(styleVal, "true", "Next Business Day is not disabled");	
		click(xpath(contactUsCheckboxNoBut));
		
		click(xpath(contactUsCheckboxNoGive));
		styleVal = driver.findElement(By.xpath(contactUsCheckboxYes)).getAttribute("disabled");
		Assert.assertEquals(styleVal, "true", "Answer ASAP is not disabled");	
		styleVal = driver.findElement(By.xpath(contactUsCheckboxNoBut)).getAttribute("disabled");
		Assert.assertEquals(styleVal, "true", "Answer Sometime Today is not disabled");	
		click(xpath(contactUsCheckboxNoGive));
	}
	
	public void Enquiry_Successfully_Sent() throws Exception{
		
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(contactUsName))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		Thread.sleep(500);
		type(xpath(contactUsName), getDataFromxls(0, "User_ContactUs.xls", 1, 4));
		type(xpath(contactUsEmail), getDataFromxls(0, "User_ContactUs.xls", 2, 4));
		type(xpath(contactUsPropertyAddress), getDataFromxls(0, "User_ContactUs.xls", 3, 4));
		type(xpath(contactUsContactNumber), getDataFromxls(0, "User_ContactUs.xls", 4, 4));
		type(xpath(contactUsContactNotes), getDataFromxls(0, "User_ContactUs.xls", 5, 4));
		click(xpath(contactUsCheckboxNoGive));
		click(xpath(contactUsSendEnquiry));
		
		if(!isElementPresent(xpath(contactUsSuccessfullySent))){ Thread.sleep(200); }
		if(!isElementPresent(xpath(contactUsSuccessfullySent))){ Thread.sleep(200); }
		if(!isElementPresent(xpath(contactUsSuccessfullySent))){ Thread.sleep(200); }
		if(!isElementPresent(xpath(contactUsSuccessfullySent))){ Thread.sleep(200); }
		if(!isElementPresent(xpath(contactUsSuccessfullySent))){ Thread.sleep(200); }
		if(!isElementPresent(xpath(contactUsSuccessfullySent))){ Thread.sleep(200); }
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
	}
	
	public void CFA_New_Fields_Validation() throws Exception{
		
		Thread.sleep(2000);
		if(isElementPresent(xpath(contactUsModalBox))){
			driver.findElement(By.id("contactUsName")).sendKeys(Keys.ESCAPE);
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			waitForElement(userLoginUsername);
			waitForElement(userLoginUsername);
			Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
		}
		Thread.sleep(1000);
		click(xpath(contactUs));
		waitForElementPresent(xpath(contactUsName));
		waitForElementVisible(xpath(contactUsName));
		waitForElement(contactUsName);
		Assert.assertTrue(isElementPresent(xpath(contactUsName)));	
		
		click(xpath(contactUsCFABtn));
		Thread.sleep(500);
		Assert.assertTrue(isElementVisible(xpath(contactUsUnitNumberLabel)), "Unit Number Label");
		Assert.assertTrue(isElementVisible(xpath(contactUsStreetNumberLabel)), "Street Number Label");
		Assert.assertTrue(isElementVisible(xpath(contactUsStreetNameLabel)), "Street Name Label");
		Assert.assertTrue(isElementVisible(xpath(contactUsSuburbLabel)), "Suburb Label");
		Assert.assertTrue(isElementVisible(xpath(contactUsStateLabel)), "State Label");
		Assert.assertTrue(isElementVisible(xpath(contactUsPostalCodeLabel)), "Postal Code Label");
		
		Assert.assertFalse(getText(xpath(contactUsUnitNumberLabel)).contains("*"), "Unit Number No Asterisk");
		Assert.assertTrue(getText(xpath(contactUsStreetNumberLabel)).contains("*"), "Street Number with Asterisk");
		Assert.assertTrue(getText(xpath(contactUsStreetNameLabel)).contains("*"), "Street Name with Asterisk");
		Assert.assertTrue(getText(xpath(contactUsSuburbLabel)).contains("*"), "Suburb with Asterisk");
		Assert.assertTrue(getText(xpath(contactUsStateLabel)).contains("*"), "State with Asterisk");
		Assert.assertTrue(getText(xpath(contactUsPostalCodeLabel)).contains("*"), "Postal Code with Asterisk");
		
	}
	
	//CBA MULTI AMV
	public void CBA_Multi_AVM_No_RPID() throws Exception{
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		
		if(URL.contains("ogin")){
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			waitForElement(userLoginUsername);
			type(xpath(userLoginUsername), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 1, 0));
			type(xpath(userLoginPassword), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 2, 0));
			click(xpath(loginButton));
	
			waitForElementPresent(xpath(propertySearch));
			waitForElementVisible(xpath(propertySearch));
			waitForElement(propertySearch);
			Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
		}else{
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/propertysearch"));
		}
		
		waitForElementPresent(xpath(userPropertySearch));
		waitForElementVisible(xpath(userPropertySearch));
		waitForElement(userPropertySearch);
		type(xpath(propertySearch), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 6, 0));
		click(xpath(propertySearchbtn));
		
		waitForElementPresent(xpath(completeAddress));
		waitForElementVisible(xpath(completeAddress));
		Assert.assertEquals(getDataFromxls(0, "User_CBA_Multi_AVM.xls", 3, 0), getText(xpath(completeAddress)));

		if(isElementPresent(xpath(pendingTransaction))){
			click(xpath(pendingTransaction));
			}
		
		waitForElementPresent(xpath(proceedNextLink));
		waitForElementVisible(xpath(proceedNextLink));
		if(!isElementPresent(xpath(proceedNextLink))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(proceedNextLink))){ Thread.sleep(2000); }
		
		click(xpath(proceedNextLink));
		Thread.sleep(3000);
		waitForElementPresent(xpath(productNavBar));
		waitForElementVisible(xpath(productNavBar));
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }
		
			Assert.assertEquals(getDataFromxls(0, "User_CBA_Multi_AVM.xls", 3, 0), getText(xpath(completeAddress)));
		   
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }

			Assert.assertTrue(isElementPresent(xpath(productNavBar)));
			Assert.assertTrue(isElementPresent(xpath(instructionNavBar)));
			Assert.assertTrue(isElementPresent(xpath(paymentNavBar)));
			Assert.assertTrue(isElementPresent(xpath(orderNavBar)));
			
		waitForElementPresent(xpath(purchaseBtn));
		waitForElementVisible(xpath(purchaseBtn));
		if(!isElementPresent(xpath(purchaseBtn))){ Thread.sleep(10000); }
		if(!isElementPresent(xpath(purchaseBtn))){ Thread.sleep(10000); }

			Assert.assertTrue(isElementPresent(xpath(purchaseBtn)));
	
		click(xpath(valuationsTab));
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));
		if(!isElementPresent(xpath(unitPriceValuation))){ Thread.sleep(15000); }
		if(!isElementPresent(xpath(unitPriceValuation))){ Thread.sleep(15000); }	
		Thread.sleep(500);
		type(xpath(unitPriceValuation), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 4, 0));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		Thread.sleep(3000);
		
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));
		if(!isElementPresent(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }	
		if(!isElementPresent(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
			
		Assert.assertEquals(getValue(xpath(CBANotAvailableAVMBtn)), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 5, 0));
	}
	
	public void CBA_Multi_AVM_No_RPID_CFA() throws Exception{
		String URL = driver.getCurrentUrl();
		if(URL.contains("acme")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		
		if(URL.contains("ogin")){
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			waitForElement(userLoginUsername);
			type(xpath(userLoginUsername), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 1, 0));
			type(xpath(userLoginPassword), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 2, 0));
			click(xpath(loginButton));
	
			waitForElementPresent(xpath(propertySearch));
			waitForElementVisible(xpath(propertySearch));
			waitForElement(propertySearch);
			Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
		}else{
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/propertysearch"));
		}
		
		waitForElementPresent(xpath(userCFAButton));
		waitForElementVisible(xpath(userCFAButton));
		waitForElement(userCFAButton);
		click(xpath(userCFAButton));
		waitForElementPresent(xpath(userCFAConfirm));
		waitForElementVisible(xpath(userCFAConfirm));
		waitForElement(userCFAConfirm);
		Thread.sleep(300);
		type(xpath(unitNumberSearchAddress), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 3, 1));
		type(xpath(streetNameSearchAddress), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 4, 1));
		type(xpath(streetTypeSearchAddress), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 5, 1));
		type(xpath(suburbSearchAddress), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 8, 1));
		click(xpath(confirmbtnSearchAddress));

		waitForElementPresent(xpath(completeAddress));
		waitForElementVisible(xpath(completeAddress));
		
		Assert.assertEquals(getDataFromxls(0, "User_CBA_Multi_AVM.xls", 7, 1), getText(xpath(completeAddress)));
		Assert.assertTrue(isElementPresent(xpath(home)));
		Assert.assertTrue(isElementPresent(xpath(myAccount)));
		Assert.assertTrue(isElementPresent(xpath(myTransactions)));
		Assert.assertTrue(isElementPresent(xpath(logout)));
		  
		if(isElementPresent(xpath(pendingTransaction))){
			click(xpath(pendingTransaction));
			}
		
		waitForElementPresent(xpath(proceedNextLink));
		waitForElementVisible(xpath(proceedNextLink));
		if(!isElementPresent(xpath(proceedNextLink))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(proceedNextLink))){ Thread.sleep(2000); }
		
		click(xpath(proceedNextLink));
		Thread.sleep(3000);
		waitForElementPresent(xpath(productNavBar));
		waitForElementVisible(xpath(productNavBar));
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }

			Assert.assertTrue(isElementPresent(xpath(productNavBar)));
			Assert.assertTrue(isElementPresent(xpath(instructionNavBar)));
			Assert.assertTrue(isElementPresent(xpath(paymentNavBar)));
			Assert.assertTrue(isElementPresent(xpath(orderNavBar)));
			
		waitForElementPresent(xpath(purchaseBtn));
		waitForElementVisible(xpath(purchaseBtn));
		if(!isElementPresent(xpath(purchaseBtn))){ Thread.sleep(10000); }
		if(!isElementPresent(xpath(purchaseBtn))){ Thread.sleep(10000); }

			Assert.assertTrue(isElementPresent(xpath(purchaseBtn)));
	
		click(xpath(valuationsTab));
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));
		if(!isElementPresent(xpath(unitPriceValuation))){ Thread.sleep(15000); }
		if(!isElementPresent(xpath(unitPriceValuation))){ Thread.sleep(15000); }	
		Thread.sleep(500);
		type(xpath(unitPriceValuation), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 4, 0));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		Thread.sleep(3000);
		
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));
		if(!isElementPresent(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }	
		if(!isElementPresent(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
			
		Assert.assertEquals(getValue(xpath(CBANotAvailableAVMBtn)), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 5, 0));
	}
	
	public void PropertySearch_Link_Navigation() throws Exception{
		Successful_login();
		Link_Navigation();
		Assert.assertTrue(isElementPresent(xpath(leftLogoReg)));
		Assert.assertTrue(isElementPresent(xpath(rightLogoReg)));
		Assert.assertTrue(isElementPresent(xpath(poweredByBar)));
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(propertySearch)));
		
		click(xpath(myAccount));
		waitForElementPresent(xpath(myAccountFN));
		waitForElementVisible(xpath(myAccountFN));
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(myAccountFN))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(myAccountFN)));
		
		click(xpath(myTransactions));
		Thread.sleep(2000);
		if(isElementVisible(xpath(myTransactionNoTransactionAvail))){
			Assert.assertTrue(isElementPresent(xpath(myTransactionNoTransactionAvail)));
		}
			else{
				Assert.assertTrue(isElementPresent(xpath(customerName)));
			}
	}
	
	public void PropertySearch_HTTPS() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("https"));
	}
	
	public void CFA_Confirm_Button() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Thread.sleep(2000);
		click(xpath(userCFAButton));
		type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 0));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 2, 0));
		type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 3, 0));
		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 4, 0));
		click(xpath(userCFAConfirm));
		
		waitForElementPresent(xpath(userPropertyPhoto));
		waitForElementVisible(xpath(userPropertyPhoto));
		if(!isElementPresent(xpath(userPropertyPhoto))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(userPropertyPhoto))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(userPropertyPhoto)));	
	}
	
	public void CFA_Clear_Button() throws Exception{
	
		click(xpath(changePropertyAddress));
		Thread.sleep(1000);
		if(isElementPresent(xpath(changePropertyPopupOK))){
			click(xpath(changePropertyPopupOK));
			}
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 0));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 2, 0));
		type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 3, 0));
		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 4, 0));
		click(xpath(userCFAClear));
		
		Thread.sleep(1000);
		Assert.assertEquals(getValue(xpath(userCFAUnitNumber)), "");
		Assert.assertEquals(getValue(xpath(userCFAStreetName)), "");
		Assert.assertEquals(getValue(xpath(userCFAStreetType)), "");
		Assert.assertEquals(getValue(xpath(userCFASuburbList)), "");
	}
	
	public void CFA_Back_To_Search_Button() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		
		click(xpath(userCFAButton));
		Thread.sleep(1000);
		click(xpath(userCFABackSearch));
		
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(propertySearch)));
	}
	
	public void CFA_Not_Triggered_No_UnitStreetLot_Number() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 1, 1));
		type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 2, 1));
		
		Thread.sleep(1000);
		Assert.assertEquals(getText(xpath(CFASearchtrigger)), "");
	}
	
	public void CFA_Search_Triggered() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFAStreetNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 2));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 2, 2));
		
		if(getText(xpath(CFASearchtrigger)).isEmpty()){ Thread.sleep(10000); }
		if(getText(xpath(CFASearchtrigger)).isEmpty()){ Thread.sleep(10000); }
		Assert.assertFalse(getText(xpath(CFASearchtrigger)).isEmpty(), "Search 1");
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFALotNumber), getDataFromxls(0, "User_PropertySearch.xls", 3, 2));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 4, 2));
		
		if(getText(xpath(CFASearchtrigger)).isEmpty()){ Thread.sleep(10000); }
		if(getText(xpath(CFASearchtrigger)).isEmpty()){ Thread.sleep(10000); }
		Assert.assertFalse(getText(xpath(CFASearchtrigger)).isEmpty(), "Search 2");
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 5, 2));
		type(xpath(userCFAStreetNumber), getDataFromxls(0, "User_PropertySearch.xls", 6, 2));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 7, 2));
		
		if(getText(xpath(CFASearchtrigger)).isEmpty()){ Thread.sleep(10000); }
		if(getText(xpath(CFASearchtrigger)).isEmpty()){ Thread.sleep(10000); }
		Assert.assertFalse(getText(xpath(CFASearchtrigger)).isEmpty(), "Search 3");
	}
	
	public void CFA_Validation_message() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Thread.sleep(1000);
		click(xpath(userCFAButton));
		Thread.sleep(500);
		click(xpath(userCFAConfirm));
		
		Assert.assertTrue(isElementVisible(xpath(cfaErrorMessageUnitNumber)), "Unit Number");
		Assert.assertTrue(isElementVisible(xpath(cfaErrorMessageStreetName)), "Street Name");
		Assert.assertTrue(isElementVisible(xpath(cfaErrorMessageStreetType)), "Street Type");
		Assert.assertTrue(isElementVisible(xpath(cfaErrorMessageSuburb)), "Suburb");
	}

	public void CBA_Multi_AVM_DB_RPID_Validation() throws Exception{
	
		String URL = driver.getCurrentUrl();
		if(URL.contains("stage")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/login"));
		}
		
		if(URL.contains("ogin")){
			waitForElementPresent(xpath(userLoginUsername));
			waitForElementVisible(xpath(userLoginUsername));
			waitForElement(userLoginUsername);
			type(xpath(userLoginUsername), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 1, 3));
			type(xpath(userLoginPassword), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 2, 3));
			click(xpath(loginButton));
	
			waitForElementPresent(xpath(propertySearch));
			waitForElementVisible(xpath(propertySearch));
			waitForElement(propertySearch);
			Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
		}else{
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/propertysearch"));
		}
		
		waitForElementPresent(xpath(userPropertySearch));
		waitForElementVisible(xpath(userPropertySearch));
		waitForElement(userPropertySearch);
		type(xpath(propertySearch), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 3, 3));
		click(xpath(propertySearchbtn));
		
		waitForElementPresent(xpath(completeAddress));
		waitForElementVisible(xpath(completeAddress));
		Assert.assertTrue(isElementPresent(xpath(completeAddress)));

		if(isElementPresent(xpath(pendingTransaction))){
			click(xpath(pendingTransaction));
			}
		
		waitForElementPresent(xpath(proceedNextLink));
		waitForElementVisible(xpath(proceedNextLink));
		if(!isElementPresent(xpath(proceedNextLink))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(proceedNextLink))){ Thread.sleep(2000); }
		
		click(xpath(proceedNextLink));
		Thread.sleep(3000);
		waitForElementPresent(xpath(productNavBar));
		waitForElementVisible(xpath(productNavBar));
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }
		if(!isElementPresent(xpath(productNavBar))){ Thread.sleep(10000); }

			Assert.assertTrue(isElementPresent(xpath(productNavBar)));
			Assert.assertTrue(isElementPresent(xpath(instructionNavBar)));
			Assert.assertTrue(isElementPresent(xpath(paymentNavBar)));
			Assert.assertTrue(isElementPresent(xpath(orderNavBar)));
			
		waitForElementPresent(xpath(purchaseBtn));
		waitForElementVisible(xpath(purchaseBtn));
		if(!isElementPresent(xpath(purchaseBtn))){ Thread.sleep(10000); }
		if(!isElementPresent(xpath(purchaseBtn))){ Thread.sleep(10000); }

		click(xpath(valuationsTab));
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));
		if(!isElementPresent(xpath(unitPriceValuation))){ Thread.sleep(15000); }
		if(!isElementPresent(xpath(unitPriceValuation))){ Thread.sleep(15000); }	
		Thread.sleep(500);
		type(xpath(unitPriceValuation), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 5, 3));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		Thread.sleep(3000);
		
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));
		if(!isElementPresent(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }	
		if(!isElementPresent(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
			
		driver.navigate().to(environment.concat("rppropertyhub.com/servlet/hubDBTracker"));
		//driver.navigate().to("https://stage.rppropertyhub.com/servlet/hubDBTracker");
		waitForElementPresent(xpath(hubSql));
		waitForElementVisible(xpath(hubSql));
		if(!isElementPresent(xpath(hubSql))){ Thread.sleep(7000); }	
		if(!isElementPresent(xpath(hubSql))){ Thread.sleep(7000); }
		
		type(xpath(hubSql), getDataFromxls(0, "User_CBA_Multi_AVM.xls", 6, 3));
		Thread.sleep(500);
		click(xpath(hubExecuteBtn));
		
		Assert.assertTrue(isElementPresent(xpath(hubLoggerLevel)));
		Assert.assertTrue(isElementPresent(xpath(hubLoggerStatus)));
		Assert.assertTrue(isElementPresent(xpath(hubLoggerResponse)));
		Assert.assertTrue(isElementPresent(xpath(hubLoggerLevel)));	
	}
	
	public void validation_Message_Feedback() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(feedback));
		waitForElementPresent(xpath(feedbackName));
		waitForElementVisible(xpath(feedbackName));
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(feedbackName)));				
		click(xpath(feedbackSendButton));
		
		String styleval = driver.findElement(By.xpath(feedbackerrorMsgName)).getAttribute("style");
		Assert.assertEquals(styleval, "display: block;", "Name validation is not displayed");
		
		styleval = driver.findElement(By.xpath(feedbackerrorMsgEmail)).getAttribute("style");
		Assert.assertEquals(styleval, "display: block;", "Email validation is not displayed");
		
		styleval = driver.findElement(By.xpath(feedbackerrorMsgContactNumber)).getAttribute("style");
		Assert.assertEquals(styleval, "display: block;", "Contact Number validation is not displayed");
		
		styleval = driver.findElement(By.xpath(feedbackerrorMsgNotes)).getAttribute("style");
		Assert.assertEquals(styleval, "display: block;", "Note Validation is not displayed");
		
		
		Assert.assertEquals(getText(xpath(feedbackerrorMsgName)), getDataFromxls(0, "User_Feedback.xls", 1, 0), "Name validation message");
		Assert.assertEquals(getText(xpath(feedbackerrorMsgEmail)), getDataFromxls(0, "User_Feedback.xls", 1, 0), "Email validation message");
		Assert.assertEquals(getText(xpath(feedbackerrorMsgContactNumber)), getDataFromxls(0, "User_Feedback.xls", 1, 0), "Contact validation message");
		Assert.assertEquals(getText(xpath(feedbackerrorMsgNotes)), getDataFromxls(0, "User_Feedback.xls", 1, 0), "Notes validation message");
	}
	
	public void Successfully_Sent_Feedback() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(feedback));
		waitForElementPresent(xpath(feedbackName));
		waitForElementVisible(xpath(feedbackName));
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }
		
		type(xpath(feedbackName), getDataFromxls(0, "User_Feedback.xls", 1, 1));
		type(xpath(feedbackEmail), getDataFromxls(0, "User_Feedback.xls", 2, 1));
		type(xpath(feedbackContactNumber), getDataFromxls(0, "User_Feedback.xls", 3, 1));
		type(xpath(feedbackNotes), getDataFromxls(0, "User_Feedback.xls", 4, 1));
		click(xpath(feedbackSendButton));
	}	
	
	public void validation_Feedback_Fields() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(feedback));
		waitForElementPresent(xpath(feedbackName));
		waitForElementVisible(xpath(feedbackName));
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(feedbackName)));
		Assert.assertTrue(isElementPresent(xpath(feedbackEmail)));
		Assert.assertTrue(isElementPresent(xpath(feedbackContactNumber)));
		Assert.assertTrue(isElementPresent(xpath(feedbackNotes)));
	}
	
	public void validate_close() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(feedback));
		waitForElementPresent(xpath(feedbackName));
		waitForElementVisible(xpath(feedbackName));
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(feedbackName)));				
		click(xpath(feedbackclose));

	}
	
	public void Contact_Validation() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(feedback));
		waitForElementPresent(xpath(feedbackName));
		waitForElementVisible(xpath(feedbackName));
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(feedbackName)));				
		type(xpath(feedbackContactNumber),"123456");
		driver.findElement(By.id("feedbackContactNumber")).sendKeys(Keys.TAB);
		Assert.assertEquals(getText(xpath(feedbackerrorMsgContactNumber)), getDataFromxls(0, "User_Feedback.xls", 1, 2), "Contact validation message");

	}
	
	public void Email_Validation() throws Exception{
		
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(userLoginUsername))){ Thread.sleep(2000); }
		click(xpath(feedback));
		waitForElementPresent(xpath(feedbackName));
		waitForElementVisible(xpath(feedbackName));
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }
		if(!isElementPresent(xpath(feedbackName))){ Thread.sleep(2000); }

		Assert.assertTrue(isElementPresent(xpath(feedbackName)));				
		type(xpath(feedbackEmail),"123456");
		driver.findElement(By.id("feedbackContactNumber")).sendKeys(Keys.TAB);
		Assert.assertEquals(getText(xpath(feedbackerrorMsgEmail)), getDataFromxls(0, "User_Feedback.xls", 1, 3), "Email validation message");

	}
	
	public void CFA_Back_To_Search_Button_back_CFA() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		
		click(xpath(userCFAButton));
		Thread.sleep(1000);
		click(xpath(userCFAConfirm));
		Thread.sleep(1000);
		click(xpath(userCFABackSearch));
		Thread.sleep(1000);
		
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000);}
		Assert.assertTrue(isElementPresent(xpath(propertySearch)));
		
		click(xpath(userCFAButton));

		Thread.sleep(1000);
		String styleval = driver.findElement(By.xpath(UnitErrorMessageHidden)).getAttribute("style");
		Assert.assertTrue(styleval.contains("display: none;"), "Unit number error still displayed");
		
		styleval = driver.findElement(By.xpath(StreetNameErrorMessageHidden)).getAttribute("style");
		Assert.assertTrue(styleval.contains("display: none;"), "Street number error still displayed");
		
		styleval = driver.findElement(By.xpath(StreetTypeErrorMessageHidden)).getAttribute("style");
		Assert.assertTrue(styleval.contains("display: none;"), "Street Type error still displayed");
		
		styleval = driver.findElement(By.xpath(SuburbErrorMessageHidden)).getAttribute("style");
		Assert.assertTrue(styleval.contains("display: none;"), "Suburb error still displayed");
		
	}
	
	public void CFA_mandatory_validation() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }

		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 3));
		type(xpath(userCFAStreetNumber), getDataFromxls(0, "User_PropertySearch.xls", 2, 3));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 3, 3));
		type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 4, 3));
		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 5, 3));
		
		Thread.sleep(3000);
		String styleval = driver.findElement(By.xpath(IncorrectSuburb)).getAttribute("style");
		Assert.assertFalse(styleval.contains("display: none;"), "Incorrect Suburb validation not displayed");
		
		click(xpath(userCFAClear));
		Thread.sleep(1000);
		type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 3));
		type(xpath(userCFAStreetNumber), getDataFromxls(0, "User_PropertySearch.xls", 2, 3));
		type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 4, 3));
		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 6, 3));
		click(xpath(userCFAConfirm));
		Assert.assertTrue(isElementVisible(xpath(cfaErrorMessageStreetName)), "Street Name");
		
		click(xpath(userCFAClear));
		Thread.sleep(1000);
		type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 3));
		type(xpath(userCFAStreetNumber), getDataFromxls(0, "User_PropertySearch.xls", 2, 3));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 3, 3));
		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 6, 3));
		click(xpath(userCFAConfirm));
		Assert.assertTrue(isElementVisible(xpath(cfaErrorMessageStreetType)), "Street Type");
		
		click(xpath(userCFAClear));
		Thread.sleep(1000);
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 3, 3));
		type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 4, 3));
		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 6, 3));
		click(xpath(userCFAConfirm));
		Assert.assertTrue(isElementVisible(xpath(cfaErrorMessageUnitNumber)), "Unit,Street,Lot Number");
		
	}
	
	
	public void CFA_No_address_Matched() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }

		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 4));
		type(xpath(userCFAStreetNumber), getDataFromxls(0, "User_PropertySearch.xls", 2, 4));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 3, 4));
		type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 4, 4));
		Thread.sleep(1000);
		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 5, 4));
		Thread.sleep(3000);

		driver.findElement(By.id("hubSearchAddress_suburbStatePostcode")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("hubSearchAddress_suburbStatePostcode")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Assert.assertEquals(getText(xpath(SorryCFA)), getDataFromxls(0, "User_PropertySearch.xls", 1, 5));
		
	}
	
	public void CFA_Form_validation() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }

		Thread.sleep(1000);
		click(xpath(userCFAButton));
		Assert.assertTrue(isElementPresent(xpath(userCFALotNumber)), "Lot Number");
		Assert.assertTrue(isElementPresent(xpath(userCFAStreetNumber)), "Street Number");
		Assert.assertTrue(isElementPresent(xpath(userCFAUnitNumber)), "Unit Number");
		Assert.assertTrue(isElementPresent(xpath(userCFAStreetName)), "Street Name");
		Assert.assertTrue(isElementPresent(xpath(userCFAStreetType)), "Street Type");
		Assert.assertTrue(isElementPresent(xpath(userCFASuburbList)), "Suburb List");
		Assert.assertTrue(isElementPresent(xpath(userCFABackSearch)), "Back to Search");
		Assert.assertTrue(isElementPresent(xpath(userCFAClear)), "Clear button");
		Assert.assertTrue(isElementPresent(xpath(userCFAConfirm)), "Confirm Button");
	}
	
	public void CFA_Searching_UI() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }

		Thread.sleep(1000);
		click(xpath(userCFAButton));
		type(xpath(userCFAStreetNumber), getDataFromxls(0, "User_PropertySearch.xls", 1, 6));
		type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 2, 6));
		Thread.sleep(1500);
		
		String styleval = driver.findElement(By.xpath(CFAIndicatorSearching)).getAttribute("style");
 		Assert.assertFalse(styleval.contains("display: none;"), "Searching not displayed");
	}
	
	public void CFA_Different_Property_Type() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Thread.sleep(1000);
		click(xpath(userCFAButton));
		
		int x = 0, y = 7;
		do{
			type(xpath(userCFAUnitNumber), getDataFromxls(0, "User_PropertySearch.xls", 2, y));
			type(xpath(userCFAStreetName), getDataFromxls(0, "User_PropertySearch.xls", 3, y));
			type(xpath(userCFAStreetType), getDataFromxls(0, "User_PropertySearch.xls", 4, y));
			type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 5, y));
			Thread.sleep(3000);
			driver.findElement(By.xpath(userCFASuburbList)).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			Assert.assertEquals(getText(xpath(IncorrectSuburb)), getDataFromxls(0, "User_PropertySearch.xls", 5, y));
			
			Thread.sleep(500);
			click(xpath(userCFAClear));
			x++;
			y++;
		}while(x<=15);
	}
	
	public void CFA_Branding() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Thread.sleep(1000);
		click(xpath(userCFAButton));

		Thread.sleep(2000);
		String styleval = driver.findElement(By.xpath(CFABorderColor)).getCssValue("background-color");
 		Assert.assertEquals(styleval, "rgba(254, 254, 213, 1)");
	}
	
	public void CFA_Suburb_Suggestion() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Thread.sleep(1000);
		click(xpath(userCFAButton));

		type(xpath(userCFASuburbList), getDataFromxls(0, "User_PropertySearch.xls", 1, 23));
		Thread.sleep(3000);

		Assert.assertTrue(getText(xpath(IncorrectSuburb)).contains(getDataFromxls(0, "User_PropertySearch.xls", 2, 23)));
		Assert.assertTrue(getText(xpath(IncorrectSuburb)).contains(getDataFromxls(0, "User_PropertySearch.xls", 3, 23)));
		Assert.assertTrue(getText(xpath(IncorrectSuburb)).contains(getDataFromxls(0, "User_PropertySearch.xls", 4, 23)));
		Assert.assertTrue(getText(xpath(IncorrectSuburb)).contains(getDataFromxls(0, "User_PropertySearch.xls", 5, 23)));
		Assert.assertTrue(getText(xpath(IncorrectSuburb)).contains(getDataFromxls(0, "User_PropertySearch.xls", 6, 23)));
	}
	
	public void Property_Search_Did_You_Mean() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		String styleval = driver.findElement(By.xpath(DidYouMean)).getAttribute("style");
 		Assert.assertTrue(styleval.contains("display: none;"), "Searching not displayed");
 		
 		type(xpath(propertySearch),getDataFromxls(0, "User_PropertySearch.xls", 1, 24));
 		click(xpath(propertySearchbtn));
 		Thread.sleep(3000);
 		
 		styleval = driver.findElement(By.xpath(DidYouMean)).getAttribute("style");
 		Assert.assertFalse(styleval.contains("display: none;"), "Searching not displayed");
 		
 		Assert.assertTrue(getText(xpath(DidYouMean)).contains(getDataFromxls(0, "User_PropertySearch.xls", 3, 24)));
 		Assert.assertTrue(getText(xpath(DidYouMean)).contains(getDataFromxls(0, "User_PropertySearch.xls", 4, 24)));
 		Assert.assertTrue(getText(xpath(DidYouMean)).contains(getDataFromxls(0, "User_PropertySearch.xls", 5, 24)));
 		Assert.assertTrue(getText(xpath(DidYouMean)).contains(getDataFromxls(0, "User_PropertySearch.xls", 6, 24)));
 		Assert.assertTrue(getText(xpath(DidYouMean)).contains(getDataFromxls(0, "User_PropertySearch.xls", 7, 24)));
 		
 		click(xpath(NundraLink));
 		waitForElementPresent(xpath(DidYouMeanListWithPicture));
		waitForElementVisible(xpath(DidYouMeanListWithPicture));
		if(!isElementPresent(xpath(DidYouMeanListWithPicture))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(DidYouMeanListWithPicture))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(DidYouMeanListWithPicture)));
 		
		click(xpath(NundraLinkWithPicture));
		Thread.sleep(3000);
		waitForElementPresent(xpath(NundraLotProperty));
		waitForElementVisible(xpath(NundraLotProperty));
		if(!isElementPresent(xpath(NundraLotProperty))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(NundraLotProperty))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(NundraLotProperty)));
	}
	
	public void Property_Search_Ghost_Text() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(propertySearch)));
		Assert.assertEquals(getValue(xpath(propertySearch)), getDataFromxls(0, "User_PropertySearch.xls", 1, 25));
		click(xpath(propertySearch));
		Assert.assertEquals(getValue(xpath(propertySearch)), "");
	}
	
	public void Property_Search_copy_paste() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(propertySearch)));
		int x=1,y=0;
		
		do{
			type(xpath(propertySearch), getDataFromxls(0, "User_PropertySearch.xls", x, 26));
			Thread.sleep(3000);
			Assert.assertEquals(getText(xpath(SuggestedList)), getDataFromxls(0, "User_PropertySearch.xls", x, 26));
			x++;
			y++;
		}while(y!=3);
	}	
	
	public void Property_Search_Invalid_Property() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(propertySearch)));
        type(xpath(propertySearch), getDataFromxls(0, "User_PropertySearch.xls", 1, 27));
        click(xpath(propertySearchbtn));
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(xpath(unfortunately_Error_Msg)), "Invalid Property Message is not displayed");
	}	
	
	public void Property_Search_Cannot_Proceed() throws Exception{
		
		click(xpath(home));
		waitForElementPresent(xpath(propertySearch));
		waitForElementVisible(xpath(propertySearch));
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }	
		if(!isElementPresent(xpath(propertySearch))){ Thread.sleep(2000); }
		Assert.assertTrue(isElementPresent(xpath(propertySearch)));
        type(xpath(propertySearch), getDataFromxls(0, "User_PropertySearch.xls", 1, 28));
        click(xpath(propertySearchbtn));
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(xpath(unfortunately_Error_Msg)), "Invalid Property Message is not displayed");
		Thread.sleep(500);
		type(xpath(propertySearch), getDataFromxls(0, "User_PropertySearch.xls", 2, 28));
        click(xpath(propertySearchbtn));
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(xpath(unfortunately_Error_Msg)), "Invalid Property Message is not displayed");
		
	}	
	
	public void loginToProdSelection() throws Exception{		
		driver.navigate().to(environment.concat("cbalender.rppropertyhub.com"));
		if(!isElementPresent(xpath(logout))){
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		Thread.sleep(3000);
		type(xpath(userLoginUsername), getDataFromxls(0, "User_ProductSelection.xls", 1, 0));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_ProductSelection.xls", 2, 0));
	    click(xpath(LoginButton));
		}
	    	waitForElementPresent(xpath(userPropertySearch));
	    	waitForElementVisible(xpath(userPropertySearch));
	    	Thread.sleep(3000);
	    	Assert.assertTrue(isElementPresent(xpath(propertySearch)));	    	


	    type(xpath(propertySearch), getDataFromxls(0, "User_ProductSelection.xls", 3, 0));
		click(xpath(propertySearchbtn));
		
		waitForElementPresent(xpath(completeAddress));
		waitForElementVisible(xpath(completeAddress));
		if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
    	if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }

		Assert.assertEquals(getDataFromxls(0, "User_ProductSelection.xls", 4, 0), getText(xpath(completeAddress)));
		

	if(isElementPresent(xpath(pendingTransaction))){
		click(xpath(pendingTransaction));
		}
	
		waitForElementPresent(xpath(proceedNextLink));
		waitForElementVisible(xpath(proceedNextLink));
		click(xpath(proceedNextLink));
		Thread.sleep(10000);
		waitForElementPresent(xpath(productNavBar));
		waitForElementVisible(xpath(productNavBar));

			Assert.assertEquals(getDataFromxls(0, "User_ProductSelection.xls", 4, 0), getText(xpath(completeAddress)));


			Assert.assertTrue(isElementPresent(xpath(productNavBar)));
			Assert.assertTrue(isElementPresent(xpath(instructionNavBar)));
			Assert.assertTrue(isElementPresent(xpath(paymentNavBar)));
			Assert.assertTrue(isElementPresent(xpath(orderNavBar)));

		
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
	
	}
	
	public void validate_Back_Button() throws Exception{
		Assert.assertFalse(isElementPresent(xpath(backBtn)), "Back Button is present");
	}
	
	public void validate_Next_ProceedToInstruction_Link_NotVisible() throws Exception{
		Assert.assertTrue(isElementPresent(xpath("//*[@class='instructionDetails hide']")), "Proceed to Instruction link is present");
		Assert.assertFalse(isElementPresent(xpath(nextBtn)), "Next Button is present");		
	}
	
	public void validate_Next_Button_function() throws Exception{
		click(xpath(pruchaseBtnSingle));
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(xpath(nextBtn)), "Next Button is not present");		
		
		click(xpath(nextBtn));
		Thread.sleep(3000);
		if(!isElementPresent(xpath(userCustomerFName))) { Thread.sleep(2000); }
		if(!isElementPresent(xpath(userCustomerFName))) { Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(userCustomerFName)));
		Assert.assertTrue(isElementPresent(xpath(userCustomerLName)));
		Logout_link();
	}
	
	public void validate_ProceedToInstruction_Link_function() throws Exception{
		click(xpath(pruchaseBtnSingle));
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(xpath(nextBtn)), "Next Button is not present");		
		
		click(xpath(nextBtn));
		Thread.sleep(3000);
		if(!isElementPresent(xpath(userCustomerFName))) { Thread.sleep(2000); }
		if(!isElementPresent(xpath(userCustomerFName))) { Thread.sleep(2000); }
		
		Assert.assertTrue(isElementPresent(xpath(userCustomerFName)));
		Assert.assertTrue(isElementPresent(xpath(userCustomerLName)));
	}
	
	public void validate_Add_To_Cart_Button() throws Exception{
		click(xpath(valuationsTab));
		Thread.sleep(4000);
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		
		type(xpath(unitPriceValuation), getDataFromxls(0, "User_ProductSelection.xls", 1, 1));
		click(xpath(construction));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		Thread.sleep(5000);
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));

		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));
		if(getValue(xpath(pruchaseBtnFifthLine)).contains("Add to cart")){
				click(xpath(pruchaseBtnFifthLine));
			}
		
		Thread.sleep(4000);
		Assert.assertTrue(isElementPresent(xpath(addToCartLabel)), "Add to Cart button is not functioning");
	}
	
	public void validate_correct_products_displayed() throws Exception{
		click(xpath(valuationsTab));
		Thread.sleep(4000);
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		
		type(xpath(unitPriceValuation), getDataFromxls(0, "User_ProductSelection.xls", 1, 1));
		click(xpath(construction));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		Thread.sleep(5000);
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));

		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));
		Assert.assertTrue(isElementVisible(xpath(AVMProduct)));
		Assert.assertTrue(isElementVisible(xpath(ShortForm)));
		Assert.assertTrue(isElementVisible(xpath(ShortFormLeaseHold)));
		Assert.assertTrue(isElementVisible(xpath(valuationsTab)));
	}
	
	public void validate_On_Credit_Card_Price() throws Exception{
		click(xpath(valuationsTab));
		Thread.sleep(4000);
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		
		type(xpath(unitPriceValuation), getDataFromxls(0, "User_ProductSelection.xls", 1, 1));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		Thread.sleep(5000);
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));

		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(pruchaseBtnSingle))){ Thread.sleep(7000); }
		waitForElementPresent(xpath(pruchaseBtnSingle));
		waitForElementVisible(xpath(pruchaseBtnSingle));
		Assert.assertTrue(isElementVisible(xpath(AVMProduct)));
		Assert.assertTrue(isElementVisible(xpath(ShortForm)));
		Assert.assertTrue(isElementVisible(xpath(ShortFormLeaseHold)));
		Assert.assertTrue(isElementVisible(xpath(valuationsTab))); 
		Assert.assertEquals(getText(xpath(ShortFormPrice)), "$49.00");
		if(isElementPresent(xpath(ConstructionPrice))){
			Assert.assertEquals(getText(xpath(ConstructionPrice)), "$49.00");
		}
	}
	
	public void validate_No_Product_Available_message() throws Exception{
		driver.navigate().to(environment.concat("amp.rppropertyhub.com"));
	
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		Thread.sleep(3000);
		type(xpath(userLoginUsername), getDataFromxls(0, "User_ProductSelection.xls", 1, 0));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_ProductSelection.xls", 2, 0));
	    click(xpath(LoginButton));
	
	    	waitForElementPresent(xpath(userPropertySearch));
	    	waitForElementVisible(xpath(userPropertySearch));
	    	Thread.sleep(3000);
	    	Assert.assertTrue(isElementPresent(xpath(propertySearch)));	    	
	
	
	    type(xpath(propertySearch), getDataFromxls(0, "User_ProductSelection.xls", 3, 0));
		click(xpath(propertySearchbtn));
		
		waitForElementPresent(xpath(completeAddress));
		waitForElementVisible(xpath(completeAddress));
		if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
		if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
	
		Assert.assertEquals(getDataFromxls(0, "User_ProductSelection.xls", 4, 0), getText(xpath(completeAddress)));
		
		if(isElementPresent(xpath(pendingTransaction))){
			click(xpath(pendingTransaction));
			Thread.sleep(4000);
			}
		
		click(xpath(proceedtoProductSelection));
	
		Thread.sleep(4000);
		waitForElementPresent(xpath(unitPriceValuation));
		waitForElementVisible(xpath(unitPriceValuation));
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(unitPriceValuation))){ Thread.sleep(7000); }
		
		
		
		type(xpath(unitPriceValuation), getDataFromxls(0, "User_ProductSelection.xls", 3, 2));
		type(xpath(loanAmount), getDataFromxls(0, "User_ProductSelection.xls", 4, 2));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(proceedToProductValuation));
		Thread.sleep(5000);
		waitForElementPresent(xpath(NoAvailableMessage));
		waitForElementVisible(xpath(NoAvailableMessage));

		if(!isElementVisible(xpath(NoAvailableMessage))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(NoAvailableMessage))){ Thread.sleep(7000); }
		waitForElementPresent(xpath(NoAvailableMessage));
		waitForElementVisible(xpath(NoAvailableMessage));
	
		Assert.assertEquals(getText(xpath(NoAvailableMessage)), getDataFromxls(0, "User_ProductSelection.xls", 5, 2));
	}
	public void validate_2_tabs_cbalender() throws Exception{
		driver.navigate().to(environment.concat("cbalender.rppropertyhub.com"));
	
		waitForElementPresent(xpath(userLoginUsername));
		waitForElementVisible(xpath(userLoginUsername));
		Thread.sleep(3000);
		type(xpath(userLoginUsername), getDataFromxls(0, "User_ProductSelection.xls", 1, 0));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_ProductSelection.xls", 2, 0));
	    click(xpath(LoginButton));
	
	    	waitForElementPresent(xpath(userPropertySearch));
	    	waitForElementVisible(xpath(userPropertySearch));
	    	Thread.sleep(3000);
	    	Assert.assertTrue(isElementPresent(xpath(propertySearch)));	    	
	
	
	    type(xpath(propertySearch), getDataFromxls(0, "User_ProductSelection.xls", 3, 0));
		click(xpath(propertySearchbtn));
		
		waitForElementPresent(xpath(completeAddress));
		waitForElementVisible(xpath(completeAddress));
		if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
		if(!isElementPresent(xpath(completeAddress)));{ Thread.sleep(2000); }
	
		Assert.assertEquals(getDataFromxls(0, "User_ProductSelection.xls", 4, 0), getText(xpath(completeAddress)));
		
		if(isElementPresent(xpath(pendingTransaction))){
			click(xpath(pendingTransaction));
			Thread.sleep(4000);
			}
		
		click(xpath(proceedtoProductSelection));
	
		Thread.sleep(4000);
		waitForElementPresent(xpath(reportsTab));
		waitForElementVisible(xpath(valuationsTab));
		if(!isElementVisible(xpath(reportsTab))){ Thread.sleep(7000); }
		if(!isElementVisible(xpath(valuationsTab))){ Thread.sleep(7000); }
		
		Assert.assertTrue(isElementPresent(xpath(valuationsTab)));
		Assert.assertTrue(isElementPresent(xpath(reportsTab)));
		
	}
	
	public void validate_Sample_Report_Link() throws Exception{
		Thread.sleep(3000);
		waitForElementVisible(xpath(SampleReport));
		click(xpath(SampleReport));
		Assert.assertTrue(isElementPresent(xpath(SampleReport)));
	}
	
	public void slas() throws Exception {
		waitForElementPresent(xpath(userPropertySearch));
		waitForElementVisible(xpath(userPropertySearch));
		if(!isElementPresent(xpath(userPropertySearch))){ Thread.sleep(3000); }
		if(!isElementPresent(xpath(userPropertySearch))){ Thread.sleep(3000); }

		try {
			Assert.assertEquals("Enter your property address or street name here.", getValue(xpath(userPropertySearch)));
		} catch (AssertionError e) {
			fail("SLAS placeholder text");
		}
		type(xpath(userPropertySearch), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 0));		
		click(xpath(userSearchButton));
		Thread.sleep(3000);
	}
	
	public void proceedProductSelection() throws Exception {	
		waitForElementPresent(xpath(userProceedToProductSelection));
		waitForElementVisible(xpath(userProceedToProductSelection));
		if(isElementPresent(xpath(userProceedToProductSelection))){
			click(xpath(userProceedToProductSelection));
			}
		Thread.sleep(6000);
	}
	
	public void startNewTransaction() throws Exception {
		if(isElementPresent(xpath(userPendingTransactionMessage))){
	        click(By.linkText("Start a new transaction for this property"));      
	    }
        Thread.sleep(3000);	
	}	
	public void changeAddressLink() throws Exception {
	    click(By.linkText("Change property address"));    
        Thread.sleep(3000);	
        waitForElementPresent(xpath(userPropertySearch));
		waitForElementVisible(xpath(userPropertySearch));
	}	
	
	public void noPromptOriginatorDetails() throws Exception{
		Successful_login_CBALender();
		slas();
		startNewTransaction();
		proceedProductSelection();
		waitForElementPresent(xpath(productTabsMenu));
		waitForElementVisible(xpath(productTabsMenu));
		Assert.assertFalse(isElementVisible(xpath(userOriginatorDetails)), "Originator Details should not display on tab not requiring BRE");	
	}
	
	public void promptOriginatorDetails() throws Exception{		
		waitForElementPresent(xpath(productTabsMenu));
		waitForElementVisible(xpath(productTabsMenu));
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));	
		
		waitForElementPresent(xpath(userOriginatorDetails));
		waitForElementVisible(xpath(userOriginatorDetails));
		Assert.assertTrue(isElementPresent(xpath(userOriginatorDetails)),"Originator Details is not displayed");
		Thread.sleep(3000);
		Assert.assertEquals(getText(xpath(originatorHeader)),"Please provide the following details to proceed:");		
	}
	
	public void breShortForm() throws Exception {
		waitForElementPresent(xpath(userOriginatorDetails));
		waitForElementVisible(xpath(userOriginatorDetails));
		type(xpath(userOEVPP),(getDataFromxls(0, "User_InstructionDetails.xls", 1, 0)));
		click(xpath(loanRefinance));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avmAckSelect));	
		click(xpath(userOriginatorToProductSelection));
		Thread.sleep(12000);
		Assert.assertTrue(isElementPresent(xpath(shortFormAddToCart)),"Short Form Valuation should be available");
		click(xpath(shortFormAddToCart));
		Thread.sleep(1500);
	}
	
	public void breConstruction() throws Exception {
		waitForElementPresent(xpath(userOriginatorDetails));
		waitForElementVisible(xpath(userOriginatorDetails));
		type(xpath(userOEVPP),(getDataFromxls(0, "User_InstructionDetails.xls", 1, 0)));
		click(xpath(loanConstruction));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avmAckSelect));	
		click(xpath(userOriginatorToProductSelection));
		Thread.sleep(12000);
		Assert.assertTrue(isElementPresent(xpath(constructionAddToCart)),"Constrcution Valuation should be available");
		click(xpath(constructionAddToCart));
	}

	public void originatorToProductSelection() throws Exception{
		waitForElementPresent(xpath(userOriginatorDetails));
		waitForElementVisible(xpath(userOriginatorDetails));
		Assert.assertTrue(isElementPresent(xpath(iconOriginatorToProductSelection)),"Procced to product selection icon is not displayed");
		Assert.assertTrue(isElementPresent(xpath(userOriginatorToProductSelection)),"Procced to product selection link is not displayed");		
	}

	public void informationIcon() throws Exception{
		Assert.assertTrue(isElementPresent(xpath(infoIcon)),"OEVPP Information icon is not displayed");
		actionType(xpath(infoIcon),"OEVPP Information Icon");
		Assert.assertEquals(getTooltip(xpath(infoIcon)), "This value is used to accurately price the products and services for this property. If you are buying the property then use the Contract Price, if not use your most accurate estimate of the current value of the property.");
		
	}

	public void propertyType() throws Exception{
		Assert.assertEquals(getText(xpath(propertyTypeLabel)), "* Is this a...?");
		Assert.assertTrue(isElementPresent(xpath(propertyTypeSelect)),"Property Type field is not present");
		Assert.assertEquals(getValue(xpath(propertyTypeSelect)), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, 0));
		
		int y=1;
		
		do{
			selectOption(xpath(propertyTypeSelect), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, y));
			String val = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, y);
			Assert.assertEquals(getText(xpath("//form[@id='propertyDetailQuestions']//option[@value='"+val+"']")), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y));
			y++;
		}while(y!=8);
		selectOption(xpath(propertyTypeSelect), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, 0));
		
	}

	public void oevppRequiredNumeric() throws Exception{
		Thread.sleep(3000);
		Assert.assertEquals(getText(xpath(oevppLabel)), "* Owners Estimated Value / Purchase Price", "Price not equal");
		Assert.assertEquals(getText(xpath(oevppLabelDollar)), "$ ", "Label is not Displayed");
		Assert.assertTrue(isElementPresent(xpath(userOEVPP)),"OEV/PP field is not present");
		click(xpath(userOEVPP));
		click(xpath(userOriginatorToProductSelection));
		Thread.sleep(3000);
		Assert.assertTrue(isElementVisible(xpath(oevppErrorMsg)),"Error message is not displayed");
		Assert.assertEquals(getText(xpath(oevppErrorMsg)), " Field should not be empty.","No validation Message");
		type(xpath(userOEVPP),(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 8)));
		Thread.sleep(200);
		Assert.assertEquals(getValue(xpath(userOEVPP)),getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 8), "OEVPP validation message not displayed or incorrect");
		click(xpath(userOriginatorToProductSelection));
		Thread.sleep(3000);
	}

	public void oevppFormatted() throws Exception{
		int y=9;		
		do{
			click(xpath(userOEVPP));
			type(xpath(userOEVPP),(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, y)));
			click(xpath(infoIcon));
			Thread.sleep(1000);
			Assert.assertEquals(getValue(xpath(userOEVPP)),getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y));
			y++;
		}while(y!=17);
	}
	
	public void loanAmountNotActive() throws Exception{
		// Loan Amount is not enabled from the admin
		Assert.assertFalse(isElementPresent(xpath(orgLoanAmount)),"Loan Amount field should not be dispalyed");		
	} 

	public void daotaPropertyExclusions() throws Exception{
		Thread.sleep(3000);
		Assert.assertEquals(getText(xpath(daotaLabel)), "* Do Any Of These Apply?");
		int x=1;
		int y=17;
		do{
		System.out.println("Checking "+getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, y));
		String excId = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, y);
		String excText = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y);
		Assert.assertTrue(isElementPresent(xpath("//form[@id='propertyDetailQuestions']//input[@id='"+excId+"']")), excText+" is not present");	
		Assert.assertTrue(getText(xpath("//*[@id='propertyDetailQuestions']/div[2]/table[1]/tbody/tr[7]/td[3]/span["+x+"]")).contains(excText));
		x++;
		y++;
		}while(y!=33);
	}
	
	public void daotaRequired() throws Exception{
		click(xpath(xButton));
		Thread.sleep(3000);
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));
		Thread.sleep(3000);
		click(xpath(userOriginatorToProductSelection));
		Assert.assertTrue(isElementVisible(xpath(daotaErrorMsg)),"Error message is not displayed");
		Assert.assertEquals(getText(xpath(daotaErrorMsg)), " Field should be checked..");	
	}
	
	public void loanPurpose() throws Exception{
		Thread.sleep(3000);
		Assert.assertEquals(getText(xpath(loanPurposeLabel)), "* Loan Purpose");
		int y=33;
		do{
		String loanPId = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, y);
		String loanPText = getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, y);
		Assert.assertTrue(isElementPresent(xpath("//form[@id='propertyDetailQuestions']//input[@value='"+loanPId+"']")), loanPText+" is not present");	
		y++;
		}while(y!=38);
	}

	public void avmAckDisplay() throws Exception{
		Thread.sleep(3000);
		Assert.assertTrue(isElementVisible(xpath(avmAckLabel)), "AVM Acknowledgement is not displayed");	
		Assert.assertEquals(getText(xpath(avmAckLabel)), "* AVM Acknowledgement");
		Assert.assertTrue(isElementVisible(xpath(avmAckSelect)), "AVM Acknowledgement checkbox is not displayed");
		Assert.assertTrue(getText(xpath(avmAckDesc)).contains("Before ordering an Automated Valuation Report I have informed the customer that"));
	}
	
	public void avmAckRequired() throws Exception{
		Thread.sleep(3000);
		click(xpath(xButton));
		Thread.sleep(3000);
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));
		Thread.sleep(3000);
		click(xpath(userOriginatorToProductSelection));
		Assert.assertTrue(isElementVisible(xpath(avmAckError)),"AVM Ack error message is not displayed");
		Assert.assertEquals(getText(xpath(avmAckError)), " Field should be checked..");			
	}
	
	public void loanAppDisplay() throws Exception{
		Thread.sleep(3000);
		click(xpath(daotaCompanyTitle));
		Thread.sleep(2000);
		Assert.assertTrue(isElementVisible(xpath(loanAppLabel)), "Loan Application is not displayed");	
		Assert.assertEquals(getText(xpath(loanAppLabel)), "* Loan Application");
		Assert.assertTrue(isElementVisible(xpath(loanAppSelect)), "Loan Application checkbox is not displayed");
		Assert.assertEquals(getText(xpath(loanAppDesc)),"I confirm this valuation request is required for a Home Loan Application (CHL / VAS Decision) / Loan Maintenance Application(CHLM)");
	}
	public void loanAppRequired() throws Exception{
		Thread.sleep(3000);
		click(xpath(xButton));
		Thread.sleep(3000);
		click(xpath(getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 0)));
		Thread.sleep(3000);
		click(xpath(userOriginatorToProductSelection));
		Thread.sleep(3000);
		Assert.assertTrue(isElementVisible(xpath(avmAckError)),"AVM Ack error message is not displayed");
//		Assert.assertTrue(isElementVisible(xpath(loanAppError)),"Loan App error message is not displayed");
		Assert.assertEquals(getText(xpath(avmAckError)), " Field should be checked..");			
	}

	public void urlHttps() throws Exception{
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("https"));
	}

	public void lenderEmpowermentNoRPID() throws Exception{
		Thread.sleep(3000);
		click(xpath(xButton));
		Thread.sleep(3000);
		changeAddressLink();	
		Thread.sleep(3000);
		click(xpath(cantFindAddressbtn));
		type(xpath(unitNumberSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 39));
		type(xpath(streetNumberSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 39));
		type(xpath(streetNameSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 3, 39));
		type(xpath(streetTypeSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 4, 39));
		type(xpath(suburbSearchAddress), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 5, 39));
		click(xpath(confirmbtnSearchAddress));
		Thread.sleep(3000);
		proceedProductSelection();
		Assert.assertFalse(isElementPresent(xpath(productLenderEmpowerment)), "Lender Empowerment is not offered");		
		Thread.sleep(3000);
	}
	
	public void lenderEmpowermentMetropolitan() throws Exception{
		changeAddressLink();
		Thread.sleep(3000);
		type(xpath(userPropertySearch), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 38));		
		click(xpath(userSearchButton));
		Thread.sleep(3000);
		startNewTransaction();
		proceedProductSelection();
		Assert.assertTrue(isElementVisible(xpath(productLenderEmpowerment)), "Lender Empowerment is not offered");		
	}

	public void productDetails() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(productName)), "Product name is not displayed");
		Assert.assertTrue(isElementVisible(xpath(productShort)), "Product Short desctiption is not displayed");
		Assert.assertTrue(isElementVisible(xpath(productMore)), "More link is not displayed");
		Assert.assertFalse(isElementVisible(xpath(productLong)), "Long description should not be displayed");
		Assert.assertFalse(isElementVisible(xpath(productHide)), "Hide details link should not be displayed");
		click(xpath(productMore));		
	}
	public void productDetailsMore() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(productLong)), "Long description is not displayed");
		Assert.assertTrue(isElementVisible(xpath(productHide)), "Hide details link is not displayed");
		Assert.assertFalse(isElementVisible(xpath(productMore)), "More details link should not be displayed");
		click(xpath(productHide));		
		Assert.assertFalse(isElementVisible(xpath(productHide)), "Hide details link should not be displayed");
	}
	public void productOnAccount() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(onAccountDisplay)), "On Account text is not displayed");
		Assert.assertEquals(getText(xpath(onAccountDisplay)), "Price: On Account");		
	}

	public void cartLinkFunctionality() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(cartCount)), "Cart Count link is not displayed");
		Assert.assertEquals(getText(xpath(cartCount)), "(0)");	
		click(xpath(cartCount));
		Thread.sleep(2000);
		Assert.assertTrue(isElementVisible(xpath(emptyCartMessage)), "Empty Cart Message is not displayed");
		Assert.assertEquals(getText(xpath(emptyCartMessage)), "Please add an item to cart to proceed.");
		Assert.assertTrue(isElementVisible(xpath(emptyCartOkBtn)), "Empty Cart Ok Button is not displayed");
		Assert.assertTrue(isElementVisible(xpath(emptyCartXBtn)), "Empty Cart X Button is not displayed");
		click(xpath(emptyCartOkBtn));
		Thread.sleep(2000);
		click(xpath(instructionDetailsTab));
		Thread.sleep(2000);
		Assert.assertTrue(isElementVisible(xpath(emptyCartMessage)), "Empty Cart Message is not displayed");
		Assert.assertEquals(getText(xpath(emptyCartMessage)), "Please add an item to cart to proceed.");
		Assert.assertTrue(isElementVisible(xpath(emptyCartOkBtn)), "Empty Cart Ok Button is not displayed");
		Assert.assertTrue(isElementVisible(xpath(emptyCartXBtn)), "Empty Cart X Button is not displayed");		
		click(xpath(emptyCartOkBtn));
		Thread.sleep(2000);
		click(xpath(productLenderEmpowerment));
		waitForElementVisible(xpath(lenderEmpAdded));
		Assert.assertEquals(getText(xpath(cartCount)), "(1)");	
		click(xpath(cartCount));
		Thread.sleep(3000);		
		Assert.assertTrue(isElementVisible(xpath(cartInstructionMessage)), "Instruction details message is not displayed");
		Assert.assertTrue(getText(xpath(cartInstructionMessage)).contains("Cart and Payment screen will not be available until mandatory fields from Instruction Details are filled in."));
		Assert.assertTrue(getText(xpath(cartInstructionMessage)).contains("Do you want to move forward to the Instruction Details screen?"));
		click(xpath(emptyCartXBtn));
		Thread.sleep(3000);	
	}

	public void workflowBar() throws Exception{
		Assert.assertTrue(isElementVisible(xpath(workflowBar)), "Workflow Bar is not displayed");
		Assert.assertTrue(isElementVisible(xpath(productSelectionBar)), "Product Selection Bar is not displayed");
		Assert.assertTrue(isElementVisible(xpath(instructionDetailsTab)), "Instruction Details Bar is not displayed");
		Assert.assertTrue(isElementVisible(xpath(paymentDetailsBar)), "Payment Details Bar is not displayed");
		Assert.assertTrue(isElementVisible(xpath(OrderConfirmationBar)), "Order Confirmation Bar is not displayed");
	}

	public void productTabNotActive() throws Exception{
		Assert.assertFalse(isElementPresent(xpath(tabRetroReports)),"Inactive tab should not be displayed");		
	}
	
	public void loanAmountActive() throws Exception{
		String URL = driver.getCurrentUrl();
		if(URL.contains("cbalender")){
			driver.navigate().to(environment.concat("amp.rppropertyhub.com"));
		}
		Thread.sleep(3000);
		type(xpath(userLoginUsername), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 1, 40));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_ProductSelectionOriginator.xls", 2, 40));
		click(xpath(loginButton));
		slas();
		startNewTransaction();
		proceedProductSelection();
		promptOriginatorDetails();
		Assert.assertEquals(getText(xpath(loanAmountLabel)), "* Loan Amount");
		Assert.assertEquals(getText(xpath(loanAmountDollar)), "$ ");
		Assert.assertTrue(isElementPresent(xpath(orgLoanAmount)),"Loan Amount field is not present");		
	}

	public void loanAmountMandatory() throws Exception{
		click(xpath(orgLoanAmount));
		click(xpath(userOriginatorToProductSelection));
		Assert.assertTrue(isElementVisible(xpath(oevppErrorMsg)),"Error message is not displayed");
		Assert.assertEquals(getText(xpath(oevppErrorMsg)), " Field should not be empty.");
	}
	
	public void clickToInstruction() throws Exception {
		waitForElementVisible(xpath(userProceedToInstructionDetails));
		click(xpath(userProceedToInstructionDetails));
		Thread.sleep(3000);
	}
	public void cartCountPopup() throws Exception {
		waitForElementVisible(xpath(cartCountPopup));
		Assert.assertTrue(isElementPresent(xpath(cartCountPopup)),"Cart Count Message popup is not displayed");
		Assert.assertTrue(isElementVisible(xpath(cartCountPopup)),"Cart Count Message popup is not displayed");
		Assert.assertTrue(getText(xpath(cartCountPopup)).contains("Please complete all mandatory fields before navigating away from Instruction Details screen."));		
		click(xpath(cartCountOK));
		Thread.sleep(2000);
	}
	public void insMandatoryPopup() throws Exception {
		waitForElementVisible(xpath(cartCountPopup));
		Assert.assertTrue(isElementPresent(xpath(cartCountPopup)),"Instrcution Details Mandatory popup is not displayed");
		Assert.assertTrue(isElementVisible(xpath(cartCountPopup)),"Instrcution Details Mandatory popup is not displayed");
		Assert.assertTrue(getText(xpath(cartCountPopup)).contains("Cart and Payment screen will not be available until mandatory fields from Instruction Details are filled in."));		
		click(xpath(cartCountOK));
		Thread.sleep(2000);
	}
	
	public void insBackBtn() throws Exception {
		Successful_login_CBALender();
		slas();
		startNewTransaction();
		proceedProductSelection();
		breShortForm();
		clickToInstruction();
		click(xpath(insBackBtn));		
		cartCountPopup();
	}

	public void instructionVallidation() throws Exception{
		click(xpath(productSelectionBar));
		cartCountPopup();
		click(xpath(paymentDetailsBar));
		insMandatoryPopup();
		click(xpath(insNextBtn));
		insMandatoryPopup();
		click(xpath(insPaymentIcon));
		insMandatoryPopup();
		click(xpath(insPaymentLink));
		insMandatoryPopup();
		click(xpath(cartCount));
		insMandatoryPopup();
	}

	public void instructionToggleSections() throws Exception{
		click(xpath(insCustomerDetails));
		Assert.assertFalse(isElementVisible(xpath(insCustomerDetailsForm)),"Customer Details section was not toggled close");
		click(xpath(insCustomerDetails));
		Assert.assertTrue(isElementVisible(xpath(insCustomerDetailsForm)),"Customer Details section was not toggled open");
		
		click(xpath(insPropertyAccess));
		Assert.assertFalse(isElementVisible(xpath(insPropertyAccessForm)),"Property Access Details section was not toggled close");
		click(xpath(insPropertyAccess));
		Assert.assertTrue(isElementVisible(xpath(insPropertyAccessForm)),"Property Access Details section was not toggled open");
		
		click(xpath(insLoanDetails));
		Assert.assertTrue(isElementVisible(xpath(insLoanDetailsForm)),"Loan Details section was not toggled close");
		click(xpath(insLoanDetails));
		Assert.assertFalse(isElementVisible(xpath(insLoanDetailsForm)),"Loan Details section was not toggled open");
		
		click(xpath(insDocumentUpload));
		Assert.assertFalse(isElementVisible(xpath(insDocumentUploadForm)),"Document Upload section was not toggled close");
		click(xpath(insDocumentUpload));
		Assert.assertTrue(isElementVisible(xpath(insDocumentUploadForm)),"Document Upload section was not toggled open");
		
		click(xpath(insSpecialInstructions));
		Assert.assertTrue(isElementVisible(xpath(insSpecialInstructionsForm)),"Special Instructions section was not toggled close");
		click(xpath(insSpecialInstructions));
		Assert.assertFalse(isElementVisible(xpath(insSpecialInstructionsForm)),"Special Instructions section was not toggled open");
		
	}

	public void minimumDataRequirement() throws Exception{
		Assert.assertTrue(isElementPresent(xpath(insCustomerDetails)),"Customer Details section is not displayed");
		Assert.assertTrue(isElementPresent(xpath(insCustomerDetailsForm)),"Customer Details Form is not displayed");
		Assert.assertTrue(isElementPresent(xpath(custFnameLabel)),"Customer Details First Name Label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(custLnameLabel)),"Customer Details Last Name Label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(custCustomerIsLabel)),"Customer Details Customer Is label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(custContactLabel)),"Customer Details Contact number label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(custEmailLabel)),"Customer Details Email label is not displayed");
		
		Assert.assertEquals(getText(xpath(custFnameLabel)),"* First Name");
		Assert.assertEquals(getText(xpath(custLnameLabel)),"* Last Name");
		Assert.assertEquals(getText(xpath(custCustomerIsLabel)),"* The Customer is");
		Assert.assertEquals(getText(xpath(custContactLabel)),"* Contact Number");
		Assert.assertEquals(getText(xpath(custEmailLabel)),"Email");
		
		Assert.assertTrue(isElementPresent(xpath(userCustomerFName)),"Customer Details First Name field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(userCustomerLName)),"Customer Details Last Name field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(userCustomerContact)),"Customer Details Contact Number field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(userCustomerEmail)),"Customer Details Email field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(insCustomerIs)),"Customer Details Customer Is dropdown field is not displayed");
		
		Assert.assertTrue(isElementPresent(xpath(insPropertyAccess)),"Property Access Details section is not displayed");
		Assert.assertTrue(isElementPresent(xpath(insPropertyAccessForm)),"Property Access Details Form is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessSameAsLabel)),"Property Access Details Same As Customer label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(userSameAsCustomer)),"Property Access Details Same As Customer checkbox is not displayed");
	
		Assert.assertTrue(isElementPresent(xpath(accessFnameLabel)),"Property Access Details First name label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessLnameLabel)),"Property Access Details Last name label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessCompanyLabel)),"Property Access Details Company name label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessContactLabel)),"Property Access Details Contact number label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessEmailLabel)),"Property Access Details Email label is not displayed");
		
		Assert.assertEquals(getText(xpath(accessFnameLabel)),"* First Name");
		Assert.assertEquals(getText(xpath(accessLnameLabel)),"Last Name");
		Assert.assertEquals(getText(xpath(accessCompanyLabel)),"Company Name");
		Assert.assertEquals(getText(xpath(accessContactLabel)),"* Contact Number");
		Assert.assertEquals(getText(xpath(accessEmailLabel)),"Email");
		
		Assert.assertTrue(isElementPresent(xpath(accessFName)),"Property Access Details First name field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessLName)),"Property Access Details Last name field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessCompany)),"Property Access Details Company name field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessContact)),"Property Access Details Contact number field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(accessEmail)),"Property Access Details Email field is not displayed");
		
		click(xpath(insLoanDetails));
		Assert.assertTrue(isElementPresent(xpath(insLoanDetails)),"Loan Details section is not displayed");
		Assert.assertTrue(isElementPresent(xpath(insLoanDetailsForm)),"Loan Details Form is not displayed");
		
		Assert.assertTrue(isElementPresent(xpath(loanApplicationIdLabel)),"Loan Details Application ID label label is not displayed");
		Assert.assertTrue(isElementPresent(xpath(loanValuationIdLabel)),"Loan Details Valuation ID label is not displayed");
		
		Assert.assertEquals(getText(xpath(loanApplicationIdLabel)),"Application ID #");
		Assert.assertEquals(getText(xpath(loanValuationIdLabel)),"Valuation ID #");
		
		Assert.assertTrue(isElementPresent(xpath(loanApplicationId)),"Loan Details Application ID field is not displayed");
		Assert.assertTrue(isElementPresent(xpath(loanValuationId)),"Loan Details Valuation ID field is not displayed");		
	}

}



