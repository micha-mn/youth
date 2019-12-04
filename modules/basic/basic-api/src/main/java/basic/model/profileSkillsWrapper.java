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
 * This class is a wrapper for {@link profileSkills}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileSkills
 * @generated
 */
@ProviderType
public class profileSkillsWrapper
	extends BaseModelWrapper<profileSkills>
	implements profileSkills, ModelWrapper<profileSkills> {

	public profileSkillsWrapper(profileSkills profileSkills) {
		super(profileSkills);
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
		attributes.put("skill", getSkill());

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

		String skill = (String)attributes.get("skill");

		if (skill != null) {
			setSkill(skill);
		}
	}

	/**
	 * Returns the company ID of this profile skills.
	 *
	 * @return the company ID of this profile skills
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this profile skills.
	 *
	 * @return the create date of this profile skills
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this profile skills.
	 *
	 * @return the group ID of this profile skills
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this profile skills.
	 *
	 * @return the ID of this profile skills
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this profile skills.
	 *
	 * @return the modified date of this profile skills
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this profile skills.
	 *
	 * @return the primary key of this profile skills
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile ID of this profile skills.
	 *
	 * @return the profile ID of this profile skills
	 */
	@Override
	public long getProfileId() {
		return model.getProfileId();
	}

	/**
	 * Returns the skill of this profile skills.
	 *
	 * @return the skill of this profile skills
	 */
	@Override
	public String getSkill() {
		return model.getSkill();
	}

	/**
	 * Returns the user ID of this profile skills.
	 *
	 * @return the user ID of this profile skills
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile skills.
	 *
	 * @return the user name of this profile skills
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile skills.
	 *
	 * @return the user uuid of this profile skills
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile skills.
	 *
	 * @return the uuid of this profile skills
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
	 * Sets the company ID of this profile skills.
	 *
	 * @param companyId the company ID of this profile skills
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this profile skills.
	 *
	 * @param createDate the create date of this profile skills
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this profile skills.
	 *
	 * @param groupId the group ID of this profile skills
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this profile skills.
	 *
	 * @param Id the ID of this profile skills
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the modified date of this profile skills.
	 *
	 * @param modifiedDate the modified date of this profile skills
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this profile skills.
	 *
	 * @param primaryKey the primary key of this profile skills
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile ID of this profile skills.
	 *
	 * @param profileId the profile ID of this profile skills
	 */
	@Override
	public void setProfileId(long profileId) {
		model.setProfileId(profileId);
	}

	/**
	 * Sets the skill of this profile skills.
	 *
	 * @param skill the skill of this profile skills
	 */
	@Override
	public void setSkill(String skill) {
		model.setSkill(skill);
	}

	/**
	 * Sets the user ID of this profile skills.
	 *
	 * @param userId the user ID of this profile skills
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile skills.
	 *
	 * @param userName the user name of this profile skills
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile skills.
	 *
	 * @param userUuid the user uuid of this profile skills
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile skills.
	 *
	 * @param uuid the uuid of this profile skills
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
	protected profileSkillsWrapper wrap(profileSkills profileSkills) {
		return new profileSkillsWrapper(profileSkills);
	}

}