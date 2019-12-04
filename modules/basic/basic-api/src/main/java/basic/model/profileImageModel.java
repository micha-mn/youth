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

import java.sql.Blob;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the profileImage service. Represents a row in the &quot;profileImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>basic.model.impl.profileImageModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>basic.model.impl.profileImageImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileImage
 * @generated
 */
@ProviderType
public interface profileImageModel extends BaseModel<profileImage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a profile image model instance should use the {@link profileImage} interface instead.
	 */

	/**
	 * Returns the primary key of this profile image.
	 *
	 * @return the primary key of this profile image
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this profile image.
	 *
	 * @param primaryKey the primary key of this profile image
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this profile image.
	 *
	 * @return the uuid of this profile image
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this profile image.
	 *
	 * @param uuid the uuid of this profile image
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this profile image.
	 *
	 * @return the ID of this profile image
	 */
	public long getId();

	/**
	 * Sets the ID of this profile image.
	 *
	 * @param id the ID of this profile image
	 */
	public void setId(long id);

	/**
	 * Returns the user ID of this profile image.
	 *
	 * @return the user ID of this profile image
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this profile image.
	 *
	 * @param userId the user ID of this profile image
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this profile image.
	 *
	 * @return the user uuid of this profile image
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this profile image.
	 *
	 * @param userUuid the user uuid of this profile image
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the image of this profile image.
	 *
	 * @return the image of this profile image
	 */
	public Blob getImage();

	/**
	 * Sets the image of this profile image.
	 *
	 * @param image the image of this profile image
	 */
	public void setImage(Blob image);

}