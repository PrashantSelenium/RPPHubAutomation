package hub.test.endtoend;

import hub.library.TestInitReference;
import static org.openqa.selenium.By.xpath;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MEBank extends TestInitReference {
		    
    @BeforeClass
    public void init() {
           driver.navigate().to("https://dev-mebank.rppropertyhub.com/Login");
    }
    
	@Test(description="User - MEBank", priority=0)
	public void MEBankMultipleProducts() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		util.LoginChannel("mebank");
		util.slas_dynamic(getDataFromxls(0, "userMEBank.xls", 1, 0));
		util.startNewTransaction();
		util.multipleProductMEBank();		
	}
	
	@Test(description="User - MEBank", priority=1)
	public void MEBankSingleProducts() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		click(xpath(changeAddressLink));
		Thread.sleep(1000);
		util.slas_dynamic(getDataFromxls(0, "userMEBank.xls", 1, 1));
		util.startNewTransaction();
		util.singleProductMEBank();		
	}
	
	@Test(description="User - MEBank", priority=2)
	public void MEBankNoProducts() throws Exception {
		
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		click(xpath(changeAddressLink));
		Thread.sleep(1000);
		util.slas_dynamic(getDataFromxls(0, "userMEBank.xls", 1, 2));
		util.startNewTransaction();
		util.noProductMEBank();		
	}
}
