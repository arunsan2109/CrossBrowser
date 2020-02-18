package crossBrowserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import crossBrowserPage.VerifyTitlePage;
import crossBrowserUtility.Utility;
import junit.framework.Assert;

public class VerifyTitle {

	WebDriver driver;
	boolean actual;
	boolean expected = true;

	@BeforeTest
	@Parameters({"browser"})
	public void openBrowser(String browser){   
		driver = Utility.getBrowser(browser, "https://www.google.com");
	}

	@Test
	public void verifyTitle() {
		VerifyTitlePage loginPage = PageFactory.initElements(driver, VerifyTitlePage.class);
		Utility.getTestCaseName("VerifyTitleScenario");
		actual = loginPage.getLogin();
		Assert.assertEquals(expected, actual);
		driver.quit();
	}
	
	@AfterTest
	public void closeBrowser(){
		Utility.getCloseBrowser();
	}
}
