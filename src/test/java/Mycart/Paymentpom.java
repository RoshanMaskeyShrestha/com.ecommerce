package Mycart;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;

import PomObject.Homepage;
import PomObject.Loginpage;
import PomObject.Mycartpage;
import PomObject.Paymentmethodpage;
import PomObject.Productcategorypage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Paymentpom {
	public static void main(String[]args) throws Throwable {
		DatabaseUtility du=new DatabaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fug=new FileUtility();
		JavaUtility ju=new JavaUtility();
		WebdriverUtility wdu=new WebdriverUtility();
		
		String URL = fug.readdatafromProperty("url");
		String UN = fug.readdatafromProperty("username");
		String PWD = fug.readdatafromProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new  ChromeDriver();
		wdu.maximizewindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);
		
		Loginpage lp = new Loginpage(driver);
		lp.login(UN, PWD);
		
		Homepage hp = new Homepage(driver);
		hp.Home();
		hp.category();
		
		Productcategorypage pc = new Productcategorypage(driver);
		pc.viewproduct();
		pc.addcart();
		
		//driver.switchTo().alert().accept();
		wdu.acceptAlert(driver);
		
		Mycartpage mcp = new Mycartpage(driver);
		mcp.addshipadd(eu,driver);
        // mcp.addbilladd();
         mcp.addpayprocess();
         
		
		//Paymentmethodpage pmp = new Paymentmethodpage(driver);
		//pmp.clickcod();
		Thread.sleep(4000);
		hp.createLogout();
		
		
	

}
}