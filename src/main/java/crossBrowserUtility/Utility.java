/**
* Utility class for re-usable functions
*
* @author  Arun Singh, Rahul Pandey, Shikha Arora 
*/

package crossBrowserUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/*
 * Utility class for re-usable functions
 */
public class Utility {

	static WebDriver driver;
	static String scenarioName;

	/*
	 * Constructor to initiate the driver
	 */
	public Utility(WebDriver driver) {
		Utility.driver = driver;
	}

	/*
	 * Function to initiate the browser Internet Explorer, Firefox, Chrome
	 */
	@SuppressWarnings("deprecation")
	public static WebDriver getBrowser(String browserName, String url) {

		try {
			if (browserName.equalsIgnoreCase("internetExplorer") || (browserName.equalsIgnoreCase("ie"))) {
				System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\IEDriverServer.exe");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				WebDriver driver = new InternetExplorerDriver(caps);
				driver.get(url);
				Thread.sleep(2000);
				return driver;
			} else if (browserName.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriverNew.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver(capabilities);
				driver.get(url);
				Thread.sleep(2000);
				return driver;

			} else

				System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			Thread.sleep(2000);
			return driver;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Scenario initiation
	 */
	public static void getTestCaseName(String scenarioNameUser) {
		try {
			scenarioName = scenarioNameUser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Quit the driver/instance
	 */
	public static void getCloseBrowser() {
		try {
			driver.quit();
			// Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
