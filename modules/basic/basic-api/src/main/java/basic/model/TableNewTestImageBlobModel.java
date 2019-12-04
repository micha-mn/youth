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
 * The Blob model class for lazy loading the Image column in TableNewTest.
 *
 * @author Brian Wing Shun Chan
 * @see TableNewTest
 * @generated
 */
@ProviderType
public class TableNewTestImageBlobModel {

	public TableNewTestImageBlobModel() {
	}

	public TableNewTestImageBlobModel(long id) {
		_id = id;
	}

	public TableNewTestImageBlobModel(long id, Blob ImageBlob) {
		_id = id;
		_ImageBlob = ImageBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getImageBlob() {
		return _ImageBlob;
	}

	public void setImageBlob(Blob ImageBlob) {
		_ImageBlob = ImageBlob;
	}

	private long _id;
	private Blob _ImageBlob;

}