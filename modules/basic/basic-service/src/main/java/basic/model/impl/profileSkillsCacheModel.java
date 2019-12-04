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

import basic.model.profileSkills;

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
 * The cache model class for representing profileSkills in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileSkillsCacheModel
	implements CacheModel<profileSkills>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileSkillsCacheModel)) {
			return false;
		}

		profileSkillsCacheModel profileSkillsCacheModel =
			(profileSkillsCacheModel)obj;

		if (Id == profileSkillsCacheModel.Id) {
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
		sb.append(", skill=");
		sb.append(skill);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public profileSkills toEntityModel() {
		profileSkillsImpl profileSkillsImpl = new profileSkillsImpl();

		if (uuid == null) {
			profileSkillsImpl.setUuid("");
		}
		else {
			profileSkillsImpl.setUuid(uuid);
		}

		profileSkillsImpl.setId(Id);
		profileSkillsImpl.setGroupId(groupId);
		profileSkillsImpl.setCompanyId(companyId);
		profileSkillsImpl.setUserId(userId);

		if (userName == null) {
			profileSkillsImpl.setUserName("");
		}
		else {
			profileSkillsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileSkillsImpl.setCreateDate(null);
		}
		else {
			profileSkillsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileSkillsImpl.setModifiedDate(null);
		}
		else {
			profileSkillsImpl.setModifiedDate(new Date(modifiedDate));
		}

		profileSkillsImpl.setProfileId(profileId);

		if (skill == null) {
			profileSkillsImpl.setSkill("");
		}
		else {
			profileSkillsImpl.setSkill(skill);
		}

		profileSkillsImpl.resetOriginalValues();

		return profileSkillsImpl;
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
		skill = objectInput.readUTF();
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

		if (skill == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skill);
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
	public String skill;

}