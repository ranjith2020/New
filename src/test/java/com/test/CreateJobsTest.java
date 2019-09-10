package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.helper.CreateJobHelper;
import com.helper.InputCredentials;

public class CreateJobsTest {

	@Test(priority=1)
	
	public static void createJobs() throws Exception {
		CreateJobHelper.createJobs();
		Thread.sleep(3000);
		
		Assert.assertEquals("Pending", CreateJobHelper.getCreateJobTitleForPending());
		Assert.assertEquals("Moments ago", CreateJobHelper.getCreateJobTitleForPending());
		
		
	}
	
}
