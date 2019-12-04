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
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link basic.service.http.formeventusertableServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class formeventusertableSoap implements Serializable {

	public static formeventusertableSoap toSoapModel(formeventusertable model) {
		formeventusertableSoap soapModel = new formeventusertableSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setID(model.getID());
		soapModel.setUserId(model.getUserId());
		soapModel.setEventId(model.getEventId());
		soapModel.setDdmFormInstanceId(model.getDdmFormInstanceId());
		soapModel.setDdmFormInstanceRecordVersionId(
			model.getDdmFormInstanceRecordVersionId());
		soapModel.setStatusCol(model.getStatusCol());
		soapModel.setFormId(model.getFormId());
		soapModel.setReviewerUserId(model.getReviewerUserId());
		soapModel.setReviewerComments(model.getReviewerComments());
		soapModel.setDdmFormInstanceRecordVersion(
			model.getDdmFormInstanceRecordVersion());

		return soapModel;
	}

	public static formeventusertableSoap[] toSoapModels(
		formeventusertable[] models) {

		formeventusertableSoap[] soapModels =
			new formeventusertableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static formeventusertableSoap[][] toSoapModels(
		formeventusertable[][] models) {

		formeventusertableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new formeventusertableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new formeventusertableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static formeventusertableSoap[] toSoapModels(
		List<formeventusertable> models) {

		List<formeventusertableSoap> soapModels =
			new ArrayList<formeventusertableSoap>(models.size());

		for (formeventusertable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new formeventusertableSoap[soapModels.size()]);
	}

	public formeventusertableSoap() {
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long pk) {
		setID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public String getEventId() {
		return _eventId;
	}

	public void setEventId(String eventId) {
		_eventId = eventId;
	}

	public String getDdmFormInstanceId() {
		return _ddmFormInstanceId;
	}

	public void setDdmFormInstanceId(String ddmFormInstanceId) {
		_ddmFormInstanceId = ddmFormInstanceId;
	}

	public String getDdmFormInstanceRecordVersionId() {
		return _ddmFormInstanceRecordVersionId;
	}

	public void setDdmFormInstanceRecordVersionId(
		String ddmFormInstanceRecordVersionId) {

		_ddmFormInstanceRecordVersionId = ddmFormInstanceRecordVersionId;
	}

	public String getStatusCol() {
		return _statusCol;
	}

	public void setStatusCol(String statusCol) {
		_statusCol = statusCol;
	}

	public String getFormId() {
		return _formId;
	}

	public void setFormId(String formId) {
		_formId = formId;
	}

	public String getReviewerUserId() {
		return _reviewerUserId;
	}

	public void setReviewerUserId(String reviewerUserId) {
		_reviewerUserId = reviewerUserId;
	}

	public String getReviewerComments() {
		return _reviewerComments;
	}

	public void setReviewerComments(String reviewerComments) {
		_reviewerComments = reviewerComments;
	}

	public String getDdmFormInstanceRecordVersion() {
		return _ddmFormInstanceRecordVersion;
	}

	public void setDdmFormInstanceRecordVersion(
		String ddmFormInstanceRecordVersion) {

		_ddmFormInstanceRecordVersion = ddmFormInstanceRecordVersion;
	}

	private String _uuid;

	private long _ID;

	private String _userId;
	private String _eventId;
	private String _ddmFormInstanceId;
	private String _ddmFormInstanceRecordVersionId;
	private String _statusCol;
	private String _formId;
	private String _reviewerUserId;
	private String _reviewerComments;
	private String _ddmFormInstanceRecordVersion;

}