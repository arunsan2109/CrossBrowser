/**
* Verify Title class with TestNG Annotations for Assert
*
* @author  Arun Singh, Rahul Pandey, Shikha Arora 
*/

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

	/*
	 * TestNG Annotations @BeforeTest and @Parameters
	 */
	@BeforeTest
	@Parameters({"browser"})
	public void openBrowser(String browser){   
		driver = Utility.getBrowser(browser, "https://www.google.com");
	}

	/*
	 * TestNG Annotations @Test to Assert the title and check return boolean value
	 */
	@Test
	public void verifyTitle() {
		VerifyTitlePage loginPage = PageFactory.initElements(driver, VerifyTitlePage.class);
		Utility.getTestCaseName("VerifyTitleScenario");
		actual = loginPage.getTitle();
		Assert.assertEquals(expected, actual);
		driver.quit();
	}
	
	/*
	 * TestNG Annotations @AfterTest to close the browser
	 */
	@AfterTest
	public void closeBrowser(){
		Utility.getCloseBrowser();
	}
}
