package com.citrix.gotomeeting.ui.resources;
/**
 * This class defines the different timezones supported by the application. 
 * Just added for US timezones - PST,EST, CST and Mountain
 * @author bhavna
 */
public enum TimeZoneEnum {
	
	PST("(GMT-07:00) Pacific Time (US and Canada);Tijuana", "America/Los_Angeles","PST", "PDT",5), 
	MOUNTAIN("(GMT-06:00) Mountain Time (US and Canada)", "America/Phoenix","MST","MDT",6),
	CENTRAL("(GMT-05:00) Central Time (US and Canada)", "America/Chicago", "CST","CDT",8), 
	EST("(GMT-04:00) Eastern Time (US and Canada)", "America/New_York", "EST","EDT",11);
	
	public String strTimeZone;
	public String strId;
	public String strAcronym;
	public String strDaylightAcronym;
	public int id;

	private TimeZoneEnum(String timezone, String strId, String acronym, String strDaylightAcronym, int id){
		this.strTimeZone = timezone;
		this.strId = strId;
		this.strAcronym = acronym;
		this.strDaylightAcronym = strDaylightAcronym;
		this.id = id;
	}
	
	/**
	 * This method returns the timezone display string of the respective timezone
	 * @return String
	 */
	public String getTimezone(){
		return strTimeZone;
	}
	
	/**
	 * This method returns the timezone ID string of the respective timezone
	 * @return String
	 */
	public String getTimezoneId(){
		return strId;
	}
	/**
	 * This method returns the acronym of the respective timezone
	 * @return String
	 */
	public String getAcronym(){
		return strAcronym;
	}
	
	/**
	 * This method returns the day light acronym of the respective timezone ex: PDT
	 * @return String
	 */
	public String getDaylightAcronym(){
		return strDaylightAcronym;
	}
	
	/**
	 * This method returns the nth number of the respective timezone in the UI the display list
	 * @return int
	 */
	public int getId(){
		return id;
	}
}

