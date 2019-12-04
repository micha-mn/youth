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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class JourneySoap implements Serializable {

	public static JourneySoap toSoapModel(Journey model) {
		JourneySoap soapModel = new JourneySoap();

		soapModel.setJourneyId(model.getJourneyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setPictureBlob(model.getPictureBlob());

		return soapModel;
	}

	public static JourneySoap[] toSoapModels(Journey[] models) {
		JourneySoap[] soapModels = new JourneySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JourneySoap[][] toSoapModels(Journey[][] models) {
		JourneySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JourneySoap[models.length][models[0].length];
		}
		else {
			soapModels = new JourneySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JourneySoap[] toSoapModels(List<Journey> models) {
		List<JourneySoap> soapModels = new ArrayList<JourneySoap>(
			models.size());

		for (Journey model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JourneySoap[soapModels.size()]);
	}

	public JourneySoap() {
	}

	public long getPrimaryKey() {
		return _journeyId;
	}

	public void setPrimaryKey(long pk) {
		setJourneyId(pk);
	}

	public long getJourneyId() {
		return _journeyId;
	}

	public void setJourneyId(long journeyId) {
		_journeyId = journeyId;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Blob getPictureBlob() {
		return _pictureBlob;
	}

	public void setPictureBlob(Blob pictureBlob) {
		_pictureBlob = pictureBlob;
	}

	private long _journeyId;
	private String _userId;
	private String _title;
	private String _description;
	private Blob _pictureBlob;

}