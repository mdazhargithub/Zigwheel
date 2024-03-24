package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_login_3_2 extends BaseClass {
	LoginPage lp;
	
	// Validate Login Page 
//	@Test(dataProvider="login",dataProviderClass=DataProviders.class)
	@Test
	public void validateLogin() throws InterruptedException {
		logger.info("**** TC_login_3_2 Started *****");
		
		lp=new LoginPage(driver);
//		lp.enterEmailId(email);
		lp.enterEmailId("");   // Entering empty email
		logger.info("**** Clicking on next *****");
		lp.clickNext();
		logger.info("**** Clicked on next *****");
		Thread.sleep(3000);
		// Capture the error message
		System.out.println(lp.captureErrorMsg());
		driver.navigate().refresh();
		Thread.sleep(2000);
		logger.info("**** Finished TC_002_LoginDDT *****");
		
//		driver.close();
	}
}
