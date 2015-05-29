package com.citrix.gotomeeting.ui.common;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.citrix.gotomeeting.ui.resources.TimeZoneEnum;
/**
 * This class is a date utility class
 * @author bhavna
 *
 */
public class DateUtil {
	/**
	 * This method is used to get the date object of a specified number of days from today 
	 * @param daysToAdd
	 * @return Date
	 */
	public Date getDate(int daysToAdd){
		
		Date today = new Date();
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("America/Los_Angeles"));
		cal.setTime(today);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, daysToAdd);
		Date endDate = cal.getTime();
		return endDate;		
	}
	
	/**
	 * This overriden method is used to get the date object of a specified number of days from today using the specified timezone
	 * @param daysToAdd
	 * @param id
	 * @return Date
	 */
	public Date getDate(int daysToAdd, TimeZoneEnum id){
		
		Date today = new Date();
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(id.getAcronym()));
		cal.setTimeZone(TimeZone.getTimeZone(id.getAcronym()));
		cal.setTime(today);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, daysToAdd);
		Date endDate = cal.getTime();
		return endDate;		
	}
	
	/**
	 * This method is used to get the date in the displayed format i.e Sat, May 5
	 * @param daysToAdd
	 * @return String
	 */
	public String getDisplayDate(int daysToAdd){
		Date date = getDate(daysToAdd);
		SimpleDateFormat simpleDate = new SimpleDateFormat("EEE, MMM d");		
		String dateString = simpleDate.format(date).toString();
		return dateString.trim();
	}
	
	/**
	 * This method returns the Month in numeral format i.e. 9
	 * @param date
	 * @return int
	 */
	public int getMonth(Date date){
		SimpleDateFormat simpleDate = new SimpleDateFormat("M");		
		String dateString = simpleDate.format(date).toString();
		return Integer.parseInt(dateString);	
	}
	
	/**
	 * This method returns the day in numeral format i.e. 30
	 * @param date
	 * @return String
	 */
	public String getDay(Date date){
		SimpleDateFormat simpleDate = new SimpleDateFormat("d");		
		String dateString = simpleDate.format(date).toString();
		return dateString.trim();	
	}
	
	/**
	 * This method returns the year i.e. 2015
	 * @param date
	 * @return int
	 */
	public int getYear(Date date){
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy");		
		String dateString = simpleDate.format(date).toString();
		return Integer.parseInt(dateString);	
		
	}
	
	/**
	 * This method returns the time zone value as per daylight i.e. PST
	 * @param daysToAdd
	 * @param id
	 * @return String
	 */
	public String getDateDaylightTimezone(int daysToAdd, TimeZoneEnum id){
		Date date = getDate(daysToAdd, id);
		TimeZone timezone = TimeZone.getTimeZone(id.getTimezoneId());
		
		if(timezone.inDaylightTime(date)){
			return id.getDaylightAcronym();
		}
		else{
			return id.getAcronym();
		}
	}
	
	/**
	 * This method computes the number of months difference between new date and current date 
	 * @param daysFromNow
	 * @return int
	 */
	public int computeDateDifference(int daysFromNow){
		Date newDate = getDate(daysFromNow);
		Date currDate = getDate(0);
		int currMonth = getMonth(currDate);
		int currYear = getYear(currDate);
		int newYear = getYear(newDate);
		int newMonth = getMonth(newDate);
		int dateDifference = 12*(newYear - currYear) + newMonth - currMonth;
		return dateDifference;
	}
	/**
	 * This method returns the day of the new date
	 * @param daysFromNow
	 * @return String
	 */
	public String getNewDay(int daysFromNow){
		Date newDate = getDate(daysFromNow);
		String newDay = getDay(newDate);
		return newDay;
	}
}
