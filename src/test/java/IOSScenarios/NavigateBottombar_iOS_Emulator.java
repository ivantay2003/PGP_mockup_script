package IOSScenarios;

import org.testng.annotations.Test;

import Appium_Objects.selenoid;
import BrowserDriver.BrowserType;
import Configuration.Configuration;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class NavigateBottombar_iOS_Emulator {

	 //Configuration object
	private Configuration config;
	selenoid sel;
	
	
	public void setup (){
		config = new Configuration();
		
		  String media_path  = System.getProperty("user.dir")+ "/Desiredcap/";
		  System.out.println(media_path);
		  String iOSfile = "gateway_iOS_real.json";
		  String jsonFile = media_path + iOSfile;
		  
		  config.setBrowser(BrowserType.IOS,jsonFile);//Use Chrome driver
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
	  
	
	  String bottom_home_xpath = "//XCUIElementTypeButton[@name='HOME']";
	  String bottom_todo_xpath = "//XCUIElementTypeButton[@name='TO-DO']";
	  String bottom_children_xpath = "//XCUIElementTypeButton[@name='CHILDREN']";
	  String bottom_people_xpath = "//XCUIElementTypeButton[@name='PROFILE']";
	  
	  //String viewtext_xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView";
	  //String message_title_xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
	  String message_title_xpath = "//XCUIElementTypeOther[contains(@name,'Welcome Onboard Parents Gateway')]";
	  String message_back_xpath = "//XCUIElementTypeOther[contains(@name,'Welcome Onboard Parents Gateway')]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
	  //String message_title_xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther";
	  String people_feedback_xpath = "//XCUIElementTypeOther[@name='Feedback ›']";
	  String people_privacy_xpath = "//XCUIElementTypeOther[@name='Privacy Policy ›']";
	  String people_terms_xpath = "//XCUIElementTypeOther[@name='Terms of Use ›']";
	  
	  String people_feedback_back_xpath = "(//XCUIElementTypeOther[@name='Got Feedback? Email us at moe_parents_gateway@moe.gov.sg'])[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther";
	  //String people_privacy_back_xpath = "(//XCUIElementTypeOther[@name='Privacy Statement 1. This is a mobile application owned and operated by the Government of the Republic of Singapore represented by the Ministry of Education. 2. We may track information about you when you use this mobile application, such as the frequency of use. However, we will not read data off your mobile device. 3. If you provide us with personally identifiable data We may share necessary data with other Government agencies, so as to serve you in the most efficient and effective way unless such sharing is prohibited by law. We will NOT share your personal data with non-Government entities, except where such entities have been authorised to carry out specific Government services or where such entities are the legal owners of any school in which your child is enrolled. For your convenience, we may also display to you data you had previously supplied us or other Government Agencies. This will speed up the transaction and save you the trouble of repeating previous submissions. Should the data be out-of-date, please supply us the latest data. 4. To safeguard your personal data, all electronic storage and transmission of personal data is secured with appropriate security technologies. 5. This mobile application may contain links to non-Government sites whose data protection and privacy practices may differ from ours. We are not responsible for the content and privacy practices of these other websites and encourage you to consult the privacy notices of those sites. 6. Please contact us using the feedback form (a) For any enquires or feedback on our data protection policies and procedures (b) If you need more information on or access to data which you have provided to us in the past. Done'])[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther";
	  String people_privacy_back_xpath = "//XCUIElementTypeOther[contains (@name,'Privacy Statement')]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
	  String people_terms_back_xpath = "//XCUIElementTypeOther[contains (@name,'Terms of Use')]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
	  
	  sel.clickElement(By.xpath(bottom_home_xpath));
		
	  sel.clickElement(By.xpath(bottom_children_xpath));
		
	  sel.clickElement(By.xpath(bottom_people_xpath));
		
	  sel.clickElement(By.xpath(bottom_todo_xpath));
		
	  sel.clickElement(By.xpath(bottom_home_xpath));
	  
	  sel.clickElement(By.xpath(message_title_xpath));
	  
	  sel.isPresence(By.xpath(message_title_xpath));
	  sel.iOSScrollDown(0, 100, 0, -700);
	  
	  sel.clickElement(By.xpath(message_back_xpath));
	 
	  
	  
	  //PEOPLE
	  sel.clickElement(By.xpath(bottom_people_xpath));
	  sel.clickElement(By.xpath(people_feedback_xpath));
	  sel.clickElement(By.xpath(people_feedback_back_xpath));
//	  //sel.iOSNavigateBack();
	  sel.clickElement(By.xpath(people_privacy_xpath));
	  sel.clickElement(By.xpath(people_privacy_back_xpath));
//	  //sel.iOSNavigateBack();
	  sel.clickElement(By.xpath(people_terms_xpath));
	  sel.clickElement(By.xpath(people_terms_back_xpath));
	  	  
//	  sel.iOSNavigateBack();
//	  
  }
}
