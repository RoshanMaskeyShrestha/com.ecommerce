package Practisepackage;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripHandlingCalender {

	public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    
    driver.manage().window().maximize();
    driver.get("https://www.makemytrip.com/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//li[text()='Round Trip']")).click();
    //driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
    //driver.findElement(By.xpath("//span[.='From']")).sendKeys("Mumbai");
    driver.findElement(By.id("fromCity")).sendKeys("Mumbai");
    driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
    //driver.findElement(By.xpath("//span[.='To']")).sendKeys("Delhi");
    driver.findElement(By.id("toCity")).sendKeys("Delhi");
    driver.findElement(By.xpath("//p[contains(text(),'New Delhi, India')]")).click();
    driver.findElement(By.xpath("//div[@aria-label='Sun May 14 2023']")).click();
    driver.findElement(By.xpath("//div[@aria-label='Fri May 19 2023']")).click();
    
   // driver.findElement(By.xpath("//a[@class='close']")).click();
    
    driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
    driver.findElement(By.xpath("//li[@data-cy='adults-3']")).click();
    driver.findElement( By.xpath("//li[@data-cy='children-2']")).click();
    driver.findElement(By.xpath("//button[text()='APPLY']")).click();
    
    driver.findElement(By.xpath("//a[text()='Search']")).click();
    
    
    
    
    
	}

}
