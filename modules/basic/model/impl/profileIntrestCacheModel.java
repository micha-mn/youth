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

import basic.model.profileIntrest;

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
 * The cache model class for representing profileIntrest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileIntrestCacheModel
	implements CacheModel<profileIntrest>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileIntrestCacheModel)) {
			return false;
		}

		profileIntrestCacheModel profileIntrestCacheModel =
			(profileIntrestCacheModel)obj;

		if (Id == profileIntrestCacheModel.Id) {
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
		sb.append(", profileId=");
		sb.append(profileId);
		sb.append(", intrest=");
		sb.append(intrest);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public profileIntrest toEntityModel() {
		profileIntrestImpl profileIntrestImpl = new profileIntrestImpl();

		if (uuid == null) {
			profileIntrestImpl.setUuid("");
		}
		else {
			profileIntrestImpl.setUuid(uuid);
		}

		profileIntrestImpl.setId(Id);
		profileIntrestImpl.setGroupId(groupId);
		profileIntrestImpl.setCompanyId(companyId);
		profileIntrestImpl.setUserId(userId);

		if (userName == null) {
			profileIntrestImpl.setUserName("");
		}
		else {
			profileIntrestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileIntrestImpl.setCreateDate(null);
		}
		else {
			profileIntrestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileIntrestImpl.setModifiedDate(null);
		}
		else {
			profileIntrestImpl.setModifiedDate(new Date(modifiedDate));
		}

		profileIntrestImpl.setProfileId(profileId);

		if (intrest == null) {
			profileIntrestImpl.setIntrest("");
		}
		else {
			profileIntrestImpl.setIntrest(intrest);
		}

		profileIntrestImpl.resetOriginalValues();

		return profileIntrestImpl;
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

		profileId = objectInput.readLong();
		intrest = objectInput.readUTF();
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

		objectOutput.writeLong(profileId);

		if (intrest == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(intrest);
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
	public long profileId;
	public String intrest;

}