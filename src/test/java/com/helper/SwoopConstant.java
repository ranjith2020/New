package com.helper;

import com.helper.ElementHandler;

public class SwoopConstant {
//	public static final ElementHandler.Platform PLATFORM = ElementHandler.Platform.ANDROID;
	public static final ElementHandler.Platform PLATFORM = ElementHandler.Platform.IOS;
	
	public static final String PLATFORM_NAME_ANDROID = "Android";
	public static final String DEVICE_NAME_ANDROID ="Android SDK built for x86";
	public static final String PLATFORM_VERSION_ANDROID="7.0";
    public static final String URL_ANDROID ="http://127.0.0.1:4723/wd/hub";
    
    public static final String PLATFORM_NAME_IOS = "IOS";
	public static final String DEVICE_NAME_IOS ="iPhone 7";
	public static final String PLATFORM_VERSION_IOS="10.1";
    public static final String URL_IOS ="http://10.1.1.145:4723/wd/hub";

    public static final String JSON_FILE_PATH = "com/helper/document.json";
    public static final String JSON_ELEMENT_TYPE = "type";
    public static final String JSON_ELEMENT_PATH = "path";


    public static final String ID = "id";
    public static final String XPATH = "xpath";
    public static final String CLASS = "class";
    public static final String ACCESSIBILITY = "accessibilityId";
    public static final String ANDROIDUIAUTOMATOR = "androiduiautomator";
    		
}
