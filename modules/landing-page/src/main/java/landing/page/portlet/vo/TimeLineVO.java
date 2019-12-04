package landing.page.portlet.vo;

import java.util.HashMap;

public class TimeLineVO 
{
	String id;
	String title;
    String description;
    String titleAr;
    String descriptionAr;
    String eventStartDay;
    String eventEndDay;
    HashMap<String,String> dayEvent = new HashMap<String, String>();
    HashMap<String,String> hs = new HashMap<String, String>();
    
    String eventId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitleAr() {
		return titleAr;
	}
	public void setTitleAr(String titleAr) {
		this.titleAr = titleAr;
	}
	public String getDescriptionAr() {
		return descriptionAr ==null || descriptionAr.equalsIgnoreCase("null") || descriptionAr.equalsIgnoreCase("")?description:descriptionAr;
	}
	public void setDescriptionAr(String descriptionAr) {
		this.descriptionAr = descriptionAr;
	}
	
	public String getEventStartDay() {
		return eventStartDay;
	}
	public void setEventStartDay(String eventStartDay) {
		this.eventStartDay = eventStartDay;
	}
	public String getEventEndDay() {
		return eventEndDay;
	}
	public void setEventEndDay(String eventEndDay) {
		this.eventEndDay = eventEndDay;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public HashMap<String, String> getHs() {
		return hs;
	}
	public void setHs(HashMap<String, String> hs) {
		this.hs = hs;
	}
	public HashMap<String, String> getDayEvent() {
		return dayEvent;
	}
	public void setDayEvent(HashMap<String, String> dayEvent) {
		this.dayEvent = dayEvent;
	}
	
    
    
}
