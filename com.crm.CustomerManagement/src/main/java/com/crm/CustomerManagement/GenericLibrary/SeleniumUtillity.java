package com.crm.CustomerManagement.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Yamuna Yadav
 * This class is a generic class which is having generic methods for selenium.
 */
public class SeleniumUtillity {
	/**
	 * This method is a generic method used to maximize the browser.
	 * @param driver
	 */
public void maximizeBrowser(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * This method is a generic method used to wait for the element until it present.
 * @param driver
 */
public void implicitWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
/**
 *  This method is a generic method used to navigate to the application.
 * @param driver
 * @param url
 */
public void navToApplication(WebDriver driver,String url) {
	driver.get(url);
}
/**
 *  This method is a generic method used to handle mouse action and used to hover on element.
 * @param driver
 * @param address
 */
public void mouseHover(WebDriver driver,WebElement address) {
	Actions a=new Actions(driver);
	a.moveToElement(address).perform();
}
/**
 *  This method is a generic method used to perform double click.
 * @param driver
 * @param address
 */
public void doubleClick(WebDriver driver,WebElement address) {
	Actions a=new Actions(driver);
	a.doubleClick(address).perform();
}
/**
 *  This method is a generic method used to perform rigt click.
 * @param driver
 * @param address
 */
public void rightclick(WebDriver driver,WebElement address) {
	Actions a=new Actions(driver);
	a.contextClick(address).perform();
}
/**
 *  This method is a generic method used to perform drag and drop.
 * @param driver
 * @param src
 * @param dest
 */
public void dragAnddrop(WebDriver driver,WebElement src,WebElement dest) {
	Actions a=new Actions(driver);
	a.dragAndDrop(src, dest).perform();
}
/**
 *  This method is a generic method used to perform scroll.
 * @param driver
 * @param xaxis
 * @param yaxis
 */
public void scroll(WebDriver driver,int xaxis,int yaxis ) {
	JavascriptExecutor j=(JavascriptExecutor)driver;
	j.executeScript("window.scrollby("+xaxis+","+yaxis+")");
}
/**
 * This method is a generic method used to select option from DropDown.
 * @param address
 * @param text
 */
public void selectOptionByContainsVisibleText(WebElement address,String text) {
	Select s=new Select(address);
	s.selectByContainsVisibleText(text);
}
public void alertPopupOk(WebDriver driver) {
	Alert a = driver.switchTo().alert();
	a.accept();
}
public void alertPopupCancel(WebDriver driver) {
	Alert a = driver.switchTo().alert();
	a.dismiss();
}

/**
 *  This method is a generic method used to close the browser.
 * @param driver
 */
public void closeBrowser(WebDriver driver) {
	driver.quit();
}
}
