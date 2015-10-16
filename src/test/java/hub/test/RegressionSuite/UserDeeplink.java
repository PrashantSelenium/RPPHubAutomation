package hub.test.RegressionSuite;

import hub.library.TestInitReference;
import hub.utilities.RegressionSuiteUtil.UserRegressionSuiteUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserDeeplink extends TestInitReference {
	
	@Test(description="Deeplink - No Property ID", priority=0)
	public void successfulDeeplink() throws Exception {
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		String[] hashTimestamp = util.getHash();
		String authToken = util.getAuthToken(hashTimestamp[0],hashTimestamp[1]);
		String accessToken = util.getAccessToken(authToken,"arvin","123456Aa");
		util.validDeepLink(accessToken);
			}
	
	@Test(description="Deeplink - No Property ID", priority=0)
	public void invalidAccessTokenDeeplink() throws Exception {
		UserRegressionSuiteUtil util = new UserRegressionSuiteUtil();
		String accessToken = "12345678iusafq1345sfgs";
		util.invalidDeepLink(accessToken);
			}
	
    @BeforeClass
    public void init() {
           driver.navigate().to("https://dev-bgl.rppropertyhub.com");
    }
 
}
