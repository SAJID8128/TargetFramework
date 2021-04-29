package utilities;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SharedMethods {
	
	// Explicit wait for element
		public static WebElement explicitWaitForElement(WebElement element, WebDriver driver, int time) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
			return e;
		}
		
		// Click on Element
		public static void clickOnElement(WebElement element, WebDriver driver, int time) {
			explicitWaitForElement(element, driver, time).click();
		}
		
		// Mouse Hover on Element
		public static void mouseHover(WebElement element, WebDriver driver) {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		
		// Select based Dropdown
		public static void dropdownHandling(WebElement element, Object countries) {
			Select select = new Select(element);
			select.selectByVisibleText(countries.toString());		
		}
		
		// Broken Links Checking
		public static void verifyLinkActive(String linkUrl) {
			try {
				URL url = new URL(linkUrl);		
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				httpURLConnection.setConnectTimeout(3000);
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnection.getResponseCode());
				} else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + HttpURLConnection.HTTP_NOT_FOUND);
				}
			} catch (Exception e) {
			
			}

		}
		
		// Type and Enter
		public static void type(WebElement element, WebDriver driver, String text, int time) {
			explicitWaitForElement(element, driver, time).sendKeys(text,Keys.ENTER);
		}

}
