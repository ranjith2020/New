package com.handler;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.helper.ElementHandler;
import com.helper.SwoopConstant;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;



/**
 * Connection for iOS and Android
 */
public class BaseDriver 
{
static AppiumDriver<MobileElement> driver;
	
	private BaseDriver() {
		
	}

 @BeforeTest

public static void setUp() throws MalformedURLException{
	if(ElementHandler.isAndroid()){
		setUpAndroidDriver();
	}else{
		setUpiOSDriver(); 
	}
	System.out.println("Appium is initialised");
}

public static void setUpAndroidDriver() throws MalformedURLException{
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, SwoopConstant.PLATFORM_NAME_ANDROID);
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, SwoopConstant.DEVICE_NAME_ANDROID);
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, SwoopConstant.PLATFORM_VERSION_ANDROID );
    capabilities.setCapability("automationName", "uiautomator2");

	capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
	capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
	capabilities.setCapability(MobileCapabilityType.APP, "D:\\swoop\\src\\main\\resources\\apps\\app-debug.apk");
	driver = new AndroidDriver<MobileElement>(new URL(SwoopConstant.URL_ANDROID), capabilities);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

public static void setUpiOSDriver() throws MalformedURLException{
	File app = new File("\\App\\Swoop.app");
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, SwoopConstant.PLATFORM_NAME_IOS);
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, SwoopConstant.PLATFORM_VERSION_IOS);
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, SwoopConstant.DEVICE_NAME_IOS); 
	capabilities.setCapability(MobileCapabilityType.APP, "/Users/Accel/Desktop/App/Swoop.app");
	capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
	capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	driver = new IOSDriver<MobileElement>(new URL(SwoopConstant.URL_IOS), capabilities);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

//@AfterTest
//
//public static void tearDown(){getDriver().quit();}

public static AppiumDriver<MobileElement> getDriver() {
	if(driver != null){
		return driver;
	}else{
		try{
			setUp();
		}catch(Exception e){
			System.out.println("Not initialised");
		}
	}
	return driver;	
	
}


		
	
	
}
	
	
	
	
	



