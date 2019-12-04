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

import basic.model.EventHighLights;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing EventHighLights in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventHighLightsCacheModel
	implements CacheModel<EventHighLights>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventHighLightsCacheModel)) {
			return false;
		}

		EventHighLightsCacheModel eventHighLightsCacheModel =
			(EventHighLightsCacheModel)obj;

		if (id == eventHighLightsCacheModel.id) {
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
		sb.append(", Title=");
		sb.append(Title);
		sb.append(", Description=");
		sb.append(Description);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventHighLights toEntityModel() {
		EventHighLightsImpl eventHighLightsImpl = new EventHighLightsImpl();

		if (uuid == null) {
			eventHighLightsImpl.setUuid("");
		}
		else {
			eventHighLightsImpl.setUuid(uuid);
		}

		eventHighLightsImpl.setId(id);

		if (Title == null) {
			eventHighLightsImpl.setTitle("");
		}
		else {
			eventHighLightsImpl.setTitle(Title);
		}

		if (Description == null) {
			eventHighLightsImpl.setDescription("");
		}
		else {
			eventHighLightsImpl.setDescription(Description);
		}

		if (eventId == null) {
			eventHighLightsImpl.setEventId("");
		}
		else {
			eventHighLightsImpl.setEventId(eventId);
		}

		eventHighLightsImpl.resetOriginalValues();

		return eventHighLightsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		Title = objectInput.readUTF();
		Description = objectInput.readUTF();
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
	public String eventId;

}