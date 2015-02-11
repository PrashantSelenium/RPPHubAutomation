package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;
import hub.library.TestInitReference;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EventUtil {
	private static FunctionReference functionReference = new FunctionReference();
	public static final String SEPARATOR = "_@@_";
	public static final String DATA_FORMAT = "%s_@@_%s_@@_%s_@@_%s_@@_%s";
	
	public static void fillOutField(String type, String value, String xPath) throws InterruptedException, IOException {
		
		switch(type){
		    case "Drop Down" :
		    	functionReference.waitForElementPresent(xpath(xPath));
		    	selectOnDropDownOption(xpath(xPath), value);
		       break; //optional
		    case "Text" :
		    	functionReference.waitForElementPresent(xpath(xPath));
		    	functionReference.type(xpath(xPath), value);
		       break;
		    case "Check Box" :
		    	functionReference.waitForElementPresent(xpath(xPath));
		    	functionReference.click(xpath(xPath));
			   break; //optional
		}
		
	}
	
	public static void selectOnDropDownOption(By by, String value) {
		   Select dropdown = new Select(FunctionReference.driver.findElement(by));
		   dropdown.selectByVisibleText(value);
	}

	public static String getDataFromFile(int sheetNumber, String fileName, int column, int row) throws Exception {
		return functionReference.getDataFromxls(sheetNumber, fileName, column, row) == null ? "" : functionReference.getDataFromxls(0, fileName, column, row);
	}
	
	public static HashMap<String, Object> dataMap(String[] dataFromXls) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		for (int x = 0; x < dataFromXls.length; x++) {
			String data = dataFromXls[x];
			
			if (data != null && data.contains(SEPARATOR)) {
				
				String[] dataArr = data.split(SEPARATOR);
				String key = dataArr[0].trim();
				String fileName = dataArr[1].trim();
				int sheetNumber = Integer.parseInt(dataArr[2].trim());
				int column = Integer.parseInt(dataArr[3].trim());
				int row = Integer.parseInt(dataArr[4].trim());
				
				
				try {
					map.put(key, getDataFromFile(sheetNumber, fileName, column, row));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return map;
	}
	
}
