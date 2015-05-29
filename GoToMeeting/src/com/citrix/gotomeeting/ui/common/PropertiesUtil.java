package com.citrix.gotomeeting.ui.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This is a utility class used to read the properties file
 * @author bhavna
 *
 */
public class PropertiesUtil{

	static Properties props = new Properties();

	static {
		try {
			props.load(new FileInputStream("src/Locators.properties"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Locators.properties File Not Found");
		} 
		catch (Exception e) {
			System.out.println("Locators.properties File Not Found" + e.getStackTrace());
		}
	}
	/**
	 * This method is used to return the property value 
	 * @param value
	 * @return String
	 */
	public String getProperty(String value) {
		String propertyValue = null;
		try {
			propertyValue = props.getProperty(value);
			} 
		catch (Exception e) {
			System.out.println("Property " + value + " not Found");
			}
			return propertyValue;
		}
}
