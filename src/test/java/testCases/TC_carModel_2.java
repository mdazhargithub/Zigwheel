package testCases;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import pageObjects.CarModel;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC_carModel_2 extends BaseClass {
	CarModel car ;
	ExcelUtility excelutility;
	String excelpath = System.getProperty("user.dir") + "//testData//bike_details.xlsx";
	// for screenshot 
	
	
	@Test
	public void validateCars() throws InterruptedException, IOException {
		BaseClass car2 = new BaseClass(); // add
		
		
		logger.info("**** Started TC_carModel_2 *****");
		car = new CarModel(driver);
		excelutility  = new ExcelUtility(excelpath);
		Thread.sleep(2000);
		car.clickChennai();
		logger.info("**** Clicked on chennai *****");
		Thread.sleep(2000);
		boolean top5 = car.displayOfUsedCars();
		Assert.assertEquals(top5,true,"Top 5 car section in chennai not displayed");
		logger.info("**** Top 5 car displayed *****");
		logger.info("**** Clicking on read more *****");
		car.clickReadMoreChennai();
		logger.info("**** Clicked on read more *****");
		Thread.sleep(1200);
		logger.info("**** Scrolling started *****");
		car.scrollCarPage();
		logger.info("**** Scrolling ended *****");
		Thread.sleep(1200);
		
		// Taking screenshot of used cars list
		try {
			
			car2.captureScreenshot("UsedCars");
			Thread.sleep(1200);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		List<WebElement> listOfUsedCars= car.listOfUsedCars();
		for (int i =0;i<listOfUsedCars.size();i++) {
			String carName = listOfUsedCars.get(i).getText();
			String sheet = "Sheet3";
			System.out.println(carName);
			excelutility.setCellData(sheet, i, 0, carName); // Adding car name into the excel sheet
			
		}
	//	logger.info("***** clicking to back on home page *****");
		//car.backToHome();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		logger.info(" ***** Switched to home page again *****");
		logger.info("**** Finished TC_carModel_2 *****");
	}
	  
	

}
