package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import org.testng.Assert;


public class AdminCartCountRestrictionUtil extends FunctionReference{
	

	String testCase = "Admin Cart Count Restriction";

//	String input[] = {"E", "1", "username"};
	
	private String[] input;
	
	public AdminCartCountRestrictionUtil() {
	}
	public AdminCartCountRestrictionUtil(String[] i) {
		input = i;
	}
	


	public void testAdminCartCountRestriction() throws Exception {
		waitForElementPresent(xpath(adminCartCountCheckbox));
		if (isElementPresent(xpath(adminCartCountCheckbox)))
		{
			
		}
		else{
		pass("Test Report: " + testCase + browser + " browser");

		waitForElementPresent(xpath(adminChannelEdit));
		click(xpath(adminChannelEdit));
		waitForElementPresent(xpath(adminChannelCartAndPayment));
		click(xpath(adminChannelCartAndPayment));

		
		try {
			Assert.assertEquals("Order Confirmation", getText(xpath(adminChannelOrderConfirmation)));
			pass("Order Confirmation section" + " is present");
		} catch (AssertionError e) {
			fail("Order Confirmation section" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
		Assert.assertTrue(verifyTextPresent("Activate Cart Count Restriction"));
		pass("Activate Cart Count Restriction" + " is present");
		} catch (AssertionError e) {
			fail("Activate Cart Count Restriction" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
		Assert.assertTrue(isElementPresent(xpath(adminCartCountCheckbox)));
		pass("Activate Cart Count Restriction checkbox" + " is present");
		} catch (AssertionError e) {
			fail("Activate Cart Count Restriction checkbox" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		}
		
	    
//		//default value
//	    try {
//	        Assert.assertEquals("false", getValue(xpath("adminCartCountValue")));
//	        pass("Activate Cart Count Restriction checkbox" + " is not active");
//	      } catch (AssertionError e) {
//				fail("Activate Cart Count Restriction checkbox" + " is active");
//				takeScreenshot();
//				resultcount++;
//			}			
	    //testActiveCartCount();

		
	    
	    	
	}
	
	public void testActiveCartCount() throws Exception{ 
		waitForElementPresent(xpath(adminCartCountValue));
		if(input[1].equalsIgnoreCase("Enable")){
			if(getValue(xpath(adminCartCountValue)).equals("false")){
			click(xpath(adminCartCountCheckbox));
			type(xpath(adminCartCountNumber),input[2]);	    
			click(xpath(adminButtonSave));
			
				try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is active");
				} catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is not active");
					takeScreenshot();
					resultcount++;
					}	
		    
				try {
					Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
					pass("Cart Count field" + " is present");
				} catch (AssertionError e) {
					fail("Cart Count field" + " is not present");
					takeScreenshot();
					resultcount++;
				}
			}
			else{
				type(xpath(adminCartCountNumber),input[2]);	    
				click(xpath(adminButtonSave));
				try {
			        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
			        pass("Activate Cart Count Restriction checkbox" + " is active");
					} catch (AssertionError e) {
						fail("Activate Cart Count Restriction checkbox" + " is not active");
						takeScreenshot();
						resultcount++;
						}	
			    
					try {
						Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
						pass("Cart Count field" + " is present");
					} catch (AssertionError e) {
						fail("Cart Count field" + " is not present");
						takeScreenshot();
						resultcount++;
					}
			}
		}
		else if (input[1].equalsIgnoreCase("Disable")){
		if(getValue(xpath(adminCartCountValue)).equals("true")){
			click(xpath(adminCartCountCheckbox));
			click(xpath(adminButtonSave));
			try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is  not active");
		      } catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is active");
					takeScreenshot();
					resultcount++;
				}	
		    
			try {
			Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
			pass("Cart Count field" + " is not present");
			} catch (AssertionError e) {
				fail("Cart Count field" + " is present");
				takeScreenshot();
				resultcount++;
			}
		}
		else{
			click(xpath(adminButtonSave));
			try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is  not active");
		      } catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is active");
					takeScreenshot();
					resultcount++;
				}	
		    
			try {
			Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
			pass("Cart Count field" + " is not present");
			} catch (AssertionError e) {
				fail("Cart Count field" + " is present");
				takeScreenshot();
				resultcount++;
			}
		}
		}
		
		
//		if (resultcount != 0) {
//			Assert.fail();
//	    } else {
//	    	pass("PASSED");
//	    }
		
	    
//	    click(xpath(adminButtonSave));
//	    click(xpath(adminLinkLogout));		
	}		
	
	public void testRequiredCartCount() throws Exception{ 
		if(input[1].equalsIgnoreCase("Enable")){
			if(getValue(xpath(adminCartCountValue)).equals("false")){
			click(xpath(adminCartCountCheckbox));
			type(xpath(adminCartCountNumber),input[2]);
			click(xpath(adminButtonSave));
			if(getValue(xpath(adminCartCountNumber)).isEmpty()){
				try {
					Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
					pass("Cart Count field" + " valid");
				} catch (AssertionError e) {
					fail("Required Cart Count");
					takeScreenshot();
					resultcount++;
				}
			}
			
				try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is active");
				} catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is not active");
					takeScreenshot();
					resultcount++;
					}	
		    
				try {
					Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
					pass("Cart Count field" + " is present");
				} catch (AssertionError e) {
					fail("Cart Count field" + " is not present");
					takeScreenshot();
					resultcount++;
				}
			}
			else if(getValue(xpath(adminCartCountValue)).equals("true")){
				type(xpath(adminCartCountNumber),input[2]);	    
				click(xpath(adminButtonSave));
				try {
			        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
			        pass("Activate Cart Count Restriction checkbox" + " is active");
					} catch (AssertionError e) {
						fail("Activate Cart Count Restriction checkbox" + " is not active");
						takeScreenshot();
						resultcount++;
						}	
			    
					try {
						Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
						pass("Cart Count field" + " is present");
					} catch (AssertionError e) {
						fail("Cart Count field" + " is not present");
						takeScreenshot();
						resultcount++;
					}
			}
		}
		else if (input[1].equalsIgnoreCase("Disable")){
		if(getValue(xpath(adminCartCountValue)).equals("true")){
			click(xpath(adminCartCountCheckbox));
			click(xpath(adminButtonSave));
			try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is  not active");
		      } catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is active");
					takeScreenshot();
					resultcount++;
				}	
		    
			try {
			Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
			pass("Cart Count field" + " is not present");
			} catch (AssertionError e) {
				fail("Cart Count field" + " is present");
				takeScreenshot();
				resultcount++;
			}
		}
		else{
			click(xpath(adminButtonSave));
			try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is  not active");
		      } catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is active");
					takeScreenshot();
					resultcount++;
				}	
		    
			try {
			Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
			pass("Cart Count field" + " is not present");
			} catch (AssertionError e) {
				fail("Cart Count field" + " is present");
				takeScreenshot();
				resultcount++;
			}
		}
		}
		
		
		if (resultcount != 0) {
			Assert.fail();
	    } else {
	    	pass("PASSED");
	    }
		
	    
//	    click(xpath(adminButtonSave));
//	    click(xpath(adminLinkLogout));		
	}		
	
	public void testInvalidInput() throws Exception{ 
		if(input[1].equalsIgnoreCase("Enable")){
			if(getValue(xpath(adminCartCountValue)).equals("false")){
			click(xpath(adminCartCountCheckbox));
			type(xpath(adminCartCountNumber),input[2]);
			click(xpath(adminButtonSave));
			if(getValue(xpath(adminCartCountNumber)).isEmpty()){
				try {
					Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
					pass("Cart Count field" + " valid");
				} catch (AssertionError e) {
					fail("Required Cart Count");
					takeScreenshot();
					resultcount++;
				}
			}
			
				try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is active");
				} catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is not active");
					takeScreenshot();
					resultcount++;
					}	
		    
				try {
					Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
					pass("Cart Count field" + " is present");
				} catch (AssertionError e) {
					fail("Cart Count field" + " is not present");
					takeScreenshot();
					resultcount++;
				}
			}
			else if(getValue(xpath(adminCartCountValue)).equals("true")){
				type(xpath(adminCartCountNumber),input[2]);	    
				click(xpath(adminButtonSave));
				try {
			        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
			        pass("Activate Cart Count Restriction checkbox" + " is active");
					} catch (AssertionError e) {
						fail("Activate Cart Count Restriction checkbox" + " is not active");
						takeScreenshot();
						resultcount++;
						}	
			    
					try {
						Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
						pass("Cart Count field" + " is present");
					} catch (AssertionError e) {
						fail("Cart Count field" + " is not present");
						takeScreenshot();
						resultcount++;
					}
			}
		}
		else if (input[1].equalsIgnoreCase("Disable")){
		if(getValue(xpath(adminCartCountValue)).equals("true")){
			click(xpath(adminCartCountCheckbox));
			click(xpath(adminButtonSave));
			try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is  not active");
		      } catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is active");
					takeScreenshot();
					resultcount++;
				}	
		    
			try {
			Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
			pass("Cart Count field" + " is not present");
			} catch (AssertionError e) {
				fail("Cart Count field" + " is present");
				takeScreenshot();
				resultcount++;
			}
		}
		else{
			click(xpath(adminButtonSave));
			try {
		        Assert.assertEquals("true", getValue(xpath(adminCartCountValue)));
		        pass("Activate Cart Count Restriction checkbox" + " is  not active");
		      } catch (AssertionError e) {
					fail("Activate Cart Count Restriction checkbox" + " is active");
					takeScreenshot();
					resultcount++;
				}	
		    
			try {
			Assert.assertTrue(isElementPresent(xpath(adminCartCountNumber)));
			pass("Cart Count field" + " is not present");
			} catch (AssertionError e) {
				fail("Cart Count field" + " is present");
				takeScreenshot();
				resultcount++;
			}
		}
		}
		
		
		if (resultcount != 0) {
			Assert.fail();
	    } else {
	    	pass("PASSED");
	    }
		
	    
//	    click(xpath(adminButtonSave));
//	    click(xpath(adminLinkLogout));		
	}		
	
	
	public void testAdminLogout() throws Exception{ 
		click(xpath(adminLinkLogout));	
	}
	
	public void testInactiveCartCount() throws Exception{ 
		if(getValue(xpath("adminCartCountValue")) == "true"){
			click(xpath(adminCartCountCheckbox));
			click(xpath(adminButtonSave));
		} 
		
	    try {
	        Assert.assertEquals("false", getValue(xpath(adminCartCountValue)));
	        pass("Activate Cart Count Restriction checkbox" + " is not active");
	      } catch (AssertionError e) {
				fail("Activate Cart Count Restriction checkbox" + " is active");
				takeScreenshot();
				resultcount++;
			}	
	    click(xpath(adminButtonSave));
	    click(xpath(adminLinkLogout));
	}

	
}
