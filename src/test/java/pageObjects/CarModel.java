package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CarModel extends BasePage {

	public CarModel(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a")
	WebElement usedCars;

	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
	WebElement chennai;

	@FindBy(xpath = "//*[@id=\"seoMore\"]/span")
	WebElement readMoreChennai;

	@FindBy(xpath = "//*[@id=\"usedcarttlID\"]")
	WebElement usedCarsSection;

	@FindBy(xpath = "//table[@class='tbl bdr']/tbody/tr/td[1]")
	WebElement top5Model;

	@FindBy(xpath = "//a[@title=\"Home\"]/span[contains(text(),\"Home\")]")
	WebElement home;

	//Clicking on Chennai option
	public void clickChennai() {
		Actions act = new Actions(driver);
		act.moveToElement(usedCars).build().perform();
		chennai.click();
	}
    // Used cars element display check method 
	public boolean displayOfUsedCars() {
		boolean display = usedCarsSection.isDisplayed();
		return display;
	}

	// Click on read more
	public void clickReadMoreChennai() {
		readMoreChennai.click();
	}

	// Scrolling the page
	public void scrollCarPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300);");
	}

	// List of used cars in Chennai
	public List<WebElement> listOfUsedCars() {
		List<WebElement> cars = driver.findElements(By.xpath("//table[@class='tbl bdr']/tbody/tr/td[1]"));
		return cars;

	}

	// Returning to home
	public void backToHome() {
		home.click();
	}

}
