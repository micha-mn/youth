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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link basic.service.http.ProfileTestimonialServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProfileTestimonialSoap implements Serializable {

	public static ProfileTestimonialSoap toSoapModel(ProfileTestimonial model) {
		ProfileTestimonialSoap soapModel = new ProfileTestimonialSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTestimonialprovidername(
			model.getTestimonialprovidername());
		soapModel.setTestimonialprovideremail(
			model.getTestimonialprovideremail());
		soapModel.setTestimonialprovorgname(model.getTestimonialprovorgname());
		soapModel.setTestimonialprovidertitle(
			model.getTestimonialprovidertitle());
		soapModel.setTestimonialprivatemessage(
			model.getTestimonialprivatemessage());
		soapModel.setImagePreview(model.getImagePreview());

		return soapModel;
	}

	public static ProfileTestimonialSoap[] toSoapModels(
		ProfileTestimonial[] models) {

		ProfileTestimonialSoap[] soapModels =
			new ProfileTestimonialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfileTestimonialSoap[][] toSoapModels(
		ProfileTestimonial[][] models) {

		ProfileTestimonialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProfileTestimonialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfileTestimonialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfileTestimonialSoap[] toSoapModels(
		List<ProfileTestimonial> models) {

		List<ProfileTestimonialSoap> soapModels =
			new ArrayList<ProfileTestimonialSoap>(models.size());

		for (ProfileTestimonial model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ProfileTestimonialSoap[soapModels.size()]);
	}

	public ProfileTestimonialSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTestimonialprovidername() {
		return _testimonialprovidername;
	}

	public void setTestimonialprovidername(String testimonialprovidername) {
		_testimonialprovidername = testimonialprovidername;
	}

	public String getTestimonialprovideremail() {
		return _testimonialprovideremail;
	}

	public void setTestimonialprovideremail(String testimonialprovideremail) {
		_testimonialprovideremail = testimonialprovideremail;
	}

	public String getTestimonialprovorgname() {
		return _testimonialprovorgname;
	}

	public void setTestimonialprovorgname(String testimonialprovorgname) {
		_testimonialprovorgname = testimonialprovorgname;
	}

	public String getTestimonialprovidertitle() {
		return _testimonialprovidertitle;
	}

	public void setTestimonialprovidertitle(String testimonialprovidertitle) {
		_testimonialprovidertitle = testimonialprovidertitle;
	}

	public String getTestimonialprivatemessage() {
		return _testimonialprivatemessage;
	}

	public void setTestimonialprivatemessage(String testimonialprivatemessage) {
		_testimonialprivatemessage = testimonialprivatemessage;
	}

	public String getImagePreview() {
		return _imagePreview;
	}

	public void setImagePreview(String imagePreview) {
		_imagePreview = imagePreview;
	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _testimonialprovidername;
	private String _testimonialprovideremail;
	private String _testimonialprovorgname;
	private String _testimonialprovidertitle;
	private String _testimonialprivatemessage;
	private String _imagePreview;

}