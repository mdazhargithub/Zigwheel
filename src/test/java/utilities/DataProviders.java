package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class DataProviders extends BaseClass{

	//DataProvider 1
	
	@DataProvider(name="login")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\loginDetails.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet2");	
		int totalcols=xlutil.getCellCount("Sheet2",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet2",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	
	
}

