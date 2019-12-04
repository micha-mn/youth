package editEvent.portlet.vo;

import java.sql.Blob;

public class AttributesVO 
{
	String id;
	String attributeNumber;
	String attributeName;
	String eventId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getAttributeNumber() {
		return attributeNumber;
	}
	public void setAttributeNumber(String attributeNumber) {
		this.attributeNumber = attributeNumber;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	
}
