package PomObject;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;

public class Mycartpage {
	@FindBy(xpath="//a[text()='Continue Shopping']")
private WebElement continueshop;
	
	@FindBy(xpath="//input[@value='Update shopping cart']")
	private WebElement updatshop;
	
	@FindBy(name="update")
	private  WebElement shipadd;
	
	@FindBy(name="shipupdate")
	private WebElement billadd;
	
	//@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")
	@FindBy(name="ordersubmit")
	private WebElement payprocess;
	
	@FindBy(xpath="//i[@class='glyphicon glyphicon-shopping-cart']")
	private WebElement icart;
	
	@FindBy(name="billingaddress")
	private WebElement billingadd;
	
	@FindBy(name="bilingstate")
	private WebElement billingstat;
	
	@FindBy(xpath="//input[@id='billingcity']")
	private WebElement billincity;
	
	@FindBy(name="billingpincode")
	private WebElement billingpin;
	

	@FindBy(name="shippingaddress")
	private WebElement shippingadd;
	

	@FindBy(name="shippingstate")
	private WebElement shippingstat;
	

	@FindBy(name="shippingcity")
	private WebElement shippincity;
	

	@FindBy(name="shippingpincode")
	private WebElement  shippingpin;
	
	@FindBy(xpath="//tr/td[3]/h4[@class='cart-product-description']")
	private WebElement MyCartstuffslist;
	
	
	
	public WebElement getMyCartstuffslist() {
		return MyCartstuffslist;
	}


	public  Mycartpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getBillingadd() {
		return billingadd;
	}


	public WebElement getBillingstat() {
		return billingstat;
	}


	public WebElement getBillincity() {
		return billincity;
	}


	public WebElement getBillingpin() {
		return billingpin;
	}


	public WebElement getShippingadd() {
		return shippingadd;
	}


	public WebElement getShippingstat() {
		return shippingstat;
	}


	public WebElement getShippincity() {
		return shippincity;
	}


	public WebElement getShippingpin() {
		return shippingpin;
	}


	public WebElement getContinueshop() {
		return continueshop;
	}


	public WebElement getUpdatshop() {
		return updatshop;
	}


	public WebElement getShipadd() {
		
		return shipadd;
	}


	public WebElement getBilladd() {
		return billadd;
	}


	public WebElement getPayprocess() {
		return payprocess;
	}


	public WebElement getIcart() {
		return icart;
	}
	
	public void addcontinueshop() {
		continueshop.click();
	}
	public void addupdateshop() {
		updatshop.click();
	}
	public String MyCartstuffslist() {
		return MyCartstuffslist.getText();
	}
	
	//String cartname=driver.findElement(By.xpath("//tr/td[3]/h4[@class='cart-product-description']")).getText();
	//return cartname;
	
	
	/*
	public void addshipadd(ExcelUtility elib) throws Throwable{
		
		HashMap<String, String> map = elib.readmultipleData("Sheet2");
		String saddress = map.get("billingaddress");
		String sstate = map.get("bilingstate");
		String scity = map.get("billincity");
		String spin = map.get("billingpin");
		billingadd.sendKeys(saddress);
		billingstat.sendKeys(sstate);
		billincity.sendKeys(scity);
		billingpin.sendKeys(spin);
		shipadd.click();
		*/
		
	public void addshipadd(ExcelUtility elib,WebDriver driver ) throws Throwable {
		HashMap<String, String> map = elib.readmultipleData("Sheet2");
		for (Entry<String, String> set: map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			
		}	
		shipadd.click();
		
	}
	/*
	public void addbilladd(ExcelUtility elib) throws Throwable {
		HashMap<String, String> map1 = elib.readmultipleData("Sheet2");
		String baddress = map1.get("shippingadd");
		String bstate = map1.get("shippingstat");
		String bcity = map1.get("shippincity");
		String bpin = map1.get("shippingpin");
		shippingadd.sendKeys(baddress);
		shippingstat.sendKeys(bstate);
		shippincity.sendKeys(bcity);
		shippingpin.sendKeys(bpin);
		billadd.click();
		
	}
	*/
public void addbilladd() {
	billadd.click();
}
	public void addpayprocess() {
		payprocess.click();
	}
	
	
}

