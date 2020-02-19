/**
* Verify Title Page with page logic functions
*
* @author  Arun Singh, Rahul Pandey, Shikha Arora 
*/

package crossBrowserPage;

import org.openqa.selenium.WebDriver;

public class VerifyTitlePage {

	WebDriver driver;

	/*
	 * Constructor to initiate the driver
	 */
	public VerifyTitlePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/*
	 * Function to check the title of web page and return boolean value
	 */
	public boolean getTitle(){
		
		try {
			driver.manage().window().maximize();
			if(driver.getTitle().equals("Google")){
				return true;
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
