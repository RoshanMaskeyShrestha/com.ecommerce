package Practisepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGTYAPP {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		 String eproject = "Dhobiwala2";
		try {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("Dhobiwala2");
		/*
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("document.getelementByname('teamSize').value='4'");
		driver.findElement(By.name("teamSize")).sendKeys("4");
		 
		 */
		driver.findElement(By.name("createdBy")).sendKeys("Shrestha");
		WebElement stat = driver.findElement(By.name("status"));
		Select s=new Select(stat);
		s.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
				con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
				Statement state = con.createStatement();
				String query = "Select * from project;";
				ResultSet result = state.executeQuery(query);
				boolean flag = false;
				while(result.next()) {
					
				
					 String aproject = result.getString(4);
					 System.out.println(aproject);
					 if(aproject.equalsIgnoreCase(eproject))
					 {
						 flag=true;
						 break;
					 }
				}
					 if(flag)
						 System.out.println("project is created");
						 
					 
				else 
					System.out.println("not created");
				
				
		}
		catch (Exception e) {
		
		}
		finally {
			con.close();
		}
				
		
	}
		
		
		

	}


