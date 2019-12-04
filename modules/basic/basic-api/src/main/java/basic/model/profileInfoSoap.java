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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link basic.service.http.profileInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileInfoSoap implements Serializable {

	public static profileInfoSoap toSoapModel(profileInfo model) {
		profileInfoSoap soapModel = new profileInfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setFatherName(model.getFatherName());
		soapModel.setGrandfatherName(model.getGrandfatherName());
		soapModel.setFamilyName(model.getFamilyName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPrimaryMobileNo(model.getPrimaryMobileNo());
		soapModel.setSecondaryMobileNo(model.getSecondaryMobileNo());
		soapModel.setGender(model.getGender());
		soapModel.setNationality(model.getNationality());
		soapModel.setNationalId(model.getNationalId());
		soapModel.setPassportId(model.getPassportId());
		soapModel.setPassportExpireDate(model.getPassportExpireDate());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setCurrentEducationTrainingStatus(
			model.getCurrentEducationTrainingStatus());
		soapModel.setCountryOfResidence(model.getCountryOfResidence());
		soapModel.setCityOfResidence(model.getCityOfResidence());
		soapModel.setNationalAddress(model.getNationalAddress());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setStreet(model.getStreet());
		soapModel.setState(model.getState());
		soapModel.setAbout(model.getAbout());
		soapModel.setProfileimage(model.getProfileimage());
		soapModel.setUniversitygeneral(model.getUniversitygeneral());
		soapModel.setCurrentworkposition(model.getCurrentworkposition());
		soapModel.setCurrentworklocation(model.getCurrentworklocation());
		soapModel.setEducationField(model.getEducationField());
		soapModel.setIsEmailVerified(model.getIsEmailVerified());
		soapModel.setIsMobileVerified(model.getIsMobileVerified());

		return soapModel;
	}

	public static profileInfoSoap[] toSoapModels(profileInfo[] models) {
		profileInfoSoap[] soapModels = new profileInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static profileInfoSoap[][] toSoapModels(profileInfo[][] models) {
		profileInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new profileInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new profileInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static profileInfoSoap[] toSoapModels(List<profileInfo> models) {
		List<profileInfoSoap> soapModels = new ArrayList<profileInfoSoap>(
			models.size());

		for (profileInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new profileInfoSoap[soapModels.size()]);
	}

	public profileInfoSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getFatherName() {
		return _fatherName;
	}

	public void setFatherName(String fatherName) {
		_fatherName = fatherName;
	}

	public String getGrandfatherName() {
		return _grandfatherName;
	}

	public void setGrandfatherName(String grandfatherName) {
		_grandfatherName = grandfatherName;
	}

	public String getFamilyName() {
		return _familyName;
	}

	public void setFamilyName(String familyName) {
		_familyName = familyName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getPrimaryMobileNo() {
		return _primaryMobileNo;
	}

	public void setPrimaryMobileNo(long primaryMobileNo) {
		_primaryMobileNo = primaryMobileNo;
	}

	public long getSecondaryMobileNo() {
		return _secondaryMobileNo;
	}

	public void setSecondaryMobileNo(long secondaryMobileNo) {
		_secondaryMobileNo = secondaryMobileNo;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public long getNationalId() {
		return _nationalId;
	}

	public void setNationalId(long nationalId) {
		_nationalId = nationalId;
	}

	public long getPassportId() {
		return _passportId;
	}

	public void setPassportId(long passportId) {
		_passportId = passportId;
	}

	public Date getPassportExpireDate() {
		return _passportExpireDate;
	}

	public void setPassportExpireDate(Date passportExpireDate) {
		_passportExpireDate = passportExpireDate;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public String getCurrentEducationTrainingStatus() {
		return _currentEducationTrainingStatus;
	}

	public void setCurrentEducationTrainingStatus(
		String currentEducationTrainingStatus) {

		_currentEducationTrainingStatus = currentEducationTrainingStatus;
	}

	public String getCountryOfResidence() {
		return _countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		_countryOfResidence = countryOfResidence;
	}

	public String getCityOfResidence() {
		return _cityOfResidence;
	}

	public void setCityOfResidence(String cityOfResidence) {
		_cityOfResidence = cityOfResidence;
	}

	public String getNationalAddress() {
		return _nationalAddress;
	}

	public void setNationalAddress(String nationalAddress) {
		_nationalAddress = nationalAddress;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getAbout() {
		return _about;
	}

	public void setAbout(String about) {
		_about = about;
	}

	public String getProfileimage() {
		return _profileimage;
	}

	public void setProfileimage(String profileimage) {
		_profileimage = profileimage;
	}

	public String getUniversitygeneral() {
		return _universitygeneral;
	}

	public void setUniversitygeneral(String universitygeneral) {
		_universitygeneral = universitygeneral;
	}

	public String getCurrentworkposition() {
		return _currentworkposition;
	}

	public void setCurrentworkposition(String currentworkposition) {
		_currentworkposition = currentworkposition;
	}

	public String getCurrentworklocation() {
		return _currentworklocation;
	}

	public void setCurrentworklocation(String currentworklocation) {
		_currentworklocation = currentworklocation;
	}

	public String getEducationField() {
		return _educationField;
	}

	public void setEducationField(String educationField) {
		_educationField = educationField;
	}

	public String getIsEmailVerified() {
		return _isEmailVerified;
	}

	public void setIsEmailVerified(String isEmailVerified) {
		_isEmailVerified = isEmailVerified;
	}

	public String getIsMobileVerified() {
		return _isMobileVerified;
	}

	public void setIsMobileVerified(String isMobileVerified) {
		_isMobileVerified = isMobileVerified;
	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _firstName;
	private String _fatherName;
	private String _grandfatherName;
	private String _familyName;
	private String _email;
	private long _primaryMobileNo;
	private long _secondaryMobileNo;
	private String _gender;
	private String _nationality;
	private long _nationalId;
	private long _passportId;
	private Date _passportExpireDate;
	private Date _dateOfBirth;
	private String _currentEducationTrainingStatus;
	private String _countryOfResidence;
	private String _cityOfResidence;
	private String _nationalAddress;
	private String _postalCode;
	private String _street;
	private String _state;
	private String _about;
	private String _profileimage;
	private String _universitygeneral;
	private String _currentworkposition;
	private String _currentworklocation;
	private String _educationField;
	private String _isEmailVerified;
	private String _isMobileVerified;

}