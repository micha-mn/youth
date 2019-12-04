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

import basic.model.profileInfo;

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
 * The cache model class for representing profileInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileInfoCacheModel
	implements CacheModel<profileInfo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileInfoCacheModel)) {
			return false;
		}

		profileInfoCacheModel profileInfoCacheModel =
			(profileInfoCacheModel)obj;

		if (id == profileInfoCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", grandfatherName=");
		sb.append(grandfatherName);
		sb.append(", familyName=");
		sb.append(familyName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", primaryMobileNo=");
		sb.append(primaryMobileNo);
		sb.append(", secondaryMobileNo=");
		sb.append(secondaryMobileNo);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", passportId=");
		sb.append(passportId);
		sb.append(", passportExpireDate=");
		sb.append(passportExpireDate);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", currentEducationTrainingStatus=");
		sb.append(currentEducationTrainingStatus);
		sb.append(", countryOfResidence=");
		sb.append(countryOfResidence);
		sb.append(", cityOfResidence=");
		sb.append(cityOfResidence);
		sb.append(", nationalAddress=");
		sb.append(nationalAddress);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", street=");
		sb.append(street);
		sb.append(", state=");
		sb.append(state);
		sb.append(", about=");
		sb.append(about);
		sb.append(", profileimage=");
		sb.append(profileimage);
		sb.append(", universitygeneral=");
		sb.append(universitygeneral);
		sb.append(", currentworkposition=");
		sb.append(currentworkposition);
		sb.append(", currentworklocation=");
		sb.append(currentworklocation);
		sb.append(", educationField=");
		sb.append(educationField);
		sb.append(", isEmailVerified=");
		sb.append(isEmailVerified);
		sb.append(", isMobileVerified=");
		sb.append(isMobileVerified);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public profileInfo toEntityModel() {
		profileInfoImpl profileInfoImpl = new profileInfoImpl();

		if (uuid == null) {
			profileInfoImpl.setUuid("");
		}
		else {
			profileInfoImpl.setUuid(uuid);
		}

		profileInfoImpl.setId(id);
		profileInfoImpl.setGroupId(groupId);
		profileInfoImpl.setCompanyId(companyId);
		profileInfoImpl.setUserId(userId);

		if (userName == null) {
			profileInfoImpl.setUserName("");
		}
		else {
			profileInfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileInfoImpl.setCreateDate(null);
		}
		else {
			profileInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileInfoImpl.setModifiedDate(null);
		}
		else {
			profileInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			profileInfoImpl.setTitle("");
		}
		else {
			profileInfoImpl.setTitle(title);
		}

		if (firstName == null) {
			profileInfoImpl.setFirstName("");
		}
		else {
			profileInfoImpl.setFirstName(firstName);
		}

		if (fatherName == null) {
			profileInfoImpl.setFatherName("");
		}
		else {
			profileInfoImpl.setFatherName(fatherName);
		}

		if (grandfatherName == null) {
			profileInfoImpl.setGrandfatherName("");
		}
		else {
			profileInfoImpl.setGrandfatherName(grandfatherName);
		}

		if (familyName == null) {
			profileInfoImpl.setFamilyName("");
		}
		else {
			profileInfoImpl.setFamilyName(familyName);
		}

		if (email == null) {
			profileInfoImpl.setEmail("");
		}
		else {
			profileInfoImpl.setEmail(email);
		}

		profileInfoImpl.setPrimaryMobileNo(primaryMobileNo);
		profileInfoImpl.setSecondaryMobileNo(secondaryMobileNo);

		if (gender == null) {
			profileInfoImpl.setGender("");
		}
		else {
			profileInfoImpl.setGender(gender);
		}

		if (nationality == null) {
			profileInfoImpl.setNationality("");
		}
		else {
			profileInfoImpl.setNationality(nationality);
		}

		profileInfoImpl.setNationalId(nationalId);
		profileInfoImpl.setPassportId(passportId);

		if (passportExpireDate == Long.MIN_VALUE) {
			profileInfoImpl.setPassportExpireDate(null);
		}
		else {
			profileInfoImpl.setPassportExpireDate(new Date(passportExpireDate));
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			profileInfoImpl.setDateOfBirth(null);
		}
		else {
			profileInfoImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (currentEducationTrainingStatus == null) {
			profileInfoImpl.setCurrentEducationTrainingStatus("");
		}
		else {
			profileInfoImpl.setCurrentEducationTrainingStatus(
				currentEducationTrainingStatus);
		}

		if (countryOfResidence == null) {
			profileInfoImpl.setCountryOfResidence("");
		}
		else {
			profileInfoImpl.setCountryOfResidence(countryOfResidence);
		}

		if (cityOfResidence == null) {
			profileInfoImpl.setCityOfResidence("");
		}
		else {
			profileInfoImpl.setCityOfResidence(cityOfResidence);
		}

		if (nationalAddress == null) {
			profileInfoImpl.setNationalAddress("");
		}
		else {
			profileInfoImpl.setNationalAddress(nationalAddress);
		}

		if (postalCode == null) {
			profileInfoImpl.setPostalCode("");
		}
		else {
			profileInfoImpl.setPostalCode(postalCode);
		}

		if (street == null) {
			profileInfoImpl.setStreet("");
		}
		else {
			profileInfoImpl.setStreet(street);
		}

		if (state == null) {
			profileInfoImpl.setState("");
		}
		else {
			profileInfoImpl.setState(state);
		}

		if (about == null) {
			profileInfoImpl.setAbout("");
		}
		else {
			profileInfoImpl.setAbout(about);
		}

		if (profileimage == null) {
			profileInfoImpl.setProfileimage("");
		}
		else {
			profileInfoImpl.setProfileimage(profileimage);
		}

		if (universitygeneral == null) {
			profileInfoImpl.setUniversitygeneral("");
		}
		else {
			profileInfoImpl.setUniversitygeneral(universitygeneral);
		}

		if (currentworkposition == null) {
			profileInfoImpl.setCurrentworkposition("");
		}
		else {
			profileInfoImpl.setCurrentworkposition(currentworkposition);
		}

		if (currentworklocation == null) {
			profileInfoImpl.setCurrentworklocation("");
		}
		else {
			profileInfoImpl.setCurrentworklocation(currentworklocation);
		}

		if (educationField == null) {
			profileInfoImpl.setEducationField("");
		}
		else {
			profileInfoImpl.setEducationField(educationField);
		}

		if (isEmailVerified == null) {
			profileInfoImpl.setIsEmailVerified("");
		}
		else {
			profileInfoImpl.setIsEmailVerified(isEmailVerified);
		}

		if (isMobileVerified == null) {
			profileInfoImpl.setIsMobileVerified("");
		}
		else {
			profileInfoImpl.setIsMobileVerified(isMobileVerified);
		}

		profileInfoImpl.resetOriginalValues();

		return profileInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		firstName = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		grandfatherName = objectInput.readUTF();
		familyName = objectInput.readUTF();
		email = objectInput.readUTF();

		primaryMobileNo = objectInput.readLong();

		secondaryMobileNo = objectInput.readLong();
		gender = objectInput.readUTF();
		nationality = objectInput.readUTF();

		nationalId = objectInput.readLong();

		passportId = objectInput.readLong();
		passportExpireDate = objectInput.readLong();
		dateOfBirth = objectInput.readLong();
		currentEducationTrainingStatus = objectInput.readUTF();
		countryOfResidence = objectInput.readUTF();
		cityOfResidence = objectInput.readUTF();
		nationalAddress = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		street = objectInput.readUTF();
		state = objectInput.readUTF();
		about = objectInput.readUTF();
		profileimage = objectInput.readUTF();
		universitygeneral = objectInput.readUTF();
		currentworkposition = objectInput.readUTF();
		currentworklocation = objectInput.readUTF();
		educationField = objectInput.readUTF();
		isEmailVerified = objectInput.readUTF();
		isMobileVerified = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (fatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName);
		}

		if (grandfatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(grandfatherName);
		}

		if (familyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(familyName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(primaryMobileNo);

		objectOutput.writeLong(secondaryMobileNo);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		objectOutput.writeLong(nationalId);

		objectOutput.writeLong(passportId);
		objectOutput.writeLong(passportExpireDate);
		objectOutput.writeLong(dateOfBirth);

		if (currentEducationTrainingStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentEducationTrainingStatus);
		}

		if (countryOfResidence == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(countryOfResidence);
		}

		if (cityOfResidence == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityOfResidence);
		}

		if (nationalAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalAddress);
		}

		if (postalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		if (street == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(street);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (about == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(about);
		}

		if (profileimage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(profileimage);
		}

		if (universitygeneral == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(universitygeneral);
		}

		if (currentworkposition == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentworkposition);
		}

		if (currentworklocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentworklocation);
		}

		if (educationField == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(educationField);
		}

		if (isEmailVerified == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(isEmailVerified);
		}

		if (isMobileVerified == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(isMobileVerified);
		}
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String firstName;
	public String fatherName;
	public String grandfatherName;
	public String familyName;
	public String email;
	public long primaryMobileNo;
	public long secondaryMobileNo;
	public String gender;
	public String nationality;
	public long nationalId;
	public long passportId;
	public long passportExpireDate;
	public long dateOfBirth;
	public String currentEducationTrainingStatus;
	public String countryOfResidence;
	public String cityOfResidence;
	public String nationalAddress;
	public String postalCode;
	public String street;
	public String state;
	public String about;
	public String profileimage;
	public String universitygeneral;
	public String currentworkposition;
	public String currentworklocation;
	public String educationField;
	public String isEmailVerified;
	public String isMobileVerified;

}