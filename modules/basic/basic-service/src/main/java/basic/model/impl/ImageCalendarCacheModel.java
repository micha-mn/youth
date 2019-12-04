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

package basic.model.impl;

import basic.model.ImageCalendar;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing ImageCalendar in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ImageCalendarCacheModel
	implements CacheModel<ImageCalendar>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageCalendarCacheModel)) {
			return false;
		}

		ImageCalendarCacheModel imageCalendarCacheModel =
			(ImageCalendarCacheModel)obj;

		if (Id == imageCalendarCacheModel.Id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", Id=");
		sb.append(Id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImageCalendar toEntityModel() {
		ImageCalendarImpl imageCalendarImpl = new ImageCalendarImpl();

		if (uuid == null) {
			imageCalendarImpl.setUuid("");
		}
		else {
			imageCalendarImpl.setUuid(uuid);
		}

		imageCalendarImpl.setId(Id);
		imageCalendarImpl.setGroupId(groupId);
		imageCalendarImpl.setCompanyId(companyId);
		imageCalendarImpl.setUserId(userId);

		if (userName == null) {
			imageCalendarImpl.setUserName("");
		}
		else {
			imageCalendarImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			imageCalendarImpl.setCreateDate(null);
		}
		else {
			imageCalendarImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			imageCalendarImpl.setModifiedDate(null);
		}
		else {
			imageCalendarImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventId == null) {
			imageCalendarImpl.setEventId("");
		}
		else {
			imageCalendarImpl.setEventId(eventId);
		}

		imageCalendarImpl.resetOriginalValues();

		return imageCalendarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		Id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(Id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (eventId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventId);
		}
	}

	public String uuid;
	public long Id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String eventId;

}