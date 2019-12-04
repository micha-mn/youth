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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.EventAttributesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventAttributesSoap implements Serializable {

	public static EventAttributesSoap toSoapModel(EventAttributes model) {
		EventAttributesSoap soapModel = new EventAttributesSoap();

		soapModel.setId(model.getId());
		soapModel.setAttributeNumber(model.getAttributeNumber());
		soapModel.setAttributeName(model.getAttributeName());
		soapModel.setEventId(model.getEventId());

		return soapModel;
	}

	public static EventAttributesSoap[] toSoapModels(EventAttributes[] models) {
		EventAttributesSoap[] soapModels =
			new EventAttributesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventAttributesSoap[][] toSoapModels(
		EventAttributes[][] models) {

		EventAttributesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EventAttributesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventAttributesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventAttributesSoap[] toSoapModels(
		List<EventAttributes> models) {

		List<EventAttributesSoap> soapModels =
			new ArrayList<EventAttributesSoap>(models.size());

		for (EventAttributes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventAttributesSoap[soapModels.size()]);
	}

	public EventAttributesSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getAttributeNumber() {
		return _attributeNumber;
	}

	public void setAttributeNumber(String attributeNumber) {
		_attributeNumber = attributeNumber;
	}

	public String getAttributeName() {
		return _attributeName;
	}

	public void setAttributeName(String attributeName) {
		_attributeName = attributeName;
	}

	public String getEventId() {
		return _eventId;
	}

	public void setEventId(String eventId) {
		_eventId = eventId;
	}

	private long _id;
	private String _attributeNumber;
	private String _attributeName;
	private String _eventId;

}