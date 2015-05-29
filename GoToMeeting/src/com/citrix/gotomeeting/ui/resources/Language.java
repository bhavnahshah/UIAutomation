package com.citrix.gotomeeting.ui.resources;
/**
 * This class is used to define the different languages supported by this application
 * @author bhavna
 * 
 */
public enum Language {

	ENGLISH("English", 2),
	DEUTSCH("Deutsch", 1),
	ESPANOL("Espanol", 3),
	FRENCH("Francais", 4),
	ITALIAN("Italiano", 5);
	
	private String name;
	private int list_id;
	
	private Language(String name, int id){
		this.name = name;
		this.list_id = id;
	}
	
	/**
	 * This method returns the language selected
	 * @return String
	 */
	public String getLanguage(){
		return this.name;
	}
	
	/**
	 * This method returns the list id of the language as displayed on the UI
	 * @return
	 */
	public int getListId(){
		return this.list_id;
	}
}
