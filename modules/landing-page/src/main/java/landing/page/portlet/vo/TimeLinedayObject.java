package landing.page.portlet.vo;

import java.util.ArrayList;
import java.util.List;

public class TimeLinedayObject 
{
	String title;
	String dateDescription;
	String time;
	List<EventTimeDescripiton> eventTimeDescription = new ArrayList<EventTimeDescripiton>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateDescription() {
		return dateDescription;
	}
	public void setDateDescription(String dateDescription) {
		this.dateDescription = dateDescription;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<EventTimeDescripiton> getEventTimeDescription() {
		return eventTimeDescription;
	}
	public void setEventTimeDescription(List<EventTimeDescripiton> eventTimeDescription) {
		this.eventTimeDescription = eventTimeDescription;
	}
	
	
	

}
