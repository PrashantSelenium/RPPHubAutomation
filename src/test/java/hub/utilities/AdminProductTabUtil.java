package hub.utilities;

import static org.openqa.selenium.By.xpath;

import java.awt.RenderingHints.Key;
import java.io.FileOutputStream;

import hub.library.FunctionReference;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Writer;

import jxl.Workbook;
import jxl.demo.Write;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.thoughtworks.selenium.*;

import org.openqa.selenium.server.*;
import org.testng.annotations.*;

public class AdminProductTabUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public AdminProductTabUtil(String[] i) {
		input = i;
	}
	
	public AdminProductTabUtil() {
	}
		
	public void navigateToChannelListPage() throws Exception{
		resultcount = 0;	
		testCase = "Navigate to Product Tab List";
		Thread.sleep(1000);
		actionType(xpath(adminChannelTab), "Channels");
		click(xpath(adminChannelListTab));
		waitForElementPresent(xpath(adminChannelSearchTextField));
		try {
			Assert.assertTrue(isElementPresent(xpath(adminChannelSearchTextField)));
			
		} catch (AssertionError e) {
			fail("Base Product List");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	public void testList() throws Exception {		
		resultcount = 0;	
		testCase = "Admin Console Base Product Back to Base Product List";
		waitForElementPresent(xpath(baseProdBackToListBtn));
		click(xpath(baseProdBackToListBtn));
		Thread.sleep(3000);
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProductList)));
		} catch (AssertionError e) {
			fail("Base Product List");
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

	
	public void testAdding() throws Exception {		
		
		driver.navigate().to("http://localhost:37080/ttsvr/n/myrp-1118?channelId=15");
		resultcount = 0;	
		testCase = "Add New Product Tab";
		waitForElementPresent(xpath(addNew));
		try {
			Assert.assertTrue(isElementPresent(xpath(addNew)));
			pass("Add new is present");
			click(xpath(addNew));
			Thread.sleep(30);
			
		} catch (AssertionError e) {
			fail("Add new is not present");
			takeScreenshot();
			resultcount++;
		}
		
		waitForElementPresent(xpath(adminProductTabName));	
		
		String productTabName= input[4];
		String productTabDescription = input[5];
		String thumbnail = input[6];
//		String reportSource = input[5];
		String isActive = input[7].toLowerCase();
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabName)));
			pass("adminProductTabName is present");
			type(xpath(adminProductTabName), productTabName);
			Thread.sleep(30);
			
		} catch (AssertionError e) {
			fail("adminProductTabName is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabDescription)));
			pass("adminProductTabDescription is present");
			
		    WebElement iframe = driver.findElement(By.xpath(ckeditor));
		    System.out.println(iframe);
		    driver.switchTo().frame(iframe);
		    ((JavascriptExecutor) driver).executeScript("document.body.innerHTML='"+productTabDescription+"'");
		    driver.switchTo().defaultContent();
			
		} catch (AssertionError e) {
			fail("adminProductTabDescription is not present");
			takeScreenshot();
			resultcount++;
		}
		
			WebElement upload = driver.findElement(By.id("thumbNailUpload"));
			if(thumbnail.equals("none")){
				
			} else {
				upload.sendKeys(thumbnail);
			}		

		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabDescription)));
			pass("adminProductTabDescription is present");
			Thread.sleep(3000);
			
		} catch (AssertionError e) {
			fail("adminProductTabDescription is not present");
			takeScreenshot();
			resultcount++;
		}
		
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabIsActive)));
			pass("adminProductTabIsActive is present");
			if(isActive.equals("true")){
				if(getValue(xpath(adminProductTabIsActive)).equals("false")){
					click(xpath(adminProductTabIsActive));
					Thread.sleep(30);
				}
			} else {
				if(getValue(xpath(adminProductTabIsActive)).equals("true")){
					click(xpath(adminProductTabIsActive));
					Thread.sleep(30);
				}
			}
			
		} catch (AssertionError e) {
			fail("adminProductTabIsActive is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabSave)));
			pass("adminProductTabSave is present");
			click(xpath(adminProductTabSave));
			
		} catch (AssertionError e) {
			fail("adminProductTabSave is not present");
			takeScreenshot();
			resultcount++;
		}
		
			waitForElementPresent(xpath(adminProductTabName));	
		

				
				if(input[8].equalsIgnoreCase("SAVE")){
					waitForElementPresent(xpath(flashMessage));
					try {
						Assert.assertTrue(isElementPresent(xpath(flashMessage)));
						pass("flashMessage is present");
						String url = driver.getCurrentUrl();
						String[] parsedUrl = null;
						String[] productTabConfId = null;
						String[] save = null;
						if(url.contains("&")){
							parsedUrl = url.split("&");
							System.out.println(parsedUrl[1]);
							System.out.println(parsedUrl[2]);
							if(parsedUrl[1].contains("=")){
								productTabConfId = parsedUrl[1].split("=");
								System.out.println(productTabConfId[0]);
								System.out.println(productTabConfId[1]);
							}
							System.out.println(parsedUrl[2]);
							if(parsedUrl[2].contains("=")){
								save = parsedUrl[2].split("=");
								System.out.println(save[0]);
								System.out.println(save[1]);
								if (save[1].equalsIgnoreCase("true")){
									pass("Saved");
								}
							}
						} else {
							fail("Saving Failed");
						}
					} catch (AssertionError e) {
						fail("adminProductTabSave is not present");
						takeScreenshot();
						resultcount++;
					}			
				}
				
				if(thumbnail.equals("none")){
					
				} else {
					waitForElementPresent(xpath(thumbNailImg));	
					try {
						Assert.assertTrue(isElementPresent(xpath(thumbNailImg)));
						pass("thumbNailImg is present");
					} catch (AssertionError e) {
						fail("thumbNailImg is not present");
						takeScreenshot();
						resultcount++;
					}
				
				}	
		
			
		if (resultcount != 0) {
			fail("Fail to Add/Edit");
		} else {
			pass("Add/Edit successful");
		}
		
	}
	
public void testEditing	() throws Exception {		
		
		driver.navigate().to("http://localhost:37080/ttsvr/n/myrp-1118?channelId=15");
		resultcount = 0;	
		testCase = "Add New Product Tab";
		waitForElementPresent(xpath(channelTabsContainer));
		try {
			Assert.assertTrue(isElementPresent(xpath(channelTabsContainer)));
			pass("channel Tabs Container is present");
			
		} catch (AssertionError e) {
			fail("channel Tabs Container is not present");
			takeScreenshot();
			resultcount++;
		}
		String productTabConfIds= input[9];
		String productTabName= input[4];
		String productTabDescription = input[5];
		String thumbnail = input[6];
//		String reportSource = input[5];
		String isActive = input[7].toLowerCase();
		double ids =  Double.parseDouble(productTabConfIds);
		String id = String.valueOf((int)ids);
		System.out.print(xpath("//*[@id='"+id+"_tr']/td[3]/a"));
		waitForElementPresent(xpath("//*[@id='"+id+"_tr']/td[3]/a"));	
		try {
			Assert.assertTrue(isElementPresent(xpath("//*[@id='"+id+"_tr']/td[3]/a")));
			pass(productTabName+" is present");
			click(xpath("//*[@id='"+id+"_tr']/td[3]/a"));
		} catch (AssertionError e) {
			fail(productTabName+" is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabName)));
			pass("adminProductTabName is present");
			if (getValue(xpath(adminProductTabName)).equals(productTabName)){
				pass("adminProductTabName is equal");
			} else {
				fail("adminProductTabName is not equal");
				takeScreenshot();
				resultcount++;
			}
			Thread.sleep(30);
			
		} catch (AssertionError e) {
			fail("adminProductTabName is not present");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabDescription)));
			pass("adminProductTabDescription is present");
			Thread.sleep(3000);
			
		} catch (AssertionError e) {
			fail("adminProductTabDescription is not present");
			takeScreenshot();
			resultcount++;
		}
		
		if(thumbnail.equals("none")){
			waitForElementPresent(xpath(thumbNailImg));	
			try {
				Assert.assertTrue(isElementPresent(xpath(thumbNailImg)));
				fail("thumbNail Image should not be present");
			} catch (AssertionError e) {
				pass("thumbNail Image is not present");
				takeScreenshot();
				resultcount++;
			}
		} else {
			waitForElementPresent(xpath(thumbNailImg));	
			try {
				Assert.assertTrue(isElementPresent(xpath(thumbNailImg)));
				pass("thumbNailImg is present");
			} catch (AssertionError e) {
				fail("thumbNailImg is not present");
				takeScreenshot();
				resultcount++;
			}
		
		}	
		
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabIsActive)));
			pass("adminProductTabIsActive is present");
				if(getValue(xpath(adminProductTabIsActive)).equals(adminProductTabIsActive)){
					pass("Is Active is equal");
				} else {
					fail("Is Active is not equal");
					takeScreenshot();
					resultcount++;
				}
			
		} catch (AssertionError e) {
			fail("adminProductTabIsActive is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminProductTabSave)));
			pass("adminProductTabSave is present");
			click(xpath(adminProductTabSave));
			
		} catch (AssertionError e) {
			fail("adminProductTabSave is not present");
			takeScreenshot();
			resultcount++;
		}
		
			waitForElementPresent(xpath(adminProductTabName));	
		

				
				if(input[8].equalsIgnoreCase("SAVE")){
					waitForElementPresent(xpath(flashMessage));
					try {
						Assert.assertTrue(isElementPresent(xpath(flashMessage)));
						pass("flashMessage is present");
						String url = driver.getCurrentUrl();
						String[] parsedUrl = null;
						String[] productTabConfId = null;
						String[] save = null;
						if(url.contains("&")){
							parsedUrl = url.split("&");
							System.out.println(parsedUrl[1]);
							System.out.println(parsedUrl[2]);
							if(parsedUrl[1].contains("=")){
								productTabConfId = parsedUrl[1].split("=");
								System.out.println(productTabConfId[0]);
								System.out.println(productTabConfId[1]);
							}
							System.out.println(parsedUrl[2]);
							if(parsedUrl[2].contains("=")){
								save = parsedUrl[2].split("=");
								System.out.println(save[0]);
								System.out.println(save[1]);
								if (save[1].equalsIgnoreCase("true")){
									pass("Saved");
								}
							}
						} else {
							fail("Saving Failed");
						}
					} catch (AssertionError e) {
						fail("adminProductTabSave is not present");
						takeScreenshot();
						resultcount++;
					}			
				}
		
			
		if (resultcount != 0) {
			fail("Fail to Add/Edit");
		} else {
			pass("Add/Edit successful");
		}
		
	}
	
	public void adminLogin() throws Exception {
		resultcount = 0;	
		driver.navigate().to("http://localhost:37080/ttsvr/n/myrp-872");
		waitForElementPresent(xpath(adminLoginUsername));			
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginUsername)));
			pass("Login Username is present");
		} catch (AssertionError e) {
			fail("Login Username is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginPassword)));
			pass("Login Password is present");
		} catch (AssertionError e) {
			fail("Login Password is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginButton)));
			pass("Login button is present");
		} catch (AssertionError e) {
			fail("Login button is not present");
			takeScreenshot();
			resultcount++;
		}
		
		
		type(xpath(adminLoginUsername), "robert.velasco@twistresources.com");
		type(xpath(adminLoginPassword), "123456");
		click(xpath(adminLoginButton));
		waitForElementPresent(xpath(adminLinkLogout));
		
		if (resultcount != 0) {
			fail("Fail to login");
		} else {
			pass("Login successful");
		}
	}
	
	public void writereport(int a, int b, String text) {
	    try {
	        File excelFile = new File("/DEMO.xls");

	        WritableWorkbook book;
	        WritableSheet sheet;
	        Workbook existingBook = null;

	        if (!excelFile.exists()) {
	            book = Workbook.createWorkbook(excelFile);
	            sheet = book.createSheet("TESTRESULTS", 0);
	        } else {
	            existingBook = Workbook.getWorkbook(excelFile);
	            book = Workbook.createWorkbook(excelFile, existingBook);
	            sheet = book.getSheet("TESTRESULTS");
	        }

	        Label i = new Label(a, b, text);
	        sheet.addCell(i);
	        book.write();
	        book.close();

	        if (existingBook != null)
	            existingBook.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
