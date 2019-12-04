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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the profileInfo service. Represents a row in the &quot;profileInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>basic.model.impl.profileInfoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>basic.model.impl.profileInfoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileInfo
 * @generated
 */
@ProviderType
public interface profileInfoModel
	extends BaseModel<profileInfo>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a profile info model instance should use the {@link profileInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this profile info.
	 *
	 * @return the primary key of this profile info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this profile info.
	 *
	 * @param primaryKey the primary key of this profile info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this profile info.
	 *
	 * @return the uuid of this profile info
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this profile info.
	 *
	 * @param uuid the uuid of this profile info
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this profile info.
	 *
	 * @return the ID of this profile info
	 */
	public long getId();

	/**
	 * Sets the ID of this profile info.
	 *
	 * @param id the ID of this profile info
	 */
	public void setId(long id);

	/**
	 * Returns the group ID of this profile info.
	 *
	 * @return the group ID of this profile info
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this profile info.
	 *
	 * @param groupId the group ID of this profile info
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this profile info.
	 *
	 * @return the company ID of this profile info
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this profile info.
	 *
	 * @param companyId the company ID of this profile info
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this profile info.
	 *
	 * @return the user ID of this profile info
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this profile info.
	 *
	 * @param userId the user ID of this profile info
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this profile info.
	 *
	 * @return the user uuid of this profile info
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this profile info.
	 *
	 * @param userUuid the user uuid of this profile info
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this profile info.
	 *
	 * @return the user name of this profile info
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this profile info.
	 *
	 * @param userName the user name of this profile info
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this profile info.
	 *
	 * @return the create date of this profile info
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this profile info.
	 *
	 * @param createDate the create date of this profile info
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this profile info.
	 *
	 * @return the modified date of this profile info
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this profile info.
	 *
	 * @param modifiedDate the modified date of this profile info
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this profile info.
	 *
	 * @return the title of this profile info
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this profile info.
	 *
	 * @param title the title of this profile info
	 */
	public void setTitle(String title);

	/**
	 * Returns the first name of this profile info.
	 *
	 * @return the first name of this profile info
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this profile info.
	 *
	 * @param firstName the first name of this profile info
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the father name of this profile info.
	 *
	 * @return the father name of this profile info
	 */
	@AutoEscape
	public String getFatherName();

	/**
	 * Sets the father name of this profile info.
	 *
	 * @param fatherName the father name of this profile info
	 */
	public void setFatherName(String fatherName);

	/**
	 * Returns the grandfather name of this profile info.
	 *
	 * @return the grandfather name of this profile info
	 */
	@AutoEscape
	public String getGrandfatherName();

	/**
	 * Sets the grandfather name of this profile info.
	 *
	 * @param grandfatherName the grandfather name of this profile info
	 */
	public void setGrandfatherName(String grandfatherName);

	/**
	 * Returns the family name of this profile info.
	 *
	 * @return the family name of this profile info
	 */
	@AutoEscape
	public String getFamilyName();

	/**
	 * Sets the family name of this profile info.
	 *
	 * @param familyName the family name of this profile info
	 */
	public void setFamilyName(String familyName);

	/**
	 * Returns the email of this profile info.
	 *
	 * @return the email of this profile info
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this profile info.
	 *
	 * @param email the email of this profile info
	 */
	public void setEmail(String email);

	/**
	 * Returns the primary mobile no of this profile info.
	 *
	 * @return the primary mobile no of this profile info
	 */
	public long getPrimaryMobileNo();

	/**
	 * Sets the primary mobile no of this profile info.
	 *
	 * @param primaryMobileNo the primary mobile no of this profile info
	 */
	public void setPrimaryMobileNo(long primaryMobileNo);

	/**
	 * Returns the secondary mobile no of this profile info.
	 *
	 * @return the secondary mobile no of this profile info
	 */
	public long getSecondaryMobileNo();

	/**
	 * Sets the secondary mobile no of this profile info.
	 *
	 * @param secondaryMobileNo the secondary mobile no of this profile info
	 */
	public void setSecondaryMobileNo(long secondaryMobileNo);

	/**
	 * Returns the gender of this profile info.
	 *
	 * @return the gender of this profile info
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this profile info.
	 *
	 * @param gender the gender of this profile info
	 */
	public void setGender(String gender);

	/**
	 * Returns the nationality of this profile info.
	 *
	 * @return the nationality of this profile info
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this profile info.
	 *
	 * @param nationality the nationality of this profile info
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the national ID of this profile info.
	 *
	 * @return the national ID of this profile info
	 */
	public long getNationalId();

	/**
	 * Sets the national ID of this profile info.
	 *
	 * @param nationalId the national ID of this profile info
	 */
	public void setNationalId(long nationalId);

	/**
	 * Returns the passport ID of this profile info.
	 *
	 * @return the passport ID of this profile info
	 */
	public long getPassportId();

	/**
	 * Sets the passport ID of this profile info.
	 *
	 * @param passportId the passport ID of this profile info
	 */
	public void setPassportId(long passportId);

	/**
	 * Returns the passport expire date of this profile info.
	 *
	 * @return the passport expire date of this profile info
	 */
	public Date getPassportExpireDate();

	/**
	 * Sets the passport expire date of this profile info.
	 *
	 * @param passportExpireDate the passport expire date of this profile info
	 */
	public void setPassportExpireDate(Date passportExpireDate);

	/**
	 * Returns the date of birth of this profile info.
	 *
	 * @return the date of birth of this profile info
	 */
	public Date getDateOfBirth();

	/**
	 * Sets the date of birth of this profile info.
	 *
	 * @param dateOfBirth the date of birth of this profile info
	 */
	public void setDateOfBirth(Date dateOfBirth);

	/**
	 * Returns the current education training status of this profile info.
	 *
	 * @return the current education training status of this profile info
	 */
	@AutoEscape
	public String getCurrentEducationTrainingStatus();

	/**
	 * Sets the current education training status of this profile info.
	 *
	 * @param currentEducationTrainingStatus the current education training status of this profile info
	 */
	public void setCurrentEducationTrainingStatus(
		String currentEducationTrainingStatus);

	/**
	 * Returns the country of residence of this profile info.
	 *
	 * @return the country of residence of this profile info
	 */
	@AutoEscape
	public String getCountryOfResidence();

	/**
	 * Sets the country of residence of this profile info.
	 *
	 * @param countryOfResidence the country of residence of this profile info
	 */
	public void setCountryOfResidence(String countryOfResidence);

	/**
	 * Returns the city of residence of this profile info.
	 *
	 * @return the city of residence of this profile info
	 */
	@AutoEscape
	public String getCityOfResidence();

	/**
	 * Sets the city of residence of this profile info.
	 *
	 * @param cityOfResidence the city of residence of this profile info
	 */
	public void setCityOfResidence(String cityOfResidence);

	/**
	 * Returns the national address of this profile info.
	 *
	 * @return the national address of this profile info
	 */
	@AutoEscape
	public String getNationalAddress();

	/**
	 * Sets the national address of this profile info.
	 *
	 * @param nationalAddress the national address of this profile info
	 */
	public void setNationalAddress(String nationalAddress);

	/**
	 * Returns the postal code of this profile info.
	 *
	 * @return the postal code of this profile info
	 */
	@AutoEscape
	public String getPostalCode();

	/**
	 * Sets the postal code of this profile info.
	 *
	 * @param postalCode the postal code of this profile info
	 */
	public void setPostalCode(String postalCode);

	/**
	 * Returns the street of this profile info.
	 *
	 * @return the street of this profile info
	 */
	@AutoEscape
	public String getStreet();

	/**
	 * Sets the street of this profile info.
	 *
	 * @param street the street of this profile info
	 */
	public void setStreet(String street);

	/**
	 * Returns the state of this profile info.
	 *
	 * @return the state of this profile info
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this profile info.
	 *
	 * @param state the state of this profile info
	 */
	public void setState(String state);

	/**
	 * Returns the about of this profile info.
	 *
	 * @return the about of this profile info
	 */
	@AutoEscape
	public String getAbout();

	/**
	 * Sets the about of this profile info.
	 *
	 * @param about the about of this profile info
	 */
	public void setAbout(String about);

	/**
	 * Returns the profileimage of this profile info.
	 *
	 * @return the profileimage of this profile info
	 */
	@AutoEscape
	public String getProfileimage();

	/**
	 * Sets the profileimage of this profile info.
	 *
	 * @param profileimage the profileimage of this profile info
	 */
	public void setProfileimage(String profileimage);

	/**
	 * Returns the universitygeneral of this profile info.
	 *
	 * @return the universitygeneral of this profile info
	 */
	@AutoEscape
	public String getUniversitygeneral();

	/**
	 * Sets the universitygeneral of this profile info.
	 *
	 * @param universitygeneral the universitygeneral of this profile info
	 */
	public void setUniversitygeneral(String universitygeneral);

	/**
	 * Returns the currentworkposition of this profile info.
	 *
	 * @return the currentworkposition of this profile info
	 */
	@AutoEscape
	public String getCurrentworkposition();

	/**
	 * Sets the currentworkposition of this profile info.
	 *
	 * @param currentworkposition the currentworkposition of this profile info
	 */
	public void setCurrentworkposition(String currentworkposition);

	/**
	 * Returns the currentworklocation of this profile info.
	 *
	 * @return the currentworklocation of this profile info
	 */
	@AutoEscape
	public String getCurrentworklocation();

	/**
	 * Sets the currentworklocation of this profile info.
	 *
	 * @param currentworklocation the currentworklocation of this profile info
	 */
	public void setCurrentworklocation(String currentworklocation);

	/**
	 * Returns the education field of this profile info.
	 *
	 * @return the education field of this profile info
	 */
	@AutoEscape
	public String getEducationField();

	/**
	 * Sets the education field of this profile info.
	 *
	 * @param educationField the education field of this profile info
	 */
	public void setEducationField(String educationField);

	/**
	 * Returns the is email verified of this profile info.
	 *
	 * @return the is email verified of this profile info
	 */
	@AutoEscape
	public String getIsEmailVerified();

	/**
	 * Sets the is email verified of this profile info.
	 *
	 * @param isEmailVerified the is email verified of this profile info
	 */
	public void setIsEmailVerified(String isEmailVerified);

	/**
	 * Returns the is mobile verified of this profile info.
	 *
	 * @return the is mobile verified of this profile info
	 */
	@AutoEscape
	public String getIsMobileVerified();

	/**
	 * Sets the is mobile verified of this profile info.
	 *
	 * @param isMobileVerified the is mobile verified of this profile info
	 */
	public void setIsMobileVerified(String isMobileVerified);

}