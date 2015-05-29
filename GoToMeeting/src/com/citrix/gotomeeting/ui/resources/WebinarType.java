package com.citrix.gotomeeting.ui.resources;

/**
 * This enum class defines the types of Webinar
 * @author bhavna
 *
 */
public enum WebinarType {
	ONESESSION("One Session"), 
	SERIES("Series"), 
	SEQUENCE("Sequence");

	private String sessionType;

	private WebinarType(String str){
		this.sessionType = str;
	}
	/**
	 * This method returns the type of webinar
	 * @return
	 */
	public String getType(){
		return this.sessionType;
	}
	
}
