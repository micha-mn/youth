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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.sql.Blob;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ImageCalendar service. Represents a row in the &quot;ImageCalendar&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>basic.model.impl.ImageCalendarModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>basic.model.impl.ImageCalendarImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageCalendar
 * @generated
 */
@ProviderType
public interface ImageCalendarModel
	extends BaseModel<ImageCalendar>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a image calendar model instance should use the {@link ImageCalendar} interface instead.
	 */

	/**
	 * Returns the primary key of this image calendar.
	 *
	 * @return the primary key of this image calendar
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this image calendar.
	 *
	 * @param primaryKey the primary key of this image calendar
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this image calendar.
	 *
	 * @return the uuid of this image calendar
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this image calendar.
	 *
	 * @param uuid the uuid of this image calendar
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this image calendar.
	 *
	 * @return the ID of this image calendar
	 */
	public long getId();

	/**
	 * Sets the ID of this image calendar.
	 *
	 * @param Id the ID of this image calendar
	 */
	public void setId(long Id);

	/**
	 * Returns the group ID of this image calendar.
	 *
	 * @return the group ID of this image calendar
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this image calendar.
	 *
	 * @param groupId the group ID of this image calendar
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this image calendar.
	 *
	 * @return the company ID of this image calendar
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this image calendar.
	 *
	 * @param companyId the company ID of this image calendar
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this image calendar.
	 *
	 * @return the user ID of this image calendar
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this image calendar.
	 *
	 * @param userId the user ID of this image calendar
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this image calendar.
	 *
	 * @return the user uuid of this image calendar
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this image calendar.
	 *
	 * @param userUuid the user uuid of this image calendar
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this image calendar.
	 *
	 * @return the user name of this image calendar
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this image calendar.
	 *
	 * @param userName the user name of this image calendar
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this image calendar.
	 *
	 * @return the create date of this image calendar
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this image calendar.
	 *
	 * @param createDate the create date of this image calendar
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this image calendar.
	 *
	 * @return the modified date of this image calendar
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this image calendar.
	 *
	 * @param modifiedDate the modified date of this image calendar
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the data of this image calendar.
	 *
	 * @return the data of this image calendar
	 */
	public Blob getData();

	/**
	 * Sets the data of this image calendar.
	 *
	 * @param data the data of this image calendar
	 */
	public void setData(Blob data);

	/**
	 * Returns the event ID of this image calendar.
	 *
	 * @return the event ID of this image calendar
	 */
	@AutoEscape
	public String getEventId();

	/**
	 * Sets the event ID of this image calendar.
	 *
	 * @param eventId the event ID of this image calendar
	 */
	public void setEventId(String eventId);

}