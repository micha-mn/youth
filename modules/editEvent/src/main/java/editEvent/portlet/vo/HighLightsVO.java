package editEvent.portlet.vo;

import java.sql.Blob;

public class HighLightsVO 
{
	String id;
	String description;
	String descriptionAr;
	String title;
	String titleAr;
	Blob  image;
	String eventId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
}
