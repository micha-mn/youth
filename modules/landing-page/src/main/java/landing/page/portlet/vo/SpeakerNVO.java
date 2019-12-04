package landing.page.portlet.vo;

import java.sql.Blob;

public class SpeakerNVO 
{
	String id_;
	String position;
	String firstName;
	String lastName;
	Blob  speakerImage;
	String  speakerImageString;
	String nationality;
	String  eventId;
	String emailAddress;
	String userId;
	
	public String getId_() {
		return id_;
	}
	public void setId_(String id_) {
		this.id_ = id_;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public Blob getSpeakerImage() {
		return speakerImage;
	}
	public void setSpeakerImage(Blob speakerImage) {
		this.speakerImage = speakerImage;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSpeakerImageString() {
		return speakerImageString;
	}
	public void setSpeakerImageString(String speakerImageString) {
		this.speakerImageString = speakerImageString;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	

}
