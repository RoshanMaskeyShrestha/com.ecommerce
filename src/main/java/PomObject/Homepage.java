package PomObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement Myaccount;
	
	@FindBy(xpath="//a[text()='Wishlist']")
	private WebElement Wishlist;
	
	@FindBy(xpath="//a[text()='My Cart']")
	private WebElement MyCart ;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement Login ;
	
	@FindBy(xpath="//span[text()='Track Order']")
	private WebElement Trackorder ;
	
	@FindBy(xpath="(//a[text()='Home'])[1]")
	private WebElement home;
	
	
	
	@FindBy(xpath="(//a[contains(text(),'womens')])[1]")
	private WebElement category;
	
	//@FindBy(xpath="//a[text()='Logout']")

	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement Logout;
	
	@FindBy(xpath="//a[contains(text(),'camera')]")
	private WebElement camera;
	
	
	
	

	

	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
		
	}
	public WebElement getLogout() {
		return Logout;
	}
	public WebElement getHome() {
		return home;
	}

	public WebElement getMyaccount() {
		return Myaccount;
	}

	public WebElement getWishlist() {
		return Wishlist;
	}

	public WebElement getMyCart() {
		return MyCart;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getTrackorder() {
		return Trackorder;
	}
	
	public WebElement getCategory() {
		return category;
	}
		
	
	public void Myaccount() {
		Myaccount.click();
		
	}
	public void WishList() {
		Wishlist.click();
		
	}
	public void Mycart() {
		MyCart.click();
		
	}
	public void Login() {
		Login.click();
		
	}
	public void Trackorder() {
		Trackorder.click();
		
	}
	public void Home() {
		home.click();
	}
	public  void category() {
		category.click();
	}
	public void createLogout() {
		Logout.click();
	}
	

	
}
