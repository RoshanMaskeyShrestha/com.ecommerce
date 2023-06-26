package Practisepackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicTable {

	public static void main(String[] args) throws Throwable {
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
    // driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    String country = driver.findElement(By.xpath("//span[text()='Argentina']")).getText();
   String cgold = driver.findElement(By.xpath("//span[text()='Argentina']/parent::div/following-sibling::div[1]")).getText();
   String silver = driver.findElement(By.xpath("//span[text()='Argentina']/parent::div/following-sibling::div[2]")).getText();
   String bronze = driver.findElement(By.xpath("//span[text()='Argentina']/parent::div/following-sibling::div[3]")).getText();
  String text = driver.findElement(By.xpath("//span[text()='Argentina']/../../child::div[4]/following-sibling::div[1]/following-sibling::div[1]/following-sibling::div[1]")).getText();
   
   
   
   
   System.out.println(country+" "+ text +" "+cgold+" "+silver+" "+bronze);
    List<WebElement> teams = driver.findElements(By.xpath("//div[@class='Tablestyles__Wrapper-sc-xjyvs9-0 imdvdL']/div[3]//span[@data-cy='country-name']"));
   ArrayList<String> list=new ArrayList<String>();
   int count=list.size();
   for(int i=0;i<count;i++) {
	   list.add(teams.get(i).getText());
   }
   //for (String myteams : list) {
	   String myteams="Indonesia";
	   
	String gold = driver.findElement(By.xpath("//span[text()='"+myteams +"']/../following-sibling::div[1]")).getText();
	String silver1=driver.findElement(By.xpath("//span[text()='"+myteams +"']/../following-sibling::div[2]")).getText();
	String bronze1 = driver.findElement(By.xpath("//span[text()='"+myteams +"']/../following-sibling::div[3]")).getText();
	String total = driver.findElement(By.xpath("//span[text()='"+myteams +"']/../following-sibling::div[4]")).getText();
	System.out.println(myteams+" "+gold+" "+silver1+" "+bronze1+" "+total);
}
   
   
   
	}
 

