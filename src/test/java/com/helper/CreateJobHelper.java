package com.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.handler.BaseDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;



public class CreateJobHelper {
	
	public static final String NAVIGATE_CREATE_JOB_ID = "android.widget.TextView";
	public static final String NAVIGATE_IOS_CREATE_JOB_ID ="XCUIElementTypeStaticText";
	public static final String CREATE_JOB ="CreateJobScreen";
    public static final String NAVIGATE_CREATE_JOB="NavigateCreateJob";
	public static final String IOS_PAYMENT_TYPE = "PaymentType";
	public static final String IOS_ACCOUNT = "Account";
	public static final String IOS_ACCOUNT_SEARCH = "AccountSearch";
	public static final String IOS_ACCOUNT_TYPE = "XCUIElementTypeOther";
	public static final String IOS_CUSTOMER_NAME = "CustomerName";
	public static final String IOS_CUSTOMER_PHONE = "CustomerPhone";
	public static final String IOS_SERVICE = "Service";
	public static final String IOS_PICKUP_LOCATION ="PickupLocation";
	public static final String IOS_PICKUP_LOCATION_TEXTBOX ="PickupLocationTextBox";
	public static final String IOS_DROPOFF_LOCATION= "DropoffLocation";
	public static final String IOS_DROPOFF_LOCATION_TEXTBOX ="DropoffLocationTextBox";
	public static final String IOS_DROPOFF_LOCATION_TYPE="DropoffLocationType";
	public static final String IOS_CREATE_BUTTON="CreateButton";
	
	public static final String ANDROID_NAVIGATE_CREATE_JOB ="NavigateCreateJob";
	public static final String CREATE_JOB_TITLE = "CreateJobTitle";
	public static final String NAVIGATE_DISPATCH ="NavigateDispatch";
	
	
		
	
	public static void navigateToCreateJob() {
		
		if(ElementHandler.isAndroid()) {
			ElementHandler.isElementPresent(CREATE_JOB, ANDROID_NAVIGATE_CREATE_JOB);
			ElementHandler.clickElement(CREATE_JOB, ANDROID_NAVIGATE_CREATE_JOB);
			
		}else {
		
		if(ElementHandler.isElementPresent(CREATE_JOB, NAVIGATE_CREATE_JOB)) {
			ElementHandler.clickElement(CREATE_JOB, NAVIGATE_CREATE_JOB);
		}
		
		}
	}
	
	public static void selectAccount(String value) {
		if(ElementHandler.isAndroid()){
			ElementHandler.clickElement(CREATE_JOB, IOS_ACCOUNT);
			if(ElementHandler.isAndroidUIAutomatorPresent(value)) {
				WebElement element = ElementHandler.getAndroidUIAutomator(value);
				element.click(); 
			}
		}else {
		ElementHandler.clickElement(CREATE_JOB, IOS_ACCOUNT);
//		ElementHandler.setText(CREATE_JOB, IOS_ACCOUNT_SEARCH, value);
	    if(ElementHandler.isAccessibilityIdPresent(value)) {
	    	WebElement element = ElementHandler.getAccessibilityId(value);
	    	element.click();
//	    	List<MobileElement> element1 = ElementHandler.getClassNameS(IOS_ACCOUNT_TYPE)	;
//			System.out.print("Elements" + element1.size());
//			element1.get(2).click();
	    	 }else {
	    		 System.out.print("No element");
	    	 }
	    
		}
	}
	
	public static void setCustomerName() throws org.openqa.selenium.InvalidElementStateException  {
		
		if(ElementHandler.isAndroid()) {
			ElementHandler.setText(CREATE_JOB, IOS_CUSTOMER_NAME, InputCredentials.ANDROID_CUSTOMER_NAME);
		}
		else {
		ElementHandler.setText(CREATE_JOB,IOS_CUSTOMER_NAME , InputCredentials.CUSTOMER_NAME);
		}
		
		
	}
	
		
	public static void setCustomerPhone(String Value) {
		ElementHandler.setText(CREATE_JOB,IOS_CUSTOMER_PHONE, Value);
	}
	
	public static void setService(String value) {
		
		if(ElementHandler.isAndroid()) {
			 List<MobileElement> element =  ElementHandler.getDriver().findElements(MobileBy.AndroidUIAutomator("text(\"Service\")"));
			 System.out.print("Service" + element.size());
			 element.get(1).click();
			 if(ElementHandler.isAndroidUIAutomatorPresent(value)) {
					WebElement element1 = ElementHandler.getAndroidUIAutomator(value);
					element1.click(); 
		}
		}	 
			 else {
		
		ElementHandler.clickElement(CREATE_JOB,IOS_SERVICE);
		if(ElementHandler.isAccessibilityIdPresent(value)) {
	    	WebElement element2 = ElementHandler.getAccessibilityId(value);
	    	element2.click();
	}
		
		}
	}
	
	public static void setPickupLocation(String value) throws Exception {
        if(ElementHandler.isAndroid()) {
		 List<MobileElement> element =  ElementHandler.getDriver().findElements(MobileBy.AndroidUIAutomator("text(\"Pickup Location\")"));
		 
		 System.out.print("Service" + element.size());
		 element.get(1).click();
		
		ElementHandler.setText(CREATE_JOB, IOS_PICKUP_LOCATION_TEXTBOX, value);
        }else {
        	
        	ElementHandler.clickElement(CREATE_JOB, IOS_PICKUP_LOCATION );
        	ElementHandler.setText(CREATE_JOB, IOS_PICKUP_LOCATION_TEXTBOX, value);
               	
        	 BaseDriver.getDriver().findElement(MobileBy.AccessibilityId("return")).click();
//           List<MobileElement> element= BaseDriver.getDriver().findElementsByAccessibilityId("California, USA");
//           System.out.print("Pickup"+ element.size());
//           element.c
//        	 
//         	WebElement  element = BaseDriver.getDriver().findElementByXPath("//XCUIElementTypeOther[@text='"+value+"')]");
//         	element.click();
//     
//        	WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
//			WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[contains(text(), '2415 Octavia Street')]")));
//			element.click();
//        	
//	  List<MobileElement> element1 = ElementHandler.getClassNameS(IOS_ACCOUNT_TYPE)	;
//		System.out.print("Elements" + element1.size());
//		element1.get(3).click();
//	  if(ElementHandler.isAccessibilityIdPresent(value)) {
//	  WebElement element = ElementHandler.getAccessibilityId(value);
//	  element.click();
//		}
        }
		}
	
	
	public static void selectPickupOrDropOffLocation(String Navigation) {
		if(ElementHandler.isAndroid()) {
			if(ElementHandler.isAndroidUIAutomatorPresent(Navigation)) {
				WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(Navigation)));
			    element.click(); 
			}
			
			
		}else {
		
		if(ElementHandler.isAccessibilityIdPresent(Navigation)) {
			WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(Navigation)));
			element.click();
		}
		}
	}
	
	public static void selectIOSPickupLocation1(String Navigation) {
		if(ElementHandler.isXpathPresent(Navigation)) {
			WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
			WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Navigation)));
			element.click();
		}
	}
	
	public static void setDropOffLocation(String value) throws Exception {
		if(ElementHandler.isAndroid()) {
		
		 List<MobileElement> element =  ElementHandler.getDriver().findElements(MobileBy.AndroidUIAutomator("text(\"Dropoff Location\")"));
		 
		 System.out.print("Service" + element.size());
		 element.get(1).click();
		 ElementHandler.setText(CREATE_JOB, IOS_DROPOFF_LOCATION_TEXTBOX,value );

		}
		else {
		
		
	 ElementHandler.clickElement(CREATE_JOB, IOS_DROPOFF_LOCATION );
	 ElementHandler.setText(CREATE_JOB, IOS_DROPOFF_LOCATION_TEXTBOX,value );
	 
	 BaseDriver.getDriver().findElement(MobileBy.AccessibilityId("return")).click();

//	 List<MobileElement> element =  ElementHandler.getDriver().findElements(MobileBy.AccessibilityId(value));
//	 
//	 System.out.print("DropOff" + element.size());
//	 element.get(1).click();
	 
//	 if(ElementHandler.isAccessibilityIdPresent(value)) {
//	 WebElement element = ElementHandler.getAccessibilityId(value);
//	 element.click();
//			}	
		}

}

	public static void navigateToDispatch(String Value) {
		if(ElementHandler.isAndroidUIAutomatorPresent(Value)) {
			ElementHandler.clickElement(CREATE_JOB, NAVIGATE_DISPATCH);
		}
	}
	
	
	public static void setDropOffLocationType(String value) {
		
		if(ElementHandler.isAndroid()) {
			ElementHandler.clickElement(CREATE_JOB, IOS_DROPOFF_LOCATION_TYPE );
			if(ElementHandler.isAndroidUIAutomatorPresent(value)) {
				WebElement element = ElementHandler.getAndroidUIAutomator(value);
				element.click();
			}
		}
		else {
		
		 ElementHandler.clickElement(CREATE_JOB, IOS_DROPOFF_LOCATION_TYPE );
//		 ElementHandler.setText(CREATE_JOB, IOS_DROPOFF_LOCATION, value);
		 if(ElementHandler.isAccessibilityIdPresent(value)) {
		 WebElement element = ElementHandler.getAccessibilityId(value);
		 element.click();
				}		
		}
	}
	
	public static void ScrollTo(String value) {
	    ElementHandler.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+value+"\").instance(0))"));

	}
	
	public static void closeiOSNumerickeypad() {
		WebElement element =ElementHandler.getDriver().findElement(MobileBy.AccessibilityId("Customer"));
		element.click();
	}
	
	
	public static void clickCreateButton() {
		ElementHandler.clickElement(CREATE_JOB, IOS_CREATE_BUTTON);
	}
	
	
	public static String getCreateJobTitleForPending() {
		if(ElementHandler.isAndroid()) {
			try {
		WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Pending\")")));
		String text = title.getText();
		System.out.print("JobTitle" + text);
		return text;

			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
				WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Pending")));
				String text = title.getText();
				System.out.print("JobTitlestatus" + text);
				return text;

		}catch(Exception e) {
			e.printStackTrace();}
		}
		return"";

	}
	

	
	public static String getCreateJobTitleForMoments() {
		if(ElementHandler.isAndroid()) {
			try {
		WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Moments ago\")")));
		String text = title.getText();
		System.out.print("JobTitle" + text);
		return text;

			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				WebDriverWait wait = new WebDriverWait(ElementHandler.getDriver(), 30);
				WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Moments ago")));
				String text = title.getText();
				System.out.print("JobTitlestatus" + text);
				return text;

		}catch(Exception e) {
			e.printStackTrace();}
		}
		return"";

	}

	
	
	
	public static void createJobs() throws Exception {
		
		if(ElementHandler.isAndroid()) {
		CreateJobHelper.navigateToCreateJob();
		CreateJobHelper.selectAccount(InputCredentials.ANDROID_ACCOUNT);
		Thread.sleep(5000);
		setCustomerName();
		ElementHandler.androidGoBack();
		setCustomerPhone(InputCredentials.ANDROID_CUSTOMER_PHONE);
		ElementHandler.androidGoBack();
		setService(InputCredentials.ANDROID_SERVICE);
		ScrollTo(InputCredentials.SCROLL_PICKUP_LOCATION);
		setPickupLocation(InputCredentials.ANDROID_PICKUP_LOCATION);
		selectPickupOrDropOffLocation(InputCredentials.ANDROID_PICKUP_LOCATION_TEXT);
		ScrollTo(InputCredentials.SCROLL_VEHICLE);

		setDropOffLocation(InputCredentials.ANDROID_DROPOFF_LOCATION);
		selectPickupOrDropOffLocation(InputCredentials.ANDROID_DROPOFF_LOCATION_TEXT);
		setDropOffLocationType(InputCredentials.ANDROID_DROPOFF_LOCATION_TYPE);
		clickCreateButton();
		navigateToDispatch(InputCredentials.NAVIGATE_DISPATCH);
		Thread.sleep(10000);
		ElementHandler.refreshButton();
		
		
		}
		else {
				
		CreateJobHelper.navigateToCreateJob();
		CreateJobHelper.selectAccount(InputCredentials.ACCOUNT);
		setCustomerName();
		setCustomerPhone(InputCredentials.CUSTOMER_PHONE);
		closeiOSNumerickeypad();
		setService(InputCredentials.SERVICE);
		ElementHandler.iOSScrolldown();

			
		setPickupLocation(InputCredentials.PICKUP_LOCATION);
		selectPickupOrDropOffLocation(InputCredentials.PICKUP_LOCATION_TEXT);
		setDropOffLocation(InputCredentials.DROPOFF_LOCATION);
		selectPickupOrDropOffLocation(InputCredentials.DROPOFF_LOCATION_TEXT);
		setDropOffLocationType(InputCredentials.DROPOFF_LOCATION_TYPE);
		clickCreateButton();
		Thread.sleep(10000);
	    ElementHandler.iOSScrolldUp();
		}
		}
	
		
}