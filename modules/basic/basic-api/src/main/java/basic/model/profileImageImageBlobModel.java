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

import java.sql.Blob;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The Blob model class for lazy loading the image column in profileImage.
 *
 * @author Brian Wing Shun Chan
 * @see profileImage
 * @generated
 */
@ProviderType
public class profileImageImageBlobModel {

	public profileImageImageBlobModel() {
	}

	public profileImageImageBlobModel(long id) {
		_id = id;
	}

	public profileImageImageBlobModel(long id, Blob imageBlob) {
		_id = id;
		_imageBlob = imageBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getImageBlob() {
		return _imageBlob;
	}

	public void setImageBlob(Blob imageBlob) {
		_imageBlob = imageBlob;
	}

	private long _id;
	private Blob _imageBlob;

}