package Login;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.FileUtility;

import PomObject.Loginpage;

public final class loginPOMTest  extends BaseClass{
	private loginPOMTest() {}
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
		 * }	
		
		*/
		
			
			
		
	//for just to check whether user can able to create the account at this time we have to comment @before method in base class which for login so
	@Test
	public void SignIN() throws Throwable {
		FileUtility fug=new FileUtility();
		String URL = fug.readdatafromProperty("url");
		String UN = fug.readdatafromProperty("username");
		String PWD = fug.readdatafromProperty("password");
		String FN = fug.readdatafromProperty("fullname");

		String EMAIL = fug.readdatafromProperty("emailadd");
	        String CON = fug.readdatafromProperty("contact");
		String PASS = fug.readdatafromProperty("paswrd");
		String CONPASS = fug.readdatafromProperty("conpaswrd");
		
		
		Loginpage lp=new Loginpage(driver);
		lp.createAcc(FN, EMAIL, CON, PASS, CONPASS, null, CONPASS, PASS);
		
		
		
		
		
	
	
		
		
	}
}
	


