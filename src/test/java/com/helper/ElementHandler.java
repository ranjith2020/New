package com.helper;

	import static io.appium.java_client.touch.offset.PointOption.point;

import java.io.IOException;
	import java.text.ParseException;
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
	import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import com.handler.BaseDriver;
import com.helper.DataManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

	public class ElementHandler {
		
		public enum Platform{
			ANDROID, IOS
		}


		private static int SCROLL_VALUE_FOR_IOS;
		
		public static boolean isAndroid() {
			if (SwoopConstant.PLATFORM.equals(Platform.ANDROID)) {
				return true;
			}
			return false;
		}
		
		public static AppiumDriver<MobileElement> getDriver(){
			return BaseDriver.getDriver();
		}
		
		
		public static ArrayList<String> jsonParserElement(String ScreenName, String ElementName){
			ArrayList<String> PathType = new ArrayList<>();
			
			try {
				JSONObject jsonobject = new JSONObject(DataManager.getJsonElement());
				String type = jsonobject.getJSONObject(ScreenName)
						     .getJSONObject(ElementName)
						     .getJSONObject(ElementHandler.isAndroid()? SwoopConstant.PLATFORM_NAME_ANDROID:SwoopConstant.PLATFORM_NAME_IOS)
						     .getString(SwoopConstant.JSON_ELEMENT_TYPE);
				
				String path = jsonobject.getJSONObject(ScreenName)
						      .getJSONObject(ElementName)
						      .getJSONObject(ElementHandler.isAndroid()? SwoopConstant.PLATFORM_NAME_ANDROID:SwoopConstant.PLATFORM_NAME_IOS)
						      .getString(SwoopConstant.JSON_ELEMENT_PATH);
				
				PathType.add(type);
				PathType.add(path);
			} catch( JSONException|ParseException|IOException | org.json.simple.parser.ParseException e ) {
				e.printStackTrace();
			}
			
			return PathType;
		}
		
		
		public static boolean checkDialog() {
			try {
				if(isAndroid()) {
					WebDriverWait wait = new WebDriverWait(getDriver(),30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button"))).click();
				}else {
					WebDriverWait wait = new WebDriverWait(getDriver(), 30);
					wait.until(ExpectedConditions.alertIsPresent());
					Alert alert = getDriver().switchTo().alert();
					alert.accept();
				}
				return true;
				}catch(Exception e) {
                    e.printStackTrace();  
					return false;
					
				}
			
			
		}
		
		public static boolean isIdPresent(String Path) {
		
			WebElement element = null;
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Path)));
				return true;
			}catch(Exception e) {
				try {
					element = BaseDriver.getDriver().findElement(By.id(Path));
					return true;
				}catch(Exception e1) {
					if(checkDialog()) {
						isIdPresent(Path);
					}
				}
			}
			return false;
			
		}
		
		public static boolean isXpathPresent(String Path) {
			
			WebElement element = null;
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Path)));
				return true;
			}catch(Exception e) {
				try {
					element = BaseDriver.getDriver().findElement(By.xpath(Path));
					return true;
				}catch(Exception e1) {
					if(checkDialog()) {
						isXpathPresent(Path);
					}
				}
			}
			return false;
			
		}
        
		public static boolean isClassPresent(String Path) {
			
			WebElement element = null;
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Path)));
				return true;
			}catch(Exception e) {
				try {
					element = BaseDriver.getDriver().findElement(By.className(Path));
					return true;
				}catch(Exception e1) {
					if(checkDialog()) {
						isClassPresent(Path);
					}
				}
			}
			return false;
			
		}
		
		public static boolean isAccessibilityIdPresent(String name) {
			
			WebElement element = null;
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 40);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(name)));
				return true;
			}catch(Exception e) {
				try {
					element = BaseDriver.getDriver().findElement(MobileBy.AccessibilityId(name));
					return true;
				}catch(Exception e1) {
					if(checkDialog()) {
						isAccessibilityIdPresent(name);
					}
				}
			}
			return false;
			
		}
		
		
		public static boolean isAndroidUIAutomatorPresent(String name) {
			
			WebElement element = null;
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(name)));
				return true;
			}catch(Exception e) {
				try {
					element = BaseDriver.getDriver().findElement(MobileBy.AndroidUIAutomator(name));
					return true;
				}catch(Exception e1) {
					if(checkDialog()) {
						isAndroidUIAutomatorPresent(name);
					}
				}
			}
			return false;
			
		}
		
		public static WebElement getId(String path) {
		      WebElement element = null;
		      try {
		    	  WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		    	  element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
		    	  	    	  
		      }   catch(Exception e) {
		    	  try {
		    		  element = getDriver().findElement(By.id(path));
		    	  }catch(Exception e1) {
		    		  if(checkDialog()) {
		    			  getId(path);
		    		  }
		    	  }
		    	  return element;
		      }
			return element;
		}
		
		public static WebElement getClass(String path) {
		      WebElement element = null;
		      try {
		    	  WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		    	  element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(path)));
		    	  	    	  
		      }   catch(Exception e) {
		    	  try {
		    		  element = getDriver().findElement(By.className(path));
		    	  }catch(Exception e1) {
		    		  if(checkDialog()) {
		    			  getClass(path);
		    		  }
		    	  }
		    	  return element;
		      }
			return element;
		}
		
		
		public static WebElement getXpath(String path) {
		      WebElement element = null;
		      try {
		    	  WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		    	  element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		    	  	    	  
		      }   catch(Exception e) {
		    	  try {
		    		  element = getDriver().findElement(By.xpath(path));
		    	  }catch(Exception e1) {
		    		  if(checkDialog()) {
		    			  getXpath(path);
		    		  }
		    	  }
		    	  return element;
		      }
			return element;
		}

		public static WebElement getAccessibilityId(String path) {
		      WebElement element = null;
		      try {
		    	  WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		    	  element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(path)));
		    	  	    	  
		      }   catch(Exception e) {
		    	  try {
		    		  element = getDriver().findElement(MobileBy.AccessibilityId(path));
		    	  }catch(Exception e1) {
		    		  if(checkDialog()) {
		    			  getAccessibilityId(path);
		    		  }
		    	  }
		    	  return element;
		      }
			return element;
		}

		
		public static WebElement getAndroidUIAutomator(String path) {
		      WebElement element = null;
		      try {
		    	  WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		    	  element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(path)));
		    	  	    	  
		      }   catch(Exception e) {
		    	  try {
		    		  element = getDriver().findElement(MobileBy.AndroidUIAutomator(path));
		    	  }catch(Exception e1) {
		    		  if(checkDialog()) {
		    			  getAndroidUIAutomator(path);
		    		  }
		    	  }
		    	  return element;
		      }
			return element;
		}

		public static List<MobileElement> getIdS(String Path){
			List<MobileElement> elements = getDriver().findElements(By.id(Path));
			return elements;
		}
		
		public static List<MobileElement> getXpathS(String Path){
			List<MobileElement> elements = getDriver().findElements(By.xpath(Path));
			return elements;
		}
		
		public static List<MobileElement> getClassNameS(String Path){
			List<MobileElement> elements = getDriver().findElements(By.className(Path));
			return elements;
		}
		
		
		public static boolean isElementPresent(String ScreenName, String ElementName) {
			boolean element = false;
			ArrayList<String> typePath = jsonParserElement(ScreenName, ElementName);
			String path = typePath.get(1);
			System.out.print("element path" + path);
			System.out.print("element type" + typePath.get(0));
			switch(typePath.get(0)) {
			case(SwoopConstant.ID):
				element = isIdPresent(path);
			    break;
			case(SwoopConstant.XPATH):
				element = isXpathPresent(path);
			    break;
			case(SwoopConstant.CLASS):
				element = isClassPresent(path);
			    break;
			case(SwoopConstant.ACCESSIBILITY):
				element = isAccessibilityIdPresent(path);
			    break;
			case(SwoopConstant.ANDROIDUIAUTOMATOR):
				element = isAndroidUIAutomatorPresent(path);
				break;
			}
			
			return element;
			
		}
		
		
		public static WebElement getElement(String ScreenName, String ElementName) {
			WebElement element = null;
			ArrayList<String> typePath = jsonParserElement(ScreenName, ElementName);
			String path = typePath.get(1);
			System.out.print("path" + path);
			System.out.print("tYPE" + typePath.get(0));
			switch(typePath.get(0)) {
			case(SwoopConstant.ID):
				element = getId(path);
			    break;
			case(SwoopConstant.XPATH):
				element = getXpath(path);
			    break;
			case(SwoopConstant.CLASS):
				element = getClass(path);
			    break;
			case(SwoopConstant.ACCESSIBILITY):
				element = getAccessibilityId(path);
			    break;
			case(SwoopConstant.ANDROIDUIAUTOMATOR):
				element = getAndroidUIAutomator(path);
				break;
			}
			
			return element;
			
		}
		
		public static void clickElement(String ScreenName, String ElementName) {
			if(isElementPresent(ScreenName, ElementName)) {
				try {
					WebElement webelement = getElement(ScreenName, ElementName);
					webelement.click();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void setText(String ScreenName, String ElementName, String Value) {
			if(isAndroid()) {
				try {
					MobileElement element = (MobileElement)getElement(ScreenName, ElementName);
					element.click();
					element.clear();
					element.setValue(Value);
//					element.sendKeys(Value);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				try {
					MobileElement element = (MobileElement)getElement(ScreenName, ElementName);
					element.click();
					element.clear();
					element.sendKeys(Value);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		public static void refreshButton(){
			if(ElementHandler.isAndroid()) {
			   int startX;
			   int startY;
			   
			   Dimension size = ElementHandler.getDriver().manage().window().getSize();
			   System.out.print("Size "+ size);
			   startX= (int) (550);
			   startY= (int)(350);
			   
			   int endX = 650;
			   int endY = 1650;
			   
			   TouchAction touchaction = new TouchAction(ElementHandler.getDriver());
			   touchaction.press(point(startX, startY)).waitAction().moveTo(point(endX, endY)).release().perform();
			}else {
				
			}
			   
		   }

		
		
		public static void AndroidscrollTo(String value) {
			
				ElementHandler.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+value+"\").instance(0))"));

			}
			
		public static void iOSScrolldown() {
				
				List<MobileElement> elements = getDriver().findElementsByClassName("XCUIElementTypeOther");
				SCROLL_VALUE_FOR_IOS+=0;
				if(SCROLL_VALUE_FOR_IOS < elements.size())	{
					MobileElement element = (MobileElement) elements.get(SCROLL_VALUE_FOR_IOS);
					HashMap<String, String> tapobject = new HashMap<>();
					tapobject.put("direction", "down");
					tapobject.put("element", element.getId());
					getDriver().executeScript("mobile: scroll", tapobject);
					
									
				}	
			}
		
		
		public static void iOSScrolldUp() {
			
			List<MobileElement> elements = getDriver().findElementsByClassName("XCUIElementTypeOther");
			SCROLL_VALUE_FOR_IOS+=0;
			if(SCROLL_VALUE_FOR_IOS < elements.size())	{
				MobileElement element = (MobileElement) elements.get(SCROLL_VALUE_FOR_IOS);
				HashMap<String, String> tapobject = new HashMap<>();
				tapobject.put("direction", "up");
				tapobject.put("element", element.getId());
				getDriver().executeScript("mobile: scroll", tapobject);
				
								
			}	
		}

		
		public static void androidGoBack() {
			getDriver().navigate().back();
		}
		
		
		public static void iOSHideKeypad() {
			getDriver().hideKeyboard();
		}
	}



