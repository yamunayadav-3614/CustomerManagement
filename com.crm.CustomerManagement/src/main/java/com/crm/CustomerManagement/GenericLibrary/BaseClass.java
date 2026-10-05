package com.crm.CustomerManagement.GenericLibrary;


import java.io.IOException;
import java.lang.reflect.Parameter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ObjectRepository.Homepage;
import ObjectRepository.LoginPage;

public class BaseClass {
	public static  WebDriver driver;
	FileUtillity f=new FileUtillity();
	SeleniumUtillity s=new SeleniumUtillity();
	@BeforeSuite
	public void dataBaseConnection() {
		Reporter.log("database connected sucessfully",true);
	}
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(@Optional("chrome") String BROWSER) throws IOException {
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
				driver=new ChromeDriver();
		}
		
		s.maximizeBrowser(driver);
		s.implicitWait(driver);
		String URL = f.readDatafromProperty("url");
		s.navToApplication(driver, URL);
		Reporter.log("browser launched and navigated to CMT application");
	}
	@BeforeMethod
	public void loginTocmt() throws IOException {
		String un = f.readDatafromProperty("username");
		String pwd = f.readDatafromProperty("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(driver, un, pwd);
		Reporter.log("logged in to cmt sucessfully",true);
		}
	@AfterMethod
	public void logoutFromcmt() {
		Homepage hp=new Homepage(driver);
		hp.logout(driver);
		Reporter.log("logged out sucessfully",true);
	}
	@AfterTest
	public void closeBrowser() {
		s.closeBrowser(driver);
		Reporter.log("browser closed sucessfully",true);
	}
	@AfterSuite
	public void disconnectWithDatabase() {
		Reporter.log("database dissconnected sucessfully",true);
	}
	
	

}
