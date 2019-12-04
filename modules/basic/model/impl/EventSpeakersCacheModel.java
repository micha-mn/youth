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

package basic.model.impl;

import basic.model.EventSpeakers;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing EventSpeakers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventSpeakersCacheModel
	implements CacheModel<EventSpeakers>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventSpeakersCacheModel)) {
			return false;
		}

		EventSpeakersCacheModel eventSpeakersCacheModel =
			(EventSpeakersCacheModel)obj;

		if (id == eventSpeakersCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", position=");
		sb.append(position);
		sb.append(", speakerImageString=");
		sb.append(speakerImageString);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", email=");
		sb.append(email);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", isNotificationSent=");
		sb.append(isNotificationSent);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventSpeakers toEntityModel() {
		EventSpeakersImpl eventSpeakersImpl = new EventSpeakersImpl();

		if (uuid == null) {
			eventSpeakersImpl.setUuid("");
		}
		else {
			eventSpeakersImpl.setUuid(uuid);
		}

		eventSpeakersImpl.setId(id);

		if (position == null) {
			eventSpeakersImpl.setPosition("");
		}
		else {
			eventSpeakersImpl.setPosition(position);
		}

		if (speakerImageString == null) {
			eventSpeakersImpl.setSpeakerImageString("");
		}
		else {
			eventSpeakersImpl.setSpeakerImageString(speakerImageString);
		}

		if (nationality == null) {
			eventSpeakersImpl.setNationality("");
		}
		else {
			eventSpeakersImpl.setNationality(nationality);
		}

		if (email == null) {
			eventSpeakersImpl.setEmail("");
		}
		else {
			eventSpeakersImpl.setEmail(email);
		}

		if (firstName == null) {
			eventSpeakersImpl.setFirstName("");
		}
		else {
			eventSpeakersImpl.setFirstName(firstName);
		}

		if (userId == null) {
			eventSpeakersImpl.setUserId("");
		}
		else {
			eventSpeakersImpl.setUserId(userId);
		}

		if (lastName == null) {
			eventSpeakersImpl.setLastName("");
		}
		else {
			eventSpeakersImpl.setLastName(lastName);
		}

		if (isNotificationSent == null) {
			eventSpeakersImpl.setIsNotificationSent("");
		}
		else {
			eventSpeakersImpl.setIsNotificationSent(isNotificationSent);
		}

		if (eventId == null) {
			eventSpeakersImpl.setEventId("");
		}
		else {
			eventSpeakersImpl.setEventId(eventId);
		}

		eventSpeakersImpl.resetOriginalValues();

		return eventSpeakersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		position = objectInput.readUTF();
		speakerImageString = objectInput.readUTF();
		nationality = objectInput.readUTF();
		email = objectInput.readUTF();
		firstName = objectInput.readUTF();
		userId = objectInput.readUTF();
		lastName = objectInput.readUTF();
		isNotificationSent = objectInput.readUTF();
		eventId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (position == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(position);
		}

		if (speakerImageString == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(speakerImageString);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (userId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userId);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (isNotificationSent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(isNotificationSent);
		}

		if (eventId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventId);
		}
	}

	public String uuid;
	public long id;
	public String position;
	public String speakerImageString;
	public String nationality;
	public String email;
	public String firstName;
	public String userId;
	public String lastName;
	public String isNotificationSent;
	public String eventId;

}