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

import basic.model.Journey;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Journey in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class JourneyCacheModel implements CacheModel<Journey>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JourneyCacheModel)) {
			return false;
		}

		JourneyCacheModel journeyCacheModel = (JourneyCacheModel)obj;

		if (journeyId == journeyCacheModel.journeyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, journeyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{journeyId=");
		sb.append(journeyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);

		return sb.toString();
	}

	@Override
	public Journey toEntityModel() {
		JourneyImpl journeyImpl = new JourneyImpl();

		journeyImpl.setJourneyId(journeyId);

		if (userId == null) {
			journeyImpl.setUserId("");
		}
		else {
			journeyImpl.setUserId(userId);
		}

		if (title == null) {
			journeyImpl.setTitle("");
		}
		else {
			journeyImpl.setTitle(title);
		}

		if (description == null) {
			journeyImpl.setDescription("");
		}
		else {
			journeyImpl.setDescription(description);
		}

		journeyImpl.resetOriginalValues();

		return journeyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		journeyId = objectInput.readLong();
		userId = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(journeyId);

		if (userId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userId);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long journeyId;
	public String userId;
	public String title;
	public String description;

}