package Wishlist;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Int_wishlistToAddtocart {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		/*
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("mmaskey23@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("98765");
		driver.findElement(By.name("login")).click();
		*/
		FileUtility fug= new FileUtility();
		String URL = fug.readdatafromProperty("url");
		String UN = fug.readdatafromProperty("username");
		String PWD = fug.readdatafromProperty("password");
		WebdriverUtility wdu=new WebdriverUtility();
		wdu.maximizewindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
		driver.findElement(By.name("login")).click();
		
		
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[contains(text(),'camera')]")).click();
		
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'reel camera')]")).click();
		driver.findElement(By.xpath("//a[@title='Wishlist']")).click();
		driver.findElement(By.xpath("//a[text()='Wishlist']")).click();
		String wlist = driver.findElement(By.xpath("//tr/td[2]/div[@class='product-name']")).getText();
		System.out.println(wlist);
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//a[text()='My Cart']")).click();
		String mcart = driver.findElement(By.xpath("//tr/td[3]/h4[@class='cart-product-description']")).getText();
		System.out.println(mcart);
		if(wlist.equalsIgnoreCase(mcart))
			System.out.println("data flowing");
			else
				System.out.println("there is no data flowing");
				
		
		
		

	}

}
