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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link EventTimeline}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventTimeline
 * @generated
 */
@ProviderType
public class EventTimelineWrapper
	extends BaseModelWrapper<EventTimeline>
	implements EventTimeline, ModelWrapper<EventTimeline> {

	public EventTimelineWrapper(EventTimeline eventTimeline) {
		super(eventTimeline);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("Title", getTitle());
		attributes.put("Description", getDescription());
		attributes.put("EventStartDay", getEventStartDay());
		attributes.put("EventendDay", getEventendDay());
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

		Date EventStartDay = (Date)attributes.get("EventStartDay");

		if (EventStartDay != null) {
			setEventStartDay(EventStartDay);
		}

		Date EventendDay = (Date)attributes.get("EventendDay");

		if (EventendDay != null) {
			setEventendDay(EventendDay);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	/**
	 * Returns the description of this event timeline.
	 *
	 * @return the description of this event timeline
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the eventend day of this event timeline.
	 *
	 * @return the eventend day of this event timeline
	 */
	@Override
	public Date getEventendDay() {
		return model.getEventendDay();
	}

	/**
	 * Returns the event ID of this event timeline.
	 *
	 * @return the event ID of this event timeline
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the event start day of this event timeline.
	 *
	 * @return the event start day of this event timeline
	 */
	@Override
	public Date getEventStartDay() {
		return model.getEventStartDay();
	}

	/**
	 * Returns the ID of this event timeline.
	 *
	 * @return the ID of this event timeline
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this event timeline.
	 *
	 * @return the primary key of this event timeline
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this event timeline.
	 *
	 * @return the title of this event timeline
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this event timeline.
	 *
	 * @return the uuid of this event timeline
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
	 * Sets the description of this event timeline.
	 *
	 * @param Description the description of this event timeline
	 */
	@Override
	public void setDescription(String Description) {
		model.setDescription(Description);
	}

	/**
	 * Sets the eventend day of this event timeline.
	 *
	 * @param EventendDay the eventend day of this event timeline
	 */
	@Override
	public void setEventendDay(Date EventendDay) {
		model.setEventendDay(EventendDay);
	}

	/**
	 * Sets the event ID of this event timeline.
	 *
	 * @param eventId the event ID of this event timeline
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the event start day of this event timeline.
	 *
	 * @param EventStartDay the event start day of this event timeline
	 */
	@Override
	public void setEventStartDay(Date EventStartDay) {
		model.setEventStartDay(EventStartDay);
	}

	/**
	 * Sets the ID of this event timeline.
	 *
	 * @param id the ID of this event timeline
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this event timeline.
	 *
	 * @param primaryKey the primary key of this event timeline
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this event timeline.
	 *
	 * @param Title the title of this event timeline
	 */
	@Override
	public void setTitle(String Title) {
		model.setTitle(Title);
	}

	/**
	 * Sets the uuid of this event timeline.
	 *
	 * @param uuid the uuid of this event timeline
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected EventTimelineWrapper wrap(EventTimeline eventTimeline) {
		return new EventTimelineWrapper(eventTimeline);
	}

}