package PomObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaUtility;

public final class Loginpage {
	@FindBy(xpath = "//div[@class='col-md-6 col-sm-6 sign-in']/child::form/div[1]//input[@name='email']")
	private WebElement emailAdd;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement logbtn;
	
	@FindBy(name="fullname")
	private WebElement fulnam;
	
	String textField="//span[text()='%s']/../following-sibling::div//input";
	String radioButton="//span[text()='%s']";
	
	@FindBy(name="emailid")
	private WebElement emalid;
	
	@FindBy(name="contactno")
	private WebElement contact;
	
	@FindBy(id="password")
	private WebElement create_password;
	
	@FindBy(id="confirmpassword")
	private WebElement con_password;
	
	@FindBy(id="submit")
	private WebElement signup;
	
	
	public WebElement getElement(String elementPartialXpath, String replaceData) {
	return	driver.findElement(By.xpath(String.format(elementPartialXpath, replaceData)));
	}
	
	
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getEmailAdd() {
		return emailAdd;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLogbtn() {
		return logbtn;
	}


	public WebElement getFulnam() {
		return fulnam;
	}


	public WebElement getEmalid() {
		return emalid;
	}


	public WebElement getContact() {
		return contact;
	}


	public WebElement getCreate_password() {
		return create_password;
	}


	public WebElement getCon_password() {
		return con_password;
	}


	public WebElement getSignup() {
		return signup;
	}
	
	public void login(String USERNAME,String PASSWORD) {
		emailAdd.sendKeys(USERNAME);
		 password.sendKeys(PASSWORD);
		 logbtn.click();                                     
		 
		
		
	}
	public void createAcc(String FULLNAME,String EMAIL,String PHONE,String PASSWRD,String ConPassword,JavaUtility jLib,String USERNAME,String PASSWORD) {
		//JavaUtility ju = new JavaUtility();
		fulnam.sendKeys(FULLNAME);
		//emalid.sendKeys(jLib.random()+EMAIL);  
		
		contact.sendKeys(PHONE);
		create_password.sendKeys(PASSWRD);
		con_password.sendKeys(ConPassword);
		signup.click();
		
		emailAdd.sendKeys(USERNAME);
		 password.sendKeys(PASSWORD);
		 logbtn.click(); 
		
		getElement(radioButton, "round-trip");
		
		
		
	}
	/*
	public static void main(String[] args) {
		String s="My name is %s";
//		String ss = s.replace("###", "Mohan");
		
		String ss =	String.format(s, "Mohan");
	System.out.println(ss);
	}
	*/
	
	

}
