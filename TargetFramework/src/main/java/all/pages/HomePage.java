package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class HomePage {

	WebDriver driver;

	@FindBy(xpath="//span[@class='sc-gsTCUz iJmNUG']")
	WebElement logo; 

	@FindBy(xpath="//a[@id='secondary']")
	WebElement deals;

	@FindBy(xpath="//div[@class='Row-uds8za-0 glDPjN'][contains(text(),'Top Deals')]")
	WebElement topDeals;


	// Constructor
	public HomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyHomePage() {
		String expectedHomePageURL = "https://www.target.com/";
		String actualHomePageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualHomePageURL, expectedHomePageURL);				
	}

	public void verifyLogo() {
		Assert.assertTrue(logo.isDisplayed());
	}

	public TopDeals clickOnTopDealsSection() throws InterruptedException {
		deals.click();
		Thread.sleep(2000L);
		topDeals.click();
		return new TopDeals(driver);// Creates a new class called 'TopDeals'.
	}

}
