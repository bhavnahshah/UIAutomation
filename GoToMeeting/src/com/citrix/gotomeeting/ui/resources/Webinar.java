package com.citrix.gotomeeting.ui.resources;
/**
 * This class holds the Webinar object
 * @author bhavna
 *
 */
public class Webinar {

	private String copywebinar;
	private String title;
	private String description;
	private String start_date;
	private String end_date;
	private String start_time;
	private String start_time_am_pm;
	private String end_time;
	private String end_time_am_pm;
	private String timezone;
	private Language language;
	private String occurs;
	
	private Webinar(WebinarBuilder builder){
		this.title = builder.title;
		this.description = builder.description;
		this.start_date = builder.start_date;
		this.end_date = builder.end_date;
		this.start_time = builder.start_time;
		this.start_time_am_pm = builder.start_time_am_pm;
		this.timezone = builder.timezone;
		this.language = builder.language;
		this.copywebinar = builder.copywebinar;
		this.occurs = builder.occurs;
		this.end_time = builder.end_time;
		this.end_time_am_pm = builder.end_time_am_pm;
	}
	
	public String getTitle(){return title.trim(); }
	public String getDescription(){return description.trim();}
	public String getStartDate(){return start_date.trim(); }
	public String getStart_time(){return start_time.trim(); }
	public String getStart_time_am_pm(){return start_time_am_pm.trim();}
	public String getEnd_time(){return end_time.trim();}
	public String getEnd_time_am_pm(){return end_time_am_pm.trim();}
	public String getTimezone(){return timezone;}
	public Language getLanguage(){return language;}
	
	public String getCopywebinar(){return copywebinar.trim();}
	public String getOccurs(){return occurs.trim();}
	public String getEndDate(){return end_date.trim();}
	
	
	//Builder class
	public static class WebinarBuilder{
		//required fields
		private String title;
		private String description;
		private String start_date;
		private String start_time;
		private String start_time_am_pm;
		private String end_time ="";
		private String end_time_am_pm = "";
		private String timezone;
		private Language language;
		
		//optional fields
		private String copywebinar = "";
		private String occurs = "";
		private String end_date ="";
		
		
		public WebinarBuilder(String title, String description, String start_date, String start_time, String start_time_am_pm, String end_time, String end_time_am_pm, String timezone, Language language){
			this.title = title;
			this.description = description;
			this.start_date = start_date;
			this.start_time = start_time;
			this.start_time_am_pm = start_time_am_pm;
			this.end_time = end_time;
			this.end_time_am_pm = end_time_am_pm;
			this.timezone = timezone;
			this.language = language;
			
		}
		
		public WebinarBuilder setCopywebinar(String copywebinar){this.copywebinar=copywebinar; return this;}
		public WebinarBuilder setOccurs(String occurs){this.occurs=occurs; return this;}
		public WebinarBuilder setEndDate(String end_date){this.end_date=end_date; return this;}
		
		/**
		 * This method returns the instance of the Webinar Object
		 * @return Webinar
		 */
		public Webinar build(){
			return new Webinar(this);
		}
	}
	
}
