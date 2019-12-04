/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package basic.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link basic.service.http.EventTimelineServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventTimelineSoap implements Serializable {

	public static EventTimelineSoap toSoapModel(EventTimeline model) {
		EventTimelineSoap soapModel = new EventTimelineSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setEventStartDay(model.getEventStartDay());
		soapModel.setEventendDay(model.getEventendDay());
		soapModel.setEventId(model.getEventId());

		return soapModel;
	}

	public static EventTimelineSoap[] toSoapModels(EventTimeline[] models) {
		EventTimelineSoap[] soapModels = new EventTimelineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventTimelineSoap[][] toSoapModels(EventTimeline[][] models) {
		EventTimelineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventTimelineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventTimelineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventTimelineSoap[] toSoapModels(List<EventTimeline> models) {
		List<EventTimelineSoap> soapModels = new ArrayList<EventTimelineSoap>(
			models.size());

		for (EventTimeline model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventTimelineSoap[soapModels.size()]);
	}

	public EventTimelineSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTitle() {
		return _Title;
	}

	public void setTitle(String Title) {
		_Title = Title;
	}

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	public Date getEventStartDay() {
		return _EventStartDay;
	}

	public void setEventStartDay(Date EventStartDay) {
		_EventStartDay = EventStartDay;
	}

	public Date getEventendDay() {
		return _EventendDay;
	}

	public void setEventendDay(Date EventendDay) {
		_EventendDay = EventendDay;
	}

	public String getEventId() {
		return _eventId;
	}

	public void setEventId(String eventId) {
		_eventId = eventId;
	}

	private String _uuid;
	private long _id;
	private String _Title;
	private String _Description;
	private Date _EventStartDay;
	private Date _EventendDay;
	private String _eventId;

}