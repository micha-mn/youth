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

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link EventAttributes}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttributes
 * @generated
 */
@ProviderType
public class EventAttributesWrapper
	extends BaseModelWrapper<EventAttributes>
	implements EventAttributes, ModelWrapper<EventAttributes> {

	public EventAttributesWrapper(EventAttributes eventAttributes) {
		super(eventAttributes);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("attributeNumber", getAttributeNumber());
		attributes.put("attributeName", getAttributeName());
		attributes.put("eventId", getEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String attributeNumber = (String)attributes.get("attributeNumber");

		if (attributeNumber != null) {
			setAttributeNumber(attributeNumber);
		}

		String attributeName = (String)attributes.get("attributeName");

		if (attributeName != null) {
			setAttributeName(attributeName);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	/**
	 * Returns the attribute name of this event attributes.
	 *
	 * @return the attribute name of this event attributes
	 */
	@Override
	public String getAttributeName() {
		return model.getAttributeName();
	}

	/**
	 * Returns the attribute number of this event attributes.
	 *
	 * @return the attribute number of this event attributes
	 */
	@Override
	public String getAttributeNumber() {
		return model.getAttributeNumber();
	}

	/**
	 * Returns the event ID of this event attributes.
	 *
	 * @return the event ID of this event attributes
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the ID of this event attributes.
	 *
	 * @return the ID of this event attributes
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this event attributes.
	 *
	 * @return the primary key of this event attributes
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attribute name of this event attributes.
	 *
	 * @param attributeName the attribute name of this event attributes
	 */
	@Override
	public void setAttributeName(String attributeName) {
		model.setAttributeName(attributeName);
	}

	/**
	 * Sets the attribute number of this event attributes.
	 *
	 * @param attributeNumber the attribute number of this event attributes
	 */
	@Override
	public void setAttributeNumber(String attributeNumber) {
		model.setAttributeNumber(attributeNumber);
	}

	/**
	 * Sets the event ID of this event attributes.
	 *
	 * @param eventId the event ID of this event attributes
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the ID of this event attributes.
	 *
	 * @param id the ID of this event attributes
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this event attributes.
	 *
	 * @param primaryKey the primary key of this event attributes
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected EventAttributesWrapper wrap(EventAttributes eventAttributes) {
		return new EventAttributesWrapper(eventAttributes);
	}

}