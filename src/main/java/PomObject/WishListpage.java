package PomObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListpage {
	@FindBy(id="exampleInputEmail1")
	private WebElement emailAdd;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement logbtn;
	
	@FindBy(name="fullname")
	private WebElement fulnam;
	
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
	
	
	public WishListpage(WebDriver driver) {
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
	public void createAcc(String FULLNAME,String EMAIL,int PHONE,String PASSWRD,String ConPassword) {
		fulnam.sendKeys(FULLNAME);
		emalid.sendKeys( EMAIL);
		contact.sendKeys("PHONE");
		create_password.sendKeys(PASSWRD);
		con_password.sendKeys(ConPassword);
		signup.click();
		
		
		
		
		
	}
	
	
	
	

}
