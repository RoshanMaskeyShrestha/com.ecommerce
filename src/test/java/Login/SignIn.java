package Login;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignIn {

	public static void main(String[] args) throws Throwable {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
/*
FileInputStream fis=new FileInputStream("./src\\test\\resources\\commondata.property");
 Properties p = new Properties();
 p.load(fis);
String URL = p.getProperty("url");
String UN = p.getProperty("username");
String PWD = p.getProperty("password");
driver.manage().window().maximize();


driver.get(URL);
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
*/
WebdriverUtility wdu=new WebdriverUtility();


FileUtility fug=new FileUtility();
String URL = fug.readdatafromProperty("url");
String UN = fug.readdatafromProperty("username");
String PWD = fug.readdatafromProperty("password");
wdu.maximizewindow(driver);
driver.get(URL);
wdu.implicitwait(driver);




driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
driver.findElement(By.name("login")).click();
Thread.sleep(9000);
boolean text=driver.findElement(By.xpath("//a[contains(text(),'Welcome ')]")).isDisplayed();
if(text==true)
	System.out.println("you are in login page");
else
	System.out.println("you are not login");
driver.findElement(By.linkText("Logout")).click();

	}
}
