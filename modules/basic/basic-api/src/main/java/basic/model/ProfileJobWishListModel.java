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
 * The base model interface for the ProfileJobWishList service. Represents a row in the &quot;ProfileJobWishList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>basic.model.impl.ProfileJobWishListModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>basic.model.impl.ProfileJobWishListImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfileJobWishList
 * @generated
 */
@ProviderType
public interface ProfileJobWishListModel
	extends BaseModel<ProfileJobWishList>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a profile job wish list model instance should use the {@link ProfileJobWishList} interface instead.
	 */

	/**
	 * Returns the primary key of this profile job wish list.
	 *
	 * @return the primary key of this profile job wish list
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this profile job wish list.
	 *
	 * @param primaryKey the primary key of this profile job wish list
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this profile job wish list.
	 *
	 * @return the uuid of this profile job wish list
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this profile job wish list.
	 *
	 * @param uuid the uuid of this profile job wish list
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this profile job wish list.
	 *
	 * @return the ID of this profile job wish list
	 */
	public long getId();

	/**
	 * Sets the ID of this profile job wish list.
	 *
	 * @param Id the ID of this profile job wish list
	 */
	public void setId(long Id);

	/**
	 * Returns the group ID of this profile job wish list.
	 *
	 * @return the group ID of this profile job wish list
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this profile job wish list.
	 *
	 * @param groupId the group ID of this profile job wish list
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this profile job wish list.
	 *
	 * @return the company ID of this profile job wish list
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this profile job wish list.
	 *
	 * @param companyId the company ID of this profile job wish list
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this profile job wish list.
	 *
	 * @return the user ID of this profile job wish list
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this profile job wish list.
	 *
	 * @param userId the user ID of this profile job wish list
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this profile job wish list.
	 *
	 * @return the user uuid of this profile job wish list
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this profile job wish list.
	 *
	 * @param userUuid the user uuid of this profile job wish list
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this profile job wish list.
	 *
	 * @return the user name of this profile job wish list
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this profile job wish list.
	 *
	 * @param userName the user name of this profile job wish list
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this profile job wish list.
	 *
	 * @return the create date of this profile job wish list
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this profile job wish list.
	 *
	 * @param createDate the create date of this profile job wish list
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this profile job wish list.
	 *
	 * @return the modified date of this profile job wish list
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this profile job wish list.
	 *
	 * @param modifiedDate the modified date of this profile job wish list
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the jobwishlist of this profile job wish list.
	 *
	 * @return the jobwishlist of this profile job wish list
	 */
	@AutoEscape
	public String getJobwishlist();

	/**
	 * Sets the jobwishlist of this profile job wish list.
	 *
	 * @param jobwishlist the jobwishlist of this profile job wish list
	 */
	public void setJobwishlist(String jobwishlist);

}