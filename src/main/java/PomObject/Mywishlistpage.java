package PomObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mywishlistpage {
	@FindBy(xpath="//tr/td[2]/div[@class='product-name']")
	private WebElement mywishstuffslist;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement wishlistAddCart;
	
	@FindBy(xpath="//tr[2]/td[4]/a")
	private WebElement wishlistDeletestuff;
	
	
	public Mywishlistpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMywishstuffslist() {
		return mywishstuffslist;
	}

	public WebElement getWishlistAddCart() {
		return wishlistAddCart;
	}

	public WebElement getWishlistDeletestuff() {
		return wishlistDeletestuff;
	}
	
	public String mywishstuffslist() {
		return mywishstuffslist.getText();
		
	}
    public void wishlistAddCart() {
    	wishlistAddCart.click();
    }
    public void wishlistDeletestuff() {
    	wishlistDeletestuff.click();
    }
    
}
//String wish=driver.findElement(By.xpath("//tr/td[2]/div[@class='product-name']")).getText();
//return wish;