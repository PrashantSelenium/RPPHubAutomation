package hub.test;
import hub.library.ObjectReference;
import hub.library.FunctionReference;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;

	public class Sample {

	  public static final String USERNAME = "tooltwist";
	  public static final String AUTOMATE_KEY = "9quC1U5hBNqMfkAByiyp";
	  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	  public static void main(String[] args) throws Exception {
	    
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "IE");
	    caps.setCapability("browser_version", "8.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "7");
	    caps.setCapability("browserstack.debug", "true");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("https://stage-cbalender.rppropertyhub.com/Login");

	    WebElement Username = driver.findElement(By.id("userName"));
	    WebElement Password = driver.findElement(By.id("password"));
	    WebElement Loginbutton = driver.findElement(xpath("(//*[@id='subRegInd'])[2]"));
		Thread.sleep(3000);
		Username.sendKeys("arvin");
		Password.sendKeys("123456Aa");
		Loginbutton.submit();

	    System.out.println(driver.getTitle());
	    Assert.assertTrue(Username.equals("123"));	
	    driver.quit();

	  }
	}
