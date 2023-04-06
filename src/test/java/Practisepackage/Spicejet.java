package Practisepackage;

import java.sql.DriverManager;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spicejet {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement from = driver.findElement(By.xpath("//div[@data-testid='search-source-code']"));
		from.sendKeys("Bengaluru");
		driver.findElement(By.xpath("//div[text()='BLR - Bengaluru, India']")).click();
		WebElement to = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']"));
		to.sendKeys("Hyderabad");
		driver.findElement(By.xpath("//div[text()='HYD - Hyderabad, India']")).click();
		Date cdate = new Date();
		String[] d=cdate.toString().split(" ");
		String day=d[0];
		String date=d[1];
		String month=d[2];
		String year=d[3];
		String traveldate=day+" "+date+" "+month+" "+year;
		driver.findElement(By.xpath("//div[  text()='March ' and text()='2023']/../..//following-sibling::div[.='22']")).click();
		driver.findElement(By.xpath("//div[.='Passengers']")).click();
		for(int i=1;i<=3;i++)
		{
		
		
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		
		
		}
		

	}

}
