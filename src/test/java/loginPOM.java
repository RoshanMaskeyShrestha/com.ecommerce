import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ABC;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;

import PomObject.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class loginPOM {
	public static void main(String[]args) throws Throwable {
		DatabaseUtility du=new DatabaseUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fug=new FileUtility();
		JavaUtility ju=new JavaUtility();
		WebdriverUtility wdu=new WebdriverUtility();
		
		
		@ABC String URL = fug.readdatafromProperty("url");
		String UN = fug.readdatafromProperty("username");
		String PWD = fug.readdatafromProperty("password");
		String FN = fug.readdatafromProperty("fullname");

		String EMAIL = fug.readdatafromProperty("emailadd");
	        String CON = fug.readdatafromProperty("contact");
		String PASS = fug.readdatafromProperty("paswrd");
		String CONPASS = fug.readdatafromProperty("conpaswrd");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new  ChromeDriver();
		wdu.maximizewindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);
		
//		Loginpage l=new Loginpage(driver);
//		l.login(UN, PWD);
		
		Loginpage lp=new Loginpage(driver);
		
		lp.createAcc(FN, EMAIL, CON, PASS, CONPASS,ju, UN,PWD);
		Thread.sleep(2000);
		
		//Loginpage l=new Loginpage(driver);
		//lp.login(UN, PWD); 	
		
		
	
		
		
	}
	

}
