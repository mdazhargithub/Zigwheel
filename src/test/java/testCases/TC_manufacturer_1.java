package testCases;

import testBase.BaseClass;
import utilities.ExcelUtility;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

public class TC_manufacturer_1 extends BaseClass {
	HomePage hp;
	ExcelUtility excelutility;
	//String excelpath = System.getProperty("user.dir") + "//testData//bike_details.xlsx";
	String excelpath = System.getProperty("user.dir") + "//testData//honda.xlsx";

	@Test
	public void validateManufactureAndPrice() throws InterruptedException, IOException {
		logger.info("**** Started TC_manufacturer_1 *****");
		
		hp = new HomePage(driver);
		excelutility = new ExcelUtility(excelpath);
		Thread.sleep(2000);
		logger.info("***** Clicking On Upcoming Bikes *****");
		hp.clickUpcomingBikes();
		logger.info("***** Clicked On Upcoming Bikes *****");
		Thread.sleep(1200);
		logger.info("***** Clicking On Honda *****");
		hp.clickHonda();
		logger.info("***** Clicked On Honda *****");
		Thread.sleep(1200);
		logger.info("***** Clicking On Read More to expand *****");
		hp.clickReadMore();
		logger.info("***** Clicked On Read More *****");
		Thread.sleep(1200);
		hp.scrollHomePage();
		Thread.sleep(1200);
		List<WebElement> upcomingBikesList = hp.getBikename();
		List<WebElement> upcomingBikesPrice = hp.getBikeprice();
		List<WebElement> expectedLaunchdate = hp.getLaunchdate();
		for (int i = 0; i < upcomingBikesList.size(); i++) {
			String bikeName = upcomingBikesList.get(i).getText();
			String bikeLaunchdate = expectedLaunchdate.get(i).getText();
			String priceN = upcomingBikesPrice.get(i).getText();
			String bikePrice = priceN.substring(priceN.indexOf(' ') + 1);
			if (bikeName.contains("Honda")) {
				if (bikePrice.contains("Lakh")) {
					bikePrice = bikePrice.replaceAll("[^\\d.]", "");
					double numericAmount = Double.parseDouble(bikePrice) * 100000;
					if (numericAmount < 400000) {
						System.out.println(bikeName + " " + numericAmount + " " + bikeLaunchdate);
						String sheet = "Filteredsheet";
						excelutility.setCellData(sheet, 0, 0, "Model Name");
						excelutility.setCellData(sheet, 0, 1, "Price");
						excelutility.setCellData(sheet, 0, 2, "Launch Date");
						excelutility.setCellData(sheet, i+1, 0, bikeName);
						excelutility.setCellData(sheet, i+1, 1, String.valueOf(numericAmount));
						excelutility.setCellData(sheet, i+1, 2, bikeLaunchdate);

					}
				} else {
					bikePrice = bikePrice.replaceAll("[^\\d.]", "");
					double numericAmount = Double.parseDouble(bikePrice);
					if (numericAmount < 400000) {
						System.out.println(bikeName + " " + numericAmount + " " + bikeLaunchdate);
						String sheet = "Filteredsheet";
						excelutility.setCellData(sheet, 0, 0, "Model Name");
						excelutility.setCellData(sheet, 0, 1, "Price");
						excelutility.setCellData(sheet, 0, 2, "Launch Date");
						excelutility.setCellData(sheet, i+1, 0, bikeName);
						excelutility.setCellData(sheet, i+1, 1, String.valueOf(numericAmount));
						excelutility.setCellData(sheet, i+1, 2, bikeLaunchdate);
					}
				}

			} else {
				System.out.println("Filtered for Honda but non-Honda displayed");
				Assert.fail("Filtered for Honda but non-Honda displayed");
			}

		}
		logger.info("**** Finished TC_manufacturer_1 *****");

	}
}
