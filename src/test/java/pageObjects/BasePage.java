package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;         
		//this line assigns the passed driver object to the driver instance variable.
		//It initializes the driver field with the value provided during object creation.
		PageFactory.initElements(driver, this); 
		// It initializes the driver field with the value provided during object creation.
		// to simplify the initialization of web elements in the BasePage class. 
		//It automatically creates the necessary findElement calls behind the scenes,
	}
}
