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

import basic.model.EventAttributes;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing EventAttributes in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventAttributesCacheModel
	implements CacheModel<EventAttributes>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventAttributesCacheModel)) {
			return false;
		}

		EventAttributesCacheModel eventAttributesCacheModel =
			(EventAttributesCacheModel)obj;

		if (id == eventAttributesCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", attributeNumber=");
		sb.append(attributeNumber);
		sb.append(", attributeName=");
		sb.append(attributeName);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventAttributes toEntityModel() {
		EventAttributesImpl eventAttributesImpl = new EventAttributesImpl();

		eventAttributesImpl.setId(id);

		if (attributeNumber == null) {
			eventAttributesImpl.setAttributeNumber("");
		}
		else {
			eventAttributesImpl.setAttributeNumber(attributeNumber);
		}

		if (attributeName == null) {
			eventAttributesImpl.setAttributeName("");
		}
		else {
			eventAttributesImpl.setAttributeName(attributeName);
		}

		if (eventId == null) {
			eventAttributesImpl.setEventId("");
		}
		else {
			eventAttributesImpl.setEventId(eventId);
		}

		eventAttributesImpl.resetOriginalValues();

		return eventAttributesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		attributeNumber = objectInput.readUTF();
		attributeName = objectInput.readUTF();
		eventId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (attributeNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attributeNumber);
		}

		if (attributeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attributeName);
		}

		if (eventId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventId);
		}
	}

	public long id;
	public String attributeNumber;
	public String attributeName;
	public String eventId;

}