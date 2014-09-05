package hub.utilities;

import static org.openqa.selenium.By.xpath;

import org.testng.Assert;

import hub.library.FunctionReference;

public class UserSignupUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public UserSignupUtil(String[] i) {
		input = i;
	}
	
	public UserSignupUtil() {
	}
	
	public void testSignupNavigation() throws Exception {	
		resultcount = 0;	
		testCase = "RP Property Hub Signup Page: " + input[0];
		
		driver.navigate().to(input[1]);
				
		
//		waitForElementPresent(xpath(registerButton));
//		click(xpath(registerButton));
		Thread.sleep(6000);   
		click(xpath("//a"));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(registrationForm)));
		} catch (AssertionError e) {
			fail("Registration form");
			takeScreenshot();
			resultcount++;
		}
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	public void testSignupFields() throws Exception {
		resultcount = 0;	
		testCase = "RP Property Hub Signup fields: " + input[0];

		
//First Name
		if(input[2].equalsIgnoreCase("fnActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountFN)));
				pass("First name");
			} catch (AssertionError e) {
				fail("First name");
				takeScreenshot();
				resultcount++;
			}
			if(input[3].equalsIgnoreCase("fnReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorFN)));
					pass("First Name validation");
				} catch (AssertionError e) {
					fail("First Name validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorFN)));
					pass("First Name validation");
				} catch (AssertionError e) {
					fail("First Name validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountFN)));
				pass("First name");
			} catch (AssertionError e) {
				fail("First name");
				takeScreenshot();
				resultcount++;
			}
		}

//Last Name		
		if(input[4].equalsIgnoreCase("lnActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountLN)));
				pass("Last name");
			} catch (AssertionError e) {
				fail("Last name");
				takeScreenshot();
				resultcount++;
			}
			if(input[5].equalsIgnoreCase("lnReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorLN)));
					pass("Last Name validation");
				} catch (AssertionError e) {
					fail("Last Name validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorLN)));
					pass("Last Name validation");
				} catch (AssertionError e) {
					fail("Last Name validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountLN)));
				pass("Last name");
			} catch (AssertionError e) {
				fail("Last name");
				takeScreenshot();
				resultcount++;
			}
		}

		
//Email
		if(input[6].equalsIgnoreCase("emailActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountEmail)));
				pass("Email");
			} catch (AssertionError e) {
				fail("Email");
				takeScreenshot();
				resultcount++;
			}
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountConfirmEmail)));
				pass("Confirm Email");
			} catch (AssertionError e) {
				fail("Confirm Email");
				takeScreenshot();
				resultcount++;
			}
			click(xpath(signupDone));
			try {
				Assert.assertTrue(isElementPresent(xpath(signUpErrorConfirmEmail)));
				pass("Confirm Email Validation");
			} catch (AssertionError e) {
				fail("Confirm Email Validation");
				takeScreenshot();
				resultcount++;
			}
			if(input[7].equalsIgnoreCase("emailReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorEmail)));
					pass("Email validation");
				} catch (AssertionError e) {
					fail("Email validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorEmail)));
					pass("Email validation");
				} catch (AssertionError e) {
					fail("Email validation");
					takeScreenshot();
					resultcount++;
				}
			}
			if(input[8].equalsIgnoreCase("suffixActive")) {
				try {
					Assert.assertTrue(isElementPresent(xpath(input[9])));
					Assert.assertTrue(isElementPresent(xpath("(" + input[9] + ")[2]")));
					pass("Email suffix");
				} catch (AssertionError e) {
					fail("Email suffix");
					takeScreenshot();
					resultcount++;
				}			
			} else {
				try {
					Assert.assertFalse(isElementPresent(xpath(input[9])));
					pass("Email suffix");
				} catch (AssertionError e) {
					fail("Email suffix");
					takeScreenshot();
					resultcount++;
				}
				
			} 
		}else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountEmail)));
				pass("Email");
			} catch (AssertionError e) {
				fail("Email");
				takeScreenshot();
				resultcount++;
			}
		}
		
//Mobile Number
		if(input[10].equalsIgnoreCase("mobileActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountMobile)));
				pass("Mobile number");
			} catch (AssertionError e) {
				fail("Mobile number");
				takeScreenshot();
				resultcount++;
			}
			if(input[11].equalsIgnoreCase("mobileReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorMobile)));
					pass("Mobile number validation");
				} catch (AssertionError e) {
					fail("Mobile number validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorMobile)));
					pass("Mobile number validation");
				} catch (AssertionError e) {
					fail("Mobile number validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountMobile)));
				pass("Mobile number");
			} catch (AssertionError e) {
				fail("Mobile number");
				takeScreenshot();
				resultcount++;
			}
		}

//Phone number
		if(input[12].equalsIgnoreCase("phoneActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountPhone)));
				pass("Phone number");
			} catch (AssertionError e) {
				fail("Phone number");
				takeScreenshot();
				resultcount++;
			}
			if(input[13].equalsIgnoreCase("phoneReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorPhone)));
					pass("Phone number validation");
				} catch (AssertionError e) {
					fail("Phone number validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorPhone)));
					pass("Phone number validation");
				} catch (AssertionError e) {
					fail("Phone number validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountPhone)));
				pass("Phone number");
			} catch (AssertionError e) {
				fail("Phone number");
				takeScreenshot();
				resultcount++;
			}
		}
		
//Staff ID
		if(input[14].equalsIgnoreCase("staffIdActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountStaffId)));
				pass("Staff ID / Broker ID");
			} catch (AssertionError e) {
				fail("Staff ID / Broker ID");
				takeScreenshot();
				resultcount++;
			}
			if(input[15].equalsIgnoreCase("staffIdReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorStaffId)));
					pass("Staff ID / Broker ID validation");
				} catch (AssertionError e) {
					fail("Staff ID / Broker ID validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorStaffId)));
					pass("Staff ID / Broker ID validation");
				} catch (AssertionError e) {
					fail("Staff ID / Broker ID validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountStaffId)));
				pass("Staff ID / Broker ID");
			} catch (AssertionError e) {
				fail("Staff ID / Broker ID");
				takeScreenshot();
				resultcount++;
			}
		}
		
//Branch ID
		if(input[16].equalsIgnoreCase("branchIdActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountBranchId)));
				pass("Branch ID");
			} catch (AssertionError e) {
				fail("Branch ID");
				takeScreenshot();
				resultcount++;
			}
			if(input[17].equalsIgnoreCase("branchIdReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorBranchId)));
					pass("Branch ID validation");
				} catch (AssertionError e) {
					fail("Branch ID validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorBranchId)));
					pass("Branch ID validation");
				} catch (AssertionError e) {
					fail("Branch ID validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountBranchId)));
				pass("Branch ID");
			} catch (AssertionError e) {
				fail("Branch ID");
				takeScreenshot();
				resultcount++;
			}
		}
		
//Professional ID
		if(input[18].equalsIgnoreCase("profIdActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountProfId)));
				pass("Professional ID");
			} catch (AssertionError e) {
				fail("Professional ID");
				takeScreenshot();
				resultcount++;
			}
			if(input[19].equalsIgnoreCase("profIdReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorProfId)));
					pass("Professional ID validation");
				} catch (AssertionError e) {
					fail("Professional ID validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorProfId)));
					pass("Professional ID validation");
				} catch (AssertionError e) {
					fail("Professional ID validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountProfId)));
				pass("Professional ID");
			} catch (AssertionError e) {
				fail("Professional ID");
				takeScreenshot();
				resultcount++;
			}
		}
		
//User Role
		if(input[20].equalsIgnoreCase("roleActive")) {
			try {
				Assert.assertTrue(isElementPresent(xpath(myAccountUserRole)));
				pass("User Role");
			} catch (AssertionError e) {
				fail("User Role");
				takeScreenshot();
				resultcount++;
			}
			if(input[21].equalsIgnoreCase("roleReq")) {
				click(xpath(signupDone));
				try {
					Assert.assertTrue(isElementPresent(xpath(signUpErrorUserRole)));
					pass("User Role validation");
				} catch (AssertionError e) {
					fail("User Role validation");
					takeScreenshot();
					resultcount++;
				}
			} else {
				click(xpath(signupDone));
				try {
					Assert.assertFalse(isElementPresent(xpath(signUpErrorUserRole)));
					pass("User Role validation");
				} catch (AssertionError e) {
					fail("User Role validation");
					takeScreenshot();
					resultcount++;
				}
			}
		} else {
			try {
				Assert.assertFalse(isElementPresent(xpath(myAccountUserRole)));
				pass("User Role");
			} catch (AssertionError e) {
				fail("User Role");
				takeScreenshot();
				resultcount++;
			}
		}
		
		
//Username
		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountUsername)));
			pass("Username");
		} catch (AssertionError e) {
			fail("Username");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(signupDone));
		try {
			Assert.assertTrue(isElementPresent(xpath(signUpErrorUsername)));
			pass("Username validation");
		} catch (AssertionError e) {
			fail("Username validation");
			takeScreenshot();
			resultcount++;
		}
	
		
//Password
		
		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountPassword)));
			pass("Password");
		} catch (AssertionError e) {
			fail("Password");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(signupDone));
		try {
			Assert.assertTrue(isElementPresent(xpath(signUpErrorPassword)));
			pass("Password validation");
		} catch (AssertionError e) {
			fail("Password validation");
			takeScreenshot();
			resultcount++;
		}
		
//Confirm Password
		
		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountConfirmPassword)));
			pass("Confirm Password");
		} catch (AssertionError e) {
			fail("Confirm Password");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(signupDone));
		try {
			Assert.assertTrue(isElementPresent(xpath(signUpErrorConfirmPass)));
			pass("Confirm Password validation");
		} catch (AssertionError e) {
			fail("Confirm Password validation");
			takeScreenshot();
			resultcount++;
		}
		
//Security question
		
		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountSecurityQuestion)));
			pass("Security question");
		} catch (AssertionError e) {
			fail("Security question");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(signupDone));
		try {
			Assert.assertTrue(isElementPresent(xpath(signUpErrorSecurityQuestion)));
			pass("Security question validation");
		} catch (AssertionError e) {
			fail("Security question validation");
			takeScreenshot();
			resultcount++;
		}
		
//Security answer

		try {
			Assert.assertTrue(isElementPresent(xpath(myAccountSecurityAnswer)));
			pass("Security answer");
		} catch (AssertionError e) {
			fail("Security answer");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(signupDone));
		try {
			Assert.assertTrue(isElementPresent(xpath(signUpErrorSecurityAnswer)));
			pass("Security answer validation");
		} catch (AssertionError e) {
			fail("Security answer validation");
			takeScreenshot();
			resultcount++;
		}	
		
//Captcha
		try {
			Assert.assertTrue(isElementPresent(xpath(signupCaptcha)));
			pass("Captcha");
		} catch (AssertionError e) {
			fail("Captcha");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(signupDone));
		try {
			Assert.assertTrue(isElementPresent(xpath(signUpErrorCaptcha)));
			pass("Captcha validation");
		} catch (AssertionError e) {
			fail("Captcha validation");
			takeScreenshot();
			resultcount++;
		}	
		

		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	

	
}
