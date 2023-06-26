package Practisepackage;

import java.sql.DriverManager;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spicejet {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='From']")).sendKeys("Agra");
		//from.sendKeys("Agra");
		//driver.findElement(By.xpath("//div[text()='BLR - Bengaluru, India']")).click();
		 driver.findElement(By.xpath("//div[text()='To']")).sendKeys("Hyderabad");
		
		
		//driver.findElement(By.xpath("//div[text()='HYD - Hyderabad, India']")).click();
		Date cdate = new Date();
		String[] d=cdate.toString().split(" ");
		String day=d[0];
		String date=d[1];
		String month=d[2];
		String year=d[3];
		String traveldate=day+" "+date+" "+month+" "+year;
		//driver.findElement(By.xpath("//div[text()='May ' and text()='2023']/../following-sibling::div[2]/child::div[4]/div[1]")).click();
//		driver.findElement(By.xpath("//div[.='Passengers']")).click();
//		for(int i=1;i<=3;i++)
//		{
//		
//		
//		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
//		div[text()='Departure Date']
		
		
		}
		

	}


