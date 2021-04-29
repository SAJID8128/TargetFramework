package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TopDeals {
	
	@FindBy(xpath="//body/div[@ID='root']/div[@id='viewport']/div[3]/div[2]/nav[1]/a[7]/span[2]/*[1]")
	WebElement signInDropDownIcon; 
	
	@FindBy(xpath="//div[@class='Row-uds8za-0 glDPjN'][contains(text(),'Create account')]")
	WebElement createAccount;
	
	@FindBy(xpath="//div[@class='Row-uds8za-0 glDPjN'][contains(text(),'Top Deals']")
	WebElement topDeals;
	
	WebDriver driver;
	
	// Constructor
		public TopDeals (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void verifyTopDealsPage() throws InterruptedException {
			String expectedHomePageURL = "https://www.target.com/c/top-deals/-/N-4xw74?lnk=dNav_topdeals";
			String actualHomePageURL = driver.getCurrentUrl();
			Assert.assertEquals(actualHomePageURL, expectedHomePageURL);
			Thread.sleep(3000L);
		}
		
		public CreateAccountPage navigateToCreateAccountPage() throws InterruptedException {
			signInDropDownIcon.click();
			Thread.sleep(2000L);
			createAccount.click();
			return new CreateAccountPage(driver);
		}
		

}
