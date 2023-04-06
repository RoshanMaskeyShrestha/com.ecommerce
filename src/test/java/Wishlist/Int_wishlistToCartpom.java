package Wishlist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import PomObject.Homepage;
import PomObject.Loginpage;
import PomObject.Mycartpage;
import PomObject.Mywishlistpage;
import PomObject.Productcategorypage;
import PomObject.WishListpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Int_wishlistToCartpom {
	public static  void main(String[]args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		
		String URL = flib.readdatafromProperty("url");
	    String UN = flib.readdatafromProperty("username");;
	    String PWD = flib.readdatafromProperty("password");
	    
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    		wlib.maximizewindow(driver);
	    		driver.get(URL);
	    		wlib.implicitwait(driver);
	    		
	    		Homepage hp=new Homepage(driver);
	    		hp.Login();
	    		
	    		Loginpage lp=new Loginpage(driver);
	    		lp.login(UN, PWD);
	    		
	    		hp.Home();
	    		hp.category();
	    		
	    		Productcategorypage pc=new Productcategorypage(driver);
	    		pc.addwishList();
	    		
	    		Thread.sleep(2000);
	    		hp.WishList();
	    		
	    		Mywishlistpage mw=new Mywishlistpage(driver);
	    		
	    	   String wlist=mw.mywishstuffslist();
	    	   mw.wishlistAddCart();
	    	   
	    	   hp.Mycart();
	    	   Mycartpage mc=new Mycartpage(driver);
	    	   String clist = mc.MyCartstuffslist();
	    	   
	    	   if(clist.equalsIgnoreCase(wlist)) {
	    		   System.out.println("data is flowing");
	    	   }
	    	   else
	    		   System.out.println("data is not  flowing");
	    		
	    	   
	    	   
	    	   
	    	   
	    	   
	    	    
	    	   
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
		
		
	
	}

}
