package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	/*
	 * Webdriver
	 * Properties
	 * Logs
	 * Extent report
	 * DB
	 * Excel
	 * Mail
	 * 
	 * 
	 */

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	
	@BeforeSuite
	public void Setup() {
		
		if(driver==null) {
			
			prop=new Properties();
			fis = null;
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test"
						+ "\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(prop.getProperty("browser").equals("chrome")) {
				System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver_win32\\chromedriver.exe" );
				driver=new ChromeDriver();
			}
			
		}
	}
	
	
	
	@AfterSuite
	public void TearDown() {
		
	}
	
}
