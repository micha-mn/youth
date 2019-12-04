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

import basic.model.profileLicensesCertifications;

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
 * The cache model class for representing profileLicensesCertifications in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileLicensesCertificationsCacheModel
	implements CacheModel<profileLicensesCertifications>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileLicensesCertificationsCacheModel)) {
			return false;
		}

		profileLicensesCertificationsCacheModel
			profileLicensesCertificationsCacheModel =
				(profileLicensesCertificationsCacheModel)obj;

		if (Id == profileLicensesCertificationsCacheModel.Id) {
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", issuingOrganization=");
		sb.append(issuingOrganization);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", credentialID=");
		sb.append(credentialID);
		sb.append(", credentialURL=");
		sb.append(credentialURL);
		sb.append(", notExpire=");
		sb.append(notExpire);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public profileLicensesCertifications toEntityModel() {
		profileLicensesCertificationsImpl profileLicensesCertificationsImpl =
			new profileLicensesCertificationsImpl();

		if (uuid == null) {
			profileLicensesCertificationsImpl.setUuid("");
		}
		else {
			profileLicensesCertificationsImpl.setUuid(uuid);
		}

		profileLicensesCertificationsImpl.setId(Id);
		profileLicensesCertificationsImpl.setGroupId(groupId);
		profileLicensesCertificationsImpl.setCompanyId(companyId);
		profileLicensesCertificationsImpl.setUserId(userId);

		if (userName == null) {
			profileLicensesCertificationsImpl.setUserName("");
		}
		else {
			profileLicensesCertificationsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileLicensesCertificationsImpl.setCreateDate(null);
		}
		else {
			profileLicensesCertificationsImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileLicensesCertificationsImpl.setModifiedDate(null);
		}
		else {
			profileLicensesCertificationsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		profileLicensesCertificationsImpl.setProfileId(profileId);

		if (name == null) {
			profileLicensesCertificationsImpl.setName("");
		}
		else {
			profileLicensesCertificationsImpl.setName(name);
		}

		if (issuingOrganization == null) {
			profileLicensesCertificationsImpl.setIssuingOrganization("");
		}
		else {
			profileLicensesCertificationsImpl.setIssuingOrganization(
				issuingOrganization);
		}

		if (issueDate == Long.MIN_VALUE) {
			profileLicensesCertificationsImpl.setIssueDate(null);
		}
		else {
			profileLicensesCertificationsImpl.setIssueDate(new Date(issueDate));
		}

		if (expirationDate == Long.MIN_VALUE) {
			profileLicensesCertificationsImpl.setExpirationDate(null);
		}
		else {
			profileLicensesCertificationsImpl.setExpirationDate(
				new Date(expirationDate));
		}

		profileLicensesCertificationsImpl.setCredentialID(credentialID);

		if (credentialURL == null) {
			profileLicensesCertificationsImpl.setCredentialURL("");
		}
		else {
			profileLicensesCertificationsImpl.setCredentialURL(credentialURL);
		}

		profileLicensesCertificationsImpl.setNotExpire(notExpire);

		profileLicensesCertificationsImpl.resetOriginalValues();

		return profileLicensesCertificationsImpl;
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
		name = objectInput.readUTF();
		issuingOrganization = objectInput.readUTF();
		issueDate = objectInput.readLong();
		expirationDate = objectInput.readLong();

		credentialID = objectInput.readLong();
		credentialURL = objectInput.readUTF();

		notExpire = objectInput.readBoolean();
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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (issuingOrganization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(issuingOrganization);
		}

		objectOutput.writeLong(issueDate);
		objectOutput.writeLong(expirationDate);

		objectOutput.writeLong(credentialID);

		if (credentialURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(credentialURL);
		}

		objectOutput.writeBoolean(notExpire);
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
	public String name;
	public String issuingOrganization;
	public long issueDate;
	public long expirationDate;
	public long credentialID;
	public String credentialURL;
	public boolean notExpire;

}