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

import basic.model.profileWorkExperience;

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
 * The cache model class for representing profileWorkExperience in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileWorkExperienceCacheModel
	implements CacheModel<profileWorkExperience>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileWorkExperienceCacheModel)) {
			return false;
		}

		profileWorkExperienceCacheModel profileWorkExperienceCacheModel =
			(profileWorkExperienceCacheModel)obj;

		if (Id == profileWorkExperienceCacheModel.Id) {
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
		StringBundler sb = new StringBundler(35);

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
		sb.append(", title=");
		sb.append(title);
		sb.append(", company=");
		sb.append(company);
		sb.append(", location=");
		sb.append(location);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", currentWorkStatus=");
		sb.append(currentWorkStatus);
		sb.append(", workExperience=");
		sb.append(workExperience);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public profileWorkExperience toEntityModel() {
		profileWorkExperienceImpl profileWorkExperienceImpl =
			new profileWorkExperienceImpl();

		if (uuid == null) {
			profileWorkExperienceImpl.setUuid("");
		}
		else {
			profileWorkExperienceImpl.setUuid(uuid);
		}

		profileWorkExperienceImpl.setId(Id);
		profileWorkExperienceImpl.setGroupId(groupId);
		profileWorkExperienceImpl.setCompanyId(companyId);
		profileWorkExperienceImpl.setUserId(userId);

		if (userName == null) {
			profileWorkExperienceImpl.setUserName("");
		}
		else {
			profileWorkExperienceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileWorkExperienceImpl.setCreateDate(null);
		}
		else {
			profileWorkExperienceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileWorkExperienceImpl.setModifiedDate(null);
		}
		else {
			profileWorkExperienceImpl.setModifiedDate(new Date(modifiedDate));
		}

		profileWorkExperienceImpl.setProfileId(profileId);

		if (title == null) {
			profileWorkExperienceImpl.setTitle("");
		}
		else {
			profileWorkExperienceImpl.setTitle(title);
		}

		if (company == null) {
			profileWorkExperienceImpl.setCompany("");
		}
		else {
			profileWorkExperienceImpl.setCompany(company);
		}

		if (location == null) {
			profileWorkExperienceImpl.setLocation("");
		}
		else {
			profileWorkExperienceImpl.setLocation(location);
		}

		if (startDate == Long.MIN_VALUE) {
			profileWorkExperienceImpl.setStartDate(null);
		}
		else {
			profileWorkExperienceImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			profileWorkExperienceImpl.setEndDate(null);
		}
		else {
			profileWorkExperienceImpl.setEndDate(new Date(endDate));
		}

		if (description == null) {
			profileWorkExperienceImpl.setDescription("");
		}
		else {
			profileWorkExperienceImpl.setDescription(description);
		}

		if (currentWorkStatus == null) {
			profileWorkExperienceImpl.setCurrentWorkStatus("");
		}
		else {
			profileWorkExperienceImpl.setCurrentWorkStatus(currentWorkStatus);
		}

		if (workExperience == null) {
			profileWorkExperienceImpl.setWorkExperience("");
		}
		else {
			profileWorkExperienceImpl.setWorkExperience(workExperience);
		}

		profileWorkExperienceImpl.resetOriginalValues();

		return profileWorkExperienceImpl;
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
		title = objectInput.readUTF();
		company = objectInput.readUTF();
		location = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		description = objectInput.readUTF();
		currentWorkStatus = objectInput.readUTF();
		workExperience = objectInput.readUTF();
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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (company == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (currentWorkStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentWorkStatus);
		}

		if (workExperience == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workExperience);
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
	public String title;
	public String company;
	public String location;
	public long startDate;
	public long endDate;
	public String description;
	public String currentWorkStatus;
	public String workExperience;

}