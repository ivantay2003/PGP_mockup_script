package AndroidScenarios;

import org.testng.annotations.Test;

import Appium_Objects.selenoid;
import BrowserDriver.BrowserType;
import Configuration.Configuration;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class NavigateBottombar_Android_Emulator {

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
	   * Navigating Parent Gateway 
	   * 
	   * 1. Navigate at bottom menu - HOME / TO-DO /  CHILDREN / PROFILE and back to HOME
	   * 2. Find how many messages at Group message (should be 2)
	   * 3. Click on Welcome Message 
	   * 4. Scroll down
	   * 5. Back to Home
	   * 6. Navigate to people bottom menu
	   * 7. Navigate to Feedback and back to People
	   * 8. Navigate to Privacy Policy and back to People
	   * 9. Navigate to Terms and back to People
	   * 
	   */
	  
	  
	  /*
	   * Xpath
	   */
	  
	  String bottom_home_xpath = "//android.widget.TextView[@text='HOME']";
	  String bottom_todo_xpath = "//android.widget.TextView[@text='TO-DO']";
	  String bottom_children_xpath = "//android.widget.TextView[@text='CHILDREN']";
	  String bottom_people_xpath = "//android.widget.TextView[@text='PROFILE']";
	  
	  String viewtext_xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView";
	  String message_title_xpath = "//android.widget.TextView[@text='Welcome Onboard Parents Gateway']";

	  String people_feedback_xpath = "//android.widget.TextView[@text='Feedback']";
	  String people_privacy_xpath = "//android.widget.TextView[@text='Privacy Policy']";
	  String people_terms_xpath = "//android.widget.TextView[@text='Terms of Use']";
	  
	System.out.println("Navigate through the bottom menu");
	
	
	sel.clickElement(By.xpath(bottom_home_xpath));
	
	sel.clickElement(By.xpath(bottom_children_xpath));
	
	sel.clickElement(By.xpath(bottom_people_xpath));
	
	sel.clickElement(By.xpath(bottom_todo_xpath));
	
	sel.clickElement(By.xpath(bottom_home_xpath));
	
	List <AndroidElement> elems = sel.getElements(By.xpath(viewtext_xpath));
	
	System.out.println("Elements size : " + elems.size());
	
	for (int i = 0 ; i < elems.size() ; i ++ ){
		
		System.out.println("String " + i + " :" + elems.get(i).getText());
		
	}
	
	elems.get(1).click();
	
	sel.isPresence(By.xpath(message_title_xpath));
	sel.androidScrollDown(0, 0, 0, 200);
	sel.androidNavigateBack();
	
	//PEOPLE
	sel.clickElement(By.xpath(bottom_people_xpath));
	sel.clickElement(By.xpath(people_feedback_xpath));
	sel.androidNavigateBack();
	sel.clickElement(By.xpath(people_privacy_xpath));
	sel.androidNavigateBack();
	sel.clickElement(By.xpath(people_terms_xpath));
	sel.androidNavigateBack();
	
	  
	  
	  
	  
	  
  }
}
