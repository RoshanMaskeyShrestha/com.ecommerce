package Practisepackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCranking {

	public static void main(String[] args) {
     WebDriver driver=WebDriverManager.chromedriver().create();
     driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
     List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
     ArrayList<String> list=new ArrayList<String>();
     for (int i = 0; i < teams.size(); i++) {
    	 String text=teams.get(i).getText();
    	 list.add(text);
    	 //list.add(teams.get(i).getText());
    	 
		
	}
     /*
     for (String  myteams : list) {
    	 String x="//span[.='"+myteams+"']/../following-sibling::td[3]";
    	String Rating = driver.findElement(By.xpath(x)).getText();
    	 System.out.println("team ->"+ myteams +" ->(rating is)-> "+Rating);
		
	}
	*/
     //String team="Australia";
     System.out.println("enter the team name");
     
     Scanner s=new Scanner(System.in);
     String team=s.nextLine();
     
 	String rating = driver.findElement(By.xpath("//span[.='"+team+"']/../following-sibling::td[3]")).getText();
 	System.out.println(rating);
	}
	

}
