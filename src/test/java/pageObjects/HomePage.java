package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
	Actions act;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//li/a[@href=\"/newbikes\"]")
	WebElement newBikesDropdown;

	@FindBy(xpath = "//li/a[@href=\"/newbikes\"]/following-sibling::ul/li[5]/span[contains(text(),\"Upcoming Bikes\")]")
	WebElement upcomingBikesInDropdown;

	@FindBy(tagName = "select")
	WebElement brandName;

	@FindBy(xpath = "//ul/li[@class=\"col-lg-4 txt-c rel modelItem \" or @class=\"col-lg-4 txt-c rel modelItem\"]/descendant::div/div[3]/a/strong")
	By listOfUpcomingHondas;

	@FindBy(xpath = "//ul/li[@class=\"col-lg-4 txt-c rel modelItem \" or @class=\"col-lg-4 txt-c rel modelItem\"]/descendant::div/div[3]/div[1]")
	By listOfHondasPrice;

	@FindBy(xpath = "//div/ul/li[7]/a[contains(text(),\"Used\")]")
	WebElement usedCarsDropdown;

	@FindBy(xpath = "//div[@class=\"h-dd-r\"]/ul/li[4]/span")
	WebElement usedCarsInChennai;

	@FindBy(xpath = "//span[contains(text(),'Read More')]")
	WebElement readmore;

	@FindBy(xpath = "//tr[@class=\"ml-15 \"]/td[1]")
	By listOfmodelname;

	@FindBy(xpath = "//tr[@class=\"ml-15 \"]/td[2]")
	By listOfprice;

	@FindBy(xpath = "//tr[@class=\"ml-15 \"]/td[3]")
	By listOflaunchdate;

	// Actions
	// Click on Upcoming Bike from NavBar DropDown
	public void clickUpcomingBikes() {

		act = new Actions(driver);
		act.moveToElement(newBikesDropdown).build().perform();
		upcomingBikesInDropdown.click();

	}

	// Click on Honda from Manufacturer dropDown
	public void clickHonda() {
		Select brand = new Select(brandName);
		brand.selectByValue("53");
	}

	// Click on read more
	public void clickReadMore() {
		readmore.click();

	}

	// Scrolling by pixel
	public void scrollHomePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300);");
	}

	// List of bike name
	public List<WebElement> getBikename() {
		List<WebElement> name = driver.findElements(By.xpath("//tr[@class=\"ml-15 \"]/td[1]"));
		return name;
	}

	// List of bike price
	public List<WebElement> getBikeprice() {
		List<WebElement> price = driver.findElements(By.xpath("//tr[@class=\"ml-15 \"]/td[2]"));
		return price;
	}

	// List of bike launch date
	public List<WebElement> getLaunchdate() {
		List<WebElement> date = driver.findElements(By.xpath("//tr[@class=\"ml-15 \"]/td[3]"));
		return date;
	}

	// List of Upcoming Honda bike
	public List<WebElement> listOfUpcomingHondas() {
		List<WebElement> hondas = driver.findElements(listOfUpcomingHondas);
		return hondas;
	}

	// List of Honda Prices
	public List<WebElement> listOfHondasPrice() {
		List<WebElement> prices = driver.findElements(listOfHondasPrice);
		return prices;
	}

	// Click Used Cars in Chennai
	public void clickUsedCarsInChennai() {
		act.moveToElement(usedCarsDropdown).build().perform();
		usedCarsInChennai.click();
	}

}
