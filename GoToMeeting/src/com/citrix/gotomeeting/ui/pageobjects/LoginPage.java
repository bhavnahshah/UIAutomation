package com.citrix.gotomeeting.ui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.citrix.gotomeeting.ui.common.Assertions;
import com.citrix.gotomeeting.ui.common.Page;
import com.citrix.gotomeeting.ui.common.PropertiesUtil;

/**
 * This class is the Login Page object.
 * @author bhavna
 *
 */
public class LoginPage extends Page{
	private WebDriver webdriver;
	
	public LoginPage(){
		this.webdriver = Page.getWebDriver(); 
	}
	
	/***
	 * This method verifies if Login functionality works
	 * @return MyWebinarPage
	 * 
	 */
	public MyWebinarPage login(){
		try{
			PropertiesUtil props = new PropertiesUtil();
			String url = props.getProperty("LoginPage");
			webdriver.get(url);
			Assertions.waitForElement(webdriver, props.getProperty("Email_Input"), 3000);
			WebElement emailInput = webdriver.findElement(By.cssSelector(props.getProperty("Email_Input")));
			emailInput.sendKeys(props.getProperty("Username"));
			WebElement passwordInput = webdriver.findElement(By.cssSelector(props.getProperty("Password_Input")));
			passwordInput.sendKeys(props.getProperty("Password"));
			WebElement submitButton = webdriver.findElement(By.cssSelector(props.getProperty("Submit_Button")));
			submitButton.click();
			if(Assertions.waitForElement(webdriver, props.getProperty("Schedule_Button"), 3000))
				return new MyWebinarPage(webdriver);
			else
				return null;
		}
		catch(Exception e){
			System.out.println("Login failed" + e.getMessage());
			super.killDriver();
		}
		return null;
	}
	
	
	/* These methods could be implemented
	public ResetPasswordPage forgotPassword(){
	}
	
	public SchedulePage rememberMe(){
	}
	
	public SchedulePage loginCompanyId(){
	}
	
	public AboutPage verifyAboutUs(){
	}
	
	public TOSPage verifyTOS(){
	}
	
	public PrivacyPage verifyPrivacyPolicy(){
	}
	
	public SupportPage verifySupport(){
	}
	
	*/

}