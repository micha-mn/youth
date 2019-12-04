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
 * This class is a wrapper for {@link Journey}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Journey
 * @generated
 */
@ProviderType
public class JourneyWrapper
	extends BaseModelWrapper<Journey>
	implements Journey, ModelWrapper<Journey> {

	public JourneyWrapper(Journey journey) {
		super(journey);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("journeyId", getJourneyId());
		attributes.put("userId", getUserId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("pictureBlob", getPictureBlob());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long journeyId = (Long)attributes.get("journeyId");

		if (journeyId != null) {
			setJourneyId(journeyId);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Blob pictureBlob = (Blob)attributes.get("pictureBlob");

		if (pictureBlob != null) {
			setPictureBlob(pictureBlob);
		}
	}

	/**
	 * Returns the description of this journey.
	 *
	 * @return the description of this journey
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the journey ID of this journey.
	 *
	 * @return the journey ID of this journey
	 */
	@Override
	public long getJourneyId() {
		return model.getJourneyId();
	}

	/**
	 * Returns the picture blob of this journey.
	 *
	 * @return the picture blob of this journey
	 */
	@Override
	public Blob getPictureBlob() {
		return model.getPictureBlob();
	}

	/**
	 * Returns the primary key of this journey.
	 *
	 * @return the primary key of this journey
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this journey.
	 *
	 * @return the title of this journey
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this journey.
	 *
	 * @return the user ID of this journey
	 */
	@Override
	public String getUserId() {
		return model.getUserId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the description of this journey.
	 *
	 * @param description the description of this journey
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the journey ID of this journey.
	 *
	 * @param journeyId the journey ID of this journey
	 */
	@Override
	public void setJourneyId(long journeyId) {
		model.setJourneyId(journeyId);
	}

	/**
	 * Sets the picture blob of this journey.
	 *
	 * @param pictureBlob the picture blob of this journey
	 */
	@Override
	public void setPictureBlob(Blob pictureBlob) {
		model.setPictureBlob(pictureBlob);
	}

	/**
	 * Sets the primary key of this journey.
	 *
	 * @param primaryKey the primary key of this journey
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this journey.
	 *
	 * @param title the title of this journey
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this journey.
	 *
	 * @param userId the user ID of this journey
	 */
	@Override
	public void setUserId(String userId) {
		model.setUserId(userId);
	}

	@Override
	protected JourneyWrapper wrap(Journey journey) {
		return new JourneyWrapper(journey);
	}

}