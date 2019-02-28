/*
 * 	Copyright (c) 2018 Ivan Tay 
 *  Configuration
 *  For basic project configurations
 *  CHANGE HERE IN THE DIFFERENT PROPERTIES TO GET YOUR PROJECT WORKING
 * 
 */

package Configuration;

import org.openqa.selenium.JavascriptExecutor;

//import Data.ExcelExtractionManager; //Extract data from excel

import org.openqa.selenium.WebDriver;

import Appium_Objects.DriverType;
import Appium_Objects.selenoid;
import BrowserDriver.BrowserType;
import BrowserDriver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;



public class Configuration {

	/*
	 * CHANGE HERE
	 */
	private static int PAGE_SCROLL_DOWN = 800;  // ADJUST THIS FOR SCROLLING - DEPENDS ON DIFFERENT RESOLUTION
	private static String chromeRelativePath = "//WebDrivers//chrome//mac//chromedriver"; //Adjust this for chrome path driver
	private static String geckoRelativePath = "//WebDrivers//gecko//mac//geckodriver"; //Adjust this for firefox path driver
	
	public static int ANDROID_VISITPROFILE_SCROLL = 500; //ADJUST THIS FOR SCROLLING IN ANDROID EMULATOR OR REAL
	
	
	//BaseWebDriver driver;
	private DriverManager driverManager;
	private static AppiumDriver<AndroidElement> androidDriver;
	private static IOSDriver <IOSElement> iosDriver; 
//	private static JavascriptExecutor js;
	private selenoid sel = new selenoid ();


	

	
	private String getUserHome (){
		/*
		 * User home 
		 */
		
		return System.getProperty("user.home");
	}
	
	
	private String getUserDataPath(){
		/*
		 * Excel data file path
		 */
		return System.getProperty("user.dir") + "/UserData/";
	}
	
	public String getScreenCapturePath (){
		/*
		 * Screen capture jpg path 
		 * 
		 */
		
		return System.getProperty("user.dir") + "/ScreenCapture/";
		
	}
	
	
	
	public void setBrowser (BrowserType browserType, String jsonFile){
		/*
		 * Select a webdriver. Only implement Chrome and Firefox
		 * 
		 */
		

		
		switch (browserType) {
        case CHROME:
  		  	driverManager = new DriverManager (getUserHome() + chromeRelativePath);
  		  	driverManager.getManager(BrowserType.CHROME);
            break;
        case FIREFOX:
  		  	driverManager = new DriverManager (getUserHome() + geckoRelativePath);
  		  	driverManager.getManager(BrowserType.FIREFOX);
            break;
        case ANDROID:
        	androidDriver =  (AppiumDriver<AndroidElement>) sel.desiredCapabilitiesConfig(jsonFile, DriverType.Android_Native);
        	break;
        case IOS:
        	iosDriver =  (IOSDriver <IOSElement>) sel.desiredCapabilitiesConfig(jsonFile, DriverType.iOS_Native);
        	break;
        default:
  		  	driverManager = new DriverManager (getUserHome() + chromeRelativePath);
  		  	driverManager.getManager(BrowserType.CHROME);
            break;
		}
	}
	
	public WebDriver getWebDriver (){
		/*
		 * Get webdriver which has been set. etc setChromeDriver() need to be called first
		 * 
		 */
		
		return driverManager.getDriver();
		
	}
	
	public AppiumDriver<AndroidElement> getAndroidDriver(){
		/*
		 * 
		 * Get Android driver which has been set
		 */
		return androidDriver;
		
	}
	
	public IOSDriver <IOSElement> getiOSDriver(){
		/*
		 * 
		 * Get Android driver which has been set
		 */
		return iosDriver;
		
	}
	
	public selenoid getSelenoid(){
		
		return sel;
	}
	


	
	public int getScrollPixel (){
		/*
		 * Number of pixels to scroll down.  Change this according to your screen resolution
		 * 
		 */
		return PAGE_SCROLL_DOWN;
	}
	
	

}
