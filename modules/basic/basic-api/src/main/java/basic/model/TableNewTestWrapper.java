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
 * This class is a wrapper for {@link TableNewTest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableNewTest
 * @generated
 */
@ProviderType
public class TableNewTestWrapper
	extends BaseModelWrapper<TableNewTest>
	implements TableNewTest, ModelWrapper<TableNewTest> {

	public TableNewTestWrapper(TableNewTest tableNewTest) {
		super(tableNewTest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("Title", getTitle());
		attributes.put("Description", getDescription());
		attributes.put("Image", getImage());
		attributes.put("eventId", getEventId());

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

		String Title = (String)attributes.get("Title");

		if (Title != null) {
			setTitle(Title);
		}

		String Description = (String)attributes.get("Description");

		if (Description != null) {
			setDescription(Description);
		}

		Blob Image = (Blob)attributes.get("Image");

		if (Image != null) {
			setImage(Image);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	/**
	 * Returns the description of this table new test.
	 *
	 * @return the description of this table new test
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the event ID of this table new test.
	 *
	 * @return the event ID of this table new test
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the ID of this table new test.
	 *
	 * @return the ID of this table new test
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image of this table new test.
	 *
	 * @return the image of this table new test
	 */
	@Override
	public Blob getImage() {
		return model.getImage();
	}

	/**
	 * Returns the primary key of this table new test.
	 *
	 * @return the primary key of this table new test
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this table new test.
	 *
	 * @return the title of this table new test
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this table new test.
	 *
	 * @return the uuid of this table new test
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
	 * Sets the description of this table new test.
	 *
	 * @param Description the description of this table new test
	 */
	@Override
	public void setDescription(String Description) {
		model.setDescription(Description);
	}

	/**
	 * Sets the event ID of this table new test.
	 *
	 * @param eventId the event ID of this table new test
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the ID of this table new test.
	 *
	 * @param id the ID of this table new test
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image of this table new test.
	 *
	 * @param Image the image of this table new test
	 */
	@Override
	public void setImage(Blob Image) {
		model.setImage(Image);
	}

	/**
	 * Sets the primary key of this table new test.
	 *
	 * @param primaryKey the primary key of this table new test
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this table new test.
	 *
	 * @param Title the title of this table new test
	 */
	@Override
	public void setTitle(String Title) {
		model.setTitle(Title);
	}

	/**
	 * Sets the uuid of this table new test.
	 *
	 * @param uuid the uuid of this table new test
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected TableNewTestWrapper wrap(TableNewTest tableNewTest) {
		return new TableNewTestWrapper(tableNewTest);
	}

}