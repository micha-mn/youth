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

import basic.model.profileEducation;

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
 * The cache model class for representing profileEducation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileEducationCacheModel
	implements CacheModel<profileEducation>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileEducationCacheModel)) {
			return false;
		}

		profileEducationCacheModel profileEducationCacheModel =
			(profileEducationCacheModel)obj;

		if (Id == profileEducationCacheModel.Id) {
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
		StringBundler sb = new StringBundler(33);

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
		sb.append(", educationCategory=");
		sb.append(educationCategory);
		sb.append(", degree=");
		sb.append(degree);
		sb.append(", fieldOfStudy=");
		sb.append(fieldOfStudy);
		sb.append(", startYear=");
		sb.append(startYear);
		sb.append(", endYear=");
		sb.append(endYear);
		sb.append(", grade=");
		sb.append(grade);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public profileEducation toEntityModel() {
		profileEducationImpl profileEducationImpl = new profileEducationImpl();

		if (uuid == null) {
			profileEducationImpl.setUuid("");
		}
		else {
			profileEducationImpl.setUuid(uuid);
		}

		profileEducationImpl.setId(Id);
		profileEducationImpl.setGroupId(groupId);
		profileEducationImpl.setCompanyId(companyId);
		profileEducationImpl.setUserId(userId);

		if (userName == null) {
			profileEducationImpl.setUserName("");
		}
		else {
			profileEducationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileEducationImpl.setCreateDate(null);
		}
		else {
			profileEducationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileEducationImpl.setModifiedDate(null);
		}
		else {
			profileEducationImpl.setModifiedDate(new Date(modifiedDate));
		}

		profileEducationImpl.setProfileId(profileId);

		if (educationCategory == null) {
			profileEducationImpl.setEducationCategory("");
		}
		else {
			profileEducationImpl.setEducationCategory(educationCategory);
		}

		if (degree == null) {
			profileEducationImpl.setDegree("");
		}
		else {
			profileEducationImpl.setDegree(degree);
		}

		if (fieldOfStudy == null) {
			profileEducationImpl.setFieldOfStudy("");
		}
		else {
			profileEducationImpl.setFieldOfStudy(fieldOfStudy);
		}

		if (startYear == null) {
			profileEducationImpl.setStartYear("");
		}
		else {
			profileEducationImpl.setStartYear(startYear);
		}

		if (endYear == null) {
			profileEducationImpl.setEndYear("");
		}
		else {
			profileEducationImpl.setEndYear(endYear);
		}

		if (grade == null) {
			profileEducationImpl.setGrade("");
		}
		else {
			profileEducationImpl.setGrade(grade);
		}

		if (description == null) {
			profileEducationImpl.setDescription("");
		}
		else {
			profileEducationImpl.setDescription(description);
		}

		profileEducationImpl.resetOriginalValues();

		return profileEducationImpl;
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
		educationCategory = objectInput.readUTF();
		degree = objectInput.readUTF();
		fieldOfStudy = objectInput.readUTF();
		startYear = objectInput.readUTF();
		endYear = objectInput.readUTF();
		grade = objectInput.readUTF();
		description = objectInput.readUTF();
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

		if (educationCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(educationCategory);
		}

		if (degree == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(degree);
		}

		if (fieldOfStudy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldOfStudy);
		}

		if (startYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startYear);
		}

		if (endYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endYear);
		}

		if (grade == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(grade);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
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
	public String educationCategory;
	public String degree;
	public String fieldOfStudy;
	public String startYear;
	public String endYear;
	public String grade;
	public String description;

}