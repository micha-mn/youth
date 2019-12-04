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

import basic.model.RegisterEvent;

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
 * The cache model class for representing RegisterEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RegisterEventCacheModel
	implements CacheModel<RegisterEvent>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegisterEventCacheModel)) {
			return false;
		}

		RegisterEventCacheModel registerEventCacheModel =
			(RegisterEventCacheModel)obj;

		if (Id == registerEventCacheModel.Id) {
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
		StringBundler sb = new StringBundler(21);

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
		sb.append(", registeredUserId=");
		sb.append(registeredUserId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegisterEvent toEntityModel() {
		RegisterEventImpl registerEventImpl = new RegisterEventImpl();

		if (uuid == null) {
			registerEventImpl.setUuid("");
		}
		else {
			registerEventImpl.setUuid(uuid);
		}

		registerEventImpl.setId(Id);
		registerEventImpl.setGroupId(groupId);
		registerEventImpl.setCompanyId(companyId);
		registerEventImpl.setUserId(userId);

		if (userName == null) {
			registerEventImpl.setUserName("");
		}
		else {
			registerEventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			registerEventImpl.setCreateDate(null);
		}
		else {
			registerEventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			registerEventImpl.setModifiedDate(null);
		}
		else {
			registerEventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (registeredUserId == null) {
			registerEventImpl.setRegisteredUserId("");
		}
		else {
			registerEventImpl.setRegisteredUserId(registeredUserId);
		}

		if (eventId == null) {
			registerEventImpl.setEventId("");
		}
		else {
			registerEventImpl.setEventId(eventId);
		}

		registerEventImpl.resetOriginalValues();

		return registerEventImpl;
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
		registeredUserId = objectInput.readUTF();
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

		if (registeredUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(registeredUserId);
		}

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
	public String registeredUserId;
	public String eventId;

}