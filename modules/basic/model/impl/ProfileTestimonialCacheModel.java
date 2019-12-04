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

import basic.model.ProfileTestimonial;

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
 * The cache model class for representing ProfileTestimonial in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProfileTestimonialCacheModel
	implements CacheModel<ProfileTestimonial>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProfileTestimonialCacheModel)) {
			return false;
		}

		ProfileTestimonialCacheModel profileTestimonialCacheModel =
			(ProfileTestimonialCacheModel)obj;

		if (id == profileTestimonialCacheModel.id) {
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
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", testimonialprovidername=");
		sb.append(testimonialprovidername);
		sb.append(", testimonialprovideremail=");
		sb.append(testimonialprovideremail);
		sb.append(", testimonialprovorgname=");
		sb.append(testimonialprovorgname);
		sb.append(", testimonialprovidertitle=");
		sb.append(testimonialprovidertitle);
		sb.append(", testimonialprivatemessage=");
		sb.append(testimonialprivatemessage);
		sb.append(", imagePreview=");
		sb.append(imagePreview);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProfileTestimonial toEntityModel() {
		ProfileTestimonialImpl profileTestimonialImpl =
			new ProfileTestimonialImpl();

		if (uuid == null) {
			profileTestimonialImpl.setUuid("");
		}
		else {
			profileTestimonialImpl.setUuid(uuid);
		}

		profileTestimonialImpl.setId(id);
		profileTestimonialImpl.setGroupId(groupId);
		profileTestimonialImpl.setCompanyId(companyId);
		profileTestimonialImpl.setUserId(userId);

		if (userName == null) {
			profileTestimonialImpl.setUserName("");
		}
		else {
			profileTestimonialImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profileTestimonialImpl.setCreateDate(null);
		}
		else {
			profileTestimonialImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileTestimonialImpl.setModifiedDate(null);
		}
		else {
			profileTestimonialImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (testimonialprovidername == null) {
			profileTestimonialImpl.setTestimonialprovidername("");
		}
		else {
			profileTestimonialImpl.setTestimonialprovidername(
				testimonialprovidername);
		}

		if (testimonialprovideremail == null) {
			profileTestimonialImpl.setTestimonialprovideremail("");
		}
		else {
			profileTestimonialImpl.setTestimonialprovideremail(
				testimonialprovideremail);
		}

		if (testimonialprovorgname == null) {
			profileTestimonialImpl.setTestimonialprovorgname("");
		}
		else {
			profileTestimonialImpl.setTestimonialprovorgname(
				testimonialprovorgname);
		}

		if (testimonialprovidertitle == null) {
			profileTestimonialImpl.setTestimonialprovidertitle("");
		}
		else {
			profileTestimonialImpl.setTestimonialprovidertitle(
				testimonialprovidertitle);
		}

		if (testimonialprivatemessage == null) {
			profileTestimonialImpl.setTestimonialprivatemessage("");
		}
		else {
			profileTestimonialImpl.setTestimonialprivatemessage(
				testimonialprivatemessage);
		}

		if (imagePreview == null) {
			profileTestimonialImpl.setImagePreview("");
		}
		else {
			profileTestimonialImpl.setImagePreview(imagePreview);
		}

		profileTestimonialImpl.resetOriginalValues();

		return profileTestimonialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		testimonialprovidername = objectInput.readUTF();
		testimonialprovideremail = objectInput.readUTF();
		testimonialprovorgname = objectInput.readUTF();
		testimonialprovidertitle = objectInput.readUTF();
		testimonialprivatemessage = objectInput.readUTF();
		imagePreview = objectInput.readUTF();
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

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (testimonialprovidername == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testimonialprovidername);
		}

		if (testimonialprovideremail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testimonialprovideremail);
		}

		if (testimonialprovorgname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testimonialprovorgname);
		}

		if (testimonialprovidertitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testimonialprovidertitle);
		}

		if (testimonialprivatemessage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testimonialprivatemessage);
		}

		if (imagePreview == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imagePreview);
		}
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String testimonialprovidername;
	public String testimonialprovideremail;
	public String testimonialprovorgname;
	public String testimonialprovidertitle;
	public String testimonialprivatemessage;
	public String imagePreview;

}