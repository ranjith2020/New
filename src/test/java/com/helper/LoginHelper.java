package com.helper;

import org.openqa.selenium.WebElement;

public class LoginHelper {

	public static final String LOGIN_SCREEN = "LoginScreen";
	public static final String LOGIN_BUTTON ="LoginButton";
	public static final String USERNAME_FIELD = "UserNameField";
	public static final String PASSWORD_FIELD ="PasswordField";
	public static final String USERNAME_BUTTON = "UserNameButton";
	public static final String ALLOW_LOCATION_BUTTON ="AllowLocationButton";
	public static final String MYJOB_TITLE = "MyJobsGetTitle";
	public static final String ALWAYS_ALLOW_BUTTON = "AlwaysAllowButton";
	public static final String ALWAYS_ALLOW_NOTIFICATION ="AlwaysNotificationsButton";
	public static void clickLoginButton() {
	
		if(ElementHandler.isAndroid()) {
		ElementHandler.clickElement(LOGIN_SCREEN, LOGIN_BUTTON);
		} else {
			System.out.print("No Login Button");
		}
		
	}
	
	public static void doLogin() {
		
		ElementHandler.setText(LOGIN_SCREEN, USERNAME_FIELD, InputCredentials.ADMIN_USER_NAME);
		ElementHandler.setText(LOGIN_SCREEN, PASSWORD_FIELD, InputCredentials.ADMIN_PASSWORD);
		ElementHandler.clickElement(LOGIN_SCREEN, USERNAME_BUTTON);
		
	}
		
	public static void allowLocation() {
		if(ElementHandler.isAndroid()) {
		ElementHandler.clickElement(LOGIN_SCREEN, ALLOW_LOCATION_BUTTON);
		ElementHandler.checkDialog();
		} else {
			ElementHandler.clickElement(LOGIN_SCREEN, ALLOW_LOCATION_BUTTON);
			ElementHandler.checkDialog();
			ElementHandler.clickElement(LOGIN_SCREEN, ALWAYS_ALLOW_NOTIFICATION);
			ElementHandler.checkDialog();

			
			
		}
		
	}	
		
	
		
	public static void acceptAlert() {
		if(ElementHandler.isAndroid()) {
		ElementHandler.checkDialog();
		}else {
	      ElementHandler.clickElement(LOGIN_SCREEN, ALWAYS_ALLOW_BUTTON);
	      ElementHandler.clickElement(LOGIN_SCREEN, ALWAYS_ALLOW_NOTIFICATION);
		}
				
	}
   
	
	
	public static String getTitle(String Text) {
		
		if(ElementHandler.isAndroid()) {
		if(ElementHandler.isAndroidUIAutomatorPresent(Text)) {
			try {
				WebElement element = ElementHandler.getAndroidUIAutomator(Text);
				String title = element.getText();
				return title;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
		
	} else {
	     
		if (ElementHandler.isAccessibilityIdPresent(Text)){
			try {
				WebElement element1 = ElementHandler.getAccessibilityId(Text);
				String title1 = element1.getText();
				return title1;
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	
	}
		
		return"";
		
	}
	
	
	
}
	
	

