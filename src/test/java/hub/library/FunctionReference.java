package hub.library;


import static org.apache.commons.io.FileUtils.copyFile;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
//import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

@SuppressWarnings("unused")
public class FunctionReference extends Results {
    private static final Logger LOGGER = Logger.getLogger(FunctionReference.class);

    protected static ReadXmlData rxml = new ReadXmlData();
    public static WebDriver driver;
//    public static ScreenRecorder screenRecorder;
    public static String browser = rxml.data("browser");
    public int resultcount = 0;

    public void takeScreenshot() throws IOException {
        Random rand = new Random();
        int num = rand.nextInt(150);
        File scrFile;
        Integer numNoRange = rand.nextInt();
        if (browser.contains("Remote")) {
            try {
                WebDriver augmentedDriver = new Augmenter().augment(driver);
                scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
                String filename = numNoRange.toString();
                fail("Screenshot file name is : " + filename);
                copyFile(scrFile, new File(rxml.data("screen_shot_location") + filename + ".png"));
            } catch (Exception n) {
                try {
                    scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String filename = numNoRange.toString();
                    fail("Screenshot file name is : " + filename);
                    copyFile(scrFile, new File(rxml.data("screen_shot_location") + filename + ".png"));
                } catch (NullPointerException m) {
                    fail(m.getMessage());
                }
            }
        } else {
            try {
                scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String filename = numNoRange.toString();
                fail("Screenshot file name is : " + filename);
                copyFile(scrFile, new File(rxml.data("screen_shot_location") + filename + ".png"));
            } catch (NullPointerException n) {
                fail(n.getMessage());
            }
        }
    }

    public void takeScreenshot(String testcase) throws IOException {
        Random rand = new Random();
        int num = rand.nextInt(150);
        File scrFile;
        Integer numNoRange = rand.nextInt();
        if (browser.contains("Remote")) {
            try {
                WebDriver augmentedDriver = new Augmenter().augment(driver);
                scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
                String filename = numNoRange.toString();
                fail("Screenshot file name is : " + testcase + filename);
                copyFile(scrFile, new File(rxml.data("screen_shot_location") + testcase + filename + ".png"));
            } catch (Exception n) {
                try {
                    scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String filename = numNoRange.toString();
                    fail("Screenshot file name is : " + filename);
                    copyFile(scrFile, new File(rxml.data("screen_shot_location") + testcase + filename + ".png"));
                } catch (NullPointerException m) {
                    fail(m.getMessage());
                }
            }
        } else {
            try {
                scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                fail("Screenshot file name is : "+ testcase);
                copyFile(scrFile, new File(rxml.data("screen_shot_location")+ testcase + ".png"));
            } catch (NullPointerException n) {
                fail(n.getMessage());
            }
        }
    }
    
    public void waitForElementNotPresent(By by) throws IOException {
        if (!browser.equalsIgnoreCase("InternetExplorer")) {
            try {
                if (isElementPresent(by)) {
                    WebDriverWait wait = new WebDriverWait(driver, 120);
                    Boolean res = wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
                }
            } catch (Exception e) {
                takeScreenshot();
            }
        }
    }

    public void waitForElementNotPresent(By by, int t) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, t);
            Boolean res = wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
        } catch (Exception e) {
            takeScreenshot();
        }
    }


    public void readPDF() throws IOException {
        URL url = new URL(driver.getCurrentUrl());
        BufferedInputStream fileToParse = new BufferedInputStream(url.openStream());
        PDFParser parser = new PDFParser(fileToParse);
        parser.parse();
        String output = new PDFTextStripper().getText(parser.getPDDocument());
        pass(output);
        parser.getPDDocument().close();
        driver.close();
    }

    public int checkPDFContent(String... checkValue) throws IOException {
        URL url = new URL(driver.getCurrentUrl());
        BufferedInputStream fileToParse = new BufferedInputStream(url.openStream());
        PDFParser parser = new PDFParser(fileToParse);
        parser.parse();
        String output = new PDFTextStripper().getText(parser.getPDDocument());
        int len = checkValue.length;
        for (int i = 0; i <= (len - 1); i++) {
            if (output.contains(checkValue[i])) {
                pass(checkValue[i] + " is present in the PDF file");
            } else {
                fail(checkValue[i] + " is not present in the PDF file");
                resultcount++;
                takeScreenshot();
            }
        }
        pass(output);
        parser.getPDDocument().close();
        driver.close();
        return resultcount;
    }

    
   
    public int checkElement(String element, String message) throws IOException {
        try {
            assertTrue(isElementPresent(xpath(element)));
            pass(message);
        } catch (AssertionError e) {
            message = message.contains("is displayed") ? message.replace("is displayed",
                    "is not displayed") : message.contains("is disabled") ? message.replace("is disabled",
                    "is not disabled") : message.contains("is enabled") ? message.replace("is enabled",
                    "is not enabled") : message.contains("is not enabled") ? message.replace("is not enabled",
                    "is enabled") : message.contains("is generated") ? message.replace("is generated",
                    "is not generated") : message.contains("is selected") ? message.replace("is selected",
                    "is not selected") : message;
            fail(message);
            takeScreenshot();
            resultcount++;
        }
        return resultcount;
    }

   

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    public boolean verifyTextPresent(String value){
    	return driver.getPageSource().contains(value);
    	}
    
    public void clickAt(By by) throws InterruptedException, IOException {
        Thread.sleep(1000);
        if (!browser.equalsIgnoreCase("InternetExplorer")) {
            Actions builder = new Actions(driver);
            try {
                WebElement tagElement = driver.findElement(by);
                builder.moveToElement(tagElement).click().perform();
                Thread.sleep(1000);
            } catch (Exception e) {
                takeScreenshot();
            }
        } else {
            click(by);
        }
    }

    public void doubleClick(By by) throws InterruptedException, IOException {
        Thread.sleep(1000);
        Actions builder = new Actions(driver);
        try {
            WebElement element = driver.findElement(by);
            builder.doubleClick(element).perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            takeScreenshot();
        }
    }

    public void click(By by) throws InterruptedException, IOException {
        waitForElementPresent(by, 5);
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            driver.findElement(by).click();
        }
    }


    public void type(By by, String value) throws InterruptedException {
        try {
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(value);
        } catch (Exception e) {
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(value);
        }
    }

    public void typeAll(String[] path, String[] value) throws InterruptedException {
        int len = path.length;
        for (int i = 0; i <= (len - 1); i++) {
            if (isElementPresent(xpath(path[i]))) {
                type(xpath(path[i]), value[i]);
            }
        }
    }

    public void actionType(By by, String value) throws InterruptedException {
        waitForElementPresent((by));
        new Actions(driver).moveToElement(driver.findElement(by)).click()
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), value).perform();
    }

    public void waitForElementPresent(By by) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 15)
                break;
            if (isElementPresent(by))
                break;
            Thread.sleep(1000);
        }
    }

    public void waitForElementPresent(By by, int i) throws InterruptedException {
        for (int second = 0; second <= i; second++) {
            if (second >= i) {
                break;
            }
            if (isElementPresent(by)) {
                break;
            }
            Thread.sleep(1000);
        }
    }

    public void waitForElementsPresent(By by1, By by2, int i) throws InterruptedException, IOException {
        for (int second = 0; second <= i; second++) {
            if (second >= i) {
                takeScreenshot();
                break;
            }
            if (isElementPresent(by1)) {
                break;
            }
            if (isElementPresent(by2)) {
                break;
            }
            Thread.sleep(1000);
        }
    }

    public void waitForOneElementPresent(int i, By... by) throws InterruptedException, IOException {
        boolean found = false;
        for (int second = 0; second <= i; second++) {
            if (second >= i) {
                takeScreenshot();
                break;
            }
            for (By singleBy : by) {
                if (isElementPresent(singleBy)) {
                    try {
                        waitForElementVisible(singleBy);
                    } catch (Exception e) {
                        takeScreenshot();
                    }
                    found = true;
                }
            }
            if (found) {
                break;
            }
            Thread.sleep(1000);
        }
    }

    public void waitForMultipleElements(int i, By... by) throws InterruptedException, IOException {
        for (int second = 0; second <= i; second++) {
            if (second >= i) {
                takeScreenshot();
                break;
            }
            if (areAllElementsPresent(by)) {
                for (By singleBy : by) {
                }
                break;
            }
            Thread.sleep(1000);
        }
    }

    public boolean verifyMultipleElements(int i, By... by) throws InterruptedException, IOException {
    	boolean allPresent = false;
        for (int second = 0; second <= i; second++) {
        	allPresent = areAllElementsPresent(by);
            if (second >= i) {
                takeScreenshot();
                return allPresent;
            } else {
            	if (allPresent) {
            		return true;
            	}
            }                        
            
            Thread.sleep(1000);
        }
        
        return allPresent;
    }
    
    public void waitForCondition(int i, boolean b) throws InterruptedException {
        for (int second = 0; second <= i; second++) {
            if (second >= i) {
                break;
            }
            if (b) {
                break;
            }
            Thread.sleep(1000);
        }
    }

    public boolean areAllElementsPresent(By... by) {
        for (By singleBy : by) {
            if (!isElementPresent(singleBy)) {
                return false;
            }
        }
        return true;
    }

    public void waitLongerForElementPresent(By by) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 360)
                break;
            if (isElementPresent(by)) {
                break;
            }
            Thread.sleep(1000);
        }
    }

    public boolean isElementVisible(final By by) throws InterruptedException {
        boolean value = false;
        waitForElementPresent(by);
        if (driver.findElement(by).isDisplayed()) {
            value = true;
        }
        return value;
    }
   

    public void waitForElementVisible(By by) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 15)
                break;
            if (isElementVisible(by))
                break;
            Thread.sleep(1000);
        }
    }

    public void waitForElementInVisible(By by, int time) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= time)
                break;
            if (!isElementVisible(by))
                break;
            Thread.sleep(1000);
        }
    }

    public void waitForElementVisible(By by, int time) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= time)
                break;
            if (isElementVisible(by))
                break;
            Thread.sleep(1000);
        }
    }

    public String getText(By by) {
        String value = driver.findElement(by).getText();
        return value;
    }

    public String getValue(By by) {
        String value = "";
        if (isElementPresent(by)) {
            value = driver.findElement(by).getAttribute("value");
        }
        return value;
    }
    public String isReadOnly(By by) {
        String readonly = "";
        if (isElementPresent(by)) {
            readonly = driver.findElement(by).getAttribute("readonly");
        }
        return readonly;
    }    
    public String getValue(By by, String attribute) {
        String value = "";
        if (isElementPresent(by)) {
            if (driver.findElement(by).getAttribute(attribute) != null) {
                value = driver.findElement(by).getAttribute(attribute);
            }
        }
        return value;
    }
    
    public String getTooltip(By by) {
    String tooltip = "";
    if (isElementPresent(by)) {
        tooltip = driver.findElement(by).getAttribute("title");
    }
    return tooltip;
	}
    
    public String getChecked(By by) {
        String value = "";
        if (isElementPresent(by)) {
            value = driver.findElement(by).getAttribute("checked");
        }
        return value;
    }

  
    public void rightClick(By by) {
        new Actions(driver).moveToElement(driver.findElement(by)).contextClick(driver.findElement(by)).perform();
    }

   
    public WebElement findElement(By by) {
        WebElement elem = driver.findElement(by);
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
        }
        return elem;
    }
    
    public void select(By by, String value) throws InterruptedException {
        try {
        	new Select(driver.findElement(by)).selectByVisibleText(value);
        } catch (Exception e) {
        	new Select(driver.findElement(by)).selectByVisibleText(value);
        }
    }
    
    public void selectOption(By by, String value) {
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByValue(value);
	}
    
    public String checkElementProperty(String element, String message) throws IOException {
        try {
            assertTrue(isElementPresent(xpath(element)));
            pass(message);
        } catch (AssertionError e) {
            message = message.contains("is displayed") ? message.replace("is displayed",
                    "is not displayed") : message.contains("is disabled") ? message.replace("is disabled",
                    "is not disabled") : message.contains("is enabled") ? message.replace("is enabled",
                    "is not enabled") : message.contains("is not enabled") ? message.replace("is not enabled",
                    "is enabled") : message.contains("is generated") ? message.replace("is generated",
                    "is not generated") : message.contains("is selected") ? message.replace("is selected",
                    "is not selected") : message;
            fail(message);
            takeScreenshot();
            resultcount++;
        }
        return message;
    }
    
    public String getDataFromxls(int sheetnumber, String XLSfilename, int row, int column) throws Exception{
//	    FileInputStream file = new FileInputStream("src/test/java/hub/library/" + XLSfilename);
//	    Workbook datafile = Workbook.getWorkbook(file);
	    Workbook datafile = Workbook.getWorkbook(new File("src/test/java/hub/library/" + XLSfilename));
	    Sheet sheetname;
	    sheetname = datafile.getSheet(sheetnumber);
	    String value = sheetname.getCell(row, column).getContents();
	    return value;
    }
    
    public void waitForElement(String element)throws Exception{
		if(!isElementPresent(xpath(element))){ Thread.sleep(7000); }	
	
	}
    
    public void waitInSecond(int num, String xpathval ) throws InterruptedException {
        
    	do{
    		if(!(driver.findElements(By.xpath(xpathval)).size() != 0)){ 
    			Thread.sleep(1000);
    			}
        	num--;
        }while(num != 0);
        	
    }

        
}
