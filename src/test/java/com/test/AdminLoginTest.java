package com.test;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.helper.CreateJobHelper;
import com.helper.ElementHandler;
import com.helper.InputCredentials;
import com.helper.LoginHelper;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;





public class AdminLoginTest {
	
	@Test(priority=1)
	
	public void navigateToDashBoard() throws InterruptedException {
		
		Thread.sleep(1000);
	LoginHelper.clickLoginButton();
	LoginHelper.doLogin();
	LoginHelper.allowLocation();
	String JobTitle = LoginHelper.getTitle(InputCredentials.IOS_TITLE);
	System.out.print("JobTitle" + JobTitle);
	Assert.assertEquals(JobTitle, "Dispatch");
	

	}
	

  
	
}
