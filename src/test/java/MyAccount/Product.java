package MyAccount;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Product {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=WebDriverManager.chromedriver().create();
		/*
		
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\commondata.property");
		 Properties p = new Properties();
		 p.load(fis);
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PWD = p.getProperty("password");
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		*/
		FileUtility fug=new FileUtility();
		String URL=fug.readdatafromProperty("url");
		String UN = fug.readdatafromProperty("username");
		String PWD = fug.readdatafromProperty("password");
		
		WebdriverUtility wdu=new WebdriverUtility();
		wdu.maximizewindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);
		
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
		driver.findElement(By.name("login")).click();
		//Thread.sleep(9000);
		driver.findElement(By.xpath("//a[text()=' womens']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[contains(text(),'t-shirts')]")).click();
		boolean img = driver.findElement(By.xpath("//img[@src='admin/productimages/247/pic1.png']")).isDisplayed();
		if(img==true)
		{
			System.out.println("Product details is visible ");
		}
		else 
			System.out.println("not visible");

	}

}
