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
 * This class is a wrapper for {@link profileEducation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileEducation
 * @generated
 */
@ProviderType
public class profileEducationWrapper
	extends BaseModelWrapper<profileEducation>
	implements profileEducation, ModelWrapper<profileEducation> {

	public profileEducationWrapper(profileEducation profileEducation) {
		super(profileEducation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("profileId", getProfileId());
		attributes.put("educationCategory", getEducationCategory());
		attributes.put("degree", getDegree());
		attributes.put("fieldOfStudy", getFieldOfStudy());
		attributes.put("startYear", getStartYear());
		attributes.put("endYear", getEndYear());
		attributes.put("grade", getGrade());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
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

		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		String educationCategory = (String)attributes.get("educationCategory");

		if (educationCategory != null) {
			setEducationCategory(educationCategory);
		}

		String degree = (String)attributes.get("degree");

		if (degree != null) {
			setDegree(degree);
		}

		String fieldOfStudy = (String)attributes.get("fieldOfStudy");

		if (fieldOfStudy != null) {
			setFieldOfStudy(fieldOfStudy);
		}

		String startYear = (String)attributes.get("startYear");

		if (startYear != null) {
			setStartYear(startYear);
		}

		String endYear = (String)attributes.get("endYear");

		if (endYear != null) {
			setEndYear(endYear);
		}

		String grade = (String)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the company ID of this profile education.
	 *
	 * @return the company ID of this profile education
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this profile education.
	 *
	 * @return the create date of this profile education
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the degree of this profile education.
	 *
	 * @return the degree of this profile education
	 */
	@Override
	public String getDegree() {
		return model.getDegree();
	}

	/**
	 * Returns the description of this profile education.
	 *
	 * @return the description of this profile education
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the education category of this profile education.
	 *
	 * @return the education category of this profile education
	 */
	@Override
	public String getEducationCategory() {
		return model.getEducationCategory();
	}

	/**
	 * Returns the end year of this profile education.
	 *
	 * @return the end year of this profile education
	 */
	@Override
	public String getEndYear() {
		return model.getEndYear();
	}

	/**
	 * Returns the field of study of this profile education.
	 *
	 * @return the field of study of this profile education
	 */
	@Override
	public String getFieldOfStudy() {
		return model.getFieldOfStudy();
	}

	/**
	 * Returns the grade of this profile education.
	 *
	 * @return the grade of this profile education
	 */
	@Override
	public String getGrade() {
		return model.getGrade();
	}

	/**
	 * Returns the group ID of this profile education.
	 *
	 * @return the group ID of this profile education
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this profile education.
	 *
	 * @return the ID of this profile education
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this profile education.
	 *
	 * @return the modified date of this profile education
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this profile education.
	 *
	 * @return the primary key of this profile education
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile ID of this profile education.
	 *
	 * @return the profile ID of this profile education
	 */
	@Override
	public long getProfileId() {
		return model.getProfileId();
	}

	/**
	 * Returns the start year of this profile education.
	 *
	 * @return the start year of this profile education
	 */
	@Override
	public String getStartYear() {
		return model.getStartYear();
	}

	/**
	 * Returns the user ID of this profile education.
	 *
	 * @return the user ID of this profile education
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile education.
	 *
	 * @return the user name of this profile education
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile education.
	 *
	 * @return the user uuid of this profile education
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile education.
	 *
	 * @return the uuid of this profile education
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
	 * Sets the company ID of this profile education.
	 *
	 * @param companyId the company ID of this profile education
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this profile education.
	 *
	 * @param createDate the create date of this profile education
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the degree of this profile education.
	 *
	 * @param degree the degree of this profile education
	 */
	@Override
	public void setDegree(String degree) {
		model.setDegree(degree);
	}

	/**
	 * Sets the description of this profile education.
	 *
	 * @param description the description of this profile education
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the education category of this profile education.
	 *
	 * @param educationCategory the education category of this profile education
	 */
	@Override
	public void setEducationCategory(String educationCategory) {
		model.setEducationCategory(educationCategory);
	}

	/**
	 * Sets the end year of this profile education.
	 *
	 * @param endYear the end year of this profile education
	 */
	@Override
	public void setEndYear(String endYear) {
		model.setEndYear(endYear);
	}

	/**
	 * Sets the field of study of this profile education.
	 *
	 * @param fieldOfStudy the field of study of this profile education
	 */
	@Override
	public void setFieldOfStudy(String fieldOfStudy) {
		model.setFieldOfStudy(fieldOfStudy);
	}

	/**
	 * Sets the grade of this profile education.
	 *
	 * @param grade the grade of this profile education
	 */
	@Override
	public void setGrade(String grade) {
		model.setGrade(grade);
	}

	/**
	 * Sets the group ID of this profile education.
	 *
	 * @param groupId the group ID of this profile education
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this profile education.
	 *
	 * @param Id the ID of this profile education
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the modified date of this profile education.
	 *
	 * @param modifiedDate the modified date of this profile education
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this profile education.
	 *
	 * @param primaryKey the primary key of this profile education
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile ID of this profile education.
	 *
	 * @param profileId the profile ID of this profile education
	 */
	@Override
	public void setProfileId(long profileId) {
		model.setProfileId(profileId);
	}

	/**
	 * Sets the start year of this profile education.
	 *
	 * @param startYear the start year of this profile education
	 */
	@Override
	public void setStartYear(String startYear) {
		model.setStartYear(startYear);
	}

	/**
	 * Sets the user ID of this profile education.
	 *
	 * @param userId the user ID of this profile education
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile education.
	 *
	 * @param userName the user name of this profile education
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile education.
	 *
	 * @param userUuid the user uuid of this profile education
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile education.
	 *
	 * @param uuid the uuid of this profile education
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
	protected profileEducationWrapper wrap(profileEducation profileEducation) {
		return new profileEducationWrapper(profileEducation);
	}

}