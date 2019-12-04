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

import basic.model.EventTimeline;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing EventTimeline in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventTimelineCacheModel
	implements CacheModel<EventTimeline>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventTimelineCacheModel)) {
			return false;
		}

		EventTimelineCacheModel eventTimelineCacheModel =
			(EventTimelineCacheModel)obj;

		if (id == eventTimelineCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", Title=");
		sb.append(Title);
		sb.append(", Description=");
		sb.append(Description);
		sb.append(", EventStartDay=");
		sb.append(EventStartDay);
		sb.append(", EventendDay=");
		sb.append(EventendDay);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventTimeline toEntityModel() {
		EventTimelineImpl eventTimelineImpl = new EventTimelineImpl();

		if (uuid == null) {
			eventTimelineImpl.setUuid("");
		}
		else {
			eventTimelineImpl.setUuid(uuid);
		}

		eventTimelineImpl.setId(id);

		if (Title == null) {
			eventTimelineImpl.setTitle("");
		}
		else {
			eventTimelineImpl.setTitle(Title);
		}

		if (Description == null) {
			eventTimelineImpl.setDescription("");
		}
		else {
			eventTimelineImpl.setDescription(Description);
		}

		if (EventStartDay == Long.MIN_VALUE) {
			eventTimelineImpl.setEventStartDay(null);
		}
		else {
			eventTimelineImpl.setEventStartDay(new Date(EventStartDay));
		}

		if (EventendDay == Long.MIN_VALUE) {
			eventTimelineImpl.setEventendDay(null);
		}
		else {
			eventTimelineImpl.setEventendDay(new Date(EventendDay));
		}

		if (eventId == null) {
			eventTimelineImpl.setEventId("");
		}
		else {
			eventTimelineImpl.setEventId(eventId);
		}

		eventTimelineImpl.resetOriginalValues();

		return eventTimelineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		Title = objectInput.readUTF();
		Description = objectInput.readUTF();
		EventStartDay = objectInput.readLong();
		EventendDay = objectInput.readLong();
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

		if (Title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Title);
		}

		if (Description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Description);
		}

		objectOutput.writeLong(EventStartDay);
		objectOutput.writeLong(EventendDay);

		if (eventId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventId);
		}
	}

	public String uuid;
	public long id;
	public String Title;
	public String Description;
	public long EventStartDay;
	public long EventendDay;
	public String eventId;

}