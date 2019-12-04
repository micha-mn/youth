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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.sql.Blob;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link profileImage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileImage
 * @generated
 */
@ProviderType
public class profileImageWrapper
	extends BaseModelWrapper<profileImage>
	implements profileImage, ModelWrapper<profileImage> {

	public profileImageWrapper(profileImage profileImage) {
		super(profileImage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("image", getImage());

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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Blob image = (Blob)attributes.get("image");

		if (image != null) {
			setImage(image);
		}
	}

	/**
	 * Returns the ID of this profile image.
	 *
	 * @return the ID of this profile image
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image of this profile image.
	 *
	 * @return the image of this profile image
	 */
	@Override
	public Blob getImage() {
		return model.getImage();
	}

	/**
	 * Returns the primary key of this profile image.
	 *
	 * @return the primary key of this profile image
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this profile image.
	 *
	 * @return the user ID of this profile image
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this profile image.
	 *
	 * @return the user uuid of this profile image
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile image.
	 *
	 * @return the uuid of this profile image
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
	 * Sets the ID of this profile image.
	 *
	 * @param id the ID of this profile image
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image of this profile image.
	 *
	 * @param image the image of this profile image
	 */
	@Override
	public void setImage(Blob image) {
		model.setImage(image);
	}

	/**
	 * Sets the primary key of this profile image.
	 *
	 * @param primaryKey the primary key of this profile image
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this profile image.
	 *
	 * @param userId the user ID of this profile image
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this profile image.
	 *
	 * @param userUuid the user uuid of this profile image
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile image.
	 *
	 * @param uuid the uuid of this profile image
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected profileImageWrapper wrap(profileImage profileImage) {
		return new profileImageWrapper(profileImage);
	}

}