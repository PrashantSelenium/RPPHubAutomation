package hub.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hub.utilities.AdminPromotionCodeUtil;
import hub.library.ReadXlsData;
import hub.library.TestInitReference;


public class AdminPromotionCodeTest extends TestInitReference {
	
	AdminPromotionCodeUtil admPromoCodeUtil;
	
	@Test(description="Admin Promotion Code Test", dataProvider = "Data-Provider-Function")
	public void promotionTest(Class clzz, String[] input) {		
		
		this.admPromoCodeUtil = new AdminPromotionCodeUtil(input);
			
		try {
			this.admPromoCodeUtil = new AdminPromotionCodeUtil(input);
			this.admPromoCodeUtil.checkPromotionListHeader();
			this.admPromoCodeUtil.checkAttributes();
			this.admPromoCodeUtil.checkPromotionCodeForm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@BeforeMethod
	public void login() throws Exception
	{
		new AdminPromotionCodeUtil().adminLogin();
		new AdminPromotionCodeUtil().navigateToPromoListPage();
	}
	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException {
		Object[][] data = null; 
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/adminPromotion.xls");
		data = rxd.getData();
		return data;
	}
	
}
