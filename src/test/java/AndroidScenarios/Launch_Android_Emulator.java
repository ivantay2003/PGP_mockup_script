package AndroidScenarios;

import org.testng.annotations.Test;

import Appium_Objects.selenoid;
import BrowserDriver.BrowserType;
import Configuration.Configuration;


import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class Launch_Android_Emulator {

	 //Configuration object
	private Configuration config;
	selenoid sel;
	
	
	public void setup (){
		config = new Configuration();
		
		  String media_path  = System.getProperty("user.dir")+ "/Desiredcap/";
		  System.out.println(media_path);
		  String androidfile = "gateway_emulator.json";
		  String jsonFile = media_path + androidfile;
		  
		  config.setBrowser(BrowserType.ANDROID,jsonFile);//Use Chrome driver
		  sel=config.getSelenoid();
	
		  
		  
	}
  @BeforeTest
  public void beforeTest() {
	  
	  setup();
  }

  @AfterTest
  public void afterTest() {
	  
	  //closeApp();
  }

  @Test
  public void start() {
	  /*
	   * Xpath
	   */
	  
	  String singpass_button_xpath = "//android.widget.TextView[@text='Log in with SingPass']";
	  String singpass_edittext_nric_xpath = "//android.widget.EditText[@resource-id='loginID']";
	  String singpass_edittext_password_xpath =  "//android.widget.EditText[@resource-id='password']";
	  String singpass_button_login_xpath = "//android.widget.Button[@content-desc='Cancel']/preceding-sibling::android.widget.Button";
	  String singpass_button_login_xpath1 = "//android.view.View[resource-id='login']/android.widget.Button[2]";
	  //MAIN MENU
	  System.out.println ("PGP");
	  sel.clickElement(By.xpath(singpass_button_xpath));
	  
	  sel.isPresence(By.xpath(singpass_button_login_xpath));
	  sel.sendKeysNoEnter(By.xpath(singpass_edittext_nric_xpath), "S12345678B");
	  sel.sendKeysNoEnter(By.xpath(singpass_edittext_password_xpath), "password");
	  sel.clickElement(By.xpath(singpass_button_login_xpath));
	

	  
	  
	  
	  
	  
	  
	  
  }
}
