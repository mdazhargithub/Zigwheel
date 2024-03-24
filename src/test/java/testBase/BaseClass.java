package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import utilities.ExcelUtility;



public class BaseClass {
	public static WebDriver driver;
	public Properties property;       // declaring properties class object
	//public  Logger logger;
	public static  org.apache.logging.log4j.Logger logger;
	String excelpath = System.getProperty("user.dir") + "//testData//loginDetails.xlsx";
	
	
	
	@BeforeSuite  // for single browser
	//@BeforeTest  // for cross browser
	@Parameters({"Browser"})
	public void setup(String browser) throws IOException {
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		
		logger = LogManager.getLogger(this.getClass()); // this.getclass returns current class
		property  = new Properties();
		property.load(file);
		
		switch(browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			
			case "edge":
				driver = new EdgeDriver();
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				break;
				
			case "safari":
				driver = new SafariDriver();
				break;
				
			default: 
				System.out.println("No matching browser found");
				return;
			
		}
	//	logger = LogManager.getLogger(this.getClass());
		setData();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.navigate().to(property.getProperty("getURL"));   // getting URL value from properties file 
		driver.manage().window().maximize();
	}
	
	public String captureScreenshot(String tname)throws Exception {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
//		FileUtils.copyFile(src, dest);
		return targetFilePath;
	}
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	
	
public void setData() throws IOException {
		
		String randomEmail=randomeString() ;        
		ExcelUtility xlutil=new ExcelUtility(excelpath);
		String sheet = "Sheet2";
		xlutil.setCellData(sheet, 0, 0,"Email" );
	//xlutil.setCellData(sheet, 0, 1,"Password" );
	xlutil.setCellData(sheet, 1, 0,randomEmail );
	//	xlutil.setCellData(sheet, 1, 1,randomEmail );
//		
//		xlutil.setCellData(sheet, 2, 0,"" );
//		xlutil.setCellData(sheet, 2, 1,randomEmail );
//		
//		xlutil.setCellData(sheet, 3, 0,"mdazharuddin295@gmail.com" );
//		xlutil.setCellData(sheet, 3, 1,randomEmail );
		
	
	}
//	@AfterSuite
//	public void closeBrowser() {
//		driver.quit();
//	}
//	
	
	
}
