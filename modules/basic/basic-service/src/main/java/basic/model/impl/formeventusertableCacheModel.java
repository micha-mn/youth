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

import basic.model.formeventusertable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing formeventusertable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class formeventusertableCacheModel
	implements CacheModel<formeventusertable>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof formeventusertableCacheModel)) {
			return false;
		}

		formeventusertableCacheModel formeventusertableCacheModel =
			(formeventusertableCacheModel)obj;

		if (ID == formeventusertableCacheModel.ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ID=");
		sb.append(ID);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", ddmFormInstanceId=");
		sb.append(ddmFormInstanceId);
		sb.append(", ddmFormInstanceRecordVersionId=");
		sb.append(ddmFormInstanceRecordVersionId);
		sb.append(", statusCol=");
		sb.append(statusCol);
		sb.append(", formId=");
		sb.append(formId);
		sb.append(", reviewerUserId=");
		sb.append(reviewerUserId);
		sb.append(", reviewerComments=");
		sb.append(reviewerComments);
		sb.append(", ddmFormInstanceRecordVersion=");
		sb.append(ddmFormInstanceRecordVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public formeventusertable toEntityModel() {
		formeventusertableImpl formeventusertableImpl =
			new formeventusertableImpl();

		if (uuid == null) {
			formeventusertableImpl.setUuid("");
		}
		else {
			formeventusertableImpl.setUuid(uuid);
		}

		formeventusertableImpl.setID(ID);

		if (userId == null) {
			formeventusertableImpl.setUserId("");
		}
		else {
			formeventusertableImpl.setUserId(userId);
		}

		if (eventId == null) {
			formeventusertableImpl.setEventId("");
		}
		else {
			formeventusertableImpl.setEventId(eventId);
		}

		if (ddmFormInstanceId == null) {
			formeventusertableImpl.setDdmFormInstanceId("");
		}
		else {
			formeventusertableImpl.setDdmFormInstanceId(ddmFormInstanceId);
		}

		if (ddmFormInstanceRecordVersionId == null) {
			formeventusertableImpl.setDdmFormInstanceRecordVersionId("");
		}
		else {
			formeventusertableImpl.setDdmFormInstanceRecordVersionId(
				ddmFormInstanceRecordVersionId);
		}

		if (statusCol == null) {
			formeventusertableImpl.setStatusCol("");
		}
		else {
			formeventusertableImpl.setStatusCol(statusCol);
		}

		if (formId == null) {
			formeventusertableImpl.setFormId("");
		}
		else {
			formeventusertableImpl.setFormId(formId);
		}

		if (reviewerUserId == null) {
			formeventusertableImpl.setReviewerUserId("");
		}
		else {
			formeventusertableImpl.setReviewerUserId(reviewerUserId);
		}

		if (reviewerComments == null) {
			formeventusertableImpl.setReviewerComments("");
		}
		else {
			formeventusertableImpl.setReviewerComments(reviewerComments);
		}

		if (ddmFormInstanceRecordVersion == null) {
			formeventusertableImpl.setDdmFormInstanceRecordVersion("");
		}
		else {
			formeventusertableImpl.setDdmFormInstanceRecordVersion(
				ddmFormInstanceRecordVersion);
		}

		formeventusertableImpl.resetOriginalValues();

		return formeventusertableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ID = objectInput.readLong();
		userId = objectInput.readUTF();
		eventId = objectInput.readUTF();
		ddmFormInstanceId = objectInput.readUTF();
		ddmFormInstanceRecordVersionId = objectInput.readUTF();
		statusCol = objectInput.readUTF();
		formId = objectInput.readUTF();
		reviewerUserId = objectInput.readUTF();
		reviewerComments = objectInput.readUTF();
		ddmFormInstanceRecordVersion = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ID);

		if (userId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userId);
		}

		if (eventId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventId);
		}

		if (ddmFormInstanceId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ddmFormInstanceId);
		}

		if (ddmFormInstanceRecordVersionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ddmFormInstanceRecordVersionId);
		}

		if (statusCol == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusCol);
		}

		if (formId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formId);
		}

		if (reviewerUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reviewerUserId);
		}

		if (reviewerComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reviewerComments);
		}

		if (ddmFormInstanceRecordVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ddmFormInstanceRecordVersion);
		}
	}

	public String uuid;

	public long ID;

	public String userId;
	public String eventId;
	public String ddmFormInstanceId;
	public String ddmFormInstanceRecordVersionId;
	public String statusCol;
	public String formId;
	public String reviewerUserId;
	public String reviewerComments;
	public String ddmFormInstanceRecordVersion;

}