package SearchTextField;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.xml.stream.events.ElementTypeNames;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchByProductname {
	public static void main(String[]args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
     FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
     Properties p=new Properties();
     p.load(fis);
     String URL = p.getProperty("url");
    String UN = p.getProperty("username");
    String PWD = p.getProperty("password");
    driver.manage().window().maximize();
    driver.get(URL);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    driver.findElement(By.xpath("//a[text()='Login']")).click();
    driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
    driver.findElement(By.name("login")).click();
    driver.findElement(By.xpath("//a[text()='Home']")).click();
    String pname="kodak";
    driver.findElement(By.name("product")).sendKeys("kodak"+Keys.ENTER);
   // driver.findElement(By.xpath("//button[@name='search']")).click();
    //String atitle = driver.getTitle();
   String aname= driver.findElement(By.xpath("//div[@class='search-result-container']/..//div[@class='product-info text-left']")).getText();
    System.out.println(aname);
   if(pname.equalsIgnoreCase(aname)) {
    //if(atitle.contains("Product")){
    	System.out.println("user is able to search the product from search box ");
    	
    }
    else {
    	System.out.println("user is not  able to search the product from search box");
    }
   
    
    
    
    
    
	}
	

}
