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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link formeventusertable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see formeventusertable
 * @generated
 */
@ProviderType
public class formeventusertableWrapper
	extends BaseModelWrapper<formeventusertable>
	implements formeventusertable, ModelWrapper<formeventusertable> {

	public formeventusertableWrapper(formeventusertable formeventusertable) {
		super(formeventusertable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ID", getID());
		attributes.put("userId", getUserId());
		attributes.put("eventId", getEventId());
		attributes.put("ddmFormInstanceId", getDdmFormInstanceId());
		attributes.put(
			"ddmFormInstanceRecordVersionId",
			getDdmFormInstanceRecordVersionId());
		attributes.put("statusCol", getStatusCol());
		attributes.put("formId", getFormId());
		attributes.put("reviewerUserId", getReviewerUserId());
		attributes.put("reviewerComments", getReviewerComments());
		attributes.put(
			"ddmFormInstanceRecordVersion", getDdmFormInstanceRecordVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ID = (Long)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String eventId = (String)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String ddmFormInstanceId = (String)attributes.get("ddmFormInstanceId");

		if (ddmFormInstanceId != null) {
			setDdmFormInstanceId(ddmFormInstanceId);
		}

		String ddmFormInstanceRecordVersionId = (String)attributes.get(
			"ddmFormInstanceRecordVersionId");

		if (ddmFormInstanceRecordVersionId != null) {
			setDdmFormInstanceRecordVersionId(ddmFormInstanceRecordVersionId);
		}

		String statusCol = (String)attributes.get("statusCol");

		if (statusCol != null) {
			setStatusCol(statusCol);
		}

		String formId = (String)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		String reviewerUserId = (String)attributes.get("reviewerUserId");

		if (reviewerUserId != null) {
			setReviewerUserId(reviewerUserId);
		}

		String reviewerComments = (String)attributes.get("reviewerComments");

		if (reviewerComments != null) {
			setReviewerComments(reviewerComments);
		}

		String ddmFormInstanceRecordVersion = (String)attributes.get(
			"ddmFormInstanceRecordVersion");

		if (ddmFormInstanceRecordVersion != null) {
			setDdmFormInstanceRecordVersion(ddmFormInstanceRecordVersion);
		}
	}

	/**
	 * Returns the ddm form instance ID of this formeventusertable.
	 *
	 * @return the ddm form instance ID of this formeventusertable
	 */
	@Override
	public String getDdmFormInstanceId() {
		return model.getDdmFormInstanceId();
	}

	/**
	 * Returns the ddm form instance record version of this formeventusertable.
	 *
	 * @return the ddm form instance record version of this formeventusertable
	 */
	@Override
	public String getDdmFormInstanceRecordVersion() {
		return model.getDdmFormInstanceRecordVersion();
	}

	/**
	 * Returns the ddm form instance record version ID of this formeventusertable.
	 *
	 * @return the ddm form instance record version ID of this formeventusertable
	 */
	@Override
	public String getDdmFormInstanceRecordVersionId() {
		return model.getDdmFormInstanceRecordVersionId();
	}

	/**
	 * Returns the event ID of this formeventusertable.
	 *
	 * @return the event ID of this formeventusertable
	 */
	@Override
	public String getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the form ID of this formeventusertable.
	 *
	 * @return the form ID of this formeventusertable
	 */
	@Override
	public String getFormId() {
		return model.getFormId();
	}

	/**
	 * Returns the ID of this formeventusertable.
	 *
	 * @return the ID of this formeventusertable
	 */
	@Override
	public long getID() {
		return model.getID();
	}

	/**
	 * Returns the primary key of this formeventusertable.
	 *
	 * @return the primary key of this formeventusertable
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reviewer comments of this formeventusertable.
	 *
	 * @return the reviewer comments of this formeventusertable
	 */
	@Override
	public String getReviewerComments() {
		return model.getReviewerComments();
	}

	/**
	 * Returns the reviewer user ID of this formeventusertable.
	 *
	 * @return the reviewer user ID of this formeventusertable
	 */
	@Override
	public String getReviewerUserId() {
		return model.getReviewerUserId();
	}

	/**
	 * Returns the status col of this formeventusertable.
	 *
	 * @return the status col of this formeventusertable
	 */
	@Override
	public String getStatusCol() {
		return model.getStatusCol();
	}

	/**
	 * Returns the user ID of this formeventusertable.
	 *
	 * @return the user ID of this formeventusertable
	 */
	@Override
	public String getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the uuid of this formeventusertable.
	 *
	 * @return the uuid of this formeventusertable
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ddm form instance ID of this formeventusertable.
	 *
	 * @param ddmFormInstanceId the ddm form instance ID of this formeventusertable
	 */
	@Override
	public void setDdmFormInstanceId(String ddmFormInstanceId) {
		model.setDdmFormInstanceId(ddmFormInstanceId);
	}

	/**
	 * Sets the ddm form instance record version of this formeventusertable.
	 *
	 * @param ddmFormInstanceRecordVersion the ddm form instance record version of this formeventusertable
	 */
	@Override
	public void setDdmFormInstanceRecordVersion(
		String ddmFormInstanceRecordVersion) {

		model.setDdmFormInstanceRecordVersion(ddmFormInstanceRecordVersion);
	}

	/**
	 * Sets the ddm form instance record version ID of this formeventusertable.
	 *
	 * @param ddmFormInstanceRecordVersionId the ddm form instance record version ID of this formeventusertable
	 */
	@Override
	public void setDdmFormInstanceRecordVersionId(
		String ddmFormInstanceRecordVersionId) {

		model.setDdmFormInstanceRecordVersionId(ddmFormInstanceRecordVersionId);
	}

	/**
	 * Sets the event ID of this formeventusertable.
	 *
	 * @param eventId the event ID of this formeventusertable
	 */
	@Override
	public void setEventId(String eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the form ID of this formeventusertable.
	 *
	 * @param formId the form ID of this formeventusertable
	 */
	@Override
	public void setFormId(String formId) {
		model.setFormId(formId);
	}

	/**
	 * Sets the ID of this formeventusertable.
	 *
	 * @param ID the ID of this formeventusertable
	 */
	@Override
	public void setID(long ID) {
		model.setID(ID);
	}

	/**
	 * Sets the primary key of this formeventusertable.
	 *
	 * @param primaryKey the primary key of this formeventusertable
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reviewer comments of this formeventusertable.
	 *
	 * @param reviewerComments the reviewer comments of this formeventusertable
	 */
	@Override
	public void setReviewerComments(String reviewerComments) {
		model.setReviewerComments(reviewerComments);
	}

	/**
	 * Sets the reviewer user ID of this formeventusertable.
	 *
	 * @param reviewerUserId the reviewer user ID of this formeventusertable
	 */
	@Override
	public void setReviewerUserId(String reviewerUserId) {
		model.setReviewerUserId(reviewerUserId);
	}

	/**
	 * Sets the status col of this formeventusertable.
	 *
	 * @param statusCol the status col of this formeventusertable
	 */
	@Override
	public void setStatusCol(String statusCol) {
		model.setStatusCol(statusCol);
	}

	/**
	 * Sets the user ID of this formeventusertable.
	 *
	 * @param userId the user ID of this formeventusertable
	 */
	@Override
	public void setUserId(String userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the uuid of this formeventusertable.
	 *
	 * @param uuid the uuid of this formeventusertable
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected formeventusertableWrapper wrap(
		formeventusertable formeventusertable) {

		return new formeventusertableWrapper(formeventusertable);
	}

}