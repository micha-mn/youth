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
 * This class is used by SOAP remote services, specifically {@link basic.service.http.profileImageServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class profileImageSoap implements Serializable {

	public static profileImageSoap toSoapModel(profileImage model) {
		profileImageSoap soapModel = new profileImageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setUserId(model.getUserId());
		soapModel.setImage(model.getImage());

		return soapModel;
	}

	public static profileImageSoap[] toSoapModels(profileImage[] models) {
		profileImageSoap[] soapModels = new profileImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static profileImageSoap[][] toSoapModels(profileImage[][] models) {
		profileImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new profileImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new profileImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static profileImageSoap[] toSoapModels(List<profileImage> models) {
		List<profileImageSoap> soapModels = new ArrayList<profileImageSoap>(
			models.size());

		for (profileImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new profileImageSoap[soapModels.size()]);
	}

	public profileImageSoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Blob getImage() {
		return _image;
	}

	public void setImage(Blob image) {
		_image = image;
	}

	private String _uuid;
	private long _id;
	private long _userId;
	private Blob _image;

}