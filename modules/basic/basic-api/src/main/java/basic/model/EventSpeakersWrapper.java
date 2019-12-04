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
 * This class is a wrapper for {@link EventSpeakers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventSpeakers
 * @generated
 */
@ProviderType
public class EventSpeakersWrapper
	extends BaseModelWrapper<EventSpeakers>
	implements EventSpeakers, ModelWrapper<EventSpeakers> {

	public EventSpeakersWrapper(EventSpeakers eventSpeakers) {
		super(eventSpeakers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("position", getPosition());
		attributes.put("speakerImage", getSpeakerImage());
		attributes.put("speakerImageString", getSpeakerImageString());
		attributes.put("nationality", getNationality());
		attributes.put("email", getEmail());
		attributes.put("firstName", getFirstName());
		attributes.put("userId", getUserId());
		attributes.put("lastName", getLastName());
		attributes.put("isNotificationSent", getIsNotificationSent());
		attributes.put("eventId", getEventId());
		attributes.put("isNotifEnabled", getIsNotifEnabled());

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

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Blob speakerImage = (Blob)attributes.get("speakerImage");

		if (speakerImage != null) {
			setSpeakerImage(speakerImage);
		}

		String speakerImageString = (String)attributes.get(
			"speakerImageString");

		if (speakerImageString != null) {
			setSpeakerImageString(speakerImageString);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String isNotificationSent = (String)attributes.get(
			"isNotificationSent");

		if (isNotificationSent != null) {
			setIsNotificationSent(isNotificationSent);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String isNotifEnabled = (String)attributes.get("isNotifEnabled");

		if (isNotifEnabled != null) {
			setIsNotifEnabled(isNotifEnabled);
		}
	}

	/**
	 * Returns the email of this event speakers.
	 *
	 * @return the email of this event speakers
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the event ID of this event speakers.
	 *
	 * @return the event ID of this event speakers
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the first name of this event speakers.
	 *
	 * @return the first name of this event speakers
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the ID of this event speakers.
	 *
	 * @return the ID of this event speakers
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is notif enabled of this event speakers.
	 *
	 * @return the is notif enabled of this event speakers
	 */
	@Override
	public String getIsNotifEnabled() {
		return model.getIsNotifEnabled();
	}

	/**
	 * Returns the is notification sent of this event speakers.
	 *
	 * @return the is notification sent of this event speakers
	 */
	@Override
	public String getIsNotificationSent() {
		return model.getIsNotificationSent();
	}

	/**
	 * Returns the last name of this event speakers.
	 *
	 * @return the last name of this event speakers
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the nationality of this event speakers.
	 *
	 * @return the nationality of this event speakers
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the position of this event speakers.
	 *
	 * @return the position of this event speakers
	 */
	@Override
	public String getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this event speakers.
	 *
	 * @return the primary key of this event speakers
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the speaker image of this event speakers.
	 *
	 * @return the speaker image of this event speakers
	 */
	@Override
	public Blob getSpeakerImage() {
		return model.getSpeakerImage();
	}

	/**
	 * Returns the speaker image string of this event speakers.
	 *
	 * @return the speaker image string of this event speakers
	 */
	@Override
	public String getSpeakerImageString() {
		return model.getSpeakerImageString();
	}

	/**
	 * Returns the user ID of this event speakers.
	 *
	 * @return the user ID of this event speakers
	 */
	@Override
	public String getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the uuid of this event speakers.
	 *
	 * @return the uuid of this event speakers
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
	 * Sets the email of this event speakers.
	 *
	 * @param email the email of this event speakers
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the event ID of this event speakers.
	 *
	 * @param eventId the event ID of this event speakers
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the first name of this event speakers.
	 *
	 * @param firstName the first name of this event speakers
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the ID of this event speakers.
	 *
	 * @param id the ID of this event speakers
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the is notif enabled of this event speakers.
	 *
	 * @param isNotifEnabled the is notif enabled of this event speakers
	 */
	@Override
	public void setIsNotifEnabled(String isNotifEnabled) {
		model.setIsNotifEnabled(isNotifEnabled);
	}

	/**
	 * Sets the is notification sent of this event speakers.
	 *
	 * @param isNotificationSent the is notification sent of this event speakers
	 */
	@Override
	public void setIsNotificationSent(String isNotificationSent) {
		model.setIsNotificationSent(isNotificationSent);
	}

	/**
	 * Sets the last name of this event speakers.
	 *
	 * @param lastName the last name of this event speakers
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the nationality of this event speakers.
	 *
	 * @param nationality the nationality of this event speakers
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the position of this event speakers.
	 *
	 * @param position the position of this event speakers
	 */
	@Override
	public void setPosition(String position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this event speakers.
	 *
	 * @param primaryKey the primary key of this event speakers
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the speaker image of this event speakers.
	 *
	 * @param speakerImage the speaker image of this event speakers
	 */
	@Override
	public void setSpeakerImage(Blob speakerImage) {
		model.setSpeakerImage(speakerImage);
	}

	/**
	 * Sets the speaker image string of this event speakers.
	 *
	 * @param speakerImageString the speaker image string of this event speakers
	 */
	@Override
	public void setSpeakerImageString(String speakerImageString) {
		model.setSpeakerImageString(speakerImageString);
	}

	/**
	 * Sets the user ID of this event speakers.
	 *
	 * @param userId the user ID of this event speakers
	 */
	@Override
	public void setUserId(String userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the uuid of this event speakers.
	 *
	 * @param uuid the uuid of this event speakers
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected EventSpeakersWrapper wrap(EventSpeakers eventSpeakers) {
		return new EventSpeakersWrapper(eventSpeakers);
	}

}