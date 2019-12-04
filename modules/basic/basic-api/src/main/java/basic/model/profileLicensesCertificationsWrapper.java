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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link profileLicensesCertifications}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileLicensesCertifications
 * @generated
 */
@ProviderType
public class profileLicensesCertificationsWrapper
	extends BaseModelWrapper<profileLicensesCertifications>
	implements profileLicensesCertifications,
			   ModelWrapper<profileLicensesCertifications> {

	public profileLicensesCertificationsWrapper(
		profileLicensesCertifications profileLicensesCertifications) {

		super(profileLicensesCertifications);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("profileId", getProfileId());
		attributes.put("name", getName());
		attributes.put("issuingOrganization", getIssuingOrganization());
		attributes.put("issueDate", getIssueDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("credentialID", getCredentialID());
		attributes.put("credentialURL", getCredentialURL());
		attributes.put("notExpire", isNotExpire());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long profileId = (Long)attributes.get("profileId");

		if (profileId != null) {
			setProfileId(profileId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String issuingOrganization = (String)attributes.get(
			"issuingOrganization");

		if (issuingOrganization != null) {
			setIssuingOrganization(issuingOrganization);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Long credentialID = (Long)attributes.get("credentialID");

		if (credentialID != null) {
			setCredentialID(credentialID);
		}

		String credentialURL = (String)attributes.get("credentialURL");

		if (credentialURL != null) {
			setCredentialURL(credentialURL);
		}

		Boolean notExpire = (Boolean)attributes.get("notExpire");

		if (notExpire != null) {
			setNotExpire(notExpire);
		}
	}

	/**
	 * Returns the company ID of this profile licenses certifications.
	 *
	 * @return the company ID of this profile licenses certifications
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this profile licenses certifications.
	 *
	 * @return the create date of this profile licenses certifications
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the credential ID of this profile licenses certifications.
	 *
	 * @return the credential ID of this profile licenses certifications
	 */
	@Override
	public long getCredentialID() {
		return model.getCredentialID();
	}

	/**
	 * Returns the credential url of this profile licenses certifications.
	 *
	 * @return the credential url of this profile licenses certifications
	 */
	@Override
	public String getCredentialURL() {
		return model.getCredentialURL();
	}

	/**
	 * Returns the expiration date of this profile licenses certifications.
	 *
	 * @return the expiration date of this profile licenses certifications
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the group ID of this profile licenses certifications.
	 *
	 * @return the group ID of this profile licenses certifications
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this profile licenses certifications.
	 *
	 * @return the ID of this profile licenses certifications
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the issue date of this profile licenses certifications.
	 *
	 * @return the issue date of this profile licenses certifications
	 */
	@Override
	public Date getIssueDate() {
		return model.getIssueDate();
	}

	/**
	 * Returns the issuing organization of this profile licenses certifications.
	 *
	 * @return the issuing organization of this profile licenses certifications
	 */
	@Override
	public String getIssuingOrganization() {
		return model.getIssuingOrganization();
	}

	/**
	 * Returns the modified date of this profile licenses certifications.
	 *
	 * @return the modified date of this profile licenses certifications
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this profile licenses certifications.
	 *
	 * @return the name of this profile licenses certifications
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the not expire of this profile licenses certifications.
	 *
	 * @return the not expire of this profile licenses certifications
	 */
	@Override
	public boolean getNotExpire() {
		return model.getNotExpire();
	}

	/**
	 * Returns the primary key of this profile licenses certifications.
	 *
	 * @return the primary key of this profile licenses certifications
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile ID of this profile licenses certifications.
	 *
	 * @return the profile ID of this profile licenses certifications
	 */
	@Override
	public long getProfileId() {
		return model.getProfileId();
	}

	/**
	 * Returns the user ID of this profile licenses certifications.
	 *
	 * @return the user ID of this profile licenses certifications
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this profile licenses certifications.
	 *
	 * @return the user name of this profile licenses certifications
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this profile licenses certifications.
	 *
	 * @return the user uuid of this profile licenses certifications
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this profile licenses certifications.
	 *
	 * @return the uuid of this profile licenses certifications
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this profile licenses certifications is not expire.
	 *
	 * @return <code>true</code> if this profile licenses certifications is not expire; <code>false</code> otherwise
	 */
	@Override
	public boolean isNotExpire() {
		return model.isNotExpire();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this profile licenses certifications.
	 *
	 * @param companyId the company ID of this profile licenses certifications
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this profile licenses certifications.
	 *
	 * @param createDate the create date of this profile licenses certifications
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the credential ID of this profile licenses certifications.
	 *
	 * @param credentialID the credential ID of this profile licenses certifications
	 */
	@Override
	public void setCredentialID(long credentialID) {
		model.setCredentialID(credentialID);
	}

	/**
	 * Sets the credential url of this profile licenses certifications.
	 *
	 * @param credentialURL the credential url of this profile licenses certifications
	 */
	@Override
	public void setCredentialURL(String credentialURL) {
		model.setCredentialURL(credentialURL);
	}

	/**
	 * Sets the expiration date of this profile licenses certifications.
	 *
	 * @param expirationDate the expiration date of this profile licenses certifications
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the group ID of this profile licenses certifications.
	 *
	 * @param groupId the group ID of this profile licenses certifications
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this profile licenses certifications.
	 *
	 * @param Id the ID of this profile licenses certifications
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the issue date of this profile licenses certifications.
	 *
	 * @param issueDate the issue date of this profile licenses certifications
	 */
	@Override
	public void setIssueDate(Date issueDate) {
		model.setIssueDate(issueDate);
	}

	/**
	 * Sets the issuing organization of this profile licenses certifications.
	 *
	 * @param issuingOrganization the issuing organization of this profile licenses certifications
	 */
	@Override
	public void setIssuingOrganization(String issuingOrganization) {
		model.setIssuingOrganization(issuingOrganization);
	}

	/**
	 * Sets the modified date of this profile licenses certifications.
	 *
	 * @param modifiedDate the modified date of this profile licenses certifications
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this profile licenses certifications.
	 *
	 * @param name the name of this profile licenses certifications
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets whether this profile licenses certifications is not expire.
	 *
	 * @param notExpire the not expire of this profile licenses certifications
	 */
	@Override
	public void setNotExpire(boolean notExpire) {
		model.setNotExpire(notExpire);
	}

	/**
	 * Sets the primary key of this profile licenses certifications.
	 *
	 * @param primaryKey the primary key of this profile licenses certifications
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile ID of this profile licenses certifications.
	 *
	 * @param profileId the profile ID of this profile licenses certifications
	 */
	@Override
	public void setProfileId(long profileId) {
		model.setProfileId(profileId);
	}

	/**
	 * Sets the user ID of this profile licenses certifications.
	 *
	 * @param userId the user ID of this profile licenses certifications
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this profile licenses certifications.
	 *
	 * @param userName the user name of this profile licenses certifications
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this profile licenses certifications.
	 *
	 * @param userUuid the user uuid of this profile licenses certifications
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this profile licenses certifications.
	 *
	 * @param uuid the uuid of this profile licenses certifications
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected profileLicensesCertificationsWrapper wrap(
		profileLicensesCertifications profileLicensesCertifications) {

		return new profileLicensesCertificationsWrapper(
			profileLicensesCertifications);
	}

}