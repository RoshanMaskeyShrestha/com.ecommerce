package Wishlist;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.Ipathconstants;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;

import PomObject.Homepage;
import PomObject.Loginpage;
import PomObject.Productcategorypage;
import PomObject.WishListpage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.GenericUtilities.ListenerImplementationclass.class)

public class AddtowishlistpomTest extends BaseClass {
	
	
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
		
		//Loginpage lp = new Loginpage(driver);
		//lp.login(UN, PWD);
		
		WishListpage wl = new WishListpage(driver);
		wl.login(UN, PWD);
		
		Homepage hp = new Homepage(driver);
		hp.Home();
		hp.category();
		
	   Productcategorypage pc = new Productcategorypage(driver);
	   pc.viewproduct();
	   pc.addwishList();
	   hp.createLogout();
	}   
	
*/

	//using base class
	//for test analyser
			@Test(retryAnalyzer =com.GenericUtilities.RetryAnlyzer.class)
	public void addtowisList() throws Throwable {
			
			
			Homepage hp=new Homepage(driver);
			hp.Home();
			hp.category();
			
			Productcategorypage pc = new Productcategorypage(driver);
			//   pc.viewproduct();
			 // pc.imgprod();
			   pc.addwishList();
			   Reporter.log("addwishlist",true);
			   
			
			
			
			
		}



	
	
	
	}
		
	
	

