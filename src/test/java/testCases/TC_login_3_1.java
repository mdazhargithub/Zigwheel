package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_login_3_1 extends BaseClass {
	LoginPage lp;

	@Test(dataProvider="login",dataProviderClass=DataProviders.class)
	
	public void validateLogin(String email, String pass) throws InterruptedException {

		logger.info("**** Starting *****");

		lp = new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(2000);
		lp.clickGoogle();
		Thread.sleep(2000);
		lp.switchWindow();
		Thread.sleep(2000);
		//lp.enterEmailId("abd");
		lp.enterEmailId(email);
		lp.clickNext();
		Thread.sleep(3000);
		// Capture the error message
		System.out.println(lp.captureErrorMsg());
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();

		logger.info("**** Finished TC_003_LoginDDT *****");

//		driver.close();

	}

}
