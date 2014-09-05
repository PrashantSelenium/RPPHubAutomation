package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminBaseProductUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public AdminBaseProductUtil(String[] i) {
		input = i;
	}
	
	public AdminBaseProductUtil() {
	}
	
	public void testBaseProductNavigation() throws Exception {		
		resultcount = 0;	
		testCase = "Admin Console Base Product Menu";
		
		actionType(xpath(adminProducts), "Products");		
		
		waitForElementPresent(xpath(adminBaseProductLink));
		try {
			Assert.assertTrue(isElementPresent(xpath(adminBaseProductLink)));
		} catch (AssertionError e) {
			fail("Base Product on sub menu");
			takeScreenshot();
			resultcount++;
		}

		click(xpath(adminBaseProductLink));
		
		waitForElementPresent(xpath(baseProductHeader));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProductHeader)));
		} catch (AssertionError e) {
			fail("Base Product on sub menu");
			takeScreenshot();
			resultcount++;
		}

		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	public void testBaseProductAddNewLink() throws Exception {		
		resultcount = 0;	
		testCase = "Admin Console Base Product Add New Navigation";
		
		waitForElementPresent(xpath(baseProdAddNewLink));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdAddNewLink)));
		} catch (AssertionError e) {
			fail("Add New link");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(baseProdAddNewLink));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
	}
	
	public void testBaseProductAddNewFields() throws Exception {	
		resultcount = 0;	
		testCase = "Admin Console Base Product Add New Fields";
		
		waitForElementPresent(xpath(baseProdAddNewHeader));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdAddNewLabel)));
			Assert.assertEquals("Add new base product:", getText(xpath(baseProdAddNewLabel)));
		} catch (AssertionError e) {
			fail("Add new base product label");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdNameFieldLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdNameField)));
			Assert.assertEquals("", getValue(xpath(baseProdNameField)));
		} catch (AssertionError e) {
			fail("Base product name field");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdDataGroupFieldLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdDataGroupField)));
			Assert.assertEquals("0", getValue(xpath(baseProdDataGroupField)));
		} catch (AssertionError e) {
			fail("Product data group field");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdTypeFieldLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdTypeField)));
			Assert.assertEquals("0", getValue(xpath(baseProdTypeField)));
		} catch (AssertionError e) {
			fail("Product type");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(prodTypeReport)));
			Assert.assertTrue(isElementPresent(xpath(prodTypeService)));
			Assert.assertTrue(isElementPresent(xpath(prodTypeProcessedReport)));
		} catch (AssertionError e) {
			fail("Product type options");
			takeScreenshot();
			resultcount++;
		}

		select(xpath(baseProdTypeField), "Please select...");
		try {
			Assert.assertEquals("0",getValue(xpath(baseProdTypeField)));
		} catch (AssertionError e) {
			fail("Select default from Product type");
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
	
	public void testBaseProductReport() throws Exception {	
		resultcount = 0;	
		testCase = "Admin Console Base Product Report";
		
		select(xpath(baseProdTypeField), "Report");
		Thread.sleep(3000);
		
		try {
			Assert.assertEquals("27",getValue(xpath(baseProdTypeField)));
		} catch (AssertionError e) {
			fail("Select Report from Product type");
			takeScreenshot();
			resultcount++;
		}
		
		waitForElementPresent(xpath(baseProdReportSourceLabel));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportSourceField)));
		} catch (AssertionError e) {
			fail("Report Source");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertFalse(isElementPresent(xpath(repSourceValexRequestMethod)));
		} catch (AssertionError e) {
			fail("Valex request method on Report");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceBSG)));
		} catch (AssertionError e) {
			fail("Report Source BSG");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceRPPropertyHub)));
		} catch (AssertionError e) {
			fail("Report Source RP Property Hub");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceValexFindMethod)));
		} catch (AssertionError e) {
			fail("Report Source Valex Find Method");
			takeScreenshot();
			resultcount++;
		}		
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdValServiceTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Valex Service Type on Report");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdValSubTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdValSubTypeField)));
		} catch (AssertionError e) {
			fail("Val Sub Type on Report");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdValSubTypeNoteLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdValSubTypeNoteField)));
		} catch (AssertionError e) {
			fail("Val Sub Type Note on Report");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdConstructionLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdConstructionField)));
		} catch (AssertionError e) {
			fail("Construction on Report");
			takeScreenshot();
			resultcount++;
		}

		
		select(xpath(baseProdReportSourceField), "BSG");
		Thread.sleep(6000);
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for BSG");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repTypePropertyProfile)));
			Assert.assertTrue(isElementPresent(xpath(repTypeRetroVal)));
		} catch (AssertionError e) {
			fail("BSG report type option");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		select(xpath(baseProdReportTypeField), "Property Profile");
		Thread.sleep(3000);
		try {
			Assert.assertTrue(isElementVisible(xpath(reportNameLabel)));
			Assert.assertTrue(isElementVisible(xpath(reportNameField)));
		} catch (AssertionError e) {
			fail("Report Name on Property Profile");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		select(xpath(baseProdReportTypeField), "RetroVal");
		Thread.sleep(3000);
		try {
			Assert.assertFalse(isElementVisible(xpath(reportNameLabel)));
			Assert.assertFalse(isElementVisible(xpath(reportNameField)));
		} catch (AssertionError e) {
			fail("Report Name on Retroval");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
			
		select(xpath(baseProdReportSourceField), "RP Property Hub");
		Thread.sleep(3000);
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for RP Property Hub");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repTypeRPAVM)));
			Assert.assertTrue(isElementPresent(xpath(repTypeScorecard)));
		} catch (AssertionError e) {
			fail("RP Property Hub report type option");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type on RP Property Hub");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		select(xpath(baseProdReportSourceField), "Valex Find Method");
		Thread.sleep(3000);
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdDupValServiceTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdDupValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type on Valex Find Method");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(dupValServiceResidetialSF)));
			Assert.assertTrue(isElementPresent(xpath(dupValServiceConstructionSF)));
			Assert.assertTrue(isElementPresent(xpath(dupValServiceCompTitleSF)));
			Assert.assertTrue(isElementPresent(xpath(dupValServiceLeaseTitleSF)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type option");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}		
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdReportTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for Valex Find Method");
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
	public void testBaseProductService() throws Exception {		
		
		resultcount = 0;	
		testCase = "Admin Console Base Product Service";

		select(xpath(baseProdTypeField), "Service");
		Thread.sleep(3000);
		
		try {
			Assert.assertEquals("28",getValue(xpath(baseProdTypeField)));
		} catch (AssertionError e) {
			fail("Select Service from Product type");
			takeScreenshot();
			resultcount++;
		}
		
		waitForElementPresent(xpath(baseProdReportSourceLabel));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportSourceField)));
		} catch (AssertionError e) {
			fail("Report Source");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceValexRequestMethod)));
		} catch (AssertionError e) {
			fail("Valex request method on Service");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertFalse(isElementPresent(xpath(repSourceBSG)));
		} catch (AssertionError e) {
			fail("Report Source BSG");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertFalse(isElementPresent(xpath(repSourceRPPropertyHub)));
		} catch (AssertionError e) {
			fail("Report Source RP Property Hub");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertFalse(isElementPresent(xpath(repSourceValexFindMethod)));
		} catch (AssertionError e) {
			fail("Report Source Valex Find Method");
			takeScreenshot();
			resultcount++;
		}		
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdValServiceTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Valex Service Type on Service");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeField)));
		} catch (AssertionError e) {
			fail("Val Sub Type on Service");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeNoteLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeNoteField)));
		} catch (AssertionError e) {
			fail("Val Sub Type Note on Service");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdConstructionLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdConstructionField)));
		} catch (AssertionError e) {
			fail("Construction on Service");
			takeScreenshot();
			resultcount++;
		}
		
		
		select(xpath(baseProdReportSourceField), "Valex Request Method");
		Thread.sleep(3000);
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdReportTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for Valex Request Method");
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
	public void testBaseProductProcessedReport() throws Exception {			
		resultcount = 0;	
		testCase = "Admin Console Base Product Processed Report";

		select(xpath(baseProdTypeField), "Processed Report");
		Thread.sleep(3000);
		
		try {
			Assert.assertEquals("29",getValue(xpath(baseProdTypeField)));
		} catch (AssertionError e) {
			fail("Select Processed Report from Product type");
			takeScreenshot();
			resultcount++;
		}
		
		waitForElementPresent(xpath(baseProdReportSourceLabel));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportSourceField)));
		} catch (AssertionError e) {
			fail("Report Source");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceValexRequestMethod)));
		} catch (AssertionError e) {
			fail("Valex request method on Processed Report");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceBSG)));
		} catch (AssertionError e) {
			fail("Report Source BSG");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceRPPropertyHub)));
		} catch (AssertionError e) {
			fail("Report Source RP Property Hub");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repSourceValexFindMethod)));
		} catch (AssertionError e) {
			fail("Report Source Valex Find Method");
			takeScreenshot();
			resultcount++;
		}			
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdValServiceTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Valex Service Type on Processed Report");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeField)));
		} catch (AssertionError e) {
			fail("Val Sub Type on Processed Report");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeNoteLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdValSubTypeNoteField)));
		} catch (AssertionError e) {
			fail("Val Sub Type Note on Processed Report");
			takeScreenshot();
			resultcount++;
		}

		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdConstructionLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdConstructionField)));
		} catch (AssertionError e) {
			fail("Construction on Processed Report");
			takeScreenshot();
			resultcount++;
		}
		
		select(xpath(baseProdReportSourceField), "BSG");
		Thread.sleep(3000);
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for BSG");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repTypePropertyProfile)));
			Assert.assertTrue(isElementPresent(xpath(repTypeRetroVal)));
		} catch (AssertionError e) {
			fail("BSG report type option");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		select(xpath(baseProdReportTypeField), "Property Profile");
		Thread.sleep(3000);
		try {
			Assert.assertTrue(isElementVisible(xpath(reportNameLabel)));
			Assert.assertTrue(isElementVisible(xpath(reportNameField)));
		} catch (AssertionError e) {
			fail("Report Name on Property Profile");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		select(xpath(baseProdReportTypeField), "RetroVal");
		Thread.sleep(3000);
		try {
			Assert.assertFalse(isElementVisible(xpath(reportNameLabel)));
			Assert.assertFalse(isElementVisible(xpath(reportNameField)));
		} catch (AssertionError e) {
			fail("Report Name on Retroval");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type on BSG");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
			
		select(xpath(baseProdReportSourceField), "RP Property Hub");
		Thread.sleep(3000);
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for RP Property Hub");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(repTypeRPAVM)));
			Assert.assertTrue(isElementPresent(xpath(repTypeScorecard)));
		} catch (AssertionError e) {
			fail("RP Property Hub report type option");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type on RP Property Hub");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		select(xpath(baseProdReportSourceField), "Valex Find Method");
		Thread.sleep(3000);
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdDupValServiceTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdDupValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type on Valex Find Method");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(dupValServiceResidetialSF)));
			Assert.assertTrue(isElementPresent(xpath(dupValServiceConstructionSF)));
			Assert.assertTrue(isElementPresent(xpath(dupValServiceCompTitleSF)));
			Assert.assertTrue(isElementPresent(xpath(dupValServiceLeaseTitleSF)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type option");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}		
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdReportTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for Valex Find Method");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		select(xpath(baseProdReportSourceField), "Valex Request Method");
		Thread.sleep(3000);
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeLabel)));
			Assert.assertTrue(isElementPresent(xpath(baseProdReportTypeField)));
		} catch (AssertionError e) {
			fail("Report type for RP Property Hub");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(repTypeCBAAVM)));
			Assert.assertTrue(isElementPresent(xpath(repTypeAussieAVM)));
		} catch (AssertionError e) {
			fail("RP Property Hub report type option");
			takeScreenshot();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
			resultcount++;
		}
		
		try {
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeLabel)));
			Assert.assertFalse(isElementVisible(xpath(baseProdDupValServiceTypeField)));
		} catch (AssertionError e) {
			fail("Duplicate Valuation Service Type on RP Property Hub");
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
	
	public void testBaseProductAddNewCancel() throws Exception {	
		resultcount = 0;	
		testCase = "Admin Console Base Product Cancel";
		waitForElementPresent(xpath(baseProdCancelBtn));
		click(xpath(baseProdCancelBtn));
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
	public void testBaseProductAddNewSave() throws Exception {		
		waitForElementPresent(xpath(baseProdSaveBtn));
		click(xpath(baseProdSaveBtn));
		Thread.sleep(30000);
	}
	
	public void testBaseProductList() throws Exception {		
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
	
	public void testBaseProductFillOut() throws Exception {		
		resultcount = 0;	
		testCase = "Admin Console Base Product field entry";
		
		String baseProductName= input[2];
		String productDataGroup = input[3];
		String productType = input[4];
		String reportSource = input[5];
		String reportType = input[6];
		String reportName = input[7];
		String dupValServiceType = input[8];
		String valexServiceType = input[9];
		String valSubType = input[10];
		String valSubTypeNote = input[11];
		String construction = input[12];

		type(xpath(baseProdNameField), baseProductName);
		Thread.sleep(3000);
		
		selectOption(xpath(baseProdDataGroupField), productDataGroup);
		Thread.sleep(6000);
		
		selectOption(xpath(baseProdTypeField), productType);
		Thread.sleep(6000);
	
		if(isElementVisible(xpath(baseProdReportSourceField))) {
		selectOption(xpath(baseProdReportSourceField), reportSource);
		Thread.sleep(6000);
		}
		
		if(isElementVisible(xpath(baseProdReportTypeField))) {
			selectOption(xpath(baseProdReportTypeField), reportType);
			Thread.sleep(6000);		
		}
		
		if(isElementVisible(xpath(reportNameField))) {
		type(xpath(reportNameField), reportName);
		Thread.sleep(6000);
		}
		
		
		if(isElementVisible(xpath(baseProdDupValServiceTypeField))) {
		select(xpath(baseProdDupValServiceTypeField), dupValServiceType);
		Thread.sleep(6000);
		}
		
		if(isElementVisible(xpath(baseProdValServiceTypeField))) {
		type(xpath(baseProdValServiceTypeField), valexServiceType);
		Thread.sleep(6000);
		}
		
		if(isElementVisible(xpath(baseProdValSubTypeField))) {
		select(xpath(baseProdValSubTypeField), valSubType);
		Thread.sleep(6000);
		}
		
		if(isElementVisible(xpath(baseProdValSubTypeNoteField))) {
		type(xpath(baseProdValSubTypeNoteField), valSubTypeNote);
		Thread.sleep(6000);
		}
		
		if(isElementVisible(xpath(baseProdConstructionField))) {
		select(xpath(baseProdConstructionField), construction);
		Thread.sleep(6000);
		}
		
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
	}

	
	public void testBaseProductValidation() throws Exception {
		resultcount = 0;	
		testCase = "Admin Console Base Product field validations";
		try {
			Assert.assertEquals(input[14], getText(xpath(input[13])));
		} catch (AssertionError e) {
			fail("Error Message");
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

	public void testBaseProductActivate() throws Exception {
		click(xpath(baseProdActivate));
		
	}
	
}
