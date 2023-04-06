package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	public void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitforpageload(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void elementtobeVisible(WebElement element,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void select(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void select(String value,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	public void mousehover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	public void draganddrop(WebDriver driver,WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des);
		
	}
	public void doubleclickAction(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
		
		
	}
	public void rightclick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	public void entryKeyPress(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	public void enterkey(WebDriver driver) throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		
	}
	public void keyrelease(WebDriver driver) throws Throwable {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
		
	}
	public void switchToFrame(WebElement element,WebDriver driver) {
		driver.switchTo().frame(element);
	}
	public void switchToFrame(String nameorId,WebDriver driver) {
		driver.switchTo().frame(nameorId);
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchTowindow(WebDriver driver,String partialTitle) {
		//step 1:use getwindowhandles to get all windows id
		Set<String> windows = driver.getWindowHandles();
		//step 2:iterate through the window
		Iterator<String> it=windows.iterator();
		//step 3:check whether there is next window or not
		while(it.hasNext()) {
			String winID = it.next();
			//step 5:switch to current window and capture the title
			String currentwintitle = driver.switchTo().window(winID).getTitle();
			//step 6:check whether current window is as expected
			if(currentwintitle.contains(partialTitle)) {
				break;
			}
		}
	}
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+".png";
		File dst=new File(path);
		FileUtils.copyFile(src, dst);
		return path;
	}
	public void scrollbarAction(WebDriver driver) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scollby(0,800)", " ");
	}
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		j.executeScript("window.scrollBy(0,"+y+")", element);
		//j.executeScript("argument[0].scrollintoview()", element);
		
		
	}
	

}
