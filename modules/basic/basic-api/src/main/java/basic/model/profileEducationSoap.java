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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.profileEducationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileEducationSoap implements Serializable {

	public static profileEducationSoap toSoapModel(profileEducation model) {
		profileEducationSoap soapModel = new profileEducationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setEducationCategory(model.getEducationCategory());
		soapModel.setDegree(model.getDegree());
		soapModel.setFieldOfStudy(model.getFieldOfStudy());
		soapModel.setStartYear(model.getStartYear());
		soapModel.setEndYear(model.getEndYear());
		soapModel.setGrade(model.getGrade());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static profileEducationSoap[] toSoapModels(
		profileEducation[] models) {

		profileEducationSoap[] soapModels =
			new profileEducationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static profileEducationSoap[][] toSoapModels(
		profileEducation[][] models) {

		profileEducationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new profileEducationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new profileEducationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static profileEducationSoap[] toSoapModels(
		List<profileEducation> models) {

		List<profileEducationSoap> soapModels =
			new ArrayList<profileEducationSoap>(models.size());

		for (profileEducation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new profileEducationSoap[soapModels.size()]);
	}

	public profileEducationSoap() {
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

	public String getEducationCategory() {
		return _educationCategory;
	}

	public void setEducationCategory(String educationCategory) {
		_educationCategory = educationCategory;
	}

	public String getDegree() {
		return _degree;
	}

	public void setDegree(String degree) {
		_degree = degree;
	}

	public String getFieldOfStudy() {
		return _fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		_fieldOfStudy = fieldOfStudy;
	}

	public String getStartYear() {
		return _startYear;
	}

	public void setStartYear(String startYear) {
		_startYear = startYear;
	}

	public String getEndYear() {
		return _endYear;
	}

	public void setEndYear(String endYear) {
		_endYear = endYear;
	}

	public String getGrade() {
		return _grade;
	}

	public void setGrade(String grade) {
		_grade = grade;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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
	private String _educationCategory;
	private String _degree;
	private String _fieldOfStudy;
	private String _startYear;
	private String _endYear;
	private String _grade;
	private String _description;

}