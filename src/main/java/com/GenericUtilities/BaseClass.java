package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import PomObject.Homepage;
import PomObject.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners
public class BaseClass {
  DatabaseUtility dlib=new DatabaseUtility();
  ExcelUtility elib=new ExcelUtility();
  FileUtility flib=new FileUtility();
  WebdriverUtility wlib=new WebdriverUtility();
  public WebDriver driver;
  
  //for ilistener class to re-inilister the driver to take the screenshot
  public static WebDriver sdriver;
	@BeforeSuite
	public void connecttoDB() throws Throwable {
		dlib.connecttoDb();
		TestNGUtil.log("connect to DB");
	}
	
	@Parameters("browser")
	@BeforeClass
	public void openBrowser() throws Throwable {
		String browser = flib.readdatafromProperty("browser");
		String URL = flib.readdatafromProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		//to takescreenshot we utilized sdriver;
		sdriver=driver;
		wlib.maximizewindow(driver);
		driver.get(URL);
		wlib.implicitwait(driver);
	//elib.openExcel();
		
		
	}
	
	@BeforeMethod
	public void login() throws Throwable {
		String USERNAME = flib.readdatafromProperty("username");
		String PASSWORD = flib.readdatafromProperty("password");
		TestNGUtil.log("Login page");
		
		Loginpage lp=new Loginpage(driver);
		lp.login(USERNAME, PASSWORD);
		
	}
	
	
	
	@AfterMethod
	public void logout() {
		TestNGUtil.log("logout");
		Homepage hp=new Homepage(driver);
		hp.createLogout();
	}
	
	@AfterClass
	public void closeBrowser() {
		TestNGUtil.log("Closing Browser");
		driver.quit();
		//elib.closeExcel();
	}
	@AfterSuite 
	public void closeDB() throws Throwable {
		dlib.closeDb();
	}

}
