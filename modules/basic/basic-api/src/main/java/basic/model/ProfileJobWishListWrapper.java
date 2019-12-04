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
 * This class is a wrapper for {@link ProfileJobWishList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileJobWishList
 * @generated
 */
@ProviderType
public class ProfileJobWishListWrapper
	extends BaseModelWrapper<ProfileJobWishList>
	implements ProfileJobWishList, ModelWrapper<ProfileJobWishList> {

	public ProfileJobWishListWrapper(ProfileJobWishList profileJobWishList) {
		super(profileJobWishList);
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
		attributes.put("jobwishlist", getJobwishlist());

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

		String jobwishlist = (String)attributes.get("jobwishlist");

		if (jobwishlist != null) {
			setJobwishlist(jobwishlist);
		}
	}

	/**
	 * Returns the company ID of this profile job wish list.
	 *
	 * @return the company ID of this profile job wish list
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this profile job wish list.
	 *
	 * @return the create date of this profile job wish list
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this profile job wish list.
	 *
	 * @return the group ID of this profile job wish list
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this profile job wish list.
	 *
	 * @return the ID of this profile job wish list
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the jobwishlist of this profile job wish list.
	 *
	 * @return the jobwishlist of this profile job wish list
	 */
	@Override
	public String getJobwishlist() {
		return model.getJobwishlist();
	}

	/**
	 * Returns the modified date of this profile job wish list.
	 *
	 * @return the modified date of this profile job wish list
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this profile job wish list.
	 *
	 * @return the primary key of this profile job wish list
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this profile job wish list.
	 *
	 * @return the user ID of this profile job wish list
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile job wish list.
	 *
	 * @return the user name of this profile job wish list
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile job wish list.
	 *
	 * @return the user uuid of this profile job wish list
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile job wish list.
	 *
	 * @return the uuid of this profile job wish list
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
	 * Sets the company ID of this profile job wish list.
	 *
	 * @param companyId the company ID of this profile job wish list
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this profile job wish list.
	 *
	 * @param createDate the create date of this profile job wish list
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this profile job wish list.
	 *
	 * @param groupId the group ID of this profile job wish list
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this profile job wish list.
	 *
	 * @param Id the ID of this profile job wish list
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the jobwishlist of this profile job wish list.
	 *
	 * @param jobwishlist the jobwishlist of this profile job wish list
	 */
	@Override
	public void setJobwishlist(String jobwishlist) {
		model.setJobwishlist(jobwishlist);
	}

	/**
	 * Sets the modified date of this profile job wish list.
	 *
	 * @param modifiedDate the modified date of this profile job wish list
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this profile job wish list.
	 *
	 * @param primaryKey the primary key of this profile job wish list
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this profile job wish list.
	 *
	 * @param userId the user ID of this profile job wish list
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile job wish list.
	 *
	 * @param userName the user name of this profile job wish list
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile job wish list.
	 *
	 * @param userUuid the user uuid of this profile job wish list
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile job wish list.
	 *
	 * @param uuid the uuid of this profile job wish list
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
	protected ProfileJobWishListWrapper wrap(
		ProfileJobWishList profileJobWishList) {

		return new ProfileJobWishListWrapper(profileJobWishList);
	}

}