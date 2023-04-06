package Practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReaddatafromPropertyfile {

	public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.property");
	Properties Pobj=new Properties();
	Pobj.load(fis);
	String URL = Pobj.getProperty("url");
	String USERNAME = Pobj.getProperty("username");
	String PASSWORD = Pobj.getProperty("password");
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
	
	
	
	

	}


}