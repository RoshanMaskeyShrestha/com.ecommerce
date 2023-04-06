package PomObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productcategorypage {
	
	
	@FindBy(xpath="//a[contains(text(),'t-shirts')]")
	private WebElement subcategory;
	
	@FindBy(xpath="//img[@src='admin/productimages/264/IMG_20191207_191305.jpg']")
	private WebElement prod;
	
	@FindBy(xpath="(//a[@title='Wishlist'])[2]")
	private WebElement wishlist;
	
	@FindBy(xpath="(//button[text()='Add to cart'])[2]")
	private WebElement cart;
	
	

	

	public Productcategorypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
		
	}

	public WebElement getSubcategory() {
		return subcategory;
	}
	
	public void viewproduct() {
		subcategory.click();
	}

	public WebElement getProd() {
		return prod;
	}
	
	public WebElement getWishlist() {
		return wishlist;
	}
	
	public WebElement getCart() {
		return cart;
	}
	
	public void imgprod() {
		prod.click();
	}
	
	public void addwishList() {
		wishlist.click();
	}
	public void addcart() {
		cart.click();
	}

}
