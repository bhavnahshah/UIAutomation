package com.citrix.gotomeeting.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.citrix.gotomeeting.ui.common.Assertions;
import com.citrix.gotomeeting.ui.common.Page;
import com.citrix.gotomeeting.ui.common.PropertiesUtil;
import com.citrix.gotomeeting.ui.resources.Webinar;
/**
 * This class is the Page Object for the My Webinar Page
 * @author bhavna
 *
 */
public class MyWebinarPage extends Page{

	private WebDriver webdriver;
	PropertiesUtil props = new PropertiesUtil();
	
	public MyWebinarPage(WebDriver webdriver){
		this.webdriver = webdriver;
	}
	
	/**
	 * This method directs the user to the schedule webinar page
	 * @return SchedulePage
	 */
	public SchedulePage scheduleWebinar(){
		try{
			Assertions.waitForElement(webdriver, props.getProperty("Schedule_Button"), 4000);
			webdriver.findElement(By.cssSelector(props.getProperty("Schedule_Button"))).click();
			return new SchedulePage(webdriver);
		}
		catch (Exception e){
			System.out.println("Schedule Webinar failed:" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * This method is used to search a webinar
	 * @param webinar
	 * @return boolean
	 */
	public boolean searchWebinar(Webinar webinar){
		try{
			if(webinar != null){
				Assertions.waitForElement(webdriver, props.getProperty("MyWebinar_Search"), 7000);
				WebElement search = webdriver.findElement(By.id(props.getProperty("MyWebinar_Search")));
				search.click();
				search.sendKeys(webinar.getTitle());
				Thread.sleep(5000);
				
				if(verifyWebinarDetails(webdriver,webinar)){
					return true;
				}
				else{
					System.out.println("Search Webinar failed as details didnt match");
					return false;
				}
			}
			else{
				System.out.println("Search Webinar failed as webinar is null object");
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Search Webinar failed:" + e.getMessage());
			return false;
		}
	}
	
	/**
	 * This method is used to verify if the webinar title, date and time match
	 * @param webdriver
	 * @param webinar
	 * @return boolean
	 */
	public boolean verifyWebinarDetails(WebDriver webdriver, Webinar webinar){
		
		String uiWebinarTitle= webdriver.findElement(By.cssSelector(props.getProperty("MyWebinar_title"))).getText();
		String uiWebinarDate = webdriver.findElement(By.cssSelector(props.getProperty("MyWebinar_date"))).getText();
		String uiWebinarPeriod= webdriver.findElement(By.cssSelector(props.getProperty("MyWebinar_period"))).getText();
		String webinarPeriod = webinar.getStart_time()+" AM - " + webinar.getEnd_time() + " AM " + webinar.getTimezone();
		
		if(uiWebinarTitle.equalsIgnoreCase(webinar.getTitle())){
			if(uiWebinarDate.equalsIgnoreCase(webinar.getStartDate())){
				if(uiWebinarPeriod.equalsIgnoreCase(webinarPeriod)){
					return true;
				}else{
					System.out.println("The Webinar Period didnt match" + uiWebinarPeriod);
					return false;
				}
			}
			else{
				System.out.println("The Webinar Date didnt match" + uiWebinarDate);
				return false;
			}
		}else{
			System.out.println("The Webinar Title didnt match" + uiWebinarTitle);
			return false;
		}
			
	}
}
