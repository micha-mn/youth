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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.EventHighLightsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventHighLightsSoap implements Serializable {

	public static EventHighLightsSoap toSoapModel(EventHighLights model) {
		EventHighLightsSoap soapModel = new EventHighLightsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setImage(model.getImage());
		soapModel.setEventId(model.getEventId());

		return soapModel;
	}

	public static EventHighLightsSoap[] toSoapModels(EventHighLights[] models) {
		EventHighLightsSoap[] soapModels =
			new EventHighLightsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventHighLightsSoap[][] toSoapModels(
		EventHighLights[][] models) {

		EventHighLightsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EventHighLightsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventHighLightsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventHighLightsSoap[] toSoapModels(
		List<EventHighLights> models) {

		List<EventHighLightsSoap> soapModels =
			new ArrayList<EventHighLightsSoap>(models.size());

		for (EventHighLights model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventHighLightsSoap[soapModels.size()]);
	}

	public EventHighLightsSoap() {
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

	public Blob getImage() {
		return _Image;
	}

	public void setImage(Blob Image) {
		_Image = Image;
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
	private Blob _Image;
	private String _eventId;

}