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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.profileLicensesCertificationsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileLicensesCertificationsSoap implements Serializable {

	public static profileLicensesCertificationsSoap toSoapModel(
		profileLicensesCertifications model) {

		profileLicensesCertificationsSoap soapModel =
			new profileLicensesCertificationsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProfileId(model.getProfileId());
		soapModel.setName(model.getName());
		soapModel.setIssuingOrganization(model.getIssuingOrganization());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setExpirationDate(model.getExpirationDate());
		soapModel.setCredentialID(model.getCredentialID());
		soapModel.setCredentialURL(model.getCredentialURL());
		soapModel.setNotExpire(model.isNotExpire());

		return soapModel;
	}

	public static profileLicensesCertificationsSoap[] toSoapModels(
		profileLicensesCertifications[] models) {

		profileLicensesCertificationsSoap[] soapModels =
			new profileLicensesCertificationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static profileLicensesCertificationsSoap[][] toSoapModels(
		profileLicensesCertifications[][] models) {

		profileLicensesCertificationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new profileLicensesCertificationsSoap
				[models.length][models[0].length];
		}
		else {
			soapModels = new profileLicensesCertificationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static profileLicensesCertificationsSoap[] toSoapModels(
		List<profileLicensesCertifications> models) {

		List<profileLicensesCertificationsSoap> soapModels =
			new ArrayList<profileLicensesCertificationsSoap>(models.size());

		for (profileLicensesCertifications model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new profileLicensesCertificationsSoap[soapModels.size()]);
	}

	public profileLicensesCertificationsSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getIssuingOrganization() {
		return _issuingOrganization;
	}

	public void setIssuingOrganization(String issuingOrganization) {
		_issuingOrganization = issuingOrganization;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public long getCredentialID() {
		return _credentialID;
	}

	public void setCredentialID(long credentialID) {
		_credentialID = credentialID;
	}

	public String getCredentialURL() {
		return _credentialURL;
	}

	public void setCredentialURL(String credentialURL) {
		_credentialURL = credentialURL;
	}

	public boolean getNotExpire() {
		return _notExpire;
	}

	public boolean isNotExpire() {
		return _notExpire;
	}

	public void setNotExpire(boolean notExpire) {
		_notExpire = notExpire;
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
	private String _name;
	private String _issuingOrganization;
	private Date _issueDate;
	private Date _expirationDate;
	private long _credentialID;
	private String _credentialURL;
	private boolean _notExpire;

}