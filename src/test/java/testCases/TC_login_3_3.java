package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_login_3_3 extends BaseClass {
	LoginPage lp;
	public Properties property;

	// Validate Login Page
	@Test
	public void validateLogin() throws InterruptedException, IOException {
		
		logger.info("**** TC_login_3_3 Started *****");
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		property  = new Properties();
		property.load(file);
		lp = new LoginPage(driver);
        
	//	Entering email id from properties data 
		lp.enterEmailId(property.getProperty("validEmailId"));

		// click next
		lp.clickNext();
//		dp.setData();

		// Enter random password
		//String randomPW = randomAlphaNumeric();
	
		Thread.sleep(3000);
		String error1 = lp.captureErrorMsgAfterPass();
		System.out.println(lp.captureErrorMsgAfterPass());
		Assert.assertEquals(error1,"Try using a different browser. If you’re already using a supported browser, you can try again to sign in.","error not match");
		
	//	Try using a different browser. If you’re already using a supported browser, you can try again to sign in.
		System.out.println(lp.captureError2()); //Couldn’t sign you in
		String error2= lp.captureError2();
		Assert.assertEquals(error2,"Couldn’t sign you in","error not matched");
		
		//add
		
//
//		Thread.sleep(2000);
//		driver.navigate().back();
//		Thread.sleep(2000);
//		driver.navigate().back();
//		driver.navigate().refresh();
		logger.info("**** TC_login_3_3 Finished *****");

	}
}
