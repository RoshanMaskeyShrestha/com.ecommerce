package Practisepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripHandlingCalender {

	public static void main(String[] args) {
    WebDriver driver=WebDriverManager.chromedriver().create();
    driver.get("https://www.makemytrip.com/");
    driver.findElement(By.xpath("//li[@class='selected']")).click();
    
	}

}
