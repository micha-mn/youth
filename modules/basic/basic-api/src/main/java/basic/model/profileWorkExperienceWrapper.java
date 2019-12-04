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
 * This class is a wrapper for {@link profileWorkExperience}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileWorkExperience
 * @generated
 */
@ProviderType
public class profileWorkExperienceWrapper
	extends BaseModelWrapper<profileWorkExperience>
	implements profileWorkExperience, ModelWrapper<profileWorkExperience> {

	public profileWorkExperienceWrapper(
		profileWorkExperience profileWorkExperience) {

		super(profileWorkExperience);
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
		attributes.put("title", getTitle());
		attributes.put("company", getCompany());
		attributes.put("location", getLocation());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("description", getDescription());
		attributes.put("currentWorkStatus", getCurrentWorkStatus());
		attributes.put("workExperience", getWorkExperience());

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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String currentWorkStatus = (String)attributes.get("currentWorkStatus");

		if (currentWorkStatus != null) {
			setCurrentWorkStatus(currentWorkStatus);
		}

		String workExperience = (String)attributes.get("workExperience");

		if (workExperience != null) {
			setWorkExperience(workExperience);
		}
	}

	/**
	 * Returns the company of this profile work experience.
	 *
	 * @return the company of this profile work experience
	 */
	@Override
	public String getCompany() {
		return model.getCompany();
	}

	/**
	 * Returns the company ID of this profile work experience.
	 *
	 * @return the company ID of this profile work experience
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this profile work experience.
	 *
	 * @return the create date of this profile work experience
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the current work status of this profile work experience.
	 *
	 * @return the current work status of this profile work experience
	 */
	@Override
	public String getCurrentWorkStatus() {
		return model.getCurrentWorkStatus();
	}

	/**
	 * Returns the description of this profile work experience.
	 *
	 * @return the description of this profile work experience
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this profile work experience.
	 *
	 * @return the end date of this profile work experience
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this profile work experience.
	 *
	 * @return the group ID of this profile work experience
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this profile work experience.
	 *
	 * @return the ID of this profile work experience
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the location of this profile work experience.
	 *
	 * @return the location of this profile work experience
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this profile work experience.
	 *
	 * @return the modified date of this profile work experience
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this profile work experience.
	 *
	 * @return the primary key of this profile work experience
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile ID of this profile work experience.
	 *
	 * @return the profile ID of this profile work experience
	 */
	@Override
	public long getProfileId() {
		return model.getProfileId();
	}

	/**
	 * Returns the start date of this profile work experience.
	 *
	 * @return the start date of this profile work experience
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the title of this profile work experience.
	 *
	 * @return the title of this profile work experience
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this profile work experience.
	 *
	 * @return the user ID of this profile work experience
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile work experience.
	 *
	 * @return the user name of this profile work experience
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile work experience.
	 *
	 * @return the user uuid of this profile work experience
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile work experience.
	 *
	 * @return the uuid of this profile work experience
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work experience of this profile work experience.
	 *
	 * @return the work experience of this profile work experience
	 */
	@Override
	public String getWorkExperience() {
		return model.getWorkExperience();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company of this profile work experience.
	 *
	 * @param company the company of this profile work experience
	 */
	@Override
	public void setCompany(String company) {
		model.setCompany(company);
	}

	/**
	 * Sets the company ID of this profile work experience.
	 *
	 * @param companyId the company ID of this profile work experience
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this profile work experience.
	 *
	 * @param createDate the create date of this profile work experience
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the current work status of this profile work experience.
	 *
	 * @param currentWorkStatus the current work status of this profile work experience
	 */
	@Override
	public void setCurrentWorkStatus(String currentWorkStatus) {
		model.setCurrentWorkStatus(currentWorkStatus);
	}

	/**
	 * Sets the description of this profile work experience.
	 *
	 * @param description the description of this profile work experience
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this profile work experience.
	 *
	 * @param endDate the end date of this profile work experience
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this profile work experience.
	 *
	 * @param groupId the group ID of this profile work experience
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this profile work experience.
	 *
	 * @param Id the ID of this profile work experience
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the location of this profile work experience.
	 *
	 * @param location the location of this profile work experience
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this profile work experience.
	 *
	 * @param modifiedDate the modified date of this profile work experience
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this profile work experience.
	 *
	 * @param primaryKey the primary key of this profile work experience
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile ID of this profile work experience.
	 *
	 * @param profileId the profile ID of this profile work experience
	 */
	@Override
	public void setProfileId(long profileId) {
		model.setProfileId(profileId);
	}

	/**
	 * Sets the start date of this profile work experience.
	 *
	 * @param startDate the start date of this profile work experience
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the title of this profile work experience.
	 *
	 * @param title the title of this profile work experience
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this profile work experience.
	 *
	 * @param userId the user ID of this profile work experience
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile work experience.
	 *
	 * @param userName the user name of this profile work experience
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile work experience.
	 *
	 * @param userUuid the user uuid of this profile work experience
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile work experience.
	 *
	 * @param uuid the uuid of this profile work experience
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work experience of this profile work experience.
	 *
	 * @param workExperience the work experience of this profile work experience
	 */
	@Override
	public void setWorkExperience(String workExperience) {
		model.setWorkExperience(workExperience);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected profileWorkExperienceWrapper wrap(
		profileWorkExperience profileWorkExperience) {

		return new profileWorkExperienceWrapper(profileWorkExperience);
	}

}