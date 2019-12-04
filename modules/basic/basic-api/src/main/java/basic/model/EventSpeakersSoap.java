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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link basic.service.http.EventSpeakersServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventSpeakersSoap implements Serializable {

	public static EventSpeakersSoap toSoapModel(EventSpeakers model) {
		EventSpeakersSoap soapModel = new EventSpeakersSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setPosition(model.getPosition());
		soapModel.setSpeakerImage(model.getSpeakerImage());
		soapModel.setSpeakerImageString(model.getSpeakerImageString());
		soapModel.setNationality(model.getNationality());
		soapModel.setEmail(model.getEmail());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setUserId(model.getUserId());
		soapModel.setLastName(model.getLastName());
		soapModel.setIsNotificationSent(model.getIsNotificationSent());
		soapModel.setEventId(model.getEventId());
		soapModel.setIsNotifEnabled(model.getIsNotifEnabled());

		return soapModel;
	}

	public static EventSpeakersSoap[] toSoapModels(EventSpeakers[] models) {
		EventSpeakersSoap[] soapModels = new EventSpeakersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSpeakersSoap[][] toSoapModels(EventSpeakers[][] models) {
		EventSpeakersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSpeakersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSpeakersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSpeakersSoap[] toSoapModels(List<EventSpeakers> models) {
		List<EventSpeakersSoap> soapModels = new ArrayList<EventSpeakersSoap>(
			models.size());

		for (EventSpeakers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSpeakersSoap[soapModels.size()]);
	}

	public EventSpeakersSoap() {
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

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public Blob getSpeakerImage() {
		return _speakerImage;
	}

	public void setSpeakerImage(Blob speakerImage) {
		_speakerImage = speakerImage;
	}

	public String getSpeakerImageString() {
		return _speakerImageString;
	}

	public void setSpeakerImageString(String speakerImageString) {
		_speakerImageString = speakerImageString;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getIsNotificationSent() {
		return _isNotificationSent;
	}

	public void setIsNotificationSent(String isNotificationSent) {
		_isNotificationSent = isNotificationSent;
	}

	public String getEventId() {
		return _eventId;
	}

	public void setEventId(String eventId) {
		_eventId = eventId;
	}

	public String getIsNotifEnabled() {
		return _isNotifEnabled;
	}

	public void setIsNotifEnabled(String isNotifEnabled) {
		_isNotifEnabled = isNotifEnabled;
	}

	private String _uuid;
	private long _id;
	private String _position;
	private Blob _speakerImage;
	private String _speakerImageString;
	private String _nationality;
	private String _email;
	private String _firstName;
	private String _userId;
	private String _lastName;
	private String _isNotificationSent;
	private String _eventId;
	private String _isNotifEnabled;

}