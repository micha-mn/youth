package editEvent.portlet.vo;

import java.sql.Blob;

public class TimelineVO 
{
	String id;
	String title;
	String titleAr;
	String description;
	String descriptionAr;
	String eventstartday;
	String eventendday;
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
	
	public String getTitleAr() {
		return titleAr;
	}
	public void setTitleAr(String titleAr) {
		this.titleAr = titleAr;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionAr() {
		return descriptionAr;
	}
	public void setDescriptionAr(String descriptionAr) {
		this.descriptionAr = descriptionAr;
	}
	public String getEventstartday() {
		return eventstartday;
	}
	public void setEventstartday(String eventstartday) {
		this.eventstartday = eventstartday;
	}
	public String getEventendday() {
		return eventendday;
	}
	public void setEventendday(String eventendday) {
		this.eventendday = eventendday;
	}
	
	
	
}
