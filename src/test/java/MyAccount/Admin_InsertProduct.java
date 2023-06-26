package MyAccount;

import java.io.File;
import java.util.List;

import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_InsertProduct {
@Test
	public void insertProd() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/Admin/");
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		 WebElement cat = driver.findElement(By.name("category"));
		 
		 Select s=new Select(cat);
		 s.selectByVisibleText("Book");
		WebElement scat = driver.findElement(By.id("subcategory"));
		Select s1=new Select(scat);
		s1.selectByValue("287");
		driver.findElement(By.name("productName")).sendKeys("PS-1");
		driver.findElement(By.name("productCompany")).sendKeys("Chola Empire");
		driver.findElement(By.name("productpricebd")).sendKeys("1000");
		
		driver.findElement(By.name("productprice")).sendKeys("750");
		driver.findElement(By.name("productDescription")).sendKeys("made in japan");
		driver.findElement(By.name("productShippingcharge")).sendKeys("50");
		WebElement avail = driver.findElement(By.id("productAvailability"));
		Select s2=new Select(avail);
		s2.selectByVisibleText("In Stock");
		File f=new File(".\\src\\test\\resources\\Book IMG.png");
		String path = f.getAbsolutePath();
		Thread.sleep(9000);
		driver.findElement(By.name("productimage1")).sendKeys(path);
		File f1=new File(".\\src\\test\\resources\\Book IMG.png");
		String path1=f1.getAbsolutePath();
		Thread.sleep(9000);
		driver.findElement(By.name("productimage2")).sendKeys(path1);
		File f2=new File(".\\src\\test\\resources\\Book IMG.png");
		String path2=f2.getAbsolutePath();
		Thread.sleep(9000);
		driver.findElement(By.name("productimage3")).sendKeys(path2);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[text()='Manage Products ']")).click();
		 String proname = driver.findElement(By.xpath("//td[text()='full-sleevw']")).getText();
		
		List<WebElement> prods = driver.findElements(By.xpath("//tr/td[2]"));
		int count = prods.size();
		System.out.println(count);
		for (int i = 0; i <count;i++) {
			String text = prods.get(i).getText();
			if(text.contains(proname)){
				System.out.println("product added");
			}
				else {
					
				System.out.println(" not added");
				}
		
		
			
			
		}
		
		
		
		
		
		
		
		
		

		
	}

}
