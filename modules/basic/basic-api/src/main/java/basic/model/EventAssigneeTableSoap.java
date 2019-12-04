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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.EventAssigneeTableServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventAssigneeTableSoap implements Serializable {

	public static EventAssigneeTableSoap toSoapModel(EventAssigneeTable model) {
		EventAssigneeTableSoap soapModel = new EventAssigneeTableSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEventId(model.getEventId());
		soapModel.setAssigneeId(model.getAssigneeId());

		return soapModel;
	}

	public static EventAssigneeTableSoap[] toSoapModels(
		EventAssigneeTable[] models) {

		EventAssigneeTableSoap[] soapModels =
			new EventAssigneeTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventAssigneeTableSoap[][] toSoapModels(
		EventAssigneeTable[][] models) {

		EventAssigneeTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EventAssigneeTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventAssigneeTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventAssigneeTableSoap[] toSoapModels(
		List<EventAssigneeTable> models) {

		List<EventAssigneeTableSoap> soapModels =
			new ArrayList<EventAssigneeTableSoap>(models.size());

		for (EventAssigneeTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EventAssigneeTableSoap[soapModels.size()]);
	}

	public EventAssigneeTableSoap() {
	}

	public int getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public int getId() {
		return _Id;
	}

	public void setId(int Id) {
		_Id = Id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getEventId() {
		return _eventId;
	}

	public void setEventId(int eventId) {
		_eventId = eventId;
	}

	public int getAssigneeId() {
		return _assigneeId;
	}

	public void setAssigneeId(int assigneeId) {
		_assigneeId = assigneeId;
	}

	private String _uuid;
	private int _Id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private int _eventId;
	private int _assigneeId;

}