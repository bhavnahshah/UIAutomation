package com.citrix.gotomeeting.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.citrix.gotomeeting.ui.common.Assertions;
import com.citrix.gotomeeting.ui.common.DateUtil;
import com.citrix.gotomeeting.ui.common.Page;
import com.citrix.gotomeeting.ui.common.PropertiesUtil;
import com.citrix.gotomeeting.ui.resources.Language;
import com.citrix.gotomeeting.ui.resources.TimeZoneEnum;
import com.citrix.gotomeeting.ui.resources.Webinar;
import com.citrix.gotomeeting.ui.resources.WebinarType;

/**
 * This class defines the Page Object for the Schedule Webinar Page
 * @author bhavna
 */
public class SchedulePage extends Page{
	private WebDriver webdriver;
	private String strTitle;
	public Webinar webinar = null;
	PropertiesUtil props = new PropertiesUtil();
	
	public SchedulePage(WebDriver webdriver){
		this.webdriver = webdriver; 
	}
	
	/**
	 * This method is used to set up a webinar
	 * @return ManageWebinarPage
	 * @param sessionType - One Session, Series, Occurence
	 * @param daysFromNow - Number of days from today
	 * @param startTime - Start time of the webinar
	 * @param endTime - End time of the webinar
	 * @param timeZone - Timezone of the webinar
	 * @param language - Language of the webinar
	 */
	public ManageWebinarPage setUpWebinar(WebinarType sessionType, int daysFromNow, String startTime, String endTime , TimeZoneEnum timeZone, Language language){
		try{
			
			Assertions.waitForElement(webdriver, props.getProperty("Schedule_Description"), 4000);
			strTitle = props.getProperty("Webinar_Name") + Math.random();
			webdriver.findElement(By.id(props.getProperty("Schedule_Title"))).sendKeys(strTitle);
			webdriver.findElement(By.cssSelector(props.getProperty("Schedule_Description"))).sendKeys(props.getProperty("Webinar_Desciption"));
			scheduleOneSession(webdriver, daysFromNow, startTime, endTime, timeZone, language);
			/**
			 *  - Supports One Session. Can be extended to support series and sequence to implement Occurs and End Date
			 */
			if(sessionType.getType().equalsIgnoreCase("Series") || sessionType.getType().equalsIgnoreCase("Sequence")){
			}
			Assertions.waitForElement(webdriver, props.getProperty("Schedule_Webinar"), 4000);
			webdriver.findElement(By.cssSelector(props.getProperty("Schedule_Webinar"))).click();
			return new ManageWebinarPage(webdriver , webinar);
		}
		catch(Exception e){
			System.out.println("Webinar Set Up failed:" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * This method is used to clear the values of start and end time input fields
	 * @param webelement - Webelement of start time or end time
	 */
	public void clearTime(WebElement webelement){
		webelement.click();
		webelement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		webelement.sendKeys(Keys.DELETE);
		webelement.sendKeys(Keys.BACK_SPACE);
		webelement.sendKeys(Keys.BACK_SPACE);
		webelement.sendKeys(Keys.BACK_SPACE);
		webelement.sendKeys(Keys.BACK_SPACE);
	}
	
	/**
	 * This method is used to schedule a single webinar session
	 * @param webdriver
	 * @param daysFromNow
	 * @param startTime
	 * @param endTime
	 * @param timeZone
	 * @param language
	 */
	private void scheduleOneSession(WebDriver webdriver, int daysFromNow, String startTime, String endTime , TimeZoneEnum timeZone, Language language) {
		try{
			Assertions.waitForElement(webdriver, props.getProperty("Schedule_Start_Date"), 4000);
			WebElement startDate = webdriver.findElement(By.id(props.getProperty("Schedule_Start_Date")));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) webdriver;
			jsExecutor.executeScript("window.scrollTo(0,"+startDate.getLocation().y+")");
			startDate.click();
			Assertions.waitForElement(webdriver, props.getProperty("Schedule_UploadRecording"), 5000);
			DateUtil date = new DateUtil();
			int dateDifference = date.computeDateDifference(daysFromNow);
			
			for(int i=0;i<dateDifference ; i++){
				webdriver.findElement(By.cssSelector(props.getProperty("Schedule_Month_next"))).click();
			}
			
			webdriver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[contains(text(),'"+date.getNewDay(daysFromNow)+"')]")).click();
			Assertions.waitForElement(webdriver, props.getProperty("Schedule_Start_Time"), 4000);
			WebElement webStartTime = webdriver.findElement(By.cssSelector(props.getProperty("Schedule_Start_Time")));
			clearTime(webStartTime);
			webStartTime.sendKeys(startTime);
			webdriver.findElement(By.id(props.getProperty("Schedule_StartTime_AMPM"))).click();
			webdriver.findElement(By.cssSelector(props.getProperty("Schedule_StartTime_AMPM_select"))).click();
			WebElement webEndTime = webdriver.findElement(By.cssSelector(props.getProperty("Schedule_End_Time")));
			clearTime(webEndTime);
			webEndTime.sendKeys(endTime);
			webdriver.findElement(By.id(props.getProperty("Schedule_EndTime_AMPM"))).click();
			webdriver.findElement(By.cssSelector(props.getProperty("Schedule_EndTime_AMPM_select"))).click();
			WebElement webTimeZone = webdriver.findElement(By.cssSelector(props.getProperty("MyWebinar_timezone")));
			webTimeZone.click();
			webTimeZone.findElement(By.xpath("//li[contains(text(),'"+ timeZone.getTimezone()+"')]")).click();
			WebElement webLanguage = webdriver.findElement(By.cssSelector(props.getProperty("MyWebinar_language")));
			webLanguage.click();
			webLanguage.findElement(By.xpath("//li[contains(text(),'"+ language.getLanguage()+"')]")).click();
			webinar = new Webinar.WebinarBuilder(strTitle,props.getProperty("Webinar_Desciption"),date.getDisplayDate(daysFromNow),startTime,"AM",endTime, "AM",date.getDateDaylightTimezone(daysFromNow, timeZone),language).build();
		}
		catch (Exception e){
			System.out.println("Session schedule failed:" + e.getMessage());
		}
	}

}
