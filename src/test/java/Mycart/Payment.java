package Mycart;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Payment {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\commondata.property");
		 Properties p = new Properties();
		 p.load(fis);
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PWD = p.getProperty("password");
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(UN);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PWD);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//a[text()=' womens']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[contains(text(),'t-shirts')]")).click();
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//a[text()='My Cart'])[1]")).click();
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet2");
		
		HashMap<String, String> map=new HashMap<String, String>();
		
		for(int i=0;i<sh.getLastRowNum();i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
		}
		
		for (Entry<String, String> set: map.entrySet()) {
			//to delete the existing data
			driver.findElement(By.name(set.getKey())).clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			Thread.sleep(2000);
		}
		//driver.findElement(By.name("billingaddress")).clear();
		//driver.findElement(By.name("billingaddress")).sendKeys("kathinagar");
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		//driver.switchTo().alert().accept();
		String etitle = "Payment Method";
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		String atitle = driver.getTitle();
		System.out.println(atitle);
		if(etitle==atitle)
		{
			driver.findElement(By.xpath("//input[@name='paymethod' and @value='Internet Banking']")).click();
			
		}
		String etitle1 = "Order History";
		driver.findElement(By.name("submit")).click();
		String atitle1 = driver.getTitle();
		if(atitle1.contains(etitle1))
			System.out.println("purchased ");
		else 
			System.out.println("not able to purchased");
		String etitle2 = "Shopping Portal Home Page";
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		String atitle2 = driver.getTitle();
		/*
	 if(atitle2.contains(etitle2))
		 System.out.println("user is sucessfully logout");
	 else 
		 System.out.println("not able to logout");
		*/
		assertEquals(etitle2, atitle2);
		System.out.println("user is sucessfully logout");
		
		
		
		

	}

}
