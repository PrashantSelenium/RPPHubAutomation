package hub.utilities.EndToEnd;

import static org.openqa.selenium.By.xpath;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Selenium;

public class UserHubEndToEndUtil_SmokeTest extends FunctionReference {
	ReadXmlData rxml = new ReadXmlData();
	String rpDataRed = rxml.data("rpDataRed");
	private String[] input = null;
	public Selenium selenium;
	
	public UserHubEndToEndUtil_SmokeTest(String[] i) {
		input = i;
	}
	
	//*************************//
	//Enviroment list		   //
	//-------------------------//
	//Stage = "https://stage-" //
	//Dev = "https://dev-"     //
	//Production = "https://"  //
	//						   //
	//*************************//

	//Set Enviroment to the list above depending from what environment you want to run the test	
	public String environment = "https://stage-";
	
	public UserHubEndToEndUtil_SmokeTest() {
	}


	//NOT YET ADDED AS TEST CASE
	public int NewUserRegistration() throws Exception{
		resultcount = 0;
		waitForElementPresent(xpath(registerButton));
		waitForElementVisible(xpath(registerButton));
		
		try{ 
			Assert.assertTrue(isElementPresent(xpath(registerButton)));
			click(xpath(registerButton));
			waitForElementPresent(xpath(signupCaptchaImg));
			
			}
			catch(AssertionError e) {
				fail(input[0] + " - Login - Register Button Invalid Display");
				resultcount++;
				}
								
		try{ 
			Assert.assertTrue(isElementPresent(xpath(signupCaptchaImg)));
			}
			catch(AssertionError e) {
				fail(input[0] + " - Not Redirected in Register Page");
				resultcount++;
				}	

			type(xpath(firstNameReg), input[1]);
			type(xpath(lastNameReg), input[2]);
			type(xpath(staffIDReg), input[3]);
			type(xpath(branchIDReg), input[4]);
			type(xpath(bodyIDReg), input[5]);
			driver.findElement(By.id("userRoleReg")).sendKeys(Keys.DOWN);
			driver.findElement(By.id("userRoleReg")).sendKeys(Keys.DOWN);
			driver.findElement(By.id("userRoleReg")).sendKeys(Keys.ENTER);
			type(xpath(emailReg), input[6]);
			type(xpath(confirmEmailReg), input[7]);
			type(xpath(mobileReg), input[8]);
			type(xpath(phoneReg), input[9]);
			type(xpath(usernameReg), input[10]);
			type(xpath(passwordReg), input[11]);
			type(xpath(confirmPasswordReg), input[12]);
			type(xpath(securityQuestionReg), input[13]);
			type(xpath(answerReg), input[14]);
			click(xpath(agreementReg));
			Thread.sleep(5000);
			
		try{
		    waitForElementPresent(xpath(userPropertySearch));
		    Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));	    	
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Hello User is not properly displayed");
		    	resultcount++;
		    	}

	return resultcount;
	}
	
	public int HealthCheck() throws Exception{
		resultcount = 0;
		
		if(environment.contains("stage")){ 
			driver.navigate().to("https://stage.rppropertyhub.com/healthcheck");}
		if(environment.contains("dev")){ 
			driver.navigate().to("https://dev.rppropertyhub.com/healthcheck");}
		if(environment.equals("https://")){ 
			driver.navigate().to("https://www.rppropertyhub.com/healthcheck");}
		
		waitInSecond(8, dbLabel);
//		Thread.sleep(8000);
		try{
		    Assert.assertTrue(isElementPresent(xpath(dbLabel)));	    	
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Health Check page is not displayed");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(isElementPresent(xpath(HealthCheck)));	
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[1]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Database Connection label is not ok");
		    	resultcount++;
		    	}
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[2]));    	
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - BSG Connection label is not ok");
		    	resultcount++;
		    	}
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[3]));	
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Shared Storage Access Connection label is not ok");
		    	resultcount++;
		    	}
		try{//Merchant	
			Assert.assertFalse(getText(xpath(HealthCheck)).contains(input[4]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Merchant Connection label is still available");
		    	resultcount++;
		    	}
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[7]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Title Authentication Connection label is not ok");
		    	resultcount++;
		    	}
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[6]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Title Document Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[8]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Valex Service Connection label is not ok");
		    	resultcount++;
		    	}
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[9]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - BRE Service Connection label is not ok");
		    	resultcount++;
		    	}
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[10]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - CBA Multi AVM Service Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[11]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Property Profile BSGv3 Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[12]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Location Base Pricing Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[11]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Property Profiler BSGv3 Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[13]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - EVR Service Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[14]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - CPS Service Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[15]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Rulex Service Connection label is not ok");
		    	resultcount++;
		    	}
		
		try{
			Assert.assertTrue(getText(xpath(HealthCheck)).contains(input[16]));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - VMS Service Connection label is not ok");
		    	resultcount++;
		    	}

		return resultcount;
	}
	
	public int SuccessfulLogin() throws Exception{		
		resultcount = 0;	
		String currentURL = driver.getCurrentUrl();
		
		if(currentURL.equalsIgnoreCase("https://dev.rppropertyhub.com/healthcheck")){
			driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/Login"));
		}else{ driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/Login")); }
		
		waitInSecond(3, userLoginUsername);
		//Thread.sleep(3000);
		type(xpath(userLoginUsername), input[1]);
		type(xpath(userLoginPassword), input[2].substring(0,8));
	    click(xpath(LoginButton));
	    
	    //FOR DEV
	    currentURL = driver.getCurrentUrl();
	    if(currentURL.contains("dev")){
	    	waitInSecond(5, propertySearch);
	    	//Thread.sleep(5000);
	    	driver.navigate().to(environment.concat("cbalender.rppropertyhub.com/propertysearch"));
	    }	    
	    
	    try{
	    	waitInSecond(5, propertySearch);
	    	//Thread.sleep(3000);	    	
	    	Assert.assertTrue(isElementPresent(xpath(propertySearch)));	    	
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Property search is not properly displayed");
	    		resultcount++;
	    		}
	    
		return resultcount;
	}
	
	public int validateCantFindAddress() throws Exception{
		resultcount = 0;	

		waitInSecond(5, userCFAButton);
		click(xpath(userCFAButton));
		waitInSecond(5, userCFAConfirm);
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAUnitNumber)));
		} catch (AssertionError e) {
			fail("Unit Number");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetNumber)));
		} catch (AssertionError e) {
			fail("Street Number");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFALotNumber)));
		} catch (AssertionError e) {
			fail("Lot Number");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetName)));
		} catch (AssertionError e) {
			fail("Street Name");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetType)));
		} catch (AssertionError e) {
			fail("Street Type");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStatePostcode)));
		} catch (AssertionError e) {
			fail("State/Postcode");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFABackSearch)));
		} catch (AssertionError e) {
			fail("Back to search");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAClear)));
		} catch (AssertionError e) {
			fail("Clear button");
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAConfirm)));
		} catch (AssertionError e) {
			fail("Confirm button");
			resultcount++;
		}
		
		type(xpath(unitNumberSearchAddress), input[1].substring(0, 1));
		type(xpath(streetNumberSearchAddress), input[2].substring(0,2));
		type(xpath(streetNameSearchAddress), input[3]);
		type(xpath(streetTypeSearchAddress), input[4]);
		type(xpath(suburbSearchAddress), input[5]);
		click(xpath(confirmbtnSearchAddress));
		waitInSecond(8, oevppLabel);
    	//Thread.sleep(8000);
		try{
			waitInSecond(5, oevppLabel);			
			Assert.assertTrue(isElementPresent(xpath(oevppLabel)), "OEVPP Not Displayed");
			Assert.assertTrue(isElementPresent(xpath(proceedToProductSelection)), "OEVPP Not Displayed");		
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Menu validation");
		    	resultcount++;
		    	}
		
		return resultcount;
	}
	
	public int CFACombank() throws Exception{
		
		LoginChannelSmokeTest("cbabroker");
		click(xpath(userCFAButton));
		waitInSecond(5, userCFAConfirm);
		try{
		Assert.assertTrue(isElementPresent(xpath(userCFAConfirm)), "CFA Combank - Confirm button is not displayed");
			}
			catch(AssertionError e){
		    	fail(input[0] + " - Confirm button is not displayed");
		    	resultcount++;
		    	}
		
		type(xpath(unitNumberSearchAddress), input[1].substring(0, 1));
		type(xpath(streetNumberSearchAddress), input[2].substring(0,2));
		type(xpath(streetNameSearchAddress), input[3]);
		type(xpath(streetTypeSearchAddress), input[4]);
		type(xpath(suburbSearchAddress), input[5]);
		click(xpath(confirmbtnSearchAddress));
		
		try{
			waitInSecond(15, propertyNotProvided);
			Assert.assertTrue(getText(xpath(propertyNotProvided)).contains(input[7]), "ComBank CFA - Incorrect Message for Combank");	
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - ComBank CFA - Incorrect Message for Combank");
		    	resultcount++;
		    	}
		
		return resultcount;
	}
	
	public int SingleLineAddress() throws Exception{
		
		if(isElementVisible(xpath(oevppLabel)) || isElementPresent(xpath(oevppLabel))){
			click(xpath(xButton));
		}	else {
		waitInSecond(5, changeAddressLink);
		click(xpath(changeAddressLink));		
		}

		waitInSecond(10, propertySearch);
		type(xpath(propertySearch), input[1]);
		driver.findElement(By.id("hubSearchAddress")).sendKeys(Keys.ENTER);
		waitInSecond(5, completeAddress);
		
	try{
		Assert.assertEquals(input[2], getText(xpath(completeAddress)));
    	}
    	catch(AssertionError e){
    		fail(input[0] + " - Incorrect Address");
    		resultcount++;
    		}

	if(isElementPresent(xpath(pendingTransaction))){
		click(xpath(pendingTransaction));
		}
	
		return resultcount;
	}
	
	public int ProductSelectionValuation() throws Exception{
		waitInSecond(15, unitPriceValuation);		
		if(!(driver.findElements(By.xpath(unitPriceValuation)).size() != 0)){ 	
			waitInSecond(20, purchaseBtn);
				try{
					Assert.assertTrue(isElementPresent(xpath(purchaseBtn)));
					}
					catch(AssertionError e){
						fail(input[0] + " - Purchase Button not available");
						resultcount++;
			    		}
				
				click(xpath(valuationsTab));
				waitInSecond(20, unitPriceValuation);
						}
		
			type(xpath(unitPriceValuation), input[2].substring(0, 6));
			click(xpath(noneApplyCheckboxValuation));
			click(xpath(avm));
			click(xpath(proceedToProductValuation));
			waitInSecond(60, purchaseBtnSingle);	
			click(xpath(purchaseBtnSingle));		
			waitInSecond(60, addToCartLabel);
		try{
			Assert.assertEquals(getText(xpath(addToCartLabel)), input[3]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Add to Cart Label is incorrect");
				resultcount++;
	    		}
		try{
			Assert.assertEquals(getText(xpath(cartCount)), input[4].substring(0, 3));
			}
			catch(AssertionError e){
				fail(input[0] + " - Incorrect cart count");
				resultcount++;
	    		}
		
	return resultcount;
	}
	
	public int instructionDetails() throws Exception{
		waitInSecond(20, nextBtn);
		click(xpath(nextBtn));
		waitInSecond(20, FnameInstructionDetails);

	    try{
	    	Assert.assertTrue(isElementPresent(xpath(FnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}
	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(LnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(MobileInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Mobile Number is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(EmailInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Email is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(OwnerInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Email is not Displayed");
				resultcount++;
	    		}

		type(xpath(FnameInstructionDetails), input[1]);
		type(xpath(LnameInstructionDetails), input[2]);
		type(xpath(MobileInstructionDetails), input[3].substring(0, 10));
		
		return resultcount;
	}
	
	
	public int paymentDetails() throws Exception{
		
		waitInSecond(5, NextBtnInstructionDetails);
		click(xpath(NextBtnInstructionDetails));
		waitInSecond(5, LabelPaymentDetails);
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Label is not Displayed");
				resultcount++;
	    		}
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(AccountPasswordPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Account Password is not Displayed");
				resultcount++;
	    		}
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(AccountIDPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Account ID is not Displayed");
				resultcount++;
	    		}
		waitInSecond(5, AccountIDPaymentDetails);
		click(xpath(TermsandConditionPaymentDetails));
		type(xpath(AccountPasswordPaymentDetails), input[1].substring(0,8));
		type(xpath(AccountIDPaymentDetails), input[2].substring(0, 6));
		
	return resultcount;
	}
	
	public int OrderConfirmation() throws Exception{
		waitInSecond(5, ConfirmBtnPaymentDetails);	
		click(xpath(ConfirmBtnPaymentDetails));
		waitInSecond(7, referenceNumber);	
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumber)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(downloadPDF)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Download PDF is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrder)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(youOrderedLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - You Ordered Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(customerDetailLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Customer Detail Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(fNameInfoOrderConfirmation)), input[1]);
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(lNameInfoOrderConfirmation)), input[2]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(theCustomer)), input[3]);
			}
			catch(AssertionError e){
				fail(input[0] + " - The Customer is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(mobileInfoOrderConfirmation)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Mobile is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrderBTN)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order Button is not Displayed");
				resultcount++;
	    		}

	return resultcount;
	}
	
	public int myTransaction() throws Exception{
		waitInSecond(5, myTransactions);
		click(xpath(myTransactions));
		waitInSecond(20, customerName);
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(customerName)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Customer Name Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(address)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Address Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(serviceType)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Service Type Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumberTransaction)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number Transaction Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(dateTransaction)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Date Transaction Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(statusTransaction)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Status Transaction Label is not Displayed");
				resultcount++;
	    		}
		try{
			Assert.assertTrue(isElementPresent(xpath(customerNameDetail)));
	    	//Assert.assertEquals(getText(xpath(customerNameDetail)), input[1]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Customer Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(addressDetail)), input[2]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Address is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(serviceTypeDetail)), input[3]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Service Type is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumberDetail)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number is not Displayed");
				resultcount++;
			}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(statusTansactionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Status is not Displayed");
				resultcount++;
			}
		
	return resultcount;
}
	
	public int Logout() throws Exception{
		waitInSecond(5, logout);
		click(xpath(logout));
		waitInSecond(5, userLoginUsername);
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Username is not Displayed");
				resultcount++;
			}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Password is not Displayed");
				resultcount++;
			}
		
		return resultcount;
	}
	
	public int deepLink() throws Exception{
		
		String Url = environment.concat("class.rppropertyhub.com/ProductSelection?propertyId=1976129");
		driver.navigate().to(Url);
		waitInSecond(10, userLoginUsername);
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(userLoginUsername)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Username is not Displayed");
				resultcount++;
			}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(userLoginPassword)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Password is not Displayed");
				resultcount++;
			}
		
		click(xpath(registerButton));
		waitInSecond(15, signupCaptchaImg);
		try{ 
			Assert.assertTrue(isElementPresent(xpath(signupCaptchaImg)));
			}
			catch(AssertionError e) {
				fail(input[0] + " - Not Redirected in Register Page");
				resultcount++;
				}	
		try{ 
			Assert.assertTrue(isElementPresent(xpath(firstNameReg)));
			}
			catch(AssertionError e) {
				fail(input[0] + " - Not Redirected in Register Page");
				resultcount++;
				}	
		try{ 
			Assert.assertTrue(isElementPresent(xpath(lastNameReg)));
			}
			catch(AssertionError e) {
				fail(input[0] + " - Not Redirected in Register Page");
				resultcount++;
				}	
		return resultcount;
	}
	
	public int adminPromotion(String PromoCode) throws Exception{
		
		driver.navigate().to(environment.concat("class.rppropertyhub.com/Admin"));
		waitInSecond(15, loginAdminUsername);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(loginAdminUsername)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Username is not Displayed");
				resultcount++;
			}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(loginAdminPassword)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Password is not Displayed");
				resultcount++;
			}
		
		type(xpath(loginAdminUsername), input[2]);
		type(xpath(loginAdminPassword), input[3]);
		click(xpath(loginAdminBtn));
		waitInSecond(30, adminHomeMenu);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(adminHomeMenu)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Home menu is not Displayed");
				resultcount++;
			}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(adminChannelsMenu)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Channel menu is not Displayed");
				resultcount++;
			}
		
		actionType(xpath(adminProducts), "Promotions");
	    click(xpath(adminPromotionLink));
	    waitInSecond(10, baseProductAddNew);
	    click(xpath(baseProductAddNew));
	    waitInSecond(10, adminPromotionName);
	   
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		
	    type(xpath(adminPromotionName), input[4].concat(dateFormat.format(date)));
	    type(xpath(adminPromotionDescription), input[5]);
	    
	    //promoCode = input[6].concat(dateFormat.format(date));

	    type(xpath(adminPromotionCodePrefix), PromoCode);
	    type(xpath(adminPromotionCodeNumber), input[7].substring(0,1));
	    click(xpath(adminPromotionCodeMultiplierUnliCheckbox));
	    Thread.sleep(1000);
	    click(xpath(adminPromotionUserLimitUnliCheckbox));
	    Thread.sleep(2000);
	    click(xpath(adminPromotionStartDate));
	    Thread.sleep(2000);
	    click(xpath(adminPromotionStartDateNow));
	    Thread.sleep(2000);
	    driver.findElement(By.id("endDate")).sendKeys(Keys.TAB);
	    Thread.sleep(2000);
	    click(xpath(adminPromotionFinishDate));
	    click(xpath(adminPromotionFinishDate));
	    Thread.sleep(2000);
	    if(isElementPresent(xpath(adminPromotionFinishDate30))){
	    	click(xpath(adminPromotionFinishDate30));
	    	}else{
	    		click(xpath(adminPromotionFinishDate28));
	    		}
	    	
	    Thread.sleep(1000);
	    click(xpath(adminPromotionTypeValue));
	    type(xpath(adminPromotionTypeValue), input[8].substring(0, 2));
	    
	    Select dropdown = new Select(driver.findElement(By.id("channelId")));
	    dropdown.selectByValue("9");
	    driver.findElement(By.id("channelId")).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    driver.findElement(By.id("channelId")).sendKeys(Keys.TAB);
	    //click(xpath(adminPromotionBaseProduct));
	    //click(xpath("//*[@value='115']"));
	    Thread.sleep(500);
	    driver.findElement(By.id("baseProductId")).sendKeys(Keys.DOWN);
	    click(xpath(adminPromotionDaySun));
	    click(xpath(adminPromotionDayMon));
	    click(xpath(adminPromotionDayTue));
	    click(xpath(adminPromotionDayWed));
	    click(xpath(adminPromotionDayThur));
	    click(xpath(adminPromotionDayFri));
	    click(xpath(adminPromotionDaySat));
	    
	    click(xpath(adminPromotionRegionACT));
	    click(xpath(adminPromotionRegionNT));
	    click(xpath(adminPromotionRegionNSW));
	    click(xpath(adminPromotionRegionQLD));
	    click(xpath(adminPromotionRegionSA));
	    click(xpath(adminPromotionRegionTAS));
	    click(xpath(adminPromotionRegionVIC));
	    click(xpath(adminPromotionRegionWA));
	    
	    click(xpath(adminPromotionSave));
	    
//	Thread.sleep(3000);
	waitInSecond(5, adminLinkLogout);
	click(xpath(adminLinkLogout));
	Thread.sleep(1000);
	return resultcount;
	}
	
	public void alertAccept() throws Exception{
		int val = alertvalidation();
		
		if(val != 0){ }
		else{
			driver.switchTo().alert().accept();
		}
	    Thread.sleep(2000);
		}

		public int alertvalidation() throws Exception{
		try{
	        driver.switchTo().alert();
	        return 0;
	    }//try
	    catch(Exception e){
	    	return 1;
	    }
		}
	
	public int myAccount() throws Exception{		
		resultcount = 0;	
		driver.navigate().to(environment.concat("acme.rppropertyhub.com"));
		alertvalidation();
		alertAccept();
		waitInSecond(15, userLoginUsername);
		type(xpath(userLoginUsername), input[1]);
		type(xpath(userLoginPassword), input[2].substring(0,8));
	    click(xpath(LoginButton));
	    try{
	    	waitInSecond(15, userPropertySearch);
	    	Assert.assertTrue(isElementPresent(xpath(propertySearch)));	    	
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Property search is not properly displayed");
	    		resultcount++;
	    		}

	    click(xpath(myAccount));
	    waitInSecond(20, myAccountFN);
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(myAccountFN)));	    	
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - First Name is not properly displayed");
	    		resultcount++;
	    		}
	    	
	    	type(xpath(myAccountFN), input[3]);
	    	type(xpath(myAccountLN), input[4]);
	    	click(xpath(myAccountSavebtn));
	    	waitInSecond(20, myAccountDialogBoxOK);
	    	click(xpath(myAccountDialogBoxOK));
	    	waitInSecond(20, myAccountFN);
	    	Thread.sleep(2000);
	    	
		    try{
		    	Assert.assertEquals(getValue(xpath(myAccountFN)), input[3]);	   
		    	Assert.assertEquals(getValue(xpath(myAccountLN)), input[4]);	   
		    	}
		    	catch(AssertionError e){
		    		fail(input[0] + " - Not properly saved");
		    		resultcount++;
		    		}
	    	
		return resultcount;
	}
	
	public int menuNavigation() throws Exception{
		
		resultcount = 0;	

	    click(xpath(home));
	    waitInSecond(15, userPropertySearch);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(userPropertySearch)));
			}
			catch(AssertionError e){
				fail(input[0] + " - " + input[1] + " Menu is not working");
				resultcount++;
			}
		
		if(isElementPresent(xpath(rpProfessional)))
			{
			click(xpath(rpProfessional));
			waitInSecond(15, RPPusername);
			try{
		    	Assert.assertTrue(isElementPresent(xpath(RPPusername)));
				}
				catch(AssertionError e){
					fail(input[0] + " - " + input[2] + " Menu is not working");
					resultcount++;
				}
			}
		
		click(xpath(myAccount));
		waitInSecond(15, myAccountFN);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(myAccount)));
			}
			catch(AssertionError e){
				fail(input[0] + " - " + input[3] + " Menu is not working");
				resultcount++;
			}
		
		click(xpath(myTransactions));
		waitInSecond(15, userMyTransactionList);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(myTransactions)));
			}
			catch(AssertionError e){
				fail(input[0] + " - " + input[4] + " Menu is not working");
				resultcount++;
			}
		return resultcount;
	}
	
	public void waitfor() throws Exception{
	Thread.sleep(12000);
	}
	
	public int EndToEnd(String channel) throws Exception{		
		resultcount = 0;	
		if(channel.equals("wpcbroker")){			
			driver.navigate().to(environment.concat("wpcbroker.rppropertyhub.com"));
		}
		if(channel.equals("bankmelbourne")){
			driver.navigate().to(environment.concat("bankmelbourne.rppropertyhub.com"));
		}
		alertvalidation();
		alertAccept();
		
		LoginChannelSmokeTest(channel);

	    type(xpath(propertySearch), input[3]);
		Thread.sleep(2000);
		driver.findElement(By.id("hubSearchAddress")).sendKeys(Keys.ENTER);
		waitInSecond(15, completeAddress);    	
		
	try{
		Assert.assertEquals(input[4], getText(xpath(completeAddress)));
    	}
    	catch(AssertionError e){
    		fail(input[0] + " - Incorrect Address");
    		resultcount++;
    		}

	if(isElementPresent(xpath(pendingTransaction))){
		click(xpath(pendingTransaction));
		}
		waitInSecond(15, productNavBar);   	
		try{
			Assert.assertEquals(input[4], getText(xpath(completeAddress)));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Incorrect Address");
		    	resultcount++;
		    	}
		waitInSecond(20, purchaseBtn);

		try{
			Assert.assertTrue(isElementPresent(xpath(purchaseBtn)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Purchase Button not available");
				resultcount++;
	    		}
		waitInSecond(25, purchaseBtnSingle);
		if(channel.equals("wpcbroker")){
			click(xpath(purchaseBtnSingle));
		}
		if(channel.equals("bankmelbourne")){
			if(isElementPresent(xpath(purchaseBtnSecondLine))){
				click(xpath(purchaseBtnSecondLine));	
			}
			else{
				click(xpath(purchaseBtnSingle));
			}
		}
		waitInSecond(30, addToCartLabel);
		try{
			Assert.assertEquals(getText(xpath(addToCartLabel)), input[6]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Add to Cart Label is incorrect");
				resultcount++;
	    		}
		try{
			Assert.assertEquals(getText(xpath(cartCount)), input[5].substring(0, 3));
			}
			catch(AssertionError e){
				fail(input[0] + " - Incorrect cart count");
				resultcount++;
	    		}
		waitInSecond(15, nextBtn);
	    Assert.assertTrue(isElementPresent(xpath(nextBtn)), "Element is not present");	
		click(xpath(nextBtn));
		    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(FnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(LnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(MobileInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Mobile Number is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(EmailInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Email is not Displayed");
				resultcount++;
	    		}

		type(xpath(FnameInstructionDetails), input[7]);
		type(xpath(LnameInstructionDetails), input[8]);
		waitInSecond(15, NextBtnInstructionDetails);
		click(xpath(NextBtnInstructionDetails));
		waitInSecond(20, LabelPaymentDetails);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Label is not Displayed");
				resultcount++;
	    		}
		
		if(channel.equals("wpcbroker")){
			try{
		    	Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)));
				}
				catch(AssertionError e){
					fail(input[0] + " - Terms and Condition is not Displayed");
					resultcount++;
		    		}
			try{
		    	Assert.assertTrue(isElementPresent(xpath(AccountPasswordPaymentDetails)));
				}
				catch(AssertionError e){
					fail(input[0] + " - Account Password is not Displayed");
					resultcount++;
		    		}
			
			try{
		    	Assert.assertTrue(isElementPresent(xpath(AccountIDPaymentDetails)));
				}
				catch(AssertionError e){
					fail(input[0] + " - Account ID is not Displayed");
					resultcount++;
		    		}
			waitInSecond(25, AccountIDPaymentDetails);
			click(xpath(TermsandConditionPaymentDetails));
			type(xpath(AccountPasswordPaymentDetails), input[9].substring(0,8));
			type(xpath(AccountIDPaymentDetails), input[10].substring(0, 6));
		}
		
		click(xpath(ConfirmBtnPaymentDetails));
		waitInSecond(15, openReportpopup);
		if(channel.equals("wpcbroker")){
			click(xpath(noBTN));
		}
		if(channel.equals("bankmelbourne")){
			click(xpath(yesBTN));
		}
		waitInSecond(25, referenceNumber);		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumber)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(downloadPDF)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Download PDF is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrder)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order is not Displayed");
				resultcount++;
	    		}

		try{
	    	Assert.assertTrue(isElementPresent(xpath(youOrderedLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - You Ordered Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(customerDetailLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Customer Detail Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(fNameInfoOrderConfirmation)), input[7]);
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(lNameInfoOrderConfirmation)), input[8]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrderBTN)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order Button is not Displayed");
				resultcount++;
	    		}
		
		return resultcount;
	}
	
	public int aussieSelectEndToEnd() throws Exception{		
		resultcount = 0;	
		driver.navigate().to(environment.concat("aussieselect.rppropertyhub.com"));
		alertvalidation();
		alertAccept();
		
		LoginChannelSmokeTest("aussieselect");

	    type(xpath(propertySearch), input[3]);
		Thread.sleep(2000);
		driver.findElement(By.id("hubSearchAddress")).sendKeys(Keys.ENTER);
		//click(xpath(userSearchButton));
		waitInSecond(15, completeAddress);
    	
	try{
		Assert.assertEquals(input[4], getText(xpath(completeAddress)));
    	}
    	catch(AssertionError e){
    		fail(input[0] + " - Incorrect Address");
    		resultcount++;
    		}

	if(isElementPresent(xpath(pendingTransaction))){
		click(xpath(pendingTransaction));
		}
	
		waitInSecond(15, productNavBar);
		try{
			Assert.assertEquals(input[4], getText(xpath(completeAddress)));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Incorrect Address");
		    	resultcount++;
		    	}

		waitInSecond(5, unitValuation);		
		if(!getValue(xpath(unitValuation)).equals("7")){
			int x=0;
			do{
			driver.findElement(By.id("1")).sendKeys(Keys.DOWN);
			x++;
			}while(x<7);
			driver.findElement(By.id("1")).sendKeys(Keys.ENTER);
		}

		type(xpath(unitPriceValuation),input[11].substring(0, 6));
		click(xpath(noneApplyCheckboxValuation));
		click(xpath(avm));
		click(xpath(proceedToProductValuation));
		waitInSecond(30, purchaseBtnSingle);		

		try{
			Assert.assertEquals(getValue(xpath(purchaseBtnSingle)), "Not Available");
			}
			catch(AssertionError e){
				fail(input[0] + " - Purchase Button for AVM is available");
				resultcount++;
	    		}

		if(isElementPresent(xpath(purchaseBtnSecondLine))){
			waitInSecond(15, purchaseBtnSecondLine);
			click(xpath(purchaseBtnSecondLine));
		}else{
			waitInSecond(15, purchaseBtnSingle);
			click(xpath(purchaseBtnSingle));
		}
		
		waitInSecond(5, addToCartLabel);		
		try{
			Assert.assertEquals(getText(xpath(addToCartLabel)), input[6]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Add to Cart Label is incorrect");
				resultcount++;
	    		}
		try{
			Assert.assertEquals(getText(xpath(cartCount)), input[5].substring(0, 3));
			}
			catch(AssertionError e){
				fail(input[0] + " - Incorrect cart count");
				resultcount++;
	    		}
		waitInSecond(5, nextBtn);
	    Assert.assertTrue(isElementPresent(xpath(nextBtn)), "Element is not present");	
		click(xpath(nextBtn));
		waitInSecond(10, FnameInstructionDetails);
		
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(FnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(LnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(MobileInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Mobile Number is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(EmailInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Email is not Displayed");
				resultcount++;
	    		}

		type(xpath(FnameInstructionDetails), input[7]);
		type(xpath(LnameInstructionDetails), input[8]);
		type(xpath(MobileInstructionDetails), input[12].substring(0, 9));
		click(xpath(instructionDetailSameAsCustomerCheckbox));
		waitInSecond(10, NextBtnInstructionDetails);
		click(xpath(NextBtnInstructionDetails));
		waitInSecond(20, LabelPaymentDetails);
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Label is not Displayed");
				resultcount++;
	    		}		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Terms and Condition is not Displayed");
				resultcount++;
	    		}		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(AccountPasswordPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Account Password is not Displayed");
				resultcount++;
	    		}		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(AccountIDPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Account ID is not Displayed");
				resultcount++;
	    		}
		waitInSecond(15, AccountIDPaymentDetails);
		click(xpath(TermsandConditionPaymentDetails));
		type(xpath(AccountPasswordPaymentDetails), input[9].substring(0,8));
		type(xpath(AccountIDPaymentDetails), input[10].substring(0, 6));
		click(xpath(ConfirmBtnPaymentDetails));
		waitInSecond(15, referenceNumber);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumber)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(downloadPDF)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Download PDF is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrder)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order is not Displayed");
				resultcount++;
	    		}

		try{
	    	Assert.assertTrue(isElementPresent(xpath(youOrderedLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - You Ordered Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(customerDetailLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Customer Detail Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(fNameInfoOrderConfirmationAussie)), input[7]);
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(lNameInfoOrderConfirmationAussie)), input[8]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrderBTN)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order Button is not Displayed");
				resultcount++;
	    		}
		
		return resultcount;
	}
	
	public int EndToEndCBABroker() throws Exception{		
		resultcount = 0;	
		driver.navigate().to(environment.concat("cbabroker.rppropertyhub.com"));
		alertvalidation();
		alertAccept();
		waitInSecond(15, userLoginUsername);
		type(xpath(userLoginUsername), input[1]);
		type(xpath(userLoginPassword), input[2].substring(0,8));
	    click(xpath(LoginButton));
	    try{
	    	waitInSecond(15, userPropertySearch);
	    	Assert.assertTrue(isElementPresent(xpath(propertySearch)));	    	
	    	}
	    	catch(AssertionError e){
	    		fail(input[0] + " - Property search is not properly displayed");
	    		resultcount++;
	    		}

	    type(xpath(propertySearch), input[3]);
		Thread.sleep(2000);
		driver.findElement(By.id("hubSearchAddress")).sendKeys(Keys.ENTER);
		waitInSecond(15, completeAddress);
		    	
	try{
		Assert.assertEquals(input[4], getText(xpath(completeAddress)));
    	}
    	catch(AssertionError e){
    		fail(input[0] + " - Incorrect Address");
    		resultcount++;
    		}

	if(isElementPresent(xpath(pendingTransaction))){
		click(xpath(pendingTransaction));
		}
		waitInSecond(15, productNavBar);	
		try{
			Assert.assertEquals(input[4], getText(xpath(completeAddress)));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Incorrect Address");
		    	resultcount++;
		    	}

		try{
			waitInSecond(5, productNavBar);	
			Assert.assertTrue(isElementPresent(xpath(productNavBar)));
			Assert.assertTrue(isElementPresent(xpath(instructionNavBar)));
			Assert.assertTrue(isElementPresent(xpath(paymentNavBar)));
			Assert.assertTrue(isElementPresent(xpath(orderNavBar)));
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Navigation Bar validation");
		    	resultcount++;
		    	}
		waitInSecond(20, purchaseBtnSingle);	
		try{
			Assert.assertTrue(isElementPresent(xpath(combanklabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Combank is not listed in Product selection page");
				resultcount++;
	    		}
		
		waitInSecond(5, purchaseBtnSingle);
		click(xpath(purchaseBtnSingle));
		waitInSecond(15, addToCartLabel);
		try{
			Assert.assertEquals(getText(xpath(addToCartLabel)), input[6]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Add to Cart Label is incorrect");
				resultcount++;
	    		}
		try{
			Assert.assertEquals(getText(xpath(cartCount)), input[5].substring(0, 3));
			}
			catch(AssertionError e){
				fail(input[0] + " - Incorrect cart count");
				resultcount++;
	    		}
		waitInSecond(15, nextBtn);
	    Assert.assertTrue(isElementPresent(xpath(nextBtn)), "Element is not present");	
		click(xpath(nextBtn));
		waitInSecond(5, FnameInstructionDetails);	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(FnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}
	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(LnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(MobileInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Mobile Number is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(EmailInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Email is not Displayed");
				resultcount++;
	    		}

		type(xpath(FnameInstructionDetails), input[7]);
		type(xpath(LnameInstructionDetails), input[8]);
		waitInSecond(10, NextBtnInstructionDetails);
		click(xpath(NextBtnInstructionDetails));
		waitInSecond(15, LabelPaymentDetails);
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Label is not Displayed");
				resultcount++;
	    		}
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Terms and Condition is not Displayed");
				resultcount++;
	    		}
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(AccountPasswordPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Account Password is not Displayed");
				resultcount++;
	    		}
		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(AccountIDPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Account ID is not Displayed");
				resultcount++;
	    		}
		waitInSecond(15, AccountIDPaymentDetails);
		click(xpath(TermsandConditionPaymentDetails));
		type(xpath(AccountPasswordPaymentDetails), input[9].substring(0,8));
		type(xpath(AccountIDPaymentDetails), input[10].substring(0, 6));
		waitInSecond(15, ConfirmBtnPaymentDetails);
		click(xpath(ConfirmBtnPaymentDetails));
		waitInSecond(15, referenceNumber);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumber)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(downloadPDF)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Download PDF is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrder)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order is not Displayed");
				resultcount++;
	    		}

		try{
	    	Assert.assertTrue(isElementPresent(xpath(youOrderedLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - You Ordered Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(customerDetailLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Customer Detail Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(fNameInfoOrderConfirmationAussie)), input[7]);
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(lNameInfoOrderConfirmationAussie)), input[8]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrderBTN)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order Button is not Displayed");
				resultcount++;
	    		}
		
		return resultcount;
	}
	
	public int BuildVersion() throws Exception{		
		resultcount = 0;	
		driver.navigate().to(environment.concat("cbabroker.rppropertyhub.com"));
		alertvalidation();
		alertAccept();
		waitInSecond(5, BuildVersion);
		
		try{
	    	Assert.assertTrue(getText(xpath(BuildVersion)).contains(input[1]));
			}
			catch(AssertionError e){
				fail(input[0] + " - Incorrect Build Version");
				resultcount++;
	    		}
		return resultcount;
	}
	
	public int PromotionWorkFlow(String PromoCode) throws Exception{		
		resultcount = 0;	
		LoginChannelSmokeTest("class");

	    type(xpath(propertySearch), input[3]);
		Thread.sleep(1000);
		driver.findElement(By.id("hubSearchAddress")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		if(isElementPresent(xpath(pendingTransaction))){
		click(xpath(pendingTransaction));
		}	
		waitInSecond(10, unitPriceValuation);				
		type(xpath(unitPriceValuation),input[13].substring(0, 6));
		if(isElementPresent(xpath(loanAmount))){
			type(xpath(loanAmount),input[14].substring(0, 6));
		}
		if(isElementPresent(xpath(noneApplyCheckboxValuation))){
			click(xpath(noneApplyCheckboxValuation));
		}
		click(xpath(proceedToProductValuation));
		waitInSecond(20, purchaseBtnSingle);			
		click(xpath(CommercialTab));
		waitInSecond(20, promotionLogo);
		Assert.assertTrue(isElementPresent(xpath(promotionLogo)), "Promotion Logo is not Displayed");
		waitInSecond(15, purchaseBtnFifthLine);
		click(xpath(purchaseBtnFifthLine));
		waitInSecond(15, addToCartLabel);

		try{
			Assert.assertEquals(getText(xpath(addToCartLabel)), input[6]);
			}
			catch(AssertionError e){
				fail(input[0] + " - Add to Cart Label is incorrect");
				resultcount++;
	    		}
		try{
			Assert.assertEquals(getText(xpath(cartCount)), input[5].substring(0, 3));
			}
			catch(AssertionError e){
				fail(input[0] + " - Incorrect cart count");
				resultcount++;
	    		}
		waitInSecond(5, nextBtn);
	    Assert.assertTrue(isElementPresent(xpath(nextBtn)), "Element is not present");	
		click(xpath(nextBtn));
		waitInSecond(7, FnameInstructionDetails);
		    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(FnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}	    
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(LnameInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(MobileInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Mobile Number is not Displayed");
				resultcount++;
	    		}
	    try{
	    	Assert.assertTrue(isElementPresent(xpath(EmailInstructionDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Email is not Displayed");
				resultcount++;
	    		}

		type(xpath(FnameInstructionDetails), input[7]);
		type(xpath(LnameInstructionDetails), input[8]);
		type(xpath(MobileInstructionDetails), input[12].substring(0, 9));
		type(xpath(EmailInstructionDetails), input[11]);
		type(xpath(CompanyNameInstructionDetails), input[15].substring(0, 9));

		click(xpath(instructionDetailSameAsCustomerCheckbox));
		Thread.sleep(1000);
		
		type(xpath(NetLendableInstructionDetails), input[16].substring(0, 3));
		type(xpath(RentalAmountInstructionDetails), input[16].substring(0, 3));
		type(xpath(OutgoingMonthlyInstructionDetails), input[16].substring(0, 3));
		waitInSecond(7, NextBtnInstructionDetails);
		click(xpath(NextBtnInstructionDetails));
		waitInSecond(40, LabelPaymentDetails);
	
		try{
	    	Assert.assertTrue(isElementPresent(xpath(LabelPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Label is not Displayed");
				resultcount++;
	    		}		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Terms and Condition is not Displayed");
				resultcount++;
	    		}		
		try{
	    	Assert.assertTrue(isElementPresent(xpath(PromoLabel)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Promo Field is not Displayed");
				resultcount++;
	    		}

		waitInSecond(20, PromoLabel);
		Double RegularPrice = Double.parseDouble(getText(xpath(ProductPrice)).substring(1).trim());
		Double Price = RegularPrice / 2;
		
		type(xpath(PromoField), PromoCode);
		Thread.sleep(500);
		click(xpath(PromoAddBtn));		
		waitInSecond(30, MainTotalAmount);
		Thread.sleep(8000);
		Double TotalAmount = Double.parseDouble(getText(xpath(MainTotalAmount)).substring(1).trim());
				
		try{
			Assert.assertTrue(Price.toString().equals(TotalAmount.toString()));
			}
			catch(AssertionError e){
				fail(input[0] + " - Price is not properly Discounted - Actual Price " + Price + " - Expected Price " + TotalAmount );
				resultcount++;
	    		}

		Thread.sleep(5000);
		click(xpath(TermsandConditionPaymentDetails));
		type(xpath(InvoiceName), input[1]);
		type(xpath(InvoiceEmail), input[11]);
		waitInSecond(15, ConfirmBtnPaymentDetails);
		click(xpath(ConfirmBtnPaymentDetails));
		waitInSecond(60, CPSIframe);
		Assert.assertTrue(isElementPresent(xpath(CPSIframe)), "CPS Iframe not yet displayed");
		
		driver.switchTo().frame(driver.findElement(By.xpath(CPSIframe)));
				
		Assert.assertTrue(isElementPresent(xpath(CPSCardNumber)), "CPS Card Number not yet displayed");
		type(xpath(CPSCardNumber), input[17].substring(0, 16).concat("111"));
		type(xpath(CPSCardHolderName), input[8]);
		type(xpath(CPSDateExpiry), "12");
		type(xpath(CPSDateExpiry2), "15");
		type(xpath(CPSCvc2), "1234");
		
		
		//STOP HERE IF TESTING IN PROD
		if(environment.contains("dev") || environment.contains("stage"))
		{
		waitInSecond(5, CPSAddbtn);
		click(xpath(CPSAddbtn));
		Thread.sleep(10000);
		driver.switchTo().defaultContent();			
		waitInSecond(80, referenceNumber);
		try{
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumber)), "Promotion Workflow - Reference Number not displayed");
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(downloadPDF)), "Promotion Workflow - Download PDF not displayed");
			}
			catch(AssertionError e){
				fail(input[0] + " - Download PDF is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrder)), "Promotion Workflow - Start New Order not displayed");
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(youOrderedLabel)), "Promotion Workflow - Product Name not displayed");
			}
			catch(AssertionError e){
				fail(input[0] + " - You Ordered Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(customerDetailLabel)), "Promotion Workflow - Customer Detail not displayed");
			}
			catch(AssertionError e){
				fail(input[0] + " - Customer Detail Label is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(fNameInfoOrderConfirmationAussie)), input[7], "Promotion Workflow - Incorrect First Name");
			}
			catch(AssertionError e){
				fail(input[0] + " - First Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertEquals(getText(xpath(lNameInfoOrderConfirmationAussie)), input[8], "Promotion Workflow - Incorrect Last Name");
			}
			catch(AssertionError e){
				fail(input[0] + " - Last Name is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrderBTN)), "Promotion Workflow - Start new order Button not displayed");
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order Button is not Displayed");
				resultcount++;
	    		}
		}
		
		return resultcount;
	}
	
	public int ResetPassword() throws Exception{
		
		resultcount = 0;	
		driver.navigate().to(environment.concat("acme.rppropertyhub.com/login"));
		if(isElementPresent(xpath(logout))){
			click(xpath(logout));
			waitInSecond(20, userForgotPasswordBtn);
		}
		
			try{
				Assert.assertTrue(isElementPresent(xpath(userForgotPasswordBtn)), "Reset Password - Forgot Password Button is not displayed");
			} catch(AssertionError e){
		    	fail(input[0] + " - Forgot Password Button is not displayed");
		    	resultcount++;
		    	}	
			
			click(xpath(userForgotPasswordBtn));
			type(xpath(forgotPasswordUsername), input[1]);
			type(xpath(forgotPasswordEmail), input[2]);
			click(xpath(userResetPasswordBtn));
			waitInSecond(20, ForgotPasswordImageVerification);
			try{
				Assert.assertTrue(isElementPresent(xpath(ForgotPasswordImageVerification)), "Reset Password - Forgot Password Image Verification is not displayed");
			} catch(AssertionError e){
		    	fail(input[0] + " - Forgot Password Image Verification is not displayed");
		    	resultcount++;
		    	}	
			//Login to Gmail
			driver.navigate().to("http://mail.google.com/");
			
			try{
				Assert.assertTrue(isElementPresent(xpath(gmailEmail)), "Reset Password - Gmail Email is not displayed");
			} catch(AssertionError e){
		    	fail(input[0] + " - Gmail Email is not displayed");
		    	resultcount++;
		    	}
			waitInSecond(20, gmailEmail);
			type(xpath(gmailEmail), input[2]);
			click(xpath(gmailNextBtn));
			waitInSecond(10, gmailPassword);
			try{
				Assert.assertTrue(isElementPresent(xpath(gmailPassword)), "Reset Password - Gmail Password is not displayed");
			} catch(AssertionError e){
				fail(input[0] + " - Gmail Password is not displayed");
				resultcount++;
				}	
			type(xpath(gmailPassword), input[4]);
			click(xpath(gmailSignInBtn));
			waitInSecond(20, gmailInboxlink);
			try{
				Assert.assertTrue(isElementPresent(xpath(gmailInboxlink)), "Reset Password - Gmail Inbox is not displayed");
			} catch(AssertionError e){
		    	fail(input[0] + " - Gmail Inbox is not displayed");
		    	resultcount++;
		    	}	
			click(xpath(gmailTopInbox));
			waitInSecond(20, gmailHubLink);
			try{
				Assert.assertTrue(isElementPresent(xpath(gmailHubLink)), "Reset Password - Gmail Hub link is not displayed");
			} catch(AssertionError e){
		    	fail(input[0] + " - Gmail Hub link is not displayed");
		    	resultcount++;
		    	}	
			//Go back to Hub Reset Password
			String URL = driver.findElement(xpath(gmailHubLink)).getAttribute("href");
			driver.navigate().to(URL);
			waitInSecond(20, userResetPasswordNewPass);
			try{
				Assert.assertTrue(isElementPresent(xpath(userResetPasswordNewPass)), "Reset Password - New Password field is not displayed");
			} catch(AssertionError e){
		    	fail(input[0] + " - New Password field is not displayed");
		    	resultcount++;
		    	}	
			type(xpath(userResetPasswordNewPass), input[3]);
			type(xpath(userResetPasswordConfirmPass), input[3]);
			waitInSecond(10, userResetPasswordConfirmPass);
			click(xpath(resetPasswordBtn));
			waitInSecond(20, flashMessage);
			try{
				Assert.assertTrue(getText(xpath(flashMessage)).contains(input[5]), "Reset Password - Reset Password not Succesful");
			} catch(AssertionError e){
		    	fail(input[0] + " - Reset Password not Succesful");
		    	resultcount++;
		    	}	
		return resultcount;		
	}
	
	public int identityVerification() throws Exception{
		resultcount = 0;	
		 
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		LoginChannelSmokeTest("acme");
		util.slas_dynamic(input[1]);
		Thread.sleep(2000);
		util.startNewTransaction();
		util.Product_Selection_select_Product("4");
		util.ProceedToInstructionDetails_ClickLink();
		util.Instruction_Input_Fields();
		util.Payment_Successful_OnAccount_Purchase("Confirm");
		Thread.sleep(2000);
		try{
			Assert.assertTrue(isElementPresent(xpath(identityVerificationResult)), "Identity Verification - Result is not Displayed");			
		    }
		    catch(AssertionError e){
		    	fail(input[0] + " - Result is not displayed");
		    	resultcount++;
		    	}		
		return resultcount;		
	}
	
	public int propertyTitle() throws Exception{
		resultcount = 0;	
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		LoginChannelSmokeTest("class");
		driver.navigate().to(environment.concat("class.rppropertyhub.com/ProductSelection?propertyId=7003499"));
		util.startNewTransaction();
		Assert.assertTrue(isElementPresent(xpath(userOEVPP)), "Property Title - OEVPP is not displayed");
		type(xpath(userOEVPP), "500000");
		waitInSecond(5, userOriginatorToProductSelection);
		click(xpath(userOriginatorToProductSelection));
		waitInSecond(20, purchaseBtnSingle);	
		Assert.assertTrue(isElementPresent(xpath(landTitlesTab)), "Property Title - Land Title tab is not displayed");
		click(xpath(landTitlesTab));
		Thread.sleep(5000);
		click(xpath(purchaseBtnSecondLine));
		waitInSecond(20, addToCartLabel);
		util.ProceedToInstructionDetails_ClickLink();
		util.Instruction_Input_Fields();
		waitInSecond(20, TermsandConditionPaymentDetails);
		Assert.assertTrue(isElementPresent(xpath(TermsandConditionPaymentDetails)), "Terms and Condition not yet displayed");
		click(xpath(TermsandConditionPaymentDetails));
		type(xpath(InvoiceName), "Arvin");
		type(xpath(InvoiceEmail), "arvin.twano@tooltwist.com");
		click(xpath(ConfirmBtnPaymentDetails));
		waitInSecond(80, CPSIframe);	
		Assert.assertTrue(isElementPresent(xpath(CPSIframe)), "CPS Iframe not yet displayed");
		
		driver.switchTo().frame(driver.findElement(By.xpath(CPSIframe)));
				
		Assert.assertTrue(isElementPresent(xpath(CPSCardNumber)), "CPS Card Number not yet displayed");
		type(xpath(CPSCardNumber), "4111111111111111");
		type(xpath(CPSCardHolderName), "Arvin");
		type(xpath(CPSDateExpiry), "12");
		type(xpath(CPSDateExpiry2), "15");
		type(xpath(CPSCvc2), "1234");	
		
		//STOP HERE IF TESTING IN PROD
		if(environment.contains("dev") || environment.contains("stage"))
		{
		click(xpath(CPSAddbtn));
		Thread.sleep(10000);
		driver.switchTo().defaultContent();		
		try{
			waitInSecond(80, referenceNumber);
	    	Assert.assertTrue(isElementPresent(xpath(referenceNumber)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Reference Number is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(downloadPDF)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Download PDF is not Displayed");
				resultcount++;
	    		}
		try{
	    	Assert.assertTrue(isElementPresent(xpath(startNewOrder)));
			}
			catch(AssertionError e){
				fail(input[0] + " - Start New Order is not Displayed");
				resultcount++;
	    		}
		}
		return resultcount;		
	}
	
	public int rulex() throws Exception{
		resultcount = 0;
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		LoginChannelSmokeTest("mbms");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String ready = (String) js.executeScript("return document.readyState");
			
			if(ready.equalsIgnoreCase("complete")){
				
			util.slas_dynamic(input[2]);
			util.startNewTransaction();		
			type(xpath(userOEVPP), input[5]);
			type(xpath(loanAmount), input[6]);			
			click(xpath(loanPurchase));
			click(xpath(noneApplyCheckboxValuation));			
			click(xpath(userOriginatorToProductSelection));
			int num = 60;
			try{
				do{
					if(getText(xpath(ProductPrice)).equals("")){
		    			Thread.sleep(1000);
		    			}
		        	num--;
		        }while(num != 0);
				Assert.assertTrue(getText(xpath(ProductPrice)).contains(input[1]), "Rulex - Incorrect Product returned by Rulex. Value" + getText(xpath(ProductPrice)));	
			} catch (AssertionError e) {
				fail(input[0] + " - Incorrect Product returned by Rulex");
				resultcount++;
			}
				}	
			return resultcount;	
	}	
	
	public void LoginChannelSmokeTest(String Channel) throws Exception{

		driver.navigate().to(environment.concat(Channel.concat(".rppropertyhub.com/login")));
		Thread.sleep(2000);
		if(isElementPresent(xpath(logout))){
			click(xpath(logout));
		}
		
		waitInSecond(20, userLoginUsername);
		type(xpath(userLoginUsername), getDataFromxls(0, "User_Login.xls", 1, 1));
		type(xpath(userLoginPassword), getDataFromxls(0, "User_Login.xls", 2, 1));
		waitInSecond(2, loginButton);
		click(xpath(loginButton));
		waitInSecond(20, propertySearch);	
		Assert.assertTrue(isElementPresent(xpath(propertySearch)), "Login not Successful");
	}
	
	public String getCurrentDate() throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	Date date = new Date();
    	String newDate = dateFormat.format(date).toString();
    	return newDate;
		}
}