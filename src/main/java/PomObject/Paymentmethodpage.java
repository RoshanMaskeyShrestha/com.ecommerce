package PomObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentmethodpage {
	@FindBy(xpath="//input[@value='COD']")
	private WebElement cod;

	@FindBy(xpath="//input[@value='Internet Banking']")
	private WebElement internetbanking;
	
	@FindBy(xpath="//input[@value='Debit / Credit card']")
	private WebElement debitcard;
	
	@FindBy(name="submit")
	private WebElement submit;
	
	
	public Paymentmethodpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCod() {
		return cod;
	}


	public WebElement getInternetbanking() {
		return internetbanking;
	}


	public WebElement getDebitcard() {
		return debitcard;
	}


	public WebElement getSubmit() {
		return submit;
	}
	public void clickcod() {
		cod.click();
	}
	public void clickinternetbanking() {
		internetbanking.click();
		
	}
	public void clickdebitCard() {
		debitcard.click();
	}
	public void clicksubmit() {
		submit.click();
	}

}
