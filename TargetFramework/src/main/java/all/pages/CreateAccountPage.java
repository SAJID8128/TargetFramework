package all.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	
WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/form[1]/div[9]/label[1]/div[1]")
	WebElement checkBox;
	
	
	// Constructor
	public CreateAccountPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signUpFormFillUp() throws InterruptedException {
		emailAddress.sendKeys("nyla@gmail.com");
		Thread.sleep(1000L);
		firstName.sendKeys("Nyla");
		Thread.sleep(1000L);
		lastName.sendKeys("Huda");
		Thread.sleep(1000L);
		mobileNumber.sendKeys("1234567890");
		Thread.sleep(1000L);
		password.sendKeys("987654321");
		Thread.sleep(1000L);
		checkBox.click();
		Thread.sleep(1000L);
	}



}
