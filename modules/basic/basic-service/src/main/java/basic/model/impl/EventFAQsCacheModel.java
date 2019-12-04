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

import basic.model.EventFAQs;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing EventFAQs in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventFAQsCacheModel
	implements CacheModel<EventFAQs>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventFAQsCacheModel)) {
			return false;
		}

		EventFAQsCacheModel eventFAQsCacheModel = (EventFAQsCacheModel)obj;

		if (id == eventFAQsCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", Question=");
		sb.append(Question);
		sb.append(", Answer=");
		sb.append(Answer);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventFAQs toEntityModel() {
		EventFAQsImpl eventFAQsImpl = new EventFAQsImpl();

		if (uuid == null) {
			eventFAQsImpl.setUuid("");
		}
		else {
			eventFAQsImpl.setUuid(uuid);
		}

		eventFAQsImpl.setId(id);

		if (Question == null) {
			eventFAQsImpl.setQuestion("");
		}
		else {
			eventFAQsImpl.setQuestion(Question);
		}

		if (Answer == null) {
			eventFAQsImpl.setAnswer("");
		}
		else {
			eventFAQsImpl.setAnswer(Answer);
		}

		if (eventId == null) {
			eventFAQsImpl.setEventId("");
		}
		else {
			eventFAQsImpl.setEventId(eventId);
		}

		eventFAQsImpl.resetOriginalValues();

		return eventFAQsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		Question = objectInput.readUTF();
		Answer = objectInput.readUTF();
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

		if (Question == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Question);
		}

		if (Answer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Answer);
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
	public String Question;
	public String Answer;
	public String eventId;

}