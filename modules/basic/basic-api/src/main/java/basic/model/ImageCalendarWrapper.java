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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link ImageCalendar}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageCalendar
 * @generated
 */
@ProviderType
public class ImageCalendarWrapper
	extends BaseModelWrapper<ImageCalendar>
	implements ImageCalendar, ModelWrapper<ImageCalendar> {

	public ImageCalendarWrapper(ImageCalendar imageCalendar) {
		super(imageCalendar);
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
		attributes.put("data", getData());
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

		Blob data = (Blob)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	/**
	 * Returns the company ID of this image calendar.
	 *
	 * @return the company ID of this image calendar
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this image calendar.
	 *
	 * @return the create date of this image calendar
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data of this image calendar.
	 *
	 * @return the data of this image calendar
	 */
	@Override
	public Blob getData() {
		return model.getData();
	}

	/**
	 * Returns the event ID of this image calendar.
	 *
	 * @return the event ID of this image calendar
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the group ID of this image calendar.
	 *
	 * @return the group ID of this image calendar
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this image calendar.
	 *
	 * @return the ID of this image calendar
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this image calendar.
	 *
	 * @return the modified date of this image calendar
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this image calendar.
	 *
	 * @return the primary key of this image calendar
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this image calendar.
	 *
	 * @return the user ID of this image calendar
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this image calendar.
	 *
	 * @return the user name of this image calendar
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this image calendar.
	 *
	 * @return the user uuid of this image calendar
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this image calendar.
	 *
	 * @return the uuid of this image calendar
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
	 * Sets the company ID of this image calendar.
	 *
	 * @param companyId the company ID of this image calendar
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this image calendar.
	 *
	 * @param createDate the create date of this image calendar
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data of this image calendar.
	 *
	 * @param data the data of this image calendar
	 */
	@Override
	public void setData(Blob data) {
		model.setData(data);
	}

	/**
	 * Sets the event ID of this image calendar.
	 *
	 * @param eventId the event ID of this image calendar
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the group ID of this image calendar.
	 *
	 * @param groupId the group ID of this image calendar
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this image calendar.
	 *
	 * @param Id the ID of this image calendar
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the modified date of this image calendar.
	 *
	 * @param modifiedDate the modified date of this image calendar
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this image calendar.
	 *
	 * @param primaryKey the primary key of this image calendar
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this image calendar.
	 *
	 * @param userId the user ID of this image calendar
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this image calendar.
	 *
	 * @param userName the user name of this image calendar
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this image calendar.
	 *
	 * @param userUuid the user uuid of this image calendar
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this image calendar.
	 *
	 * @param uuid the uuid of this image calendar
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
	protected ImageCalendarWrapper wrap(ImageCalendar imageCalendar) {
		return new ImageCalendarWrapper(imageCalendar);
	}

}