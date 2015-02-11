package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.EventUtil;
import hub.utilities.HubEndToEndUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleEndToEnd extends TestInitReference {
	private static final String XML_FILE_NAME = "EndToEndUtilData2.xls";
	
	@Test
	public void sample() throws Exception {
		
		HubEndToEndUtil endToEnd = new HubEndToEndUtil();
		EventUtil.getDataFromFile(0, XML_FILE_NAME, 1, 1);
		//Login
		String username = EventUtil.getDataFromFile(0, XML_FILE_NAME, 1, 1);
		String password = EventUtil.getDataFromFile(0, XML_FILE_NAME, 2, 1);
		endToEnd.hubUserLogin(username.trim(), password.trim());
		
		//Property Search
		String addressToSearch = EventUtil.getDataFromFile(0, XML_FILE_NAME, 1, 2);
		endToEnd.searchAddress(addressToSearch);
		
		//Property Details
		endToEnd.propertyDetails();
		
		//Product Selection
		endToEnd.productSelectionManipultation(getProductSelectionList());

		//Instruction Details
		endToEnd.instructionDetails(getInstructionDetailsMap());
		
		//Payment Details
		endToEnd.paymentDetails(getPaymentDetailsMap());
		
		//Payment Detail CPS
		endToEnd.paymentDetailsCps(getPaymentDetailsCpsMap());
		
	}
	
	private List<HashMap<String, Object>> getProductSelectionList() throws Exception {
		
		String[] productSelectionArr = {String.format(EventUtil.DATA_FORMAT, "Type", XML_FILE_NAME, 0, 1, 6),
			String.format(EventUtil.DATA_FORMAT, "OEVPP", XML_FILE_NAME, 0, 1, 7)};
		
		HashMap<String, Object> originatorMap = EventUtil.dataMap(productSelectionArr);
		
		String productTab = EventUtil.getDataFromFile(0, XML_FILE_NAME, 1, 3);
		String productXpath = EventUtil.getDataFromFile(0, XML_FILE_NAME, 1, 4);
		
		HashMap<String, String> productsAndTabMap = new HashMap<String, String>();
		productsAndTabMap.put("Tab", productTab);
		productsAndTabMap.put("Products", productXpath);
		originatorMap.put("TabProductObject", productsAndTabMap);
		
		//Selecting of product form another Tab (IF NEEDED).
		String[] productSelectionArr2 = {String.format(EventUtil.DATA_FORMAT, "Type", XML_FILE_NAME, 0, 1, 17),
				String.format(EventUtil.DATA_FORMAT, "OEVPP", XML_FILE_NAME, 0, 1, 18)};
		
		HashMap<String, Object> originatorMap2 = EventUtil.dataMap(productSelectionArr2);
		
		String productTab2 = EventUtil.getDataFromFile(0, XML_FILE_NAME, 1, 14);
		String productXpath2 = EventUtil.getDataFromFile(0, XML_FILE_NAME, 1, 15);
		
		HashMap<String, String> productsAndTabMap2 = new HashMap<String, String>();
		productsAndTabMap2.put("Tab", productTab2);
		productsAndTabMap2.put("Products", productXpath2);
		originatorMap2.put("TabProductObject", productsAndTabMap2);
		
		//NOTE: Placing of new Map in List Object should in order as declared on xls file.
		List<HashMap<String, Object>> productSelectionMap = new ArrayList<HashMap<String, Object>>();
		productSelectionMap.add(originatorMap);
		productSelectionMap.add(originatorMap2);
		
		return productSelectionMap;
	}
	
	private HashMap<String, Object> getInstructionDetailsMap() throws Exception {
		
		String[] arr = {String.format(EventUtil.DATA_FORMAT, "FirstName", XML_FILE_NAME, 0, 1, 26),
			String.format(EventUtil.DATA_FORMAT, "LastName", XML_FILE_NAME, 0, 1, 27), String.format(EventUtil.DATA_FORMAT, "TheCustomerIs", XML_FILE_NAME, 0, 1, 28),
			String.format(EventUtil.DATA_FORMAT, "ContactNumber", XML_FILE_NAME, 0, 1, 29), String.format(EventUtil.DATA_FORMAT, "CompanyName", XML_FILE_NAME, 0, 1, 30),
			String.format(EventUtil.DATA_FORMAT, "Email", XML_FILE_NAME, 0, 1, 31), String.format(EventUtil.DATA_FORMAT, "SameAsCustomerDetails", XML_FILE_NAME, 0, 1, 32),
			String.format(EventUtil.DATA_FORMAT, "NetLettableArea", XML_FILE_NAME, 0, 1, 33), String.format(EventUtil.DATA_FORMAT, "RentalAmountMonthly", XML_FILE_NAME, 0, 1, 34),
			String.format(EventUtil.DATA_FORMAT, "OutgoinsMonthly", XML_FILE_NAME, 0, 1, 35)};
		
		HashMap<String, Object> map = EventUtil.dataMap(arr);		
		return map;
		
	}
	
	private HashMap<String, Object> getPaymentDetailsMap() throws Exception {
		
		String[] arr = {String.format(EventUtil.DATA_FORMAT, "TermsAndConditions", XML_FILE_NAME, 0, 1, 38),
			String.format(EventUtil.DATA_FORMAT, "NameForTaxInvoice", XML_FILE_NAME, 0, 1, 39), String.format(EventUtil.DATA_FORMAT, "EmailForInvoice", XML_FILE_NAME, 0, 1, 40)};
		
		HashMap<String, Object> map = EventUtil.dataMap(arr);	
		
		return map;
		
	}
	
	private HashMap<String, Object> getPaymentDetailsCpsMap() throws Exception {
		
		String[] arr = {String.format(EventUtil.DATA_FORMAT, "CardNumber", XML_FILE_NAME, 0, 1, 43),
			String.format(EventUtil.DATA_FORMAT, "CardHolder", XML_FILE_NAME, 0, 1, 44), String.format(EventUtil.DATA_FORMAT, "ExpiryDate", XML_FILE_NAME, 0, 1, 45),
			String.format(EventUtil.DATA_FORMAT, "SecurityCode", XML_FILE_NAME, 0, 1, 46)};
		
		HashMap<String, Object> map = EventUtil.dataMap(arr);	
		
		return map;
		
	}
	
	@BeforeMethod
    public void reinitializeBrowser() throws Exception {
    	String url = getDataFromxls(0, "EndToEndUtilData2.xls", 1, 0);
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }
}
