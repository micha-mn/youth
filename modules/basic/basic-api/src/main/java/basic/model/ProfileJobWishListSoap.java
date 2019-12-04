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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.ProfileJobWishListServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProfileJobWishListSoap implements Serializable {

	public static ProfileJobWishListSoap toSoapModel(ProfileJobWishList model) {
		ProfileJobWishListSoap soapModel = new ProfileJobWishListSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setJobwishlist(model.getJobwishlist());

		return soapModel;
	}

	public static ProfileJobWishListSoap[] toSoapModels(
		ProfileJobWishList[] models) {

		ProfileJobWishListSoap[] soapModels =
			new ProfileJobWishListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfileJobWishListSoap[][] toSoapModels(
		ProfileJobWishList[][] models) {

		ProfileJobWishListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProfileJobWishListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfileJobWishListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfileJobWishListSoap[] toSoapModels(
		List<ProfileJobWishList> models) {

		List<ProfileJobWishListSoap> soapModels =
			new ArrayList<ProfileJobWishListSoap>(models.size());

		for (ProfileJobWishList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ProfileJobWishListSoap[soapModels.size()]);
	}

	public ProfileJobWishListSoap() {
	}

	public long getPrimaryKey() {
		return _Id;
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
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
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

	public String getJobwishlist() {
		return _jobwishlist;
	}

	public void setJobwishlist(String jobwishlist) {
		_jobwishlist = jobwishlist;
	}

	private String _uuid;
	private long _Id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _jobwishlist;

}