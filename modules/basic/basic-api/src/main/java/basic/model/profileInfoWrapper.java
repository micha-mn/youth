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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link profileInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileInfo
 * @generated
 */
@ProviderType
public class profileInfoWrapper
	extends BaseModelWrapper<profileInfo>
	implements profileInfo, ModelWrapper<profileInfo> {

	public profileInfoWrapper(profileInfo profileInfo) {
		super(profileInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("firstName", getFirstName());
		attributes.put("fatherName", getFatherName());
		attributes.put("grandfatherName", getGrandfatherName());
		attributes.put("familyName", getFamilyName());
		attributes.put("email", getEmail());
		attributes.put("primaryMobileNo", getPrimaryMobileNo());
		attributes.put("secondaryMobileNo", getSecondaryMobileNo());
		attributes.put("gender", getGender());
		attributes.put("nationality", getNationality());
		attributes.put("nationalId", getNationalId());
		attributes.put("passportId", getPassportId());
		attributes.put("passportExpireDate", getPassportExpireDate());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put(
			"currentEducationTrainingStatus",
			getCurrentEducationTrainingStatus());
		attributes.put("countryOfResidence", getCountryOfResidence());
		attributes.put("cityOfResidence", getCityOfResidence());
		attributes.put("nationalAddress", getNationalAddress());
		attributes.put("postalCode", getPostalCode());
		attributes.put("street", getStreet());
		attributes.put("state", getState());
		attributes.put("about", getAbout());
		attributes.put("profileimage", getProfileimage());
		attributes.put("universitygeneral", getUniversitygeneral());
		attributes.put("currentworkposition", getCurrentworkposition());
		attributes.put("currentworklocation", getCurrentworklocation());
		attributes.put("educationField", getEducationField());
		attributes.put("isEmailVerified", getIsEmailVerified());
		attributes.put("isMobileVerified", getIsMobileVerified());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String grandfatherName = (String)attributes.get("grandfatherName");

		if (grandfatherName != null) {
			setGrandfatherName(grandfatherName);
		}

		String familyName = (String)attributes.get("familyName");

		if (familyName != null) {
			setFamilyName(familyName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long primaryMobileNo = (Long)attributes.get("primaryMobileNo");

		if (primaryMobileNo != null) {
			setPrimaryMobileNo(primaryMobileNo);
		}

		Long secondaryMobileNo = (Long)attributes.get("secondaryMobileNo");

		if (secondaryMobileNo != null) {
			setSecondaryMobileNo(secondaryMobileNo);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long passportId = (Long)attributes.get("passportId");

		if (passportId != null) {
			setPassportId(passportId);
		}

		Date passportExpireDate = (Date)attributes.get("passportExpireDate");

		if (passportExpireDate != null) {
			setPassportExpireDate(passportExpireDate);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String currentEducationTrainingStatus = (String)attributes.get(
			"currentEducationTrainingStatus");

		if (currentEducationTrainingStatus != null) {
			setCurrentEducationTrainingStatus(currentEducationTrainingStatus);
		}

		String countryOfResidence = (String)attributes.get(
			"countryOfResidence");

		if (countryOfResidence != null) {
			setCountryOfResidence(countryOfResidence);
		}

		String cityOfResidence = (String)attributes.get("cityOfResidence");

		if (cityOfResidence != null) {
			setCityOfResidence(cityOfResidence);
		}

		String nationalAddress = (String)attributes.get("nationalAddress");

		if (nationalAddress != null) {
			setNationalAddress(nationalAddress);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String about = (String)attributes.get("about");

		if (about != null) {
			setAbout(about);
		}

		String profileimage = (String)attributes.get("profileimage");

		if (profileimage != null) {
			setProfileimage(profileimage);
		}

		String universitygeneral = (String)attributes.get("universitygeneral");

		if (universitygeneral != null) {
			setUniversitygeneral(universitygeneral);
		}

		String currentworkposition = (String)attributes.get(
			"currentworkposition");

		if (currentworkposition != null) {
			setCurrentworkposition(currentworkposition);
		}

		String currentworklocation = (String)attributes.get(
			"currentworklocation");

		if (currentworklocation != null) {
			setCurrentworklocation(currentworklocation);
		}

		String educationField = (String)attributes.get("educationField");

		if (educationField != null) {
			setEducationField(educationField);
		}

		String isEmailVerified = (String)attributes.get("isEmailVerified");

		if (isEmailVerified != null) {
			setIsEmailVerified(isEmailVerified);
		}

		String isMobileVerified = (String)attributes.get("isMobileVerified");

		if (isMobileVerified != null) {
			setIsMobileVerified(isMobileVerified);
		}
	}

	/**
	 * Returns the about of this profile info.
	 *
	 * @return the about of this profile info
	 */
	@Override
	public String getAbout() {
		return model.getAbout();
	}

	/**
	 * Returns the city of residence of this profile info.
	 *
	 * @return the city of residence of this profile info
	 */
	@Override
	public String getCityOfResidence() {
		return model.getCityOfResidence();
	}

	/**
	 * Returns the company ID of this profile info.
	 *
	 * @return the company ID of this profile info
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of residence of this profile info.
	 *
	 * @return the country of residence of this profile info
	 */
	@Override
	public String getCountryOfResidence() {
		return model.getCountryOfResidence();
	}

	/**
	 * Returns the create date of this profile info.
	 *
	 * @return the create date of this profile info
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the current education training status of this profile info.
	 *
	 * @return the current education training status of this profile info
	 */
	@Override
	public String getCurrentEducationTrainingStatus() {
		return model.getCurrentEducationTrainingStatus();
	}

	/**
	 * Returns the currentworklocation of this profile info.
	 *
	 * @return the currentworklocation of this profile info
	 */
	@Override
	public String getCurrentworklocation() {
		return model.getCurrentworklocation();
	}

	/**
	 * Returns the currentworkposition of this profile info.
	 *
	 * @return the currentworkposition of this profile info
	 */
	@Override
	public String getCurrentworkposition() {
		return model.getCurrentworkposition();
	}

	/**
	 * Returns the date of birth of this profile info.
	 *
	 * @return the date of birth of this profile info
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the education field of this profile info.
	 *
	 * @return the education field of this profile info
	 */
	@Override
	public String getEducationField() {
		return model.getEducationField();
	}

	/**
	 * Returns the email of this profile info.
	 *
	 * @return the email of this profile info
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the family name of this profile info.
	 *
	 * @return the family name of this profile info
	 */
	@Override
	public String getFamilyName() {
		return model.getFamilyName();
	}

	/**
	 * Returns the father name of this profile info.
	 *
	 * @return the father name of this profile info
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the first name of this profile info.
	 *
	 * @return the first name of this profile info
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the gender of this profile info.
	 *
	 * @return the gender of this profile info
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the grandfather name of this profile info.
	 *
	 * @return the grandfather name of this profile info
	 */
	@Override
	public String getGrandfatherName() {
		return model.getGrandfatherName();
	}

	/**
	 * Returns the group ID of this profile info.
	 *
	 * @return the group ID of this profile info
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this profile info.
	 *
	 * @return the ID of this profile info
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is email verified of this profile info.
	 *
	 * @return the is email verified of this profile info
	 */
	@Override
	public String getIsEmailVerified() {
		return model.getIsEmailVerified();
	}

	/**
	 * Returns the is mobile verified of this profile info.
	 *
	 * @return the is mobile verified of this profile info
	 */
	@Override
	public String getIsMobileVerified() {
		return model.getIsMobileVerified();
	}

	/**
	 * Returns the modified date of this profile info.
	 *
	 * @return the modified date of this profile info
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national address of this profile info.
	 *
	 * @return the national address of this profile info
	 */
	@Override
	public String getNationalAddress() {
		return model.getNationalAddress();
	}

	/**
	 * Returns the national ID of this profile info.
	 *
	 * @return the national ID of this profile info
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the nationality of this profile info.
	 *
	 * @return the nationality of this profile info
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the passport expire date of this profile info.
	 *
	 * @return the passport expire date of this profile info
	 */
	@Override
	public Date getPassportExpireDate() {
		return model.getPassportExpireDate();
	}

	/**
	 * Returns the passport ID of this profile info.
	 *
	 * @return the passport ID of this profile info
	 */
	@Override
	public long getPassportId() {
		return model.getPassportId();
	}

	/**
	 * Returns the postal code of this profile info.
	 *
	 * @return the postal code of this profile info
	 */
	@Override
	public String getPostalCode() {
		return model.getPostalCode();
	}

	/**
	 * Returns the primary key of this profile info.
	 *
	 * @return the primary key of this profile info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the primary mobile no of this profile info.
	 *
	 * @return the primary mobile no of this profile info
	 */
	@Override
	public long getPrimaryMobileNo() {
		return model.getPrimaryMobileNo();
	}

	/**
	 * Returns the profileimage of this profile info.
	 *
	 * @return the profileimage of this profile info
	 */
	@Override
	public String getProfileimage() {
		return model.getProfileimage();
	}

	/**
	 * Returns the secondary mobile no of this profile info.
	 *
	 * @return the secondary mobile no of this profile info
	 */
	@Override
	public long getSecondaryMobileNo() {
		return model.getSecondaryMobileNo();
	}

	/**
	 * Returns the state of this profile info.
	 *
	 * @return the state of this profile info
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the street of this profile info.
	 *
	 * @return the street of this profile info
	 */
	@Override
	public String getStreet() {
		return model.getStreet();
	}

	/**
	 * Returns the title of this profile info.
	 *
	 * @return the title of this profile info
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the universitygeneral of this profile info.
	 *
	 * @return the universitygeneral of this profile info
	 */
	@Override
	public String getUniversitygeneral() {
		return model.getUniversitygeneral();
	}

	/**
	 * Returns the user ID of this profile info.
	 *
	 * @return the user ID of this profile info
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile info.
	 *
	 * @return the user name of this profile info
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile info.
	 *
	 * @return the user uuid of this profile info
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile info.
	 *
	 * @return the uuid of this profile info
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the about of this profile info.
	 *
	 * @param about the about of this profile info
	 */
	@Override
	public void setAbout(String about) {
		model.setAbout(about);
	}

	/**
	 * Sets the city of residence of this profile info.
	 *
	 * @param cityOfResidence the city of residence of this profile info
	 */
	@Override
	public void setCityOfResidence(String cityOfResidence) {
		model.setCityOfResidence(cityOfResidence);
	}

	/**
	 * Sets the company ID of this profile info.
	 *
	 * @param companyId the company ID of this profile info
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of residence of this profile info.
	 *
	 * @param countryOfResidence the country of residence of this profile info
	 */
	@Override
	public void setCountryOfResidence(String countryOfResidence) {
		model.setCountryOfResidence(countryOfResidence);
	}

	/**
	 * Sets the create date of this profile info.
	 *
	 * @param createDate the create date of this profile info
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the current education training status of this profile info.
	 *
	 * @param currentEducationTrainingStatus the current education training status of this profile info
	 */
	@Override
	public void setCurrentEducationTrainingStatus(
		String currentEducationTrainingStatus) {

		model.setCurrentEducationTrainingStatus(currentEducationTrainingStatus);
	}

	/**
	 * Sets the currentworklocation of this profile info.
	 *
	 * @param currentworklocation the currentworklocation of this profile info
	 */
	@Override
	public void setCurrentworklocation(String currentworklocation) {
		model.setCurrentworklocation(currentworklocation);
	}

	/**
	 * Sets the currentworkposition of this profile info.
	 *
	 * @param currentworkposition the currentworkposition of this profile info
	 */
	@Override
	public void setCurrentworkposition(String currentworkposition) {
		model.setCurrentworkposition(currentworkposition);
	}

	/**
	 * Sets the date of birth of this profile info.
	 *
	 * @param dateOfBirth the date of birth of this profile info
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the education field of this profile info.
	 *
	 * @param educationField the education field of this profile info
	 */
	@Override
	public void setEducationField(String educationField) {
		model.setEducationField(educationField);
	}

	/**
	 * Sets the email of this profile info.
	 *
	 * @param email the email of this profile info
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the family name of this profile info.
	 *
	 * @param familyName the family name of this profile info
	 */
	@Override
	public void setFamilyName(String familyName) {
		model.setFamilyName(familyName);
	}

	/**
	 * Sets the father name of this profile info.
	 *
	 * @param fatherName the father name of this profile info
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the first name of this profile info.
	 *
	 * @param firstName the first name of this profile info
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the gender of this profile info.
	 *
	 * @param gender the gender of this profile info
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the grandfather name of this profile info.
	 *
	 * @param grandfatherName the grandfather name of this profile info
	 */
	@Override
	public void setGrandfatherName(String grandfatherName) {
		model.setGrandfatherName(grandfatherName);
	}

	/**
	 * Sets the group ID of this profile info.
	 *
	 * @param groupId the group ID of this profile info
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this profile info.
	 *
	 * @param id the ID of this profile info
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the is email verified of this profile info.
	 *
	 * @param isEmailVerified the is email verified of this profile info
	 */
	@Override
	public void setIsEmailVerified(String isEmailVerified) {
		model.setIsEmailVerified(isEmailVerified);
	}

	/**
	 * Sets the is mobile verified of this profile info.
	 *
	 * @param isMobileVerified the is mobile verified of this profile info
	 */
	@Override
	public void setIsMobileVerified(String isMobileVerified) {
		model.setIsMobileVerified(isMobileVerified);
	}

	/**
	 * Sets the modified date of this profile info.
	 *
	 * @param modifiedDate the modified date of this profile info
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national address of this profile info.
	 *
	 * @param nationalAddress the national address of this profile info
	 */
	@Override
	public void setNationalAddress(String nationalAddress) {
		model.setNationalAddress(nationalAddress);
	}

	/**
	 * Sets the national ID of this profile info.
	 *
	 * @param nationalId the national ID of this profile info
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the nationality of this profile info.
	 *
	 * @param nationality the nationality of this profile info
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the passport expire date of this profile info.
	 *
	 * @param passportExpireDate the passport expire date of this profile info
	 */
	@Override
	public void setPassportExpireDate(Date passportExpireDate) {
		model.setPassportExpireDate(passportExpireDate);
	}

	/**
	 * Sets the passport ID of this profile info.
	 *
	 * @param passportId the passport ID of this profile info
	 */
	@Override
	public void setPassportId(long passportId) {
		model.setPassportId(passportId);
	}

	/**
	 * Sets the postal code of this profile info.
	 *
	 * @param postalCode the postal code of this profile info
	 */
	@Override
	public void setPostalCode(String postalCode) {
		model.setPostalCode(postalCode);
	}

	/**
	 * Sets the primary key of this profile info.
	 *
	 * @param primaryKey the primary key of this profile info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the primary mobile no of this profile info.
	 *
	 * @param primaryMobileNo the primary mobile no of this profile info
	 */
	@Override
	public void setPrimaryMobileNo(long primaryMobileNo) {
		model.setPrimaryMobileNo(primaryMobileNo);
	}

	/**
	 * Sets the profileimage of this profile info.
	 *
	 * @param profileimage the profileimage of this profile info
	 */
	@Override
	public void setProfileimage(String profileimage) {
		model.setProfileimage(profileimage);
	}

	/**
	 * Sets the secondary mobile no of this profile info.
	 *
	 * @param secondaryMobileNo the secondary mobile no of this profile info
	 */
	@Override
	public void setSecondaryMobileNo(long secondaryMobileNo) {
		model.setSecondaryMobileNo(secondaryMobileNo);
	}

	/**
	 * Sets the state of this profile info.
	 *
	 * @param state the state of this profile info
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the street of this profile info.
	 *
	 * @param street the street of this profile info
	 */
	@Override
	public void setStreet(String street) {
		model.setStreet(street);
	}

	/**
	 * Sets the title of this profile info.
	 *
	 * @param title the title of this profile info
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the universitygeneral of this profile info.
	 *
	 * @param universitygeneral the universitygeneral of this profile info
	 */
	@Override
	public void setUniversitygeneral(String universitygeneral) {
		model.setUniversitygeneral(universitygeneral);
	}

	/**
	 * Sets the user ID of this profile info.
	 *
	 * @param userId the user ID of this profile info
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile info.
	 *
	 * @param userName the user name of this profile info
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile info.
	 *
	 * @param userUuid the user uuid of this profile info
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile info.
	 *
	 * @param uuid the uuid of this profile info
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected profileInfoWrapper wrap(profileInfo profileInfo) {
		return new profileInfoWrapper(profileInfo);
	}

}