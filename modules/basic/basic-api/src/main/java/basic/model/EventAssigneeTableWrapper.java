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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link EventAssigneeTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAssigneeTable
 * @generated
 */
@ProviderType
public class EventAssigneeTableWrapper
	extends BaseModelWrapper<EventAssigneeTable>
	implements EventAssigneeTable, ModelWrapper<EventAssigneeTable> {

	public EventAssigneeTableWrapper(EventAssigneeTable eventAssigneeTable) {
		super(eventAssigneeTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("eventId", getEventId());
		attributes.put("assigneeId", getAssigneeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Integer Id = (Integer)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer eventId = (Integer)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Integer assigneeId = (Integer)attributes.get("assigneeId");

		if (assigneeId != null) {
			setAssigneeId(assigneeId);
		}
	}

	/**
	 * Returns the assignee ID of this event assignee table.
	 *
	 * @return the assignee ID of this event assignee table
	 */
	@Override
	public int getAssigneeId() {
		return model.getAssigneeId();
	}

	/**
	 * Returns the company ID of this event assignee table.
	 *
	 * @return the company ID of this event assignee table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this event assignee table.
	 *
	 * @return the create date of this event assignee table
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event ID of this event assignee table.
	 *
	 * @return the event ID of this event assignee table
	 */
	@Override
	public int getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the group ID of this event assignee table.
	 *
	 * @return the group ID of this event assignee table
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this event assignee table.
	 *
	 * @return the ID of this event assignee table
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this event assignee table.
	 *
	 * @return the modified date of this event assignee table
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this event assignee table.
	 *
	 * @return the name of this event assignee table
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this event assignee table.
	 *
	 * @return the primary key of this event assignee table
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this event assignee table.
	 *
	 * @return the user ID of this event assignee table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this event assignee table.
	 *
	 * @return the user name of this event assignee table
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this event assignee table.
	 *
	 * @return the user uuid of this event assignee table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this event assignee table.
	 *
	 * @return the uuid of this event assignee table
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the assignee ID of this event assignee table.
	 *
	 * @param assigneeId the assignee ID of this event assignee table
	 */
	@Override
	public void setAssigneeId(int assigneeId) {
		model.setAssigneeId(assigneeId);
	}

	/**
	 * Sets the company ID of this event assignee table.
	 *
	 * @param companyId the company ID of this event assignee table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this event assignee table.
	 *
	 * @param createDate the create date of this event assignee table
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event ID of this event assignee table.
	 *
	 * @param eventId the event ID of this event assignee table
	 */
	@Override
	public void setEventId(int eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the group ID of this event assignee table.
	 *
	 * @param groupId the group ID of this event assignee table
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this event assignee table.
	 *
	 * @param Id the ID of this event assignee table
	 */
	@Override
	public void setId(int Id) {
		model.setId(Id);
	}

	/**
	 * Sets the modified date of this event assignee table.
	 *
	 * @param modifiedDate the modified date of this event assignee table
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this event assignee table.
	 *
	 * @param name the name of this event assignee table
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this event assignee table.
	 *
	 * @param primaryKey the primary key of this event assignee table
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this event assignee table.
	 *
	 * @param userId the user ID of this event assignee table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this event assignee table.
	 *
	 * @param userName the user name of this event assignee table
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this event assignee table.
	 *
	 * @param userUuid the user uuid of this event assignee table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this event assignee table.
	 *
	 * @param uuid the uuid of this event assignee table
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EventAssigneeTableWrapper wrap(
		EventAssigneeTable eventAssigneeTable) {

		return new EventAssigneeTableWrapper(eventAssigneeTable);
	}

}