package Wishlist;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoWishlist {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		/*
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/login.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Login")).click();
		*/
WebdriverUtility wdu=new WebdriverUtility();
		
		FileUtility fug=new FileUtility();
		String URL = fug.readdatafromProperty("url");
		String UN = fug.readdatafromProperty("username");
		String PWD = fug.readdatafromProperty("password");
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
		String kod = driver.findElement(By.xpath("//a[.='kodak']")).getText();
		driver.findElement(By.xpath("//a[@class='add-to-cart']")).click();
		driver.findElement(By.xpath("//a[text()='Wishlist']")).click();
		//driver.findElement(By.xpath("//a[text()='Login']")).click();
		//driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
		//driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
		//driver.findElement(By.name("login")).click();
		
		
		
		
		
		
		//driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("kodak");
		//driver.findElement(By.xpath("//button[@class='search-button']")).click();
		
		//String kod = driver.findElement(By.xpath("//a[.='kodak']")).getText();
		//driver.findElement(By.xpath("//a[.='kodak']/../../..//i[@class='icon fa fa-heart']")).click();
		
		//driver.findElement(By.xpath("//a[text()=' womens']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'t-shirts')]")).click();
		//String pname=driver.findElement(By.xpath("//a[text()='seventy eight']")).getText();
	 
 Thread.sleep(2000);
	    List<WebElement> wlist = driver.findElements(By.xpath("//th[.='my wishlist']/../../..//tbody//tr//td[2]//div[@class='product-name']"));
	 for(WebElement list:wlist)
		 {			   String res = list.getText();		  
		 System.out.println(res);
		  
		   if(res.equalsIgnoreCase(kod))
		   {
			   System.out.println("product added in wishlist");			   
		   }
		   else
	   {
			   System.out.println("product not added ");
		   	 } 
		 }
		 /*  String text = driver.getTitle();
		  
		    System.out.println(text);
		    if(text.contains("Wishlist"))
		    	System.out.println("product is added");
		    else 
		    	System.out.println(" not added");
		   */ 	
		
		
		
	
	
		
		

	}

	}
