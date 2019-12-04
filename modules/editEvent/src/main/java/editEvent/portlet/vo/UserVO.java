package editEvent.portlet.vo;

import java.sql.Blob;

public class UserVO 
{
	String userId;
	String firstName;
	String lastName;
	String email;
	String position;
	String image;
	String speakerId;
	String isNotifEnabled; 
	String speakerOrder;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(String speakerId) {
		this.speakerId = speakerId;
	}
	public String getIsNotifEnabled() {
		return isNotifEnabled;
	}
	public void setIsNotifEnabled(String isNotifEnabled) {
		this.isNotifEnabled = isNotifEnabled;
	}
	public String getSpeakerOrder() {
		return speakerOrder;
	}
	public void setSpeakerOrder(String speakerOrder) {
		this.speakerOrder = speakerOrder;
	}
	
	
}
