package MyAccount;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;

import PomObject.Homepage;
import PomObject.Loginpage;
import PomObject.Productcategorypage;
import io.github.bonigarcia.wdm.WebDriverManager;
// i have to comment @listener here because to run from suite xml file for listerner
@Listeners(com.GenericUtilities.ListenerImplementationclass.class)
public class ProductviewpomTest extends BaseClass{
	/*
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
		
		Loginpage lp=new Loginpage(driver);
		lp.login(UN, PWD);
		
		Homepage hp=new Homepage(driver);
		hp.Home();
		hp.category();
		
		Productcategorypage p=new Productcategorypage(driver);
		p.viewproduct();
		p.imgprod();
		
		hp.createLogout();
		
		

}
*/
	@Test(retryAnalyzer = com.GenericUtilities.RetryAnlyzer.class)
	public void Productview() throws Throwable {
		
		Homepage hp=new Homepage(driver);
		hp.Home();
		hp.category();
		Productcategorypage p=new Productcategorypage(driver);
		p.viewproduct();
		Assert.fail();
		p.imgprod();
		Reporter.log("Productview",true);
		
		
		
	}
}