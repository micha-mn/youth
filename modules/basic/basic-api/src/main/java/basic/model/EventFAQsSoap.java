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
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link basic.service.http.EventFAQsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventFAQsSoap implements Serializable {

	public static EventFAQsSoap toSoapModel(EventFAQs model) {
		EventFAQsSoap soapModel = new EventFAQsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setAnswer(model.getAnswer());
		soapModel.setEventId(model.getEventId());

		return soapModel;
	}

	public static EventFAQsSoap[] toSoapModels(EventFAQs[] models) {
		EventFAQsSoap[] soapModels = new EventFAQsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventFAQsSoap[][] toSoapModels(EventFAQs[][] models) {
		EventFAQsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventFAQsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventFAQsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventFAQsSoap[] toSoapModels(List<EventFAQs> models) {
		List<EventFAQsSoap> soapModels = new ArrayList<EventFAQsSoap>(
			models.size());

		for (EventFAQs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventFAQsSoap[soapModels.size()]);
	}

	public EventFAQsSoap() {
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

	public String getQuestion() {
		return _Question;
	}

	public void setQuestion(String Question) {
		_Question = Question;
	}

	public String getAnswer() {
		return _Answer;
	}

	public void setAnswer(String Answer) {
		_Answer = Answer;
	}

	public String getEventId() {
		return _eventId;
	}

	public void setEventId(String eventId) {
		_eventId = eventId;
	}

	private String _uuid;
	private long _id;
	private String _Question;
	private String _Answer;
	private String _eventId;

}