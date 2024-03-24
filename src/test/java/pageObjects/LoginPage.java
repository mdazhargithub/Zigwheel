package pageObjects;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="#des_lIcon")
	WebElement login ;
	
	@FindBy(xpath="//span[contains(text(),\"Google\")]")
	WebElement loginWithGoogle ;
	
	@FindBy(id="identifierId")
	WebElement email ;
	
	@FindBy(xpath="//span[contains(text(),\"Next\")]")
	WebElement next ;
	
	@FindBy(xpath="//div[contains(text(),\"Couldn’t find your Google Account\") or contains(text(),\"Enter an email or phone number\")]")
	WebElement errorMessage ;
	
//	@FindBy(xpath="//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div[1]/form/span/section/div/div/div[1]/div/div[2]/div[2]/div/font/font")
	@FindBy(xpath="//*[@jsname='B34EJ']/div")
	WebElement error1;
	
	
	@FindBy(xpath="//div/input[@name=\"Passwd\"]")
	WebElement password ;
	
	@FindBy(xpath="//*[@id=\"passwordNext\"]/div/button/div[3]")
	WebElement nextafterpass;
	
	//@FindBy(xpath="//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div[1]/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span/font/font")
	@FindBy(xpath="//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section/div/div/div/div[2]")
	WebElement errorAfterPass;
	
	@FindBy(xpath="//*[@id=\"headingText\"]/span")
	WebElement errorAfterPass2;
	
	
//	@FindBy(xpath="//input[@type=\"email\"]")
//	WebElement randomEmail;
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement randomEmail;
	
	
	@FindBy(xpath="//*[@id=\"next\"]/div/div/a")
	WebElement tryAgain;
	
	

	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/div[3]")
	WebElement next2;
	
	
	//Click on Login Button
	public void clickLogin() {
		login.click();
	}
	
	// Click login By Google 
	public void clickGoogle() {
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Google\")]")));
		//js.executeScript("arguments[0].click();", loginWithGoogle);
		loginWithGoogle.click();
	}
	
	// Switch to Login Window 
	public void switchWindow() throws InterruptedException {
		String parentId=driver.getWindowHandle();
		Set<String> ids=driver.getWindowHandles();
		Thread.sleep(2000);
		for(String id:ids) {
			if(!parentId.equals(id)){
				driver.switchTo().window(id);
				driver.manage().window().maximize();
				break;
			}
		}
	}
	
	// Enter random email id
	public void enterEmailId(String mail) {
		email.sendKeys(mail);
	}
	
	// Click on Next 
	public void clickNext() {
		next.click();
	}
	
	//Capture Error Message
	public String captureErrorMsg() {
		//return errorMessage.getText();
		return error1.getText();
	}
	
	// Enter random password 
	public void enterpw(String pw) {
		email.sendKeys(pw);
	}
	
	public void clicknextAfterPass() {
		nextafterpass.click();
	}
	public String captureErrorMsgAfterPass() {
		//return errorMessage.getText();
		return errorAfterPass.getText();
	}
	public String captureError2() {
		return errorAfterPass2.getText();
	}
	public void randomEmail(String email2) {
		randomEmail.sendKeys(email2);
		
		
	}
	
	public void tryAgain() {
	// add	tryAgain.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", tryAgain);
		
	}
	public void clicknext2() throws InterruptedException {
		//next2.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", next2);
		
		
	}
	public void clearBox() {
		randomEmail.clear();
	}
}

