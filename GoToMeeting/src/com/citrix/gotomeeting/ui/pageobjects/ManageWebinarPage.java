package com.citrix.gotomeeting.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.citrix.gotomeeting.ui.common.Page;
import com.citrix.gotomeeting.ui.resources.Webinar;

/**
 * This class is the Page Object for the Manage Webinar Page
 * @author bhavna
 *
 */
public class ManageWebinarPage extends Page{
private WebDriver webdriver;
public Webinar webinar;
	
	public ManageWebinarPage(WebDriver webdriver, Webinar webinar){
		this.webdriver = webdriver; 
		this.webinar = webinar;
	}
	/**
	 * This method directs the user to go to the My Webinar page by clicking on the link in the left menu
	 * @return MyWebinarPage
	 */
	public MyWebinarPage gotoMyWebinar(){
		
		webdriver.findElement(By.linkText("My Webinars")).click();
		return new MyWebinarPage(webdriver);
	}
}
