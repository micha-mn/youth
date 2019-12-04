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
 * This class is a wrapper for {@link EventFAQs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventFAQs
 * @generated
 */
@ProviderType
public class EventFAQsWrapper
	extends BaseModelWrapper<EventFAQs>
	implements EventFAQs, ModelWrapper<EventFAQs> {

	public EventFAQsWrapper(EventFAQs eventFAQs) {
		super(eventFAQs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("Question", getQuestion());
		attributes.put("Answer", getAnswer());
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

		String Question = (String)attributes.get("Question");

		if (Question != null) {
			setQuestion(Question);
		}

		String Answer = (String)attributes.get("Answer");

		if (Answer != null) {
			setAnswer(Answer);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	/**
	 * Returns the answer of this event fa qs.
	 *
	 * @return the answer of this event fa qs
	 */
	@Override
	public String getAnswer() {
		return model.getAnswer();
	}

	/**
	 * Returns the event ID of this event fa qs.
	 *
	 * @return the event ID of this event fa qs
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the ID of this event fa qs.
	 *
	 * @return the ID of this event fa qs
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this event fa qs.
	 *
	 * @return the primary key of this event fa qs
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the question of this event fa qs.
	 *
	 * @return the question of this event fa qs
	 */
	@Override
	public String getQuestion() {
		return model.getQuestion();
	}

	/**
	 * Returns the uuid of this event fa qs.
	 *
	 * @return the uuid of this event fa qs
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
	 * Sets the answer of this event fa qs.
	 *
	 * @param Answer the answer of this event fa qs
	 */
	@Override
	public void setAnswer(String Answer) {
		model.setAnswer(Answer);
	}

	/**
	 * Sets the event ID of this event fa qs.
	 *
	 * @param eventId the event ID of this event fa qs
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the ID of this event fa qs.
	 *
	 * @param id the ID of this event fa qs
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this event fa qs.
	 *
	 * @param primaryKey the primary key of this event fa qs
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question of this event fa qs.
	 *
	 * @param Question the question of this event fa qs
	 */
	@Override
	public void setQuestion(String Question) {
		model.setQuestion(Question);
	}

	/**
	 * Sets the uuid of this event fa qs.
	 *
	 * @param uuid the uuid of this event fa qs
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected EventFAQsWrapper wrap(EventFAQs eventFAQs) {
		return new EventFAQsWrapper(eventFAQs);
	}

}