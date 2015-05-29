package com.citrix.gotomeeting.ui.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import com.citrix.gotomeeting.ui.pageobjects.LoginPage;
import com.citrix.gotomeeting.ui.pageobjects.ManageWebinarPage;
import com.citrix.gotomeeting.ui.pageobjects.MyWebinarPage;
import com.citrix.gotomeeting.ui.pageobjects.SchedulePage;
import com.citrix.gotomeeting.ui.resources.Language;
import com.citrix.gotomeeting.ui.resources.TimeZoneEnum;
import com.citrix.gotomeeting.ui.resources.WebinarType;

import junit.framework.TestCase;

/**
 * This is a Junit test class to test different tests related to creating Webinars
 * @author bhavna
 *
 */
public class test_CreateWebinar extends TestCase {
	//String username, password;
	LoginPage login;
	int daysFromNow;
	String startTime;
	String endTime;
	
	@BeforeClass
	public void setUpClass(){
	}
	
	@Before
	public void setUp(){
		login = new LoginPage();
		daysFromNow = 7;
		startTime="4:00";
		endTime="6:00";
	}
	/*
	
	@Test
	public void testLogin(){
		try{
			MyWebinarPage myWebinar = login.login();
			Assert.assertNotNull(myWebinar);
		}
		catch (Exception e){
			System.out.println("testLogin() failed " + e.getMessage());
		}
		
	}
	
	@Test
	public void testMyWebinar(){
		try{
			MyWebinarPage myWebinar = login.login();
			Assert.assertNotNull(myWebinar);
			SchedulePage schedule = myWebinar.scheduleWebinar();
			Assert.assertNotNull(schedule);
		}
		catch (Exception e){
			System.out.println("testMyWebinar() failed " + e.getMessage());
		}
		
	}
	*/
	
	/**
	 * Test to set up a webinar and verify its details
	 */
	@Test
	public void testMyWebinarSetUp(){
		try{
			MyWebinarPage myWebinar = login.login();
			Assert.assertNotNull(myWebinar);
			
			SchedulePage schedule = myWebinar.scheduleWebinar();
			Assert.assertNotNull(schedule); 
			
			ManageWebinarPage manageWebinar = schedule.setUpWebinar(WebinarType.ONESESSION, daysFromNow, startTime,endTime,TimeZoneEnum.EST, Language.ENGLISH);
			Assert.assertNotNull(manageWebinar);
			
			myWebinar = manageWebinar.gotoMyWebinar();
			Assert.assertNotNull(myWebinar);
			Assert.assertTrue(myWebinar.searchWebinar(manageWebinar.webinar));
		}
		catch (Exception e){
			System.out.println("testMyWebinarSetUp() failed " + e.getMessage());
		}
	}
	
	@After
	public void tearDown(){
		login.killDriver();
		login = null;
	}
	
	@AfterClass
	public void tearDownClass(){
		
	}
}
