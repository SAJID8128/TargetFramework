package web.pages.execution;

import org.testng.annotations.Test;

import all.pages.CreateAccountPage;
import all.pages.HomePage;
import all.pages.TopDeals;
import browser.setup.BaseClass;



public class TargetPagesExecution extends BaseClass {
	
	@Test
	public void targetaAllPagesExecution() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.verifyLogo();
		//driver.navigate().back();-----This line navigates you back to Homepage
		
		
		TopDeals topDeals = homePage.clickOnTopDealsSection();
		topDeals.verifyTopDealsPage();
		
		CreateAccountPage createAccountPage = topDeals.navigateToCreateAccountPage();
		createAccountPage.signUpFormFillUp();
		
	}


}
