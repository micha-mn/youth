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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.profileWorkExperienceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileWorkExperienceSoap implements Serializable {

	public static profileWorkExperienceSoap toSoapModel(
		profileWorkExperience model) {

		profileWorkExperienceSoap soapModel = new profileWorkExperienceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setTitle(model.getTitle());
		soapModel.setCompany(model.getCompany());
		soapModel.setLocation(model.getLocation());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setCurrentWorkStatus(model.getCurrentWorkStatus());
		soapModel.setWorkExperience(model.getWorkExperience());

		return soapModel;
	}

	public static profileWorkExperienceSoap[] toSoapModels(
		profileWorkExperience[] models) {

		profileWorkExperienceSoap[] soapModels =
			new profileWorkExperienceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static profileWorkExperienceSoap[][] toSoapModels(
		profileWorkExperience[][] models) {

		profileWorkExperienceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new profileWorkExperienceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new profileWorkExperienceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static profileWorkExperienceSoap[] toSoapModels(
		List<profileWorkExperience> models) {

		List<profileWorkExperienceSoap> soapModels =
			new ArrayList<profileWorkExperienceSoap>(models.size());

		for (profileWorkExperience model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new profileWorkExperienceSoap[soapModels.size()]);
	}

	public profileWorkExperienceSoap() {
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

	public long getProfileId() {
		return _profileId;
	}

	public void setProfileId(long profileId) {
		_profileId = profileId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getCurrentWorkStatus() {
		return _currentWorkStatus;
	}

	public void setCurrentWorkStatus(String currentWorkStatus) {
		_currentWorkStatus = currentWorkStatus;
	}

	public String getWorkExperience() {
		return _workExperience;
	}

	public void setWorkExperience(String workExperience) {
		_workExperience = workExperience;
	}

	private String _uuid;
	private long _Id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _profileId;
	private String _title;
	private String _company;
	private String _location;
	private Date _startDate;
	private Date _endDate;
	private String _description;
	private String _currentWorkStatus;
	private String _workExperience;

}