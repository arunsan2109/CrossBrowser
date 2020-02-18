package crossBrowserPage;

import org.openqa.selenium.WebDriver;

public class VerifyTitlePage {

	WebDriver driver;

	public VerifyTitlePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean getLogin(){
		
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
