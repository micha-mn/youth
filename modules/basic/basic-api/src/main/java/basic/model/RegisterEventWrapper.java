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
 * This class is a wrapper for {@link RegisterEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegisterEvent
 * @generated
 */
@ProviderType
public class RegisterEventWrapper
	extends BaseModelWrapper<RegisterEvent>
	implements RegisterEvent, ModelWrapper<RegisterEvent> {

	public RegisterEventWrapper(RegisterEvent registerEvent) {
		super(registerEvent);
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
		attributes.put("registeredUserId", getRegisteredUserId());
		attributes.put("eventId", getEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long Id = (Long)attributes.get("Id");

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

		String registeredUserId = (String)attributes.get("registeredUserId");

		if (registeredUserId != null) {
			setRegisteredUserId(registeredUserId);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	/**
	 * Returns the company ID of this register event.
	 *
	 * @return the company ID of this register event
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this register event.
	 *
	 * @return the create date of this register event
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event ID of this register event.
	 *
	 * @return the event ID of this register event
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the group ID of this register event.
	 *
	 * @return the group ID of this register event
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this register event.
	 *
	 * @return the ID of this register event
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this register event.
	 *
	 * @return the modified date of this register event
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this register event.
	 *
	 * @return the primary key of this register event
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the registered user ID of this register event.
	 *
	 * @return the registered user ID of this register event
	 */
	@Override
	public String getRegisteredUserId() {
		return model.getRegisteredUserId();
	}

	/**
	 * Returns the user ID of this register event.
	 *
	 * @return the user ID of this register event
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this register event.
	 *
	 * @return the user name of this register event
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this register event.
	 *
	 * @return the user uuid of this register event
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this register event.
	 *
	 * @return the uuid of this register event
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
	 * Sets the company ID of this register event.
	 *
	 * @param companyId the company ID of this register event
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this register event.
	 *
	 * @param createDate the create date of this register event
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event ID of this register event.
	 *
	 * @param eventId the event ID of this register event
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the group ID of this register event.
	 *
	 * @param groupId the group ID of this register event
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this register event.
	 *
	 * @param Id the ID of this register event
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the modified date of this register event.
	 *
	 * @param modifiedDate the modified date of this register event
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this register event.
	 *
	 * @param primaryKey the primary key of this register event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the registered user ID of this register event.
	 *
	 * @param registeredUserId the registered user ID of this register event
	 */
	@Override
	public void setRegisteredUserId(String registeredUserId) {
		model.setRegisteredUserId(registeredUserId);
	}

	/**
	 * Sets the user ID of this register event.
	 *
	 * @param userId the user ID of this register event
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this register event.
	 *
	 * @param userName the user name of this register event
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this register event.
	 *
	 * @param userUuid the user uuid of this register event
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this register event.
	 *
	 * @param uuid the uuid of this register event
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
	protected RegisterEventWrapper wrap(RegisterEvent registerEvent) {
		return new RegisterEventWrapper(registerEvent);
	}

}