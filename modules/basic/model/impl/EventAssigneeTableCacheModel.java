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

import basic.model.EventAssigneeTable;

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
 * The cache model class for representing EventAssigneeTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventAssigneeTableCacheModel
	implements CacheModel<EventAssigneeTable>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventAssigneeTableCacheModel)) {
			return false;
		}

		EventAssigneeTableCacheModel eventAssigneeTableCacheModel =
			(EventAssigneeTableCacheModel)obj;

		if (Id == eventAssigneeTableCacheModel.Id) {
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
		StringBundler sb = new StringBundler(23);

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
		sb.append(", name=");
		sb.append(name);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", assigneeId=");
		sb.append(assigneeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventAssigneeTable toEntityModel() {
		EventAssigneeTableImpl eventAssigneeTableImpl =
			new EventAssigneeTableImpl();

		if (uuid == null) {
			eventAssigneeTableImpl.setUuid("");
		}
		else {
			eventAssigneeTableImpl.setUuid(uuid);
		}

		eventAssigneeTableImpl.setId(Id);
		eventAssigneeTableImpl.setGroupId(groupId);
		eventAssigneeTableImpl.setCompanyId(companyId);
		eventAssigneeTableImpl.setUserId(userId);

		if (userName == null) {
			eventAssigneeTableImpl.setUserName("");
		}
		else {
			eventAssigneeTableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventAssigneeTableImpl.setCreateDate(null);
		}
		else {
			eventAssigneeTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventAssigneeTableImpl.setModifiedDate(null);
		}
		else {
			eventAssigneeTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			eventAssigneeTableImpl.setName("");
		}
		else {
			eventAssigneeTableImpl.setName(name);
		}

		eventAssigneeTableImpl.setEventId(eventId);
		eventAssigneeTableImpl.setAssigneeId(assigneeId);

		eventAssigneeTableImpl.resetOriginalValues();

		return eventAssigneeTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		Id = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		eventId = objectInput.readInt();

		assigneeId = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeInt(Id);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(eventId);

		objectOutput.writeInt(assigneeId);
	}

	public String uuid;
	public int Id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public int eventId;
	public int assigneeId;

}